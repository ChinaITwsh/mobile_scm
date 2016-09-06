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
         $("input[name=date]").datepicker();
        });
    </script>
  </head>
 
  <body>
    <my:navigation text="报表业务 >>　销售日报表" percent="90"/>
    <form action="mobReturn_list.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td>日期</td>
          <td><input class="text" style="width:180px" name="date" readonly/></td>
          <td><button>查询</button></td>
       </tr>
       </table>
    </form>
    <table class="table"  width="90%" align="center" >      
      <tr>
        <th>部门</th>
        <th>机型</th>
        <th>数量</th>    
        <th>平均售价</th>    
        <th>销售总额</th>
        <th>总成本</th>        
        <th>毛利</th>
      </tr>
      <tr>
        <td rowspan="3">一分店</td>
        <td>S808</td>
        <td>22</td>
        <td>1000</td>
        <td>22000</td>
        <td>19000</td>
        <td>3000</td>
      </tr>
      <tr>
        <td>A8</td>
        <td>26</td>
        <td>1200</td>
        <td>31600</td>
        <td>25000</td>
        <td>6600</td>
      </tr>
      <tr>
        <td>E309</td>
        <td>8</td>
        <td>5000</td>
        <td>40000</td>
        <td>31000</td>
        <td>9000</td>
      </tr>
      <tr>
        <td colspan="2" style="text-align:right">小计</td>
        <td>56</td>
        <td>1200</td>
        <td>3160000</td>
        <td>250000</td>
        <td>66000</td>
      </tr>
      <tr>
        <td rowspan="3">二分店</td>
        <td>S808</td>
        <td>22</td>
        <td>1000</td>
        <td>22000</td>
        <td>19000</td>
        <td>3000</td>
      </tr>
      <tr>
        <td>A8</td>
        <td>26</td>
        <td>1200</td>
        <td>31600</td>
        <td>25000</td>
        <td>6600</td>
      </tr>
      <tr>
        <td>E309</td>
        <td>8</td>
        <td>5000</td>
        <td>40000</td>
        <td>31000</td>
        <td>9000</td>
      </tr>
      <tr>
        <td colspan="2" style="text-align:right">小计</td>
        <td>56</td>
        <td>1200</td>
        <td>3160000</td>
        <td>250000</td>
        <td>66000</td>
      </tr>
      <tr>
        <td colspan="2" style="text-align:right;font-weight:bold">总计</td>
        <td><b>56</b></td>
        <td><b>1200</b></td>
        <td><b>3160000</b></td>
        <td><b>250000</b></td>
        <td><b>66000</b></td>
      </tr>
    </table>
  </body>
</html>
