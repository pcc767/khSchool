package com.data.controller.ex02;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* page 이동에 관련 함수 정리
* 
* 1. forward 방식
*   - Response - RequestDispatcher에서 forward 함수를 활용하여 이동하는 방식
*   - 페이지 이동이 되면서 가지고 있던 파라메터 및 Attribute를 모두 넘겨줌.
*   - 예시) 로그인 Controller(Servlet) -> 로그인 결과 View (JSP) 
*     [MVC패턴2] 에서 활용됨 
*  
* 2. SendRedirect 방식
*   - Request - SendRedirect 함수를 호출하는 방식
*   - 페이지가 이동되면서 기존에 가진 파라메터 및 Attribute를 초기화함
*   - 예시) 로그인 실패 -> 메인페이지로 이동 시킬때, 기존 data를 소거하고 get 방식
* 	   주로 단순 페이지 이동에도 활용됨.
* 
* 3. include 방식 (잘쓰이지 않음)
*   - Response - RequestDispatcher에서 include 함수를 활용하여 이동하는 방식
*   - 기존 페이지 -> 새로운 페이지 -> 기존 페이지 이동
*   - 현재 MVC 패턴들에서는 사실상 잘 사용되지 않음.
*/


//forward방식
//해당 페이지에서 인자를 담아 다른페이지로 이동 시키는 방법실습

@WebServlet("/pagemove.do")
public class PageMoveServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PageMoveServlet - doPost 실행!");
		
		// 인자를 담는 방법
		// 1. request에 인자를 담음 - setAttivute에 key-value 형식으로 담을수 있다.
		req.setAttribute("MSG", "안녕하세요. 저녁 6시입니다.");
		req.setAttribute("MSG_DATE", new Date());
		req.setAttribute("MSG", "안녕하세요? 이건 덮어쓰는 메세지입니다.");
		
		// 2. request에서 객체를 읽는 방법(원래는 다른 페이지에서 읽으면 됩니다.)
		try {
			String msg = (String) req.getAttribute("MSG");
			Date date = (Date) req.getAttribute("MSG_DATE");
			System.out.println(msg);
			System.out.println(date.toString());
			//여기서 발생 할 수 있는 에러 : null point, type cast
		} catch (Exception e) {
			return;
		}
		
		// 3. 페이지 이동하는 방법
		RequestDispatcher rd = req.getRequestDispatcher("testperson.do");
		rd.forward(req, resp); // 실제 페이지가 이동되는 코드.
//		rd.include(req, resp); // 실제로 해당 페이지로 돌아옴으로 인코딩 세팅이 날아간다.
		System.out.println("페이지가 이동되었습니다.");
		
	}

}
