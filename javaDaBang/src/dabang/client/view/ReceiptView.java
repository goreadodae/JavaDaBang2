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
	private JButton backButton = new JButton("�ڷΰ���");
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
		titleLabel = new JLabel(accessMember.getId()+"���� ������",JLabel.LEFT);
		
		model.addColumn("No.");
		model.addColumn("��ǰ��");
		model.addColumn("���� �Ͻ�");
		model.addColumn("���� ����");
		model.addColumn("���� �ݾ�");
		
		oCon.loadOrder();
		
		if(accessMember.getId().equals("0")) {
			System.out.println("�α��ϰ� ó��");
		} else {
			ArrayList al = oCon.selectOrder(accessMember.getId());
			
			int number = 1, countSum = 0, priceSum = 0;
			for(int i=0; i<al.size();i++) {
				m = (Menu)al.get(i);
				SimpleDateFormat fm = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
				Calendar c = m.getOrderDate();
				Date d = new Date(c.getTimeInMillis());
				String date = fm.format(d); 
				model.addRow(new Object[] {number++,m.getMenuName(),date,m.getNumberOfGoods(),
						String.format("%,d",m.getPrice()*m.getNumberOfGoods())});
				countSum += m.getNumberOfGoods();
				priceSum += m.getNumberOfGoods()*m.getPrice();
			}
			model.addRow(new Object[] {"�հ�"," "," ",countSum,String.format("%,d",priceSum)});
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
		titleLabel.setFont(new Font("����",Font.BOLD,50));
		titlePanel.add(titleLabel);
		
		bodyPanel.setSize(800,600);
		bodyPanel.setLocation(100,100);
		bodyPanel.setBackground(new Color(240,250,170));
		
		buttonPanel.setSize(800,80);
		buttonPanel.setLocation(100,700);
		buttonPanel.setBackground(new Color(240,250,170));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		backButton.setFont(new Font("�������",Font.BOLD,17));
		backButton.addActionListener(this);
		buttonPanel.add(backButton);

		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		receiptTable.getTableHeader().setFont(new Font("�������",Font.BOLD,15));
		receiptTable.setRowHeight(30);

		receiptTable.getColumn("No.").setPreferredWidth(50);
		receiptTable.getColumn("No.").setCellRenderer(celAlignRight);
		receiptTable.getColumn("��ǰ��").setPreferredWidth(225);
		receiptTable.getColumn("��ǰ��").setCellRenderer(celAlignRight);
		receiptTable.getColumn("���� �Ͻ�").setPreferredWidth(225);
		receiptTable.getColumn("���� �Ͻ�").setCellRenderer(celAlignRight);
		receiptTable.getColumn("���� ����").setPreferredWidth(100);
		receiptTable.getColumn("���� ����").setCellRenderer(celAlignRight);
		receiptTable.getColumn("���� �ݾ�").setPreferredWidth(200);
		receiptTable.getColumn("���� �ݾ�").setCellRenderer(celAlignRight);
		
		receiptTable.setFont(new Font("�������",Font.PLAIN,15));
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
