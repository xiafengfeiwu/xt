<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>热泵在线</title>
	<style>
		body,html{padding:0;margin:0;height:100%;text-align:center;overflow:hidden;moz-user-select: -moz-none;-moz-user-select: none;-o-user-select:none;-khtml-user-select:none;-webkit-user-select:none;-ms-user-select:none;user-select:none}.main-bg{position:absolute;left:0;top:0;width:100%;height:100%;overflow:hidden;background:#fff none no-repeat center center;background-image:url(assets/img/main-bg.jpg);background-size:cover}.main-bg-color{position:absolute;left:0;top:0;width:100%;height:100%;background-color:rgba(0,0,0,.5)}.img-box{width:680px;height:180px;margin:auto;padding-top:8%}.img-box img{width:100%}@media screen and (max-width:800px){.img-box{width:90%}}.login-btn{width:180px;height:46px;border-radius:4px;background:rgba(90,180,80,.9);color:#fff;line-height:46px;font-size:14px;position:absolute;left:50%;top:60%;margin:-28px -90px;cursor: pointer}.login-btn:hover{background:rgba(255,255,255,.6);color:#000;}.hf{position:fixed;width:100%;height:60px;line-height:60px}.header{top:0;background-color:rgba(0,0,0,.3)}.footer{bottom:0;background-color:rgba(0,0,0,.1);color:#aaa;font-size:12px}@media screen and (max-width:600px){.header{display:none}}
	</style>
</head>
<body>
	<div class="main-bg">
		<div class="hf header"></div>
		<div class="main-bg-color">
		  	<div class="img-box"><img src="assets/img/main-title.png"></div>
		  	<div class="login-btn">登 录</div>
		</div>
		<div class="hf footer">热泵在线 版权所有 &copy; 2017 中电华源   &nbsp; 技术支持：夏风飞舞</div>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/layer/3.0/layer.min.js"></script>
	<script type="text/javascript">
		$(".login-btn").on("click", function(){
			layer.open({
				type: 2,
				title: 0,
				closeBtn: 0,
				skin: 'layui-layer-rim',
				area: ['420px', '360px'],
				resize: 0,
				shadeClose: 1,
				scrollbar: 0,
				content: 'login.jspx'
			});
		})
	</script>
</body>
</html>