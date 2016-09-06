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
    <my:navigation text="基础设置 >>　部门管理 >> 部门列表" percent="90"/>
    <form action="deptManage_listDept.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">部门名称:</td>
          <td width="180" align="left"><input name="dept.deptName" class="text" value="${dept.deptName}"/></td>
          <td width="60" align="left">部门地址:</td>
          <td width="180" align="left"><input name="dept.address" class="text" value="${dept.address}"/></td>
          
          <td align="right">
            <input type="submit" class="btn find" value="查询"/>
            <input type="button" class="btn ok" style="width:90px" value="添加部门"
             onclick="location='deptManage_toAddDept.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>部门名称</th>
        <th>地址</th>
        <th>电话</th>
        <th>联系人</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${deptList}" var="adept">
        <tr>
          <td>${adept.deptName}</td>
          <td>${adept.address}</td>
          <td>${adept.tel}</td>
          <td>${adept.linkman}</td>
          <td>${adept.remark}</td>
          <td>          
              <a href="${ctx}/deptManage_toEditDept.do?dept.deptId=${adept.deptId}">编辑</a>
              <a href="${ctx}/deptManage_delDept.do?dept.deptId=${adept.deptId}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
