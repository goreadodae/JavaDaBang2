package dabang.client.view;
import java.awt.BorderLayout;  
import dabang.client.model.Member;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.LoginController;
import dabang.client.controller.MemberController;
import dabang.client.controller.MemberManegermentController;
public class MemberManagermentView extends JFrame implements ActionListener{
	private JPanel titlepanel = new JPanel();//����
	private JLabel label1 = new JLabel("ȸ������");//Ÿ��Ʋ�� �Ҹ�
	private JPanel buttonpanel = new JPanel();//��ư�����г�
	private JButton button1 = new JButton("����");
	private JButton deletebutton = new JButton("����");
	private JButton exitbutton = new JButton("������");
	private JScrollPane scr = new JScrollPane();
	private ImageIcon picup = null;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll; 
	public MemberManagermentView() //���� â 
	{
		super("ȸ������"); //�̸�����
		this.setSize(1000,500); //������ ������
		this.setLocationRelativeTo(null); //ȭ�� ����� ��ġ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //�����ư�� �ƿ��ٲ�����
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.compInit(); //����� ���� �޼ҵ�
		this.setVisible(true); //���������� �����־��
	}

	private void compInit() 
	{	
		picture();
		title();
		table();
		button();
	}
	private void picture()
	{
		picup = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
	}
	private void title()//Ÿ��Ʋ
	{
		label1.setIcon(picup);
		titlepanel.setBackground(Color.yellow);
		titlepanel.add(label1);
		titlepanel.setPreferredSize(new Dimension(1000,100));
		this.add(titlepanel);	
	}
	private void button()//�ؿ� ��ư
	{
		buttonpanel.setBackground(Color.white);
		button1.addActionListener(this);//�׼��߰�
		button1.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(button1);
		deletebutton.addActionListener(this);//�׼��߰�
		deletebutton.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(deletebutton);
		exitbutton.addActionListener(this);//�׼��߰�
		exitbutton.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(exitbutton);
		this.add(buttonpanel);
	}
	
	private void table()//ǥ
	{
		Object [][] data = new Object[10][11];
	    Member testMem [] = new Member[11];
	    testMem[0] = new Member();
	    testMem[1] = new Member();
	    testMem[2] = new Member();
	    testMem[3] = new Member();
	    testMem[4] = new Member();
	    testMem[5] = new Member();
	    testMem[6] = new Member();
	    testMem[7] = new Member();
	    testMem[8] = new Member();
	    testMem[9] = new Member();



	    data[0] = new Object[11];
	    data[1] = new Object[11];
	    data[2] = new Object[11];
	    data[3] = new Object[11];
	    data[4] = new Object[11];
	    data[5] = new Object[11];
	    data[6] = new Object[11];
	    data[7] = new Object[11];
	    data[8] = new Object[11];
	    data[9] = new Object[11];

	    

	   for(int i=0;i<data.length;i++) 
	    {
	    	data[i][0] =testMem[i].getId();
	    	data[i][1] =testMem[i].getNickName();
	    	data[i][2] =testMem[i].getName();
	    	data[i][3] =testMem[i].getSclc();
	    	data[i][4] =testMem[i].getAgeY();
	    	data[i][5] =testMem[i].getAgeD();
	    	data[i][6] =testMem[i].getAgeM();
	    	data[i][7] =testMem[i].getGender();
	    	data[i][8] =testMem[i].getPhoneNumber();
	    	data[i][9] =testMem[i].getGrade();
	    	data[i][10] =testMem[i].getPoint();  									
	    }
		String[] columnName = {"���̵�","����","�̸�","���","�⵵","��","��","����","PH","���","����Ʈ"};
		model = new DefaultTableModel(data, columnName) {
		public boolean isCellEditable(int rowlndex,int mCollnDex) {
		return false;}};//�����Ұ��ڵ�
	    table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);//�̵�����
		table.getTableHeader().setResizingAllowed(false);//ũ����������
		scroll = new JScrollPane (table);//��ũ�ѿ� ���̺����
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1000, 280));//��ũ��ũ��
		add(scroll);//�߰���		
	}	

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button1)
    {

    }
	if(e.getSource()==exitbutton)
	{
		this.dispose();
	}
}
/////////////////////////////////////////////// �Ǵ��� �����ϴ°� 
public static void main(String[] args) {
	try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
	    }
	} catch (Exception e) {
	    // If Nimbus is not available, you can set the GUI to another look and feel.
	}
	new MemberManagermentView();
}
}
