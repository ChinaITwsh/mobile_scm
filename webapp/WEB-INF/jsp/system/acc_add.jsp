<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysUsers"%>

<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/system/acc.js"></script>
  </head>
  
  <body>
    <my:navigation text="系统管理 >>　帐号管理 >> 创建帐号" percent="90"/>
    <form action="accManage_addAcc.do" method="post" onsubmit="return checkAddFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>员工姓名：</th>
          <td>${empName}
            <input type="hidden" name="empId" value="${empId}"/>
          </td>
        </tr>
        <tr>
          <th>帐号名称：</th>
          <td><input class="text" name="acc.account" value="${acc.account}"/>
            <my:errInfo key="dupAcc"/>
          </td>
        </tr>
        <tr>
          <th>密码：</th>
          <td><input class="text" name="acc.passwd" value="${acc.passwd}"/></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="acc.remark" style="width:300px;height:46px"/>${acc.remark}</textarea></td>
        </tr>
        <tr>
          <th>状态：</th>
          <td>
            <input type="radio" name="acc.status" checked value="<%=SysUsers.STAT_ENABLE%>"/>启用
            <input type="radio" name="acc.status" value="<%=SysUsers.STAT_DISABLE%>"
              <my:checked curVal="<%=SysUsers.STAT_DISABLE%>" compare="${acc.status}"/>
            />禁用            
          </td>
        </tr>
        <tr>
          <th>角色：</th>
          <td>
            <c:forEach items="${roleList}" var="role">
              <input type="checkbox" name="acc.roleIdList" value="${role.roleId}"
                <my:checked curVal="${role.roleId}" list="${acc.roleIdList}"/>
              />${role.roleName}
            </c:forEach>
            <my:errInfo key="nullRole"/>
          </td>
        </tr>
        <tr>
          <th>查询范围：</th>
          <td>
            <c:forEach items="${deptList}" var="dept">
              <input type="checkbox" name="acc.queryScopeList" value="${dept.deptId}"
                <my:checked curVal="${dept.deptId}" list="${acc.queryScopeList}"/>
              />${dept.deptName}
            </c:forEach>
            <my:errInfo key="nullScope"/>
          </td>
        </tr>
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/accManage_listAcc.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
