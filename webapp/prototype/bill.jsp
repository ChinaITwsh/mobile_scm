<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <%@ include file="/WEB-INF/jsp/include/datepicker.jsp" %>
  </head>
 
  <body>
    <my:navigation text="供应商业务 >>　对帐单" percent="90"/>
    <form action="mobReturn_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>开始时间</td>
          <td><input class="text" style="width:80px" name="startDate" readonly/></td>
          <td>结束时间</td>
          <td><input class="text" style="width:80px" name="endDate"  readonly/></td>
         <td>供应商类别</td>
          <td>
          <select name="supTypeId" class="text" style="width:80px">
            <option value="">--不限--</option>
            <c:forEach items="${supTypeList}" var="supType">
                <option value="${supType.suptypeid}">${supType.suptypename}</option>
            </c:forEach>
          </select>
          </td>
          <td>供应商</td>
          <td>
            <select name="supplierid" class="text" style="width:80px">
            <option value="">--不限--</option>
            <c:forEach items="${supList}" var="sup">
                <option value="${sup.supType.suptypeid}.${sup.supid}" >${sup.supname}</option>
            </c:forEach>
          </select>
          </td>
          <td align="right">
            <input type="submit" class="btn find" value="查询" />    
          </td>
       </tr>
       </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >      
      <tr>
        <th>日期</th>
        <th>期初余额</th>
        <th>支出金额</th>
        <th>收入金额</th>        
        <th>期末余额</th>
      </tr>
    </table>
  </body>
</html>
