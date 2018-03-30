package dabang.client.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.MemberController;
import dabang.client.model.Member;


public class MemberManagermentView extends JFrame implements ActionListener{
	private JPanel titlepanel = new JPanel();//����
	private JLabel label1 = new JLabel("ȸ������");//Ÿ��Ʋ�� �Ҹ�
	private JLabel notice = new JLabel("(���or���� ������ 1����� 2������)    (���̵�,����,���,����Ʈ �����Ұ�)    (������ �����Ұ� Ŭ���� �ؿ� ���� ����Ŭ��)");//Ÿ��Ʋ�� �Ҹ�
	private JPanel buttonpanel = new JPanel();//��ư�����г�
	private JPanel noticepanel = new JPanel();//���������г�
	private JButton button1 = new JButton("����");
	private JButton diabutton1 = new JButton("Ȯ��");
	private JButton diaexitbutton = new JButton("���");
	private JButton deletebutton = new JButton("����");
	private JButton exitbutton = new JButton("������");
	private JPanel fix = new JPanel();//����â �г�
	private JScrollPane scr = new JScrollPane();
	private ImageIcon picup = null;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll; 
	private JOptionPane jop = new JOptionPane();
	private JDialog dialog = new JDialog (); 
	private Object [][] data = null;
	private ArrayList<Member> testMem = new ArrayList<Member>();
	int updateRow;
	private JLabel fixlabel = new JLabel("������ ������ �Է����ּ���� : ");
	private MemberController memC = new MemberController();
	private JTextField fixtextfield = new JTextField(20);
	
	private MemberController mCon = new MemberController();

	public MemberManagermentView() //���� â 
	{
		super("ȸ������"); //�̸�����
		this.setSize(1000,560); //������ ������
		this.setLocationRelativeTo(null); //ȭ�� ����� ��ġ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //�����ư�� �ƿ��ٲ�����
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.compInit(); //����� ���� �޼ҵ�
		this.setVisible(true); //���������� �����־��
	}
	private void compInit() //���డ���
	{   
		picture();
		title();
		table();
		noticelabel();
		fixlabel();
		button();
	}
	private void picture() //Ÿ��Ʋ ���� �����ֱ�
	{
		picup = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
	}
	private void title()//Ÿ��Ʋ�г�
	{
		
		label1.setIcon(picup); //����(��������)
		titlepanel.setBackground(Color.yellow);//����
		titlepanel.add(label1);//���Ѹ���  �� 
		titlepanel.setPreferredSize(new Dimension(1000,100));//âũ��

		this.add(titlepanel);//�߰� �����    

		this.add(titlepanel);//�߰� �����    

	}
	private void button()//�ؿ� ��ư2��
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
	private void noticelabel()
	{
	    noticepanel.setBorder(new TitledBorder(new LineBorder(Color.MAGENTA,2),"                                                                                                       Notice"));
		noticepanel.add(notice);
		this.add(noticepanel);
	}

	private void fixlabel()//����â
	{
		fix.setPreferredSize(new Dimension(1000,40));
		fix.setBackground(Color.yellow);
		fix.add(fixlabel);//������
		fix.add(fixtextfield);//����tf
		diabutton1.addActionListener(this);
		diaexitbutton.addActionListener(this);
		this.add(fix);
	}
	private void table()//��� ǥ
	{
		HashMap<String, Member> member = new HashMap<String, Member>();
		mCon.loadMember();
		member = mCon.selectAll();
		Iterator<String> iter = member.keySet().iterator();
		
		while(iter.hasNext())
		{
			String key = iter.next();
			testMem.add(member.get(key));
		}
		

		data = new Object[testMem.size()][11];
		for(int i=0; i<testMem.size();i++) {
			data[i] = new Object[11];
		}
		//�ȳ��ϼ���

		for(int i=0;i<data.length;i++) //�ҷ����°�
		{
			data[i][0]  =testMem.get(i).getId();//���̵�
			data[i][1]  =testMem.get(i).getNickName();//����
			data[i][2]  =testMem.get(i).getName();//�̸�
			if(testMem.get(i).getSclc() == 1) {   //1 ����Ͻ�
				data[i][3]  ="���";
			}
			else if(testMem.get(i).getSclc() == 2) { //2 �����Ͻ�
				data[i][3]  ="����";
			}   
			data[i][4]  =testMem.get(i).getAgeY();//����
			data[i][5]  =testMem.get(i).getAgeM();//��
			data[i][6]  =testMem.get(i).getAgeD();//��
			data[i][7]  =testMem.get(i).getGender();//����
			data[i][8]  =testMem.get(i).getPhoneNumber();//����
			data[i][9]  =testMem.get(i).getGrade();//���
			data[i][10] =testMem.get(i).getPoint();//������                        

			String[] columnName = {"���̵�","����","�̸�","���","�⵵","��","��","����","PH","���","����Ʈ"};//����
			table = new JTable(model);
			model = new DefaultTableModel(data, columnName) 
			{
				public boolean isCellEditable(int rowlndex,int mCollnDex) {return false;}};//�����Ұ��ڵ�
		}
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);//���̵�ĭũ��
		table.getColumnModel().getColumn(1).setPreferredWidth(100);//����ĭ
		table.getColumnModel().getColumn(2).setPreferredWidth(70);//�̸�ĭ
		table.getColumnModel().getColumn(3).setPreferredWidth(30);//���ĭ
		table.getColumnModel().getColumn(4).setPreferredWidth(30);//����ĭ
		table.getColumnModel().getColumn(5).setPreferredWidth(30);//��ĭ
		table.getColumnModel().getColumn(6).setPreferredWidth(30);//��ĭ
		table.getColumnModel().getColumn(7).setPreferredWidth(30);//����ĭ
		table.getColumnModel().getColumn(8).setPreferredWidth(200);//����ĭ
		table.getColumnModel().getColumn(9).setPreferredWidth(70);//���ĭ
		table.getColumnModel().getColumn(10).setPreferredWidth(100);//����Ʈĭũ��
		table.getTableHeader().setReorderingAllowed(false);//�̵�����
		table.getTableHeader().setResizingAllowed(false);//ũ����������
		scroll = new JScrollPane (table);//��ũ�ѿ� ���̺����
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1000, 230));//��ũ��ũ��
		add(scroll);//�߰���      
	}   
	///////////////////////////////////////////////////////////////////////////////////////////

	public void DelData()//////����
	{
		int yes_no_select = JOptionPane.showConfirmDialog(null, 
				"���� �����ϰڽ��ϱ�?", "���� Ȯ�� â", JOptionPane.YES_NO_CANCEL_OPTION);
		if(yes_no_select==JOptionPane.YES_OPTION)
		{
			////////////////////////////////////////////////////////////////
	   		
            Member m = new Member();
			mCon.loadMember();//�ҷ���
			int deleteRow = table.getSelectedRow(); //Ŭ������ ����
			System.out.println((String)table.getValueAt(deleteRow, 0));
			mCon.memberDelete((String)table.getValueAt(deleteRow, 0));
			model.removeRow(deleteRow);//�����
            mCon.saveMember();//����
			
			////////////////////////////////////////////////////////////////
		}
	}
	private void westyes()//����â
	{
		int yes_no_select = JOptionPane.showConfirmDialog(null, 
				"���� �����Ͻʴϱ�?", "������", JOptionPane.YES_NO_CANCEL_OPTION     );
		if(yes_no_select==JOptionPane.YES_OPTION)
		{
			//////////////////////////////////////////////////////��������   
			Member m = new Member();
			int rowIdx = table.getSelectedRow(); //������
			int colIdx = table.getSelectedColumn();//���ÿ�
			table.setValueAt(fixtextfield.getText(), rowIdx, colIdx);//�����Ѱ� ��������
            //"���̵�","����","�̸�","���","�⵵","��","��","����","PH","���","����Ʈ"
			mCon.loadMember(); //����ε�
			m = mCon.memberSelect((String)table.getValueAt(rowIdx,0));
			switch(colIdx) 
			{
			//0 ���̵���� x
			case 1: m.setNickName(fixtextfield.getText());break;//����
			case 2: m.setName(fixtextfield.getText());break;//�̸�
			case 3: m.setSclc(Integer.valueOf(fixtextfield.getText()));break;//���
			case 4: m.setAgeY(Integer.valueOf(fixtextfield.getText()));break;//��
			case 5: m.setAgeM(Integer.valueOf(fixtextfield.getText()));break;//��
			case 6: m.setAgeD(Integer.valueOf(fixtextfield.getText()));break;//��
			//7 ��������x
			case 8: m.setPhoneNumber(fixtextfield.getText());break;//����
			//9 ��޼���x
			//10 ����Ʈ����x
            default:
  JOptionPane.showMessageDialog(null, "������ �Ұ����� �׸��Դϴ�", "������", JOptionPane.ERROR_MESSAGE);
			}
			mCon.memberModify(m);
			mCon.saveMember();
			//setValueAt(������ ��ġ, ��, ��)
			//////////////////////////////////////////////////////����������
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)//����â������
		{
			westyes();
		}
		if(e.getSource()==deletebutton)//������ư������
		{
			DelData();
		}
		if(e.getSource()==exitbutton)//����â������
		{
			this.dispose();
		}
	}
	/////////////////////////////////////////////// �Ǵ��� �����ϴ°� 
}