<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/common/tree.js"></script>
    <script type="text/javascript" src="${ctx}/js/system/privilege.js"></script>
  </head>
  
  <body>
    <my:navigation text="权限管理 >> 角色授权" percent="90"/>    
      <table width="680" align="center" style="margin-top:10px" class="inputTable">
        <tr>
          <th>选择角色：</th>
          <td>
            <select id="role" class="text">
              <c:forEach items="${roleList}" var="role">
                <option value="${role.roleId}">${role.roleName}</option>
              </c:forEach>
            </select>
          </td>
          <td width="80">          
              <input type="button" class="btn ok" value="保存设置" onclick="savePriv();"/>
          </td>
        </tr>        
      </table>
      <table border="0" width="680" align="center" class="table" style="margin-top:10px">
        <tr><td style="background-color:#fcfcfc;text-align:left;vertical-align:top;padding-left:10px" id="treeContainer">
          
        </td></tr>
      </table>
  </body>
</html>
