package com.session.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 세션이란? 
 * - HTTP 프로토콜 중 하나로, 서버에서 Session ID를 통해 사용자 정보를 저장하는 용도로 활용
 * - 저장 기간 : 클라이언트 (브라우저)가 종료되었을때 세션 해지, 서버가 지정한 시간의 time out 시 
 * - 저장 위치 : 서버의 메모리 공간 / 디스크 공간 (임시적으로 생성됨)
 * - 특징 : 쿠키 보단 보안적으로 안전하다.
 * - 단점 : 인터넷 연결이 불완전하거나 브라우저가 종료되는 경우 세션이 유지 않음
 *  -> 최근 스마트폰 환경에서 단점을 보완하기 위해 cookie와 혼용되어 활용됨
 * 
 */

@WebServlet("/sessiontest.do")
public class SessionCreateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public static final String SESSION_ID   = "S_ID";
	public static final String SESSION_NAME = "S_NAME";
	public static final String SESSION_DATE = "S_DATE";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션 생성하는 법
		
		//1.req에서 객체 가져오기
		HttpSession session = req.getSession();
		System.out.println("session ID : "+ session.getId()); 		//세션의 고유번호, 브라우저마다 생성됨.
		
		//2. 세션에 데이터 넣기(객체도 넣을수 있다.)
		session.setAttribute(SESSION_ID, "test1234");
		session.setAttribute(SESSION_NAME, "홍길동");
		session.setAttribute(SESSION_DATE, new Date());
		
		//3. 세션 시작 설정(옵션, default 30분)
		session.setMaxInactiveInterval(10);		// 초단위 10초 설정
		
		// 응답페이지 작성하기
				resp.setContentType("text/html;charset=utf-8");
				StringBuffer sb = new StringBuffer();

				sb.append("<html>");
				sb.append("<body>");
				sb.append("<p>세션이 생성했습니다.</p>");
				sb.append("<a href = 'checksession.do'>저장된 세션 확인</a>");
				sb.append("</body>");
				sb.append("</html>");

				resp.getWriter().append(sb.toString());

	}


}
