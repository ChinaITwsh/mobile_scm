<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <link rel="stylesheet" href="${ctx}/skin/${skin}/css/main.css" type="text/css">
    <script type="text/javascript" src="${ctx}/js/common/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/js/common/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/common/init.js"></script>
    <script type="text/javascript" src="${ctx}/js/home.js"></script>
  </head>
  
  <body onselectstart="return false;" oncontextmenu="return false;">
    <input type="hidden" name="ctx" value="${ctx}" />
    <input type="hidden" name="skinpath" value="${ctx}/skin/${skin}" />
    <div class="mask"></div>
    <div class="menu">
      <div class="handle"></div>           
    </div>
    <div class="main">
      <div class="conDiv">
        <iframe name="content" width="100%" height="100%" frameborder="0" src="welcome.do" style="background-color:white"></iframe>
      </div>
    </div>
    <div class="foot">登录用户：『${loginUser.empName}』</div>
  </body>
</html>