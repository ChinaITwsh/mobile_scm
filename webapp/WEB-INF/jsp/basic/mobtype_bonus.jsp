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
    <my:navigation text="基础设置 >>　手机型号管理 >> 返利价格" percent="90"/>    
      <br>
    <table class="table" width="90%" align="center" >
      <tr>       
        <th>返利类别</th>        
        <th>价格</th>
      </tr>
      <c:forEach items="${mobBonusList}" var="bonus">
        <tr>          
          <td>${bonus.typeName}</td>          
          <td><fmt:formatNumber value="${bonus.money}" pattern="0.00" /></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
