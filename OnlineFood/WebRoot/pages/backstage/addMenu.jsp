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

<title>十五、新增菜品页面</title>

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

* {font-family: "黑体";font-size:14px;margin: 0px auto;}

body {padding-top: 10px;}
th{font-size:16px;color:#818181}
#div1{border:1px #d8f8fe solid;background-color: #f0fdff;width:800px;margin-bottom:20px;margin-top: 30px}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 110px;height: 30px;color: #ffffff;
	}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
</style>
</head>

<body>
<form >
<div id="div1">
	<table>
	<tr>
	<th colspan="2">新 增 菜 品</th>
	</tr>
		<tr>
			<td>菜名</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"/></td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"/></td>
		</tr>
		<tr>
			<td>类型</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"/></td>
		</tr>
		<tr>
			<td>简述</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"/></td>
		</tr>
			<tr>
			<td>图片</td>
			<td><input type="file" style="width:200px;height:30px;border-color:#a2ffff;"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="新   增"
				class="aa">&nbsp;<input type="button" value="取   消" class="aa"></td>
		</tr>
	</table>
	</div>
	<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
	</form>
</body>
</html>
