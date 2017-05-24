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

<title>登录页面</title>

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
	font-family: "黑体";
	font-size: 16px;
	margin: 0px auto;
}

#div1 {
	align: center;
	background-image: url("images/09.jpg");
	width: 1000px;
	height: 666px
}

table {
	padding-left: 30px;
	padding-top: 160px
}

th {
	font-size: 26px;
	color: #3366ff
}

tr {
	height: 70
}
</style>
</head>
<body>
	<form action="login" method="post">
		<div id="div1">
			<table>
				<tr>
					<td>账号</td>
					<td><input type="text" name="account" value="${requestScope.user.account }"
						style="width:280px;height:50px;border-color:#a2ffff;" /></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password" value="${requestScope.user.password }"
						style="width:280px;height:50px;border-color:#a2ffff;" /></td>
				</tr>
				<tr><td>${requestScope.mes }</td></tr>
				<tr align="center">
					<td colspan="2">
					<input type="submit" value="登录"/>
					<a href="#">忘记密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="pages/login/register.jsp">注 册</a></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
