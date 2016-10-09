<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
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
				<td width="10%">商品名称</td>
				<td width="10%">规格</td>
				<td width="10%">价格</td>
				<td width="10%">数量</td>
				<td width="10%">类型</td>
				<td width="10%">日期</td>
				<td width="20%">操作</td>
			</tr>

			<tr>		
				<!-- ${status.index+1}编号 -->
				<td><c:out value="${goods.id}" /></td>
				<td><c:out value="${goods.shopname}" /></td>
				<td><c:out value="${goods.size}" /></td>
				<td><c:out value="${goods.price}" /></td>
				<td><c:out value="${goods.number}" /></td>
				<td><c:out value="${goods.type}" /></td>
				<td><c:out value="${goods.createtime}" /></td>
				<td><a href="/Demo5/goods/toupdate/${goods.id}">修改</a> <a
					href="/Demo5/goods/delete/${goods.id}">删除</a></td>
			</tr>
		</table>
	</div>
	<a href="/Demo5/goods/list">首页</a>
</body>
</html>