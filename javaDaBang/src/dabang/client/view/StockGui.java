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

	//정보수정창 다이어로그dabang.client.model 변수들
	private JDialog revision = new JDialog(); //수정
	private JLabel reSerialNum = new JLabel("시리얼 번호");
	private JLabel reIngerName = new JLabel("재고명");
	private JLabel reUnit = new JLabel("개수");
	private JLabel reExpiryDate = new JLabel("유통기한");
	private JTextField reInputSerial = new JTextField(10);
	private JTextField reInputIngreName = new JTextField(10);
	private JTextField reInputUnit = new JTextField(10);
	private JTextField reInputExpiryDate = new JTextField(10);
	private JButton reDuplication = new JButton("시리얼 번호 확인");
	private JButton revisionData = new JButton("수정하기");
	
	private JComboBox reYearBox = new JComboBox();//년
	private JComboBox reMonthBox = new JComboBox();//달
	private JComboBox reDayBox  = new JComboBox(); //일
	
	//삭제 다이어로그 변수들
	private JDialog delete = new JDialog(); //삭제
	private JLabel deSerialNum = new JLabel("시리얼 번호");
	private JLabel deIngerName = new JLabel("재고명");
	private JLabel deUnit = new JLabel("개수");
	private JLabel deExpiryDate = new JLabel("유통기한");
	private JTextField deInputSerial = new JTextField(10);
	private JTextField deInputIngreName = new JTextField(10);
	private JTextField deInputUnit = new JTextField(10);
	private JTextField deInputExpiryDate = new JTextField(10);
	private JButton deDuplication = new JButton("삭제");

	private JComboBox deYearBox = new JComboBox();//년
	private JComboBox deMonthBox = new JComboBox();//달
	private JComboBox deDayBox  = new JComboBox(); //일

	//private String contents[][] = new String[3][4];

	//private Calendar year = null;
	//private Calendar month = null;
	//private Calendar day = null;

	private JPanel titlePanel = new JPanel(); //제목
	private JLabel titleLabel = new JLabel("재 고 관 리");

	private JPanel insertPanel = new JPanel();//입력패널
	private JLabel serialLabel = new JLabel("시리얼 번호");
	private JLabel ingreNameLabel = new JLabel("재료명");
	private JLabel unitLabel = new JLabel("개수");
	private JLabel expiryDate = new JLabel("유통기한");
	private JComboBox yearBox = new JComboBox();//년
	private JComboBox monthBox = new JComboBox();//달
	private JComboBox dayBox  = new JComboBox(); //일

	private JPanel buttonPanel = new JPanel();//버튼창
	private JButton addButton = new JButton("추가");
	private JButton deleteButton = new JButton("삭제");
	private JButton duplication = new JButton("중복체크");
	private JButton loadButton = new JButton("불러오기");
	private JButton saveButton = new JButton("저장");
	private JButton reviseButton = new JButton("정보수정");

	private JPanel contentsPanel = new JPanel();//출력(테이블 창)
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
	private JButton backButton = new JButton("뒤로가기");
	private static Color bgc = new Color(246,245,239);

	//Object[] data = new Object[4];

	public void titlePanel()
	{
		//프레임
		titlePanel.setSize(1000,70);
		titlePanel.setLocation(0,0);
		//titlePanel.setBackground(Color.blue);
		titleLabel.setFont(new Font("맑은 고딕",Font.BOLD,50));
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

	public void insertPanel() //재료정보삽입 패널
	{
		//패널 레이아웃 설정
		insertPanel.setLayout(null);
		insertPanel.setSize(750,320);
		insertPanel.setLocation(0,70);
		insertPanel.setBackground(bgc);

		//패널안에 라벨과 텍스트필드 설정
		//시리얼번호
		serialLabel.setBounds(10,10, 70,50);
		insertPanel.add(serialLabel);
		inputSerialNum.setBounds(80, 20, 120, 30);
		insertPanel.add(inputSerialNum);

		//중복체크 버튼 삽입
		duplication.setBounds(210, 20, 100, 30);
		insertPanel.add(duplication);
		duplication.addActionListener(this);

		//재료의 이름
		ingreNameLabel.setBounds(10,65,70,50);
		insertPanel.add(ingreNameLabel);
		inputIngreName.setBounds(80, 75, 120, 30);
		insertPanel.add(inputIngreName);

		//개수
		unitLabel.setBounds(10,130,70,50);
		insertPanel.add(unitLabel);
		inputUnit.setBounds(80, 140, 120, 30);
		insertPanel.add(inputUnit);

		//유통기한
		expiryDate.setBounds(10,185,70,50);
		insertPanel.add(expiryDate);
		yearBox.setBounds(80, 195, 65, 30);;

		//콤보박스 (년)
		for(int i=2018; i<=2028; i++)
		{
			yearBox.addItem(i);
			insertPanel.add(yearBox);
		}
		
		//콤보박스 (월)
		monthBox.setBounds(155, 195, 65, 30);

		for(int i=1; i<=12; i++)
		{
			monthBox.addItem(i);
			insertPanel.add(monthBox);
		}

		//콤보박스 (일)
		dayBox.setBounds(230, 195, 65, 30);
		for(int i=1; i<=31; i++)
		{
			dayBox.addItem(i);
			insertPanel.add(dayBox);
		}

		insertPanel.add(serialLabel);
		this.add(insertPanel);
	}

	public void buttonPanel() //버튼 사용을 위한 패널
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

	public void dialogSetting()//정보수정다이어로그 레이아웃
	{
		revision.setTitle("재고정보수정");
		revision.setLayout(null);
		revision.setSize(750,320);
		revision.setLocationRelativeTo(null);
		revision.setResizable(false);
		revision.setVisible(true);
	}
	public void dialogSetting2()
	{
		delete.setTitle("삭제");
		delete.setLayout(null);
		delete.setSize(750,320);
		delete.setLocationRelativeTo(null);
		delete.setResizable(false);
		delete.setVisible(true);
		
	}
	
	public void forDelete() //삭제창
	{
		dialogSetting2();
		deSerialNum.setBounds(10,10, 80,50);
		delete.add(deSerialNum); //삭제할 시리얼번호 라벨

		deInputSerial.setBounds(85, 20, 120, 30);
		delete.add(deInputSerial);

		//중복체크 버튼 삽입
		deDuplication.setBounds(210, 20, 140, 30);
		delete.add(deDuplication);
		deDuplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==deDuplication)  //삭제 다이얼로그창의 시리얼넘버 중복 체크 버튼
				{
					if(deInputSerial.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null, "시리얼 번호를 입력해주세요");
					}
					else if(stkCon.searchStock(Integer.parseInt(deInputSerial.getText())))
					{
						stkCon.loadIngredient();
						System.out.println(Integer.valueOf(deInputSerial.getText()));
						stkCon.deleteIngredient(Integer.valueOf(deInputSerial.getText()));
						stkCon.saveIngredient();
						JOptionPane.showMessageDialog(null, "삭제완료");
						repaint();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "시리얼번호가 존재하지않습니다.");
					}
				}
				
			}
		}); 
		
	}
	

	public void forRevision()
	{
		dialogSetting(); //호출 레이아웃



		//패널안에 라벨과 텍스트필드 설정
		//시리얼번호

		reSerialNum.setBounds(10,10, 80,50);
		revision.add(reSerialNum);

		reInputSerial.setBounds(85, 20, 120, 30);
		revision.add(reInputSerial);

		//중복체크 버튼 삽입
		reDuplication.setBounds(210, 20, 140, 30);
		revision.add(reDuplication);
		reDuplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==reDuplication) {
					if(stkCon.searchStock(Integer.parseInt(reInputSerial.getText()))) {
						JOptionPane.showMessageDialog(null, "수정이 가능합니다");
					}
					else {
						JOptionPane.showMessageDialog(null, "해당 재료가 없습니다");

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
						JOptionPane.showMessageDialog(null,"수정가능한 시리얼번호" );
					}
					else if(stkCon.searchStock(Integer.parseInt(inputSerialNum.getText()))==false)
					{
						JOptionPane.showMessageDialog(null,"시리얼번호가 존재하지 않습니다." );
					}
				}
			}
		});
		//재료의 이름
		reIngerName.setBounds(10,65,70,50);
		revision.add(reIngerName);
		reInputIngreName.setBounds(85, 75, 120, 30);
		revision.add(reInputIngreName);

		//개수
		reUnit.setBounds(10,130,70,50);
		revision.add(reUnit);
		reInputUnit.setBounds(85, 140, 120, 30);
		revision.add(reInputUnit);

		//유통기한
		reExpiryDate.setBounds(10,185,70,50);
		revision.add(reExpiryDate);


		reYearBox.setBounds(80, 195, 65, 30);;

		//콤보박스 (년)
		for(int i=2018; i<=2028; i++)
		{
			reYearBox.addItem(i);
			revision.add(reYearBox);
		}

		//콤보박스 (월)
		reMonthBox.setBounds(155, 195, 65, 30);

		for(int i=1; i<=12; i++)
		{
			reMonthBox.addItem(i);
			revision.add(reMonthBox);
		}

		//콤보박스 (일)
		reDayBox.setBounds(230, 195, 65, 30);
		for(int i=1; i<=31; i++)
		{
			reDayBox.addItem(i);
			revision.add(reDayBox);
		}

	}

	public void contentsPanel()//테이블 삽입 패널
	{
		contentsPanel.setLayout(new FlowLayout());
		contentsPanel.setSize(1000,410);
		contentsPanel.setLocation(0,390);
		contentsPanel.setBackground(bgc);

		createTable();

		this.add(contentsPanel);

	}



	public void createTable() //테이블창 만들기
	{
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		stockTable = new JTable(contents,header);

		stockTable.setPreferredSize(new Dimension(900,300));
		stockTable.getTableHeader().setFont(new Font("굴림체",Font.BOLD,15));
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
		stockTable.setFont(new Font("고딕",Font.PLAIN,15));
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
		if(e.getSource() == duplication)//중복체크!!
		{
			if(inputSerialNum.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"시리얼번호를 입력해주세요");
			}
			else if(stkCon.searchStock(Integer.parseInt(inputSerialNum.getText())))
			{
				JOptionPane.showMessageDialog(null, "해당 시리얼번호는 존재 합니다.");
				inputSerialNum.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "사용 가능한 시리얼 번호입니다.");
			}
		}


		else if(e.getSource() == addButton)
		{	//추가 버튼을 누른다면..
			if(inputSerialNum.getText().length()==0) //시리얼 텍스트길이가 0이면
			{	
				JOptionPane.showMessageDialog(null, "시리얼번호를 입력해주세요");
			}

			else if(inputIngreName.getText().length()==0)//재료명 길이가 0이면
			{
				JOptionPane.showMessageDialog(null, "재료명을 입력해주세요.");
			}

			else if(inputUnit.getText().length()==0) //수량텍스트 길이가 0이면
			{
				JOptionPane.showMessageDialog(null, "수량을 입력해주세요");
			}

			//콤보박스에 있는 날짜를 입력해야 함!!
			Calendar day = Calendar.getInstance();
			day.set((int)yearBox.getSelectedItem(), (int)monthBox.getSelectedItem(), (int)dayBox.getSelectedItem());

			stockInfo = new Stock(Integer.parseInt(inputSerialNum.getText()),//맴버변수에서 원래 정수형이므로 텍스트필드의 값을 integer형으로 ....
					inputIngreName.getText(),
					Integer.parseInt(inputUnit.getText()), //시리얼번호와 동일한 이유
					day);
			System.out.println(stockInfo);

			if(stkCon.addstock(stockInfo)==true)	//추가가 된다면
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
					contents[i][3] = s.getExpiryDate().get(Calendar.YEAR)+"년"+
							s.getExpiryDate().get(Calendar.MONTH)+"월"+
							s.getExpiryDate().get(Calendar.DATE)+"일";
					i++;

				}


				JOptionPane.showMessageDialog(null, "재고 추가 완료");

			}
			else 
			{
				JOptionPane.showMessageDialog(null, "재료 추가 실패","(Serial Number Error)",JOptionPane.ERROR_MESSAGE);
				inputSerialNum.setText("");
				//inputIngreName.setText("");
				//	inputUnit.setText("");
			}
			repaint();
		}
		else if(e.getSource()==reviseButton) //수정버튼을 한다면
		{
			forRevision(); //수정다이얼로그 메소드 호출
		
		}
		else if(e.getSource()==loadButton) //불러오기를 한다면 
		{
			System.out.println("불러오기했음");
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
				contents[i][3] = s.getExpiryDate().get(Calendar.YEAR)+"년"+
						s.getExpiryDate().get(Calendar.MONTH)+"월"+
						s.getExpiryDate().get(Calendar.DATE)+"일";
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
