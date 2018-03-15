package dabang.client.view;
import java.awt.BorderLayout;
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
import java.lang.reflect.Member;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.MemberController;
public class MemberManagermentView extends JFrame implements ActionListener{
	private JPanel panel1 = new JPanel();//����
	private JLabel label1 = new JLabel("ȸ������");//�Ѹ���
	private JPanel panel2 = new JPanel();//��ư2��
	private JPanel panel3 = new JPanel();
	private JButton button1 = new JButton("�߰�");
	private JButton button2 = new JButton("����");
	private JButton button3 = new JButton("������");
	private JScrollPane scr = new JScrollPane();
	private ImageIcon picup = null;
	public MemberManagermentView() 
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
		p1();
		p3();
		p2();
		picture();
		
	}
	private void picture()
	{
		picup = new ImageIcon(new ImageIcon("1-1.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
	}
	private void p1()//Ÿ��Ʋ
	{
		panel1.setBackground(Color.yellow);
		panel1.add(label1);
		panel1.setPreferredSize(new Dimension(1000,100));
		this.add(panel1);
		
	}
	private void p2()//�ؿ� ��ư
	{
		panel2.setBackground(Color.white);
		button1.setPreferredSize(new Dimension(330, 70));
		panel2.add(button1);
		button2.setPreferredSize(new Dimension(330, 70));
		panel2.add(button2);
		button3.addActionListener(this);
		button3.setPreferredSize(new Dimension(330, 70));
		panel2.add(button3);
		this.add(panel2);
	}
	private void p3()//ǥ
	{
		
		Object[][] data = {{"��","����"},{"��","����"},{"��","����"},{"��","����"},{"��","����"},{"��","����"},{"��","����"}};
		String[] columnName = {"���̵�","����","�̸�","���","�⵵","��","��","����","PH","���","����Ʈ"};
		DefaultTableModel model = new DefaultTableModel(data, columnName);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane (table);
		scroll.setPreferredSize(new Dimension(1000, 280));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(scroll);		
	}	
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button3)
	{
		this.dispose();
	}
		
}
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

