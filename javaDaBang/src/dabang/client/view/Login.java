package dabang.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dabang.client.controller.LoginController;
import dabang.client.model.Member;
public  class Login extends JFrame implements ActionListener{
	private JPanel panel1 = new JPanel();//���̵�
	private JPanel panel2 = new JPanel();//��й�ȣ
	private JPanel panel3 = new JPanel();//������ 
	private JPanel panel4 = new JPanel();//��ư
	private JPanel panel5 = new JPanel();//��������(��)
	private JPanel panel6 = new JPanel();//��������(�Ʒ�)

	private JLabel label1 = new JLabel("ID");
	private JLabel label2 = new JLabel("PW");
	private JLabel label3 = new JLabel();//����
	private JLabel label4 = new JLabel();
	private JLabel label5 = new JLabel();
	private JTextField field1 = new JTextField(10);//���̵�
	private JPasswordField field2 = new JPasswordField(10);//��й�ȣ
	private JButton button1 = new JButton("�α���");
	private JButton button2 = new JButton("��ȸ�� �ֹ�");
	private JButton button3 = new JButton("ȸ������");
	private ImageIcon picup = null;
	private ImageIcon picdown = null;
	private ImageIcon mainpic = null;

	private ImageIcon gaep  = null;
	private ImageIcon login = null;

	LoginController lCon = new LoginController();

	public Login() 
	{
		super("��ٹ�"); //�̸�����
		//this.setTitle("�̸�") �̶� ����
		this.setSize(1000,800); //������ ������
		this.setLocationRelativeTo(null); //ȭ�� ����� ��ġ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //�����ư�� �ƿ��ٲ�����
		this.setResizable(false);
		this.setLayout(new GridLayout(6,1));
		this.compInit(); //����� ���� �޼ҵ�

		this.setVisible(true); //���������� �����־��
	}
	private void idgo()//���̵�
	{
		panel1.setBackground(Color.WHITE);
		panel1.add(label1);//���̵�
		panel1.add(field1);//ĭ
		this.add(panel1);
	}
	private void passwordgo()//���
	{
		panel2.setBackground(Color.WHITE);
		panel2.add(label2);//���
		panel2.add(field2);//���ĭ
		this.add(panel2);
	}



	private void compInit() {
		picme();
		saygo();
		idgo();
		passwordgo();
		loginchang();
		pic1();
		pic2();


	}


	private void saygo() {
		panel3.setBackground(Color.WHITE);
		panel3.setPreferredSize(new Dimension(1,1));
		label3.setIcon(mainpic);
		panel3.add(label3);

		this.add(panel3);
	}
	private void loginchang()
	{
		panel4.setBackground(Color.WHITE);
		button1.setIcon(login);
		button1.setBackground(Color.WHITE);
		panel4.add(button1);
		panel4.add(button2);
		button3.setBackground(Color.WHITE);
		button3.setIcon(gaep);
		panel4.add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		


		this.add(panel4);
	}
	private void pic1()
	{
		panel5.setBackground(Color.YELLOW);
		panel5.setPreferredSize(new Dimension(1,1));
		label4.setIcon(picup);
		panel5.add(label4);

		this.add(panel5);

	}
	private void pic2()
	{
		panel6.setBackground(Color.LIGHT_GRAY);
		panel6.setPreferredSize(new Dimension(1,1));
		label5.setIcon(picdown);
		panel6.add(label5);


		this.add(panel6);
	}
	private void picme()
	{
		mainpic = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(100,90,Image.SCALE_DEFAULT));
		picup = new ImageIcon(new ImageIcon("1-1.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
		picdown = new ImageIcon(new ImageIcon("1-2.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
		gaep = new ImageIcon(new ImageIcon("gaep.jpg").getImage().getScaledInstance(150,30,Image.SCALE_DEFAULT));
		login = new ImageIcon(new ImageIcon("login.jpg").getImage().getScaledInstance(150,30,Image.SCALE_DEFAULT));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button3)
		{
			new Application();
		}
		else if(e.getSource()==button1) {
			if(field1.getText().length()==0) JOptionPane.showMessageDialog(null,"ID�� �Է��Ͽ��ּ���");
			else {
				if(lCon.checkId(field1.getText())) {
					if(lCon.checkPwd(field1.getText(), field2.getText())) {
						JOptionPane.showMessageDialog(null,"�α��� ����");
					}
					else JOptionPane.showMessageDialog(null,"��й�ȣ�� Ȯ���ϼ���");
				}
				else JOptionPane.showMessageDialog(null,"ID�� Ȯ���ϼ���");
			}
		}


	}
}