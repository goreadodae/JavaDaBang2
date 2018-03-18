package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dabang.client.controller.MenuManageControl;
import dabang.client.model.MenuManage;


public class Guimodifymenu extends JPanel implements ActionListener{

	private JPanel p1 = new JPanel();
	private JLabel addmenutitle = new JLabel("  메뉴 수정");
	private JPanel p2 = new JPanel();
	private JLabel addmenunamelabel = new JLabel("   수정할 메뉴명");
	private JTextField tallmenu = new JTextField(25);
	private JLabel addmenupricelabel = new JLabel("   수정할 가격");
	private JTextField tprice = new JTextField(25);
	private JLabel addmenupicturelabel = new JLabel("   수정할 사진");
	private JPanel p3 = new JPanel();
	private JLabel addmenupictureaddr=new JLabel("여기에 사진주소값"); 
	private JButton calladdrbutton = new JButton("불러오기");
	private JButton modifysave = new JButton("수정하기");
	private JButton cancel = new JButton("취소하기");
	
	private JPanel myPanel = this;
	private JPanel mainPanel = null;
	
	MenuManageControl menuCon = new MenuManageControl();
	MenuManage modifymenu= new MenuManage();;
	
	public void p1 () { //제목
		p1.setSize(980,90);
		p1.setLocation(0,0);
		p1.setBackground(Color.red);
		this.add(p1);
		p1.add(addmenutitle);
		addmenutitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(addmenutitle,BorderLayout.WEST);
	}
	
	public void p2 () { //메뉴수정
		p2.setSize(980,570);
		p2.setLocation(0,90);
		p2.setBackground(Color.blue);
		this.add(p2);
		p2.setLayout(new GridLayout(3,1));
		JPanel p21 = new JPanel();
		JPanel p22 = new JPanel();
		JPanel p23 = new JPanel();
		p2.add(p21);
		p2.add(p22);
		p2.add(p23);
		p21.setLayout(new GridLayout(2,1));
		JPanel p211 = new JPanel();
		JPanel p212 = new JPanel();
		p21.add(p211);
		p21.add(p212);
		p211.add(addmenunamelabel);
		addmenunamelabel.setFont(new Font("Serif",Font.BOLD,30));
		p211.setLayout(new BorderLayout());
		p211.add(addmenunamelabel,BorderLayout.WEST);
		p212.add(tallmenu);
		tallmenu.setFont(new Font("Serif",Font.BOLD,25));
		p212.setLayout(new BorderLayout());
		p212.add(tallmenu,BorderLayout.CENTER);
		p22.setLayout(new GridLayout(2,1));
		JPanel p221 = new JPanel();
		JPanel p222 = new JPanel();
		p22.add(p221);
		p22.add(p222);
		p221.add(addmenupricelabel);
		p222.add(tprice);
		addmenupricelabel.setFont(new Font("Serif",Font.BOLD,30));
		p221.setLayout(new BorderLayout());
		p221.add(addmenupricelabel,BorderLayout.WEST);
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
		p232.add(addmenupictureaddr);
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
		p31.add(modifysave);
		p31.setLayout(new BorderLayout());
		p31.add(modifysave,BorderLayout.CENTER);
		modifysave.setFont(new Font("Serif",Font.BOLD,30));
		modifysave.addActionListener(this);
		p32.add(cancel);
		p32.setLayout(new BorderLayout());
		p32.add(cancel,BorderLayout.CENTER);
		cancel.setFont(new Font("Serif",Font.BOLD,30));
		cancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==modifysave) {
			menuCon.menuPlus(new MenuManage("아메",200));
			modifymenu=new MenuManage();
			modifymenu.setMenuname(tallmenu.getText());
			modifymenu.setMenuprice(Integer.valueOf(tprice.getText()));
			if(menuCon.menumodify(modifymenu)) { //메뉴수정 완료
				JOptionPane.showMessageDialog(this, "메뉴 수정이 되었습니다", "등록완료", JOptionPane.INFORMATION_MESSAGE);
			}else { //메뉴수정 실패
				JOptionPane.showMessageDialog(this, "수정할 메뉴가 없습니다. 메뉴명을 확인 해주세요.", "등록실패", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==cancel) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "ManegeMenu");
		}
	}
	
	private void comInit() {
		p1();
		p2();
		p3();
		calladdrbutton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==calladdrbutton) {
					JFileChooser calladdrjc = new JFileChooser();
					int choiceValue = calladdrjc.showOpenDialog(myPanel);
					if(choiceValue == JFileChooser.APPROVE_OPTION) {
						System.out.println("선택한 파일 :"+calladdrjc.getSelectedFile());
					}
				}
			}
		});
	}
	
	public Guimodifymenu (JPanel mainPanel) {
		this.setSize(1000,800);
		this.setLayout(null);
		this.comInit();
		this.setVisible(true);
		this.mainPanel  = mainPanel;
	}

}
