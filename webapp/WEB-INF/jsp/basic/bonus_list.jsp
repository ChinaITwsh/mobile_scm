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
    <my:navigation text="基础设置 >>　返利类别管理 >> 类别列表" percent="90"/>    
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr> 
          <td align="right">            
            <input type="button" class="btn ok" style="width:90px" value="添加类别"
             onclick="location='bonusType_toAdd.do'"/>
          </td>
        </tr>
      </table>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>       
        <th>类别名称</th>        
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="bonus">
        <tr>          
          <td>${bonus.typename}</td>          
          <td>${bonus.remark}</td>          
          <td>
              <a href="${ctx}/bonusType_toEdit.do?bonustype.bonustypeid=${bonus.bonustypeid}">编辑</a>
              <a href="${ctx}/bonusType_delType.do?bonustype.bonustypeid=${bonus.bonustypeid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
