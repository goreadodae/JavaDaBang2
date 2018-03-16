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
	
	private JButton button = new JButton("���̾�");
	private JButton button1 = new JButton("<-");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Personal Option");
	
	private JPanel panel2 =new JPanel();
	private JLabel label2 = new JLabel("���������� ��");
	private JButton button2p = new JButton("+");
	private JButton button2m = new JButton("-");
	private JLabel clabel2 = null;
	private int count2 = 0;
	
	private JPanel panel3 =new JPanel();
	private JLabel label3 = new JLabel("�÷�");
	private JButton button3p = new JButton("+");
	private JButton button3m = new JButton("-");
	private JLabel clabel3 = null;
	private int count3 = 0;
	
	private JPanel panel4 =new JPanel();
	private JLabel label4 = new JLabel("����");
	private JRadioButton milkregular = new JRadioButton("�Ϲݿ���", true);
	private JRadioButton milklow = new JRadioButton("���������", false);
	private JRadioButton milkno = new JRadioButton("������ ����", false);
	
	private JPanel panel5 =new JPanel();
	private JLabel label5 = new JLabel("���̽�");
	private JRadioButton basefew = new JRadioButton("����", false);
	private JRadioButton baseregular = new JRadioButton("����", true);
	private JRadioButton baselots = new JRadioButton("����", false);
	
	private JPanel panel6 =new JPanel();
	private JLabel label6 = new JLabel("����");
	private JRadioButton whipfew = new JRadioButton("����", false);
	private JRadioButton whipregular = new JRadioButton("����", false);
	private JRadioButton whiplots = new JRadioButton("����", false);
	
	private JPanel panel7 =new JPanel();
	private JLabel label7 = new JLabel("�帮��");
	private JRadioButton drizzlefew = new JRadioButton("����", false);
	private JRadioButton drizzleregular = new JRadioButton("����", false);
	private JRadioButton drizzlelots = new JRadioButton("����", false);
	
	private JPanel panel8 = new JPanel();
	private JButton button8_1 = new JButton("�ɼ� �ʱ�ȭ �ϱ�");
	private JButton button8_2 = new JButton("Ȯ��");


	
	
	Dialog d = new Dialog(this, "���̾�α�");
	public void comInit()
	{
		this.add(button);
		
		clabel2 = new JLabel(Integer.toString(count2)); // ����������
		clabel2.setFont(new Font("Serif", Font.BOLD,20));
		
		clabel3 = new JLabel(Integer.toString(count3)); //�÷�
		clabel3.setFont(new Font("Serif", Font.BOLD,20));
		
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					d.setLayout(new GridLayout(8,1,10,10));
					
					// �۽��� �ɼ�
					panel.setBackground(Color.black); // �г� ��׶��� ��
					panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20)); //�г� ���̾ƿ�
					label.setFont(new Font("Serif", Font.ITALIC,20)); //�г� ��Ʈ, ũ��
					label.setForeground(Color.WHITE); //�۽��οɼ� ��
					panel.add(button1); //�ڷΰ��� ��ư
					
					button1.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button1)
							{
								System.exit(0); //����
							}
						}
					});
					panel.add(label);
					
					//���������� ��
					panel2.setBackground(Color.white); // 2�г� ����
					panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //2�г� ���̾ƿ�
					label2.setFont(new Font("Serif", Font.ITALIC,20)); //2�г� ��Ʈ, ũ��
					panel2.add(label2); //���������� ��
					
					// +,- ��ư�׼�
					panel2.add(button2m); // -��ư
					button2m.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									if(e.getSource() == button2m)
									{
										if(0 < count2) {
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
					panel3.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //3�г� ���̾ƿ�
					label3.setFont(new Font("Serif", Font.ITALIC,20)); //3�г� ��Ʈ, ũ��
					panel3.add(label3); //�÷�
					
					// +,- ��ư�׼�
					panel3.add(button3m); // -��ư
					button3m.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									if(e.getSource() == button3m)
									{
										if(count3 >= 1) {
											count3--; // -ī����
											clabel3.setText(Integer.toString(count3));
										}
									}
								}
							});
					panel3.add(clabel3); // ī��Ʈ ��
					panel3.add(button3p);
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
					panel4.setBackground(Color.white); //4�г� ����
					panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); //4�г� ���̾ƿ�
					label4.setFont(new Font("Serif", Font.ITALIC,20)); //4�г� ��Ʈ, ũ��
					panel4.add(label4); //����
					
					ButtonGroup milkbg = new ButtonGroup(); // �� ������ư �׷�
					milkbg.add(milkregular);
					milkbg.add(milklow);
					milkbg.add(milkno);
					
					milkregular.setBackground(Color.white); //��׶��� ���� �����ϰ� ����
					milklow.setBackground(Color.white);
					milkno.setBackground(Color.white);
				
					panel4.add(milkregular);
					panel4.add(milklow);
					panel4.add(milkno);
					
					milkbg.getSelection();
					
					
					//���̽�
					panel5.setBackground(Color.LIGHT_GRAY); // 5�г� ����
					panel5.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 5�г� ���̾ƿ�
					label5.setFont(new Font("Serif", Font.ITALIC,20)); // 5�г� ��Ʈ, ũ��
					panel5.add(label5); //����
					
					basefew.setBackground(Color.LIGHT_GRAY); // ������ �����ϰ� ����
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
					
					
					
					//����
					panel6.setBackground(Color.white); // 6�г� ����
					panel6.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 6�г� ���̾ƿ�
					label6.setFont(new Font("Serif", Font.ITALIC,20)); // 6�г� ��Ʈ, ũ��
					panel6.add(label6);
					
					ButtonGroup whipbg = new ButtonGroup(); //���� ������ư �׷�
					whipbg.add(whipfew);
					whipbg.add(whipregular);
					whipbg.add(whiplots);
					
					whipfew.setBackground(Color.white); // ������ �����ϰ� ����
					whipregular.setBackground(Color.white);
					whiplots.setBackground(Color.white);
					
					panel6.add(whipfew);
					panel6.add(whipregular);
					panel6.add(whiplots);
					
					whipbg.getSelection();
					
					
					//�帮��
					panel7.setBackground(Color.LIGHT_GRAY); // 7�г� ����
					panel7.setLayout(new FlowLayout(FlowLayout.LEFT,10,15)); // 7�г� ���̾ƿ�
					label7.setFont(new Font("Serif", Font.ITALIC,20)); // 7�г� ��Ʈ, ũ��
					panel7.add(label7);
					
					ButtonGroup drizzlebg = new ButtonGroup(); // ������ư �׷�ȭ
					drizzlebg.add(drizzlefew);
					drizzlebg.add(drizzleregular);
					drizzlebg.add(drizzlelots);
					
					drizzlefew.setBackground(Color.LIGHT_GRAY); //��׶��� ���� �����ϰ� ����
					drizzleregular.setBackground(Color.LIGHT_GRAY);
					drizzlelots.setBackground(Color.LIGHT_GRAY);
					
					panel7.add(drizzlefew);
					panel7.add(drizzleregular);
					panel7.add(drizzlelots);
					
					
					drizzlebg.getSelection();
					
					panel8.setBackground(Color.white); //�г� ����
					panel8.setLayout(new FlowLayout(FlowLayout.CENTER,10,15)); //�г� ���̾ƿ�
					panel8.add(button8_1); //�ɼ� �ʱ�ȭ ��ư
					panel8.add(button8_2); //Ȯ�� ��ư
					
					// �ɼ� �ʱ�ȭ
					button8_1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button8_1)
							{
								count2 = 0;
								clabel2.setText(Integer.toString(count2)); // �� �ʱ�ȭ
								count3 = 0;
								clabel3.setText(Integer.toString(count3)); //�÷� �ʱ�ȭ
								milkregular.setSelected(true); //�Ϲݿ����� �ʱ�ȭ
								baseregular.setSelected(true);
								whipbg.clearSelection(); // ���� ��������
								drizzlebg.clearSelection(); // �帮�� ��������
							}
						}
					});
					
					button8_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == button8_2)
							{
								d.setVisible(false); // �����ϰ� â�� �Ⱥ��̰� ��
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
