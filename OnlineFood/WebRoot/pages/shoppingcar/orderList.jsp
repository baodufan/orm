<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>五、订单列表页面</title>

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
	<h2 align="center">订单列表</h2>
	<div align="center">
		<div
			style="width:600px;height:26px;background-image: url(images/car_menu.jpg);">
		</div>
		<div>
			<table style="width:600px;border: 1px solid black;margin:15px auto;">
				<c:forEach items="${requestScope.listorder }" var="order">
				<tr>
					<td>订单编号:${order.orderId }</td>
				</tr>
				<tr>
					<td>下单时间:${order.ordertime }</td>
				</tr>
				<tr><td>订单状态：${order.orderStatus }</td></tr>
				<tr>
					<td>总价:${order.total }</td>
					<td><a href="Order?method=listOrder&orderId=${order.orderId }" style="padding-left: 440px;">查看该订单</a></td>
				<td><a href="Order?method=AbolishOrder&orderid=${order.orderId }">取消订单</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<a href="" style="padding-left: 440px;"><input type="button"
				value="返回" style="width: 150px;height: 28px;"></a>
		</div>
		<div
			style="width: 600px;height: 230px;background-image: url(images/09454I259-6.jpg);margin: 0px auto;">
			<p id="bot" align="center">Copyright © 2017 W161001J第一组所有</p>
		</div>
</body>
</html>
