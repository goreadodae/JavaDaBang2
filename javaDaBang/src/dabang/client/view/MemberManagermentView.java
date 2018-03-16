package dabang.client.view;
import java.awt.BorderLayout;  
import dabang.client.model.Member;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.LoginController;
import dabang.client.controller.MemberController;
import dabang.client.controller.MemberManegermentController;
public class MemberManagermentView extends JFrame implements ActionListener{
	private JPanel titlepanel = new JPanel();//간판
	private JLabel label1 = new JLabel("회원관리");//타이틀에 할말
	private JPanel buttonpanel = new JPanel();//버튼넣은패널
	private JButton button1 = new JButton("수정");
	private JButton deletebutton = new JButton("삭제");
	private JButton exitbutton = new JButton("나가기");
	private JScrollPane scr = new JScrollPane();
	private ImageIcon picup = null;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll; 
	public MemberManagermentView() //메인 창 
	{
		super("회원관리"); //이름설정
		this.setSize(1000,500); //프레임 사이즈
		this.setLocationRelativeTo(null); //화면 가운데로 위치설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //종료버튼시 아예다꺼버림
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.compInit(); //사용자 정의 메소드
		this.setVisible(true); //가시적으로 보여주어라
	}

	private void compInit() 
	{	
		picture();
		title();
		table();
		button();
	}
	private void picture()
	{
		picup = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
	}
	private void title()//타이틀
	{
		label1.setIcon(picup);
		titlepanel.setBackground(Color.yellow);
		titlepanel.add(label1);
		titlepanel.setPreferredSize(new Dimension(1000,100));
		this.add(titlepanel);	
	}
	private void button()//밑에 버튼
	{
		buttonpanel.setBackground(Color.white);
		button1.addActionListener(this);//액션추가
		button1.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(button1);
		deletebutton.addActionListener(this);//액션추가
		deletebutton.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(deletebutton);
		exitbutton.addActionListener(this);//액션추가
		exitbutton.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(exitbutton);
		this.add(buttonpanel);
	}
	
	private void table()//표
	{
		Object [][] data = new Object[10][11];
	    Member testMem [] = new Member[11];
	    testMem[0] = new Member();
	    testMem[1] = new Member();
	    testMem[2] = new Member();
	    testMem[3] = new Member();
	    testMem[4] = new Member();
	    testMem[5] = new Member();
	    testMem[6] = new Member();
	    testMem[7] = new Member();
	    testMem[8] = new Member();
	    testMem[9] = new Member();



	    data[0] = new Object[11];
	    data[1] = new Object[11];
	    data[2] = new Object[11];
	    data[3] = new Object[11];
	    data[4] = new Object[11];
	    data[5] = new Object[11];
	    data[6] = new Object[11];
	    data[7] = new Object[11];
	    data[8] = new Object[11];
	    data[9] = new Object[11];

	    

	   for(int i=0;i<data.length;i++) 
	    {
	    	data[i][0] =testMem[i].getId();
	    	data[i][1] =testMem[i].getNickName();
	    	data[i][2] =testMem[i].getName();
	    	data[i][3] =testMem[i].getSclc();
	    	data[i][4] =testMem[i].getAgeY();
	    	data[i][5] =testMem[i].getAgeD();
	    	data[i][6] =testMem[i].getAgeM();
	    	data[i][7] =testMem[i].getGender();
	    	data[i][8] =testMem[i].getPhoneNumber();
	    	data[i][9] =testMem[i].getGrade();
	    	data[i][10] =testMem[i].getPoint();  									
	    }
		String[] columnName = {"아이디","별명","이름","양력","년도","월","일","성별","PH","등급","포인트"};
		model = new DefaultTableModel(data, columnName) {
		public boolean isCellEditable(int rowlndex,int mCollnDex) {
		return false;}};//수정불가코드
	    table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);//이동막기
		table.getTableHeader().setResizingAllowed(false);//크기조절막기
		scroll = new JScrollPane (table);//스크롤에 테이블넣음
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1000, 280));//스크롤크기
		add(scroll);//추가함		
	}	

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button1)
    {

    }
	if(e.getSource()==exitbutton)
	{
		this.dispose();
	}
}
/////////////////////////////////////////////// 되는지 실험하는곳 
public static void main(String[] args) {
	try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
	    }
	} catch (Exception e) {
	    // If Nimbus is not available, you can set the GUI to another look and feel.
	}
	new MemberManagermentView();
}
}
