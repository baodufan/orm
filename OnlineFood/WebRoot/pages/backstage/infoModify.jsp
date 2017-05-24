<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">

		<title>二十四、用户信息修改（系统管理员可更改用户状态）</title>

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
th{font-size:16px;color:#17ff17}
#div1{border:1px #d8f8fe solid;background-color: #f0fdff;width:800px;margin-bottom:20px;margin-top:30px }
.aa {
	border:1px solid;font-size:16;background-color:#60afff;font-weight:bold;
	width: 88px;height: 30px;color: #ffffff;
	}
#bb{background-image:url(images/14.jpg);width:800px;padding-top: 90px;
    text-align:center;margin-bottom: 20px;font-size:16px;color:#ff870f}
		</style>
	</head>
	<body>
		<form action="" method="post">
			<div id="div1">
			<table cellspacing="0px" width="300px">
			    <tr>
					<th colspan="2" align="left">修 改 用 户</th>
				</tr>
			
				<tr>
					<th colspan="2" align="left">账号</th>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" style="width:200px;height:30px;border-color:#a2ffff;"></td>
				</tr>
				<tr>
					<td>用户状态</td>
					<td>
						<select name="status" style="width:200px;height:30px;border-color:#a2ffff;">
							<option value="正常">正常</option>
							<option value="禁用">禁用</option>
						</select>
					</td>
				</tr>
				<tr>
				<td colspan="2" align="left" height="70px">
					<input type="submit" value="修   改" class="aa"/>
					<input type="reset" value="重   置" class="aa"/>
					<input type="button" value="取   消" class="aa"/>
					</td>
				</tr>
			</table>
			</div>
			<div><p id="bb">Copyright © 2017     W161001J第一组所有</p></div>
		</form>
	</body>
</html>