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
    <my:navigation text="供应商业务 >>　一般返利" percent="90"/>
    <form action="" method="post">
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
            <input type="button" class="btn ok" style="width:90px" value="新增返利单"
             onclick="location='commonBonus_toAdd.do'"/>
          </td>
       </tr>
       </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>单据号码</th>
        <th>供应商</th>
        <th>返利类别</th>
        <th>返利单价</th>
        <th>数量</th>
        <th>总金额</th>        
        <th>录入人</th>
        <th>审核人</th>
        <th>状态</th>
        <th>备注</th>
        <th>机构</th>
        <th>操作</th>
      </tr>
      
    </table>
    ${pagination.naviHtml}
  </body>
</html>
