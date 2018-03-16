package dabang.client.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TeaCustom extends JFrame{
	
	private JButton button = new JButton("다이얼");
	private JButton button1 = new JButton("<-");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Personal Option");
	
	private JPanel panel2 =new JPanel();
	private JLabel label2 = new JLabel("에스프레소 샷");
	private JButton button2p = new JButton("+");
	private JButton button2m = new JButton("-");
	private JLabel clabel2 = null;
	private int count2 = 0;
	
	private JPanel panel3 =new JPanel();
	private JLabel label3 = new JLabel("시럽");
	private JButton button3p = new JButton("+");
	private JButton button3m = new JButton("-");
	private JLabel clabel3 = null;
	private int count3 = 0;
	
	private JPanel panel4 =new JPanel();
	private JLabel label4 = new JLabel("우유");
	private JRadioButton milkregular = new JRadioButton("일반우유", true);
	private JRadioButton milklow = new JRadioButton("저지방우유", false);
	private JRadioButton milkno = new JRadioButton("무지방 우유", false);
	
	private JPanel panel5 =new JPanel();
	private JLabel label5 = new JLabel("베이스");
	private JRadioButton basefew = new JRadioButton("적게", false);
	private JRadioButton baseregular = new JRadioButton("보통", true);
	private JRadioButton baselots = new JRadioButton("많이", false);
	
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


	
	
	Dialog d = new Dialog(this, "다이얼로그");
	public void comInit()
	{
		this.add(button);
		
		clabel2 = new JLabel(Integer.toString(count2)); // 에스프레소
		clabel2.setFont(new Font("Serif", Font.BOLD,20));
		
		clabel3 = new JLabel(Integer.toString(count3)); //시럽
		clabel3.setFont(new Font("Serif", Font.BOLD,20));
		
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					d.setLayout(new GridLayout(8,1,10,10));
					
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
								System.exit(0); //종료
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
										if(0 < count2) {
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
					
					//우유
					panel4.setBackground(Color.white); //4패널 배경색
					panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //4패널 레이아웃
					label4.setFont(new Font("Serif", Font.ITALIC,20)); //4패널 폰트, 크기
					panel4.add(label4); //우유
					
					ButtonGroup milkbg = new ButtonGroup(); // 물 라디오버튼 그룹
					milkbg.add(milkregular);
					milkbg.add(milklow);
					milkbg.add(milkno);
					
					milkregular.setBackground(Color.white); //백그라운드 색과 동일하게 설정
					milklow.setBackground(Color.white);
					milkno.setBackground(Color.white);
				
					panel4.add(milkregular);
					panel4.add(milklow);
					panel4.add(milkno);
					
					milkbg.getSelection();
					
					
					//베이스
					panel5.setBackground(Color.LIGHT_GRAY); // 5패널 배경색
					panel5.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 5패널 레이아웃
					label5.setFont(new Font("Serif", Font.ITALIC,20)); // 5패널 폰트, 크기
					panel5.add(label5); //얼음
					
					basefew.setBackground(Color.LIGHT_GRAY); // 배경색과 동일하게 설정
					baseregular.setBackground(Color.LIGHT_GRAY);
					baselots.setBackground(Color.LIGHT_GRAY);
					
					ButtonGroup basebg = new ButtonGroup();
					basebg.add(basefew);
					basebg.add(baseregular);
					basebg.add(baselots);
					
					panel5.add(basefew);
					panel5.add(baseregular);
					panel5.add(baselots);

					basebg.getSelection();
					
					
					
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
					
					whipbg.getSelection();
					
					
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
					
					
					drizzlebg.getSelection();
					
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
								count2 = 0;
								clabel2.setText(Integer.toString(count2)); // 샷 초기화
								count3 = 0;
								clabel3.setText(Integer.toString(count3)); //시럽 초기화
								milkregular.setSelected(true); //일반우유로 초기화
								baseregular.setSelected(true);
								whipbg.clearSelection(); // 휘핑 선택해제
								drizzlebg.clearSelection(); // 드리즐 선택해제
							}
						}
					});
					
					button8_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button8_2)
							{
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
					
					
					
					d.setSize(500, 700);
					d.setLocationRelativeTo(null);
					d.setResizable(false);
					d.setVisible(true);
					
					
				}
			}
		});
	}
	
	public TeaCustom()
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
