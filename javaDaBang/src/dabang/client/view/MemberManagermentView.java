package dabang.client.view;
import java.awt.BorderLayout;
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
import java.lang.reflect.Member;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.MemberController;
public class MemberManagermentView extends JFrame implements ActionListener{
	private JPanel panel1 = new JPanel();//간판
	private JLabel label1 = new JLabel("회원관리");//한마디
	private JPanel panel2 = new JPanel();//버튼2개
	private JPanel panel3 = new JPanel();
	private JButton button1 = new JButton("추가");
	private JButton button2 = new JButton("삭제");
	private JButton button3 = new JButton("나가기");
	private JScrollPane scr = new JScrollPane();
	private ImageIcon picup = null;
	public MemberManagermentView() 
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
		p1();
		p3();
		p2();
		picture();
		
	}
	private void picture()
	{
		picup = new ImageIcon(new ImageIcon("1-1.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
	}
	private void p1()//타이틀
	{
		panel1.setBackground(Color.yellow);
		panel1.add(label1);
		panel1.setPreferredSize(new Dimension(1000,100));
		this.add(panel1);
		
	}
	private void p2()//밑에 버튼
	{
		panel2.setBackground(Color.white);
		button1.setPreferredSize(new Dimension(330, 70));
		panel2.add(button1);
		button2.setPreferredSize(new Dimension(330, 70));
		panel2.add(button2);
		button3.addActionListener(this);
		button3.setPreferredSize(new Dimension(330, 70));
		panel2.add(button3);
		this.add(panel2);
	}
	private void p3()//표
	{
		
		Object[][] data = {{"ㅇ","ㅎㅇ"},{"ㅇ","ㅎㅇ"},{"ㅇ","ㅎㅇ"},{"ㅇ","ㅎㅇ"},{"ㅇ","ㅎㅇ"},{"ㅇ","ㅎㅇ"},{"ㅇ","ㅎㅇ"}};
		String[] columnName = {"아이디","별명","이름","양력","년도","월","일","성별","PH","등급","포인트"};
		DefaultTableModel model = new DefaultTableModel(data, columnName);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane (table);
		scroll.setPreferredSize(new Dimension(1000, 280));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(scroll);		
	}	
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button3)
	{
		this.dispose();
	}
		
}
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

