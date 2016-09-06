package net.beifeng.mobile_scm.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

@SuppressWarnings("unchecked")
public class MultiCheckTag extends SimpleTagSupport {

    private Object curVal;
    private Object list;
    private Object compare;
    private String text = "checked";

    public void setCurVal(Object curVal) {
        this.curVal = curVal;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCompare(Object compare) {
        this.compare = compare;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (list != null) {
            if (list instanceof Collection) {// 如果为集合类型

                Collection tmp = null;
                try {
                    tmp = (Collection) list;
                } catch (ClassCastException cce) {
                    throw new JspException("list对象的类型无效,必须为数组或collection类型元素",
                            cce);
                }
                Iterator it = tmp.iterator();
                while (it.hasNext()) {
                    Object o = it.next();
                    if (curVal.equals(o)) {
                        getJspContext().getOut().print(" " + text + " ");
                        return;
                    }
                }
            } else { // 否则按数组处理
                Object[] tmp = null;
                try {
                    tmp = (Object[]) list;
                } catch (ClassCastException cce) {
                    throw new JspException("list对象的类型无效,必须为数组或collection类型元素",
                            cce);
                }
                for (int i = 0; i < tmp.length; i++) {
                    if (curVal.equals(tmp[i])) {
                        getJspContext().getOut().print(" " + text + " ");
                        return;
                    }
                }

            }
        } else if (compare != null) {
            if (curVal.equals(compare)) {
                getJspContext().getOut().print(" " + text + " ");
            }
        }
    }
}
