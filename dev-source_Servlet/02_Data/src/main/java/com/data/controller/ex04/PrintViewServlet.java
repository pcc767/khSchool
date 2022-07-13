package com.data.controller.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/printmain.do")
public class PrintViewServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//로그인이 되었는지 확인하는 코드
		HttpSession session = req.getSession();
		String userID = (String) session.getAttribute("userID");
		
		PrintWriter out = resp.getWriter();
		
		out.append("<html>");
		out.append("<body>");
		if(userID != null) {	//로그인 성공, 세션이 살아 있는경우
			out.printf("<h2>%s 님의 로그인을 환영합니다.</h2>", userID);
			String path = req.getContextPath() + "/sessiondel.do";
			String path2 = req.getContextPath() + "/views/index.html";
			out.printf("<button onclick=\"location.href = '%s'\"> 로그아웃 </button>" , path);
			out.printf("<button onclick=\"location.href = '%s'\"> 홈페이지 이동 </button>" , path2);
		} else {
			out.printf("<h2>로그인에 실패하였습니다!! admin/1234 </h2>");
			String path = req.getContextPath() + "/views/login.html";
			out.printf("<button onclick=\"location.href = '%s'\"> 로그인 </button>" , path);
		}
		out.append("</body>");
		out.append("</html>");
		resp.setContentType("text/html;charset=utf-8");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
