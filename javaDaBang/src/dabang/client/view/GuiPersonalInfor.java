package dabang.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GuiPersonalInfor extends JPanel implements ActionListener {

	private JPanel p1 = new JPanel(); //제목
	private JLabel modifytitle = new JLabel("개인 정보 확인 및 수정");
	
	private JPanel p2 = new JPanel(); //아이디
	private JLabel modifyid = new JLabel("  아이디");
	private JLabel modifyidlabel = new JLabel("ID입니당");
	
	private JPanel p3 = new JPanel(); //이름 /남,여
	private JLabel modifyname = new JLabel("  이름");
	private JTextField modifynametext = new JTextField(10);
	private JRadioButton man = new JRadioButton("남",false);
	private JRadioButton woman = new JRadioButton("여",false);
	
	private JPanel p4 = new JPanel(); //생년월일
	private JLabel birthtitle = new JLabel("  생년월일");
	private JComboBox birthbox = new JComboBox();
	private JComboBox monthbox = new JComboBox();
	private JComboBox datebox = new JComboBox();
	private JComboBox sclcbox = new JComboBox();
	
	private JPanel p5 = new JPanel(); //휴대폰
	private JLabel modifynumber = new JLabel(" 휴대폰");
	private JTextField modifynumbertext = new JTextField(20);
	private JCheckBox chagree = new JCheckBox("SMS를 통한 이벤트 정보수신에 동의합니다[선택]",false);
	
	private JPanel p6 = new JPanel(); //별명
	private JLabel modifynickname = new JLabel(" 별명");
	private JTextField modifynicknametext = new JTextField(7);
	private JButton overnickname = new JButton("중복확인");
	
	private JPanel p7 = new JPanel(); //광고사진
	private ImageIcon banner01 = new ImageIcon("1카라멜마키아또.jpg");
	private JLabel banner01label = new JLabel(banner01);
	private ImageIcon banner02 = new ImageIcon("2그린 티 프라푸치노.jpg");
	private JLabel banner02label = new JLabel(banner01);
	private ImageIcon banner03 = new ImageIcon("3얼 그레이 티.jpg");
	private JLabel banner03label = new JLabel(banner01);
	
	private JPanel p8 = new JPanel(); //수정
	private JButton save = new JButton("수정하기");
	
	private JPanel p9 = new JPanel(); //취소
	private JButton cancel = new JButton("취소하기");

	private JPanel mainPanel = null;
	
	public void p1 () { //제목
		p1.setSize(980,80);
		p1.setLocation(0,0);
		//p1.setBackground(Color.blue);
		this.add(p1);
		p1.add(modifytitle);
		modifytitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(modifytitle,BorderLayout.WEST);
	}

	public void p2 () { //아이디
		p2.setSize(600,120);
		p2.setLocation(0,80);
		p2.setBackground(Color.red);
		this.add(p2);
		p2.setLayout(new GridLayout(2,1));
		JPanel p21 = new JPanel();
		JPanel p22 = new JPanel();
		p2.add(p21);
		p2.add(p22);
		p21.add(modifyid);
		modifyid.setFont(new Font("Serif",Font.BOLD,25));
		p21.setLayout(new BorderLayout());
		p21.add(modifyid,BorderLayout.WEST);
		p22.add(modifyidlabel);
		
	}

	public void p3 () { //이름/남,여
		p3.setSize(600,135);
		p3.setLocation(0,200);
		//p3.setBackground(Color.green);
		this.add(p3);
		p3.setLayout(new GridLayout(2,1));
		JPanel p31 = new JPanel();
		JPanel p32 = new JPanel();
		p3.add(p31);
		p3.add(p32);
		p31.add(modifyname);
		modifyname.setFont(new Font("Serif",Font.BOLD,25));
		p31.setLayout(new BorderLayout());
		p31.add(modifyname,BorderLayout.WEST);
		p32.setLayout(new GridLayout(1,2));
		JPanel p321 = new JPanel();
		JPanel p322 = new JPanel();
		p32.add(p321);
		p32.add(p322);
		p321.add(modifynametext);
		modifynametext.setFont(new Font("Serif",Font.BOLD,30));
		ButtonGroup gender = new ButtonGroup();
		gender.add(man);
		gender.add(woman);
		p322.add(man);
		p322.add(woman);
	}

	public void p4 () { //생년월일
		p4.setSize(600,150);
		p4.setLocation(0,335);
		//p4.setBackground(Color.white);
		p4.setLayout(new GridLayout(2,1));
		JPanel p41 = new JPanel();
		JPanel p42 = new JPanel();
		p4.add(p41);
		p4.add(p42);
		this.add(p4);
		ArrayList<String> birth = new ArrayList<String>();
		String month[] = new String[12];
		String date[] = new String[32];
		String sclc[] = {"양","음"};
		
		int year = 1920;
		while(true) {
			 birth.add(Integer.toString(year++));
			 if(year==2019) break;
		}
		for(int i=0;i<birth.size();i++) {
			birthbox.addItem(birth.get(i));
		}
		for(int i=0;i<12;i++) {
			 month [i] = Integer.toString(i+1);
		}
		for(int i=0;i<month.length;i++) {
			monthbox.addItem(month[i]);
		}
		for(int i=0;i<31;i++) {
			 date [i] = Integer.toString(i+1);
		}
		for(int i=0;i<date.length;i++) {
			datebox.addItem(date[i]);
		}
		for(int i=0;i<sclc.length;i++) {
			sclcbox.addItem(sclc[i]);
		}
		
		birthbox.setPreferredSize(new Dimension(130,50));
		monthbox.setPreferredSize(new Dimension(130,50));
		datebox.setPreferredSize(new Dimension(130,50));
		sclcbox.setPreferredSize(new Dimension(130,50));
		
		p41.add(birthtitle);
		birthtitle.setFont(new Font("Serif",Font.BOLD,25));
		p41.setLayout(new BorderLayout());
		p41.add(birthtitle,BorderLayout.WEST);
		p42.add(birthbox);
		p42.add(monthbox);
		p42.add(datebox);
		p42.add(sclcbox);
		

	}

	public void p5 () { //휴대폰
		p5.setSize(600,150);
		p5.setLocation(0,485);
		//p5.setBackground(Color.yellow);
		this.add(p5);
		p5.setLayout(new GridLayout(3,1));
		JPanel p51 = new JPanel();
		JPanel p52 = new JPanel();
		JPanel p53 = new JPanel();
		p5.add(p51);
		p5.add(p52);
		p5.add(p53);
		p51.add(modifynumber);
		modifynumber.setFont(new Font("Serif",Font.BOLD,25));
		p51.setLayout(new BorderLayout());
		p51.add(modifynumber,BorderLayout.WEST);
		p52.add(modifynumbertext);
		modifynumbertext.setFont(new Font("Serif",Font.BOLD,30));
		modifynicknametext.setSize(500, 35);
		p53.add(chagree);
	}

	public void p6 () { //별명
		p6.setSize(380,255);
		p6.setLocation(600,80);
		p6.setBackground(Color.orange);
		this.add(p6);
		p6.setLayout(new GridLayout(2,1));
		JPanel p61 = new JPanel();
		JPanel p62 = new JPanel();
		p6.add(p61);
		p61.add(modifynickname);
		modifynickname.setFont(new Font("Serif",Font.BOLD,25));
		p61.setLayout(new BorderLayout());
		p61.add(modifynickname,BorderLayout.WEST);
		p6.add(p62);
		p62.setLayout(new GridLayout(1,2));
		JPanel p621 = new JPanel();
		JPanel p622 = new JPanel();
		p62.add(p621);
		p62.add(p622);
		p621.add(modifynicknametext);
		modifynicknametext.setFont(new Font("Serif",Font.BOLD,30));
		p622.add(overnickname);
		

	}

	public void p7 () { //사진
		p7.setSize(380,300);
		p7.setLocation(600,335);
		p7.setBackground(Color.pink);
		this.add(p7);
		
		
		p7.add(banner01label);
		
		
		//p7.setLayout(new BorderLayout());
		//p7.add(banner01rlabel,BorderLayout.CENTER);

	}

	public void p8 () { //저장
		p8.setSize(490,115);
		p8.setLocation(0,635);
		p8.setBackground(Color.white);
		this.add(p8);
		
		p8.setLayout(new BorderLayout());
		p8.add(save,BorderLayout.CENTER);
		save.setFont(new Font("Serif",Font.BOLD,30));
	}

	public void p9 () { //취소
		p9.setSize(490,115);
		p9.setLocation(490,635);
		p9.setBackground(Color.red);
		this.add(p9);
		
		p9.setLayout(new BorderLayout());
		p9.add(cancel,BorderLayout.CENTER);
		cancel.setFont(new Font("Serif",Font.BOLD,30));
		cancel.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancel) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "member");
		}
		
	}

	public void comInit() { 
		p1();
		p2();
		p3();
		p4();
		p5();
		p6();
		p7();
		p8();
		p9();
	}

	public GuiPersonalInfor (JPanel mainPanel) {
		this.setSize(1000,800);
		this.setLayout(null);
		this.mainPanel = mainPanel;
		this.comInit();
		this.setVisible(true);
	}


}

