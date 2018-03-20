package dabang.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dabang.client.controller.MemberController;
import dabang.client.controller.OrderCon;
import dabang.client.model.Member;
import dabang.client.model.Menu;
import dabang.client.model.MenuDrink;

public class GuiMember extends JPanel implements ActionListener {

	private MemberController mc = new MemberController();

	private JPanel membergrade = new JPanel();
	private JPanel membervisit = new JPanel();
	private JPanel managebutton = new JPanel();
	private JPanel backmain = new JPanel();

	private JButton menageinforbutton = new JButton("나의 정보 관리");
	private JButton receiptbutton = new JButton("영수증");
	private JButton backmainbutton = new JButton("뒤로가기");

	private ImageIcon welcome = new ImageIcon("Image/MyInforImage/welcomelevel.jpg");
	//	private ImageIcon welcome = new ImageIcon("Image/MyInforImage/welcomelevel.jpg");
	private JLabel welcomelabel = new JLabel(welcome);
	private ImageIcon star = new ImageIcon("Image/MyInforImage/star.png");
	private JLabel starlabel = new JLabel(star);

	private JLabel countvisit = new JLabel("나의 방문 횟수 ");
	private JLabel countLabel;


	private JPanel mainPanel = null;
	private Member accessMember = new Member();
	private MemberController mCon = new MemberController();
	
	public void membergrade () {
		
		membergrade.setSize(396,490);
		membergrade.setLocation(0,0);
		membergrade.setBackground(Color.WHITE);
		
		membergrade.setLayout(new BorderLayout());
		membergrade.add(welcomelabel);
		membergrade.add(welcomelabel,BorderLayout.CENTER);
		
		if(!accessMember.getId().equals("0")) //회원일 때
		{

			mCon.loadMember();
			
			if(0 <= mCon.memberSelect(accessMember.getId()).getVisitCount() &&
					mCon.memberSelect(accessMember.getId()).getVisitCount() < 2)
			{
				welcome = new ImageIcon("Image/MyInforImage/welcomelevel.jpg");
			}
			else if (2 <= mCon.memberSelect(accessMember.getId()).getVisitCount() &&
					mCon.memberSelect(accessMember.getId()).getVisitCount() <4)
			{
				welcome = new ImageIcon("Image/MyInforImage/greenlevel.jpg");
			}
			else if(4 <= mCon.memberSelect(accessMember.getId()).getVisitCount())
			{
				welcome = new ImageIcon("Image/MyInforImage/goldlevel.jpg");
			}
		}
		welcomelabel.setIcon(welcome);
		
		this.add(membergrade);
	}

	public void membervisit () {
		membervisit.setSize(596, 490);
		membervisit.setLocation(396, 0);
		membervisit.add(starlabel);
		membervisit.setLayout(new BorderLayout());
		membervisit.add(starlabel,BorderLayout.CENTER);
		
		
		starlabel.add(countvisit);
		countvisit.setFont(new Font("Serif",Font.BOLD,17));
		countvisit.setBounds(100, 60, 145, 30);
		if(!accessMember.getId().equals("0")) //회원일 때
		{

			mCon.loadMember();
			countLabel = new JLabel(Integer.toString(mCon.memberSelect(accessMember.getId()).getVisitCount()));

		}

		else if(accessMember.getId().equals("0")) //비회원일때
		{
			countLabel = new JLabel(Integer.toString(0));
		}

		countLabel.setFont(new Font("Serif",Font.BOLD,100));
		starlabel.add(countLabel);
		countLabel.setBounds(277, 140, 100, 100);
		this.add(membervisit);
	}

	public void managebutton () {
		managebutton.setSize(992, 275);
		managebutton.setLocation(0,490);
		this.add(managebutton);
		managebutton.setLayout(new GridLayout(2,1));
		JPanel managebutton01 = new JPanel();
		JPanel managebutton02 = new JPanel();
		managebutton.add(managebutton01);
		managebutton.add(managebutton02);
		managebutton01.setLayout(new GridLayout(1,2));
		JPanel myinformanage = new JPanel();
		JPanel myreceipt = new JPanel();
		managebutton01.add(myinformanage);
		managebutton01.add(myreceipt);
		myinformanage.add(menageinforbutton);
		myinformanage.setLayout(new BorderLayout());
		myinformanage.add(menageinforbutton,BorderLayout.CENTER);
		menageinforbutton.setFont(new Font("Serif",Font.BOLD,30));
		menageinforbutton.addActionListener(this);

		myreceipt.add(receiptbutton);
		myreceipt.setLayout(new BorderLayout());
		myreceipt.add(receiptbutton,BorderLayout.CENTER);
		receiptbutton.setFont(new Font("Serif",Font.BOLD,30));
		receiptbutton.addActionListener(this);
		
		managebutton02.add(backmainbutton);
		managebutton02.setLayout(new BorderLayout());
		managebutton02.add(backmainbutton,BorderLayout.CENTER);
		backmainbutton.setFont(new Font("Serif",Font.BOLD,30));
		backmainbutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menageinforbutton) {
			mainPanel.remove(4);
			GuiMember gm = new GuiMember(mainPanel,accessMember);
			mainPanel.add(gm,"member",4);
			mainPanel.remove(6);
			GuiPersonalInfor gpi = new GuiPersonalInfor(mainPanel,accessMember);
			mainPanel.add(gpi,"PersonalInfor",6);
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "PersonalInfor");
		}else if(e.getSource()==receiptbutton) {
			OrderCon oCon = new OrderCon();
			oCon.loadOrder();
			ArrayList al = oCon.selectOrder(accessMember.getId());
			
			if(al==null) {
				JOptionPane.showMessageDialog(null, "주문 내역이 없습니다.");
			} else {
				mainPanel.remove(14);
				ReceiptView rv = new ReceiptView(mainPanel,accessMember);
				mainPanel.add(rv,"receipt",14);
				((CardLayout)mainPanel.getLayout()).show(mainPanel, "receipt");
			}
		}else if(e.getSource()==backmainbutton) {
			mainPanel.remove(1);
			JFrame mainFrame = new JFrame();
			ArrayList<Menu> orderAl= new ArrayList<Menu>();
			MenuDrink md = new MenuDrink();
			memberMainView mmv = new memberMainView(mainPanel, mainFrame,orderAl,md,accessMember);
			mainPanel.add(mmv,"memberMain",1);
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "memberMain");
		}

	}

	private void comInit() {
		membergrade();
		membervisit();
		managebutton();
	}

	public GuiMember (JPanel mainPanel, Member accessMember) {

		this.setSize(1000,800);
		this.setLayout(null);
		this.mainPanel = mainPanel;
		this.accessMember = accessMember;
		this.comInit();
		this.setVisible(true);
	}

}
