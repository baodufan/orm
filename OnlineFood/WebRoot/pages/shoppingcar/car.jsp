<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>三、购物车页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
			span {
				font-size: 16px;
				font-weight: bolder;
			}
			
			#text1 {
				color: blue;
			}
			
			.t {
				text-align: center;
			}
			
			a {
				text-decoration: none;
			}
			
			.t1 {
				border: 0px;
				text-align: center;
			}
			
			#bot {
				padding-top: 180px;
			}
		</style>
		<script type="text/javascript">
			function add() {
				var num = parseInt(document.getElementById("te").value);
				num=num+1;
				document.getElementById("te").value=num;
			}

			function subtract() {
				var num = parseInt(document.getElementById("te").value);
				num=num-1;
				document.getElementById("te").value=num;
			}
		</script>
		<script type="text/javascript" src="pages/shoppingcar/update.js"></script>
	</head>

	<body align="center">
		<div align="center">
			<img src="images/u=648553422,3345149513&fm=23&gp=0.jpg">
		</div>
		<div>
			<img src="images/shoppingcart.png">&nbsp;<span>购物车</span>
		</div>
		<div style="width:600px;height:26px;margin:0px auto;background-image: url(images/car_menu.jpg);">
			<p style="padding:4px;">
				<span id="text1">导航条</span>:&nbsp;
				<a href="">网上订餐</a>|
				<a href="">订餐帮助</a>|
				<a href="">关于我们</a>&nbsp;&nbsp;
				<a href="">未登录</a>|
				<a href="">注册</a>
			</p>
		</div>
		<div align="center">
			<table width="600px" border="1px" cellspacing="0px">
				<tr>
					<td class="t">序号</td>
					<td class="t">图片</td>
					<td class="t">菜品</td>
					<td class="t">价格</td>
					<td class="t">数量</td>
					<td class="t">小计</td>
					<td class="t">操作</td>
				</tr>
				<c:forEach items="${sessionScope.ShopCart.getCartitem() }" var="cartitem">
				<tr>
					<td class="t">${cartitem.item.itemId }</td>
					<td class="t">${cartitem.item.image }</td>
					<td class="t">${cartitem.item.itemName }</td>
					<td class="t">${cartitem.item.price }</td>
					<td class="t"><input type="button" value="+" onclick="add()"><input type="text" size="2" id="te" value="${cartitem.num }" onchange="updateNum(${cartitem.item.itemId},this,${cartitem.num})">
					<input type="button" value="-" onclick="subtract()"></td>
					<td>${cartitem.getSubtotal() }</td>
					<td><a href="<c:url value='/Shopcart?method=close&itemId=${cartitem.item.itemId }'/>">删除商品</a></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="7" style="font-size:20px;color:red;">总计:${sessionScope.ShopCart.getTotal() }</td>
				</tr>
				<tr>
					<td class="t1" colspan="5">
						<a href="index.jsp">继续订餐</a>
						<a href="<c:url value='/Shopcart?method=chear'/>">清空购物车</a>
						<a href="pages/shoppingcar/orderConfirm.jsp">提交订单</a>
					</td>
				</tr>
			</table>
		</div>
		<div style="width: 600px;height: 230px;background-image: url(images/09454I259-6.jpg);margin: 0px auto;">
			<p id="bot" align="center">Copyright © 2017 W161001J第一组所有</p>
		</div>
	</body>
</html>
