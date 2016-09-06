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
    <my:navigation text="供应商业务 >>　付款 >> 付款单列表" percent="90"/>
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
            <input type="button" class="btn ok" style="width:90px" value="付款"
             onclick="location='pay_toAdd.do'"/>
          </td>
       </tr>
       </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>单据号码</th>
        <th>供应商</th>
        <th>付款帐户</th>
        <th>付款金额</th>        
        <th>录入人</th>
        <th>审核人</th>
        <th>状态</th>
        <th>备注</th>
        <th>机构</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="cp">
        <tr>
          <td>${cp.invoiceid}</td>
          <td>${cp.supplierid }</td>
          <td>${cp.accountid}</td>                   
          <td>${cp.money}</td>
          <td>${mr.inputuserid}</td>
          <td>${mr.checkuserid}</td>
          <td>${mr.status}</td>
          <td>${mr.remark}</td>
          <td>${mr.orgid}</td>
          <td>          
              <a href="#">详情</a>
              <c:choose>
                  <c:when test="${mr.status eq 0}">
                      <a href="#">修改</a>              
                      <a href="#">删除</a>
                        <a href="pay_check.do?invoiceid=${cp.invoiceid}">审核</a>
                  </c:when>
                  <c:otherwise>
                     <span style="color:gray">修改</span>
                     <span style="color:gray">删除</span>
                     <span style="color:gray">审核</span>
                  </c:otherwise>
              </c:choose>   
              
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
