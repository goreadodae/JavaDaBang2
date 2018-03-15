package dabang.client.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame implements ActionListener {
	private JPanel[] cards = new JPanel[7];
	//private Login login = new Login();
	private memberMainView nextLogin = new memberMainView();
	private CardLayout card = new CardLayout();
	private JPanel mainPanel = new JPanel();
	public void comInit() {

		mainPanel.setLayout(new CardLayout());
		cards[0] = new Login(mainPanel);
		cards[1] = new memberMainView();
		mainPanel.add(cards[0], 0);
		mainPanel.add(cards[1], 1);
		
		//this.add("login",login);
		this.add(mainPanel);
		//login.button1.addActionListener(this);
	}
	public MainView() {
		this.setSize(1000,800); //프레임 사이즈
		this.setLocationRelativeTo(null); //화면 가운데로 위치설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //종료버튼시 아예다꺼버림
		this.setResizable(false);
		this.setLayout(new CardLayout());
		this.comInit(); //사용자 정의 메소드

		this.setVisible(true); //가시적으로 보여주어라
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}
