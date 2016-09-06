<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript">
$().ready(function() {
/*
  var els = document.forms["form1"].elements;          
  var len = els.length;
  var para = {};
  for (var i = 0; i < len; i++) {
  var e = document.forms["form1"].elements[i];  
  
  if (para[e.name] == undefined) {
    para[e.name] = e.value.trim();  
  } else {
    var curVal = para[e.name];
    if (curVal instanceof Array) {
      curVal.push(e.value);
    } else {
      para[e.name] = [];
      para[e.name].push(curVal);
      para[e.name].push(e.value);
    }
  }
  }
  */
  
});

$.fn.extend({
  ajaxSubmit: function() {
  
    var len = this[0].elements.length;
    var para = {};
    for (var i = 0; i < len; i++) {
      var e = document.forms["form1"].elements[i];  
      
      if (para[e.name] == undefined) {
        para[e.name] = e.value.trim();  
      } else {
        var curVal = para[e.name];
        if (curVal instanceof Array) {
          curVal.push(e.value);
        } else {
          para[e.name] = [];
          para[e.name].push(curVal);
          para[e.name].push(e.value);
        }
      }
   }
   
   var url = this[0].action;
   alert(url + ", " + para);
   
   $.post(url, para, function() {
    alert("ok");
   });
  }
});
</script>
  </head>

  <body>
    <form id="form1" name="form1" method="post"
      action="servlet/TestServlet" onsubmit="return false;">
      <input type="text" name="textfield" id="textfield" />
      <input type="text" name="t2" />
      <input type="password" name="t3" />
      <input type="radio" name="t4" />
      <input type="radio" name="t4" />
      <textarea name="t8"></textarea>
      <input type="checkbox" name="t5" value="a"/>
      <input type="checkbox" name="t5" value="b"/>
      <input type="checkbox" name="t5" value="c"/>
      <input type="submit" value="submit" onclick='$("#form1").ajaxSubmit();'/>
    </form>
  </body>
</html>
