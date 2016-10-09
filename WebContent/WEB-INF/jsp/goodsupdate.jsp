<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品修改</title>
</head>
<body>
	<form action="/Demo5/goods/update" method="post">
		<table>
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="shopname" value="${goods.shopname}" /></td>
			</tr>
			
			<tr>
				<td>规格:</td>
				<td><input type="text" name="size" value="${goods.size}" /></td>
			</tr>

			<tr>
				<td>价格:</td>
				<td><input type="text" name="price" value="${goods.price}" /></td>
			</tr>

			<tr>
				<td>数量:</td>
				<td><input type="text" name="number" value="${goods.number}" /></td>
			</tr>

			<tr>
				<td>类型:</td>
				<td><input type="text" name="type" value="${goods.type}" /></td>
			</tr>
			
			

			<tr>
				<td><input type="hidden" name="comid" value="${goods.id }" /><input
					type="submit" value="submit" /></td>
				<td><input type="reset" value="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>