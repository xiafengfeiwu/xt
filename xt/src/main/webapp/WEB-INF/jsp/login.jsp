<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录 - 热泵在线</title>
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
p{width: 278px;margin: auto;font-size: 12px;line-height: 24px;text-align: left;}
</style>
</head>
<body>
	<div class="login-box">
		<h1>热泵在线 - 登录</h1>
		<form method="post" action="login-action.jspx">
			<input type="text" required="required" placeholder="用户名" name="username" value="admin"/>
			<input type="password" required="required" placeholder="密码" name="password" value="123456"/>
			<button class="but" type="submit">登录</button>
			<p><span style="color:red">${message }</span> &nbsp; <a style="float: right;" href="javascript:void(0);">忘记密码？</a></p>
		</form>
	</div>
</body>
</html>