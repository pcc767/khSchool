<%@page import="com.kh.util.AES256Cipher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 결과</h2>
	<hr><br>
	
	아이디 : <%=request.getParameter("id") %> <br>
	패스워드 : <%=request.getParameter("password") %><br>
	이름 : <%=request.getParameter("name") %><br>
	생년월일(암호화) : <%=request.getParameter("day") %><br>
	
	<%
		String deDay = null;
		try{
			String enDay = request.getParameter("day");
			deDay = AES256Cipher.AES_Decode(enDay);
		}catch(Exception e){}
	%>
	생년월일(복호화) : <%=deDay %><br>
</body>
</html>