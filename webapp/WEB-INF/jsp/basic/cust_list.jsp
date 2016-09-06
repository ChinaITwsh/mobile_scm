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
    <my:navigation text="基础设置 >>　客户管理 >> 客户列表" percent="90"/>
    <form action="cust_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>客户类别:</td>
          <td>
            <select class="text" name="cust.custType.custtypeid">
                <option value="">--全部类别--</option>
                <c:forEach items="${custTypeList}" var="ctype">
                    <option value="${ctype.custtypeid}"
                        <c:if test="${cust.custType.custtypeid eq ctype.custtypeid}">selected</c:if>
                    >${ctype.custtypename}</option>
                </c:forEach>
            </select>
          </td>
          <td>客户名称</td>
          <td><input class="text" name="cust.custname" value="${cust.custname}"/></td>
          <td align="right">   
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加客户"
             onclick="location='cust_toAdd.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>客户编号</th>
        <th>客户名称</th>
        <th>类别</th>
        <th>联系人</th>
        <th>电话</th>
        <th>EMAIL</th>
        <th>地址</th>
        <th>传真</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="cust">
        <tr>
          <td>${cust.custid}</td>
          <td>${cust.custname}</td>
          <td>${cust.custType.custtypename}</td>
          <td>${cust.linkman}</td>
          <td>${cust.tel}</td>
          <td>${cust.email}</td>
          <td>${cust.address}</td>
          <td>${cust.fax}</td>
          <td>${cust.remark}</td>
          <td>          
              <a href="${ctx}/cust_toEdit.do?cust.custid=${cust.custid}">编辑</a>
              <a href="${ctx}/cust_delCust.do?cust.custid=${cust.custid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
