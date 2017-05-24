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

<title>十九、新增优惠券页面</title>

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
#div2{margin-bottom: 10px;margin-top: 10px}
* {font-family: "微软雅黑";font-size:14px;margin: 0px auto;}
th{font-size:20px;color:#949494}
body {
	padding-top: 30px;
	padding-bottom: 20px;
}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 100px;height: 30px;color: #ffffff;
	}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
</style>
</head>

<body>
	<form>
		<table>
			<tr>
				<th colspan="2">优惠券使用下限</th>
			</tr>
			<tr>
				<td>优惠券折扣</td>
				<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"/></td>
			</tr>
			<tr>
				<td>时间限定</td>
				<td><select style="width:200px;height:30px;border-color:#a2ffff;">
						<option>不能使用</option>
						<option>星期日</option>
						<option>星期一</option>
						<option>星期二</option>
						<option>星期三</option>
						<option>星期四</option>
						<option>星期五</option>
						<option>星期六</option>
						<option>无限定</option>
				</select></td>
				<td><a href="">保存</a>  |  <a href="">重置</a></td>
			</tr>

		</table>
		<div align="center" id="div2">
		<a href="pages/extra/addDiscount.jsp"><input type="button" value="新   增" class="aa"></a>
		<a href=""><input type="button" value="返  回" class="aa"/></a></div>
	</form>
	<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
</body>

</html>