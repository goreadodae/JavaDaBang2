package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

public class GuiManegeMenu extends JFrame{

	private JPanel p1 = new JPanel();
	private JLabel manegeMenuTitle = new JLabel("메뉴 관리");
	private JPanel p2 = new JPanel();
	private JButton allmenubutton = new JButton(new ImageIcon(new ImageIcon("allmenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton addmenubutton = new JButton(new ImageIcon(new ImageIcon("addmenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton deletemenubutton = new JButton(new ImageIcon(new ImageIcon("deletemenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton modifymenubutton = new JButton(new ImageIcon(new ImageIcon("modifymenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JButton todaymenubutton = new JButton(new ImageIcon(new ImageIcon("todaymenu.jpg").getImage().getScaledInstance(320,270, Image.SCALE_DEFAULT)));
	private JLabel adverlabel = new JLabel(new ImageIcon(new ImageIcon("20180209_springProm_01.jpg").getImage().getScaledInstance(325,283, Image.SCALE_DEFAULT)));
	private JPanel p3 = new JPanel();
	
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
		p2.add(allmenubutton);
		p2.add(addmenubutton);
		p2.add(deletemenubutton);
		p2.add(modifymenubutton);
		p2.add(todaymenubutton);
		p2.add(adverlabel);
		
	}
	
	public void p3 () { //공란
		p3.setSize(980,90);
		p3.setLocation(0,660);
		p3.setBackground(Color.red);
		this.add(p3);
	
	}
	
	public void comInit() {
		
		this.p1();
		this.p2();
		this.p3();
		
	}
	
	public GuiManegeMenu () {
		super("잡다방");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		comInit();
		this.setVisible(true);
	}

}
