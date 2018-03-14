package dabang.client.controller;
import java.util.HashMap;

import dabang.client.model.Member;
public class MemberController {
	private HashMap<String, Member> member = new HashMap<String, Member>();
	public boolean memberJoin(Member m) {
		if(member.containsKey(m.getId())) {
			return false;
		}
		else {
			member.put(m.getId(), m);
			return true;
		}
	}

	public boolean memberCheck(String userId) {
		return member.containsKey(userId);
	}
	public Member memberSelect(String userId) {
		return member.get(userId);
	}
	public boolean memberModify(Member m) {    // 회원 수정
		if(member.containsKey(m.getId())) {
			member.put(m.getId(), m);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean memberDelete(String userId){    // 회원 삭제
		if(member.containsKey(userId)) {
			member.remove(userId);
			return true;
		}
		else {
			return false;
		}
	}
}