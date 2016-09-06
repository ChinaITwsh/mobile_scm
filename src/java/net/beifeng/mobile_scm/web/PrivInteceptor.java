package net.beifeng.mobile_scm.web;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Invocation;
import org.apache.struts2.StrutsStatics;
import org.omg.CORBA.PRIVATE_MEMBER;

import net.beifeng.mobile_scm.entity.Message;
import net.beifeng.mobile_scm.system.entity.SysUsers;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivInteceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        // 用户是否登录
        Map session = invocation.getInvocationContext().getSession();
        SysUsers loginUser = (SysUsers) session.get("loginUser");

        if (loginUser == null) { // 返回登录页
            return "login";
        }

        // 当前ACTION是否在有权限的列表之中
        Set<String> actionList = (Set<String>) session.get("actionList");

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

        if (actionList != null && actionList.contains(action)) {
            return invocation.invoke();
        } else {
            Message mess = new Message();
            mess.setTitle("没有权限");
            mess.setContent("您没有执行这项操作的权限!");
            invocation.getInvocationContext().getValueStack().set("mess", mess);
            return "message";
        }
    }

}
