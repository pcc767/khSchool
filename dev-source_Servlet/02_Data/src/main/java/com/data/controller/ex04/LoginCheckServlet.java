package com.data.controller.ex04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//MVC2 패턴으로 구성되고, 여기는 Controller부분

@WebServlet("/logincheck.do")
public class LoginCheckServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String userID = req.getParameter("userID");
		String password = req.getParameter("password");
		
		boolean result = checkLogin(userID, password);
		
		if(result == true) {
			HttpSession session = req.getSession();
			session.setAttribute("userID", userID);
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패!!!");
		}
		
		//실제 view단 코드(JSP)로 이동하는 코드
		// RequestDispatcher : 페이디 이동이 필요할때 재배치를 도와주는 객체
		RequestDispatcher rd = req.getRequestDispatcher("printmain.do");
		rd.forward(req, resp);
		
	}

	private boolean checkLogin(String userID, String password) {
		//db(Model)에서 회원정보를 조히하여 로그인이 가능한지 확인하는 로직.
		if(userID.equals("admin") && password.equals("1234")) {
			return true;
		}else {
			return false;
		}
	}

}
