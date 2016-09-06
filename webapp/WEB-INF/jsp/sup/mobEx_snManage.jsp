<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.beifeng.mobile_scm.system.entity.SysRole"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript">
        function modify(oldSn1) {
            $("input[name=oldsn1]").attr("readonly",true).val(oldSn1);
            //修改按钮名称 -- 修改串号
            //表单action, eidtSn
        }
    </script>   
  </head>
  
  <body>
    <my:navigation text="供应商业务 >>　换机串号管理" percent="90"/>
      <table width="90%" align="center" style="margin-top:30px" class="inputTable">    
        <tr><td>${mobExchange.invoiceid}</td><td>${mobExchange.supplierid}</td><td>${mobExchange.mobtypeid}</td><td>${mobExchange.amount}</td>
            <td>${mobExchange.unitprice}</td><td>${mobExchange.totalmoney}</td><td>${mobExchange.remark}</td><td><button>修改</button></td>
        </tr>
      </table>
      <table class="table" align="center" width="90%" style="margin-top:10px">
        <tr>
            <th>供应商</th>
            <th>机型</th>
            <th>原串号一</th>
            <th>新串号一</th>
            <th>原串号二</th>
            <th>新串号二</th>
            <th>原颜色</th>
            <th>新颜色</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${exchangeSnList}" var="sn">
            <td></td>
            <td></td>
            <td>${sn.oldsn1}</td>
            <td>${sn.newsn1}</td>
            <td>${sn.oldsn2}</td>
            <td>${sn.newsn2}</td>
            <td>${sn.oldcolor}</td>
            <td>${sn.newcolor}</td>
            <td>OK</td>
            <td>
                <c:if test="${empty sn.newsn1}">
                    <a href="modify('${sn.oldsn1}');">修改</a>
                </c:if>
                                    <a href="#">删除</a>
           </td>
        </c:forEach>
      </table>
      <form action="mobEx_addSn.do" method="post">
      <table class="table" align="center" width="90%" style="margin-top:10px">        
        <tr>
            <td>原串号</td>
            <td><input name="oldsn1"></td>
            <td>新串号一</td>
            <td><input name="newsn1"></td>
            <td>新串号二</td>
            <td><input name="newsn2"></td>
            <td>新颜色</td>
            <td>
                <select name="newcolor">
                    <c:forEach items="${colorList}" var="color">
                        <option value="${color}">${color}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="invoiceid" value="${mobExchange.invoiceid}" />
            </td>
            <td><input type="submit" value="新增串号 "/></td>
            <td><my:errInfo key="snNotExist" /></td>
        </tr>
      </table>
      </form>
  </body>
</html>
