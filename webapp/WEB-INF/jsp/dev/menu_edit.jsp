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
    <my:navigation percent="98" text="菜单管理 >> 编辑菜单"/>
    <form action="menuManage_editMenu.do" method="post" onsubmit="return validateFrm();">
    <table width="500" align="center" class="inputTable" style="margin-top:15px">
      <tr>
        <th>父菜单：</th>
        <td>${parentMenu.menuName}</td>
      </tr>
      <tr  id="menuNameRow">
        <th>菜单名：</th>
        <td>
          <input name="menu.menuName" class="text" value="${menu.menuName}"/>
          <input name="menu.menuId" type="hidden" value="${menu.menuId}" />
          <input name="menu.parentId" type="hidden" value="${menu.parentId}" />
        </td>
      </tr>
      <tr>
        <th>菜单类型：</th>
        <td>
          <input type="hidden" name="menu.type" value="${menu.type}"/>
          <select class="text" onchange="showHideActionRow(this);" disabled>
            <c:forEach items="${menuTypeList}" var="menuType">
              <option value="${menuType.typeId}"
                <c:if test="${menu.type eq menuType.typeId}">selected</c:if>
              >${menuType.typeName}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <c:if test="${menu.type eq 2}">
      <tr id="actionRow" style="display:">
        <th>菜单动作</th>
        <td>
          <input name="menu.action.actionName" class="text" value="${menu.action.actionName}" />
          <input type="hidden" name="menu.action.actionId" value="${menu.action.actionId}"/>
        </td>
      </tr>      
      </c:if>     
      <tr>
        <th>菜单说明</th>
        <td><textarea name="menu.remark" class="text" style="width:300px;height:56px">${menu.remark}</textarea></td>
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
