package com.data.controller.ex05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * InitParam : DID (web.xml)으로 부터 특정 파라메터를 입력 받는 방법
 * <init-param>
 * <param-name>email</param-name> <param-value>test@email.com</param-value>
 * </init-param> 
 * getInitParameter을 사용하여 데이터 가져옴
 */

public class InitParamServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		resp.getWriter().append("<html><body>");
		resp.getWriter().append("email : " + email +"<br>");
		resp.getWriter().append("tel : " + tel +"<br>");
		resp.getWriter().append("</body></html>");
	}
	
}
