package com.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



	/**
	 * 버전 1의 문제점 : xml을 관리하기 어려움. -> 개발자 실수를 많이 한다.(버그)
	 * 
	 * 해결방법 : 어노테이션(@Annotation) 활용하여 클래스와 별도의 파라메터를 맵핑시킴
	 * 사용법 : @webServlet(...)을 활용
	 */
	
	//방법 1
//	@WebServlet(name = "second", urlPatterns = "/second.do")
	
	//방법 2 - name 생략 가능
	@WebServlet(urlPatterns = "/second.do")
	// 주의점 : '/' 빼먹으면 안돌아간다.
	// tip : xml과 어노테이션 표기의 하이브리드 가능하다.(?)
	
	
public class secondServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// get 방식을 처리하는 메소드
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			System.out.println("사용자 요청 확인!!(doGet 호출됨)");
	
		
			System.out.println("사용자의 요청 URL : " + req.getRequestURI());
			System.out.println("서버 이름 : " + req.getServerName());
			System.out.println("서버 주소 : " + req.getLocalAddr());
			System.out.println("서버 Port : " + req.getServerPort());
			System.out.println("Context path : " + req.getContextPath());  //★★★★★★★ 프로젝트의 주소를 가르친다.
			System.out.println("사용자 ip : " + req.getRemoteAddr());
			System.out.println("사용자 Port : " + req.getRemotePort());
			
			// 응답하는 방법 (고전)
			// - HttpServletResponse를 활용하여 응답페이지 작성 가능
			resp.setContentType("text/html;charset=UTF-8"); // 응답할 페이지의 타입을 결정
			
			PrintWriter out = resp.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>SecondServlet 응답한 최초의 메세지!!</h1>");
			out.println("<p> - 어노테이션을 통해 URL과 서블릿간의 맵핑이 가능</p>");
			out.println("<p> - xml보다 개발자 관점에서는 편하다. 운영관점에서는 xml이 편하다.</p>");
			out.println("<p> - 운영할때는 코드가 보이지 않음으로 xml이 유리하다.</p>");
			out.println("</body>");
			out.println("</html>");
		}

}
