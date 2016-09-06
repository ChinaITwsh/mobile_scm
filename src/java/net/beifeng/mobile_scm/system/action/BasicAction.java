package net.beifeng.mobile_scm.system.action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.entity.Message;
import net.beifeng.mobile_scm.entity.Pagination;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport implements ServletResponseAware,
        ServletRequestAware, ServletContextAware {

    private static final long serialVersionUID = -7493241864514155959L;

    private final int PAGESIZE = 15;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext application;
    protected Map<String, Object> session = ActionContext.getContext()
            .getSession();

    protected Message mess;
    protected Map<String, String> errMap = new HashMap<String, String>();

    protected Integer pageIndex;
    protected Pagination pagination;

    protected CommonDao dao;

    protected void paginatedQuery(String sqlId) throws Exception {

        pagination = new Pagination();
        pagination.setPageIndex(pageIndex == null ? 1 : pageIndex);
        pagination.setPageSize(PAGESIZE);

        Map paraMap = getParaMap();

        int totalRecordCnt = dao.getTotalRecordCnt(sqlId, paraMap);
        pagination.setTotalRecordCnt(totalRecordCnt);
        int skip = (pagination.getPageIndex() - 1) * PAGESIZE;

        List dataList = dao.queryPaginatedList(sqlId, paraMap, skip, PAGESIZE);
        pagination.setDataList(dataList);
        pagination.setUrl(genURL());
    }

    @SuppressWarnings("unchecked")
    private Map getParaMap() {

        Map map = new HashMap();

        Method[] methods = this.getClass().getMethods();

        for (Method m : methods) {
            String methodName = m.getName();
            if (methodName.startsWith("set")) {
                String fieldName = methodName.substring(3, 4).toLowerCase()
                        + methodName.substring(4);
                try {
                    Field f = this.getClass().getDeclaredField(fieldName);
                    f.setAccessible(true);
                    map.put(f.getName(), f.get(this));
                } catch (Exception e) {
                }
            }
        }
        return map;
    }

    private String genURL() throws UnsupportedEncodingException {
        // /mobile_scm/log_listLog?beginDate=xxx&endDate=xxx&pageIndex=xxx
        StringBuilder sb = new StringBuilder(request.getRequestURI());
        sb.append("?");
        Enumeration<String> paraNames = request.getParameterNames();
        while (paraNames.hasMoreElements()) {
            String paraName = paraNames.nextElement();
            if (!"pageIndex".equals(paraName)) {
                sb.append(paraName).append("=");
                sb.append(
                        URLEncoder.encode(request.getParameter(paraName),
                                "utf-8")).append("&");
            }
        }
        return sb.toString();
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletContext(ServletContext application) {
        this.application = application;
    }

    public Message getMess() {
        return mess;
    }

    public Map<String, String> getErrMap() {
        return errMap;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
