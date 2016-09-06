package net.beifeng.mobile_scm.web;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.system.entity.SysLog;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.utils.DoLog;
import net.beifeng.mobile_scm.utils.StringUtils;

import org.apache.struts2.StrutsStatics;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.AnnotationUtils;

public class LogInteceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 2107215991378362497L;

    @SuppressWarnings("unchecked")
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        String methodName = invocation.getProxy().getMethod();
        Collection<Method> methods = AnnotationUtils.getAnnotatedMethods(
                invocation.getAction().getClass(), DoLog.class);
        if (methods != null && methods.size() > 0) {
            Iterator<Method> methodIterator = methods.iterator();
            while (methodIterator.hasNext()) {
                Method method = methodIterator.next();
                if (methodName.equals(method.getName())) {
                    DoLog doLog = method.getAnnotation(DoLog.class);
                    if (doLog.value() == false) {
                        return invocation.invoke();
                    }
                }
            }
        }

        SysLog log = new SysLog();
        log.setId(StringUtils.uniqueKey());
        log.setOperTime(new Date());

        HttpServletRequest request = (HttpServletRequest) invocation
                .getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
        String uri = request.getRequestURI();
        String ctx = (String) invocation.getInvocationContext()
                .getApplication().get("ctx");
        String action = null;
        if (ctx != null) {
            if (ctx == "/") {
                action = uri.substring(1);
            } else {
                action = uri.substring(ctx.length() + 1);
            }
        }

        log.setActionName(action);

        SysUsers user = (SysUsers) invocation.getInvocationContext()
                .getSession().get("loginUser");
        if (user != null) {
            log.setAccount(user.getAccount());
        }

        Enumeration<String> paraNames = request.getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (paraNames.hasMoreElements()) {

            String paraName = paraNames.nextElement();
            String[] vals = request.getParameterValues(paraName);

            sb.append(paraName).append(":");
            for (int i = 0; i < vals.length; i++) {
                sb.append(vals[i]).append(",");
            }
            sb.append("; ");
        }

        log.setParameter(sb.toString());

        ApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext((ServletContext) invocation
                        .getInvocationContext().get(
                                StrutsStatics.SERVLET_CONTEXT));
        CommonDao dao = (CommonDao) applicationContext.getBean("dao");

        dao.addObj("log.addLog", log);

        return invocation.invoke();
    }

}
