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
    <my:navigation text="手机库存 >>　汇总信息" percent="90"/>
    
    <table class="table" rowNum="15" width="500" align="center" >
      <tr>
        <th>机型编号</th>
        <th>总数量</th>
        <th>平均入库价</th>
        <th>平均成本价</th>
        <th>平均报损金额</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${countList}" var="c">
        <tr>
          <td>${c.mobtypeid}</td>
          <td>${c.amount}</td>
          <td>${c.buyprice}</td>
          <td>${c.cost}</td>
          <td>${c.lossamount}</td>
          <td><a href="stoView_showDetail.do?mobtypeid=${c.mobtypeid}">明细</a>          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
