package dabang.client.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import dabang.client.model.Member;

public class LoginController {
	private HashMap<String, Member> member = new HashMap<String, Member>();
	MemberController mCon = new MemberController();
	private static Properties props = new Properties();
	public void startLogin() {
		mCon.loadMember();
	}
	public boolean checkAdmin(String adminId) {
		try {
			props.load(new FileReader("admin.Properties"));
			if(props.getProperty("ID").equals(adminId)) {

				return true;
			}
			else return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean ckeckAdminPwd(String adminPwd) {
		if(props.getProperty("password").equals(adminPwd)) return true;
		else return false;
	}
	public boolean checkId(String userId) {
		mCon.loadMember();
		member = mCon.selectAll();        
		return member.containsKey(userId);
	}
	public boolean checkPwd(String userId, String userPwd) {
		if(member.get(userId).getPassWord().equals(userPwd)) {
			return true;
		}
		else return false;
	}
	public MemberController memCon() {
		return mCon;
	}

}
