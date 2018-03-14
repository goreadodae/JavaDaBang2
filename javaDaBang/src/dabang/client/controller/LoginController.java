package dabang.client.controller;

import java.util.HashMap;

import dabang.client.model.Member;

public class LoginController {
	private HashMap<String, Member> member = new HashMap<String, Member>();
	MemberController mCon = new MemberController();
	public boolean checkId(String userId) {
		member = mCon.selectAll();        
		return member.containsKey(userId);
	}
	public boolean checkPwd(String userId, String userPwd) {
		if(member.get(userId).getPassWord().equals(userPwd)) {
			return true;
		}
		else return false;
	}

}
