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

<title>十一、网站后台页面</title>

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
#div2,#div1{align:center}
</style>
	</head>
<body>
	<div align="center">
		<img src="images/u=648553422,3345149513&fm=23&gp=0.jpg">
	</div>
	<div align="center" align="center" id="div1">
		<div
			style="width:600px;height:26px;background-image: url(images/car_menu.jpg);">
			<p style="padding:4px;padding-left: 80px;">
				<span id="text1">导航条</span>:&nbsp; <a href="">网上订餐</a>| <a href="">订餐帮助</a>|
				<a href="">关于我们</a>&nbsp;&nbsp; <a href="">未登录</a>| <a href="">注册</a>
			</p>
		</div>
		<div style="margin-top:15px ;" id="div2">
			<table>
				<tr>
					<td><a href="pages/backstage/orderStatus.jsp"><input type="button" value="查看订单"
							style="width:500px;height:30px;"></a></td>
				</tr>
				<tr>
					<td><a href="pages/backstage/menuView.jsp"><input type="button" value="查看菜单"
							style="width:500px;height:30px;"></a></td>
				</tr>
				<tr>
					<td><a href="pages/backstage/revenueCalculate.jsp"><input type="button" value="收益统计"
							style="width:500px;height:30px;"></a></td>
				</tr>
				<tr>
					<td><a href="pages/extra/discountView.jsp"><input type="button" value="优惠券设置"
							style="width:500px;height:30px;"></a></td>
				</tr>
				<tr>
					<td><a href="pages/extra/staffManage.jsp"><input type="button" value="配送员管理"
							style="width:500px;height:30px;"></a></td>
				</tr>
				<tr>
					<td><a href="pages/backstage/userList.jsp"><input type="button" value="其他用户管理"
							style="width:500px;height:30px;"></a></td>
				</tr>
			</table>
		</div>
		</div>
		<div
			style="width: 600px;height: 230px;background-image: url(images/09454I259-6.jpg);margin: 0px auto;">
			<p id="bot" align="center">Copyright © 2017 W161001J第一组所有</p>
		</div>
</body>
</html>
