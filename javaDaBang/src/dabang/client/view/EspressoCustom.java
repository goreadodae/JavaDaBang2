package dabang.client.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import dabang.client.model.Espresso;

public class EspressoCustom extends JDialog {
//	private JFrame customFrame = new JFrame();
	private JButton button = new JButton("다이얼");
	private JButton button1 = new JButton("<-");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Personal Option");

	private JPanel panel2 =new JPanel();
	private JLabel label2 = new JLabel("에스프레소 샷");
	private JButton button2p = new JButton("+");
	private JButton button2m = new JButton("-");
	private JLabel clabel2 = null;
	private int count2 = 2;

	private JPanel panel3 =new JPanel();
	private JLabel label3 = new JLabel("시럽");
	private JButton button3p = new JButton("+");
	private JButton button3m = new JButton("-");
	private JLabel clabel3 = null;
	private int count3 = 0;

	private JPanel panel4 =new JPanel();
	private JLabel label4 = new JLabel("물");
	private JRadioButton waterfew = new JRadioButton("적게", false);
	private JRadioButton waterregular = new JRadioButton("보통", true);
	private JRadioButton waterlots = new JRadioButton("많이", false);

	private JPanel panel5 =new JPanel();
	private JLabel label5 = new JLabel("얼음");
	private JCheckBox ice = new JCheckBox("적게", false);

	private JPanel panel6 =new JPanel();
	private JLabel label6 = new JLabel("휘핑");
	private JRadioButton whipfew = new JRadioButton("적게", false);
	private JRadioButton whipregular = new JRadioButton("보통", false);
	private JRadioButton whiplots = new JRadioButton("많이", false);

	private JPanel panel7 =new JPanel();
	private JLabel label7 = new JLabel("드리즐");
	private JRadioButton drizzlefew = new JRadioButton("적게", false);
	private JRadioButton drizzleregular = new JRadioButton("보통", false);
	private JRadioButton drizzlelots = new JRadioButton("많이", false);

	private JPanel panel8 = new JPanel();
	private JButton button8_1 = new JButton("옵션 초기화 하기");
	private JButton button8_2 = new JButton("확인");




//	Dialog d = new Dialog(this, "다이얼로그");
	public void comInit()
	{
//		this.add(button);

		clabel2 = new JLabel(Integer.toString(count2)); // 에스프레소
		clabel2.setFont(new Font("Serif", Font.BOLD,20));

		clabel3 = new JLabel(Integer.toString(count3)); //시럽
		clabel3.setFont(new Font("Serif", Font.BOLD,20));

		// 퍼스널 옵션
		panel.setBackground(Color.black); // 패널 백그라운드 색
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20)); //패널 레이아웃
		label.setFont(new Font("Serif", Font.ITALIC,20)); //패널 폰트, 크기
		label.setForeground(Color.WHITE); //퍼스널옵션 색
		panel.add(button1); //뒤로가는 버튼

		button1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button1)
				{
					dispose();
				}
			}
		});
		panel.add(label);

		//에스프레소 샷
		panel2.setBackground(Color.white); // 2패널 배경색
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //2패널 레이아웃
		label2.setFont(new Font("Serif", Font.ITALIC,20)); //2패널 폰트, 크기
		panel2.add(label2); //에스프레소 샷

		// +,- 버튼액션
		panel2.add(button2m); // -버튼
		button2m.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button2m)
				{
					if(count2 >= 2) {
						count2--; // -카운팅
						clabel2.setText(Integer.toString(count2));
					}
				}
			}
		});
		panel2.add(clabel2); // 카운트 라벨
		panel2.add(button2p); // +버튼
		button2p.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button2p)
				{
					if(0 <= count2 && count2 <= 8) {
						count2++; // +카운팅
				 		clabel2.setText(Integer.toString(count2));
					}
				}
			}
		});


		//시럽
		panel3.setBackground(Color.LIGHT_GRAY); // 3패널 배경색
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //3패널 레이아웃
		label3.setFont(new Font("Serif", Font.ITALIC,20)); //3패널 폰트, 크기
		panel3.add(label3); //시럽

		// +,- 버튼액션
		panel3.add(button3m); // -버튼
		button3m.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button3m)
				{
					if(count3 >= 1) {
						count3--; // -카운팅
						clabel3.setText(Integer.toString(count3));
					}
				}
			}
		});
		panel3.add(clabel3); // 카운트 라벨
		panel3.add(button3p);
		button3p.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button3p)
				{
					if(0 <= count3 && count3 <= 8) {
						count3++; // +카운팅
				 		clabel3.setText(Integer.toString(count3));
					}
				}
			}
		});

		//베이스(물)
		panel4.setBackground(Color.white); //4패널 배경색
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //4패널 레이아웃
		label4.setFont(new Font("Serif", Font.ITALIC,20)); //4패널 폰트, 크기
		panel4.add(label4); //물

		ButtonGroup waterbg = new ButtonGroup(); // 물 라디오버튼 그룹
		waterbg.add(waterfew);
		waterbg.add(waterregular);
		waterbg.add(waterlots);

		waterfew.setBackground(Color.white); //백그라운드 색과 동일하게 설정
		waterregular.setBackground(Color.white);
		waterlots.setBackground(Color.white);

		panel4.add(waterfew);
		panel4.add(waterregular);
		panel4.add(waterlots);

		
		//얼음
		panel5.setBackground(Color.LIGHT_GRAY); // 5패널 배경색
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 5패널 레이아웃
		label5.setFont(new Font("Serif", Font.ITALIC,20)); // 5패널 폰트, 크기
		panel5.add(label5); //얼음

		ice.setBackground(Color.LIGHT_GRAY); // 배경색과 동일하게 설정

		panel5.add(ice);


		//휘핑
		panel6.setBackground(Color.white); // 6패널 배경색
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 6패널 레이아웃
		label6.setFont(new Font("Serif", Font.ITALIC,20)); // 6패널 폰트, 크기
		panel6.add(label6);

		ButtonGroup whipbg = new ButtonGroup(); //휘핑 라디오버튼 그룹
		whipbg.add(whipfew);
		whipbg.add(whipregular);
		whipbg.add(whiplots);

		whipfew.setBackground(Color.white); // 배경색과 동일하게 설정
		whipregular.setBackground(Color.white);
		whiplots.setBackground(Color.white);

		panel6.add(whipfew);
		panel6.add(whipregular);
		panel6.add(whiplots);


		//드리즐
		panel7.setBackground(Color.LIGHT_GRAY); // 7패널 배경색
		panel7.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 7패널 레이아웃
		label7.setFont(new Font("Serif", Font.ITALIC,20)); // 7패널 폰트, 크기
		panel7.add(label7);

		ButtonGroup drizzlebg = new ButtonGroup(); // 라디오버튼 그룹화
		drizzlebg.add(drizzlefew);
		drizzlebg.add(drizzleregular);
		drizzlebg.add(drizzlelots);

		drizzlefew.setBackground(Color.LIGHT_GRAY); //백그라운드 색과 동일하게 설정
		drizzleregular.setBackground(Color.LIGHT_GRAY);
		drizzlelots.setBackground(Color.LIGHT_GRAY);

		panel7.add(drizzlefew);
		panel7.add(drizzleregular);
		panel7.add(drizzlelots);
		

		panel8.setBackground(Color.white); //패널 배경색
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER,10,15)); //패널 레이아웃
		panel8.add(button8_1); //옵션 초기화 버튼
		panel8.add(button8_2); //확인 버튼

		// 옵션 초기화
		button8_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button8_1)
				{
					count2 = 2;
					clabel2.setText(Integer.toString(count2)); // 샷 초기화
					count3 = 0;
					clabel3.setText(Integer.toString(count3)); //시럽 초기화
					waterregular.setSelected(true); // 물 보통으로 초기화
					ice.setSelected(false); // 얼음 선택해제
					whipbg.clearSelection(); // 휘핑 선택해제
					drizzlebg.clearSelection(); // 드리즐 선택해제
				}
			}
		});

		button8_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button8_2)
				{ //물, 휘핑, 드리즐, 아이스체크
					int water = 0, whip = 0, drizzle = 0, iceChk = 0;
					for(Enumeration<AbstractButton> waterbs = waterbg.getElements(); waterbs.hasMoreElements();) {
						AbstractButton waterb = waterbs.nextElement();
						if(waterb.isSelected()) { //물
							switch(waterb.getText()) {
							case "적게" : water = 1; break;
							case "보통" : water = 2; break;
							case "많이" : water = 3; break;
							}
						}
					}
					for(Enumeration<AbstractButton> whipbs = whipbg.getElements(); whipbs.hasMoreElements();) {
						AbstractButton whipb = whipbs.nextElement(); //Enumeration은 버튼을 하나씩 처리
						if(whipb.isSelected()) { //휘핑
							switch(whipb.getText()) {
							case "적게" : whip = 1; break;
							case "보통" : whip = 2; break;
							case "많이" : whip = 3; break;
							default : whip = 0;
							}
						}
					}
					for(Enumeration<AbstractButton> drizzlebs = drizzlebg.getElements(); drizzlebs.hasMoreElements();) {
						AbstractButton drizzleb = drizzlebs.nextElement();
						if(drizzleb.isSelected()) { //드리즐
							switch(drizzleb.getText()) {
							case "적게" : drizzle = 1; break;
							case "보통" : drizzle = 2; break;
							case "많이" : drizzle = 3; break;
							default : drizzle = 0;
							}
						}
					}
					if(ice.isSelected()) iceChk = 1; //아이스가 체크되어있을때  아이스를 1로 만듦
					
					System.out.println("샷 : "+Integer.toString(count2));
					System.out.println("시럽 : "+Integer.toString(count3));
					System.out.println("물 : "+water);
					System.out.println("얼음 : "+iceChk);
					System.out.println("휘핑 : "+whip);
					System.out.println("드리즐 : "+drizzle);
					
					Espresso eps = new Espresso();
					eps.setShot(count2); // 샷 양
					eps.setSyrupNum(count3); // 시럽 양
					eps.setWaterAmount(water); //물 양
					eps.setIceAmount(iceChk); //아이스 양
					eps.setWhipAmount(whip);  // 휘핑 양
					eps.setDrizzleAmount(drizzle); //드리즐 양
					
					setVisible(false);
				}
			}
		});


		this.add(panel);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);
		this.add(panel7);
		this.add(panel8);
		
	}

	public EspressoCustom(JFrame frame, String title, boolean b)
	{
		super(frame,title,b);
		this.setLayout(new GridLayout(8,1,10,10));
		this.setSize(500, 700);
		this.setLocation(950,170);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.comInit();
		this.setVisible(true);
	}

	public EspressoCustom() {}
}
