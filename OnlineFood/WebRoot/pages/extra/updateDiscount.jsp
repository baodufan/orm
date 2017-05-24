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

<title>My JSP 'updateDiscount.jsp' starting page</title>

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
					<td>优惠券使用下限</td>
					<td><input type="text" name="name" id="name" value="" /></td>
				</tr>
				<tr>
					<td>优惠券折扣</td>
					<td><input type="text" name="mobile" id="mobile" value=" " /></td>
				</tr>
				<tr>
					<td>使用时间限定</td>
					<td><select
						style="width:100px;height:30px;border-color:#a2ffff;">
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
