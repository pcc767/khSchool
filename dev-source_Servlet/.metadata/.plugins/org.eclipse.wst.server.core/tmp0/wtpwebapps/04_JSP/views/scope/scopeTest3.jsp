<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Scope 객체간 생존 주기 실험 Round 2, forward 이동됨</h3>
	- forward 이동임으로 pageContext만 초기화 되고 모두 삼!! <br>
	<hr>

	application : <%=application.getAttribute("name") %> <br>
	session : <%=session.getAttribute("name") %> <br>
	request : <%=request.getAttribute("name") %> <br>
	pageContext : <%=pageContext.getAttribute("name") %> <br>
	
</body>
</html>