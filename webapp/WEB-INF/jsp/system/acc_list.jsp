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
    <my:navigation text="系统管理 >>　帐号管理 >> 帐号列表" percent="90"/>
    <form action="accManage_listAcc.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">帐号名称:</td>
          <td width="180" align="left"><input name="acc.account" class="text" value="${acc.account}"/></td>         
          <td align="right">
            <input type="submit" class="btn find" value="查询"/>          
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>登录帐号</th>
        <th>员工姓名</th>
        <th>备注</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>页面主题</th>
        <th>角色</th>
        <th>查询范围</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${accList}" var="aacc">
        <tr>
          <td>${aacc.account}</td>
          <td>${aacc.empName}</td>
          <td>${aacc.remark}</td>
          <td>${aacc.statName}</td>
          <td>${aacc.createTimeStr}</td>
          <td>${aacc.skin}</td>
          <td>
            <c:forEach items="${aacc.roleList}" var="role">
              ${role.roleName}&nbsp;
            </c:forEach>
          </td>
          <td>${aacc.queryScopeName}</td>
          <td>
            <c:choose>
            <c:when test="${0 eq aacc.status}">
              <a href="${ctx}/accManage_restoreAcc.do?acc.userId=${aacc.userId}">恢复帐号</a>
            </c:when>
            <c:otherwise>
              <a href="${ctx}/accManage_toEditAcc.do?acc.userId=${aacc.userId}">编辑</a>
              <a href="${ctx}/accManage_delAcc.do?acc.userId=${aacc.userId}" onclick="return confirm('确定要删除吗？');">删除</a>
            </c:otherwise>  
            </c:choose>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
