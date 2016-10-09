<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
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
	json数据:${jsonObject}
	<form action="/Demo5/goods/add" method="post">
		<table>
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="shopname" /></td>
			</tr>

			<tr>
				<td>规格:</td>
				<td><input type="text" name="size" /></td>
			</tr>
			
			<tr>
				<td>价格:</td>
				<td><input type="text" name="price" /></td>
			</tr>

			<tr>
				<td>数量:</td>
				<td><input type="text" name="number" /></td>
			</tr>

			<tr>
				<td>类型:</td>
				<td><input type="text" name="type" /></td>
			</tr>
			
			<tr>
				<td>日期:</td>
				<td><input type="text" name="createtime" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="新增" /> <input type="reset"
					value="reset" /></td>
			</tr>
		</table>
	</form>
	<br>
	<font size="3">共 ${page.totalCount} 条</font>
	<font size="3">共 ${page.totalPageCount} 页</font>
	<font size="3">第 ${page.pageNow} 页</font>
	<a href="/Demo5/goods/list?pageNow=1">首页</a>
	<c:choose>
		<c:when test="${page.pageNow - 1 > 0}">
			<a href="/Demo5/goods/list?pageNow=${page.pageNow - 1}">上一页</a>
		</c:when>
		<c:when test="${page.pageNow - 1 <= 0}">
			<a href="/Demo5/goods/list?pageNow=1">上一页</a>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${page.pageNow + 1 < page.totalPageCount}">
			<a href="/Demo5/goods/list?pageNow=${page.pageNow + 1}">下一页</a>
		</c:when>
		<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
			<a href="/Demo5/goods/list?pageNow=${page.totalPageCount}">下一页</a>
		</c:when>
	</c:choose>
	<a href="/Demo5/goods/list?pageNow=${page.totalPageCount}">尾页</a>
	<a href="/Demo5/company/list.do">返回到企业列表</a><br>
	<div class="dd">
		<table width="800px">
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

			<c:forEach items="${goodss}" var="goods" varStatus="status">
				<tr>
					<!-- ${status.index+1}编号 -->
					<td><c:out value="${goods.id}" /></td>
					<td><c:out value="${goods.shopname}" /></td>
					<td><c:out value="${goods.size}" /></td>
					<td><c:out value="${goods.price}" /></td>
					<td><c:out value="${goods.number}" /></td>
					<td><c:out value="${goods.type}" /></td>
					<td><c:out value="${goods.createtime}" /></td>
					<td><a href="/Demo5/goods/detail/${goods.id}">详细</a> <a
						href="/Demo5/goods/toupdate/${goods.id}">修改</a> <a
						href="/Demo5/goods/delete/${goods.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	

</body>
</html>