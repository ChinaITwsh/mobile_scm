<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript">
    
      if (top.location == location) {       
      
        window.opener=null;
        window.open('','_self','');
        window.close();
      } else {
        top.location = location;
      }
            
    </script>
  </head>
  
  <body>
       
      <table width="500" align="center" style="margin-top:120px" class="inputTable">
        <tr>
          <th style="font-weight:bold">系统已关闭</th>          
        </tr>
        <tr>
          <td style="height:100px">系统已安全退出，请关闭浏览器！</td>
        </tr>
      </table>
     
  </body>
</html>
