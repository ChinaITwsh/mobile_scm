<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>菜单管理</title>   
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/dev/menu.js"></script> 
  </head>

  <body>
    <my:navigation percent="98" text="菜单管理 >> 添加菜单"/>
    <form action="menuManage_addMenu.do" method="post" onsubmit="return validateFrm();">
    <table width="500" align="center" class="inputTable" style="margin-top:15px">
      <tr>
        <th>父菜单：</th>
        <td>${menu.menuName}         
            <input type="hidden" name="menu.parentId" value="${menu.menuId}"/>
        </td>
      </tr>
      <tr  id="menuNameRow">
        <th>菜单名：</th>
        <td><input name="menu.menuName" class="text"/></td>
      </tr>
      <tr>
        <th>菜单类型：</th>
        <td>
          <select class="text" onchange="showHideActionRow(this);" name="menu.type">
            <c:forEach items="${menuTypeList}" var="menuType">
              <option value="${menuType.typeId}">${menuType.typeName}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr id="actionRow" style="display:none">
        <th>菜单动作</th>
        <td><input name="menu.action.actionName" class="text" disabled/></td>
      </tr>
      <tr>
        <th>菜单说明</th>
        <td><textarea name="menu.remark" class="text" style="width:300px;height:56px"></textarea></td>
      </tr>
    </table>
    <table width="500" align="center" style="margin-top:15px">
      <tr><td align="center">
        <input type="submit" class="btn ok" value="确定"/>
        <input type="button" class="btn cancel" value="取消" onclick="location='menuManage_menuDetail.do?menu.menuId=${menu.menuId}'"/>
      </td></tr>
    </table>
    </form>
  </body>
</html>
