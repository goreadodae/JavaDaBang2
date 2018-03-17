package dabang.client.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManagerGui extends JPanel{
	private JPanel p1 = new JPanel();//매출관리버튼 넣을 패널
	private JPanel p2 = new JPanel(); //메뉴관리버튼 넣을 패널
	private JPanel p3 = new JPanel();//재고관리버튼 넣을 패널
	private JPanel p4 = new JPanel(); //회원관리버튼 넣을 패널
	private JPanel p5 = new JPanel(); //가리개
	
	private JButton salesMgr = new JButton(new ImageIcon(new ImageIcon("salesmgr.jpg").getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT))); //매출관리
	private JButton menuMgr = new JButton(new ImageIcon(new ImageIcon("menumgr.jpg").getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT)));	//메뉴관리
	private JButton stockMgr = new JButton(new ImageIcon(new ImageIcon("stockmgr.jpg").getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT)));	//재고관리
	private JButton memberMgr = new JButton(new ImageIcon(new ImageIcon("membermgr.jpg").getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT))); //회원관리
	private JPanel mainPanel = null;
	
	
	private void setPanel1()
	{
		p1.setSize(500,300);
		p1.setLocation(0,100);
		p1.setBackground(Color.darkGray);
		p1.setLayout(null);
		salesMgr.setSize(500,300);
		salesMgr.setLocation(0,0);
		p1.add(salesMgr);
		this.add(p1);
	}
	private void setPanel2()
	{
		p2.setSize(500,300);
		p2.setLocation(500,100);
		p2.setBackground(Color.BLUE);
		p2.setLayout(null);
		menuMgr.setSize(500,300);
		menuMgr.setLocation(0,0);
		p2.add(menuMgr);
		this.add(p2);
		
	}
	private void setPanel3()
	{
		p3.setSize(500,300);
		p3.setLocation(0,400);
		p3.setBackground(Color.GREEN);
		p3.setLayout(null);
		stockMgr.setSize(500,300);
		stockMgr.setLocation(0,0);
		p3.add(stockMgr);
		this.add(p3);
		
	}
	private void setPanel4()
	{
		p4.setSize(500,300);
		p4.setLocation(500,400);
		p4.setBackground(Color.ORANGE);
		p4.setLayout(null);
		memberMgr.setSize(500, 300);
		memberMgr.setLocation(0,0);
		p4.add(memberMgr);
		this.add(p4);
	
		
	}
	private void setPanel5()
	{
		//밑바닥
		p5.setSize(1000,300);
		p5.setLocation(0,700);
		p5.setBackground(Color.black);
		p5.setLayout(null);
		this.add(p5);
		
	}
	
	private void comInit()
	{
		
		
		setPanel1();
		setPanel2();
		setPanel3();
		setPanel4();
		setPanel5();
		
	}
	 public ManagerGui(JPanel mainPanel) {
		 this.setSize(1000,800);
		 this.setLayout(null);
		 this.setBackground(Color.BLACK);
		 this.mainPanel  = mainPanel;
		 this.comInit();
		 this.setVisible(true);
		 
		
	}

}
