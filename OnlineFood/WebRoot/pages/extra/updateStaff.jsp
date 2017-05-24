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

<title>My JSP 'updateStaff.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>

<body>
	<div id="adddiv">
		<form action="" method="post">
			<table border="3px" id="mtab1">
				<tr>
					<th colspan="2">修改配送员</th>
				</tr>
				<tr>
					<td>配送员编号</td>
					<td id="mtd1"><input type="text" name="tid" id="tid1"
						readonly="readonly" value="" /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="name" id="name" value="" /></td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="text" name="mobile" id="mobile" value=" " /></td>
				</tr>
				<tr>
					<td>配送区域</td>
					<td><select>
							<option value="芙蓉区">芙蓉区</option>
							<option value="雨花区">雨花区</option>
							<option value="岳麓区">岳麓区</option>
							<option value="天心区">天心区</option>
							<option value="开福区">开福区</option>
							<option value="无">无</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="保存" /><input type="reset" value="重置" /></td>
				</tr>
			</table>
			<a href="DoIndex.jsp">返回</a>
		</form>
	</div>
</body>
</html>
