package com.cookie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkcookie.do")
public class CheckCookieServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키 읽어오는 법
		//1. request 객체에서 쿠키 리스트를 가져온다.
		
		Cookie[] cookies = req.getCookies();
		Map<String, String> cookieMap = new HashMap<String, String>();
		
		//2. key-value로 찾기
		for(Cookie c : cookies) {
			System.out.println("name : "+ c.getName()+", value : "+c.getValue());
			cookieMap.put(c.getName(), c.getValue());
		}
		
		//응답페이지 만들기
		String userId = cookieMap.get(CookieCreateServlet.COOKIE_ID);
		String userName = cookieMap.get(CookieCreateServlet.COOKIE_NAME);
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		out.append("<html><body>");
		out.append("User ID : " + userId +"<br>");
		out.append("User Name : " + userName +"<br>");
		out.printf("<a href='%s'>쿠키 삭제</a><br>", "deletecookie.do");
		out.printf("<a href='%s'>메인 페이지</a><br>", req.getContextPath());
		out.append("</body></html>");

	}

}
