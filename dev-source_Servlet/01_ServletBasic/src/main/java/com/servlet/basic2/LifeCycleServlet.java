package com.servlet.basic2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LifeCycle?
 *  -jvm에서 class(객테, 인스턴스)가 어떻게 생성되고 소멸하는지에 대한 흐름
 *  
 *
 */
@WebServlet("/life.do")
public class LifeCycleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("0. static을 통한 초기화문");
	}
	
	public LifeCycleServlet() {
		System.out.println("1. LifeCycleServlet 생성자 호출");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. init() : 최초 한번만 서블릿이 실행될때 호출됨.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		System.out.println("3. service() : doGet, doPost가 호출되기 직전에 한번만 호출됨!!");
		super.service(req, resp);	// <- 이부분이 없으면 doGet, doPost가 호출되지 않는다.
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4. doGet() : 사용자의 get 요청이 들어올때 실행되는 코드");
		
		resp.setContentType("text/html;charset=UTF-8"); // 응답할 페이지의 타입을 결정
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>FirstServlet 응답한 최초의 메세지!!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4. doPost() : 사용자의 post 요청이 들어올때 실행되는 코드");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("5. destory() : 서블릿이 소멸하기 직전에 호출됨.(실제 호출타이밍은 알 수 없음. 잘 안됨.)");
		// 주의 : 언제 호출될지 예상하기 어려움으로 이 함수를 사용하지 않기를 권장.
		//		 객체가 소멸되는 시점은 서버가 종료되거나 재시작할때로 생각하면 된다.
		//		 주로 로그용도?로 활용될수 있다.
	}
 
}
