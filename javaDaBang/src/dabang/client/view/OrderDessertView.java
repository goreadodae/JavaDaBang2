package dabang.client.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dabang.client.model.MenuDrink;
import dabang.client.model.OrderList;

public class OrderDessertView extends JPanel {
	private JFrame mainFrame = null;
	private JPanel mainPanel = null;
	private MenuDrink md = null;
	private ImageIcon img = null;
	private JLabel imgLabel = null;
	private JLabel goodsName = null;
	private JLabel goodsNameEng = null;
	private JLabel price = null;
	private Properties props = new Properties();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p7 = new JPanel();
	private JPanel p8 = new JPanel();
	private Font f1 = new Font("πŸ≈¡",Font.BOLD,20);
	private Font f2 = new Font("πŸ≈¡",Font.PLAIN,15);
	private Font f3 = new Font("±º∏≤",Font.BOLD,25);
	private JButton minusButton = new JButton("-");
	private JButton plusButton = new JButton("+");
	private int goodsNum = 0;
	private JLabel orderCnt = new JLabel(Integer.toString(goodsNum));
	private JLabel orderAvailableCnt = new JLabel("¡÷πÆ ∞°¥… ºˆ∑Æ : 2∞≥");
	private ImageIcon img_order = new ImageIcon(new ImageIcon("Image\\OrderImage\\order.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private ImageIcon img_cancel = new ImageIcon(new ImageIcon("Image\\OrderImage\\cancel.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private JButton orderButton = new JButton(img_order);
	private JButton cancelButton = new JButton(img_cancel);
	private ImageIcon img_event1 = new ImageIcon(new ImageIcon("Image\\OrderImage\\event1.png").getImage().getScaledInstance(500, 150, Image.SCALE_DEFAULT));
	private JButton toWebPage = new JButton(img_event1);
	private ArrayList<OrderList> orderAl = null;
	private OrderList ol = new OrderList();
	
	public void comInit() {
		ActionListener lisener = new MyActionListener();
		
		p1.setSize(1000,200);
		p1.setBackground(Color.WHITE);
		p1.setLocation(0,0);
		p1.setLayout(null);
		imgLabel.setBounds(20,20,180,180);
		p1.add(imgLabel);
		JPanel p1_2 = new JPanel();
		p1_2.setBackground(Color.WHITE);
		p1_2.setSize(800,30);
		p1_2.setLocation(200,20);
		p1_2.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		goodsName.setFont(f1);
		p1_2.add(goodsName);
		JPanel p1_3 = new JPanel();
		p1_3.setBackground(Color.WHITE);
		p1_3.setSize(800,30);
		p1_3.setLocation(200,50);
		p1_3.setLayout(new FlowLayout(FlowLayout.LEFT,20,7));
		goodsNameEng.setFont(new Font("Arial",Font.PLAIN,15));
		goodsNameEng.setForeground(new Color(170,160,70));
		p1_3.add(goodsNameEng);
		JPanel p1_4 = new JPanel();
		p1_4.setBackground(Color.WHITE);
		p1_4.setSize(800,50);
		p1_4.setLocation(200,80);
		p1_4.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		price.setFont(f3);
		p1_4.add(price);
		JPanel p1_5 = new JPanel();
		p1_5.setBackground(Color.WHITE);
		p1_5.setSize(800,65);
		p1_5.setLocation(200,130);
		p1_5.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		plusButton.setFocusPainted(false);
		minusButton.setFocusPainted(false);
		plusButton.setFont(new Font("∞ÌµÒ",Font.PLAIN,20));
		minusButton.setFont(new Font("∞ÌµÒ",Font.BOLD,20));
		plusButton.addActionListener(lisener);
		minusButton.addActionListener(lisener);
		orderCnt.setFont(f3);
		p1_5.add(minusButton);
		p1_5.add(orderCnt);
		p1_5.add(plusButton);
		p1.add(p1_2);
		p1.add(p1_3);
		p1.add(p1_4);
		p1.add(p1_5);
		
		p2.setSize(1000,70);
		p2.setBackground(Color.WHITE);
		p2.setLocation(0,200);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,200,10));
		orderAvailableCnt.setFont(new Font("±º∏≤",Font.BOLD,15));
		p2.add(orderAvailableCnt);
		
		p3.setSize(1000,280);
		p3.setBackground(Color.WHITE);
		p3.setLocation(0,270);
		
		p7.setSize(1000,70);
		p7.setBackground(Color.WHITE);
		p7.setLocation(0,550);
		p7.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		orderButton.setBorderPainted(false);
		orderButton.setFocusPainted(false);
		orderButton.setContentAreaFilled(false);
		cancelButton.setBorderPainted(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setContentAreaFilled(false);
		orderButton.addActionListener(lisener);
		cancelButton.addActionListener(lisener);
		p7.add(orderButton);
		p7.add(cancelButton);
		
		p8.setSize(995,150);
		p8.setBackground(Color.WHITE);
		p8.setLocation(0,620);
		p8.setLayout(null);
		toWebPage.setSize(500,150);
		toWebPage.setBorderPainted(false);
		toWebPage.setFocusPainted(false);
		toWebPage.setContentAreaFilled(false);
		toWebPage.addActionListener(lisener);
		p8.add(toWebPage);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p7);
		this.add(p8);
	}
	
	public void menuSet() {
		String str = null;
		String s[] = null;
		String showPrice = null;
		
		try(BufferedInputStream bfs = new BufferedInputStream(new FileInputStream("menu.properties"))) {
			props.load(bfs);
			
			str = new String(props.getProperty(md.getGoodsName()).getBytes("ISO-8859-1"), "UTF-8");
			s = str.split("/");
			
			showPrice = s[3].charAt(0)+","+s[3].substring(s[3].length()-3, s[3].length())+"ø¯";

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		img = new ImageIcon(new ImageIcon(s[2]).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		imgLabel = new JLabel(img);
		goodsName = new JLabel(s[0]);
		goodsNameEng = new JLabel(s[1]);
		price = new JLabel(showPrice);
	}
	
	public OrderDessertView(JPanel mainPanel, JFrame mainFrame, ArrayList<OrderList> orderAl, MenuDrink md) {
		this.md = md;
		this.mainFrame = mainFrame;
		this.mainPanel = mainPanel;
		this.orderAl = orderAl;
		this.setSize(1000,800);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.menuSet();
		this.comInit();
		this.setVisible(true);
	}
	
	public class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==plusButton) {
				goodsNum++;
				orderCnt.setText(""+goodsNum);
			} else if(e.getSource()==minusButton) {
				if(goodsNum>0) {
					goodsNum--;
					orderCnt.setText(""+goodsNum);
				}
			} else if(e.getSource()==orderButton) {
				
			} else if(e.getSource()==cancelButton) {
				goodsNum=0;
				orderCnt.setText(""+goodsNum);
				((CardLayout)mainPanel.getLayout()).show(mainPanel, "menu");
			} else if(e.getSource()==toWebPage) {
				try {
					Desktop.getDesktop().browse(new URL("http://www.youtube.com/watch?v=ClbJ41ll8og").toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
}

	
