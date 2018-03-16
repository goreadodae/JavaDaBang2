package dabang.client.view;

import java.awt.*;

import javax.swing.*;

public class GuiMember extends JFrame {
	
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton("나의 정보 관리");
	private JButton button4 = new JButton("영수증");
	private ImageIcon welcome = new ImageIcon("welcomelevel.jpg");
	private JLabel welcomelabel = new JLabel(welcome);
	private ImageIcon star = new ImageIcon("star.png");
	private JLabel starlabel = new JLabel(star);
	private JLabel countvisit = new JLabel("나의 방문 횟수 ");
	private JLabel countLabel = null;
	private int count =0;
	
	
	
	private void comInit() {
		
		p1.setSize(400,500);
		p1.setLocation(0,0);
		p1.setBackground(Color.white);
		p1.add(welcomelabel);
		p1.setLayout(new BorderLayout());
		p1.add(welcomelabel,BorderLayout.CENTER);
		
		
		p2.setSize(600, 500);
		p2.setLocation(400, 0);
		//p2.setBackground(star);
		p2.add(starlabel);
		p2.setLayout(new BorderLayout());
		p2.add(starlabel,BorderLayout.CENTER);
		starlabel.add(countvisit);
		countvisit.setFont(new Font("Serif",Font.BOLD,17));
		countvisit.setBounds(100, 60, 145, 30);
		countLabel = new JLabel(Integer.toString(count));
		countLabel.setFont(new Font("Serif",Font.BOLD,100));
		starlabel.add(countLabel);
		countLabel.setBounds(277, 140, 100, 100);
		
		
		p3.setSize(500, 300);
		p3.setLocation(0,500);
		//p3.setBackground(Color.PINK);
		p3.setLayout(new BorderLayout());
		p3.add(button3,BorderLayout.CENTER);
		
		p4.setSize(500,300);
		p4.setLocation(500,500);
		//p4.setBackground(Color.blue);
		p4.setLayout(new BorderLayout());
		p4.add(button4,BorderLayout.CENTER);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		
	}

	public GuiMember () {
		super("잡다방");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		comInit();
		this.setVisible(true);
	}


}
