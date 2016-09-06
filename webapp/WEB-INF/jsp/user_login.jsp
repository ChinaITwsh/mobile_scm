<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>${sysname}</title>  
    <style type="text/css">
      body {
         background-color:#2469ac;
         font-size: 12px;
         margin: 0;
      }
      table {
        font-size: 12px;
      }
      .container {
          width: 100%;
          height: 250px;
          background-image:url("images/login_back.jpg");    
          overflow: hidden;   
          position: absolute;
          left: 0px;
          top: 160px;
        }
        
       .leftLogo {
        position: absolute;
        top: 0;
        left: 0;
        width:571px;
        height: 250px;
        background-image:url("images/login_logo.png");
      }
      
      .loginFormDiv {
        position:absolute;
        top:0;
        left:490px;
         width: 298px;
        height:250px;        
        z-index:10;
         padding:0;
      }
      
      .loginTable {
        font-weight:bold;
      }
      
      .rightPic {
        position:absolute;
        top:0;
        left:800px;
        width:158px;
        height:250px;
        z-index:5px;
        background-image: url("images/login_pic.png");
      }
      
      .txt {
        border: 1px solid #999999;
        width: 100px;
        height: 21px;
        margin-left: 8px;
        font-size: 12px;
      }
      
        .validateCodeDiv {
        position: absolute;
        width: 160px;
        height: 80px;
        background-color:#f5f5f5;
        border: 1px solid black;
        z-index:15;
      }
    </style>
    <script type="text/javascript" src="js/common/jquery.js"></script>
    <script type="text/javascript" src="js/common/common.js"></script>
    <script type="text/javascript" src="js/user_login.js"></script>
  </head>
  
  <body>
    <div class="container">
      <div class="leftLogo"></div>
      <div class="loginFormDiv">
        <form name="frm1" onsubmit="return false;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="loginTable">
          <tr>
            <td height="92" colspan="3" align="center" valign="middle">
              <span style="color:red;font-weight:bold;" id="messBox"></span>
            </td>
          </tr>
          <tr>
            <td width="80" height="28" align="right" valign="middle">用户ID：</td>
            <td width="120" align="left" valign="middle"><input type="text" name="account" class="txt" /></td>
            <td rowspan="3" align="left" valign="middle">
              <img src="images/login_submitBtn1.gif" id="submitBtn" style="cursor:pointer"/>
            </td>
          </tr>
          <tr>
            <td height="28" align="right" valign="middle">密码：</td>
            <td align="left" valign="middle"><input type="password" name="passwd" class="txt" /></td>
          </tr>
          <tr>
            <td height="28" align="right" valign="middle">验证码：</td>
            <td align="left" valign="middle">
              <input type="text" name="vcode" class="txt" maxLength="4" />
            </td>
          </tr>
        </table>
        </form>
    </div>
    <div class="rightPic"></div>
    </div>
    
    <div class="validateCodeDiv"  style="cursor:pointer;display:none" onclick="changeCode();">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="60">
            <img src="servlet/getVcode" id="imgVcode"/>
          </td>
        </tr>
        <tr>
          <td align="center" valign="middle" height="20" style="color:blue">若看不清，点图片换一张</td>
        </tr>
      </table>
    </div>
  </body>
</html>
