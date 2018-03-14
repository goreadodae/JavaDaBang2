package dabang.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dabang.client.controller.MemberController;
import dabang.client.model.Member;
public class Application extends JFrame implements ActionListener {
	MemberController mCon = new MemberController();
	Member m = new Member();
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();
	private JPanel panel9 = new JPanel();
	private JLabel label1 = new JLabel("�̸�");
	private JLabel label2 = new JLabel("ID");
	private JLabel label3 = new JLabel("PW");
	private JLabel label4 = new JLabel("�������");//�޺��ڽ�
	private JLabel label5 = new JLabel("P.H");
	private JLabel label6 = new JLabel("����");
	private JLabel label7 = new JLabel("�ڡڡڡڡ�ȸ�������� �սô� ^��^�ڡڡڡڡ�");
	private JLabel mainLabel = new JLabel();
	private JTextField nameField = new JTextField(5);//�̸�
	private JTextField idField = new JTextField(10);//���̵�
	private JPasswordField pwdField = new JPasswordField(10);//���
	private JTextField phoneField = new JTextField(13);//����
	private JTextField nickNameField = new JTextField(7);//�г���
	private JButton button1 = new JButton("ID �ߺ�Ȯ��");
	private JButton button4 = new JButton("�г��� �ߺ�Ȯ��");
	private JButton button5 = new JButton("ȸ������");
	private JButton button6 = new JButton("�������");
	private ImageIcon muzi = null;
	private JComboBox combox1 = new JComboBox();  //����year
	private JComboBox combox2 = new JComboBox(); //��monthly
	private JComboBox combox3 = new JComboBox(); //��day
	private String year    [] = new String[98];  //����
	private String monthly [] = new String[12];  //��
	private String day     [] = new String[31];  //��
	private JRadioButton solar = new JRadioButton("���",false);
	private JRadioButton lunar = new JRadioButton("����",false);

	private String id;        //���̵�
	private String passWord;  //��й�ȣ
	private String nickName;  //���� 
	private String name;      //�̸�
	private int sclc;//0���, 1����
	private int ageY;
	private int ageM;
	private int ageD;
	private char gender;
	private String phoneNumber;  //����
	private String grade;     //ȸ�����
	private double point;     //����Ʈ


	public Application() 
	{
		super("ȸ������"); //�̸�����
		//this.setTitle("�̸�") �̶� ����
		this.setSize(400,600); //������ ������
		this.setLocationRelativeTo(null); //ȭ�� ����� ��ġ����
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE); //�����ư�� �ƿ��ٲ�����
		this.setResizable(false);
		this.setLayout(new GridLayout(9,0));
		this.compInit(); //����� ���� �޼ҵ�

		this.setVisible(true); //���������� �����־��
	}
	private void NameAge()//�̸�
	{

		panel1.setBackground(Color.yellow);
		panel1.add(label1);//�̸�
		panel1.add(nameField);//ĭ

		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel1);
	}
	private void birthday()//�������
	{
		panel9.setBackground(Color.yellow);//���
		panel9.add(label4);//������� ����
		////////////////////////////////////////////////////////      
		for(int i=0;i<year.length;i++) {
			year[i] = Integer.toString(1920+i);
		}  //����   
		combox1 = new JComboBox(year);//���� �޹�
		panel9.add(combox1);//�߰�
		/////////////////////////////////////////////////////////      

		for(int i=0;i<monthly.length;i++) {
			monthly[i] = Integer.toString(1+i);
		}  //����   
		combox2 = new JComboBox(monthly);
		panel9.add(combox2);//��

		//////////////////////////////////////////////////////////
		for(int i=0;i<day.length;i++) {
			day[i] = Integer.toString(1+i);
		}  //����   
		combox3 = new JComboBox(day);
		panel9.add(combox3);//��
		///////////////////////////////////////////////////////////      
		ButtonGroup bg = new ButtonGroup();
		bg.add(solar);
		bg.add(lunar);
		panel9.add(solar);
		panel9.add(lunar);
		panel9.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel9);
		
		combox1.addActionListener(this);
		combox2.addActionListener(this);
		combox3.addActionListener(this);
		solar.addActionListener(this);
		lunar.addActionListener(this);
	}
	private void idgo()//���̵�
	{
		panel2.setBackground(Color.yellow);
		panel2.add(label2);//���̵�
		panel2.add(idField);//ĭ
		panel2.add(button1);//�ߺ�
		
		button1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==button1)
				{
					if(mCon.memberCheck(id)) {
						JOptionPane.showMessageDialog(null,"�ߺ��� ID�Դϴ�. �ٽ� �Է����ּ���");
					}
					else {
						JOptionPane.showMessageDialog(null,"�ش�ID�� ���԰����մϴ�");
					}
					
				}}});   
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel2);
	}
	
	private void passwordgo()//���
	{
		panel3.setBackground(Color.yellow);
		panel3.add(label3);//���
		panel3.add(pwdField);//���ĭ
		pwdField.setText("");
		passWord = pwdField.getText();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel3);
	}
	private void phonenumbergo()//����
	{
		panel5.setBackground(Color.YELLOW);//�������
		panel5.add(label5);//����
		panel5.add(phoneField);//����ĭ
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));//�������Λy������
		this.add(panel5);//�г��߰�
	}
	private void nicknamego()//�г���
	{
		panel6.setBackground(Color.yellow);
		panel6.add(label6);//�г���
		panel6.add(nickNameField);//�г���ĭ
		panel6.add(button4);//�ߺ�Ȯ��ĭ
		button4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==button4)
				{
					JOptionPane.showMessageDialog(null,"�ش� �г����� ���԰����մϴ�");
				}}});   
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel6);
	}
	private void setImage()
	{

		muzi = new ImageIcon(new ImageIcon("400x122.jpg").getImage().getScaledInstance(400,55,Image.SCALE_DEFAULT));
	}

	private void yesno()
	{
		panel4.setBackground(Color.yellow);
		panel4.add(button5); 
		button5.addActionListener(this); 
		panel4.add(button6);
		button6.addActionListener(this);
		this.add(panel4);

	}

	private void compInit()
	{  
		setImage();
		say();
		NameAge();
		birthday();
		idgo();
		passwordgo();
		nicknamego();
		phonenumbergo();
		imagego();
		yesno();

	}

	private void say()
	{
		panel7.setBackground(Color.yellow);
		panel7.add(label7);
		this.add(panel7);
	}
	private void imagego()
	{
		panel8.setBackground(Color.yellow);
		panel8.setPreferredSize(new Dimension(1,1));
		mainLabel.setIcon(muzi);
		panel8.add(mainLabel);
		this.add(panel8);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button6)
		{
			this.dispose();
		}
		else if(e.getSource()==combox1) {
			ageY = Integer.valueOf((String)combox1.getSelectedItem());
		}
		else if(e.getSource()==combox2) {
			ageM = Integer.valueOf((String)combox2.getSelectedItem());
		}
		else if(e.getSource()==combox3) {
			ageD = Integer.valueOf((String)combox3.getSelectedItem());
		}
		else if(e.getSource()==solar) {
			sclc = 1;
		}
		else if(e.getSource()==lunar) {
			sclc = 2;
		}else if(e.getSource()==button5) {
			System.out.println(idField.getText());
			System.out.println(pwdField.getText());
			System.out.println(nickNameField.getText());
			System.out.println(nameField.getText());
			System.out.println(sclc);
			System.out.println(ageY);
			System.out.println(ageM);
			System.out.println(ageD);
			System.out.println(gender);
			System.out.println(phoneField.getText());
			m = new Member(idField.getText(),pwdField.getText(),nickNameField.getText(),nameField.getText(),
					sclc,ageY,ageM,ageD,gender,phoneField.getText(),"Welcome",0.0);
			if(mCon.memberJoin(m)) {
				JOptionPane.showMessageDialog(null,"���Կ� �����Ͽ����ϴ�.");
			}else {
				JOptionPane.showMessageDialog(null,"���Կ� �����Ͽ����ϴ�.");
			}
			this.dispose();
		}
	}
}

