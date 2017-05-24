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

<title>十二、订单列表状态</title>

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
#table1{background-color: #f4f4f4}
#bot {
	padding-top: 180px;
}
#qx{padding-right:80px}
.a{margin-left:30px}
#p{align:center}
</style>
</head>
<body>
	<h2 align="center">订单列表</h2>
	<div align="center">
		<div
			style="width:600px;height:26px;background-image: url(images/car_menu.jpg);">
			<p style="padding:4px;padding-left: 80px;" id="p">
				<a href="" class="a">新订单</a> <a href="" class="a">已接受</a> <a href="" class="a">已配送</a>
				 <a href="" class="a">已完成</a> <a href="" class="a" id="qx">已取消</a>
			</p>
		</div>
		<div>
			<table style="width:600px;border: 1px solid black;margin:15px auto;" id="table1">
				<tr>
					<td>订单编号</td>
				</tr>
				<tr>
					<td>下单时间</td>
				</tr>
				<tr>
					<td>总价</td>
				</tr>
				<tr>
					<td><a href="pages/backstage/orderQuery.jsp" style="padding-left: 500px;">查看该订单</a></td>
				</tr>
			</table>
		</div>
		<div>
			<a href="" style="padding-left: 450px;"><input type="button"
				value="返    回" style="width: 120px;height: 28px;"></a>
		</div>
		</div>
		<div
			style="width: 600px;height: 230px;background-image: url(images/09454I259-6.jpg);margin: 0px auto;">
			<p id="bot" align="center">Copyright © 2017 W161001J第一组所有</p>
		</div>
		
</body>
</html>
