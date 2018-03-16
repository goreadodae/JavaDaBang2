package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiAddmenu extends JFrame{
	
	private JPanel p1 = new JPanel();
	private JLabel addmenutitle = new JLabel("  메뉴 추가");
	private JPanel p2 = new JPanel();
	private JLabel addmenunamelabel = new JLabel("   메뉴명");
	private JTextField tallmenu = new JTextField(25);
	private JLabel addmenupricelabel = new JLabel("   가격");
	private JTextField tprice = new JTextField(25);
	private JLabel addmenupicturelabel = new JLabel("   사진");
	private JPanel p3 = new JPanel();
	private JLabel addmenupictureaddr=new JLabel("여기에 사진주소값"); 
	private JButton calladdrbutton = new JButton("불러오기");
	private JButton save = new JButton("추가하기");
	private JButton cancel = new JButton("취소하기");
	
	private JFrame myframe = this;
	
	
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
	
	public void p2 () { //메뉴추가
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
		p31.add(save);
		p31.setLayout(new BorderLayout());
		p31.add(save,BorderLayout.CENTER);
		save.setFont(new Font("Serif",Font.BOLD,30));
		p32.add(cancel);
		p32.setLayout(new BorderLayout());
		p32.add(cancel,BorderLayout.CENTER);
		cancel.setFont(new Font("Serif",Font.BOLD,30));
	}
	
	private void comInit() {
		this.p1();
		this.p2();
		calladdrbutton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==calladdrbutton) {
					JFileChooser calladdrjc = new JFileChooser();
					int choiceValue = calladdrjc.showOpenDialog(myframe);
					if(choiceValue == JFileChooser.APPROVE_OPTION) {
						System.out.println("선택한 파일 :"+calladdrjc.getSelectedFile());
					}
				}
			}
		});
		this.p3();
	}
	
	public GuiAddmenu () {
		super("잡다방");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		comInit();
		this.setVisible(true);
	}


}
