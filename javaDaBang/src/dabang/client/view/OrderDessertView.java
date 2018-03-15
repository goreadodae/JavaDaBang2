package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderDessertView extends JFrame {
	private ImageIcon img = new ImageIcon(new ImageIcon("Image\\MenuImage\\4Æ¼¶ó¹Ì¼ö.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	private JLabel imgLabel = new JLabel(img);
//	private Container c = getContentPane();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p7 = new JPanel();
	private JPanel p8 = new JPanel();
	private Font f1 = new Font("¹ÙÅÁ",Font.BOLD,20);
	private Font f2 = new Font("¹ÙÅÁ",Font.PLAIN,15);
	private Font f3 = new Font("±¼¸²",Font.BOLD,25);
	private JButton minusButton = new JButton("-");
	private JButton plusButton = new JButton("+");
	private int goodsNum = 0;
	private JLabel orderCnt = new JLabel(Integer.toString(goodsNum));
	private JLabel orderAvailableCnt = new JLabel("ÁÖ¹® °¡´É ¼ö·® : 2°³");
	private ImageIcon img_order = new ImageIcon(new ImageIcon("Image\\OrderImage\\order.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private ImageIcon img_cancel = new ImageIcon(new ImageIcon("Image\\OrderImage\\cancel.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private JButton orderButton = new JButton(img_order);
	private JButton cancelButton = new JButton(img_cancel);
	private ImageIcon img_event1 = new ImageIcon(new ImageIcon("Image\\OrderImage\\event1.png").getImage().getScaledInstance(500, 150, Image.SCALE_DEFAULT));
	private JButton toWebPage = new JButton(img_event1);
	
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
		JLabel goodsName = new JLabel("Æ¼¶ó¹Ì¼ö");
		goodsName.setFont(f1);
		p1_2.add(goodsName);
		JPanel p1_3 = new JPanel();
		p1_3.setBackground(Color.WHITE);
		p1_3.setSize(800,30);
		p1_3.setLocation(200,50);
		p1_3.setLayout(new FlowLayout(FlowLayout.LEFT,20,7));
		JLabel goodsNameEng = new JLabel("Tiramisu");
		goodsNameEng.setFont(new Font("Arial",Font.PLAIN,15));
		goodsNameEng.setForeground(new Color(170,160,70));
		p1_3.add(goodsNameEng);
		JPanel p1_4 = new JPanel();
		p1_4.setBackground(Color.WHITE);
		p1_4.setSize(800,50);
		p1_4.setLocation(200,80);
		p1_4.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel price = new JLabel("4,800¿ø");
		price.setFont(f3);
		p1_4.add(price);
		JPanel p1_5 = new JPanel();
		p1_5.setBackground(Color.WHITE);
		p1_5.setSize(800,65);
		p1_5.setLocation(200,130);
		p1_5.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		plusButton.setFocusPainted(false);
		minusButton.setFocusPainted(false);
		plusButton.setFont(new Font("°íµñ",Font.PLAIN,20));
		minusButton.setFont(new Font("°íµñ",Font.BOLD,20));
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
		orderAvailableCnt.setFont(new Font("±¼¸²",Font.BOLD,15));
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
	
	public OrderDessertView() {
		super("OrderDessertView");
		this.setSize(1000,800);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	
