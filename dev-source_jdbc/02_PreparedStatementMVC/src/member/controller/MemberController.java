package member.controller;

import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberController {

MemberDao dao = new MemberDao();
	
	public List<Member> selectAll() {
		return dao.selectAll();
	}

	public Member selectOne(String memberId) {
		return dao.selectOne(memberId);
	}

	public List<Member> selectByName(String memberName) {
		return dao.selectByName(memberName);
	}

	public int insertMember(Member member) {
		return dao.insertMember(member);
	}

	public int updateMember(Member member) {
		return dao.updateMember(member);
	}

	public int deleteMember(String memberId) {
		return dao.deleteMember(memberId);
	}

}
