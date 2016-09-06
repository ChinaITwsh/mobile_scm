<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/system/emp.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　员工管理 >> 添加员工" percent="90"/>
    <form action="empManage_addEmp.do" method="post" onsubmit="">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>姓名：</th>
          <td><input class="text" name="emp.empName"/></td>
        </tr>
        <tr>
          <th>电话：</th>
          <td><input class="text" name="emp.tel" /></td>
        </tr>
        <tr>
          <th>类别：</th>
          <td>
            <select class="text" name="emp.empType">
              <c:forEach items="${empTypeList}" var="empType">
                <option value="${empType.type}">${empType.typeName}</option>
              </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <th>部门：</th>
          <td>
            <select class="text" name="emp.dept.deptId">
              <c:forEach items="${deptList}" var="dept">
                <option value="${dept.deptId}">${dept.deptName}</option>
              </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="emp.remark" style="width:300px;height:46px"/></textarea></td>
        </tr>       
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/empManage_listEmp.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
