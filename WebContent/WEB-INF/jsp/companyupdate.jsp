<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改企业信息</title>
</head>
<body>
	<form action="/Demo5/company/update" method="post">
		<table>
			<tr>
				<td>companyname:</td>
				<td><input type="text" name="companyname" value="${company.companyname}" /></td>
			</tr>
			
			<tr>
				<td>address:</td>
				<td><input type="text" name="address" value="${company.address}" /></td>
			</tr>

			<tr>
				<td>tel:</td>
				<td><input type="text" name="tel" value="${company.tel}" /></td>
			</tr>

			<tr>
				<td>dept:</td>
				<td><input type="text" name="dept" value="${company.dept}" /></td>
			</tr>

			<tr>
				<td>employ:</td>
				<td><input type="text" name="employ" value="${company.employ}" /></td>
			</tr>

			<tr>
				<td><input type="hidden" name="comid" value="${company.id }" /><input
					type="submit" value="submit" /></td>
				<td><input type="reset" value="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>