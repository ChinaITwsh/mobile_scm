<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysRole"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
  </head>
 
  <body>
    <my:navigation text="系统管理 >>　角色管理 >> 角色列表" percent="90"/>
    <form action="roleManage_listRole.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">角色名称:</td>
          <td width="180" align="left"><input name="role.roleName" class="text" value="${role.roleName}"/></td>
          <td align="left">
            <input type="checkbox" name="status" value="<%=SysRole.ROLESTAT_ENABLE%>"  
               <my:checked curVal="<%=SysRole.ROLESTAT_ENABLE%>" list="${status}"/> 
            />已启用
            <input type="checkbox" name="status" value="<%=SysRole.ROLESTAT_DISABLE%>"
               <my:checked curVal="<%=SysRole.ROLESTAT_DISABLE%>" list="${status}"/>   
            />已停用
            <input type="checkbox" name="status" value="<%=SysRole.ROLESTAT_DEL%>"
               <my:checked curVal="<%=SysRole.ROLESTAT_DEL%>" list="${status}"/>   
            />已删除
          </td>
          <td align="right">
            <input type="submit" class="btn find" value="查询"/>
            <my:privShow action="roleManage_toAddRole.do">
            <input type="button" class="btn ok" style="width:90px" value="添加角色"
             onclick="location='roleManage_toAddRole.do'"/>
             </my:privShow>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>角色名称</th>
        <th>角色说明</th>
        <th>角色状态</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${roleList}" var="role">
        <tr>
          <td>${role.roleName}</td>
          <td>${role.remark}</td>
          <td>${role.statName}</td>
          <td>
            <c:choose>
            <c:when test="${3 eq role.status}">
              <a href="${ctx}/roleManage_restoreRole.do?role.roleId=${role.roleId}">恢复角色</a>
            </c:when>
            <c:otherwise>
              <a href="${ctx}/roleManage_toEditRole.do?role.roleId=${role.roleId}">编辑</a>
              <a href="${ctx}/roleManage_delRole.do?role.roleId=${role.roleId}" onclick="return confirm('确定要删除吗？');">删除</a>
            </c:otherwise>  
            </c:choose>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
