<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysMenu"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>菜单管理</title>
    <link href="${ctx}/skin/default/css/page.css" rel="stylesheet"
      type="text/css" />  
    <link href="${ctx}/skin/default/css/table.css" rel="stylesheet"
      type="text/css" />  
    <script type="text/javascript" src="${ctx}/js/common/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/js/common/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/common/tree.js"></script>
    <script type="text/javascript" src="${ctx}/js/dev/menu_manage.js"></script>
  </head>

  <body style="margin: 8px">
    <table class="table" width="98%" align="center">
      <tr>
        <td width="200" id="treeContainer"
          style="text-align: left; vertical-align: top; padding-left: 8px">

        </td>
        <td id="menuDetail" style="padding: 0px">
          <iframe id="ifrm" name="menuDetail" frameborder="0" width="100%"
            height="100%" src="menuManage_menuDetail.do?menu.menuId=root&menu.type=<%=SysMenu.MENUTYPE_PARENT%>"></iframe>
        </td>
      </tr>
    </table>
  </body>
</html>
