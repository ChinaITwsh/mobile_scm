package net.beifeng.mobile_scm.web;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NavigateTag extends SimpleTagSupport {

    private int percent = 100;
    private int width = 1000;
    private String text;
    private String widthType = "percent";

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWidth(int width) {
        this.widthType = "width";
        this.width = width;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String tableWidth = this.widthType.equals("percent") ? (percent + "%")
                : width + "";
        out.print("<table width='" + tableWidth
                + "' border='0' cellspacing='0'"
                + " cellpadding='0' align='center'><tr>");
        out.print("<td class='navTd1'></td>");
        out.print("<td class='navTd2'>" + text + "</td>");
        out.print("<td class='navTd3'></td></tr></table>");
    }

}
