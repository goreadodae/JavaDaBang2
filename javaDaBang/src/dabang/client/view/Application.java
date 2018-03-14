package dabang.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dabang.client.controller.MemberController;
import dabang.client.model.Member;
public class Application extends JFrame implements ActionListener {
	MemberController mCon = new MemberController();
	Member m = new Member();
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();
	private JPanel panel9 = new JPanel();
	private JLabel label1 = new JLabel("이름");
	private JLabel label2 = new JLabel("ID");
	private JLabel label3 = new JLabel("PW");
	private JLabel label4 = new JLabel("생년월일");//콤보박스
	private JLabel label5 = new JLabel("P.H");
	private JLabel label6 = new JLabel("별명");
	private JLabel label7 = new JLabel("★★★★★회원가입을 합시다 ^ㅅ^★★★★★");
	private JLabel mainLabel = new JLabel();
	private JTextField nameField = new JTextField(5);//이름
	private JTextField idField = new JTextField(10);//아이디
	private JPasswordField pwdField = new JPasswordField(10);//비번
	private JTextField phoneField = new JTextField(13);//폰번
	private JTextField nickNameField = new JTextField(7);//닉네임
	private JButton button1 = new JButton("ID 중복확인");
	private JButton button4 = new JButton("닉네임 중복확인");
	private JButton button5 = new JButton("회원가입");
	private JButton button6 = new JButton("가입취소");
	private ImageIcon muzi = null;
	private JComboBox combox1 = new JComboBox();  //연도year
	private JComboBox combox2 = new JComboBox(); //달monthly
	private JComboBox combox3 = new JComboBox(); //일day
	private String year    [] = new String[98];  //연수
	private String monthly [] = new String[12];  //월
	private String day     [] = new String[31];  //일
	private JRadioButton solar = new JRadioButton("양력",false);
	private JRadioButton lunar = new JRadioButton("음력",false);

	private String id;        //아이디
	private String passWord;  //비밀번호
	private String nickName;  //별명 
	private String name;      //이름
	private int sclc;//0양력, 1음력
	private int ageY;
	private int ageM;
	private int ageD;
	private char gender;
	private String phoneNumber;  //폰번
	private String grade;     //회원등급
	private double point;     //포인트


	public Application() 
	{
		super("회원가입"); //이름설정
		//this.setTitle("이름") 이랑 같음
		this.setSize(400,600); //프레임 사이즈
		this.setLocationRelativeTo(null); //화면 가운데로 위치설정
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE); //종료버튼시 아예다꺼버림
		this.setResizable(false);
		this.setLayout(new GridLayout(9,0));
		this.compInit(); //사용자 정의 메소드

		this.setVisible(true); //가시적으로 보여주어라
	}
	private void NameAge()//이름
	{

		panel1.setBackground(Color.yellow);
		panel1.add(label1);//이름
		panel1.add(nameField);//칸

		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel1);
	}
	private void birthday()//생년월일
	{
		panel9.setBackground(Color.yellow);//배경
		panel9.add(label4);//생년월일 글자
		////////////////////////////////////////////////////////      
		for(int i=0;i<year.length;i++) {
			year[i] = Integer.toString(1920+i);
		}  //연수   
		combox1 = new JComboBox(year);//연수 콤박
		panel9.add(combox1);//추가
		/////////////////////////////////////////////////////////      

		for(int i=0;i<monthly.length;i++) {
			monthly[i] = Integer.toString(1+i);
		}  //연수   
		combox2 = new JComboBox(monthly);
		panel9.add(combox2);//월

		//////////////////////////////////////////////////////////
		for(int i=0;i<day.length;i++) {
			day[i] = Integer.toString(1+i);
		}  //연수   
		combox3 = new JComboBox(day);
		panel9.add(combox3);//일
		///////////////////////////////////////////////////////////      
		ButtonGroup bg = new ButtonGroup();
		bg.add(solar);
		bg.add(lunar);
		panel9.add(solar);
		panel9.add(lunar);
		panel9.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel9);
		
		combox1.addActionListener(this);
		combox2.addActionListener(this);
		combox3.addActionListener(this);
		solar.addActionListener(this);
		lunar.addActionListener(this);
	}
	private void idgo()//아이디
	{
		panel2.setBackground(Color.yellow);
		panel2.add(label2);//아이디
		panel2.add(idField);//칸
		panel2.add(button1);//중복
		
		button1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==button1)
				{
					if(mCon.memberCheck(id)) {
						JOptionPane.showMessageDialog(null,"중복된 ID입니다. 다시 입력해주세요");
					}
					else {
						JOptionPane.showMessageDialog(null,"해당ID는 가입가능합니다");
					}
					
				}}});   
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel2);
	}
	
	private void passwordgo()//비번
	{
		panel3.setBackground(Color.yellow);
		panel3.add(label3);//비번
		panel3.add(pwdField);//비번칸
		pwdField.setText("");
		passWord = pwdField.getText();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel3);
	}
	private void phonenumbergo()//전번
	{
		panel5.setBackground(Color.YELLOW);//전번배경
		panel5.add(label5);//전번
		panel5.add(phoneField);//전번칸
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));//왼쪽으로썌려박음
		this.add(panel5);//패널추가
	}
	private void nicknamego()//닉네임
	{
		panel6.setBackground(Color.yellow);
		panel6.add(label6);//닉네임
		panel6.add(nickNameField);//닉네임칸
		panel6.add(button4);//중복확인칸
		button4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==button4)
				{
					JOptionPane.showMessageDialog(null,"해당 닉네임은 가입가능합니다");
				}}});   
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel6);
	}
	private void setImage()
	{

		muzi = new ImageIcon(new ImageIcon("400x122.jpg").getImage().getScaledInstance(400,55,Image.SCALE_DEFAULT));
	}

	private void yesno()
	{
		panel4.setBackground(Color.yellow);
		panel4.add(button5); 
		button5.addActionListener(this); 
		panel4.add(button6);
		button6.addActionListener(this);
		this.add(panel4);

	}

	private void compInit()
	{  
		setImage();
		say();
		NameAge();
		birthday();
		idgo();
		passwordgo();
		nicknamego();
		phonenumbergo();
		imagego();
		yesno();

	}

	private void say()
	{
		panel7.setBackground(Color.yellow);
		panel7.add(label7);
		this.add(panel7);
	}
	private void imagego()
	{
		panel8.setBackground(Color.yellow);
		panel8.setPreferredSize(new Dimension(1,1));
		mainLabel.setIcon(muzi);
		panel8.add(mainLabel);
		this.add(panel8);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button6)
		{
			this.dispose();
		}
		else if(e.getSource()==combox1) {
			ageY = Integer.valueOf((String)combox1.getSelectedItem());
		}
		else if(e.getSource()==combox2) {
			ageM = Integer.valueOf((String)combox2.getSelectedItem());
		}
		else if(e.getSource()==combox3) {
			ageD = Integer.valueOf((String)combox3.getSelectedItem());
		}
		else if(e.getSource()==solar) {
			sclc = 1;
		}
		else if(e.getSource()==lunar) {
			sclc = 2;
		}else if(e.getSource()==button5) {
			System.out.println(idField.getText());
			System.out.println(pwdField.getText());
			System.out.println(nickNameField.getText());
			System.out.println(nameField.getText());
			System.out.println(sclc);
			System.out.println(ageY);
			System.out.println(ageM);
			System.out.println(ageD);
			System.out.println(gender);
			System.out.println(phoneField.getText());
			m = new Member(idField.getText(),pwdField.getText(),nickNameField.getText(),nameField.getText(),
					sclc,ageY,ageM,ageD,gender,phoneField.getText(),"Welcome",0.0);
			if(mCon.memberJoin(m)) {
				JOptionPane.showMessageDialog(null,"가입에 성공하였습니다.");
			}else {
				JOptionPane.showMessageDialog(null,"가입에 실패하였습니다.");
			}
			this.dispose();
		}
	}
}

