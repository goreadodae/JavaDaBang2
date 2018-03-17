package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.MenuManageControl;
import dabang.client.model.MenuManage;


public class GuiAllmenu extends JFrame{

	private JPanel p1 = new JPanel();
	private JLabel allmenutitle = new JLabel("전체 메뉴 보기");
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JButton back = new JButton("뒤로가기");

	private MenuManageControl mCon = new MenuManageControl();
	 ArrayList<String> menuname = null;
	 ArrayList<String> menuprice = null;
	private MenuManage menuInsert ;

	public void p1 () { //제목
		p1.setSize(980,90);
		p1.setLocation(0,0);
		p1.setBackground(Color.red);
		this.add(p1);
		p1.add(allmenutitle);
		allmenutitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(allmenutitle,BorderLayout.WEST);
	}

	public void p2 () { //메뉴전체출력
		p2.setSize(980,570);
		p2.setLocation(0,90);
		p2.setBackground(Color.blue);
		/*for(int i=0;i<menuAll.size();i++) {
			p2.add(new Label(menuAll.get(i).toString()));
		}*/
		this.add(p2);

		String header[] = {"메뉴명","가격"};
		String contents [][] ={};

		DefaultTableModel allmenumodel = new DefaultTableModel(contents,header);
		JTable allmenutable = new JTable(allmenumodel);
		allmenutable.getTableHeader().setReorderingAllowed(false);
		allmenutable.getTableHeader().setResizingAllowed(false);
		JScrollPane allmenuscroll = new JScrollPane(allmenutable);
		p2.add(allmenuscroll);

		
		String allmenu [] = new String[2];
		for(int i=0;i<menuname.size();i++) {
			allmenu[0]=menuname.get(i);
			allmenu[1]=menuprice.get(i);
			allmenumodel.addRow(allmenu);
		}
		
	}

	public void p3 () { //뒤로가기
		p3.setSize(980,90);
		p3.setLocation(0,660);
		p3.setBackground(Color.red);
		this.add(p3);
		p3.add(back);
		p3.setLayout(new BorderLayout());
		p3.add(back,BorderLayout.CENTER);
		back.setFont(new Font("Serif",Font.BOLD,30));
	}

	private void comInit() {

		mCon.menuPlus(new MenuManage("아메리카노",200));
		mCon.menuPlus(new MenuManage("카페라떼",10000));
		mCon.menuPlus(new MenuManage("카페모카",900));
		mCon.menuPlus(new MenuManage("딸기",2000));
		mCon.menuPlus(new MenuManage("아메아메",500));


		menuname = mCon.arraytmenuname();
		menuprice = mCon.arraytmenuprice();

		this.p1();
		this.p2();
		this.p3();
	}

	public GuiAllmenu () {
		super("잡다방");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		comInit();
		this.setVisible(true);
	}



}
