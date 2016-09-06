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
    <my:navigation text="基础设置 >>　员工管理 >> 员工列表" percent="90"/>
    <form action="empManage_listEmp.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">员工姓名:</td>
          <td width="180" align="left"><input name="emp.empName" class="text" value="${emp.empName}"/></td>
          
          <td align="right">
            <input type="submit" class="btn find" value="查询"/>
            <input type="button" class="btn ok" style="width:90px" value="添加员工"
             onclick="location='empManage_toAddEmp.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>姓名</th>        
        <th>电话</th>
        <th>类别</th>
        <th>部门</th>
        <th>备注</th>
        <th>系统帐号</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${empList}" var="aemp">
        <tr>
          <td>${aemp.empName}</td>
          <td>${aemp.tel}</td>
          <td>${aemp.empTypeName}</td>
          <td>${aemp.dept.deptName}</td>
          <td>${aemp.remark}</td>
          <td>
            <c:if test="${empty aemp.user.userId}">
                无
            </c:if>            
            ${aemp.user.account}
            &nbsp;&nbsp;
            
            <c:if test="${empty aemp.user.userId}">
              <a href="accManage_toAddAcc.do?empId=${aemp.empId}">[创建帐号]</a>
            </c:if>              
           </td>
          <td>
              <a href="${ctx}/empManage_toEditEmp.do?emp.empId=${aemp.empId}">编辑</a>
              <a href="${ctx}/empManage_delEmp.do?emp.empId=${aemp.empId}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
