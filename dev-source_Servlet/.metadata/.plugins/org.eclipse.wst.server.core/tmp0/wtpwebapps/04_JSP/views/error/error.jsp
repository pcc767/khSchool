<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error!!!</title>
</head>
<body>
	<h1>사용자 정의 에러페이지 입니다.</h1>

	<%= exception %><br>
	<%= exception.getMessage() %><br>
	<%= exception.getClass().getName() %><br>
</body>
</html>