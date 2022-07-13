package com.cookie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletecookie.do")
public class DeleteCookieSetvlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키 삭제하는 법
		// -> 쿠키 데이터를 빈데이터로 변경하고, live 시간을 0으로 설정함
		
		try {
			Cookie[] cookies = req.getCookies();
			for(Cookie c : cookies) {
				String name = c.getName();
				Cookie tempC = new Cookie(name, "");	// 이렇게 하면 데이터만 지워진다.
				tempC.setMaxAge(0);						// live시간을 0으로 설정함
				resp.addCookie(tempC);
			}
		} catch (Exception e) {
			
		}
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().append("<script> alert('쿠키가 삭제되었습니다.'); "
				+ "location.href='" + req.getContextPath()+ "' </script>");

	}

}
