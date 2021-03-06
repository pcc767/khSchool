package com.data.controller.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class GetPostServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출!!");
		
		//사용자 데이터 가져오는 방법
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println("id : " + id + ", pw : "+ pw);
		
		//응답 페이지 만들기
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		out.printf("사용자 id : %s <br>", id);
		out.printf("사용자 pw : %s <br>", pw);
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost호출!!");
		req.setCharacterEncoding("UTF-8");  //post는 반드시 인코딩 처리가 필요하다.
		doGet(req, resp);
	}

}
