<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">

		<title>二十三、新增操作员</title>

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

#geren{font-size:20px;}

body {padding-top: 10px;}
th{font-size:16px}
#div1{border:1px #d8f8fe solid;background-color: #f0fdff;width:800px;margin-bottom:20px;}
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 125px;height: 30px;color: #ffffff;
	}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
		</style>
	</head>

	<body>
		<form action="" method="post">
		<div id="div1">
			<table>
				<tr>
					<th colspan="2" align="left">新增操作员信息填写</th>
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
					<td><label><input type="radio" value="男" checked="checked" name="sex"/>男</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio" value="女" name="sex"/>女</label>
					</td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
				</tr>
				<tr>
				
					<td colspan="2" align="left" height="70px"><input
					type="submit" value="确    认" class="aa">&nbsp;&nbsp;<input
					type="button" value="取   消" class="aa"></td>
					
				</tr>
			</table>
			</div>
			<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
		</form>
	</body>
</html>