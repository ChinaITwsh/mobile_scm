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
    <my:navigation text="基础设置 >>　配件型号管理 >> 型号列表" percent="90"/>
    <form action="accessoryType_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>品牌:</td>
          <td>
            <select class="text" name="accessoryType.brand">
                <option value="">--全部类别--</option>
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand}"
                        <c:if test="${accessoryType.brand eq brand}">selected</c:if>
                    >${brand}</option>
                </c:forEach>
            </select>
          </td>
          <td>型号名</td>
          <td><input class="text" name="accessoryType.typename" value="${accessoryType.typename}"/></td>
          <td align="right">   
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加型号"
             onclick="location='accessoryType_toAdd.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>型号编号</th>
        <th>品牌</th>
        <th>型号名</th>
        <th>单位</th>        
        <th>规格</th>
        <th>制造厂商</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="atype">
        <tr>
          <td>${atype.accessorytypeid}</td>
          <td>${atype.brand}</td>
          <td>${atype.typename}</td>
          <td>${atype.unit}</td>
          <td>${atype.spec}</td>
          <td>${atype.manufacturer}</td>         
          <td>${atype.remark}</td>
          <td>          
              <a href="${ctx}/accessoryType_toEdit.do?accessoryType.accessorytypeid=${atype.accessorytypeid}">编辑</a>
              <a href="${ctx}/accessoryType_delType.do?accessoryType.accessorytypeid=${atype.accessorytypeid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
