<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/sup/mobreturn.js"> </script>
  </head>
  
	<body>
        <my:navigation text="供应商业务 >>　手机退货  >> 新建退货单" percent="90"/>		
		<form action="${ctx}/mobReturn_add.do" method="post">
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
				<tr>
					<th colspan="2">
						新建手机退货单
					</th>
                    <th>数量</th>
                    <th><input type="text" name="amount" value="0" class="text" style="width:100;border:none;background:none;font-weight:bold"
                            maxlength="6" readonly />
                    </th>
                    <th>退货价</th>
                    <th><input type="text" name="returnprice"  class="text" style="width:100;"
                            maxlength="6" />
                    </th>
                    <th>总价</th>
                    <th><input name="totalmoney" readonly class="text" style="width:80px;border:none;background:none;font-weight:bold" value="0"/>
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
								<option value="${sup.supType.suptypeid }.${sup.supid }">${sup.supname}</option>
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
							<c:forEach items="${mobTypeList }" var="mobType">
								<option value="${mobType.brand}.${mobType.mobtypeid }">${mobType.mobtypename}</option>
							</c:forEach>
						</select>
					</td>
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
			<table id="tblSns"  class="table" width="90%" align="center" style="margin-top:10px">
				<tr>
						<th align="center" width="50">
							序号
						</th>
						<th >
							串号一
						</th>
						<th >
							串号二
						</th>
                        <th>
                                                                            供应商
                        </th>
                        <th>
                                                                            机型
                        </th>
						<th>
							操作
						</th>
						<th>
							状态
						</th>
				</tr>
			</table>
			<table align="center" width="90%" class="inputTable" style="border-top:none">
				<tr>
					
					<th width="50">
						串号
					</th>
					<th width="220">
						<input type="text" name="sn1" value="" class="text" maxlength="30"/>
					</th>
					
                    <th align="left">
                        <input type="button" value="添加" class="btn ok" onclick="addSn();"> 
                    </th>
				</tr>
			</table>
			<br />
			<div align="center">
				<input type="button" name="but1" value="保存" class="btn ok" onclick="submitFrm(this.form)" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" name="but2" value="返回" class="btn cancel" onclick="location='${ctx}/mobReturn_list.do'"/>
			</div>
		</form>

	</body>
</html>
