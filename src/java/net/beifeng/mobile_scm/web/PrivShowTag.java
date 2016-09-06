package net.beifeng.mobile_scm.web;

import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PrivShowTag extends TagSupport {

    private String action;

    public void setAction(String action) {
        this.action = action;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int doStartTag() throws JspException {
        if (action != null) {
            Set<String> actionList = (Set<String>) this.pageContext
                    .getSession().getAttribute("actionList");
            if (actionList.contains(action)) {
                return EVAL_BODY_INCLUDE;
            } else {
                return SKIP_BODY;
            }
        }
        return super.doStartTag();
    }

}
