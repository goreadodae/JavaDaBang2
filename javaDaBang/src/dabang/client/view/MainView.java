package dabang.client.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dabang.client.model.OrderList;

public class MainView implements ActionListener {
	private JFrame mainFrame = new JFrame();
	private JPanel[] cards = new JPanel[7];
	private JPanel mainPanel = new JPanel();
	private ArrayList<OrderList> orderAl = new ArrayList<OrderList>();
	
	public void comInit() {

		mainPanel.setLayout(new CardLayout());
		cards[0] = new Login(mainPanel);
		cards[1] = new memberMainView(mainPanel);
		cards[2] = new MenuView(mainPanel,orderAl);
		cards[3] = new OrderView(mainPanel, mainFrame,orderAl);
		mainPanel.add("Login",cards[0]);
		mainPanel.add("memberMain",cards[1]);
		mainPanel.add("menu",cards[2]);
		mainPanel.add("order",cards[3]);
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
		this.comInit(); //����� ���� �޼ҵ�

		mainFrame.setVisible(true); //���������� �����־��
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}
