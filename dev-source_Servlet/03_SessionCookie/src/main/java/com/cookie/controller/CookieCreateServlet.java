package com.cookie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 쿠키란(cookie)? 
 *  - HTTP의 기록서의 일종으로 사용자가 웹사이트를 방문하면 사이트에서 사용하는 정보를 저장할수 있는 기능
 *  - 쿠키 표준 : 최대 4kb, 저장갯수 3000개 
 *  - 기록 장소 : 웹브라우저가 지정한 고유 path에 저장됨 (Client)
 *  - 특징 : 보안에 취약하다고 알려짐 -> 개발자가 안전하게 사용할수 있도록 기술적 보완을 하거나 중요하지 않은 기능만 저장. 
 */

@WebServlet("/cookietest.do")
public class CookieCreateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public static final String COOKIE_ID   = "C_ID"; // key
	public static final String COOKIE_NAME = "C_NAME"; // key
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿠키 생성하는 방법.
		//1. 쿠키 객체를 생성하고, key-value 값을 넣어줌
		Cookie cookie1 = new Cookie(COOKIE_ID, "test1234");
		Cookie cookie2 = new Cookie(COOKIE_NAME, "홍길동");
		
		//2. 쿠키의 기본적인 설정을 셋팅한다. (ex : 시간, 경로, 도메인)
		cookie1.setMaxAge(60*60*24);  // 초단위로 기록됨, 24시간 설정
		cookie2.setMaxAge(60*60*24);  // 초단위로 기록됨, 24시간 설정
		
		//3. 응답에 쿠키를 추가
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		
		// 응답페이지 만들기
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.append("<html>");
		out.append("<body>");
		out.append("<h1>쿠키를 생성하였습니다.</h1>");
		out.append("<a href = 'checkcookie.do'>저장된 쿠키 확인</a>");
		out.append("</body>");
		out.append("</html>");

	}



}
