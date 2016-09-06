<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysRole"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/basic/supType.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　返利类别管理 >> 修改类别" percent="90"/>
    <form action="bonusType_editType.do" method="post" onsubmit="return checkFrm();">
        <input type="hidden" name="bonustype.bonustypeid" value="${bonustype.bonustypeid}" />
      <table width="500" align="center" style="margin-top:30px" class="inputTable">       
        <tr>
          <th>类别名称：</th>
          <td><input class="text" name="bonustype.typename"  value="${bonustype.typename}"/></td>
        </tr>        
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="bonustype.remark" style="width:300px;height:46px"/>${bonustype.remark}</textarea></td>
        </tr>       
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/bonusType_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
