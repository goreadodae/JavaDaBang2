package dabang.client.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.OrderCon;
import dabang.client.model.Member;
import dabang.client.model.Menu;

public class ReceiptView extends JPanel implements ActionListener {
	private JPanel mainPanel = null;
	private JButton backButton = new JButton("뒤로가기");
	private JLabel titleLabel = null;
	private DefaultTableModel model = new DefaultTableModel() {
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};
	private JTable receiptTable = new JTable(model);
	private Member accessMember = null;
	private OrderCon oCon = new OrderCon();
	private Menu m = null;
	
	public ReceiptView(JPanel mainPanel, Member accessMember) {
		this.mainPanel = mainPanel;
		this.accessMember = accessMember;
		this.setSize(1000,800);
		this.setLayout(null);
		loadReceipt();
		comInit();
		this.setBackground(new Color(240,250,170));
	}
	
	public void loadReceipt() {
		titleLabel = new JLabel(accessMember.getId()+"님의 영수증",JLabel.LEFT);
		
		model.addColumn("No.");
		model.addColumn("제품명");
		model.addColumn("구매 일시");
		model.addColumn("구매 수량");
		model.addColumn("지출 금액");
		
		oCon.loadOrder();
		
		if(accessMember.getId().equals("0")) {
			System.out.println("로긴하고 처리");
		} else {
			ArrayList al = oCon.selectOrder(accessMember.getId());
			
			int number = 1, countSum = 0, priceSum = 0;
			for(int i=0; i<al.size();i++) {
				m = (Menu)al.get(i);
				SimpleDateFormat fm = new SimpleDateFormat("yyyy년MM월dd일 HH:mm:ss");
				Calendar c = m.getOrderDate();
				Date d = new Date(c.getTimeInMillis());
				String date = fm.format(d); 
				model.addRow(new Object[] {number++,m.getMenuName(),date,m.getNumberOfGoods(),
						String.format("%,d",m.getPrice()*m.getNumberOfGoods())});
				countSum += m.getNumberOfGoods();
				priceSum += m.getNumberOfGoods()*m.getPrice();
			}
			model.addRow(new Object[] {"합계"," "," ",countSum,String.format("%,d",priceSum)});
		}
	}
	
	public void comInit() {
		JPanel titlePanel = new JPanel();
		JPanel bodyPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		titlePanel.setSize(800,80);
		titlePanel.setLocation(100,20);
		titlePanel.setBackground(new Color(240,250,170));
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titleLabel.setFont(new Font("굴림",Font.BOLD,50));
		titlePanel.add(titleLabel);
		
		bodyPanel.setSize(800,600);
		bodyPanel.setLocation(100,100);
		bodyPanel.setBackground(new Color(240,250,170));
		
		buttonPanel.setSize(800,80);
		buttonPanel.setLocation(100,700);
		buttonPanel.setBackground(new Color(240,250,170));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		backButton.setFont(new Font("맑은고딕",Font.BOLD,17));
		backButton.addActionListener(this);
		buttonPanel.add(backButton);

		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		receiptTable.getTableHeader().setFont(new Font("맑은고딕",Font.BOLD,15));
		receiptTable.setRowHeight(30);

		receiptTable.getColumn("No.").setPreferredWidth(50);
		receiptTable.getColumn("No.").setCellRenderer(celAlignRight);
		receiptTable.getColumn("제품명").setPreferredWidth(225);
		receiptTable.getColumn("제품명").setCellRenderer(celAlignRight);
		receiptTable.getColumn("구매 일시").setPreferredWidth(225);
		receiptTable.getColumn("구매 일시").setCellRenderer(celAlignRight);
		receiptTable.getColumn("구매 수량").setPreferredWidth(100);
		receiptTable.getColumn("구매 수량").setCellRenderer(celAlignRight);
		receiptTable.getColumn("지출 금액").setPreferredWidth(200);
		receiptTable.getColumn("지출 금액").setCellRenderer(celAlignRight);
		
		receiptTable.setFont(new Font("맑은고딕",Font.PLAIN,15));
		JScrollPane scrollpane = new JScrollPane(receiptTable);

		scrollpane.setPreferredSize(new Dimension(800,580));
		
		bodyPanel.add(scrollpane);		
		this.add(titlePanel);
		this.add(bodyPanel);
		this.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "member");
		}
	}
	
}
