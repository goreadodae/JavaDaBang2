package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.StockController;
import dabang.client.model.Stock;


public class StockGui extends JPanel implements ActionListener{
	Stock stockInfo = new Stock();
	StockController stkCon = new StockController();

	//��������â ���̾�α�dabang.client.model ������
	private JDialog revision = new JDialog(); //����
	private JLabel reSerialNum = new JLabel("�ø��� ��ȣ");
	private JLabel reIngerName = new JLabel("����");
	private JLabel reUnit = new JLabel("����");
	private JLabel reExpiryDate = new JLabel("�������");
	private JTextField reInputSerial = new JTextField(10);
	private JTextField reInputIngreName = new JTextField(10);
	private JTextField reInputUnit = new JTextField(10);
	private JTextField reInputExpiryDate = new JTextField(10);
	private JButton reDuplication = new JButton("�ø��� ��ȣ Ȯ��");
	private JButton revisionData = new JButton("�����ϱ�");
	
	private JComboBox reYearBox = new JComboBox();//��
	private JComboBox reMonthBox = new JComboBox();//��
	private JComboBox reDayBox  = new JComboBox(); //��
	
	//���� ���̾�α� ������
	private JDialog delete = new JDialog(); //����
	private JLabel deSerialNum = new JLabel("�ø��� ��ȣ");
	private JLabel deIngerName = new JLabel("����");
	private JLabel deUnit = new JLabel("����");
	private JLabel deExpiryDate = new JLabel("�������");
	private JTextField deInputSerial = new JTextField(10);
	private JTextField deInputIngreName = new JTextField(10);
	private JTextField deInputUnit = new JTextField(10);
	private JTextField deInputExpiryDate = new JTextField(10);
	private JButton deDuplication = new JButton("����");

	private JComboBox deYearBox = new JComboBox();//��
	private JComboBox deMonthBox = new JComboBox();//��
	private JComboBox deDayBox  = new JComboBox(); //��

	//private String contents[][] = new String[3][4];

	//private Calendar year = null;
	//private Calendar month = null;
	//private Calendar day = null;

	private JPanel titlePanel = new JPanel(); //����
	private JLabel titleLabel = new JLabel("�� �� �� ��");

	private JPanel insertPanel = new JPanel();//�Է��г�
	private JLabel serialLabel = new JLabel("�ø��� ��ȣ");
	private JLabel ingreNameLabel = new JLabel("����");
	private JLabel unitLabel = new JLabel("����");
	private JLabel expiryDate = new JLabel("�������");
	private JComboBox yearBox = new JComboBox();//��
	private JComboBox monthBox = new JComboBox();//��
	private JComboBox dayBox  = new JComboBox(); //��

	private JPanel buttonPanel = new JPanel();//��ưâ
	private JButton addButton = new JButton("�߰�");
	private JButton deleteButton = new JButton("����");
	private JButton duplication = new JButton("�ߺ�üũ");
	private JButton loadButton = new JButton("�ҷ�����");
	private JButton saveButton = new JButton("����");
	private JButton reviseButton = new JButton("��������");

	private JPanel contentsPanel = new JPanel();//���(���̺� â)
	private String header[] = {"Serial No.","Ingredients", "Unit","Expiry Date"};
	private Object contents[][] = new Object[100][4];

	private DefaultTableModel model = new DefaultTableModel();

	private JScrollPane scroll = new JScrollPane();

	private JTable stockTable = new JTable();


	private JTextField inputSerialNum = new JTextField(10);
	private JTextField inputIngreName = new JTextField(10);
	private JTextField inputUnit = new JTextField(10);
	private JTextField dupliMessage = new  JTextField(15);

	private JPanel mainPanel = new JPanel();

	ArrayList<Integer> serialNum = null;
	ArrayList<String> ingredients = null;
	ArrayList<Integer> unit = null;
	ArrayList<Calendar> expiryDateC = null;
	private JButton backButton = new JButton("�ڷΰ���");
	private static Color bgc = new Color(246,245,239);

	//Object[] data = new Object[4];

	public void titlePanel()
	{
		//������
		titlePanel.setSize(1000,70);
		titlePanel.setLocation(0,0);
		//titlePanel.setBackground(Color.blue);
		titleLabel.setFont(new Font("���� ���",Font.BOLD,50));
		serialLabel.setLayout(new BorderLayout());
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(bgc);
		titlePanel.add(titleLabel,BorderLayout.CENTER);
		JPanel backPanel = new JPanel();
		backPanel.setBackground(bgc);
		backPanel.add(backButton);
		backButton.addActionListener(this);
		titlePanel.add(backPanel,BorderLayout.EAST);
		this.add(titlePanel);
	}

	public void insertPanel() //����������� �г�
	{
		//�г� ���̾ƿ� ����
		insertPanel.setLayout(null);
		insertPanel.setSize(750,320);
		insertPanel.setLocation(0,70);
		insertPanel.setBackground(bgc);

		//�гξȿ� �󺧰� �ؽ�Ʈ�ʵ� ����
		//�ø����ȣ
		serialLabel.setBounds(10,10, 70,50);
		insertPanel.add(serialLabel);
		inputSerialNum.setBounds(80, 20, 120, 30);
		insertPanel.add(inputSerialNum);

		//�ߺ�üũ ��ư ����
		duplication.setBounds(210, 20, 100, 30);
		insertPanel.add(duplication);
		duplication.addActionListener(this);

		//����� �̸�
		ingreNameLabel.setBounds(10,65,70,50);
		insertPanel.add(ingreNameLabel);
		inputIngreName.setBounds(80, 75, 120, 30);
		insertPanel.add(inputIngreName);

		//����
		unitLabel.setBounds(10,130,70,50);
		insertPanel.add(unitLabel);
		inputUnit.setBounds(80, 140, 120, 30);
		insertPanel.add(inputUnit);

		//�������
		expiryDate.setBounds(10,185,70,50);
		insertPanel.add(expiryDate);
		yearBox.setBounds(80, 195, 65, 30);;

		//�޺��ڽ� (��)
		for(int i=2018; i<=2028; i++)
		{
			yearBox.addItem(i);
			insertPanel.add(yearBox);
		}
		
		//�޺��ڽ� (��)
		monthBox.setBounds(155, 195, 65, 30);

		for(int i=1; i<=12; i++)
		{
			monthBox.addItem(i);
			insertPanel.add(monthBox);
		}

		//�޺��ڽ� (��)
		dayBox.setBounds(230, 195, 65, 30);
		for(int i=1; i<=31; i++)
		{
			dayBox.addItem(i);
			insertPanel.add(dayBox);
		}

		insertPanel.add(serialLabel);
		this.add(insertPanel);
	}

	public void buttonPanel() //��ư ����� ���� �г�
	{

		buttonPanel.setLayout(null);
		buttonPanel.setSize(250,320);
		buttonPanel.setLocation(750,70);
		buttonPanel.setBackground(bgc);

		addButton.setSize(110,50);
		addButton.setLocation(10,10);
		addButton.addActionListener(this);

		deleteButton.setSize(110,50);
		deleteButton.setLocation(10,70);
		deleteButton.addActionListener(this);

		loadButton.setSize(110,50);
		loadButton.setLocation(10,130);
		loadButton.addActionListener(this);

		saveButton.setSize(110,50);
		saveButton.setLocation(10,190);
		saveButton.addActionListener(this);

		reviseButton.setBounds(10, 250, 110, 50);
		reviseButton.addActionListener(this);

		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(reviseButton);



		this.add(buttonPanel);
	}

	public void dialogSetting()//�����������̾�α� ���̾ƿ�
	{
		revision.setTitle("�����������");
		revision.setLayout(null);
		revision.setSize(750,320);
		revision.setLocationRelativeTo(null);
		revision.setResizable(false);
		revision.setVisible(true);
	}
	public void dialogSetting2()
	{
		delete.setTitle("����");
		delete.setLayout(null);
		delete.setSize(750,320);
		delete.setLocationRelativeTo(null);
		delete.setResizable(false);
		delete.setVisible(true);
		
	}
	
	public void forDelete() //����â
	{
		dialogSetting2();
		deSerialNum.setBounds(10,10, 80,50);
		delete.add(deSerialNum); //������ �ø����ȣ ��

		deInputSerial.setBounds(85, 20, 120, 30);
		delete.add(deInputSerial);

		//�ߺ�üũ ��ư ����
		deDuplication.setBounds(210, 20, 140, 30);
		delete.add(deDuplication);
		deDuplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==deDuplication)  //���� ���̾�α�â�� �ø���ѹ� �ߺ� üũ ��ư
				{
					if(deInputSerial.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null, "�ø��� ��ȣ�� �Է����ּ���");
					}
					else if(stkCon.searchStock(Integer.parseInt(deInputSerial.getText())))
					{
						stkCon.loadIngredient();
						System.out.println(Integer.valueOf(deInputSerial.getText()));
						stkCon.deleteIngredient(Integer.valueOf(deInputSerial.getText()));
						stkCon.saveIngredient();
						JOptionPane.showMessageDialog(null, "�����Ϸ�");
						repaint();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "�ø����ȣ�� ���������ʽ��ϴ�.");
					}
				}
				
			}
		}); 
		
	}
	

	public void forRevision()
	{
		dialogSetting(); //ȣ�� ���̾ƿ�



		//�гξȿ� �󺧰� �ؽ�Ʈ�ʵ� ����
		//�ø����ȣ

		reSerialNum.setBounds(10,10, 80,50);
		revision.add(reSerialNum);

		reInputSerial.setBounds(85, 20, 120, 30);
		revision.add(reInputSerial);

		//�ߺ�üũ ��ư ����
		reDuplication.setBounds(210, 20, 140, 30);
		revision.add(reDuplication);
		reDuplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==reDuplication) {
					if(stkCon.searchStock(Integer.parseInt(reInputSerial.getText()))) {
						JOptionPane.showMessageDialog(null, "������ �����մϴ�");
					}
					else {
						JOptionPane.showMessageDialog(null, "�ش� ��ᰡ �����ϴ�");

					}
				}
			}
		});	


		revisionData.setBounds(100, 240, 140, 30);
		revision.add(revisionData);
		revisionData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==revisionData)
				{
					if(stkCon.searchStock(Integer.parseInt(reInputSerial.getText())))
					{
						stkCon.loadIngredient();
						Stock st = new Stock();
						Calendar cd = Calendar.getInstance();
						cd.set(reYearBox.getSelectedIndex(), reMonthBox.getSelectedIndex(), reDayBox.getSelectedIndex());
						st.setExpiryDate(cd);
						st.setIngredientName(reInputIngreName.getText());
						st.setQuantity(Integer.valueOf(reInputUnit.getText()));
						st.setSerialNumber(Integer.valueOf(reInputSerial.getText()));
						stkCon.reviseIngredient(st);
						stkCon.saveIngredient();
						JOptionPane.showMessageDialog(null,"���������� �ø����ȣ" );
					}
					else if(stkCon.searchStock(Integer.parseInt(inputSerialNum.getText()))==false)
					{
						JOptionPane.showMessageDialog(null,"�ø����ȣ�� �������� �ʽ��ϴ�." );
					}
				}
			}
		});
		//����� �̸�
		reIngerName.setBounds(10,65,70,50);
		revision.add(reIngerName);
		reInputIngreName.setBounds(85, 75, 120, 30);
		revision.add(reInputIngreName);

		//����
		reUnit.setBounds(10,130,70,50);
		revision.add(reUnit);
		reInputUnit.setBounds(85, 140, 120, 30);
		revision.add(reInputUnit);

		//�������
		reExpiryDate.setBounds(10,185,70,50);
		revision.add(reExpiryDate);


		reYearBox.setBounds(80, 195, 65, 30);;

		//�޺��ڽ� (��)
		for(int i=2018; i<=2028; i++)
		{
			reYearBox.addItem(i);
			revision.add(reYearBox);
		}

		//�޺��ڽ� (��)
		reMonthBox.setBounds(155, 195, 65, 30);

		for(int i=1; i<=12; i++)
		{
			reMonthBox.addItem(i);
			revision.add(reMonthBox);
		}

		//�޺��ڽ� (��)
		reDayBox.setBounds(230, 195, 65, 30);
		for(int i=1; i<=31; i++)
		{
			reDayBox.addItem(i);
			revision.add(reDayBox);
		}

	}

	public void contentsPanel()//���̺� ���� �г�
	{
		contentsPanel.setLayout(new FlowLayout());
		contentsPanel.setSize(1000,410);
		contentsPanel.setLocation(0,390);
		contentsPanel.setBackground(bgc);

		createTable();

		this.add(contentsPanel);

	}



	public void createTable() //���̺�â �����
	{
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		stockTable = new JTable(contents,header);

		stockTable.setPreferredSize(new Dimension(900,300));
		stockTable.getTableHeader().setFont(new Font("����ü",Font.BOLD,15));
		stockTable.setRowHeight(50);
		stockTable.getTableHeader().setReorderingAllowed(false);
		stockTable.getTableHeader().setResizingAllowed(false);

		stockTable.getColumn("Serial No.").setPreferredWidth(50);
		stockTable.getColumn("Serial No.").setCellRenderer(cellRenderer);
		stockTable.getColumn("Ingredients").setPreferredWidth(250);
		stockTable.getColumn("Ingredients").setCellRenderer(cellRenderer);
		stockTable.getColumn("Unit").setPreferredWidth(50);
		stockTable.getColumn("Unit").setCellRenderer(cellRenderer);
		stockTable.getColumn("Expiry Date").setPreferredWidth(250);
		stockTable.getColumn("Expiry Date").setCellRenderer(cellRenderer);
		stockTable.setFont(new Font("���",Font.PLAIN,15));
		JScrollPane scrollPane = new JScrollPane(stockTable);
		scrollPane.setPreferredSize(new Dimension(990,300));

		contentsPanel.add(scrollPane);

		/*
		DefaultTableModel allStockModel = new DefaultTableModel(contents,header);
			//{public boolean isCellEditable(int i, int c) {return false;}};
		 */


	}



	public void comInit() 
	{
		titlePanel();
		buttonPanel();
		insertPanel();
		contentsPanel();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == duplication)//�ߺ�üũ!!
		{
			if(inputSerialNum.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"�ø����ȣ�� �Է����ּ���");
			}
			else if(stkCon.searchStock(Integer.parseInt(inputSerialNum.getText())))
			{
				JOptionPane.showMessageDialog(null, "�ش� �ø����ȣ�� ���� �մϴ�.");
				inputSerialNum.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "��� ������ �ø��� ��ȣ�Դϴ�.");
			}
		}


		else if(e.getSource() == addButton)
		{	//�߰� ��ư�� �����ٸ�..
			if(inputSerialNum.getText().length()==0) //�ø��� �ؽ�Ʈ���̰� 0�̸�
			{	
				JOptionPane.showMessageDialog(null, "�ø����ȣ�� �Է����ּ���");
			}

			else if(inputIngreName.getText().length()==0)//���� ���̰� 0�̸�
			{
				JOptionPane.showMessageDialog(null, "������ �Է����ּ���.");
			}

			else if(inputUnit.getText().length()==0) //�����ؽ�Ʈ ���̰� 0�̸�
			{
				JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
			}

			//�޺��ڽ��� �ִ� ��¥�� �Է��ؾ� ��!!
			Calendar day = Calendar.getInstance();
			day.set((int)yearBox.getSelectedItem(), (int)monthBox.getSelectedItem(), (int)dayBox.getSelectedItem());

			stockInfo = new Stock(Integer.parseInt(inputSerialNum.getText()),//�ɹ��������� ���� �������̹Ƿ� �ؽ�Ʈ�ʵ��� ���� integer������ ....
					inputIngreName.getText(),
					Integer.parseInt(inputUnit.getText()), //�ø����ȣ�� ������ ����
					day);
			System.out.println(stockInfo);

			if(stkCon.addstock(stockInfo)==true)	//�߰��� �ȴٸ�
			{
				stkCon.saveIngredient();
				stkCon.loadIngredient();

				HashMap<Integer,Stock> in = new HashMap<Integer,Stock>();

				in = stkCon.selectAll();

				Iterator iter = in.keySet().iterator();

				int i = 0;
				while(iter.hasNext()) {
					Stock s = new Stock();
					s = in.get(iter.next());
					contents[i][0] = s.getSerialNumber();
					contents[i][1] = s.getIngredientName();
					contents[i][2] = s.getQuantity();
					contents[i][3] = s.getExpiryDate().get(Calendar.YEAR)+"��"+
							s.getExpiryDate().get(Calendar.MONTH)+"��"+
							s.getExpiryDate().get(Calendar.DATE)+"��";
					i++;

				}


				JOptionPane.showMessageDialog(null, "��� �߰� �Ϸ�");

			}
			else 
			{
				JOptionPane.showMessageDialog(null, "��� �߰� ����","(Serial Number Error)",JOptionPane.ERROR_MESSAGE);
				inputSerialNum.setText("");
				//inputIngreName.setText("");
				//	inputUnit.setText("");
			}
			repaint();
		}
		else if(e.getSource()==reviseButton) //������ư�� �Ѵٸ�
		{
			forRevision(); //�������̾�α� �޼ҵ� ȣ��
		
		}
		else if(e.getSource()==loadButton) //�ҷ����⸦ �Ѵٸ� 
		{
			System.out.println("�ҷ���������");
			stkCon.loadIngredient();

			HashMap<Integer,Stock> in = new HashMap<Integer,Stock>();

			in = stkCon.selectAll();

			Iterator iter = in.keySet().iterator();

			int i = 0;
			while(iter.hasNext()) {
				Stock s = new Stock();
				s = in.get(iter.next());
				contents[i][0] = s.getSerialNumber();
				contents[i][1] = s.getIngredientName();
				contents[i][2] = s.getQuantity();
				contents[i][3] = s.getExpiryDate().get(Calendar.YEAR)+"��"+
						s.getExpiryDate().get(Calendar.MONTH)+"��"+
						s.getExpiryDate().get(Calendar.DATE)+"��";
				i++;
			}
			repaint();
		}
		else if(e.getSource()==saveButton)
		{
			stkCon.saveIngredient();
		}
		else if(e.getSource()==deleteButton)
		{
			forDelete();
			
		}
		else if(e.getSource()==backButton) {
			mainPanel.remove(13);
			StockGui sv = new StockGui(mainPanel);
			mainPanel.add(sv,"Stock",13);
			((CardLayout)mainPanel.getLayout()).show(mainPanel,"admin");
		}
		

	}

	public StockGui(JPanel mainPanel)
	{
		//this.mainPanel  = mainPanel;
		this.setSize(1000,800);
		this.setLayout(null);
		this.mainPanel = mainPanel;
//		this.setResizable(false);
//		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.comInit();
		this.setVisible(true);
	}

}
