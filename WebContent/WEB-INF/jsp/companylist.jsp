<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业列表</title>
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
	json数据：${jsonObject}
	<form action="/Demo5/company/add" method="post">
		<table>
			<tr>
				<td>企业名称:</td>
				<td><input type="text" name="companyname" /></td>
			</tr>

			<tr>
				<td>企业地址:</td>
				<td><input type="text" name="address" /></td>
			</tr>
			
			<tr>
				<td>电话:</td>
				<td><input type="text" name="tel" /></td>
			</tr>

			<tr>
				<td>部门:</td>
				<td><input type="text" name="dept" /></td>
			</tr>

			<tr>
				<td>员工:</td>
				<td><input type="text" name="employ" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="新增" /> <input type="reset"
					value="reset" /></td>
			</tr>
		</table>
	</form>
	<br>
	<div class="dd">
		<table width="800px">
			<tr>
				<td width="25%">ID</td>
				<td width="10%">企业名称</td>
				<td width="10%">地址</td>
				<td width="10%">电话</td>
				<td width="10%">部门</td>
				<td width="10%">员工</td>
				<td width="20%">操作</td>
			</tr>

			<c:forEach items="${companys}" var="company" varStatus="status">
				<tr >
					<!-- ${status.index+1}编号 -->
					<td><c:out value="${company.id}" /></td>
					<td><c:out value="${company.companyname}" /></td>
					<td><c:out value="${company.address}" /></td>
					<td><c:out value="${company.tel}" /></td>
					<td><c:out value="${company.dept}" /></td>
					<td><c:out value="${company.employ}" /></td>
					<td><a href="/Demo5/company/detail/${company.id}">下属商品</a> <a
						href="/Demo5/company/toupdate/${company.id}">修改</a> <a
						href="/Demo5/company/delete/${company.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<font size="5">共 ${page.totalCount} 条</font>
	<font size="5">共 ${page.totalPageCount} 页</font>
	<font size="5">第 ${page.pageNow} 页</font>
	<a href="/Demo5/company/list?pageNow=1">首页</a>
	<c:choose>
		<c:when test="${page.pageNow - 1 > 0}">
			<a href="/Demo5/company/list?pageNow=${page.pageNow - 1}">上一页</a>
		</c:when>
		<c:when test="${page.pageNow - 1 <= 0}">
			<a href="/Demo5/company/list?pageNow=1">上一页</a>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${page.pageNow + 1 < page.totalPageCount}">
			<a href="/Demo5/company/list?pageNow=${page.pageNow + 1}">下一页</a>
		</c:when>
		<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
			<a href="/Demo5/company/list?pageNow=${page.totalPageCount}">下一页</a>
		</c:when>
	</c:choose>
	<a href="/Demo5/company/list?pageNow=${page.totalPageCount}">尾页</a>

</body>
</html>