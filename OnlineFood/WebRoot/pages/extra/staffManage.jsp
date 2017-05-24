<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">

		<title>二十、配送员管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
tr {height: 40px;}

* {font-family: "微软雅黑";font-size:16px;margin: 0px auto;}

body {padding-top: 30px;}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 125px;height: 30px;color: #ffffff;
	}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
#div1{align:center;border:1px solid #dddddd;width:800px;margin-bottom: 30px}
#div2{margin-top: 30px;margin-bottom: 30px}
th{font-size:20px;}
table{margin-top: 30px}
</style>

	</head>

	<body>
	<form>
	<div id="div1">
		<table>
		<tr><th colspan="5">配 送 员 管 理 表</th></tr>
			<tr>
				<td width="50px">序号</td>
				<td width="100px">配送员姓名</td>
				<td width="120px">配送员手机号</td>
				<td width="100px">配送区域</td>
			</tr>
			<tr>
				<td>1</td>
				<td>…</td>
				<td>…</td>
				<td>。。。</td>
			</tr>
		</table>
		<div id="div2">
		<p align="center"><a href="pages/extra/staffRegister.jsp"><input type="button" value="新   增" class="aa"/></a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a><input type="button" value="返   回" class="aa"/></a></p>
		</div>
		</div>
		<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
		</form>
	</body>

</html>