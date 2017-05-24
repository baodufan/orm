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

<title>八、注册页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
#geren {
	font-size: 20px;
}

tr {
	height: 40px;
}

* {
	font-family: "微软雅黑";
	font-size: 14px;
	margin: 0px auto;
}

.text_in {
	width: 200px;
	height: 30px;
	border-color: #a2ffff;
}

body {
	padding-top: 10px;
}

#div1 {
	border: 1px #d8f8fe solid;
	background-color: #f0fdff;
	width: 800px;
	margin-bottom: 20px;
	margin-top: 30px
}

.aa {
	border: 1px solid;
	font-size: 16;
	background-color: #60afff;
	font-weight: bold;
	width: 125px;
	height: 30px;
	color: #ffffff;
}

#bb {
	background-image: url(images/14.jpg);
	width: 800px;
	padding-top: 90px;
	text-align: center;
	margin-bottom: 20px;
	font-size: 16px;
	color: #ff870f
}
</style>
<script type="text/javascript">
	function affirm() {
		var pwd1 = document.form1.pwd1.value.trim();
		var pwd2 = document.form1.pwd2.value.trim();
		if (pwd1 != pwd2) {
			document.form1.error.innertext = "两次输入的密码不一致";
			return false;
		}
		return true;
	}
	function user() {
		var rule = "^\\w{4,8}$";
		var account = document.form1.account.value.trim();
		if (account.length == 0) {
			alert("用户名不能为空");
			document.form1.account.focus();
			return false;
		}
		if (!(account.match(rule))) {
			alert("用户名不合法");
			document.form1.account.select();
			return false;
		}
		return true;
	}
	function pwd() {
		var rule = "^\\w{4,8}$";
		var password = document.form1.password.value.trim();
		if (password.length == 0) {
			alert("密码不能为空");
			document.form1.password.focus();
			return false;
		}
		if (!(password.match(rule))) {
			alert("密码不合法，请重新输入");
			document.form1.password.select();
			return false();
		}
		return true;
	}
	function name() {
		var username = document.form1.username.value.trim();
		if (username.length == 0) {
			alert("姓名不能为空");
			document.form1.username.focus();
			return false;
		}
		return true;
	}
	function phone() {
		var rule = "^\\d{11}$";
		var userphone = document.form1.userphone.value.trim();
		if (userphone.length = 0) {
			alert("手机号码不能为空");
			document.form1.userphone.focus();
			return false;
		}
		if (!(phone.match(rule))) {
			alert("手机号码格式不正确");
			document.form1.phone.select();
			return false;
		}
		return true;
	}
	function checkall() {
		if (user() && pwd() && name() && phone()) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<form name="form1" action="login?method=registerUser" method="post" onsubmit="return checkall()">
		<div id="div1">
			<table width="300px" cellspacing="0px">

				<tr>
					<td colspan="2" align="center" height="50" id="geren">个人信息填写</td>
				</tr>
				<tr>
					<td>账号</td>
					<td><input type="text" class="text_in" name="account" /><span>账号长度为4-8位</span></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" class="text_in" name="password" /><span>密码长度为4-8位</span></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" class="text_in" name="pwd2"
						onblur="affirm()" />
						<div name="error" style="color:red;"></div></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" class="text_in" name="username"/></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><lable><input type = "radio" name="sex" value="男" checked="checked"/>男</lable>
					<lable><input type = "radio" name="sex" value="女"/>女</lable></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" class="text_in" name="userphone"></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" class="text_in" name="address"></td>
				</tr>
				<tr>
					<td colspan="2" align="left" height="70px"><input
						type="submit" value="注    册" >&nbsp;&nbsp;<input
						type="button" value="返    回" ></td>
				</tr>

			</table>
		</div>
		<div>
			<p id="bb">Copyright © 2017 W161001J第一组所有</p>
		</div>
	</form>
</body>
</html>
