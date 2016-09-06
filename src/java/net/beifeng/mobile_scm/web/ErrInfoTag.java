package net.beifeng.mobile_scm.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ErrInfoTag extends TagSupport {

    private static final long serialVersionUID = -6965422265190706575L;

    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int doStartTag() throws JspException {
        Map<String, String> errMap = (Map<String, String>) this.pageContext
                .getRequest().getAttribute("errMap");
        if (errMap != null) {
            String errMess = errMap.get(key);
            if (errMess != null) {
                try {
                    this.pageContext.getOut().print(
                            "<span style='color:red'>" + errMess + "</span>");
                } catch (IOException e) {
                    throw new JspException(e);
                }
            }
        }
        return SKIP_BODY;
    }

}
