package dabang.client.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame implements ActionListener {
	private JPanel[] cards = new JPanel[7];
	private CardLayout card = new CardLayout();
	private JPanel mainPanel = new JPanel();
	public void comInit() {

		mainPanel.setLayout(new CardLayout());
		cards[0] = new Login(mainPanel);
		cards[1] = new memberMainView(mainPanel);
		cards[2] = new MenuView(mainPanel);
		mainPanel.add("Login",cards[0]);
		mainPanel.add("memberMain",cards[1]);
		mainPanel.add("menu",cards[2]);
		//this.add("login",login);
		this.add(mainPanel);
		//login.button1.addActionListener(this);
	}
	public MainView() {
		this.setSize(1000,800); //������ ������
		this.setLocationRelativeTo(null); //ȭ�� ����� ��ġ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //�����ư�� �ƿ��ٲ�����
		this.setResizable(false);
		this.setLayout(new CardLayout());
		this.comInit(); //����� ���� �޼ҵ�

		this.setVisible(true); //���������� �����־��
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}