package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dabang.client.controller.MenuManageControl;
import dabang.client.model.MenuManage;

public class GuiAddmenu extends JPanel implements ActionListener{

	private JPanel p1 = new JPanel();
	private JLabel addmenutitle = new JLabel("  메뉴 추가");
	private JPanel p2 = new JPanel();
	
	private JLabel addEgmenunamelabel = new JLabel("   영어 메뉴명");
	private JTextField taddEgmenu = new JTextField(25);
	private JLabel addKormenunamelabel = new JLabel("   한글 메뉴명");
	private JTextField taddKormenu = new JTextField(25);
	
	private JLabel addmenupricelabel = new JLabel("   가격");
	private JTextField tprice = new JTextField(25);
	private JLabel addmenupicturelabel = new JLabel("   메뉴종류 번호(1:에스프레소 2:프라푸치노 3:티 4:디저트) &사진");
	private JPanel p3 = new JPanel();
	private JComboBox kindofmuenubox = new JComboBox(); //메뉴종류 선택 콤보박스
	private String addmenupictureaddr=null;
	private JButton calladdrbutton = new JButton("불러오기");
	private JButton save = new JButton("추가하기");
	private JButton cancel = new JButton("취소하기");

	private JPanel mypanel = this;
	private JPanel mainPanel = new JPanel();

	private Properties props = new Properties();
	
	MenuManageControl menuCon = new MenuManageControl();

	public void p1 () { //제목
		p1.setSize(980,90);
		p1.setLocation(0,0);
		//p1.setBackground(Color.red);
		this.add(p1);
		p1.add(addmenutitle);
		addmenutitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(addmenutitle,BorderLayout.WEST);
	}

	public void p2 () { //메뉴추가
		MenuManage m = new MenuManage();
		p2.setSize(980,570);
		p2.setLocation(0,90);
		//p2.setBackground(Color.blue);
		this.add(p2);
		
		p2.setLayout(new GridLayout(3,1));
		JPanel p21 = new JPanel();
		JPanel p22 = new JPanel();
		JPanel p23 = new JPanel();
		p2.add(p21);
		p2.add(p22);
		p2.add(p23);
		
		p21.setLayout(new GridLayout(2,2));
		JPanel p211 = new JPanel();
		JPanel p212 = new JPanel();
		JPanel p213 = new JPanel();
		JPanel p214 = new JPanel();
		p21.add(p211);
		p21.add(p212);
		p21.add(p213);
		p21.add(p214);
		
		p211.add(addEgmenunamelabel);
		p212.add(addKormenunamelabel);
		p213.add(taddEgmenu);
		p214.add(taddKormenu);
		addEgmenunamelabel.setFont(new Font("Serif",Font.BOLD,30));
		p211.setLayout(new BorderLayout());
		p211.add(addEgmenunamelabel,BorderLayout.CENTER);
		addKormenunamelabel.setFont(new Font("Serif",Font.BOLD,30));
		p212.setLayout(new BorderLayout());
		p212.add(addKormenunamelabel,BorderLayout.CENTER);
		
		taddEgmenu.setFont(new Font("Serif",Font.BOLD,25));
		p213.setLayout(new BorderLayout());
		p213.add(taddEgmenu,BorderLayout.CENTER);
		taddKormenu.setFont(new Font("Serif",Font.BOLD,25));
		p214.setLayout(new BorderLayout());
		p214.add(taddKormenu,BorderLayout.CENTER);

		p22.setLayout(new GridLayout(2,1));
		JPanel p221 = new JPanel();
		JPanel p222 = new JPanel();
		p22.add(p221);
		p22.add(p222);
		
		p221.add(addmenupricelabel);
		p222.add(tprice);
		
		addmenupricelabel.setFont(new Font("Serif",Font.BOLD,30));
		p221.setLayout(new BorderLayout());
		p221.add(addmenupricelabel,BorderLayout.CENTER);
		
		tprice.setFont(new Font("Serif",Font.BOLD,25));
		p222.setLayout(new BorderLayout());
		p222.add(tprice,BorderLayout.CENTER);
	
		
		p23.setLayout(new GridLayout(2,1));
		JPanel p231 = new JPanel();
		JPanel p232 = new JPanel();
		p23.add(p231);
		p23.add(p232);
		p231.add(addmenupicturelabel);
		addmenupicturelabel.setFont(new Font("Serif",Font.BOLD,30));
		p231.setLayout(new BorderLayout());
		p231.add(addmenupicturelabel,BorderLayout.WEST);
//		p232.add(addmenupictureaddr);
		String kindofmenu [] = new String[4];
		
		for(int i=0;i<4;i++) {
			kindofmenu [i] = Integer.toString(i+1);
		}
		for(int i=0;i<kindofmenu.length;i++) {
			kindofmuenubox.addItem(kindofmenu[i]);
		}
		p232.add(kindofmuenubox);
		p232.add(calladdrbutton);
		
		
	}

	public void p3 () { //저장하기,취소하기
		p3.setSize(980,90);
		p3.setLocation(0,660);
		p3.setBackground(Color.red);
		this.add(p3);
		p3.setLayout(new GridLayout(1,2));
		JPanel p31 = new JPanel();
		JPanel p32 = new JPanel();
		p3.add(p31);
		p3.add(p32);
		
		save.addActionListener(this);
		p31.add(save);
		p31.setLayout(new BorderLayout());
		p31.add(save,BorderLayout.CENTER);
		save.setFont(new Font("Serif",Font.BOLD,30));
		
		cancel.addActionListener(this);
		p32.add(cancel);
		p32.setLayout(new BorderLayout());
		p32.add(cancel,BorderLayout.CENTER);
		cancel.setFont(new Font("Serif",Font.BOLD,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==save) {
			MenuManage menuInsert = new MenuManage();
			menuInsert.setEgmenuename(taddEgmenu.getText());
			menuInsert.setKormenurname(taddKormenu.getText());
			menuInsert.setMenuprice(Integer.valueOf(tprice.getText()));
			menuInsert.setKindofmenu(kindofmuenubox.getSelectedIndex());
			menuInsert.setPhotoaddr(addmenupictureaddr);
			//menuInsert.setPhotoaddr(photoaddr);
			//menuInsert.setKindofmenu(kindofmenu);
			if(menuCon.menuPlus(menuInsert)) { //메뉴등록 완료
				JOptionPane.showMessageDialog(this, "메뉴 등록이 되었습니다", "등록완료", JOptionPane.INFORMATION_MESSAGE);
				menuCon.filesave();
			}else { //메뉴등록 실패
				JOptionPane.showMessageDialog(this, "중복된 메뉴가 있습니다. 다른 메뉴를 등록해주세요.", "등록실패", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==cancel) {
//			mainPanel.remove(8);
//			GuiManegeMenu gm = new GuiManegeMenu(mainPanel);
//			mainPanel.add(gm,"ManegeMenu",8);
			mainPanel.remove(9);
			GuiAllmenu ga = new GuiAllmenu(mainPanel);
			mainPanel.add(ga,"Allmenu",9);
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "ManegeMenu");
		}
	}


	private void comInit() {
		this.p1();
		this.p2();
		calladdrbutton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==calladdrbutton) {
					JFileChooser calladdrjc = new JFileChooser();
					int choiceValue = calladdrjc.showOpenDialog(mypanel);
					if(choiceValue == JFileChooser.APPROVE_OPTION) {
						addmenupictureaddr=calladdrjc.getSelectedFile().getPath();
						//System.out.println(addmenupictureaddr);
					}
				}
			}
		});
		
		this.p3();
	}

	public GuiAddmenu (JPanel mainPanel) {
		this.setSize(1000,800);
		this.setLayout(null);
		this.comInit();
		this.mainPanel = mainPanel;
		this.setVisible(true);
	}



}
