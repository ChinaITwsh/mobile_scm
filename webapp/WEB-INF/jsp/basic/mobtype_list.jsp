<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
  </head>
 
  <body>
    <my:navigation text="基础设置 >>　手机型号管理 >> 型号列表" percent="90"/>
    <form action="mobType_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>品牌:</td>
          <td>
            <select class="text" name="mobType.brand">
                <option value="">--全部类别--</option>
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand}"
                        <c:if test="${mobType.brand eq brand}">selected</c:if>
                    >${brand}</option>
                </c:forEach>
            </select>
          </td>
          <td>型号名</td>
          <td><input class="text" name="mobType.mobtypename" value="${mobType.mobtypename}"/></td>
          <td align="right">   
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加型号"
             onclick="location='mobType_toAdd.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>型号编号</th>
        <th>品牌</th>
        <th>型号名</th>
        <th>进货价</th>        
        <th>返利价格</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="mtype">
        <tr>
          <td>${mtype.mobtypeid}</td>
          <td>${mtype.brand}</td>
          <td>${mtype.mobtypename}</td>
          <td><fmt:formatNumber value="${mtype.buyprice}" pattern="#,##0.00" /></td>
          <td><a href="#" onclick="showModalDialog('mobType_viewBonus.do?mobType.mobtypeid=${mtype.mobtypeid}&ts=' + new Date().getTime(),null, 'dialogHeight: 350px; dialogWidth: 500px;center: yes; help: no;resizable: no; status: no;');return false;">查看返利价格</a></td>        
          <td>${mtype.remark}</td>
          <td>          
              <a href="${ctx}/mobType_toEdit.do?mobType.mobtypeid=${mtype.mobtypeid}">编辑</a>
              <a href="${ctx}/mobType_delType.do?mobType.mobtypeid=${mtype.mobtypeid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
