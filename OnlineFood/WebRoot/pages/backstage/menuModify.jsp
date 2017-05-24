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

<title>十六、菜单修改页面</title>

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

* {font-family: "微软雅黑";font-size:14px;margin: 0px auto;}

body {padding-top: 10px;}

#div1{border:1px #d8f8fe solid;background-color: #f0fdff;width:800px;margin-bottom:20px;margin-top:30px}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 80px;height: 30px;color: #ffffff;
	}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
th{font-size:16px;color:#17ff17}
</style>
	</head>
<body>
	<form method="post" action="">
	<div id="div1">
	<table>
	   <tr><th colspan="2">菜 单 修 改</th></tr>
		<tr>
			<td>菜名</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>类型</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>简述</td>
			<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>图片</td>
			<td><input type="file" style="width:200px;height:30px;border-color:#a2ffff;"></td>
		</tr>
		<tr>
			<td>状态</td>
			<td><label><input type="radio" name="zt" value="在售"checked>在售</label>&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio" name="zt"value="下架">下架</label></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="保  存" class="aa">&nbsp;<input
				type="reset" value="重  置" class="aa">&nbsp;<a href="#"><input
					type="button" value="返  回" class="aa"></a></td>
		</tr>
	</table>
	</div>
	<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
	</form>
</body>
</html>
