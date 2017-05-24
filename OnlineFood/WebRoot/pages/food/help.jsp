<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>九、帮助页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css"> 
#bot { padding-top: 180px; }
.dh{margin-left:20px}
#zc{margin-right: 50px}
</style>
	</head>
<body>
	<div align="center">
		<img src="images/u=648553422,3345149513&fm=23&gp=0.jpg">
	</div>
	<div id="div1" align="center">
		<div
			style="width:600px;height:26px;background-image: url(images/car_menu.jpg);">
			<p style="padding:4px;padding-left: 80px;">
				<span id="text1">导航条</span>:&nbsp; <a href="" class="dh">网上订餐</a><a href="" class="dh">订餐帮助</a>
				<a href="" class="dh">关于我们</a>&nbsp;&nbsp; <a href="" class="dh">未登录</a> <a href="" class="dh" id="zc">注册</a>
			</p>
		</div>
		<div></div>
		<div
			style="width: 600px;height: 230px;background-image: url(images/09454I259-6.jpg);margin: 0px auto;">
			<p id="bot" align="center">Copyright © 2017 W161001J第一组所有</p>
		</div>
		</div>
</body>
</html>
