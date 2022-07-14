<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Scope간 생명주기 실습</h1>
	<%
		application.setAttribute("name", "홍길동"); 	// 제일 오래삼
		session.setAttribute("name", "최길동"); 	  	// 세션이 해지될때 까지
		request.setAttribute("name", "김길동");     	// 다음 페이지도 전달 될수 있음. 단 forward에서만
		pageContext.setAttribute("name", "박길동");  	// 페이지 그려질 동안만 유효
	%>
	
	application : <%=application.getAttribute("name") %> <br>
	session : <%=session.getAttribute("name") %> <br>
	request : <%=request.getAttribute("name") %> <br>
	pageContext : <%=pageContext.getAttribute("name") %> <br>
	
	<a href="scopeTest.jsp">다음 페이지 이동</a>
	<!-- a태그 = sendRedirect와 동일한 기능 -->
</body>
</html>