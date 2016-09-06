<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <%@ include file="/WEB-INF/jsp/include/datepicker.jsp" %>  
    <script type="text/javascript">
        $().ready(function() {
            $("input[name=startDate]").datepicker();
            $("input[name=endDate]").datepicker();
            
            $("select[name=supTypeId]").relate($("select[name=supplierid]"));
            $("select[name=brand]").relate($("select[name=mobtypeid]"));
            
        });
    </script>
  </head>
 
  <body>
    <my:navigation text="供应商业务 >>　手机入库 >> 入库单列表列表" percent="90"/>
    <form action="mobStockIn_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>开始时间</td>
          <td><input class="text" style="width:80px" name="startDate" value="${my:fmtDate(startDate)}" readonly/></td>
          <td>结束时间</td>
          <td><input class="text" style="width:80px" name="endDate" value="${my:fmtDate(endDate)}" readonly/></td>
          <td colspan="5"></td>
          <td rowspan="2" align="right">
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加入库"
             onclick="location='mobStockIn_toAdd.do'"/>
          </td>
       </tr>
       <tr>
          <td>供应商类别</td>
          <td>
          <select name="supTypeId" class="text" style="width:80px">
            <option value="">--不限--</option>
            <c:forEach items="${supTypeList}" var="supType">
                <option value="${supType.suptypeid}">${supType.suptypename}</option>
            </c:forEach>
          </select>
          </td>
          <td>供应商</td>
          <td>
            <select name="supplierid" class="text" style="width:80px">
            <option value="">--不限--</option>
            <c:forEach items="${supList}" var="sup">
                <option value="${sup.supType.suptypeid}.${sup.supid}" >${sup.supname}</option>
            </c:forEach>
          </select>
          </td>
          <td>品牌</td>
          <td>
          <select name="brand" class="text" style="width:80px">
            <option value="">--不限--</option>
            <c:forEach items="${brandList}" var="brand">
                <option value="${brand}">${brand}</option>
            </c:forEach>
          </select>
          </td>
          <td>手机型号</td>
          <td>
           <select name="mobtypeid" class="text" style="width:80px">
            <option value="">--不限--</option>
            <c:forEach items="${mobTypeList}" var="mobType">
                <option value="${mobType.brand}.${mobType.mobtypeid}">${mobType.mobtypename}</option>
            </c:forEach>
          </select>     
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>单据号码</th>
        <th>供应商</th>
        <th>机型</th>
        <th>颜色</th>
        <th>进价</th>
        <th>数量</th>
        <th>总金额</th>
        <th>录入人</th>
        <th>审核人</th>
        <th>状态</th>
        <th>备注</th>
        <th>机构</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${pagination.dataList}" var="msi">
        <tr>
          <td>${msi.invoiceid}</td>
          <td>${msi.supName }</td>
          <td>${msi.mobTypeName}</td>                   
          <td>${msi.color}</td>
          <td>${msi.buyprice}</td>
          <td>${msi.amount}</td>
          <td>${msi.totalmoney}</td>
          <td>${msi.inputUserName}</td>
          <td>${msi.checkUserName}</td>
          <td>${msi.statName}</td>
          <td>${msi.remark}</td>
          <td>${msi.orgName}</td>
          <td>          
              <a href="#">详情</a>
              <c:choose>
              <c:when test="${msi.status eq 0}">
                  <a href="#">修改</a>              
                  <a href="#">删除</a>
                  <my:privShow action="mobStockIn_check.do">
                    <a href="mobStockIn_check.do?invoiceid=${msi.invoiceid}">审核</a>
                  </my:privShow>
              </c:when>
              <c:otherwise>
                 <span style="color:gray">修改</span>
                 <span style="color:gray">删除</span>
                 <my:privShow action="mobStockIn_check.do">
                    <span style="color:gray">审核</span>
                  </my:privShow>
              </c:otherwise>
              </c:choose>   
              
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
