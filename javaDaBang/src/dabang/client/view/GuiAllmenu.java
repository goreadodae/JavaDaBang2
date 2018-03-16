package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dabang.client.controller.MenuManageControl;
import dabang.client.model.MenuManage;


public class GuiAllmenu extends JFrame{
	
	private JPanel p1 = new JPanel();
	private JLabel allmenutitle = new JLabel("전체 메뉴 보기");
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JButton back = new JButton("뒤로가기");
	//private ArrayList<JLabel> menuAllLabel = new ArrayList<JLabel>();
	private ArrayList<String> menuAll = new ArrayList<String>();
	
	MenuManageControl mCon = new MenuManageControl();
	
	public void p1 () { //제목
		p1.setSize(980,90);
		p1.setLocation(0,0);
		p1.setBackground(Color.red);
		this.add(p1);
		p1.add(allmenutitle);
		allmenutitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(allmenutitle,BorderLayout.WEST);
	}
	
	public void p2 () { //메뉴
		p2.setSize(980,570);
		p2.setLocation(0,90);
		p2.setBackground(Color.blue);
		for(int i=0;i<menuAll.size();i++) {
			p2.add(new Label(menuAll.get(i)));
		}
		this.add(p2);
	}
	
	public void p3 () { //뒤로가기
		p3.setSize(980,90);
		p3.setLocation(0,660);
		p3.setBackground(Color.red);
		this.add(p3);
		p3.add(back);
		p3.setLayout(new BorderLayout());
		p3.add(back,BorderLayout.CENTER);
		back.setFont(new Font("Serif",Font.BOLD,30));
	}
	
	private void comInit() {
		
		MenuManage m = new MenuManage();
		m.setMenuname("ㅁㄴㅇㄻㄴㅇㄹ");
		m.setMenuprice(10000);
		mCon.menuPlus(m);
		m.setMenuname("ㅁㄴㅇㄻㄴㅇㄹ");
		m.setMenuprice(10000);
		mCon.menuPlus(m);
		m.setMenuname("ㅁㄴㅇㄻㄴㅇㄹ");
		m.setMenuprice(10000);
		mCon.menuPlus(m);
		m.setMenuname("ㅁㄴㅇㄻㄴㅇㄹ");
		m.setMenuprice(10000);
		mCon.menuPlus(m);
		ArrayList<String> menuAll = mCon.selectAll();
		
	    this.p1();
		this.p2();
		this.p3();
	}
	
	public GuiAllmenu () {
		super("잡다방");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		comInit();
		this.setVisible(true);
	}



}
