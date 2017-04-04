<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>忘记密码- 热泵在线</title>
<style>
body, html {
	padding: 0;
	margin: 0;
	height: 100%;
	text-align: center;
	moz-user-select: -moz-none;
	-moz-user-select: none;
	-o-user-select: none;
	-khtml-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	user-select: none;
	overflow: hidden;
}

.login-box {
	width: 420px;
	height: 240px;
	margin: auto;
}

h1 {
	font-size: 1em;
	margin: 0.67em 0;
	line-height: 2.8em;
}

input {
	width: 278px;
	height: 18px;
	margin-bottom: 10px;
	outline: none;
	padding: 10px;
	font-size: 13px;
	color: #fff;
	border-top: 1px solid #312E3D;
	border-left: 1px solid #312E3D;
	border-right: 1px solid #312E3D;
	border-bottom: 1px solid #56536A;
	border-radius: 4px;
	background-color: #2D2D3F;
}

.but {
	width: 300px;
	min-height: 20px;
	display: block;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 9px 14px;
	font-size: 15px;
	line-height: normal;
	border-radius: 5px;
	margin: auto;
}

.send-code-but {
	width: 124px;
	min-height: 20px;
	background-color: orange;
	border: 1px solid orange;
	color: #fff;
	padding: 9px 14px;
	font-size: 15px;
	line-height: normal;
	border-radius: 5px;
	margin: auto;
}
p{width: 278px;margin: auto;font-size: 12px;line-height: 24px;text-align: left;}
</style>
</head>
<body>
	<div class="login-box">
		<h1>热泵在线 - 重设密码</h1>
		<form method="post" action="login-action.jspx">
			<input type="text" required="required" placeholder="手机号" name="phoneNo" value=""/>
			<input type="text" style="width: 150px" required="required" placeholder="验证码" name="code" value=""/> <button type="button" id="sendCodeBtn" class="send-code-but">获取验证码</button>
			<input type="password" required="required" placeholder="密码" name="password" value=""/>
			<input type="password" required="required" placeholder="重复密码" name="rpassword" value=""/>
			<button class="but" type="submit">重设密码</button>
			<p><span id="messageBox" style="color:red">${message }</span> &nbsp; <a style="float: right;" href="login.jspx">返回登录</a></p>
		</form>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var sending = false;
			var def = "获取验证码";
			var timStr = function(s){
				return  s + "s重新获取";
			};
			var tim = 60;
			var timer = null;
			$("#sendCodeBtn").on("click", function(){
				if(sending) {
					return;
				}
				sending = true;
				var _this = this;
				if(timer) {
					window.clearInterval(timer);
				}
				timer = window.setInterval(function(){
					if(tim == 0) {
						$(_this).text(def);
						window.clearInterval(timer);
						sending = false;
					} else {
						$(_this).text(timStr(--tim));
					}
				}, 1000);
				$.get("send-vcode.jspx?phoneNo=" + $("input[name=phoneNo]").val(), function(data){
					if(!data.success) {
						$("#messageBox").html(data.message);
						window.clearInterval(timer);
						sending = false;
					} else {
						$("#messageBox").html("发送成功");
					}
				}, "json");
			})
		})
	</script>
</body>
</html>