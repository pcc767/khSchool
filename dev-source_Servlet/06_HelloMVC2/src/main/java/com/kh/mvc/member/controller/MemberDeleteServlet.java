package com.kh.mvc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.MyHttpSertvlet;
import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends MyHttpSertvlet {
	private static final long serialVersionUID = 1L;

	private MemberService service = new MemberService();
	
	@Override
	public String getServletName() {
		return "MemberDeleteServlet";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Member loginMember = getSessionMember(req);
			if(loginMember == null) {
				sendCommonPage("잘못된 접근입니다.", "/", req, resp);
				return;
			}
			
			int result = service.delete(loginMember.getNo());
			
			if(result > 0) {
				sendCommonPage("회원탈퇴에 성공하였습니다.", "/logout", req, resp);
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendCommonPage("회원 탈퇴에 실패하였습니다. 문의 부탁합니다.", "/logout", req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
