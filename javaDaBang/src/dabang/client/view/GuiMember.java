package dabang.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiMember extends JPanel implements ActionListener {
	
	private JPanel membergrade = new JPanel();
	private JPanel membervisit = new JPanel();
	private JPanel managebutton = new JPanel();
	private JPanel backmain = new JPanel();
	
	private JButton menageinforbutton = new JButton("나의 정보 관리");
	private JButton receiptbutton = new JButton("영수증");
	private JButton backmainbutton = new JButton("뒤로가기");
	
	private ImageIcon welcome = new ImageIcon("Image/MyInforImage/welcomelevel.jpg");
	private JLabel welcomelabel = new JLabel(welcome);
	private ImageIcon star = new ImageIcon("Image/MyInforImage/star.png");
	private JLabel starlabel = new JLabel(star);
	
	private JLabel countvisit = new JLabel("나의 방문 횟수 ");
	private JLabel countLabel = null;
	private int count =0;
	
	private JPanel mainPanel = null;
	
	public void membergrade () {
		membergrade.setSize(396,490);
		membergrade.setLocation(0,0);
		membergrade.setBackground(Color.WHITE);
		membergrade.add(welcomelabel);
		membergrade.setLayout(new BorderLayout());
		membergrade.add(welcomelabel,BorderLayout.CENTER);
		this.add(membergrade);
	}
	
	public void membervisit () {
		membervisit.setSize(596, 490);
		membervisit.setLocation(396, 0);
		membervisit.add(starlabel);
		membervisit.setLayout(new BorderLayout());
		membervisit.add(starlabel,BorderLayout.CENTER);
		starlabel.add(countvisit);
		countvisit.setFont(new Font("Serif",Font.BOLD,17));
		countvisit.setBounds(100, 60, 145, 30);
		countLabel = new JLabel(Integer.toString(count));
		countLabel.setFont(new Font("Serif",Font.BOLD,100));
		starlabel.add(countLabel);
		countLabel.setBounds(277, 140, 100, 100);
		this.add(membervisit);
	}
	
	public void managebutton () {
		managebutton.setSize(992, 275);
		managebutton.setLocation(0,490);
		this.add(managebutton);
		managebutton.setLayout(new GridLayout(2,1));
		JPanel managebutton01 = new JPanel();
		JPanel managebutton02 = new JPanel();
		managebutton.add(managebutton01);
		managebutton.add(managebutton02);
		managebutton01.setLayout(new GridLayout(1,2));
		JPanel myinformanage = new JPanel();
		JPanel myreceipt = new JPanel();
		managebutton01.add(myinformanage);
		managebutton01.add(myreceipt);
		myinformanage.add(menageinforbutton);
		myinformanage.setLayout(new BorderLayout());
		myinformanage.add(menageinforbutton,BorderLayout.CENTER);
		menageinforbutton.setFont(new Font("Serif",Font.BOLD,30));
		menageinforbutton.addActionListener(this);
		
		myreceipt.add(receiptbutton);
		myreceipt.setLayout(new BorderLayout());
		myreceipt.add(receiptbutton,BorderLayout.CENTER);
		receiptbutton.setFont(new Font("Serif",Font.BOLD,30));
		managebutton02.add(backmainbutton);
		managebutton02.setLayout(new BorderLayout());
		managebutton02.add(backmainbutton,BorderLayout.CENTER);
		backmainbutton.setFont(new Font("Serif",Font.BOLD,30));
		backmainbutton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menageinforbutton) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "PersonalInfor");
		}else if(e.getSource()==receiptbutton) {
			
		}else if(e.getSource()==backmainbutton) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "memberMain");
		}
		
	}
	
	private void comInit() {
		membergrade();
		membervisit();
		managebutton();
	}

	public GuiMember (JPanel mainPanel) {
		this.setSize(1000,800);
		this.setLayout(null);
		this.mainPanel = mainPanel;
		this.comInit();
		this.setVisible(true);
	}

}
