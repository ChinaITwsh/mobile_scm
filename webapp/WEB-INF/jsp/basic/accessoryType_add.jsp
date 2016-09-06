<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysRole"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/basic/accessoryType.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　配件类别管理 >> 添加类别" percent="90"/>
    <form action="accessoryType_addType.do" method="post" onsubmit="return ValidateFrm.submitValidate(this)">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">    
        <tr>
          <th>类别编号：</th>
          <td><input required class="text" name="accessoryType.accessorytypeid"  value="${accessoryType.accessorytypeid}"/></td>
        </tr>      
        <tr>
          <th>类别名称：</th>
          <td><input class="text" name="accessoryType.typename"  value="${accessoryType.typename}"/></td>
        </tr>
        <tr>
          <th>品牌：</th>
          <td>
            <select name="accessoryType.brand" class="text">
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand}"
                        <c:if test="${brand eq accessoryType.brand}">selected</c:if>
                    >${brand}</option>
                </c:forEach>
            </select>
          </td>
        </tr>  
        <tr>
          <th>单位：</th>
          <td><input class="text" name="accessoryType.unit"  value="${accessoryType.unit}"/></td>
        </tr> 
        <tr>
          <th>规格：</th>
          <td><input class="text" name="accessoryType.spec"  value="${accessoryType.spec}"/></td>
        </tr> 
        <tr>
          <th>制造厂商：</th>
          <td><input class="text" name="accessoryType.manufacturer"  value="${accessoryType.manufacturer}"/></td>
        </tr>    
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="accessoryType.remark" style="width:300px;height:46px"/>${accessoryType.remark}</textarea></td>
        </tr>       
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/accessoryType_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
