<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysRole"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/basic/supplier.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　客户管理  >> 修改客户" percent="90"/>
    <form action="cust_editCust.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>客户编号：</th>
          <td><input type="hidden" name="cust.custid" value="${cust.custid}"/>${cust.custid}</td>
        </tr>
        <tr>
          <th>客户名称：</th>
          <td><input class="text" name="cust.custname" value="${cust.custname}"/></td>
        </tr> 
        <tr>
          <th>类别：</th>
          <td>
            <select class="text" name="cust.custType.custtypeid">               
                <c:forEach items="${custTypeList}" var="ctype">
                    <option value="${ctype.custtypeid}"
                        <c:if test="${cust.custType.custtypeid eq ctype.custtypeid}">selected</c:if>
                    >${ctype.custtypename}</option>
                </c:forEach>
            </select>
          </td>
        </tr> 
        <tr>
            <th>联系人：</th>
            <td><input class="text" name="cust.linkman" value="${cust.linkman}"/></td>
        </tr>      
        <tr>
            <th>电话：</th>
            <td><input class="text" name="cust.tel" value="${cust.tel}"/></td>
        </tr>      
        <tr>
            <th>传真</th>
            <td><input class="text" name="cust.fax" value="${cust.fax}"/></td>
        </tr>
        <tr>
            <th>EMAIL：</th>
            <td><input class="text" name="cust.email" value="${cust.email}"/></td>
        </tr>      
        <tr>
          <th>地址：</th>
          <td><textarea class="text" name="cust.address" style="width:300px;height:46px"/>${cust.address}</textarea></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="scust.remark" style="width:300px;height:46px"/>${cust.remark}</textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/cust_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
