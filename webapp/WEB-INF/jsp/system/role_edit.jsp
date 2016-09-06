<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysRole"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/system/role.js"></script>
  </head>
  
  <body>
    <my:navigation text="系统管理 >>　角色管理 >> 编辑角色" percent="90"/>
    <form action="roleManage_editRole.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>角色名称：</th>
          <td>
            <input class="text" name="role.roleName" value="${role.roleName}"/>
            <input type="hidden" name="role.roleId" value="${role.roleId}"/>
          </td>
        </tr>
        <tr>
          <th>角色说明：</th>
          <td><textarea class="text" name="role.remark" style="width:300px;height:46px"/>${role.remark}</textarea></td>
        </tr>
        <tr>
          <th>状态：</th>
          <td>
            <input type="radio" name="role.status" value="<%=SysRole.ROLESTAT_ENABLE%>"
              <my:checked curVal="<%=SysRole.ROLESTAT_ENABLE%>" compare="${role.status}"/>
            />启用
            <input type="radio" name="role.status" value="<%=SysRole.ROLESTAT_DISABLE%>"
              <my:checked curVal="<%=SysRole.ROLESTAT_DISABLE%>"  compare="${role.status}" />
            />禁用            
          </td>
        </tr>
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/roleManage_listRole.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
