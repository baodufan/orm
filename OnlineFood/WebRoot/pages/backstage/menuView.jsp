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

<title>十四、查看菜单页面（后台）</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
body {padding-top: 20px;}
 span { color: red; font-weight: bolder; }
  #bot {padding-top: 180px; }
  #table1{background-color: #f4f4f4}
</style>
	</head>
<body>

	<h2 align="center">菜单页面</h2>
	<div align="center" >
		<table style="width:600px;font-size: 14px;border: 2px solid #e2e2e2;" id="table1">
			<tr>
				<td>菜名：</td>
				
			</tr>
			<tr>
				<td>价格：<span></span></td>
				
			</tr>
			<tr>
				<td>会员价：<span></span></td>
				
			</tr>
		</table>
	</div>
	<div style="margin-top: 10px;">
		<table>
			<tr>
				<td style="padding-left:170px;"><a href="pages/backstage/addMenu.jsp"><input
						type="button" value="+" style="width: 50px;height: 50px;"></a></td></tr>
				<tr><td style="padding-left:630px;"><a href=""><input
						type="button" value="返    回" style="width: 120px;height: 28px;"></a></td>
			    </tr>
		</table>
	
	</div>
	<div
		style="width: 600px;height: 230px;background-image: url(images/09454I259-6.jpg);margin: 0px auto;">
		<p id="bot" align="center">Copyright © 2017 W161001J第一组所有</p>
	</div>
</body>
</html>
