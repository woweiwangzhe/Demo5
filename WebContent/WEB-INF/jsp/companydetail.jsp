<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业详情</title>
<style type="text/css">
table,td {
	font: 100% Arial, Helvetica, sans-serif;
	font-size: 14px;
}

.dd table {
	border-collapse: collapse;
	border: none;
}

.dd td {
	border: solid gray 1px;
	height: 25px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="dd">
		<table>

			<tr>
				<td width="25%">ID</td>
				<td width="10%">companyname</td>
				<td width="10%">address</td>
				<td width="10%">tel</td>
				<td width="10%">dept</td>
				<td width="10%">employ</td>
				<td width="20%">operation</td>
			</tr>

			<tr>
				<!-- ${status.index+1}编号 -->
				<td><c:out value="${company.id}" /></td>
				<td><c:out value="${company.companyname}" /></td>
				<td><c:out value="${company.address}" /></td>
				<td><c:out value="${company.tel}" /></td>				
				<td><c:out value="${company.dept}" /></td>
				<td><c:out value="${company.employ}" /></td>
				<td><a href="/Demo5/company/toupdate/${company.id}">update</a> <a
					href="/Demo5/company/delete/${company.id}">delete</a></td>
			</tr>
		</table>
	</div>
	<a href="/Demo5/company/list">首页</a>
</body>
</html>