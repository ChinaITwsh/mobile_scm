<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysMenu"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>菜单管理</title>   
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript">
      $().ready(function() {
        if ($("input[name=refreshTree]").val() == "true") {
          parent.loadTree();
        }
      });
    </script> 
  </head>

  <body>
    <input type="hidden" name="refreshTree" value="${refreshTree}" />
    <table width="98%" align="center" border="0">
      <tr><td>当前菜单：<span style="font-weight:bold;color:#000099">${menu.menuName}</span></td></tr>    
    </table>
    <table width="98%" align="center" class="table">     
      <tr>       
        <th>菜单类型</th>
        <th>菜单动作</th>       
        <th>说明</th>
        <th>父菜单</th>
        <th>操作</th>
      </tr>
      <tr>
        <td>${menu.typeName}</td>
        <td>${menu.action.actionName}</td>       
        <td>${menu.remark}</td>
        <td><a href="menuManage_menuDetail.do?menu.menuId=${parentMenu.menuId}&menu.type=${parentMenu.type}">${parentMenu.menuName}</a></td>
        <td>        
           <c:if test="${not (menu.menuId eq 'root')}">
              <a href="menuManage_toEditMenu.do?menu.menuId=${menu.menuId}">编辑</a>
           </c:if> 
           <c:if test="${menu.type eq 1}">
              <a href="menuManage_toAddSubMenu.do?menu.menuId=${menu.menuId}">添加子菜单</a>
           </c:if> 
           <c:if test="${menu.type eq 2}">
              <a href="menuManage_toAddAction.do?menu.menuId=${menu.menuId}">添加动作</a>
           </c:if>    
        </td>
      </tr>
    </table>
    <s:if test="subMenuList != null">
      <table width="98%" align="center" border="0" style="margin-top:15px">
        <tr><td>子菜单列表：</td></tr>
      </table>
      <table width="98%" align="center" class="table">
        <tr>
          <th>菜单名称</th>
          <th>菜单类型</th>
          <th>菜单动作</th>       
          <th>说明</th>        
          <th>操作</th>       
        </tr>     
        <c:forEach items="${subMenuList}" var="subMenu">
          <tr>
            <td>
              <c:if test="${subMenu.type eq 3}">
                ${subMenu.menuName}
              </c:if>
              <c:if test="${subMenu.type != 3}">
                <a href="menuManage_menuDetail.do?menu.menuId=${subMenu.menuId}">${subMenu.menuName}</a></td>              
              </c:if>
            <td>${subMenu.typeName}</td>
            <td>${subMenu.action.actionName}</td>
            <td>${subMenu.remark}</td>
            <td>
              <a href="menuManage_delMenu.do?menu.menuId=${subMenu.menuId}&menu.parentId=${subMenu.parentId}&menu.type=${subMenu.type}" onclick="return confirm('此操作将删除所有相关子菜单或动作,确定要删除吗?');">删除</a>
              <a href="menuManage_upMenu.do?menu.menuId=${subMenu.menuId}">上移</a>
              <a href="menuManage_downMenu.do?menu.menuId=${subMenu.menuId}">下移</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </s:if>    
    <s:elseif test="normalActionList!=null || authorActionList!=null">
       <table width="98%" align="center" border="0" style="margin-top:15px">
        <tr><td>普通动作列表：</td></tr>
      </table>
      <table width="98%" align="center" class="table">
        <tr>
          <th>动作名称</th>
          <th>动作类型</th>
          <th>说明</th>        
          <th>操作</th>       
        </tr>     
        <c:forEach items="${normalActionList}" var="normalAction">
          <tr>
            <td>${normalAction.actionName}</td>
            <td>普通动作</td>
            <td <c:if test="${normalAction.actionId eq menu.action.actionId}">style="color:red"</c:if>>${normalAction.remark}</td>
            <td>
              <c:if test="${normalAction.actionId ne menu.action.actionId}">
              <a href="menuManage_toEditAction.do?action.actionId=${normalAction.actionId}">编辑</a>
              <a href="menuManage_delAction.do?action.actionId=${normalAction.actionId}" onclick="return confirm('确定要删除吗?');">删除</a>
              </c:if>
            </td>
          </tr>
        </c:forEach>
      </table>
       <table width="98%" align="center" border="0" style="margin-top:15px">
        <tr><td>授权动作列表：</td></tr>
      </table>
      <table width="98%" align="center" class="table">
        <tr>
          <th>动作名称</th>
          <th>动作类型</th>
          <th>说明</th>        
          <th>操作</th>       
        </tr>     
        <c:forEach items="${authorActionList}" var="authorAction">
          <tr>
            <td>${authorAction.actionName}</td>
            <td>授权动作</td>
            <td>${authorAction.remark}</td>
            <td>
              <a href="menuManage_toEditAction.do?action.actionId=${authorAction.actionId}">编辑</a>
              <a href="menuManage_delAction.do?action.actionId=${authorAction.actionId}" onclick="return confirm('确定要删除吗?');">删除</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </s:elseif>
  </body>
</html>
