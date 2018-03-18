package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiManegeMenu extends JPanel implements ActionListener{

	private JPanel p1 = new JPanel();
	private JLabel manegeMenuTitle = new JLabel("메뉴 관리");
	private JPanel p2 = new JPanel();
	private JButton allmenubutton = new JButton(new ImageIcon(new ImageIcon("Image/MenuAdminImage/allmenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton addmenubutton = new JButton(new ImageIcon(new ImageIcon("Image/MenuAdminImage/addmenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton modifymenubutton  = new JButton(new ImageIcon(new ImageIcon("Image/MenuAdminImage/modifymenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton deletemenubutton = new JButton(new ImageIcon(new ImageIcon("Image/MenuAdminImage/deletemenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton todaymenubutton = new JButton(new ImageIcon(new ImageIcon("Image/MenuAdminImage/todaymenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JLabel adverlabel = new JLabel(new ImageIcon(new ImageIcon("Image/MenuAdminImage/addmenu.jpg").getImage().getScaledInstance(325,283, Image.SCALE_DEFAULT)));
	private JPanel p3 = new JPanel();
	private JButton backButton = new JButton("뒤로가기");
	
	private JPanel mainPanel = null;
	
	public void p1 () { //제목
		p1.setSize(980,90);
		p1.setLocation(0,0);
		p1.setBackground(Color.red);
		this.add(p1);
		p1.add(manegeMenuTitle);
		manegeMenuTitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(manegeMenuTitle,BorderLayout.WEST);
	}
	
	public void p2 () { //메뉴
		p2.setSize(980,570);
		p2.setLocation(0,90);
		p2.setBackground(Color.blue);
		this.add(p2);
		p2.setLayout(new GridLayout(2,3));
		allmenubutton.addActionListener(this);
		addmenubutton.addActionListener(this);
		modifymenubutton.addActionListener(this);
		deletemenubutton.addActionListener(this);
		p2.add(allmenubutton);
		p2.add(addmenubutton);
		p2.add(deletemenubutton);
		p2.add(modifymenubutton);
		p2.add(todaymenubutton);
		p2.add(adverlabel);
		
	}
	
	public void p3 () { //공란/뒤로가기버튼
		p3.setSize(980,90);
		p3.setLocation(0,660);
		p3.setBackground(Color.red);
		this.add(p3);
		p3.add(backButton);
		backButton.setFont(new Font("맑은고딕",Font.BOLD,17));
		backButton.addActionListener(this);
		
		p3.setLayout(new BorderLayout());
		p3.add(backButton,BorderLayout.CENTER);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==allmenubutton) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "Allmenu");
		}else if(e.getSource()==addmenubutton) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "Addmenu");
		}else if(e.getSource()==modifymenubutton) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "modifymenu");
		}else if(e.getSource()==deletemenubutton) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "Deletemenu");
		}else if(e.getSource()==backButton) {
			mainPanel.remove(5);
			ManagerGui mg = new ManagerGui(mainPanel); 
			mainPanel.add(mg,"admin",5);
			((CardLayout)mainPanel.getLayout()).show(mainPanel,"admin");
		}
	}
	
	public void comInit() {
		
		p1();
		p2();
		p3();
		
	}
	
	public GuiManegeMenu (JPanel mainPanel) {
		this.setSize(1000,800);
		this.setLayout(null);
		this.comInit();
		this.setVisible(true);
		this.mainPanel  = mainPanel;
	}


}
