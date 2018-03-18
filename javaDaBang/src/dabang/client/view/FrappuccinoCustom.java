package dabang.client.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
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

import dabang.client.model.Frappuccino;

public class FrappuccinoCustom extends JDialog{
	
	private JButton button = new JButton("���̾�");
	private JButton button1 = new JButton("<-");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Personal Option");
	
	private JPanel panel2 =new JPanel();
	private JLabel label2 = new JLabel("����Ǫġ�� �ν�Ʈ");
	private JButton button2p = new JButton("+");
	private JButton button2m = new JButton("-");
	private JLabel clabel2 = null;
	private int count2 = 2;
	
	private JPanel panel3 =new JPanel();
	private JLabel label3 = new JLabel("�÷�");
	private JButton button3p = new JButton("+");
	private JButton button3m = new JButton("-");
	private JLabel clabel3 = null;
	private int count3 = 2;
	
	private JPanel panel4 =new JPanel();
	private JLabel label4 = new JLabel("����");
	private JRadioButton milkregular = new JRadioButton("�Ϲݿ���", true);
	private JRadioButton milklow = new JRadioButton("���������", false);
	private JRadioButton milkno = new JRadioButton("������ ����", false);
	private JRadioButton milkdu = new JRadioButton("����", false);
	
	private JPanel panel5 =new JPanel();
	private JLabel label5 = new JLabel("����");
	private JRadioButton icefew = new JRadioButton("����", false);
	private JRadioButton iceregular = new JRadioButton("����", true);
	private JRadioButton icelots = new JRadioButton("����", false);
	
	private JPanel panel6 =new JPanel();
	private JLabel label6 = new JLabel("�ڹ�Ĩ");
	private JButton button6p = new JButton("+");
	private JButton button6m = new JButton("-");
	private JLabel clabel6 = null;
	private int count6 = 2;
	
	private JPanel panel7 =new JPanel();
	private JLabel label7 = new JLabel("����");
	private JRadioButton whipno = new JRadioButton("����",false);
	private JRadioButton whipfew = new JRadioButton("����",false);
	private JRadioButton whipregular = new JRadioButton("����",true);
	private JRadioButton whiplots = new JRadioButton("����",false);
	
	
	private JPanel panel8 = new JPanel();
	private JLabel label8 = new JLabel("�帮��");
	private JRadioButton drizzleno = new JRadioButton("����", false);
	private JRadioButton drizzlefew = new JRadioButton("����", false);
	private JRadioButton drizzleregular = new JRadioButton("����", true);
	private JRadioButton drizzlelots = new JRadioButton("����", false);
	
	private JPanel panel9 = new JPanel();
	private JButton button9_1 = new JButton("�ɼ� �ʱ�ȭ �ϱ�");
	private JButton button9_2 = new JButton("Ȯ��");
	private Frappuccino fra = new Frappuccino();


	
	

	public void comInit()
	{

		
		clabel2 = new JLabel(Integer.toString(count2)); // ���������� ī��Ʈ
		clabel2.setFont(new Font("Serif", Font.BOLD,20));
		
		clabel3 = new JLabel(Integer.toString(count2)); //�÷� ī��Ʈ
		clabel3.setFont(new Font("Serif", Font.BOLD,20));
		
		clabel6 = new JLabel(Integer.toString(count2)); //�ڹ�Ĩ ī��Ʈ
		clabel6.setFont(new Font("Serif", Font.BOLD,20));
		
					
					// �۽��� �ɼ�
					panel.setBackground(Color.black); // 1�г� ����
					panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20)); // 1�г� ���̾ƿ�
					label.setFont(new Font("Serif", Font.ITALIC,20)); // 1�г� ��Ʈ, ũ��
					label.setForeground(Color.WHITE);
					
					panel.add(button1); //�ڷ� ���� ��ư
					
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
					
					// ����Ǫġ�� �ν�Ʈ
					panel2.setBackground(Color.white); // 2�г� ����
					panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 2�г� ���̾ƿ�
					label2.setFont(new Font("Serif", Font.ITALIC,20)); // 2�г� ��Ʈ, ũ��
					panel2.add(label2); //����Ǫġ�� �ν�Ʈ
					
					// +,- ��ư�׼�
					panel2.add(button2m); // -��ư
					button2m.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									if(e.getSource() == button2m)
									{
										if(count2 >= 2) {
											count2--; // -ī����
											clabel2.setText(Integer.toString(count2));
										}
									}
								}
							});
					panel2.add(clabel2); // ī��Ʈ ��
					panel2.add(button2p); // +��ư
					button2p.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button2p)
							{
								if(0 <= count2 && count2 <= 8) {
									count2++; // +ī����
							 		clabel2.setText(Integer.toString(count2));
								}		
							}
						}
					});
				
					
					//�÷�
					panel3.setBackground(Color.LIGHT_GRAY); // 3�г� ����
					panel3.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 3�г� ���̾ƿ�
					label3.setFont(new Font("Serif", Font.ITALIC,20)); // 3�г� ��Ʈ, ũ��
					panel3.add(label3); //�÷�
					
					// +,- ��ư�׼�
					panel3.add(button3m); // -��ư
					button3m.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									if(e.getSource() == button3m)
									{
										if(count3 >= 2) {
											count3--; // -ī����
											clabel3.setText(Integer.toString(count3));
										}
									}
								}
							});
					panel3.add(clabel3); // ī��Ʈ ��
					panel3.add(button3p); // +��ư
					button3p.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button3p)
							{
								if(0 <= count3 && count3 <= 8) {
									count3++; // +ī����
							 		clabel3.setText(Integer.toString(count3));
								}	
							}
						}
					});
					
					//����
					panel4.setBackground(Color.white); //�г� ����
					panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //�г� ���̾ƿ�
					label4.setFont(new Font("Serif", Font.ITALIC,20)); //�г� ��Ʈ, ũ��
					panel4.add(label4); //����
					
					ButtonGroup milkbg = new ButtonGroup(); //���� ��ư �׷�
					milkbg.add(milkregular);
					milkbg.add(milklow);
					milkbg.add(milkno);
					milkbg.add(milkdu);
					
					milkregular.setBackground(Color.WHITE); //������ ����
					milklow.setBackground(Color.WHITE);
					milkno.setBackground(Color.WHITE);
					
					panel4.add(milkregular);
					panel4.add(milklow);
					panel4.add(milkno);
					panel4.add(milkdu);
								
					
					//����
					panel5.setBackground(Color.LIGHT_GRAY); // 5�г� ����
					panel5.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 5�г� ���̾ƿ�
					label5.setFont(new Font("Serif", Font.ITALIC,20)); // 5�г� ��Ʈ, ũ��
					panel5.add(label5); //����
					
					ButtonGroup icebg = new ButtonGroup(); //������ư �׷�ȭ
					icebg.add(icefew);
					icebg.add(iceregular);
					icebg.add(icelots);
					
					icefew.setBackground(Color.LIGHT_GRAY); //������ �����ϰ� ����
					iceregular.setBackground(Color.LIGHT_GRAY);
					icelots.setBackground(Color.LIGHT_GRAY);
					
					panel5.add(icefew);
					panel5.add(iceregular);
					panel5.add(icelots);

					
					
					
					//�ڹ�Ĩ
					panel6.setBackground(Color.white); // 6�г� ����
					panel6.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 6�г� ���̾ƿ�
					label6.setFont(new Font("Serif", Font.ITALIC,20)); // 6�г� ��Ʈ, ũ��
					panel6.add(label6); // �ڹ�Ĩ
					
					// +,- ��ư�׼�
					panel6.add(button6m); // -��ư
					button6m.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									if(e.getSource() == button6m)
									{
										if(count6 >= 2) {
											count6--; // -ī����
											clabel6.setText(Integer.toString(count6));
										}
									}
								}
							});
					panel6.add(clabel6); // ī��Ʈ ��
					panel6.add(button6p); // +��ư
					button6p.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button6p)
							{
								if(0 <= count6 && count6 <= 8) {
									count6++; // +ī����
							 		clabel6.setText(Integer.toString(count6));
								}	
							}
						}
					});
					
					
					
					//����
					panel7.setBackground(Color.LIGHT_GRAY); // 7�г� ����
					panel7.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 7�г� ���̾ƿ�
					label7.setFont(new Font("Serif", Font.ITALIC,20)); // 7�г� ��Ʈ, ũ��
					panel7.add(label7); //����
					
					ButtonGroup whipbg = new ButtonGroup(); //������ư �׷�ȭ
					whipbg.add(whipno);
					whipbg.add(whipfew);
					whipbg.add(whipregular);
					whipbg.add(whiplots);
					
					whipno.setBackground(Color.LIGHT_GRAY); // ������ �����ϰ� ����
					whipfew.setBackground(Color.LIGHT_GRAY);
					whipregular.setBackground(Color.LIGHT_GRAY);
					whiplots.setBackground(Color.LIGHT_GRAY);
					
					panel7.add(whipno);
					panel7.add(whipfew);
					panel7.add(whipregular);
					panel7.add(whiplots);
					
										
					
					//�帮��
					panel8.setBackground(Color.white); // 8�г� ����
					panel8.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 8�г� ���̾ƿ�
					label8.setFont(new Font("Serif", Font.ITALIC,20)); // 8�г� ��Ʈ, ũ��
					panel8.add(label8); //�帮��
					ButtonGroup drizzlebg = new ButtonGroup(); //������ư �׷�ȭ
					drizzlebg.add(drizzleno);
					drizzlebg.add(drizzlefew);
					drizzlebg.add(drizzleregular);
					drizzlebg.add(drizzlelots);
					
					drizzleno.setBackground(Color.white); //������ �����ϰ� ����
					drizzlefew.setBackground(Color.white);
					drizzleregular.setBackground(Color.white);
					drizzlelots.setBackground(Color.white);
					
					panel8.add(drizzleno);
					panel8.add(drizzlefew);
					panel8.add(drizzleregular);
					panel8.add(drizzlelots);
					
					
					
					panel9.setBackground(Color.white); //�г� ����
					panel9.setLayout(new FlowLayout(FlowLayout.CENTER,10,15)); //�г� ���̾ƿ�
					panel9.add(button9_1); //�ɼ� �ʱ�ȭ��ư
					panel9.add(button9_2); //Ȯ�ι�ư
					
					// �ɼ� �ʱ�ȭ
					button9_1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button9_1)
							{
								count2 = 2;
								clabel2.setText(Integer.toString(count2)); // �� �ʱ�ȭ
								count3 = 2;
								clabel3.setText(Integer.toString(count3)); //�÷� �ʱ�ȭ
								count6 = 2;
								clabel6.setText(Integer.toString(count6)); // �ڹ�Ĩ �ʱ�ȭ
								
								milkregular.setSelected(true); // �Ϲݿ����� �ʱ�ȭ
								iceregular.setSelected(true); //���� �������� �ʱ�ȭ
								whipregular.setSelected(true); // ���� �������� �ʱ�ȭ
								drizzleregular.setSelected(true); // �帮�� ��������
							}
						}
					});
					
					button9_2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button9_2)
							{//����, ����, ����, �帮��
								String milk = null; 
								int ice = 0, whip = 0, drizzle = 0;
								for(Enumeration<AbstractButton> milkbs = milkbg.getElements(); milkbs.hasMoreElements();) {
									AbstractButton milkb = milkbs.nextElement();
									if(milkb.isSelected()) {
										switch(milkb.getText()) {
										case "�Ϲݿ���" : milk = "�Ϲݿ���"; break;
										case "���������" : milk = "���������"; break;
										case "���������" : milk = "���������"; break;
										case "����" : milk = "����"; break;
										
										}
									}
								}
								for(Enumeration<AbstractButton>icebs = icebg.getElements(); icebs.hasMoreElements();) {
									AbstractButton iceb = icebs.nextElement();
									if(iceb.isSelected()) {
										switch(iceb.getText()) {
										case "����" : ice = 1; break;
										case "����" : ice = 2; break;
										case "����" : ice = 3; break;
										default : ice = 0;
										}
									}
								}
								for(Enumeration<AbstractButton>whipbs = whipbg.getElements(); whipbs.hasMoreElements();) {
									AbstractButton whipb = whipbs.nextElement();
									if(whipb.isSelected()) {
										switch(whipb.getText()) {
										case "����" : whip = 0; break;
										case "����" : whip = 1; break;
										case "����" : whip = 2; break;
										case "����" : whip = 3; break;
										}
									}
								}
								for(Enumeration<AbstractButton>drizzlebs = drizzlebg.getElements(); drizzlebs.hasMoreElements();) {
									AbstractButton drizzleb = drizzlebs.nextElement();
									if(drizzleb.isSelected()) {
										switch(drizzleb.getText()) {
										case "����" : drizzle = 0; break;
										case "����" : drizzle = 1; break;
										case "����" : drizzle = 2; break;
										case "����" : drizzle = 3; break;
										}
									}
								}
								
								fra.setFrappuccinoRoast(count2);
								fra.setSyrupNum(count3);
								fra.setMilkType(milk);
								fra.setIceAmount(ice);
								fra.setJavaChipNum(count6);
								fra.setWhippingAmount(whip);
								fra.setDrizzleAmount(drizzle);
								
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
					this.add(panel9);		
					
				}
	
	public FrappuccinoCustom(JFrame frame, String title, boolean b, Frappuccino fra)
	{
		super(frame, title, b);
		this.setLayout(new GridLayout(9, 1, 10, 10));
		this.setSize(500,700);
		this.setLocation(950,  170);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);		
		this.fra  = fra;
		this.comInit();
		this.setVisible(true);
	}

	public FrappuccinoCustom() {}
}
