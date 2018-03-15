package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class MenuView extends JPanel implements ActionListener{
	private JPanel title = new JPanel();
	private JPanel payment = new JPanel();
	private JPanel menu = new JPanel();
	private JLabel titleName = new JLabel("메뉴");
	private JPanel menuTitle = new JPanel();
	private JPanel menuCenter = new JPanel();
	private JButton espressoButton = new JButton("에스프레소");
	private JButton frappuccinoButton = new JButton("프라푸치노");
	private JButton teaButton = new JButton("티");
	private JButton dessortButton = new JButton("디저트");

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
	
	private JPanel espPanel[] = new JPanel[6];
	private JPanel fraPanel[] = new JPanel[6];
	private JPanel teaPanel[] = new JPanel[6];
	private JPanel desPanel[] = new JPanel[6];
	private int cardNumber = 1;
	
//	private JButton
	private JLabel paymentTitle = new JLabel("결제");
	private JPanel paymentCenter1 = new JPanel();
	private JPanel paymentCenter2 = new JPanel();
	private JPanel paymentSouth = new JPanel();
	private JButton paymentPayButton = new JButton("주문하기");
	private JButton paymentCancelButon = new JButton("취소하기");
	private JLabel paymentTotalPrice = new JLabel("총 가격 : ");
	private JLabel totalPrice = new JLabel("원");
	private JScrollPane paymentScroll = null;
	private ArrayList<JPanel> payList = new ArrayList<JPanel>();
	
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
			espPanel[i] = new JPanel();
			menuCard[0].add(espPanel[i]);
			espPanel[i].setLayout(new BorderLayout());
			espPanel[i].setBackground(Color.white);
		}

		for(int i=0;i<espPanel.length;i++) {
			espName[i].setHorizontalAlignment(JLabel.CENTER);
			espPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			espPanel[i].add(espPicLabel[i],BorderLayout.NORTH);
			espPanel[i].add(espName[i],BorderLayout.CENTER);
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
			fraPanel[i] = new JPanel();
			menuCard[1].add(fraPanel[i]);
			fraPanel[i].setLayout(new BorderLayout());
			fraPanel[i].setBackground(Color.white);
		}
		for(int i=0;i<fraPanel.length;i++) {
			fraName[i].setHorizontalAlignment(JLabel.CENTER);
			fraPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			fraPanel[i].add(fraPicLabel[i],BorderLayout.NORTH);
			fraPanel[i].add(fraName[i],BorderLayout.CENTER);
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
			teaPanel[i] = new JPanel();
			menuCard[2].add(teaPanel[i]);
			teaPanel[i].setLayout(new BorderLayout());
			teaPanel[i].setBackground(Color.white);
		}

		for(int i=0;i<teaPanel.length;i++) {
			teaName[i].setHorizontalAlignment(JLabel.CENTER);
			teaPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			teaPanel[i].add(teaPicLabel[i],BorderLayout.NORTH);
			teaPanel[i].add(teaName[i],BorderLayout.CENTER);
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
			desPanel[i] = new JPanel();
			menuCard[3].add(desPanel[i]);
			desPanel[i].setLayout(new BorderLayout());
			desPanel[i].setBackground(Color.white);
		}

		for(int i=0;i<desPanel.length;i++) {
			desName[i].setHorizontalAlignment(JLabel.CENTER);
			desPicLabel[i].setHorizontalAlignment(JLabel.CENTER);
			desPanel[i].add(desPicLabel[i],BorderLayout.NORTH);
			desPanel[i].add(desName[i],BorderLayout.CENTER);
		}
	}

	public void menuInit() {
		title.setPreferredSize(new Dimension(100,100));
		menu.setPreferredSize(new Dimension(300,100));
		title.add(titleName);
		menu.setLayout(new BorderLayout());
		menuTitle.setBackground(Color.white);
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
		}
	}
	
	public void paymentInit() {
		
		paymentCenterInit();
		paymentSouthInit();
		payment.setBackground(Color.YELLOW);
		payment.setPreferredSize(new Dimension(250,100));
		payment.setLayout(new BorderLayout());
		paymentTitle.setPreferredSize(new Dimension(250,100));
		
		payment.add(paymentScroll,BorderLayout.CENTER);
		payment.add(paymentTitle,BorderLayout.NORTH);
		payment.add(paymentSouth,BorderLayout.SOUTH);

	}
	
	public void paymentCenterInit() {
		paymentCenter1.setLayout(new GridBagLayout());
		paymentCenter2.add(paymentCenter1);
		paymentScroll = new JScrollPane(paymentCenter2);
		
		JPanel jp[] = new JPanel[10];
		payList.add(jp[0] = new JPanel()); 
		payList.add(jp[1] = new JPanel()); 
		payList.add(jp[2] = new JPanel()); 
		payList.add(jp[3] = new JPanel()); 
		payList.add(jp[4] = new JPanel()); 
		payList.add(jp[5] = new JPanel()); 
		payList.add(jp[6] = new JPanel()); 
		payList.add(jp[7] = new JPanel()); 
		payList.add(jp[8] = new JPanel()); 
		payList.add(jp[9] = new JPanel()); 
		
		for(int i=0;i<jp.length;i++) {
			if(i%2==0) {
				jp[i].setBackground(Color.blue);
			}
			jp[i].setPreferredSize(new Dimension(230,100));
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
		paymentSouth.add(paymentTotalPrice);
		paymentSouth.add(totalPrice);
		paymentSouth.add(paymentPayButton);
		paymentSouth.add(paymentCancelButon);
	}
	
	public void comInit() {
		this.menuInit();
		this.paymentInit();
		this.add(title, BorderLayout.NORTH);
		this.add(payment, BorderLayout.EAST);
		this.add(menu,BorderLayout.CENTER);
	}

	public MenuView() {
		this.setSize(1000,800);
		this.setLayout(new BorderLayout());
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
//		this.setTitle("메뉴");
//		this.setLocationRelativeTo(null);
		comInit();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		}
		((CardLayout)(menuCenter.getLayout())).show(menuCenter, Integer.toString(cardNumber));
	}
}
