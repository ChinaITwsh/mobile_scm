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
    <my:navigation text="基础设置 >>　手机颜色管理" percent="90"/>
    <form action="color_addColor.do" method="post">
      <table border="0" width="500" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">颜色:</td>
          <td width="180" align="left"><input name="color" class="text"/></td>
          <td align="left" width="80">
            <input type="submit" value="添加" class="btn ok" />
          </td>
          <td align="left"><my:errInfo key="dupClr"/></td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="500" align="center" >
      <tr>
        <th>颜色</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${colorList}" var="clr">
        <tr>
          <td>${clr}</td>
          <td>
              <c:url value="${ctx}/color_delColor.do" var="delUrl">
                <c:param name="color" value="${clr}"></c:param>
              </c:url>
              <a href="${delUrl}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
