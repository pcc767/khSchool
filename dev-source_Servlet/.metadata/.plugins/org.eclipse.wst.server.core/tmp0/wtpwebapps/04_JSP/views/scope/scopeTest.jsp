<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Scope 객체간 생존 주기 실험 Round 1, a태그로 페이지 이동됨</h3>
	- redirect와 같은 효과로 request와 pageContext는 초기화 됨<br>
	<hr>

	application : <%=application.getAttribute("name") %> <br>
	session : <%=session.getAttribute("name") %> <br>
	request : <%=request.getAttribute("name") %> <br>
	pageContext : <%=pageContext.getAttribute("name") %> <br>
	
	<a href="scopeTest2.jsp">다음 페이지 이동</a>
</body>
</html>