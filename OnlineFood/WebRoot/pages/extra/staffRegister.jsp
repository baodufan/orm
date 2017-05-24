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

<title>二十一、新增操作页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
tr {height: 50px;}
* {font-family: "黑体";font-size:14px;margin: 0px auto;}

body {padding-top: 20px;}
table{margin-top: 30px}
#div1{border:1px #d8f8fe solid;background-color: #f0fdff;width:800px;margin-bottom:20px;margin-top: 20px}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 125px;height: 30px;color: #ffffff;}
th{font-size:20px;color:#60afff}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
 #div1{align:center;border:1px solid #dddddd;width:800px;margin-bottom: 30px}
</style>
</head>

<body>
     <form>
     <div id="div1">
	<table>
		<tr>
			<th colspan="2" align="center">新增操作员信息填写</th>
		</tr>
		<tr>
			<td>账号</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>手机号码</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" height="70px"><input type="submit" value="确 认 支 付" class="aa">
			&nbsp; <a href="#"><input type="button" value="返   回" class="aa"></a></td>
		</tr>
	</table>
	</div>
	<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
	</form>
</body>
</html>
