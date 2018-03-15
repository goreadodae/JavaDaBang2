package dabang.client.view;
import java.util.Scanner;

import dabang.client.controller.MemberController;
import dabang.client.model.Member;


public class MemberView {
    Scanner sc = new Scanner(System.in);
    MemberController mCon = new MemberController();
    public void mainMenu() {
        while(true) {
            System.out.println("\n\n- - - - - - ȸ�� ���� ���α׷� - - - - - -");
            System.out.println("1. ȸ�� ����");
            System.out.println("2. ȸ�� ���Կ��� Ȯ��");
            System.out.println("3. ȸ�� ���� ����(1��)");
            System.out.println("4. ȸ�� ���� �����ϱ�");
            System.out.println("5. ȸ�� ���� �ϱ�");
            System.out.println("6. �ε�");
            System.out.println("0. ���α׷� ����");
            System.out.print("���� : ");
            switch(sc.nextInt()) {
            case 1: memberJoin(); break;
            case 2: memberCheck(); break;
            case 3: memberSelect(); break;
            case 4: memberModify(); break;
            case 5: memberDelete(); break;
            case 6: memberLoad(); break;
            case 0: System.out.println("���α׷� ����"); return;
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
        System.out.print("\n\n========== ȸ�� ���� �ϱ� ==========\n\n");
        System.out.print("������ ȸ���� ���̵� �Է��ϼ��� : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            mCon.memberDelete(userId);
            System.out.println("�ش� ȸ���� �����Ǿ����ϴ�.");
        }
        else System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
    }
    private void memberModify() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== ȸ�� ���� ���� �ϱ� ==========\n\n");
        System.out.print("�����Ͻ� ȸ���� ���̵� �Է��ϼ��� : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            System.out.print("ȸ�� ��й�ȣ �Է� : ");
            String userPwd = sc.next();
            System.out.print("ȸ�� �̸� �Է� : ");
            String userName = sc.next();
            System.out.print("ȸ�� ���� �Է� : ");
            String userNickName = sc.next();
            System.out.print("���(0)/����(1) : ");
            int userSclc = sc.nextInt();
            System.out.print("�� : ");
            int userYear = sc.nextInt();
            System.out.print("�� : ");
            int userMonth = sc.nextInt();
            System.out.print("�� : ");
            int userDay = sc.nextInt();
            System.out.print("���� : ");
            char userGender = sc.next().charAt(0);
            System.out.print("ȸ�� ����ȣ �Է� : ");
            String phoneNumber = sc.next();
            mCon.memberModify(new Member(userId,userPwd,userNickName,userName,userSclc,userYear,
            		userMonth,userDay,userGender,phoneNumber,"�ǹ�",0.0));
            System.out.println("������ �Ϸ�Ǿ����ϴ�.");
        }
        else {
            System.out.println("�ش� ȸ���� �����ϴ�.");
        }
 
    }
    private void memberSelect() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== ȸ�� ���� ���� ==========\n\n");
        System.out.print("��ȸ�� ȸ���� ���̵� �Է��ϼ��� : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            System.out.println("��ȸ ����!");
            Member m = mCon.memberSelect(userId);
            System.out.printf("���̵� : %s\n", m.getId());
            System.out.printf("��й�ȣ : %s\n", m.getPassWord());
            System.out.printf("�̸� : %s\n",m.getName());
            System.out.printf("����ȣ : %s\n",m.getPhoneNumber());
        }
        else System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
 
    }
    private void memberCheck() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== ȸ�� ���� ���� Ȯ�� ==========\n\n");
        System.out.print("ȸ�� ���̵� �Է��ϼ��� : ");
        String userId = sc.next();
        if(mCon.memberCheck(userId)) {
            System.out.printf("%sȸ���� ���� �����մϴ�. �ٸ����̵� ������ּ���\n",userId);
        }
        else
            System.out.printf("%s�� ���� ����� �����մϴ�.\n",userId);
 
    }
    private void memberJoin() {
        // TODO Auto-generated method stub
        System.out.print("\n\n========== ȸ�� ���� �ϱ� ==========\n\n");
        System.out.print("ȸ�� ���̵� �Է� : ");
        String userId = sc.next();
        System.out.print("ȸ�� ��й�ȣ �Է� : ");
        String userPwd = sc.next();
        System.out.print("ȸ�� �̸� �Է� : ");
        String userName = sc.next();
        System.out.print("ȸ�� ���� �Է� : ");
        String userNickName = sc.next();
        System.out.print("���(0)/����(1) : ");
        int userSclc = sc.nextInt();
        System.out.print("�� : ");
        int userYear = sc.nextInt();
        System.out.print("�� : ");
        int userMonth = sc.nextInt();
        System.out.print("�� : ");
        int userDay = sc.nextInt();
        System.out.print("���� : ");
        char userGender = sc.next().charAt(0);
        System.out.print("ȸ�� ����ȣ �Է� : ");
        String phoneNumber = sc.next();
 
        if(mCon.memberJoin(new Member(userId,userPwd,userNickName,userName,userSclc,userYear,
        		userMonth,userDay,userGender,phoneNumber,"�ǹ�",0.0))) {
            System.out.println("ȸ�� ������ �Ϸ� �Ǿ����ϴ�.");
        }
        else {
            System.out.println("�ߺ��� ID�Դϴ�. �ٽ� �Է����ּ���");
        }
 
 
 
    }
}