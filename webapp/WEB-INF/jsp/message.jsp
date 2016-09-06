<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/basic/dept.js"></script>
  </head>
  
  <body>
    <my:navigation text="系统信息 - ${mess.title}" percent="90"/>
    
      <table width="500" align="center" style="margin-top:80px" class="inputTable">
        <tr>
          <th style="font-weight:bold">${mess.title}</th>          
        </tr>
        <tr>
          <td style="height:100px">${mess.content}</td>
        </tr>
      </table>
      <c:if test="${not empty mess.link}">
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="button" class="btn ok" style="width:80px" value=" 确 定 " onclick="location.href='${mess.link}'"/>
        </td></tr>
      </table>
      </c:if>
  </body>
</html>
