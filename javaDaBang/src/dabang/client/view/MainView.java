package dabang.client.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dabang.client.model.Member;
import dabang.client.model.MenuDrink;
import dabang.client.model.OrderList;

public class MainView implements ActionListener {
	private MenuDrink md = new MenuDrink();
	private JFrame mainFrame = new JFrame();
	private JPanel[] cards = new JPanel[15];
	private JPanel mainPanel = new JPanel();
	private ArrayList<OrderList> orderAl = new ArrayList<OrderList>();
	private Member accessMember = new Member();

	
	public void comInit() {

		mainPanel.setLayout(new CardLayout());
		cards[0] = new Login(mainPanel, mainFrame,orderAl,md,accessMember);
		cards[1] = new memberMainView(mainPanel, mainFrame,orderAl,md,accessMember);
		cards[2] = new MenuView(mainPanel, mainFrame, orderAl, md, accessMember);
		cards[3] = new OrderView(mainPanel, mainFrame, orderAl, md, accessMember);
		cards[4] = new GuiMember(mainPanel,accessMember); //사용자 나의정보확인 화면
		cards[5] = new ManagerGui(mainPanel);
		cards[6] = new GuiPersonalInfor(mainPanel); //사용자개인정보수정화면
		cards[7] = new SalesView(mainPanel);
		cards[8] = new GuiManegeMenu(mainPanel); //관리자메뉴관리화면
		cards[9] = new GuiAllmenu(mainPanel); //관리자메뉴관리화면 전체보기
		cards[10] = new GuiAddmenu(mainPanel); //관리자메뉴관리화면 메뉴추가
		cards[11] = new Guimodifymenu(mainPanel); //관리자메뉴관리화면 메뉴추가
		cards[12] = new GuiDeletemenu(mainPanel); //관리자메뉴관리화면 메뉴추가
	
		mainPanel.add(cards[0],"Login",0);
		mainPanel.add(cards[1],"memberMain",1);
		mainPanel.add(cards[2],"menu",2);
		mainPanel.add(cards[3],"order",3);
		mainPanel.add(cards[4],"member",4); //사용자 나의정보확인 화면
		mainPanel.add(cards[5],"admin",5);
		mainPanel.add(cards[6],"PersonalInfor",6); //사용자개인정보수정화면
		mainPanel.add(cards[7],"sales",7);
		mainPanel.add(cards[8],"ManegeMenu",8); //관리자메뉴관리화면
		mainPanel.add(cards[9],"Allmenu",9); //관리자메뉴관리화면 전체보기
		mainPanel.add(cards[10],"Addmenu",10); //관리자메뉴관리화면 메뉴추가
		mainPanel.add(cards[11],"modifymenu",11); //관리자메뉴관리화면 메뉴추가
		mainPanel.add(cards[12],"Deletemenu",12); //관리자메뉴관리화면 메뉴추가
		//this.add("login",login);
		mainFrame.add(mainPanel);
		//login.button1.addActionListener(this);
	}
	public MainView() {
		mainFrame.setSize(1000,800); //프레임 사이즈
		mainFrame.setLocationRelativeTo(null); //화면 가운데로 위치설정
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼시 아예다꺼버림
		mainFrame.setResizable(false);
		mainFrame.setLayout(new CardLayout());
		mainFrame.setTitle("Java다방");
		md.setGoodsName("americano");
		this.comInit(); //사용자 정의 메소드

		mainFrame.setVisible(true); //가시적으로 보여주어라
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}
