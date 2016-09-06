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
        <my:navigation text="供应商业务 >>　手机报费" percent="90"/>		
			总数量：3    损失总金额：5  损失平均价：1100
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
							损失金额

						</th>
				</tr>
			</table>
			<table align="center" width="90%" class="inputTable" style="border-top:none">
				<tr>
										<th width="50">
						串号一
					</th>
					<th width="220">
						<input type="text" name="sn1" value="" class="text" maxlength="30"/>
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
