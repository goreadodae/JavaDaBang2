package dabang.client.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FrappuccinoCustom extends JFrame{
	
	private JButton button = new JButton("다이얼");
	private JButton button1 = new JButton("<-");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Personal Option");
	
	private JPanel panel2 =new JPanel();
	private JLabel label2 = new JLabel("프라푸치노 로스트");
	private JButton button2p = new JButton("+");
	private JButton button2m = new JButton("-");
	private JLabel clabel2 = null;
	private int count2 = 2;
	
	private JPanel panel3 =new JPanel();
	private JLabel label3 = new JLabel("시럽");
	private JButton button3p = new JButton("+");
	private JButton button3m = new JButton("-");
	private JLabel clabel3 = null;
	private int count3 = 2;
	
	private JPanel panel4 =new JPanel();
	private JLabel label4 = new JLabel("우유");
	private JRadioButton milkregular = new JRadioButton("일반우유", true);
	private JRadioButton milklow = new JRadioButton("저지방우유", false);
	private JRadioButton milkno = new JRadioButton("무지방 우유", false);
	
	private JPanel panel5 =new JPanel();
	private JLabel label5 = new JLabel("얼음");
	private JRadioButton icefew = new JRadioButton("적게", false);
	private JRadioButton iceregular = new JRadioButton("보통", true);
	private JRadioButton icelots = new JRadioButton("많이", false);
	
	private JPanel panel6 =new JPanel();
	private JLabel label6 = new JLabel("자바칩");
	private JButton button6p = new JButton("+");
	private JButton button6m = new JButton("-");
	private JLabel clabel6 = null;
	private int count6 = 2;
	
	private JPanel panel7 =new JPanel();
	private JLabel label7 = new JLabel("휘핑");
	private JRadioButton whipno = new JRadioButton("없이",false);
	private JRadioButton whipfew = new JRadioButton("적게",false);
	private JRadioButton whipregular = new JRadioButton("보통",true);
	private JRadioButton whiplots = new JRadioButton("많이",false);
	
	
	private JPanel panel8 = new JPanel();
	private JLabel label8 = new JLabel("드리즐");
	private JRadioButton drizzleno = new JRadioButton("없이", false);
	private JRadioButton drizzlefew = new JRadioButton("적게", false);
	private JRadioButton drizzleregular = new JRadioButton("보통", true);
	private JRadioButton drizzlelots = new JRadioButton("많이", false);
	
	private JPanel panel9 = new JPanel();
	private JButton button9_1 = new JButton("옵션 초기화 하기");
	private JButton button9_2 = new JButton("확인");


	
	
	Dialog d = new Dialog(this, "다이얼로그");
	public void comInit()
	{
		this.add(button);
		
		clabel2 = new JLabel(Integer.toString(count2)); // 에스프레소 카운트
		clabel2.setFont(new Font("Serif", Font.BOLD,20));
		
		clabel3 = new JLabel(Integer.toString(count2)); //시럽 카운트
		clabel3.setFont(new Font("Serif", Font.BOLD,20));
		
		clabel6 = new JLabel(Integer.toString(count2)); //자바칩 카운트
		clabel6.setFont(new Font("Serif", Font.BOLD,20));
		
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					d.setLayout(new GridLayout(9,1,10,10));
					
					// 퍼스널 옵션
					panel.setBackground(Color.black); // 1패널 배경색
					panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20)); // 1패널 레이아웃
					label.setFont(new Font("Serif", Font.ITALIC,20)); // 1패널 폰트, 크기
					label.setForeground(Color.WHITE);
					
					panel.add(button1); 
					
					button1.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button1)
							{
								System.exit(0);
							}
						}
					});
					panel.add(label);
					
					// 프라푸치노 로스트
					panel2.setBackground(Color.white); // 2패널 배경색
					panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 2패널 레이아웃
					label2.setFont(new Font("Serif", Font.ITALIC,20)); // 2패널 폰트, 크기
					panel2.add(label2); //프라푸치노 로스트
					
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
								if(count2 >= 0) {
									count2++; // +카운팅
									clabel2.setText(Integer.toString(count2));
								}	
							}
						}
					});
				
					
					//시럽
					panel3.setBackground(Color.LIGHT_GRAY); // 3패널 배경색
					panel3.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 3패널 레이아웃
					label3.setFont(new Font("Serif", Font.ITALIC,20)); // 3패널 폰트, 크기
					panel3.add(label3); //시럽
					
					// +,- 버튼액션
					panel3.add(button3m); // -버튼
					button3m.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									if(e.getSource() == button3m)
									{
										if(count3 >= 2) {
											count3--; // -카운팅
											clabel3.setText(Integer.toString(count3));
										}
									}
								}
							});
					panel3.add(clabel3); // 카운트 라벨
					panel3.add(button3p); // +버튼
					button3p.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button3p)
							{
								if(count3 >= 0) {
									count3++; // +카운팅
									clabel3.setText(Integer.toString(count3));
								}	
							}
						}
					});
					
					//우유
					panel4.setBackground(Color.white); //패널 배경색
					panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //패널 레이아웃
					label4.setFont(new Font("Serif", Font.ITALIC,20)); //패널 폰트, 크기
					panel4.add(label4); //우유
					
					ButtonGroup milkbg = new ButtonGroup(); //라디오 버튼 그룹
					milkbg.add(milkregular);
					milkbg.add(milklow);
					milkbg.add(milkno);
					
					milkregular.setBackground(Color.WHITE); //배경색에 맞춤
					milklow.setBackground(Color.WHITE);
					milkno.setBackground(Color.WHITE);
					
					panel4.add(milkregular);
					panel4.add(milklow);
					panel4.add(milkno);
					
					// 우유 리스너
					milkregular.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == milkregular)
							{
								
							}
						}
					});
					
					milklow.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == milklow)
							{
								
							}	
						}
					});
					
					milkno.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == milkno)
							{
								
							}	
						}
					});
					
					
					//얼음
					panel5.setBackground(Color.LIGHT_GRAY); // 5패널 배경색
					panel5.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 5패널 레이아웃
					label5.setFont(new Font("Serif", Font.ITALIC,20)); // 5패널 폰트, 크기
					panel5.add(label5); //얼음
					
					ButtonGroup icebg = new ButtonGroup(); //라디오버튼 그룹화
					icebg.add(icefew);
					icebg.add(iceregular);
					icebg.add(icelots);
					
					icefew.setBackground(Color.LIGHT_GRAY); //배경색과 동일하게 설정
					iceregular.setBackground(Color.LIGHT_GRAY);
					icelots.setBackground(Color.LIGHT_GRAY);
					
					panel5.add(icefew);
					panel5.add(iceregular);
					panel5.add(icelots);

					//얼음 리스너
					icefew.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == icefew)
							{
								
							}	
						}	
					});
					
					iceregular.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == iceregular)
							{
								
							}	
						}	
					});
					
					icelots.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == icelots)
							{
								
							}	
						}	
					});
					
					
					
					//자바칩
					panel6.setBackground(Color.white); // 6패널 배경색
					panel6.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 6패널 레이아웃
					label6.setFont(new Font("Serif", Font.ITALIC,20)); // 6패널 폰트, 크기
					panel6.add(label6); // 자바칩
					
					// +,- 버튼액션
					panel6.add(button6m); // -버튼
					button6m.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									if(e.getSource() == button6m)
									{
										if(count6 >= 2) {
											count6--; // -카운팅
											clabel6.setText(Integer.toString(count6));
										}
									}
								}
							});
					panel6.add(clabel6); // 카운트 라벨
					panel6.add(button6p); // +버튼
					button6p.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button6p)
							{
								if(count6 >= 0) {
									count6++; // +카운팅
									clabel6.setText(Integer.toString(count6));
								}	
							}
						}
					});
					
					
					
					//휘핑
					panel7.setBackground(Color.LIGHT_GRAY); // 7패널 배경색
					panel7.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 7패널 레이아웃
					label7.setFont(new Font("Serif", Font.ITALIC,20)); // 7패널 폰트, 크기
					panel7.add(label7); //휘핑
					
					ButtonGroup whipbg = new ButtonGroup(); //라디오버튼 그룹화
					whipbg.add(whipno);
					whipbg.add(whipfew);
					whipbg.add(whipregular);
					whipbg.add(whiplots);
					
					whipno.setBackground(Color.LIGHT_GRAY); // 배경색과 동일하게 설정
					whipfew.setBackground(Color.LIGHT_GRAY);
					whipregular.setBackground(Color.LIGHT_GRAY);
					whiplots.setBackground(Color.LIGHT_GRAY);
					
					panel7.add(whipno);
					panel7.add(whipfew);
					panel7.add(whipregular);
					panel7.add(whiplots);
					
					
					//드리즐리스너
					whipno.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == whipno)
							{
								
							}
						}
					});
					
					whipfew.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == whipfew)
							{
								
							}
						}
					});
					
					whipregular.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == whipregular)
							{
								
							}
						}
					});
					
					whiplots.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == whiplots)
							{
								
							}
						}
					});
					
					
					//드리즐
					panel8.setBackground(Color.white); // 8패널 배경색
					panel8.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 8패널 레이아웃
					label8.setFont(new Font("Serif", Font.ITALIC,20)); // 8패널 폰트, 크기
					panel8.add(label8); //드리즐
					ButtonGroup drizzlebg = new ButtonGroup(); //라디오버튼 그룹화
					drizzlebg.add(drizzleno);
					drizzlebg.add(drizzlefew);
					drizzlebg.add(drizzleregular);
					drizzlebg.add(drizzlelots);
					
					drizzleno.setBackground(Color.white); //배경색과 동일하게 설정
					drizzlefew.setBackground(Color.white);
					drizzleregular.setBackground(Color.white);
					drizzlelots.setBackground(Color.white);
					
					panel8.add(drizzleno);
					panel8.add(drizzlefew);
					panel8.add(drizzleregular);
					panel8.add(drizzlelots);
					
					
					
					//드리즐 리스너
					drizzlefew.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == drizzlefew)
							{
								
							}
						}
					});
					
					drizzleregular.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == drizzleregular)
							{
								
							}
						}
					});
					
					drizzlelots.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == drizzlelots)
							{
								
							}
						}
					});
					drizzlelots.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == drizzlelots)
							{
								
							}
						}
					});
					
					panel9.setBackground(Color.white); //패널 배경색
					panel9.setLayout(new FlowLayout(FlowLayout.CENTER,10,15)); //패널 레이아웃
					panel9.add(button9_1); //옵션 초기화버튼
					panel9.add(button9_2); //확인버튼
					
					// 옵션 초기화
					button9_1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button9_1)
							{
								count2 = 2;
								clabel2.setText(Integer.toString(count2)); // 샷 초기화
								count3 = 2;
								clabel3.setText(Integer.toString(count3)); //시럽 초기화
								count6 = 2;
								clabel6.setText(Integer.toString(count6)); // 자바칩 초기화
								
								milkregular.setSelected(true); // 일반우유로 초기화
								iceregular.setSelected(true); //얼음 보통으로 초기화
								whipregular.setSelected(true); // 휘핑 보통으로 초기화
								drizzleregular.setSelected(true); // 드리즐 선택해제
							}
						}
					});
					
					button9_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button9_2)
							{
//								dispose(); //프레임만 종료
								d.setVisible(false); // 저장하고 창을 안보이게 함
							}
						}
					});
		
					
					d.add(panel);
					d.add(panel2);
					d.add(panel3);
					d.add(panel4);
					d.add(panel5);
					d.add(panel6);
					d.add(panel7);
					d.add(panel8);
					d.add(panel9);
			
					
					d.setSize(500, 700);
					d.setLocationRelativeTo(null);
					d.setResizable(false);
					d.setVisible(true);
					
					
				}
			}
		});
	}
	
	public FrappuccinoCustom()
	{
		super("Personal Option");
		
		this.setLayout(new FlowLayout());
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.comInit();
		this.setVisible(true);
	}

}
