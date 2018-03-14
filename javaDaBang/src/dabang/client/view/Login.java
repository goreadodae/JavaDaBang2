package dabang.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dabang.client.controller.LoginController;
import dabang.client.model.Member;
public  class Login extends JFrame implements ActionListener{
	private JPanel panel1 = new JPanel();//아이디
	private JPanel panel2 = new JPanel();//비밀번호
	private JPanel panel3 = new JPanel();//맨위에 
	private JPanel panel4 = new JPanel();//버튼
	private JPanel panel5 = new JPanel();//사진반쪽(위)
	private JPanel panel6 = new JPanel();//사진반쪽(아래)

	private JLabel label1 = new JLabel("ID");
	private JLabel label2 = new JLabel("PW");
	private JLabel label3 = new JLabel();//맨위
	private JLabel label4 = new JLabel();
	private JLabel label5 = new JLabel();
	private JTextField field1 = new JTextField(10);//아이디
	private JPasswordField field2 = new JPasswordField(10);//비밀번호
	private JButton button1 = new JButton("로그인");
	private JButton button2 = new JButton("비회원 주문");
	private JButton button3 = new JButton("회원가입");
	private ImageIcon picup = null;
	private ImageIcon picdown = null;
	private ImageIcon mainpic = null;

	private ImageIcon gaep  = null;
	private ImageIcon login = null;

	LoginController lCon = new LoginController();

	public Login() 
	{
		super("잡다방"); //이름설정
		//this.setTitle("이름") 이랑 같음
		this.setSize(1000,800); //프레임 사이즈
		this.setLocationRelativeTo(null); //화면 가운데로 위치설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //종료버튼시 아예다꺼버림
		this.setResizable(false);
		this.setLayout(new GridLayout(6,1));
		this.compInit(); //사용자 정의 메소드

		this.setVisible(true); //가시적으로 보여주어라
	}
	private void idgo()//아이디
	{
		panel1.setBackground(Color.WHITE);
		panel1.add(label1);//아이디
		panel1.add(field1);//칸
		this.add(panel1);
	}
	private void passwordgo()//비번
	{
		panel2.setBackground(Color.WHITE);
		panel2.add(label2);//비번
		panel2.add(field2);//비번칸
		this.add(panel2);
	}



	private void compInit() {
		picme();
		saygo();
		idgo();
		passwordgo();
		loginchang();
		pic1();
		pic2();


	}


	private void saygo() {
		panel3.setBackground(Color.WHITE);
		panel3.setPreferredSize(new Dimension(1,1));
		label3.setIcon(mainpic);
		panel3.add(label3);

		this.add(panel3);
	}
	private void loginchang()
	{
		panel4.setBackground(Color.WHITE);
		button1.setIcon(login);
		button1.setBackground(Color.WHITE);
		panel4.add(button1);
		panel4.add(button2);
		button3.setBackground(Color.WHITE);
		button3.setIcon(gaep);
		panel4.add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		


		this.add(panel4);
	}
	private void pic1()
	{
		panel5.setBackground(Color.YELLOW);
		panel5.setPreferredSize(new Dimension(1,1));
		label4.setIcon(picup);
		panel5.add(label4);

		this.add(panel5);

	}
	private void pic2()
	{
		panel6.setBackground(Color.LIGHT_GRAY);
		panel6.setPreferredSize(new Dimension(1,1));
		label5.setIcon(picdown);
		panel6.add(label5);


		this.add(panel6);
	}
	private void picme()
	{
		mainpic = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(100,90,Image.SCALE_DEFAULT));
		picup = new ImageIcon(new ImageIcon("1-1.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
		picdown = new ImageIcon(new ImageIcon("1-2.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
		gaep = new ImageIcon(new ImageIcon("gaep.jpg").getImage().getScaledInstance(150,30,Image.SCALE_DEFAULT));
		login = new ImageIcon(new ImageIcon("login.jpg").getImage().getScaledInstance(150,30,Image.SCALE_DEFAULT));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button3)
		{
			new Application();
		}
		else if(e.getSource()==button1) {
			if(field1.getText().length()==0) JOptionPane.showMessageDialog(null,"ID를 입력하여주세요");
			else {
				if(lCon.checkId(field1.getText())) {
					if(lCon.checkPwd(field1.getText(), field2.getText())) {
						JOptionPane.showMessageDialog(null,"로그인 성공");
					}
					else JOptionPane.showMessageDialog(null,"비밀번호를 확인하세요");
				}
				else JOptionPane.showMessageDialog(null,"ID를 확인하세요");
			}
		}


	}
}