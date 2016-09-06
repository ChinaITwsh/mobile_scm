<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysUsers"%>

<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    
  </head>
  
  <body>
    <my:navigation text="系统管理 >>　修改密码" percent="90"/>
    <form action="accManage_modifyPasswd.do" method="post" onsubmit="">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>原密码：</th>
          <td><input class="text" type="password" name="oldPass"/><my:errInfo key="oldPassErr" /></td>
        </tr>
        <tr>
          <th>新密码：</th>
          <td><input class="text" type="password" name="newPass"/></td>
        </tr>
        <tr>
          <th>确认新密码：</th>
          <td><input class="text" type="password" name="reNewPass"/></td>
        </tr>
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
        </td></tr>
      </table>
    </form>    
  </body>
</html>
