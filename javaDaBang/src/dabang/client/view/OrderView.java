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
import java.util.Calendar;
import java.util.Properties;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dabang.client.model.Espresso;
import dabang.client.model.Frappuccino;
import dabang.client.model.Member;
import dabang.client.model.Menu;
import dabang.client.model.MenuDrink;
import dabang.client.model.Tea;

public class OrderView extends JPanel {
	private static int orderID = 0;
	private MenuDrink md = null;
	private Properties props = new Properties();
	private JFrame mainFrame = null;
	private JPanel mainPanel = null;
	private ImageIcon img = null;
	private JLabel imgLabel = null;
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	private JPanel p6 = new JPanel();
	private JPanel p7 = new JPanel();
	private JPanel p8 = new JPanel();
	private Font f1 = new Font("¹ÙÅÁ",Font.BOLD,20);
	private Font f2 = new Font("¹ÙÅÁ",Font.PLAIN,15);
	private Font f3 = new Font("±¼¸²",Font.BOLD,25);
	private JLabel goodsName = null;
	private JLabel goodsNameEng = null;
	private JLabel price = null;
	private JButton minusButton = new JButton("-");
	private JButton plusButton = new JButton("+");
	private int goodsNum = 0;
	private JLabel orderCnt = new JLabel(Integer.toString(goodsNum));
	private ImageIcon img_hot_selected = new ImageIcon(new ImageIcon("Image\\OrderImage\\hot_selected.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private ImageIcon img_hot_unselected = new ImageIcon(new ImageIcon("Image\\OrderImage\\hot_unselected.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private ImageIcon img_iced_selected = new ImageIcon(new ImageIcon("Image\\OrderImage\\iced_selected.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private ImageIcon img_iced_unselected = new ImageIcon(new ImageIcon("Image\\OrderImage\\iced_unselected.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private JButton hotButton = new JButton(img_hot_selected);
	private JButton icedButton = new JButton(img_iced_unselected);
	private String [] size = {"Short","Tall","Grande","Venti"};
	private JComboBox sizeCb = new JComboBox(size);
	private String [] cup = {"ÀÏÈ¸¿ë ÄÅ","¸Ó±×ÄÅ","¿ùµåÄÅ"};
	private JComboBox cupCb = new JComboBox(cup);
	private JButton personalO = new JButton("ÆÛ½º³Î ¿É¼Ç                                       >");
	private ImageIcon img_order = new ImageIcon(new ImageIcon("Image\\OrderImage\\order.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private ImageIcon img_cancel = new ImageIcon(new ImageIcon("Image\\OrderImage\\cancel.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
	private JButton orderButton = new JButton(img_order);
	private JButton cancelButton = new JButton(img_cancel);
	private ImageIcon img_event1 = new ImageIcon(new ImageIcon("Image\\OrderImage\\event1.png").getImage().getScaledInstance(500, 150, Image.SCALE_DEFAULT));
	private JButton toWebPage = new JButton(img_event1);
	private ArrayList<Menu> orderAl = null;
	private Menu ol = new Menu();
	private int sendPrice;
	private Member accessMember = new Member();
	Espresso espre = new Espresso();
	Frappuccino fra = new Frappuccino();
	Tea te = new Tea();
	Calendar od = Calendar.getInstance();
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
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		hotButton.setBorderPainted(false);
		hotButton.setFocusPainted(false);
		hotButton.setContentAreaFilled(false);
		icedButton.setBorderPainted(false);
		icedButton.setFocusPainted(false);
		icedButton.setContentAreaFilled(false);
		hotButton.addActionListener(lisener);
		icedButton.addActionListener(lisener);
		p2.add(hotButton);
		p2.add(icedButton);
		
		p3.setSize(1000,70);
		p3.setBackground(Color.WHITE);
		p3.setLocation(0,270);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT,70,15));
		JLabel notice = new JLabel("ÆÛ½º³Î ¿É¼ÇÀ» ¼±ÅÃÇÏ¿© µðÄ«ÆäÀÎÀ¸·Î Áñ°Üº¸¼¼¿ä.");
		notice.setFont(new Font("±¼¸²",Font.BOLD,15));
		notice.setForeground(Color.GRAY);
		p3.add(notice);
		
		p4.setSize(1000,70);
		p4.setBackground(Color.WHITE);
		p4.setLocation(0,340);
		p4.setLayout(null);
		JPanel p4_2 = new JPanel();
		JLabel sizeLabel = new JLabel("»çÀÌÁî");
		sizeLabel.setFont(new Font("±¼¸²",Font.BOLD,18));
		p4_2.add(sizeLabel);
		p4_2.setSize(70,40);
		p4_2.setLocation(10,15);
		p4_2.setBackground(Color.WHITE);
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.RIGHT);
		sizeCb.setRenderer(dlcr);
		sizeCb.setSelectedIndex(1);
		sizeCb.setFont(new Font("Arial",Font.PLAIN,20));
		sizeCb.setLocation(80,10);
		sizeCb.setSize(400,50);
		p4.add(p4_2);
		p4.add(sizeCb);
		
		p5.setSize(1000,70);
		p5.setBackground(Color.WHITE);
		p5.setLocation(0,410);
		p5.setLayout(null);
		JPanel p5_2 = new JPanel();
		JLabel cupLabel = new JLabel("ÄÅ ¼±ÅÃ");
		cupLabel.setFont(new Font("±¼¸²",Font.BOLD,18));
		p5_2.add(cupLabel);
		p5_2.setSize(70,40);
		p5_2.setLocation(10,15);
		p5_2.setBackground(Color.WHITE);
		cupCb.setRenderer(dlcr);
		cupCb.setFont(new Font("±¼¸²",Font.BOLD,20));
		cupCb.setLocation(80,10);
		cupCb.setSize(400,50);
		p5.add(p5_2);
		p5.add(cupCb);
		
		p6.setSize(1000,70);
		p6.setBackground(Color.WHITE);
		p6.setLocation(0,480);
		p6.setLayout(null);
		personalO.setLocation(10,10);
		personalO.setSize(470,50);
		personalO.setFont(new Font("±¼¸²",Font.BOLD,20));
		personalO.setHorizontalAlignment(SwingConstants.LEFT);
		personalO.addActionListener(lisener);
		p6.add(personalO);
		
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
		this.add(p4);
		this.add(p5);
		this.add(p6);
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
			
//			showPrice = s[3].charAt(0)+","+s[3].substring(s[3].length()-3, s[3].length())+"¿ø";
			showPrice = String.format("%,d", Integer.parseInt(s[3]))+"¿ø";
			sendPrice = Integer.valueOf(s[3]);
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
	
	public OrderView(JPanel mainPanel, JFrame mainFrame, ArrayList<Menu> orderAl, MenuDrink md,
			Member accessMember) {
		this.md = md;
		this.mainFrame = mainFrame;
		this.mainPanel = mainPanel;
		this.orderAl = orderAl;
		this.accessMember  = accessMember;
		this.setSize(1000,800);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.menuSet();
		this.comInit();
		this.setVisible(true);
		orderID++;
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
			} else if(e.getSource()==hotButton) {
				hotButton.setIcon(img_hot_selected);
				icedButton.setIcon(img_iced_unselected);
			} else if(e.getSource()==icedButton) {
				hotButton.setIcon(img_hot_unselected);
				icedButton.setIcon(img_iced_selected);
			} else if(e.getSource()==personalO) {
				if(md.getKindOfDrink()==1) {
					EspressoCustom ec = new EspressoCustom(mainFrame,"Espresso Personal Option",true,espre);
				}else if(md.getKindOfDrink()==2) {
					FrappuccinoCustom fc = new FrappuccinoCustom(mainFrame,"Frappuccino Personal Option",true,fra);
				}else if(md.getKindOfDrink()==3) {
					TeaCustom tc = new TeaCustom(mainFrame,"Tea Personal Option",true,te);
				}
			} else if(e.getSource()==orderButton) {
				if(goodsNum == 0) {
					JOptionPane.showMessageDialog(null,"ÁÖ¹® ½ÇÆÐ");
				}else {
					if(sizeCb.getSelectedItem().equals("Grande")) {
						sendPrice += 500;
					}
					else if(sizeCb.getSelectedItem().equals("Venti")) {
						sendPrice += 1000;
					}
					else if(sizeCb.getSelectedItem().equals("Short")) {
						sendPrice -= 500;
					}
					switch(md.getKindOfDrink()) {
					case 1:
						espre.setKindOfMenu("¿¡½ºÇÁ·¹¼Ò");
						espre.setMenuName(goodsName.getText());
						espre.setNumberOfGoods(goodsNum);
						espre.setPrice(sendPrice);
						espre.setSize((String)sizeCb.getSelectedItem());
						Calendar od = Calendar.getInstance();
						espre.setOrderDate(od);
						orderAl.add(espre);break;
					case 2:
						fra.setKindOfMenu("ÇÁ¶óÇªÄ¡³ë");
						fra.setMenuName(goodsName.getText());
						fra.setNumberOfGoods(goodsNum);
						fra.setPrice(sendPrice);
						fra.setSize((String)sizeCb.getSelectedItem());
						od = Calendar.getInstance();
						fra.setOrderDate(od);
						orderAl.add(fra);
						break;
					case 3:
						te.setKindOfMenu("Æ¼");
						te.setMenuName(goodsName.getText());
						te.setNumberOfGoods(goodsNum);
						te.setPrice(sendPrice);
						te.setSize((String)sizeCb.getSelectedItem());
						od = Calendar.getInstance();
						te.setOrderDate(od);
						orderAl.add(te);
						break;
					}
					mainPanel.remove(2);
					MenuView mv = new MenuView(mainPanel, mainFrame, orderAl, md, accessMember);
					mainPanel.add(mv,"menu",2);
					((CardLayout)mainPanel.getLayout()).show(mainPanel, "menu");
				}
			} else if(e.getSource()==cancelButton) {
				goodsNum=0;
				orderCnt.setText(""+goodsNum);
				hotButton.setIcon(img_hot_selected);
				icedButton.setIcon(img_iced_unselected);
				sizeCb.setSelectedIndex(1);
				cupCb.setSelectedIndex(0);
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

	
