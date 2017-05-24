<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<title>一、主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
div{
	padding: 10px auto;
	margin:5px auto;
}
a {
	text-decoration: none;
	color: black;
}

#bottom {
	background-image: url(images/77-1606151KAC29.png);
	width: 600px;
	height: 128px;
}

td {
	font-size: 12px;
}

#sel, #backstage, #space1 {
	display: none;
}

.right_login {
	float: right;
}
</style>
<script type="text/javascript">
	function changeop() {
		var op = document.getElementById("sel").value;
		switch (op) {
		case "个人信息":
			window.location.href = "pages/login/userInfo.jsp";
			return true;
			break;
		case "购物车":
			window.location.href = "pages/shoppingcar/car.jsp";
			return true;
			break;
		case "我的订单":
			window.location.href = "Order?method=myOrders";
			return true;
			break;
		case "退出账户":
			if (confirm("确定要退出么?")) {
				window.location.href = "login?method=removed";
				return true;
				break;
			}
		}
		return false;
	}
	function init(level) {
		if (level == "普通用户") {
			document.getElementById("sel").style.display = 'inline';
			document.getElementById("unlogin").style.display = 'none';
			if (level == '操作员' || level == '系统管理员') {
				document.getElementById("space1").style.display = 'inline';
				document.getElementById("backstage").style.display = 'inline';
			}
		} else {
			document.getElementById("unlogin").style.display = 'inline';
			document.getElementById("sel").style.display = 'none';
			document.getElementById("space1").style.display = 'none';
			document.getElementById("backstage").style.display = 'none';
		}
	}
</script>
</head>

<body onload="init('${user.level }')">
	<div align="center">
		<img src="images/u=648553422,3345149513&fm=23&gp=0.jpg">
	</div>
	<div id="div1" align="center">
		<div
			style="width:600px;height:26px;background-image: url(images/car_menu.jpg);">
			<p style="padding:4px;padding-left: 80px;">
				<a href="#">网上订餐</a>| <a href="pages/food/help.jsp">订餐帮助</a>| <a
					href="pages/food/webInfo.jsp">关于我们</a><span id="space1">|</span><a
					href="pages/backstage/backstage.jsp" id="backstage">网站后台</a>&nbsp;&nbsp;
				<span class="right_login"><a href="pages/login/loginIn.jsp"
					id="unlogin">未登录</a> <select id="sel" onchange="changeop()">
						<option>${user.username }</option>
						<option value="个人信息">个人信息</option>
						<option value="购物车">购物车</option>
						<option value="我的订单">我的订单</option>
						<option value="退出账户">退出账户</option>
				</select><a href="pages/login/register.jsp">注册</a></span>
			</p>
		</div>
		<div>
		<table style="margin:auto 40px;">
			<c:forEach items="${requestScope.pit.list }" begin="0"
				end="${requestScope.pit.list.size() }" step="1" var="item"
				varStatus="status">
				<c:if test="${status.count%3==1||status.first } ">
					<tr>
				</c:if>
				<td>
					<table>
						<tr>
							<td rowspan="4"><a href="Item?itemId=${item.itemId }"><img
									src="images/${item.image }" width="100px" height="100px"></a></td>
						</tr>
						<tr>
							<td>菜名：${item.itemName }</td>
						</tr>
						<tr>
							<td>价格:<span>${item.price }</span></td>
						</tr>
						<tr>
							<td>会员价:<span>${item.price*0.88 }</span></td>
						</tr>
					</table>
				</td>
				<c:if test="${(status.count%3==0)||status.last }">
					</tr>
				</c:if>
			</c:forEach>
		</table>
		</div>
		<center>
		<a href="<c:url value='/page?page=1'/>">首页</a>
		<c:if test="${requestScope.pit.page>1 }">
		<a href="<c:url value='/page?page=${requestScope.pit.page-1 }'/>">上一页</a>
		</c:if>
		<c:if test="${requestScope.pit.page<pit.pagetotal }">
		<a href="<c:url value='/page?page=${requestScope.pit.page+1 }'/>">下一页</a>
		</c:if>
		<a href="<c:url value='/page?page=${requestScope.pit.pagetotal }'/>">末页</a>
		</center>
	</div>
	<div id="bottom"></div>
</body>

</html>