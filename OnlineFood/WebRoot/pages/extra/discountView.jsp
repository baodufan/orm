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

<title>十八、优惠券页面</title>

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

body {
	padding-top: 30px;
	padding-bottom: 20px;
}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f;margin-top: 30px}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 125px;height: 30px;color: #ffffff;
	}
th{font-size:20px;}
#table1{margin-top: 30px}
#div3{margin-top: 30px;margin-bottom: 20px}
#div1{border:1px solid #dddddd;width:800px}
</style>
</head>
<body>
	<form>
		<div id="div1">
			<table id="table1">
			<tr><th colspan="5">优 惠 券 统 计</th></tr>
				<tr>
					<td width="50px">序号</td>
					<td width="120px">优惠券使用下限</td>
					<td width="100px">优惠券折扣</td>
					<td width="100px">使用时间限定</td>
				</tr>
				<tr>
					<td>001</td>
					<td>30</td>
					<td>3</td>
					<td>。。。</td>
					 <td><input type="submit" value="确 认">&nbsp;<input type="button" value="取 消"></td>
				</tr>
			</table>
		
		<div align="center" id="div3">
			<a href="pages/extra/addDiscount.jsp"><input type="button" value="新   增" class="aa"/></a>
			<a href=""><input type="button" value="返   回" class="aa"/></a>
		</div>
		</div>
		<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
	</form>
</body>
</html>
