package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class memberMainView extends JPanel implements ActionListener {

	private Font ft = new Font("Bitstream Vera Sans Mono",Font.BOLD,50);
	private Font ft2 = new Font("Bitstream Vera Sans Mono",Font.BOLD,30);
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();

	private JLabel storeName = new JLabel("JAVADABANG");
	private JLabel hi = new JLabel("안녕하세요 잡다방입니다");

	private JButton grade = new JButton(new ImageIcon(new ImageIcon("Image\\membermainview\\myinfo.jpg").getImage().getScaledInstance(500,250, Image.SCALE_DEFAULT)));
	private JButton order = new JButton(new ImageIcon(new ImageIcon("Image\\membermainview\\order.jpg").getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT)));
	private JButton custom = new JButton(new ImageIcon(new ImageIcon("Image\\membermainview\\customorder.jpg").getImage().getScaledInstance(500, 250,Image.SCALE_DEFAULT)));

	private JPanel mainPanel = null;

	private JButton logoutButton = new JButton("로그아웃");
	private void setImage()
	{
		//customImage = new ImageIcon(new ImageIcon("order.jpg").getImage().getScaledInstance(500,250, Image.SCALE_DEFAULT)); 

	}

	private void panel1()
	{
		p1.setSize(1000,70);
		p1.setLocation(0,100);
		p1.setBackground(Color.white);

		//인사
		hi.setSize(1000,100);
		hi.setLocation(340,70);
		hi.setFont(ft2);

		p1.add(hi);
		this.add(p1);

	}



	private void panel2()
	{
		p2.setSize(500,250);
		p2.setLocation(0,170);
		p2.setBackground(Color.BLUE);
		p2.setLayout(null);//주문버튼 넣을꺼임
		order.setSize(500,250);
		order.setLocation(0,0);
		p2.add(order);
		order.addActionListener(this);
		this.add(p2);
	}

	private void panel3()
	{
		p3.setSize(500,250);
		p3.setLocation(500,170);
		p3.setLayout(null);
		grade.setSize(500,250);
		grade.setLocation(0,0);
		p3.add(grade);
		grade.addActionListener(this);
		this.add(p3);

	}

	private void panel4()
	{
		p4.setSize(1000,250);
		p4.setLocation(0,420);
		p4.setBackground(Color.BLACK);
		p4.setLayout(null);

		//order.setPreferredSize(new Dimension(500,250));
		//order.setBorderPainted(false);
		//order.setFocusPainted(false);

		this.add(p4);

	}
	private void panel5()
	{
		p5.setSize(1000,130);
		p5.setLocation(0,670);
		p5.setBackground(Color.BLACK);
		p5.setLayout(null);
		this.add(p5);

	}



	private void comInit() {

		//잡다방이름
		storeName.setSize(1000,100);
		storeName.setLocation(340,0);
		storeName.setFont(ft);
		logoutButton.setSize(90,30);
		logoutButton.setLocation(850, 35);
		logoutButton.addActionListener(this);
		this.add(logoutButton);
		this.add(storeName);

		panel1();
		panel2();
		panel3();
		panel4();
		panel5();
	}

	public memberMainView(JPanel mainPanel)
	{
		this.setSize(1000,800);
		//		this.setTitle("잡다방");
		this.setLayout(null);
		//		this.setResizable(false);
		//		this.setLocationRelativeTo(null);
		//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setBackground(Color.BLACK);
		this.mainPanel = mainPanel;
		this.comInit();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==grade) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "member");
		}else if(e.getSource()==order) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "menu");
		}else if(e.getSource()==logoutButton) {
			mainPanel.remove(0);
			Login l = new Login(mainPanel);
			mainPanel.add(l,"Login",0);
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "Login");
		}
	}



}
