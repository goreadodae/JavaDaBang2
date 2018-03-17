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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Vector;

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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dabang.client.controller.LoginController;
import dabang.client.controller.MemberController;
public class MemberManagermentView extends JFrame implements ActionListener{
	private JPanel titlepanel = new JPanel();//����
	private JLabel label1 = new JLabel("ȸ������");//Ÿ��Ʋ�� �Ҹ�
	private JPanel buttonpanel = new JPanel();//��ư�����г�
	private JButton button1 = new JButton("����");
	private JButton diabutton1 = new JButton("Ȯ��");
	private JButton diaexitbutton = new JButton("���");
	private JButton deletebutton = new JButton("����");
	private JButton exitbutton = new JButton("������");
	private JScrollPane scr = new JScrollPane();
	private ImageIcon picup = null;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll; 
	private JOptionPane jop = new JOptionPane();
	private JDialog dialog = new JDialog (); 
	private Object [][] data = new Object[10][11];
	private Member testMem [] = new Member[11];
	int updateRow;
	private JLabel labelid = new JLabel("                    ���̵�");
	private JLabel labelnikcname = new JLabel("                    ����");
	private JLabel labelname = new JLabel("                    �̸�");
	private JLabel labels = new JLabel("                    ���/����");
	private JLabel labely = new JLabel("                    ����");
	private JLabel labeld = new JLabel("                    ��");
	private JLabel labelm = new JLabel("                    ��");
	private JLabel labelgender = new JLabel("                    ����");
	private JLabel labelpn = new JLabel("                    ��ȭ��ȣ");

	private JTextField labelidf = new JTextField();
	private JTextField labelnikcnamef = new JTextField();
	private JTextField labelnamef = new JTextField();
	private JTextField labelsf = new JTextField("���/����");
	private JTextField labelyf = new JTextField();
	private JTextField labeldf = new JTextField();
	private JTextField labelmf = new JTextField();
	private JTextField labelgenderf = new JTextField();
	private JTextField labelpnf = new JTextField();
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
	private void compInit() //���డ���
	{   
		West();
		picture();
		title();
		table();
		button();
	}
	private void picture() //Ÿ��Ʋ ���� �����ֱ�
	{
		picup = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
	}
	private void title()//Ÿ��Ʋ�г�
	{
		//setborder(new TitledBorder(new LineBorder(Color.MAGENTA,2),"�Է�"));
		label1.setIcon(picup); //����(��������)
		titlepanel.setBackground(Color.yellow);//����
		titlepanel.add(label1);//���Ѹ���  �� 
		titlepanel.setPreferredSize(new Dimension(1000,100));//âũ��
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

	private void table()//��� ǥ
	{

		testMem[0] = new Member("topama2","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[1] = new Member("topama3","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[2] = new Member("topama4","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[3] = new Member("topama5","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[4] = new Member("topama6","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[5] = new Member("topama7","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[6] = new Member("topama8","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[7] = new Member("topama9","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[8] = new Member("topama10","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );
		testMem[9] = new Member("topama11","�ָ�" ,"������", 1, 92, 02, 05, '��', "010-7730-1344","vip",100 );


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
		

		model = new DefaultTableModel(data, columnName) 
		{public boolean isCellEditable(int rowlndex,int mCollnDex) {return false;}};//�����Ұ��ڵ�
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
        /*DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel CellModel = table.getColumnModel();
        for(int i=0;i<CellModel.getColumnCount();i++){
            CellModel.getColumn(i).setCellRenderer(tableCell);
         }*/
		table.getTableHeader().setReorderingAllowed(false);//�̵�����
		table.getTableHeader().setResizingAllowed(false);//ũ����������
		scroll = new JScrollPane (table);//��ũ�ѿ� ���̺����
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1000, 280));//��ũ��ũ��
		add(scroll);//�߰���      
	}   
	public void West(){ //����â�������̽�
		dialog.setBackground(Color.yellow);
		dialog.setTitle("�������ٲ��");
		dialog.setLayout(new GridLayout(10,1)); 
		dialog.add(labelid);
		dialog.add(labelidf);
		dialog.add(labelnikcname);
		dialog.add(labelnikcnamef);
		dialog.add(labelname);
		dialog.add(labelnamef);
		dialog.add(labels);
		dialog.add(labelsf);
		dialog.add(labely);
		dialog.add(labelyf);
		dialog.add(labeld);
		dialog.add(labeldf);
		dialog.add(labelm);
		dialog.add(labelmf);
		dialog.add(labelgender);
		dialog.add(labelgenderf);
		dialog.add(labelpn);
		dialog.add(labelpnf);
		diabutton1.addActionListener(this);
		diaexitbutton.addActionListener(this);
		dialog.add(diabutton1);
		dialog.add(diaexitbutton);   
	}
///////////////////////////////////////////////////////////////////////////////////////////
	public void DelData()//////����
	{
		int yes_no_select = JOptionPane.showConfirmDialog(null, 
				"���� �����ϰڽ��ϱ�?", "���� Ȯ�� â", JOptionPane.YES_NO_CANCEL_OPTION);
		if(yes_no_select==JOptionPane.YES_OPTION)
		{
            int deleteRow = table.getSelectedColumn();
			if(deleteRow == -1) return;
			else 
			{
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(deleteRow);
			}
		}
		else return;       
	}
	

	private void westyes()//����â���� �پ��� Ȯ��
	{

		for(int i=0;i<data.length;i++) 
		{
			        
		} 
	}
	
//////////////////////////////////////////////////////////////////////////////

	//showtable.table.setValueAt(west.tf[1].getText(), updateRow, 12);   

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button1)//����â������
	{
		dialog.setSize(700,400);
		dialog.setLocation(200, 200);
		dialog.setVisible(true);
	}
	if(e.getSource()==deletebutton)//������ư������
	{
		DelData();
	}
	if(e.getSource()==exitbutton)//����â������
	{
		this.dispose();
	}
	if(e.getSource()==diabutton1)//���������
	{
		this.westyes();
		// dialog.tf[0].setText(" ");
		dialog.dispose();
	}
	if(e.getSource()==diaexitbutton)//����â����������
	{
		dialog.dispose();
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