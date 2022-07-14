<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
		application.setAttribute("name", "홍길동"); 	// 제일 오래삼
		session.setAttribute("name", "최길동"); 	  	// 세션이 해지될때 까지
		request.setAttribute("name", "김길동");     	// 다음 페이지도 전달 될수 있음. 단 forward에서만
		pageContext.setAttribute("name", "박길동");  	// 페이지 그려질 동안만 유효
		
		pageContext.forward("scopeTest3.jsp");
//		request.getRequestDispatcher("scopeTest3.jsp").forward(request, response);
	%>