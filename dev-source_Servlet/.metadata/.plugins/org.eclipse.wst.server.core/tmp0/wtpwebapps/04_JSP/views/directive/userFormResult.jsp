<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String height = request.getParameter("height");
	String[] foods = request.getParameterValues("food");
%>

<section>
	<h3>사용자 입력정보 출력</h3>
	- 이름 : <%=name%><br>
	- 나이 : <%=age%><br>
	- 성별 : <%=gender%><br>
	- 신장 : <%=height%><br>
	- 좋아하는 음식 : <%=Arrays.toString(foods)%><br>
	- 좋아하는 음식1<br>
	<%for(int i = 0; i< foods.length; i++) {%>
		<%="" + foods[i] + "<br>" %>
	<%} %>
	
	
	
	- 좋아하는 음식2<br>
	<%for(String food : foods) {%>
		<%="" + food + "<br>" %>
	<%} %>
</section>

<%@ include file="/views/common/footer.jsp" %>