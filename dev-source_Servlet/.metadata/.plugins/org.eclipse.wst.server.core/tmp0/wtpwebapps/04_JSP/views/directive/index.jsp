
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error/error.jsp"--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

 <%
 //	int value = 10 / 0;
 %>
 
<!-- Include 실습부
 	■ Include 전략
 	1. <html><head><css></head><body> 포함한 header 영역을 분리하고, </body></html>을 포함한 Footer로 작성함 ★★★★★
 	2. JSP마다 html, body를 각자 선언하고, <header>부나 <footer>를 포함하는 방법
 	※ 해당 파일이나 실습은 1번째 방법을 선호함
-->

<%@ include file="/views/common/header.jsp" %>

<section>
	<h4>개인 정보 입력</h4>
	<p>데이터 입력 후 확인 버튼을 눌러주세요.</p>
	<form action="userFormResult.jsp" method="POST">
		<label>이름 : <input type="text" name="name" size="10"/></label><br>
		<label>나이 : <input type="text" name="age" size="10"/></label><br>
		<label>성별 : </label> 
		<label><input type="radio" name="gender" value="남자"/>남자</label>
		<label><input type="radio" name="gender" value="여자"/>여자</label><br>
		<label>키 : <input type="range" name="height" min="140" max="190" step="1"/></label><br>
		
		<label>좋아하는 음식 : </label>
		<label><input type="checkbox" name="food" value="한식"/>한식</label>
		<label><input type="checkbox" name="food" value="분식"/>분식</label>
		<label><input type="checkbox" name="food" value="중식"/>중식</label>
		<label><input type="checkbox" name="food" value="양식"/>양식</label>
		<label><input type="checkbox" name="food" value="일식"/>일식</label>
		<br><br>
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>
</section>

<%@ include file="/views/common/footer.jsp" %>