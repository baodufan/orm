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

<title>二十二、用户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
a {
	text-decoration: none;
}

#bot {
	padding-top: 180px;
}
</style>
</head>

<body>
<div align="center">
	<div
		style="width:600px;height:26px;background-image: url(images/car_menu.jpg);">
		<p style="padding:4px;padding-left: 80px;">
			<a href="">操作员</a>| <a href="">普通用户</a>
		</p>
	</div>
	<div>
		<table style="width:600px;border: 1px solid black;margin:15px auto;">
			<tr>
				<td>用户编号</td>
			</tr>
			<tr>
				<td>用户姓名</td>
			</tr>
			<tr>
				<td><a href="pages/backstage/orderQuery.jsp"
					style="padding-left: 440px;">查看用户信息</a></td>
			</tr>
		</table>
	</div>
	<div id="">
		<a href="pages/backstage/addOperator.jsp"><input type="button"
			value="新增" /></a> <a><input type="button" value="返回" /></a>
	</div>
	</div>
</body>
</html>