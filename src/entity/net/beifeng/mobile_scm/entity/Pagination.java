package net.beifeng.mobile_scm.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public class Pagination implements Serializable {

    private static final long serialVersionUID = 8719855803676768829L;
    private int pageIndex;
    private int pageSize;
    private int totalRecordCnt;
    private List dataList;
    private String url;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecordCnt() {
        return totalRecordCnt;
    }

    public void setTotalRecordCnt(int totalRecordCnt) {
        this.totalRecordCnt = totalRecordCnt;
    }

    public int getTotalPageCnt() {
        return (totalRecordCnt + pageSize - 1) / pageSize;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public String getNaviHtml() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("<table width='100%' align='center' border=0><tr><td align='center'>");
        // 页数显示
        sb.append("第  ").append(pageIndex).append(" 页 / 共 ").append(
                getTotalPageCnt()).append(" 页 &nbsp;&nbsp;");

        if (pageIndex <= 1) {
            sb.append(genBtn("首页", null));
            sb.append(genBtn("上一页", null));
        } else {
            sb.append(genBtn("首页", 1));
            sb.append(genBtn("上一页", pageIndex - 1));
        }

        if (pageIndex >= getTotalPageCnt()) {
            sb.append(genBtn("下一页", null));
            sb.append(genBtn("尾页", null));
        } else {
            sb.append(genBtn("下一页", pageIndex + 1));
            sb.append(genBtn("尾页", getTotalPageCnt()));
        }

        sb
                .append(" <input type='text' class='text' style='width:30px' id='newPageIndex'/> ");
        sb
                .append(" <input type='button' class='btn default' style='width:20px' value=GO onclick='");
        sb
                .append("var oPN = document.getElementById(\"newPageIndex\");var pnVal=parseInt(oPN.value);");
        sb.append("if (isNaN(pnVal) || pnVal < 1 || pnVal > ").append(
                getTotalPageCnt()).append("){alert(\"请输入正确的页数!\");oPN.value=\"\";}");
        sb.append("else {location=\"").append(url).append("pageIndex=").append("\" + pnVal}");
        sb.append("'/>");

        sb.append(" 总记录数：").append(totalRecordCnt);
        sb.append("</td></tr></table>");
        return sb.toString();
    }

    private String genBtn(String btnVal, Integer pageIndex) {
        StringBuilder sb = new StringBuilder();
        sb
                .append(
                        " <input type=button class='btn default' style='width:60px' value=")
                .append(btnVal).append(" ");

        if (pageIndex == null) {
            sb.append(" disabled ");
        } else {
            sb.append(" onclick='location=\"").append(url).append("pageIndex=")
                    .append(pageIndex).append("\"'");

        }
        sb.append("/> ");
        return sb.toString();
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
