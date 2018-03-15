package dabang.client.view;
import java.util.Scanner;

import dabang.client.controller.MemberController;
import dabang.client.model.Member;


public class MemberView {
    Scanner sc = new Scanner(System.in);
    MemberController mCon = new MemberController();
    public void mainMenu() {
        while(true) {
            System.out.println("\n\n- - - - - - 회원 관리 프로그램 - - - - - -");
            System.out.println("1. 회원 가입");
            System.out.println("2. 회원 가입여부 확인");
            System.out.println("3. 회원 정보 보기(1명)");
            System.out.println("4. 회원 정보 변경하기");
            System.out.println("5. 회원 삭제 하기");
            System.out.println("6. 로드");
            System.out.println("0. 프로그램 종료");
            System.out.print("선택 : ");
            switch(sc.nextInt()) {
            case 1: memberJoin(); break;
            case 2: memberCheck(); break;
            case 3: memberSelect(); break;
            case 4: memberModify(); break;
            case 5: memberDelete(); break;
            case 6: memberLoad(); break;
            case 0: System.out.println("프로그램 종료"); return;
            }
        }
    }
    private void memberLoad() {
		// TODO Auto-generated method stub
		mCon.loadMember();
		memberSelect();
	}
	private void memberDelete() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== 회원 삭제 하기 ==========\n\n");
        System.out.print("삭제할 회원의 아이디를 입력하세요 : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            mCon.memberDelete(userId);
            System.out.println("해당 회원이 삭제되었습니다.");
        }
        else System.out.println("해당 회원이 존재하지 않습니다.");
    }
    private void memberModify() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== 회원 정보 변경 하기 ==========\n\n");
        System.out.print("변경하실 회원의 아이디를 입력하세요 : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            System.out.print("회원 비밀번호 입력 : ");
            String userPwd = sc.next();
            System.out.print("회원 이름 입력 : ");
            String userName = sc.next();
            System.out.print("회원 별명 입력 : ");
            String userNickName = sc.next();
            System.out.print("양력(0)/음력(1) : ");
            int userSclc = sc.nextInt();
            System.out.print("년 : ");
            int userYear = sc.nextInt();
            System.out.print("월 : ");
            int userMonth = sc.nextInt();
            System.out.print("일 : ");
            int userDay = sc.nextInt();
            System.out.print("성별 : ");
            char userGender = sc.next().charAt(0);
            System.out.print("회원 폰번호 입력 : ");
            String phoneNumber = sc.next();
            mCon.memberModify(new Member(userId,userPwd,userNickName,userName,userSclc,userYear,
            		userMonth,userDay,userGender,phoneNumber,"실버",0.0));
            System.out.println("변경이 완료되었습니다.");
        }
        else {
            System.out.println("해당 회원이 없습니다.");
        }
 
    }
    private void memberSelect() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== 회원 정보 보기 ==========\n\n");
        System.out.print("조회할 회원의 아이디를 입력하세요 : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            System.out.println("조회 성공!");
            Member m = mCon.memberSelect(userId);
            System.out.printf("아이디 : %s\n", m.getId());
            System.out.printf("비밀번호 : %s\n", m.getPassWord());
            System.out.printf("이름 : %s\n",m.getName());
            System.out.printf("폰번호 : %s\n",m.getPhoneNumber());
        }
        else System.out.println("해당 회원이 존재하지 않습니다.");
 
    }
    private void memberCheck() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== 회원 가입 여부 확인 ==========\n\n");
        System.out.print("회원 아이디를 입력하세요 : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            System.out.printf("%s회원은 현재 존재합니다. 다른아이디를 사용해주세요\n",userId);
        }
        else
            System.out.printf("%s는 현재 사용이 가능합니다.\n",userId);
 
    }
    private void memberJoin() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== 회원 가입 하기 ==========\n\n");
        System.out.print("회원 아이디 입력 : ");
        String userId = sc.next();
        System.out.print("회원 비밀번호 입력 : ");
        String userPwd = sc.next();
        System.out.print("회원 이름 입력 : ");
        String userName = sc.next();
        System.out.print("회원 별명 입력 : ");
        String userNickName = sc.next();
        System.out.print("양력(0)/음력(1) : ");
        int userSclc = sc.nextInt();
        System.out.print("년 : ");
        int userYear = sc.nextInt();
        System.out.print("월 : ");
        int userMonth = sc.nextInt();
        System.out.print("일 : ");
        int userDay = sc.nextInt();
        System.out.print("성별 : ");
        char userGender = sc.next().charAt(0);
        System.out.print("회원 폰번호 입력 : ");
        String phoneNumber = sc.next();
 
        if(mCon.memberJoin(new Member(userId,userPwd,userNickName,userName,userSclc,userYear,
        		userMonth,userDay,userGender,phoneNumber,"실버",0.0))) {
            System.out.println("회원 가입이 완료 되었습니다.");
        }
        else {
            System.out.println("중복된 ID입니다. 다시 입력해주세요");
        }
 
 
 
    }
}