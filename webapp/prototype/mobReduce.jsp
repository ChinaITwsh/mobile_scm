<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/sup/mobstockin.js"> </script>
  </head>
  
	<body>
        <my:navigation text="供应商业务 >>　手机报损" percent="90"/>		
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
				<tr>
					<th colspan="4">
						增加报损
					</th>
                    <th>数量</th>
                    <th><input type="text" name="amount" value="3" class="text" style="width:100;border:none;background:none;font-weight:bold"
                            maxlength="6" readonly />
                    </th>
                    <th>损失总金额</th>
                    <th><input name="totalmoney" readonly class="text" style="width:80px;border:none;background:none;font-weight:bold" value="0"/>
				</tr>
				<tr>
					
					
					<th>机型</th>
					<td>
						<select name="mobtypeid" class="text"  style="width:100">
							<c:forEach items="${mobTypeList }" var="mobType">
								<option value="${mobType.brand}.${mobType.mobtypeid }">${mobType.mobtypename}</option>
							</c:forEach>
						</select>
					</td>
                    <td><button>查询</button></td>
				</tr>

				<tr>
					
					<th>目标价</th>
					<td>
						<input type="text" name="buyprice" value="" class="text" style="width:100"
							maxlength="8" />
					</td>
                   <td><button>计算</button></td>
					
					
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
						<th width="250">
							串号一
						</th>
						<th width="250">
							串号二
						</th>
                        <th>成本价</th>
						<th>
							报损金额
						</th>					
				</tr>
                <tr>
                    <td>1</td>
                    <td>123</td>
                    <td>1200</td>
                    <td>1000</td>
                    <td><input value="0" class="text" style="width:50px"/>
                </tr>
                <tr>
                    <td>2</td>
                    <td>456</td>
                    <td>1200</td>
                    <td>1100</td>
                    <td><input value="0" class="text" style="width:50px"/>
                </tr>
                <tr>
                    <td>3</td>
                    <td>789</td>
                    <td>1100</td>
                    <td>1200</td>
                    <td><input value="0" class="text" style="width:50px"/>
                </tr>
			</table>
			
			<br />
			<div align="center">
				<input type="button" name="but1" value="保存" class="btn ok" onclick="submitFrm(this.form)" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" name="but2" value="返回" class="btn cancel" onclick="location='${ctx}/mobStockIn_list.do'"/>
			</div>

	</body>
</html>
