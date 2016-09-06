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
        <my:navigation text="供应商业务 >>　手机调拔" percent="90"/>		
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
				<tr>
					<th colspan="4">
						增加手机调拔
					</th>
                    <th>数量</th>
                    <th><input type="text" name="amount" value="0" class="text" style="width:100;border:none;background:none;font-weight:bold"
                            maxlength="6" readonly />
                    </th>
                    <th>总价</th>
                    <th><input name="totalmoney" readonly class="text" style="width:80px;border:none;background:none;font-weight:bold" value="0"/>
				</tr>
				<tr>
					<th>调出部门</th>
					<td>
						<select name="outorgid" class="text" style="width:100">
							<c:forEach items="${orgList }" var="org">
								<option value="${org.deptid}">${org.deptname}</option>
							</c:forEach>
						</select>
					</td>
					<th>调入部门</th>
					<td>
						<select name="inorgid" class="text" style="width:100">
							<c:forEach items="${orgList }" var="org">
                                <option value="${org.deptid}">${org.deptname}</option>
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
					<th>配置</th>
					<td>
						<select name="config" class="text" style="width:100">
							<c:forEach items="${configList}" var="con">
								<option value="${con}">${con}</option>
							</c:forEach>
						</select>
					</td>
					<th>调拔价</th>
					<td>
						<input type="text" name="buyprice" value="" class="text" style="width:100"
							maxlength="8" />
					</td>
                   
					<th>
						颜色
					</th>
					<td>
						<select name="color" class="text" style="width:100">
							<c:forEach items="${colorList }" var="color">
								<option value="${color}">${color}</option>
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
						<th width="250">
							串号一
						</th>
						<th width="250">
							串号二
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
					<th width="245">
						<input type="radio" name="setSn" checked value="single"/>
							单串号

						<input type="radio" name="setSn" value="double"/>
							双串号

					</th>
					<th width="50">
						串号一
					</th>
					<th width="220">
						<input type="text" name="sn1" value="" class="text" maxlength="30"/>
					</th>
					<th width="50">
						串号二
					</th>
					<th>
						<input type="text" name="sn2" value="" class="text" maxlength="30" disabled style="background-color:gray"/>						
					</th>
                    <th align="center">
                        <input type="button" value="添加" class="btn ok" onclick="addSn();"> 
                    </th>
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
