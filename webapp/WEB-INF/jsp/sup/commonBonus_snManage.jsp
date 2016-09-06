<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <%@ include file="/WEB-INF/jsp/include/datepicker.jsp" %>
    <script type="text/javascript" src="${ctx}/js/sup/commonBonus.js"> </script>
  </head>
  
	<body>
        <my:navigation text="供应商业务 >>　 一般返利" percent="90"/>		
		<form action="${ctx}/commonBonus_addInvoice.do" method="post">
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
				    <tr>
					<th>${commonBonus.invoiceid}</th>
					<th>${commonBonus.supplierid}</th>
					<th>${commonBonus.mobtypeid}</th>
					<th>${commonBonus.bonustypeid}</th>
					<th>${commonBonus.unitprice}</th>
					<th>${commonBonus.amount}</th>
					<th>${commonBonus.totalmoney}</th>
					<th>${my:fmtDate(commonBonus.startdate)}</th>
					<th>${my:fmtDate(commonBonus.enddate)}</th>
                    </tr>
			</table>
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
                <tr>
                    <th>串号一</th>
                    <th>串号二</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${snList}" var="sn">
                    <tr>
                        <td>${sn.sn1 }</td>
                        <td>${sn.sn2 }</td>
                        <td><a href="#">删除</a></td>
                    </tr>                
                </c:forEach>
            </table>
			<br />
			<div align="center">
				<input type="button" name="but1" value="查询串号" class="btn ok" onclick="querySn('${commonBonus.supplierid}','${commonBonus.mobtypeid}','${my:fmtDate(commonBonus.startdate)}','${my:fmtDate(commonBonus.enddate)}');"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" name="but2" value="返回" class="btn cancel" onclick="location='${ctx}/commonBonus_list.do'"/>
			</div>
		</form>

	</body>
</html>
