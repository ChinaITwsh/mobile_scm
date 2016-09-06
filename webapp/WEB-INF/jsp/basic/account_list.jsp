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
    <my:navigation text="基础设置 >>　帐户管理 >> 帐户列表" percent="90"/>
    <form action="account_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>部门:</td>
          <td>
            <select class="text" name="account.dept.deptId">
                <option value="">--全部类别--</option>
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.deptId}"
                        <c:if test="${account.dept.deptId eq dept.deptId}">selected</c:if>
                    >${dept.deptName}</option>
                </c:forEach>
            </select>
          </td>          
          <td align="right">   
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加帐户"
             onclick="location='account_toAdd.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>帐户名</th>
        <th>余额</th>
        <th>所属部门</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="acc">
        <tr>
          <td>${acc.name}</td>
          <td><fmt:formatNumber value="${acc.balance}" pattern="￥#,##0.00"/></td>
          <td>${acc.dept.deptName}</td>                   
          <td>${acc.remark}</td>
          <td>          
              <a href="${ctx}/account_toEdit.do?account.accountid=${acc.accountid}">编辑</a>
              <a href="${ctx}/account_del.do?account.accountid=${acc.accountid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
