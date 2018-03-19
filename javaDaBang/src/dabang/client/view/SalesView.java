package dabang.client.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dabang.client.controller.OrderCon;
import dabang.client.controller.SalesCon;
import dabang.client.model.Menu;
import dabang.client.model.Sales;

public class SalesView extends JPanel implements ActionListener {
	private JPanel mainPanel = null;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable salesTable = new JTable(model);
	private JLabel titleLabel = new JLabel("¸ÅÃâ °ü¸®",JLabel.CENTER);
	private JButton backButton = new JButton("µÚ·Î°¡±â");
	private HashMap<String,ArrayList> orderList = null;
	private HashMap<String,Sales> salesMap = null;
	private ArrayList<Sales> salesAl = new ArrayList<Sales>();
	private OrderCon oCon = new OrderCon();
	private SalesCon sCon = new SalesCon();
	private Menu m = new Menu();

	public SalesView(JPanel mainPanel) {	
		this.mainPanel = mainPanel;
		this.setSize(1000,800);
		this.setLayout(null);
		loadSales();
		comInit();
		this.setBackground(new Color(130,230,130));
	}

	private void loadSales() {
		model.addColumn("No.");
		model.addColumn("Á¦Ç°¸í");
		model.addColumn("ÃÑ ÆÇ¸Å ¼ö·®");
		model.addColumn("ÃÑ ¸ÅÃâ¾×");

		oCon.loadOrder();
		orderList = oCon.selectAll();

		Iterator<String> orderIter = orderList.keySet().iterator();

		while(orderIter.hasNext()) {
			String key = orderIter.next();

			for(int i=0;i<orderList.get(key).size();i++) {
				m = (Menu) orderList.get(key).get(i);
				sCon.addSales(m);
//				System.out.println(m.getMenuName()+" "+m.getNumberOfGoods()+" "+m.getPrice());
			}
		}
		
		salesMap = sCon.selectSales();
		
		Iterator<String> salesIter = salesMap.keySet().iterator();
		
		while(salesIter.hasNext()) {
			String key = salesIter.next();
			salesAl.add(salesMap.get(key));
		}

		Collections.sort(salesAl);
		Collections.reverse(salesAl);
		
		int number = 1;
		for(int i=0;i<salesAl.size();i++) {
			model.addRow(new Object[] {number++,salesAl.get(i).getMenuName(),
					salesAl.get(i).getTotalSalesCount(),salesAl.get(i).getTotalSalesPrice()});
		}
	}

	public void comInit() {
		JPanel titlePanel = new JPanel();
		JPanel tablePanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		titlePanel.setSize(350,60);
		titlePanel.setLocation(50,20);
		titlePanel.setBackground(new Color(130,230,130));
		tablePanel.setSize(900,570);
		tablePanel.setLocation(50,100);
		tablePanel.setBackground(new Color(130,230,130));
		buttonPanel.setSize(900,200);
		buttonPanel.setLocation(50,670);
		buttonPanel.setBackground(new Color(130,230,130));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		salesTable.getTableHeader().setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		salesTable.setRowHeight(50);

		salesTable.getColumn("No.").setPreferredWidth(10);
		salesTable.getColumn("No.").setCellRenderer(celAlignRight);
		salesTable.getColumn("Á¦Ç°¸í").setPreferredWidth(250);
		salesTable.getColumn("Á¦Ç°¸í").setCellRenderer(celAlignRight);
		salesTable.getColumn("ÃÑ ÆÇ¸Å ¼ö·®").setPreferredWidth(250);
		salesTable.getColumn("ÃÑ ÆÇ¸Å ¼ö·®").setCellRenderer(celAlignRight);
		salesTable.getColumn("ÃÑ ¸ÅÃâ¾×").setPreferredWidth(250);
		salesTable.getColumn("ÃÑ ¸ÅÃâ¾×").setCellRenderer(celAlignRight);
		salesTable.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		JScrollPane scrollpane = new JScrollPane(salesTable);

		scrollpane.setPreferredSize(new Dimension(900,550));

		titleLabel.setFont(new Font("±¼¸²",Font.BOLD,50));

		backButton.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,17));
		backButton.addActionListener(this);

		titlePanel.add(titleLabel);
		tablePanel.add(scrollpane);
		buttonPanel.add(backButton);
		this.add(titlePanel);
		this.add(tablePanel);
		this.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			orderList.clear();
			mainPanel.remove(7);
			SalesView sv = new SalesView(mainPanel);
			mainPanel.add(sv,"sales",7);

			((CardLayout)mainPanel.getLayout()).show(mainPanel,"admin");
		}
	}


}
