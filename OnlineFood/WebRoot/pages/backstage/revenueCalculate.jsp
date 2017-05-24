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

<title>十七、收益统计页面</title>

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
	margin: 0px auto;
	font-size: 16px;
	line-height: 32px;
	font-family: "微软雅黑";
}

body {
	padding-top: 30px;
	padding-bottom: 30px;
}

.aa {
	background-image: url("04.jpg");
	width: 82px;
	height: 23px;
	color: blue
}

div {
	padding: 10px auto;
	margin: 10px auto;
}

#box1 {
	width: 534px;
}

.td_top {
	vertical-align: top;
	width:90px;
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

.inputbox {
	padding-bottom: 15px;
}

.raise {
	font-size: 20px;
	font-weight: bold;
}

.pad_left1 {
	padding-left: 80px;
}

.float_right1 {
	float: right;
}
.groundbox{
	border:1px dashed black; 
	padding:50px;
	width:600px;
	heigth:600px;
}
</style>
</head>
<body>
	<div align="center">
		<img src="images/u=648553422,3345149513&fm=23&gp=0.jpg">
	</div>
	<div class="groundbox">
		<table id="box1">
			<tr>
				<td class="td_top"><p><span class="raise">填写日期</span></p></td>
				<td class="td_next">
					<form action="" method="post">
						<p class="inputbox">
							从&nbsp;<input type="text" size="3" name="beginyear" />&nbsp;年&nbsp;<input
								type="text" size="1" name="beginmonth" />&nbsp;月 &nbsp;<input
								type="text" size="1" name="beginday" />&nbsp;日&nbsp;&nbsp;
								到&nbsp;<input type="text" size="3" name="endyear" />&nbsp;年&nbsp;<input
								type="text" size="1" name="endmonth" />&nbsp;月&nbsp; <input
								type="text" size="1" name="endday" />&nbsp;日
						</p>
						<p class="stay_back">
							<input type="submit" class="float_right1" value="确认统计">
						</p>
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2"><hr /> 统计结果</td>
			</tr>
			<tr>
				<td colspan="2" class="pad_left1">订单数:</td>
			</tr>
			<tr>
				<td colspan="2" class="pad_left1"><p class="stay_back">总金额:
				<input type="button" class="float_right1" value="返回"></p></td>
			</tr>
		</table>
	</div>
	<div>
		<p id="bb">Copyright © 2017 W161001J第一组所有</p>
	</div>
</body>
</html>
