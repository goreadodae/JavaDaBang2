package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dabang.client.controller.LoginController;
import dabang.client.controller.MemberController;
import dabang.client.model.Member;
import dabang.client.model.Menu;
import dabang.client.model.MenuDrink;
public  class Login extends JPanel implements ActionListener,KeyListener{
	private static Color bgc = new Color(246,245,239);
	private JPanel panel1 = new JPanel();//아이디
	private JPanel panel2 = new JPanel();//비밀번호
	private JPanel panel3 = new JPanel();//맨위에 
	private JPanel panel4 = new JPanel();//버튼
	private JPanel southPanel5 = new JPanel();//사진반쪽(위)

	private JPanel centerPanel1 = new JPanel();
	private JPanel centerPanel2 = new JPanel();
	private JPanel centerPanel3 = new JPanel();
	private JPanel centerPanelParent = new JPanel();

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
	private ImageIcon logo = null;

	private JComboBox loginSelect = null;
	private String [] loginSel = new String[] {"사용자","관리자"};
	private JPanel mainPanel = null;


	LoginController lCon = new LoginController();
	private int loginSuccess = 0;//0로그인 실패, 1사용자 로그인, 2관리자 로그인
	private JLabel logoLabel = new JLabel();
	private Member accessMember = new Member();
	private MenuDrink md = new MenuDrink();
	private JFrame mainFrame = new JFrame();
	private ArrayList<Menu> orderAl = new ArrayList<Menu>();
	public Login(JPanel mainPanel, JFrame mainFrame, ArrayList<Menu> orderAl, MenuDrink md,
			Member accessMember) 
	{
		//		super("잡다방"); //이름설정
		//this.setTitle("이름") 이랑 같음
		this.setSize(1000,800); //프레임 사이즈
		//		this.setLocationRelativeTo(null); //화면 가운데로 위치설정
		//		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //종료버튼시 아예다꺼버림
		//		this.setResizable(false);
		this.mainPanel = mainPanel;
		this.accessMember  = accessMember;
		this.md = md;
		this.mainFrame = mainFrame;
		this.orderAl = orderAl;
		this.setLayout(new BorderLayout());
		this.compInit(); //사용자 정의 메소드

		this.setVisible(true); //가시적으로 보여주어라
	}
	private void idgo()//아이디
	{
		panel1.setBackground(bgc);
		panel1.add(label1);//아이디
		panel1.add(field1);//칸
		field1.addKeyListener(this);
		centerPanel2.add(panel1);
	}
	private void passwordgo()//비번
	{
		panel2.setBackground(bgc);
		panel2.add(label2);//비번
		panel2.add(field2);//비번칸
		field2.addKeyListener(this);
		centerPanel2.add(panel2);
	}

	private void adminClient() {
		JPanel selectPanel = new JPanel();
		loginSelect = new JComboBox(loginSel);
		selectPanel.add(loginSelect);
		selectPanel.setBackground(bgc);
		selectPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		selectPanel.setPreferredSize(new Dimension(50,30));
		centerPanel2.add(selectPanel);
	}

	private void centerPan() {
		centerPanel2.setLayout(new GridLayout(5,1));
		centerPanelParent.add(centerPanel1);
		centerPanelParent.add(centerPanel2);
		centerPanelParent.add(centerPanel3);
		centerPanel1.setBackground(bgc);
		centerPanel2.setBackground(bgc);
		centerPanel3.setBackground(bgc);
		centerPanelParent.setBackground(bgc);
		centerPanel1.setPreferredSize(new Dimension(320,600));
		centerPanel2.setPreferredSize(new Dimension(320,600));
		centerPanel3.setPreferredSize(new Dimension(320,600));
		centerPanelParent.setPreferredSize(new Dimension(2000,600));
		this.add(centerPanelParent, BorderLayout.NORTH);
	}
	private void compInit() {
		lCon.startLogin();
		picme();
		centerPan();
		saygo();
		idgo();
		passwordgo();
		adminClient();
		loginchang();
		pic1();
	}


	private void saygo() {
		panel3.setBackground(bgc);
		panel3.setPreferredSize(new Dimension(1,1));
		//label3.setIcon(mainpic);
		panel3.add(label3);

		centerPanel2.add(panel3);
	}
	private void loginchang()
	{
		panel4.setBackground(bgc);
		button1.setBackground(bgc);
		panel4.add(button1);
		panel4.add(button2);
		button3.setBackground(bgc);
		panel4.add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);



		centerPanel2.add(panel4);
	}
	private void pic1()
	{
		southPanel5.setBackground(bgc);
		southPanel5.setPreferredSize(new Dimension(1000,200));
		//label4.setIcon(picup);
		southPanel5.add(label4);

		this.add(southPanel5,BorderLayout.SOUTH);

	}

	private void picme()
	{
		logo = new ImageIcon(new ImageIcon("Image\\LoginImage\\logo.png").getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
		JLabel logoLabel = new JLabel("asdf");
		logoLabel.setIcon(logo);
		logoLabel.setPreferredSize(new Dimension(300,300));
		//		logoPanel.setBackground(Color.black);
		centerPanel1.add(logoLabel);
	}
	public int isLogin() {
		return loginSuccess;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button3)
		{
			new Application(lCon);
		}
		else if(e.getSource()==button1) {
			if(loginSelect.getSelectedItem()=="사용자") {
				if(field1.getText().length()==0) JOptionPane.showMessageDialog(null,"ID를 입력하여주세요");
				else {
					if(lCon.checkId(field1.getText())) {
						if(lCon.checkPwd(field1.getText(), field2.getText())) {
							MemberController mCon = lCon.memCon();
							accessMember = mCon.memberSelect(field1.getText());
							JOptionPane.showMessageDialog(null,"로그인 성공");
							mainPanel.remove(1);
							memberMainView mmv = new memberMainView(mainPanel, mainFrame,orderAl,md,accessMember);
							mainPanel.add(mmv,"memberMain",1);
							((CardLayout)mainPanel.getLayout()).show(mainPanel, "memberMain");
						}
						else JOptionPane.showMessageDialog(null,"비밀번호를 확인하세요");
					}
					else JOptionPane.showMessageDialog(null,"ID를 확인하세요");
				}
			}
			else if(loginSelect.getSelectedItem()=="관리자") {
				if(lCon.checkAdmin(field1.getText())) {
					if(lCon.ckeckAdminPwd(field2.getText())) {
						JOptionPane.showMessageDialog(null,"로그인 성공");
						((CardLayout)mainPanel.getLayout()).show(mainPanel, "admin");
					}
					else JOptionPane.showMessageDialog(null,"비밀번호를 확인하세요");
				}
				else JOptionPane.showMessageDialog(null,"ID를 확인하세요");
			}
		}


	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			button1.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}