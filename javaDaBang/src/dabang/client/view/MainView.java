package dabang.client.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dabang.client.model.Member;
import dabang.client.model.MenuDrink;
import dabang.client.model.OrderList;

public class MainView implements ActionListener {
	private MenuDrink md = new MenuDrink();
	private JFrame mainFrame = new JFrame();
	private JPanel[] cards = new JPanel[15];
	private JPanel mainPanel = new JPanel();
	private ArrayList<OrderList> orderAl = new ArrayList<OrderList>();
	private Member accessMember = new Member();

	
	public void comInit() {

		mainPanel.setLayout(new CardLayout());
		cards[0] = new Login(mainPanel, mainFrame,orderAl,md,accessMember);
		cards[1] = new memberMainView(mainPanel, mainFrame,orderAl,md,accessMember);
		cards[2] = new MenuView(mainPanel, mainFrame, orderAl, md, accessMember);
		cards[3] = new OrderView(mainPanel, mainFrame, orderAl, md, accessMember);
		cards[4] = new GuiMember(mainPanel,accessMember); //����� ��������Ȯ�� ȭ��
		cards[5] = new ManagerGui(mainPanel);
		cards[6] = new GuiPersonalInfor(mainPanel); //����ڰ�����������ȭ��
		cards[7] = new SalesView(mainPanel);
		cards[8] = new GuiManegeMenu(mainPanel); //�����ڸ޴�����ȭ��
		cards[9] = new GuiAllmenu(mainPanel); //�����ڸ޴�����ȭ�� ��ü����
		cards[10] = new GuiAddmenu(mainPanel); //�����ڸ޴�����ȭ�� �޴��߰�
		cards[11] = new Guimodifymenu(mainPanel); //�����ڸ޴�����ȭ�� �޴��߰�
		cards[12] = new GuiDeletemenu(mainPanel); //�����ڸ޴�����ȭ�� �޴��߰�
	
		mainPanel.add(cards[0],"Login",0);
		mainPanel.add(cards[1],"memberMain",1);
		mainPanel.add(cards[2],"menu",2);
		mainPanel.add(cards[3],"order",3);
		mainPanel.add(cards[4],"member",4); //����� ��������Ȯ�� ȭ��
		mainPanel.add(cards[5],"admin",5);
		mainPanel.add(cards[6],"PersonalInfor",6); //����ڰ�����������ȭ��
		mainPanel.add(cards[7],"sales",7);
		mainPanel.add(cards[8],"ManegeMenu",8); //�����ڸ޴�����ȭ��
		mainPanel.add(cards[9],"Allmenu",9); //�����ڸ޴�����ȭ�� ��ü����
		mainPanel.add(cards[10],"Addmenu",10); //�����ڸ޴�����ȭ�� �޴��߰�
		mainPanel.add(cards[11],"modifymenu",11); //�����ڸ޴�����ȭ�� �޴��߰�
		mainPanel.add(cards[12],"Deletemenu",12); //�����ڸ޴�����ȭ�� �޴��߰�
		//this.add("login",login);
		mainFrame.add(mainPanel);
		//login.button1.addActionListener(this);
	}
	public MainView() {
		mainFrame.setSize(1000,800); //������ ������
		mainFrame.setLocationRelativeTo(null); //ȭ�� ����� ��ġ����
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�����ư�� �ƿ��ٲ�����
		mainFrame.setResizable(false);
		mainFrame.setLayout(new CardLayout());
		mainFrame.setTitle("Java�ٹ�");
		md.setGoodsName("americano");
		this.comInit(); //����� ���� �޼ҵ�

		mainFrame.setVisible(true); //���������� �����־��
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}
