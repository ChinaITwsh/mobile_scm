<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/basic/account.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　帐户管理 >> 添加帐户" percent="90"/>
    <form action="account_edit.do" method="post" onsubmit="return ValidateFrm.submitValidate(this)">
        <input type="hidden" name="account.accountid" value="${account.accountid}">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">    
        <tr>
          <th>帐户名：</th>
          <td><input required class="text" name="account.name"  value="${account.name}"/></td>
        </tr>
        <tr>
          <th>所属部门：</th>
          <td>
            <select name="account.dept.deptId" class="text">
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.deptId}"
                        <c:if test="${dept.deptId eq account.dept.deptId}">selected</c:if>
                    >${dept.deptName}</option>
                </c:forEach>
            </select>
          </td>
        </tr>  
        <tr>
          <th>余额：</th>
          <td><fmt:formatNumber value="${account.balance}" pattern="￥#,##0.00" /></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="account.remark" style="width:300px;height:46px"/>${account.remark}</textarea></td>
        </tr>       
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/account_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
