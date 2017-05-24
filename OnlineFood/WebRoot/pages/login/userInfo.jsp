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

<title>七.个人信息页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css"> tr{height: 30px;} *{margin:0px
auto;background-color: #ffcccc;} body {padding-top: 70px;} h3{height:
50px;}
</style>
	</head>
<body>

	<div>
		<img src="">
	</div>
	<form action="<c:url value='/login?id=${sessionScope.user.userid }'/>" method="post">
	<div>
		<h3 align="center">显示账号名</h3>
		<table width="300px" cellspacing="0px">
		<input type="hidden" name="method" value="amendUser"/>
			<tr>
				<td colspan="2">个人信息填写</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" value="${sessionScope.user.username }"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>手机号码</td>
				<td><input type="text" name="userphone" value="${sessionScope.user.userphone }"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="address" value="${sessionScope.user.address }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="70px"><input
					type="submit" value="保存">&nbsp;&nbsp;<input type="button"
					value="取消"></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>
