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

<title>十三.订单查看页面（后台）</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
* {font-family: "微软雅黑";font-size:14px;margin: 0px auto;}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 125px;height: 30px;color: #ffffff;
	}
tr {
	height: 30px;
}
legend{color:#2f2f2f;font-weight:bold;font-size:16px}
.div1{width:600px;}

body {
    font-weight:bold;
	padding-top: 30px;
	padding-bottom: 10px;
}
h1{margin-bottom: 20px;font-size:20px;color:#666666}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
 #div2{margin-top:20px;margin-bottom: 20px }
</style>
</head>
<body>

	<form>
	<input type="hidden" name="method" value="ExamineStatus"/>
	<h1 align="center">订  单  查  看</h1>
	<div class="div1">
	<fieldset class="ff">
	<legend>菜 品 明 细</legend>
		<table >
			<tr>
				<td>菜名</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
		</table>
		</fieldset>
		</div>
		<div class="div1">
		<fieldset class="ff">
		<legend>配 送 信 息</legend>
		<table>
			<tr>
				<td>配送员</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
			<tr>
				<td>收货人电话</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
			<tr>
				<td>配送地址</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
		</table>
		</fieldset>
		</div>
		<div class="div1">
		<fieldset class="ff">
		<legend>订 单 信 息</legend>
		<table >
			<tr>
				<th align="left">订单编号</th>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
			<tr>
				<td>下单时间</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
			<tr>
				<td>订单状态</td>
				<td><select style="width:200px;height:30px;border-color:#d2d2d2;">
						<option>未接收</option>
						<option>已接受</option>
						<option>已配送</option>
						<option>已完成</option>
						<option>已取消</option>
				</select></td>
			</tr>
			<tr>
				<td>支付方式</td>
				<td><label><input type="radio" name="zf" value="网上支付"
						checked>网上支付</label> <label><input type="radio" name="zf"
						value="货到付款">货到付款</label></td>
			</tr>
			<tr>
				<td>订单留言</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#d2d2d2;"></td>
			</tr>
		</table>
		</fieldset>
		</div>
		<div align="center" id="div2"><input type="submit" value="确   认" class="aa">&nbsp;
		<input type="button" value="返   回" class="aa"></div>
		<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
	</form>
</body>
</html>
