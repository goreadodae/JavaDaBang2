package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import dabang.client.controller.MemberController;

public class ManagerGui extends JPanel implements ActionListener{
	private static Color bgc = new Color(246,245,239);
	private JPanel p1 = new JPanel();//매출관리버튼 넣을 패널
	private JPanel p2 = new JPanel(); //메뉴관리버튼 넣을 패널
	private JPanel p3 = new JPanel();//재고관리버튼 넣을 패널
	private JPanel p4 = new JPanel(); //회원관리버튼 넣을 패널
	
	private JButton salesMgr = new JButton(new ImageIcon(new ImageIcon("Image\\AdminMainIamge\\salesmgr.jpg").getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT))); //매출관리
	private JButton menuMgr = new JButton(new ImageIcon(new ImageIcon("Image\\AdminMainIamge\\menumgr.jpg").getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT)));	//메뉴관리
	private JButton stockMgr = new JButton(new ImageIcon(new ImageIcon("Image\\AdminMainIamge\\stockmgr.jpg").getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT)));	//재고관리
	private JButton memberMgr = new JButton(new ImageIcon(new ImageIcon("Image\\AdminMainIamge\\membermgr.jpg").getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT))); //회원관리
	private JPanel mainPanel = null;
	
	private JButton logoutButton = new JButton("로그아웃");
	private JPanel menuPanel = new JPanel();
	private void setPanel1()
	{
		p1.setSize(500,300);
		p1.setLocation(0,100);
		p1.setBackground(bgc);
		p1.setLayout(null);
		salesMgr.setSize(500,300);
		salesMgr.setLocation(0,0);
		salesMgr.addActionListener(this);
		p1.add(salesMgr);
		menuPanel.add(p1);
	}
	private void setPanel2()
	{
		p2.setSize(500,300);
		p2.setLocation(500,100);
		p2.setBackground(bgc);
		p2.setLayout(null);
		menuMgr.setSize(500,300);
		menuMgr.setLocation(0,0);
		menuMgr.addActionListener(this);
		p2.add(menuMgr);
		menuPanel.add(p2);
		
	}
	private void setPanel3()
	{
		p3.setSize(500,300);
		p3.setLocation(0,400);
		p3.setBackground(bgc);
		p3.setLayout(null);
		stockMgr.setSize(500,300);
		stockMgr.setLocation(0,0);
		p3.add(stockMgr);
		menuPanel.add(p3);
		
	}
	private void setPanel4()
	{
		p4.setSize(500,300);
		p4.setLocation(500,400);
		p4.setBackground(bgc);
		p4.setLayout(null);
		memberMgr.setSize(500, 300);
		memberMgr.setLocation(0,0);
		p4.add(memberMgr);
		menuPanel.add(p4);
	
		
	}

	private void logout() {
		JPanel logoutPanel = new JPanel();
		logoutButton.setPreferredSize(new Dimension(90,30));

		logoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,54,35));
		logoutPanel.add(logoutButton);
		logoutPanel.setBackground(bgc);
		this.add(logoutPanel,BorderLayout.NORTH);
		logoutButton.addActionListener(this);
	}
	
	private void comInit()
	{
		menuPanel.setLayout(new GridLayout(2,2));
		this.add(menuPanel);
		logout();
		setPanel1();
		setPanel2();
		setPanel3();
		setPanel4();
		
		
	}
	 public ManagerGui(JPanel mainPanel) {
		 this.setSize(1000,800);
		 this.setLayout(new BorderLayout());
		 this.setBackground(Color.BLACK);
		 this.mainPanel  = mainPanel;
		 this.comInit();
		 this.setVisible(true);
		 
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==logoutButton) {
			mainPanel.remove(0);
			Login l = new Login(mainPanel,null,null,null,null);//수정해야함
			mainPanel.add(l,"Login",0);
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "Login");
		}else if(e.getSource()==salesMgr) {
			mainPanel.remove(7);
			SalesView sv = new SalesView(mainPanel);
			mainPanel.add(sv,"sales",7);
			((CardLayout)mainPanel.getLayout()).show(mainPanel,"sales");
		}else if(e.getSource()==menuMgr) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel,"ManegeMenu");
		}
	}

}
