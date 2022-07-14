<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

해당페이지는 보이지 않는 페이지 입니다.!!

<%
	request.setAttribute("id", "test1234"); 	// 다음 페이지로 넘길 데이터 redirect로 남지 않는다.
	
	// redirect로 넘기는 방법 - 데이터 안남는다.
	//response.sendRedirect("redirect_target.jsp");
	
	
	// forward로 넘기는 방법 - 데이터 남는다.(단축형, 추천)
	request.getRequestDispatcher("redirect_target.jsp").forward(request,response);
	
	// 위 코드 기본형.
	//RequestDispatcher rd = request.getRequestDispatcher("redirect_target.jsp");
	//rd.forward(request, response);
%>