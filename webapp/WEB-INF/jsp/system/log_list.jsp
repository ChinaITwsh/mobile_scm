<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <%@ include file="/WEB-INF/jsp/include/datepicker.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/system/log.js"></script>
  </head>
 
  <body>
    <my:navigation text="系统管理 >>　日志管理 >> 日志列表" percent="90"/>
    <form action="log_listLog.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">开始日期:</td>
          <td width="100" align="left">
            <input name="beginDate" class="date" value="${my:fmtDate(beginDate)}" readonly/>
          </td>         
          <td width="60" align="left">结束日期:</td>
          <td width="100">
            <input name="endDate" class="date" value="${my:fmtDate(endDate)}" readonly/>
          </td>  
          <td width="60" align="left">用户帐号:</td>
          <td>
            <select class="text" name="accName">
                <option value="">全部</option>
                <c:forEach items="${accList}" var="acc">
                    <option value="${acc.account}"
                        <c:if test="${accName eq acc.account}">selected</c:if>
                    >${acc.account}</option>
                </c:forEach>
            </select>
          </td>
          <td align="right">
            <input type="submit" class="btn find" value="查询"/>        
            <!--   
            <input type="button" class="btn return" style="width:80px" value="清理日志"/>
             -->       
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>动作</th>
        <th>参数</th>
        <th>用户帐号</th>
        <th>操作时间</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="log">
        <tr>
          <td>${log.actionName}</td>
          <td>${log.parameter}</td>
          <td>${log.account}</td>
          <td>${my:fmtDateTime(log.operTime)}</td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
