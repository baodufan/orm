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

<title>四.订单确认，填写信息页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	margin: 0px auto;
	background-color: #ffcccc;
}

tr {
	height: 30px;
}

#aa {
	background-image: url("02.png");
	width: 556px;
	padding-top: 90px;
	text-align: center;
	margin-bottom: 20px;
}

body {
	padding-top: 70px;
	padding-bottom: 30px;
}
</style>
</head>
<body>
	<form action="Order">

		<div align="center">
			<img src="01.jpg" width="534px<strong></strong>" height="334px">
		</div>
		<div>
			<table cellspacing="0px" width="400px" background-color:#ccffff>
				<tr>
					<td colspan="2" align="center">订单消息填写</td>
				</tr>
				<tr>
					<td>收货人</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>收发地址</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>配送方式</td>
					<td><label><input type="radio" name="ps" value="送货上门"
							checked>送货上门</label> <label><input type="radio" name="ps"
							value="自取">自取</label></td>
				</tr>
				<tr>
					<td>优惠券选择</td>
					<td><label><input type="radio" name="discountId" value="2"
							checked>10元</label> <label><input type="radio" name=""discountId""
							value="3">30元</label><label><input type="radio" name=""discountId""
							value="4">50元</label></td>
				</tr>
				<tr>
					<td>支付方式</td>
					<td><label><input type="radio" name="payWay" value="网上支付"
							checked>网上支付</label> <label><input type="radio" name="payWay"
							value="货到付款">货到付款</label></td>
				</tr>
				<tr>
					<td>订单留言</td>
					<td><input type="text" name="message"></td>
				</tr>
				<tr>
					<td colspan="2" align="center" height="80px"><input
						type="submit" value="确认支付">&nbsp;<a href="#"><input
							type="button" value="返回"></a></td>
				</tr>
			</table>
		</div>
		<div>
			<p id="aa">Copyright © 2017 W161001J第一组所有</p>
		</div>
	</form>
</body>
</html>
