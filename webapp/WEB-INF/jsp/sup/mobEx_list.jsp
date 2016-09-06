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
    <my:navigation text="供应商业务 >>　手机换机" percent="90"/>
    <form action="mobEx_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td align="right"> 
            <input type="button" class="btn ok" style="width:90px" value="新建换机单"
             onclick="location='mobEx_toAdd.do'"/>
          </td>
       </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>单据号码</th>
        <th>供应商</th>
        <th>机型</th>
        <th>贴补价</th>
        <th>数量</th>
        <th>金额</th>
        <th>录入人</th>
        <th>审核人</th>
        <th>状态</th>
        <th>备注</th>
        <th>机构</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="me">
        <tr>
          <td>${me.invoiceid}</td>
          <td>${me.supplierid }</td>
          <td>${me.mobtypeid}</td>                   
          <td>${me.unitprice}</td>
          <td>${me.amount}</td>
          <td>${me.totalmoney}</td>
          <td>${me.inputuserid}</td>
          <td>${me.checkuserid}</td>
          <td>${me.status}</td>
          <td>${me.remark}</td>
          <td>${me.orgid}</td>
          <td>          
              <a href="#">详情</a>
              <c:choose>
                  <c:when test="${me.status eq 0}">
                      <a href="mobEx_snManage.do?invoiceid=${me.invoiceid}">修改</a>              
                      <a href="#">删除</a>
                        <a href="mobEx_check.do?invoiceid=${me.invoiceid}">审核</a>
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
