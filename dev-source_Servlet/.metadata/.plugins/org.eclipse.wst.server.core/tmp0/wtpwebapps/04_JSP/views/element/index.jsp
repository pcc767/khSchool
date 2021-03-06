<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		td{
			text-align: center;
		}
	</style>
</head>
<body>
	<!-- HTML 주석 : 일반 브라우저에서 사용자도 소스코드 보기로 볼수 있다. -->
	<%-- JSP 주석 : JSP에서만 보여지는 주석, Java코드나 HTML에는 노출되지 않음 --%>

	<h1>JSP 스크립트 요소(Element) 실습</h1>
	<!-- 선언부 사용법 -->
	<%! // 멤버변수나 메소드 선언 가능
		public static final String TEST_ID = "testid123";
		public String userName = "김길동";
		
		public String getName(){
			return this.userName;
		}
	%>
	<hr><br>
	
	<%-- 출력부 기본꼴 (★★★★★추천!!) --%>
	<%= userName %><br>
	
	<%-- 복잡한 출력식, 비추한다. --%>
	<%= userName + ", " + getName() + ", " + TEST_ID + "<br>" %>
	
	<%-- 스크립트식 + out 객체 활용 -> 쓰지 말 것!! --%>
	<% out.println(userName); %><br>
	
	<%-- java 문자열을 결합이 필요할때 해결방법 --%>
	<% String divTag = userName + ", " + getName() + ", " + TEST_ID + "<br>";%>

	<div><%= divTag %></div>
	<hr><br>
	
	<!-- 일반 스크립트식(스클립틀릿) 연습 -->
	<h3>스크립트식 연습</h3>
	<% // 일반 Java 문법이 먹히는 영역
		if(userName.equals("홍길동")){
			out.append("<h3>홍길동이 맞습니다.</h3>");
		}else{
			out.append("<h3>홍길동이 절대 아닙니다!!</h3>");
		}
		// 해당 표현법은 추천하지 않는 문법!! 이렇게 쓸바에 서블릿 써라!
	%>
	
	<% // JSP식 1, 정적 html 표현식 사용
		if(userName.equals("홍길동")){
	%>
			<p>홍길동 운영자님 환영합니다!!</p>
	<%	
		} else {
	%>
			<p>일반 유저님 환영합니다. 당신은 홍길동이 아닙니다!</p>
	<%
		}
	%>
	
	<% // JSP식 2, 동적 html 표현식 사용
		if(userName.equals("홍길동")){
	%>
			<p><%= userName %> 운영자님 환영합니다!!</p>
	<%	
		} else {
	%>
			<p>일반 유저 <%= userName %>님 환영합니다. 당신은 홍길동이 아닙니다!</p>
	<%
		}
	%>
	<hr><br>
	
	<!-- 게시판 실습부 -->
	<!-- 게시판 -->
	<table border="1">
		<!-- 헤더부 시작 -->
		<tr>
			<th width="40px">번호</th>
			<th width="300px">게시글 제목</th>
			<th width="80px">작성자</th>
			<th width="100px">작성일</th>
		</tr>
		<!-- 헤더부 종료 -->
		
		<!-- 게시글 내용 시작 -->
		<%for(int i = 0; i < 10; i++){ %>
		<tr>
			<td><%= (i+1) %></td>
			<td> <a href="#"> <%= "게시글 제목" + (i+1) %></a></td>
			<td><%= "홍길동" + (i+1) %></td>
			<td><%= "22/07/"+(i+1) %></td>
		</tr>
		<%} %>
		<!-- 게시글 내용 끝 -->
	</table>

</body>
</html>




















