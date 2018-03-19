package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dabang.client.controller.MenuManageControl;
import dabang.client.model.MenuManage;



public class GuiDeletemenu extends JPanel implements ActionListener{
	
	private JPanel p1 = new JPanel();
	private JLabel addmenutitle = new JLabel("  �޴� ����");
	private JPanel p2 = new JPanel();
	private JLabel deletemenunamelabel = new JLabel("   ������ �޴���");
	private JTextField tddletemenu = new JTextField(25);
	private JPanel p3 = new JPanel();
	private JButton deletesave = new JButton("�����ϱ�");
	private JButton deletecancel = new JButton("����ϱ�");
	
	private JPanel myPanel = this;
	private JPanel mainPanel = null;
	
	MenuManageControl menuCon = new MenuManageControl();
	MenuManage deletemenu= new MenuManage();;
	
	public void p1 () { //����
		p1.setSize(980,90);
		p1.setLocation(0,0);
		//p1.setBackground(Color.red);
		this.add(p1);
		p1.add(addmenutitle);
		addmenutitle.setFont(new Font("Serif",Font.BOLD,34));
		p1.setLayout(new BorderLayout());
		p1.add(addmenutitle,BorderLayout.WEST);
	}
	
	public void p2 () { //�޴�����
		p2.setSize(980,570);
		p2.setLocation(0,90);
		//p2.setBackground(Color.blue);
		this.add(p2);
		
		p2.setLayout(new GridLayout(2,1));
		JPanel p21 = new JPanel();
		JPanel p22 = new JPanel();
		p2.add(p21);
		p2.add(p22);
		
		p21.add(deletemenunamelabel);
		deletemenunamelabel.setFont(new Font("Serif",Font.BOLD,34));
		p21.setLayout(new BorderLayout());
		p21.add(deletemenunamelabel,BorderLayout.CENTER);
		
		p22.add(tddletemenu);
		tddletemenu.setFont(new Font("Serif",Font.BOLD,34));
		p22.setLayout(new BorderLayout());
		p22.add(tddletemenu,BorderLayout.WEST);
	}
	
	public void p3 () { //�����ϱ�,����ϱ�
		p3.setSize(980,90);
		p3.setLocation(0,660);
		//p3.setBackground(Color.red);
		this.add(p3);
		
		p3.setLayout(new GridLayout(1,2));
		JPanel p31 = new JPanel();
		JPanel p32 = new JPanel();
		p3.add(p31);
		p3.add(p32);
		
		p31.add(deletesave);
		p31.setLayout(new BorderLayout());
		p31.add(deletesave,BorderLayout.CENTER);
		deletesave.setFont(new Font("Serif",Font.BOLD,30));
		deletesave.addActionListener(this);
		
		p32.add(deletecancel);
		p32.setLayout(new BorderLayout());
		p32.add(deletecancel,BorderLayout.CENTER);
		deletecancel.setFont(new Font("Serif",Font.BOLD,30));
		deletecancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deletesave) {
//			menuCon.menuPlus(new MenuManage("�Ƹ�",200));
			if(menuCon.menuDelete(tddletemenu.getText())) { //�޴����� �Ϸ�
				JOptionPane.showMessageDialog(this, "�޴� ������ �Ǿ����ϴ�", "�����Ϸ�", JOptionPane.INFORMATION_MESSAGE);
			}else { //�޴����� ����
				JOptionPane.showMessageDialog(this, "������ �޴��� �����ϴ�. �޴����� Ȯ�� ���ּ���.", "��������", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==deletecancel) {
			
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "ManegeMenu");
		}
	}
	
	private void comInit() {
		p1();
		p2();
		p3();
	}
	
	public GuiDeletemenu (JPanel mainPanel) {
		this.setSize(1000,800);
		this.setLayout(null);
		this.comInit();
		this.setVisible(true);
		this.mainPanel  = mainPanel;
	}

}
