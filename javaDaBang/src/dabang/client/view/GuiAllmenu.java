package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class GuiAllmenu extends JPanel implements ActionListener{

	private JPanel p1 = new JPanel();
	private JLabel allmenutitle = new JLabel("��ü �޴� ����");
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JButton back = new JButton("�ڷΰ���");

	private MenuManageControl mCon = new MenuManageControl();
	 ArrayList<String> menuname = null;
	 ArrayList<String> menuprice = null;
	private MenuManage menuInsert ;
	
	private JPanel mainPanel = null;

	public void p1 () { //����
		p1.setSize(980,90);
		p1.setLocation(0,0);
		p1.setBackground(Color.red);
		this.add(p1);
		p1.add(allmenutitle);
		allmenutitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(allmenutitle,BorderLayout.WEST);
	}

	public void p2 () { //�޴���ü���
		p2.setSize(980,570);
		p2.setLocation(0,90);
		p2.setBackground(Color.blue);
		/*for(int i=0;i<menuAll.size();i++) {
			p2.add(new Label(menuAll.get(i).toString()));
		}*/
		this.add(p2);

		String header[] = {"�޴���","����"};
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

	public void p3 () { //�ڷΰ���
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

		mCon.menuPlus(new MenuManage("�Ƹ޸�ī��",200));
		mCon.menuPlus(new MenuManage("ī���",10000));
		mCon.menuPlus(new MenuManage("ī���ī",900));
		mCon.menuPlus(new MenuManage("����",2000));
		mCon.menuPlus(new MenuManage("�Ƹ޾Ƹ�",500));


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
