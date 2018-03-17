package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dabang.client.model.MenuDrink;
import dabang.client.model.OrderList;

public class MenuView extends JPanel implements ActionListener{
	private static Color bgc = new Color(246,245,239);
	private Font f1 = new Font("돋움",Font.BOLD,20);
	private Font f2 = new Font("돋움",Font.PLAIN,25);
	private JFrame mainFrame = null;
	private MenuDrink md = null; 
	private JPanel title = new JPanel();
	private ImageIcon titleIcon = new ImageIcon(new ImageIcon("Image\\menuViewImage\\menu.png").getImage());
	private JPanel payment = new JPanel();
	private JPanel menu = new JPanel();
	private JLabel titleName = new JLabel();
	private JPanel menuTitle = new JPanel();
	private JPanel menuCenter = new JPanel();
	private JButton espressoButton = new JButton("에스프레소");
	private JButton frappuccinoButton = new JButton("프라푸치노");
	private JButton teaButton = new JButton("티");
	private JButton dessortButton = new JButton("디저트");
	private ArrayList<JButton> deleteButton = new ArrayList<JButton>();

	private ImageIcon espPic[] = new ImageIcon[6];
	private ImageIcon fraPic[] = new ImageIcon[6];
	private ImageIcon teaPic[] = new ImageIcon[6];
	private ImageIcon desPic[] = new ImageIcon[6];

	private JLabel espPicLabel[] = new JLabel[6];
	private JLabel fraPicLabel[] = new JLabel[6];
	private JLabel teaPicLabel[] = new JLabel[6];
	private JLabel desPicLabel[] = new JLabel[6];

	private JLabel espName[] = new JLabel[6];
	private JLabel fraName[] = new JLabel[6];
	private JLabel teaName[] = new JLabel[6];
	private JLabel desName[] = new JLabel[6];

	private JPanel menuCard[] = new JPanel[4];

	private JButton espPanel[] = new JButton[6];
	private JButton fraPanel[] = new JButton[6];
	private JButton teaPanel[] = new JButton[6];
	private JButton desPanel[] = new JButton[6];
	private int cardNumber = 1;

	private JLabel paymentTitle = new JLabel();
	private ImageIcon paymentTitleIcon = new ImageIcon(new ImageIcon("Image\\menuViewImage\\payment.png").getImage());
	private JPanel paymentCenter1 = new JPanel();
	private JPanel paymentCenter2 = new JPanel();
	private JPanel paymentSouth = new JPanel();
	private JButton paymentPayButton = new JButton("주문하기");
	private JButton paymentCancelButon = new JButton("취소하기");
	private JLabel paymentTotalPrice = new JLabel("총 가격 : ");
	private JLabel totalPrice = null;
	private JScrollPane paymentScroll = null;
	private ArrayList<JPanel> payList = new ArrayList<JPanel>();

	private JPanel mainPanel = null;
	private ArrayList<OrderList> orderAl = null;

	ArrayList<JPanel> jp = null;
	ArrayList<JLabel> orderName = null;
	ArrayList<JLabel> orderNum = null;
	ArrayList<JLabel> orderSize = null;
	ArrayList<JLabel> orderPrice = null;
	ArrayList<JLabel> orderCancel = null;
	private int totalPriceNum;
	
	public void menuInit1() {
		for(int i=0;i<espPanel.length;i++) {
			espName[i] = new JLabel();
			espPicLabel[i] = new JLabel();
		}

		espPic[0] = new ImageIcon(new ImageIcon("Image\\MenuImage\\1아메리카노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		espPic[1] = new ImageIcon(new ImageIcon("Image\\MenuImage\\1돌체라떼.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		espPic[2] = new ImageIcon(new ImageIcon("Image\\MenuImage\\1카페모카.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		espPic[3] = new ImageIcon(new ImageIcon("Image\\MenuImage\\1카페라떼.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		espPic[4] = new ImageIcon(new ImageIcon("Image\\MenuImage\\1카라멜마키아또.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		espPic[5] = new ImageIcon(new ImageIcon("Image\\MenuImage\\1카푸치노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

		for(int i=0;i<espPicLabel.length;i++) {
			espPicLabel[i].setIcon(espPic[i]);
		}

		espName[0].setText("아메리카노");
		espName[1].setText("돌체라떼");
		espName[2].setText("카페모카");
		espName[3].setText("카페라떼");
		espName[4].setText("카라멜 마키아또");
		espName[5].setText("카푸치노");

		for(int i=0;i<espPanel.length;i++) {
			espPanel[i] = new JButton();
			menuCard[0].add(espPanel[i]);
			espPanel[i].setLayout(new BorderLayout());
			espPanel[i].setBackground(Color.white);
		}

		for(int i=0;i<espPanel.length;i++) {
			espName[i].setHorizontalAlignment(JLabel.CENTER);
			espPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			espPanel[i].add(espPicLabel[i],BorderLayout.NORTH);
			espPanel[i].add(espName[i],BorderLayout.CENTER);
			espPanel[i].addActionListener(this);
		}

	}
	public void menuInit2() {
		for(int i=0;i<espPanel.length;i++) {
			fraName[i] = new JLabel();
			fraPicLabel[i] = new JLabel();
		}
		fraPic[0] = new ImageIcon(new ImageIcon("Image\\MenuImage\\2자바 칩 프라푸치노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		fraPic[1] = new ImageIcon(new ImageIcon("Image\\MenuImage\\2화이트 초콜릿 모카 프라푸치노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		fraPic[2] = new ImageIcon(new ImageIcon("Image\\MenuImage\\2카라멜 프라푸치노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		fraPic[3] = new ImageIcon(new ImageIcon("Image\\MenuImage\\2모카 프라푸치노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		fraPic[4] = new ImageIcon(new ImageIcon("Image\\MenuImage\\2에스프레소 프라푸치노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		fraPic[5] = new ImageIcon(new ImageIcon("Image\\MenuImage\\2그린 티 프라푸치노.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

		for(int i=0;i<fraPicLabel.length;i++) {
			fraPicLabel[i].setIcon(fraPic[i]);
		}

		fraName[0].setText("자바 칩 프라푸치노");
		fraName[1].setText("화이트 초콜릿 모카 프라푸치노");
		fraName[2].setText("카라멜 프라푸치노");
		fraName[3].setText("모카 프라푸치노");
		fraName[4].setText("에스프레소 프라푸치노");
		fraName[5].setText("그린 티 프라푸치노");

		for(int i=0;i<fraPanel.length;i++) {
			fraPanel[i] = new JButton();
			menuCard[1].add(fraPanel[i]);
			fraPanel[i].setLayout(new BorderLayout());
			fraPanel[i].setBackground(Color.white);
		}
		for(int i=0;i<fraPanel.length;i++) {
			fraName[i].setHorizontalAlignment(JLabel.CENTER);
			fraPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			fraPanel[i].add(fraPicLabel[i],BorderLayout.NORTH);
			fraPanel[i].add(fraName[i],BorderLayout.CENTER);
			fraPanel[i].addActionListener(this);
		}

	}
	public void menuInit3() {
		for(int i=0;i<teaPanel.length;i++) {
			teaName[i] = new JLabel();
			teaPicLabel[i] = new JLabel();
		}

		teaPic[0] = new ImageIcon(new ImageIcon("Image\\MenuImage\\3그린 티 라떼.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		teaPic[1] = new ImageIcon(new ImageIcon("Image\\MenuImage\\3민트 블렌드 티.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		teaPic[2] = new ImageIcon(new ImageIcon("Image\\MenuImage\\3얼 그레이 티.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		teaPic[3] = new ImageIcon(new ImageIcon("Image\\MenuImage\\3유스베리 티.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		teaPic[4] = new ImageIcon(new ImageIcon("Image\\MenuImage\\3차이 티.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		teaPic[5] = new ImageIcon(new ImageIcon("Image\\MenuImage\\3캐모마일 블렌드 티.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

		for(int i=0;i<teaPicLabel.length;i++) {
			teaPicLabel[i].setIcon(teaPic[i]);
		}

		teaName[0].setText("그린 티 라떼");
		teaName[1].setText("민트 블렌드 티");
		teaName[2].setText("얼 그레이 티");
		teaName[3].setText("유스베리 티");
		teaName[4].setText("차이 티");
		teaName[5].setText("캐모마일 블렌드 티");

		for(int i=0;i<teaPanel.length;i++) {
			teaPanel[i] = new JButton();
			menuCard[2].add(teaPanel[i]);
			teaPanel[i].setLayout(new BorderLayout());
			teaPanel[i].setBackground(Color.white);
		}

		for(int i=0;i<teaPanel.length;i++) {
			teaName[i].setHorizontalAlignment(JLabel.CENTER);
			teaPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			teaPanel[i].add(teaPicLabel[i],BorderLayout.NORTH);
			teaPanel[i].add(teaName[i],BorderLayout.CENTER);
			teaPanel[i].addActionListener(this);
		}
	}
	public void menuInit4() {
		for(int i=0;i<desPanel.length;i++) {
			desName[i] = new JLabel();
			desPicLabel[i] = new JLabel();
		}

		desPic[0] = new ImageIcon(new ImageIcon("Image\\MenuImage\\4부드러운 생크림 카스텔라.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		desPic[1] = new ImageIcon(new ImageIcon("Image\\MenuImage\\4블루베리 쿠키 치즈 케이크.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		desPic[2] = new ImageIcon(new ImageIcon("Image\\MenuImage\\4티라미수.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		desPic[3] = new ImageIcon(new ImageIcon("Image\\MenuImage\\4크랜베리 치킨 치즈 샌드위치.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		desPic[4] = new ImageIcon(new ImageIcon("Image\\MenuImage\\4크로크 무슈.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		desPic[5] = new ImageIcon(new ImageIcon("Image\\MenuImage\\4터키 멜팅 치즈 샌드위치.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

		for(int i=0;i<desPicLabel.length;i++) {
			desPicLabel[i].setIcon(desPic[i]);
		}

		desName[0].setText("부드러운 생크림 카스텔라");
		desName[1].setText("블루베리 쿠키 치즈 케이크");
		desName[2].setText("티라미수");
		desName[3].setText("크램베리 치킨 치즈 샌드위치");
		desName[4].setText("크로크 무슈");
		desName[5].setText("터키 멜팅 치즈 샌드위치");

		for(int i=0;i<desPanel.length;i++) {
			desPanel[i] = new JButton();
			menuCard[3].add(desPanel[i]);
			desPanel[i].setLayout(new BorderLayout());
			desPanel[i].setBackground(Color.white);
		}

		for(int i=0;i<desPanel.length;i++) {
			desName[i].setHorizontalAlignment(JLabel.CENTER);
			desPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			desPanel[i].add(desPicLabel[i],BorderLayout.NORTH);
			desPanel[i].add(desName[i],BorderLayout.CENTER);
			desPanel[i].addActionListener(this);
		}
	}

	public void menuInit() {
		title.setPreferredSize(new Dimension(100,100));
		menu.setPreferredSize(new Dimension(300,100));
		titleName.setIcon(titleIcon);
		title.setLayout(new GridLayout(1,2));
		title.add(titleName);
		menu.setLayout(new BorderLayout());
		title.setBackground(bgc);
		menuTitle.setBackground(bgc);
		menu.setBackground(bgc);
		menuTitle.setPreferredSize(new Dimension(300,100));
		menu.add(menuTitle, BorderLayout.NORTH);
		menu.add(menuCenter, BorderLayout.CENTER);

		this.menuCardInit();
		menuTitle.setLayout(new FlowLayout(FlowLayout.LEFT,70,35));
		menuTitle.add(espressoButton);
		menuTitle.add(frappuccinoButton);
		menuTitle.add(teaButton);
		menuTitle.add(dessortButton);

		espressoButton.addActionListener(this);
		frappuccinoButton.addActionListener(this);
		teaButton.addActionListener(this);
		dessortButton.addActionListener(this);

		menuInit1();
		menuInit2();
		menuInit3();
		menuInit4();
	}

	public void menuCardInit() {
		menuCenter.setLayout(new CardLayout());
		for(int i=0;i<menuCard.length;i++) {
			menuCard[i] = new JPanel();
			menuCenter.add(Integer.toString(i+1),menuCard[i]);
			menuCard[i].setLayout(new GridLayout(2, 3));
			menuCard[i].setBackground(bgc);
		}
	}

	public void paymentInit() {

		paymentCenterInit();
		paymentSouthInit();
		payment.setBackground(bgc);
		payment.setPreferredSize(new Dimension(250,50));
		payment.setLayout(new BorderLayout());
		paymentTitle.setPreferredSize(new Dimension(250,70));
		paymentTitle.setIcon(paymentTitleIcon);
		payment.add(paymentScroll,BorderLayout.CENTER);
		payment.add(paymentTitle,BorderLayout.NORTH);
		payment.add(paymentSouth,BorderLayout.SOUTH);

	}

	public void paymentCenterInit() {
		paymentCenter1.setLayout(new GridBagLayout());
		paymentCenter2.add(paymentCenter1);
		paymentScroll = new JScrollPane(paymentCenter2);
		paymentScroll.getVerticalScrollBar().setUnitIncrement(16);
		
		paymentCenter1.setBackground(bgc);
		paymentCenter2.setBackground(bgc);
		jp = new ArrayList<JPanel>();
		orderName = new ArrayList<JLabel>();
		orderNum = new ArrayList<JLabel>();
		orderSize = new ArrayList<JLabel>();
		orderPrice = new ArrayList<JLabel>();
		orderCancel = new ArrayList<JLabel>();

		for(int i=0;i<orderAl.size();i++) {
			jp.add(new JPanel());
			jp.get(i).setLayout(new BorderLayout());
			
			deleteButton.add(new JButton("x"));
			jp.get(i).setPreferredSize(new Dimension(230,100));
			orderName.add(new JLabel());
			orderNum.add(new JLabel());
			orderSize.add(new JLabel());
			orderPrice.add(new JLabel());
			orderCancel.add(new JLabel());
			orderName.get(i).setText(orderAl.get(i).getName());
			orderNum.get(i).setText(Integer.toString(orderAl.get(i).getOrderNum())+" 개");
			orderSize.get(i).setText("사이즈 : "+orderAl.get(i).getSize());
			orderPrice.get(i).setText(Integer.toString(orderAl.get(i).getPrice()*orderAl.get(i).getOrderNum())+"원");
			orderName.get(i).setFont(f1);
			
			jp.get(i).add(orderName.get(i),BorderLayout.NORTH);
			JPanel nspPanel = new JPanel();
			orderNum.get(i).setHorizontalAlignment(JLabel.RIGHT);
			orderSize.get(i).setHorizontalAlignment(JLabel.RIGHT);
			orderPrice.get(i).setHorizontalAlignment(JLabel.RIGHT);
			nspPanel.setLayout(new GridLayout(3,1));
			nspPanel.setBackground(Color.white);
			nspPanel.add(orderNum.get(i));
			nspPanel.add(orderSize.get(i));
			nspPanel.add(orderPrice.get(i));
			jp.get(i).add(nspPanel,BorderLayout.CENTER);
//			jp.get(i).add(orderNum.get(i),BorderLayout.CENTER);
//			jp.get(i).add(orderSize.get(i),BorderLayout.CENTER);
//			jp.get(i).add(orderPrice.get(i),BorderLayout.CENTER);
			JPanel buttonPanel = new JPanel();
			buttonPanel.add(deleteButton.get(i));
			buttonPanel.setBackground(Color.white);
			deleteButton.get(i).setPreferredSize(new Dimension(35,35));
			jp.get(i).add(buttonPanel,BorderLayout.EAST);
			
			jp.get(i).setBackground(Color.white);
//			jp.get(i).setLayout(new GridLayout(5,1));
			payList.add(jp.get(i));
			totalPriceNum += orderAl.get(i).getPrice()*orderAl.get(i).getOrderNum();
			deleteButton.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i=0;i<deleteButton.size();i++) {
						if(e.getSource()==deleteButton.get(i)) {
							orderAl.remove(i);
							deleteButton.remove(i);
							jp.remove(i);
							mainPanel.remove(2);
							MenuView mv = new MenuView(mainPanel, mainFrame, orderAl, md);
							mainPanel.add(mv,"menu",2);
							((CardLayout)mainPanel.getLayout()).show(mainPanel, "menu");
						}
					}
				}
			});
		}
		GridBagConstraints c = new GridBagConstraints();
		for(int i=0;i<payList.size();i++) {
			c.gridx = 1;
			c.gridy = i;
			c.fill = GridBagConstraints.HORIZONTAL;
			paymentCenter1.add(payList.get(i),c);
		}
	}
	public void paymentSouthInit() {
		paymentSouth.setLayout(new GridLayout(3,2));
		paymentSouth.setBackground(bgc);
		paymentSouth.add(paymentTotalPrice);
		paymentTotalPrice.setFont(f2);
		totalPrice = new JLabel(Integer.valueOf(totalPriceNum)+"원");
		totalPrice.setFont(f2);
		totalPrice.setHorizontalAlignment(JLabel.RIGHT);
		paymentSouth.add(totalPrice);
		paymentSouth.add(paymentPayButton);
		paymentSouth.add(paymentCancelButon);
		paymentCancelButon.addActionListener(this);
	}

	public void comInit() {
		this.menuInit();
		this.paymentInit();
		this.add(title, BorderLayout.NORTH);
		this.add(payment, BorderLayout.EAST);
		this.add(menu,BorderLayout.CENTER);
	}

	public MenuView(JPanel mainPanel, JFrame mainFrame, ArrayList<OrderList> orderAl, MenuDrink md) {
		this.md = md;
		this.mainFrame = mainFrame;
		this.setSize(1000,800);
		this.setLayout(new BorderLayout());
		//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);
		//		this.setTitle("메뉴");
		//		this.setLocationRelativeTo(null);
		this.mainPanel = mainPanel;
		this.orderAl = orderAl;
		this.setBackground(Color.WHITE);
		comInit();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==espressoButton) {
			cardNumber = 1;
		}else if(e.getSource()==frappuccinoButton) {
			cardNumber = 2;
			repaint();
		}else if(e.getSource()==teaButton) {
			cardNumber = 3;
		}
		else if(e.getSource()==dessortButton) {
			cardNumber = 4;
		}else if(e.getSource()==paymentCancelButon) {
			orderAl.clear();
			mainPanel.remove(2);
			MenuView mv = new MenuView(mainPanel, mainFrame, orderAl, md);
			mainPanel.add(mv,"menu",2);
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "memberMain");
		}
		else {
			mainPanel.remove(3);

			if(e.getSource()==espPanel[0]) {//에에스프레소!
				md.setGoodsName("americano");
				md.setKindOfDrink(1);
			}else if(e.getSource()==espPanel[1]) {
				md.setGoodsName("dolceLatte");
				md.setKindOfDrink(1);
			}else if(e.getSource()==espPanel[2]) {
				md.setGoodsName("cafeMocha"); 
				md.setKindOfDrink(1);
			}else if(e.getSource()==espPanel[3]) {
				md.setGoodsName("cafeLatte");
				md.setKindOfDrink(1);
			}else if(e.getSource()==espPanel[4]) {
				md.setGoodsName("caramelMacchiato");
				md.setKindOfDrink(1);
			}else if(e.getSource()==espPanel[5]) {
				md.setGoodsName("cappuccino");
				md.setKindOfDrink(1);
			}//프으라푸치노!
			else if(e.getSource()==fraPanel[0]){
				md.setGoodsName("javaChip");
				md.setKindOfDrink(2);
			}else if(e.getSource()==fraPanel[1]){
				md.setGoodsName("whiteChocolate");
				md.setKindOfDrink(2);
			}else if(e.getSource()==fraPanel[2]){
				md.setGoodsName("caramel");
				md.setKindOfDrink(2);
			}else if(e.getSource()==fraPanel[3]){
				md.setGoodsName("mocha");
				md.setKindOfDrink(2);
			}else if(e.getSource()==fraPanel[4]){
				md.setGoodsName("espresso");
				md.setKindOfDrink(2);
			}else if(e.getSource()==fraPanel[5]){
				md.setGoodsName("greenTea");
				md.setKindOfDrink(2);
			}//티이~
			else if(e.getSource()==teaPanel[0]){
				md.setGoodsName("greenTeaLatte");
				md.setKindOfDrink(3);
			}else if(e.getSource()==teaPanel[1]){
				md.setGoodsName("mintTea");
				md.setKindOfDrink(3);
			}else if(e.getSource()==teaPanel[2]){
				md.setGoodsName("earlGrey");
				md.setKindOfDrink(3);
			}else if(e.getSource()==teaPanel[3]){
				md.setGoodsName("youthBerry");
				md.setKindOfDrink(3);
			}else if(e.getSource()==teaPanel[4]){
				md.setGoodsName("chaiTea");
				md.setKindOfDrink(3);
			}else if(e.getSource()==teaPanel[5]){
				md.setGoodsName("chamomile");
				md.setKindOfDrink(3);
			}//디이절트!
			else if(e.getSource()==desPanel[0]){
				md.setGoodsName("castella");
				md.setKindOfDrink(4);
			}else if(e.getSource()==desPanel[1]){
				md.setGoodsName("blueberryCake");
				md.setKindOfDrink(4);
			}else if(e.getSource()==desPanel[2]){
				md.setGoodsName("tiramisu");
				md.setKindOfDrink(4);
			}else if(e.getSource()==desPanel[3]){
				md.setGoodsName("cranberrySandwich");
				md.setKindOfDrink(4);
			}else if(e.getSource()==desPanel[4]){
				md.setGoodsName("croqueMonsieur");
				md.setKindOfDrink(4);
			}else if(e.getSource()==desPanel[5]){
				md.setGoodsName("turkeySandwich");
				md.setKindOfDrink(4);
			}
			
			if(md.getKindOfDrink()>0 && md.getKindOfDrink()<4) {
				OrderView ov = new OrderView(mainPanel, mainFrame, orderAl, md);
				mainPanel.add(ov,"order",3);
			} else {
				OrderDessertView odv = new OrderDessertView(mainPanel, mainFrame, orderAl, md);
				mainPanel.add(odv,"order",3);
			}
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "order");
		}

		((CardLayout)(menuCenter.getLayout())).show(menuCenter, Integer.toString(cardNumber));
	}
}
