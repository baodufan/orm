<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">

		<title>二、菜品详细信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<style type="text/css">
			td {
				font-size: 12px;
			}
			
			span {
				color: red;
				font-weight: bolder;
			}
			
			#text1 {
				color: blue;
			}
      .dh{margin-left:20px}
		</style>
	</head>

	<body>
		<div align="center">
			<img src="images/u=648553422,3345149513&fm=23&gp=0.jpg">
		</div>
		<div style="width:600px;height:26px;margin:0px auto;background-image: url(images/car_menu.jpg);">
			<p style="padding:4px;">
				<span id="text1">导航条</span>:&nbsp;
				<a href="" class="dh">网上订餐</a>
				<a href="" class="dh">订餐帮助</a>
				<a href="" class="dh">关于我们</a>&nbsp;&nbsp;
				<a href="" class="dh">未登录</a>
				<a href="" class="dh">注册</a>
			</p>
		</div>
		<div style="border: 1px solid black;width: 600px;margin: 10px auto;">
			<table>
				<tr>
					<td width="280px">
						<img src="images/${sessionScope.Item.image }" width="250px" style="margin-top: 10px;">
					</td>
					<td width="280px">
						<table>
							<tr>
								<td>&nbsp;菜名:${sessionScope.Item.itemName }</td>
							</tr>
							<tr>
								<td>&nbsp;价格:<span>${sessionScope.Item.price }</span></td>
							</tr>
							<tr>
								<td>会员价:${sessionScope.Item.price*0.88 }</td>
							</tr>
							<tr>
								<td>&nbsp;类型:${sessionScope.Item.type }</td>
							</tr>
							<tr>
								<td>
									<a href="Shopcart?itemId=${sessionScope.Item.itemId }"><img src="images/buy_cn.gif"></a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	
		<div style="background-image: url(images/77-1606151KAC29.png);width:600px;height: 128px;margin: 0px auto;">
		</div>
	
	</body>

</html>