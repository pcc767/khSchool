package com.data.controller.ex02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* SendRedirect란? 
* - 단순 페이지 이동으로 사용자 파라메터와 Attribute가 저장되지 않음.
* - 다음 페이지 호출은 get방식으로 호출됨!
*/

@WebServlet("/sendredirect.do")
public class SendRedirectServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("SendRedirectServlet -  doPodt 호출됨");
			req.setAttribute("MSG", "이건 SendRedirectServlet의 메세지 입니다."); // 실제 전달 안됨.
			resp.sendRedirect("testperson.do");
		}

}
