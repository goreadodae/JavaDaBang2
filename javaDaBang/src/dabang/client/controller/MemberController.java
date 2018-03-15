package dabang.client.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;

import dabang.client.model.Member;
public class MemberController {
	private HashMap<String, Member> member = new HashMap<String, Member>();
	private HashSet<String> nickName = new HashSet<String>();
	public HashMap<String,Member> selectAll(){
		return member;
	}
	public boolean memberJoin(Member m) {
		if(member.containsKey(m.getId())) {
			return false;
		}
		else {
			member.put(m.getId(), m);
			nickName.add(m.getNickName());
			return true;
		}
	}
	
	public boolean nickNameCheck(String nick) {
		return nickName.contains(nick);
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
			nickName.add(m.getNickName());
			return true;
		}
		else {
			return false;
		}
	}
	public boolean memberDelete(String userId){    // 회원 삭제
		if(member.containsKey(userId)) {
			nickName.remove(member.get(userId).getNickName());
			member.remove(userId);			
			return true;
		}
		else {
			return false;
		}
	}
	public void saveMember() {
        // TODO Auto-generated method stub
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Member.txt"))){
            oos.writeObject(member);
        }catch(IOException e){
            e.printStackTrace();
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("nickName.txt"))){
            oos.writeObject(nickName);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
 
    public void loadMember() {
        // TODO Auto-generated method stub
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Member.txt"))){
        	member = (HashMap<String, Member>) ois.readObject();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nickName.txt"))){
        	nickName = (HashSet<String>) ois.readObject();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
}