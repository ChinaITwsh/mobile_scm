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
    <my:navigation text="基础设置 >>　供应商管理 >> 供应商列表" percent="90"/>
    <form action="sup_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>供应商类别:</td>
          <td>
            <select class="text" name="supplier.supType.suptypeid">
                <option value="">--全部类别--</option>
                <c:forEach items="${supTypeList}" var="stype">
                    <option value="${stype.suptypeid}"
                        <c:if test="${supplier.supType.suptypeid eq stype.suptypeid}">selected</c:if>
                    >${stype.suptypename}</option>
                </c:forEach>
            </select>
          </td>
          <td>供应商名称</td>
          <td><input class="text" name="supplier.supname" value="${sup.supname}"/></td>
          <td align="right">   
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加供应商"
             onclick="location='sup_toAdd.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>供应商编号</th>
        <th>供应商名称</th>
        <th>类别</th>
        <th>联系人</th>
        <th>电话</th>
        <th>EMAIL</th>
        <th>地址</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="sup">
        <tr>
          <td>${sup.supid}</td>
          <td>${sup.supname}</td>
          <td>${sup.supType.suptypename}</td>
          <td>${sup.linkman}</td>
          <td>${sup.tel}</td>
          <td>${sup.email}</td>
          <td>${sup.address}</td>
          <td>${sup.remark}</td>
          <td>          
              <a href="${ctx}/sup_toEdit.do?supplier.supid=${sup.supid}">编辑</a>
              <a href="${ctx}/sup_delSup.do?supplier.supid=${sup.supid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
