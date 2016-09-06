<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysRole"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/basic/mobType.js"></script>
    <script type="text/javascript">
        //初始化返利价格数组
        <c:forEach items="${mobBonusList}" var="bonus">
            parameter["mobType.bonusList"].push({
                bonusTypeId:'${bonus.bonusTypeId}',
                bonusTypeName:'${bonus.typeName}',
                bonusPrice:${bonus.money}
            });
        </c:forEach>
    </script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　手机型号管理 >> 编辑型号" percent="90"/>
    <form action="mobType_editType.do" method="post" >
      <table width="500" align="center" style="margin-top:30px" class="inputTable">       
        <tr>
          <th>型号编号：</th>
          <td><input readonly class="text" name="mobType.mobtypeid"  value="${mobType.mobtypeid}" maxlength=10 pattern="/^[a-z]{2}-\d{3,7}$/i" info="必须以两位字母开头，后跟分隔线，之后3到7位数字！" /></td>
        </tr>    
        <tr>
          <th>品牌：</th>
          <td>
            <select name="mobType.brand" class="text">
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand}"
                        <c:if test="${brand eq mobType.brand}">selected</c:if>
                    >${brand}</option>
                </c:forEach>
            </select>
          </td>
        </tr>  
        <tr>
          <th>型号名：</th>
          <td><input class="text" name="mobType.mobtypename"  value="${mobType.mobtypename}" required valType="email"/></td>
        </tr> 
        <tr>
          <th>进货价：</th>
          <td><input class="text" name="mobType.buyprice"  value="${mobType.buyprice}" valType="number" range="1-10"/></td>
        </tr> 
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="mobType.remark" style="width:300px;height:46px" validate="repass"/>${mobType.remark}</textarea></td>
        </tr>       
      </table>
      
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="left">返利价格设置</td></tr>
      </table>
      <table border="0" width="500" align="center" style="margin-top:2px" class="table" id="tblPrice">
        <tr>
            <th width="160">返利类别</th>
            <th width="160">返利价格</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${mobBonusList}" var="bonus">
            <tr lineId="${bonus.bonusTypeId}">
                <td>${bonus.typeName}</td>
                <td><fmt:formatNumber value="${bonus.money}" pattern="0.00" /></td>
                <td><a href="#" onclick="delPrice('${bonus.bonusTypeId}')">删除</a></td>
            </tr>
        </c:forEach>
      </table>
      <table border="0" width="500" align="center" style="margin-top:0px" class="table">
         <tr>
            <th width="160">
                <select id="bonusType" class="text" style="width:100px">
                    <c:forEach items="${bonusTypeList}" var="btype">
                        <option value="${btype.bonustypeid}:${btype.typename}">${btype.typename}</option>
                    </c:forEach>
                </select>
            </th>
            <th width="160" >
                <input class="text" id="bonusPrice" style="width:60px"/>
            </th>
            <th>
                <input class="btn ok" type="button" value="加入" onclick="addBonus();"/>
            </th>
         </tr>
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="button" class="btn ok" value="确定" onclick="submitType(this.form);"/>
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/mobType_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
