package dabang.client.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SalesView extends JPanel implements ActionListener {
	private JPanel mainPanel = null;
	private String header[] = {"No.","Á¦Ç°¸í","ÃÑ ÆÇ¸Å ¼ö·®","ÃÑ ¸ÅÃâ¾×"};
	private String contents[][] = new String[3][4];
	private JTable salesTable = null;
	private JLabel titleLabel = new JLabel("¸ÅÃâ °ü¸®",JLabel.CENTER);
	private JButton backButton = new JButton("µÚ·Î°¡±â");
	
	public SalesView(JPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.setSize(1000,800);
		this.setLayout(null);
		comInit();
		this.setBackground(new Color(130,230,130));
	}
	
	public void comInit() {
		
		for(int i=0;i<3;i++) {
			contents[i][0] = Integer.toString(i+1);
			contents[i][1] = "goodsName";
			contents[i][2] = "salesCount";
			contents[i][3] = "salesMoney";
		}
		
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
		
		salesTable = new JTable(contents,header);
//		salesTable.setBackground(new Color(255,255,204));
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
//		titleLabel.setForeground(new Color(170,160,70));
		
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
			mainPanel.remove(5);
			ManagerGui mg = new ManagerGui(mainPanel); 
			mainPanel.add(mg,"admin",5);
			((CardLayout)mainPanel.getLayout()).show(mainPanel,"admin");
		}
	}
	
	
}
