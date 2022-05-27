package member.contoller;

import java.util.List;

import member.model.service.MemberService;
import member.model.vo.Member;

public class MemberController {
	MemberService service = new MemberService();
	
	public List<Member> selectAll() {
		return service.selectAll();
	}

	public Member selectOne(String memberId) {
		return service.selectOne(memberId);
	}

	public List<Member> selectByName(String memberName) {
		return service.selectByName(memberName);
	}

	public int insertMember(Member member) {
		return service.insertMember(member);
	}

	public int updateMember(Member member) {
		return service.updateMember(member);
	}

	public int deleteMember(String memberId) {
		return service.deleteMember(memberId);
	}
}
