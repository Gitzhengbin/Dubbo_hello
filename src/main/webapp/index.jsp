<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add.do" method="post">
		帐号：<input name="username" type="text">
		密码：<input name="password" type="password">
		<input type="submit" value="添加">
	</form>
	<hr>
	<table align="center" border="1" width="50%">
		<tr>
			<td>帐号</td>
			<td>密码</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.username}</td>
				<td>${u.password}</td>
				<td><a href="delete.do?id=${u.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>