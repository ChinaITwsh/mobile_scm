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
    <my:navigation text="基础设置 >>　供应商管理 >> 修改供应商" percent="90"/>
    <form action="sup_editSup.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>供应商编号：</th>
          <td><input type="hidden" name="supplier.supid" value="${supplier.supid}"/>${supplier.supid}</td>
        </tr>
        <tr>
          <th>供应商名称：</th>
          <td><input class="text" name="supplier.supname" value="${supplier.supname}"/></td>
        </tr> 
        <tr>
          <th>类别：</th>
          <td>
            <select class="text" name="supplier.supType.suptypeid">               
                <c:forEach items="${supTypeList}" var="stype">
                    <option value="${stype.suptypeid}"
                        <c:if test="${supplier.supType.suptypeid eq stype.suptypeid}">selected</c:if>
                    >${stype.suptypename}</option>
                </c:forEach>
            </select>
          </td>
        </tr> 
        <tr>
            <th>联系人：</th>
            <td><input class="text" name="supplier.linkman" value="${supplier.linkman}"/></td>
        </tr>      
        <tr>
            <th>电话：</th>
            <td><input class="text" name="supplier.tel" value="${supplier.tel}"/></td>
        </tr>      
        <tr>
            <th>EMAIL：</th>
            <td><input class="text" name="supplier.email" value="${supplier.email}"/></td>
        </tr>      
        <tr>
          <th>地址：</th>
          <td><textarea class="text" name="supplier.address" style="width:300px;height:46px"/>${supplier.address}</textarea></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="supplier.remark" style="width:300px;height:46px"/>${supplier.remark}</textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/sup_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
