package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.MenuManageControl;
import dabang.client.model.MenuDrink;
import dabang.client.model.MenuManage;


public class GuiAllmenu extends JPanel implements ActionListener{

	private JPanel p1 = new JPanel();
	private JLabel allmenutitle = new JLabel("전체 메뉴 보기");
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JButton back = new JButton("뒤로가기");

	private MenuManageControl mCon = new MenuManageControl();
	ArrayList<String> menuname = null;
	ArrayList<String> menuprice = null;
	private MenuManage menuInsert ;

	private JPanel mainPanel = null;

	private Properties props = new Properties();

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
		back.addActionListener(this);
		p3.add(back);
		p3.setLayout(new BorderLayout());
		p3.add(back,BorderLayout.CENTER);
		back.setFont(new Font("Serif",Font.BOLD,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "ManegeMenu");
		}
	}

	private void comInit() {


/*		String str  =  null;
		String s[] = null;
		String showPrice = null;

		try(BufferedInputStream bfs = new BufferedInputStream(new FileInputStream("menu.properties"))) {
			props.load(bfs);

			Enumeration<Object> enumm = props.keys();

			while (enumm.hasMoreElements()) {
				String key = (String) enumm.nextElement(); 
				str = new String(((String) props.get(key)).getBytes("ISO-8859-1"), "UTF-8");

				s = str.split("/");

				mCon.menuPlus(new MenuManage(s[0],Integer.parseInt(s[3])));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		menuname = mCon.arraytmenuname();
		menuprice = mCon.arraytmenuprice();

		p1();
		p2();
		p3();
	}

	public GuiAllmenu (JPanel mainPanel) {
		this.setSize(1000,800);
		this.setLayout(null);
		this.comInit();
		this.setVisible(true);
		this.mainPanel  = mainPanel;
	}



}
