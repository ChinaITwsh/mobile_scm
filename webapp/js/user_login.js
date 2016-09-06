$().ready(function(){
	//处理提交按纽图片
	$("#submitBtn").mouseover(function(){
		this.src = "images/login_submitBtn2.gif";
	}).mouseout(function(){
		this.src = "images/login_submitBtn1.gif";
	}).click(function() {
		submitForm();
	});
	
	//定位验证码图片框
	var oVCode = $("input[name=vcode]");
	var pos = getAbsPosition(oVCode);
	
	var left = pos.left;
	var top = pos.top + oVCode[0].offsetHeight + 2;
	
	$("div.validateCodeDiv").css("top", top).css("left", left);
	
	//设置验证码图片框显隐
	showHideVcodeImg();
	
	//绑定验证码图片框单击事件实现更换验证码
	$("div.validateCodeDiv").click(function(event) {
		changeCode();
		event.stopPropagation();
	});
});

function submitForm() {
	var oAcc = $("input[name=account]");
	if(oAcc.val().trim().length == 0) {
		$("#messBox").html("请输入用户名");
		oAcc.focus();
		return;
	}
	var oPass = $("input[name=passwd]");
	if(oPass.val().trim().length == 0) {
		$("#messBox").html("请输入密码");
		oPass.focus();
		return;
	}
	var oVcode = $("input[name=vcode]");
	if(oVcode.val().trim().length == 0) {
		$("#messBox").html("请输入验证码");
		oVcode.focus();
		return;
	}
	
	var url = "userLogin.do";
	var para = getFormPara($("form[name=frm1]"));
	
	$.get(url, para, function(data) {
		if (data == "vcode error") {
			$("#messBox").html("验证码错误");
		} else if (data == "userpass error") {
			$("#messBox").html("用户名或密码错误");
		} else if (data == "sys error") {
			$("#messBox").html("系统发生错误，请重试");	
		} else if (data == "db error") {
			$("#messBox").html("数据库发生错误");	
		} else if (data == "success"){
			location = "home.do";
		} else {
			$("#messBox").html("发生错误");			
		}
		
		changeCode();
	});
}

function showHideVcodeImg() {
	$("input[name=account], input[name=passwd], #submitBtn").click(function(){
		$("div.validateCodeDiv").css("display", "none");
	}).focus(function() {
		$("div.validateCodeDiv").css("display", "none");
	});
	
	$("input[name=vcode]").click(function(event) {
		$("div.validateCodeDiv").css("display", "block");
		event.stopPropagation();
	}).focus(function() {
		$("div.validateCodeDiv").css("display", "block");
	});
	
	$(document).click(function() {
		$("div.validateCodeDiv").css("display", "none");
	})
}

function changeCode() {
	$("#imgVcode").attr("src", "servlet/getVcode?ts=" + new Date().getTime());
}
