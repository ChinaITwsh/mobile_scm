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
					<th colspan="8">
						新建一般返利单
					</th>
				</tr>
				<tr>
					<th>供应商类别</th>
					<td>
						<select name="supTypeId" class="text" style="width:100">
							<c:forEach items="${supTypeList }" var="st">
								<option value="${st.suptypeid}">${st.suptypename}</option>
							</c:forEach>
						</select>
					</td>
					<th>供应商</th>
					<td>
						<select name="supplierid" class="text" style="width:100">
							<c:forEach items="${supList}" var="sup">
								<option value="${sup.supid }">${sup.supname}</option>
							</c:forEach>
						</select>
					</td>
					<th>品牌名称</th>
					<td>
						<select name="brand" class="text" style="width:100" >
							<c:forEach items="${brandList}" var="brand">
								<option value="${brand}">${brand}</option>
							</c:forEach>
						</select>
					</td>	
					<th>机型</th>
					<td>
						<select name="mobtypeid" class="text"  style="width:100">
							<c:forEach items="${mtList }" var="mobType">
								<option value="${mobType.mobtypeid }">${mobType.mobtypename}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<th>返利类别</th>
					<td>
						<select name="bonustypeid" class="text" style="width:100">
							<c:forEach items="${bonusTypeList}" var="bt">
								<option value="${bt.bonustypeid}">${bt.typename}</option>
							</c:forEach>
						</select>
					</td>
					<th>返利单价</th>
					<td>
						<input type="text" name="unitprice" value="" class="text" style="width:100"
							maxlength="8" />
					</td>
                    <th>参考单价</th>
                    <td colspan="3">
                        <span id="refPrice"><img src="${ctx}/images/loading.gif"/></span>
                    </td>					
				</tr>
                <tr>
                    <th>开始日期</th>
                    <td><input class="text" name="startdate" value="${my:fmtDate(startDate)}"  readonly/></td>
                    <th>结束日期</th>
                    <td colspan="5"><input class="text" name="enddate" value="${my:fmtDate(endDate)}" readonly/></td>
                    
                </tr>
				<tr>
					<th>
						备注
					</th>
					<td colspan="7">
						<textarea rows="2" cols="82" name="remark"></textarea>
					</td>
				</tr>
			</table>
			
			<br />
			<div align="center">
				<input type="submit" name="but1" value="保存" class="btn ok" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" name="but2" value="返回" class="btn cancel" onclick="location='${ctx}/commonBonus_list.do'"/>
			</div>
		</form>

	</body>
</html>
