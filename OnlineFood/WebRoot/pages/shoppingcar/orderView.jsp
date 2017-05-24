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

<title>六、订单查看页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css"> tr{height: 30px;} *{margin:0px
auto;background-color: #ffcccc;} body {padding-top: 70px;}

</style>
	</head>
<body>
	<form>
		<table width="500px">
			<tr>
				<th colspan="2" align="left">订单明细</th>
			</tr>
			<tr>
				<td>菜名</td>
				<td>数量</td>
				<td>价格:</td>
			</tr>
			<c:forEach items="${requestScope.order.orderitems }" var="item">
			<tr>
			<td>${item.item.itemName }</td>
			<td>${item.count }</td>
			<td>${item.item.price }</td>
			</tr>
			</c:forEach>
			<tr>
				<td>配送费:10元</td>
			</tr>
			<tr>
				<td>优惠券编号：${requestScope.order.discount.discountId }</td>
			</tr>
			<tr>
				<td>总计：${requestScope.order.total }</td>
			</tr>
			<tr>
				<td>优惠:${requestScope.order.discount.num }</td>
			</tr>
			<tr>
				<td>实付:${requestScope.order.total-requestScope.order.discount.num }</td>
			</tr>
		</table>
		<table width="500">
			<tr>
				<th colspan="2" align="left">配送信息</th>
			</tr>
			<tr>
				<td>配送地址:${requestScope.order.address }</td>
			</tr>
			<tr>
				<td>收货人电话:${requestScope.order.phone }</td>
			</tr>
		</table>
		<table width="500">
			<tr>
				<th align="left">订单编号:${requestScope.order.orderId }</th>
			</tr>
			<tr>
				<td>下单时间:${requestScope.order.ordertime }</td>
			</tr>
			<tr>
				<td>订单状态:${requestScope.order.orderStatus }</td>
			</tr>
			<tr>
				<td>支付方式:${requestScope.order.payWay }</td>
			</tr>
			<tr>
				<td>订单留言:${requestScope.order.message }</td>
			</tr>
			<tr>
				<td>订单评价:用户暂未评论！</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="返回"></td>
			</tr>
		</table>
	</form>
</body>
</html>
