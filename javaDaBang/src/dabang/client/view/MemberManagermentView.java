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
	private JPanel titlepanel = new JPanel();//간판
	private JLabel label1 = new JLabel("회원관리");//타이틀에 할말
	private JLabel notice = new JLabel("(양력or음력 수정은 1번양력 2번음력)    (아이디,성별,등급,포인트 수정불가)    (수정은 수정할곳 클릭후 밑에 쓰고 수정클릭)");//타이틀에 할말
	private JPanel buttonpanel = new JPanel();//버튼넣은패널
	private JPanel noticepanel = new JPanel();//공지사항패널
	private JButton button1 = new JButton("수정");
	private JButton diabutton1 = new JButton("확인");
	private JButton diaexitbutton = new JButton("취소");
	private JButton deletebutton = new JButton("삭제");
	private JButton exitbutton = new JButton("나가기");
	private JPanel fix = new JPanel();//수정창 패널
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
	private JLabel fixlabel = new JLabel("수정할 내용을 입력해주세요ㅕ : ");
	private MemberController memC = new MemberController();
	private JTextField fixtextfield = new JTextField(20);
	
	private MemberController mCon = new MemberController();

	public MemberManagermentView() //메인 창 
	{
		super("회원관리"); //이름설정
		this.setSize(1000,560); //프레임 사이즈
		this.setLocationRelativeTo(null); //화면 가운데로 위치설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //종료버튼시 아예다꺼버림
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.compInit(); //사용자 정의 메소드
		this.setVisible(true); //가시적으로 보여주어라
	}
	private void compInit() //실행가즈아
	{   
		picture();
		title();
		table();
		noticelabel();
		fixlabel();
		button();
	}
	private void picture() //타이틀 위에 사진넣기
	{
		picup = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
	}
	private void title()//타이틀패널
	{
		
		label1.setIcon(picup); //사진(아직없음)
		titlepanel.setBackground(Color.yellow);//바탕
		titlepanel.add(label1);//글한마디  ㅎ 
		titlepanel.setPreferredSize(new Dimension(1000,100));//창크기

		this.add(titlepanel);//추가 가즈아    

		this.add(titlepanel);//추가 가즈아    

	}
	private void button()//밑에 버튼2개
	{
		buttonpanel.setBackground(Color.white);
		button1.addActionListener(this);//액션추가
		button1.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(button1);
		deletebutton.addActionListener(this);//액션추가
		deletebutton.setPreferredSize(new Dimension(330, 70));
		buttonpanel.add(deletebutton);
		exitbutton.addActionListener(this);//액션추가
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

	private void fixlabel()//수정창
	{
		fix.setPreferredSize(new Dimension(1000,40));
		fix.setBackground(Color.yellow);
		fix.add(fixlabel);//수정라벨
		fix.add(fixtextfield);//수정tf
		diabutton1.addActionListener(this);
		diaexitbutton.addActionListener(this);
		this.add(fix);
	}
	private void table()//가운데 표
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
		//안녕하세요

		for(int i=0;i<data.length;i++) //불러오는거
		{
			data[i][0]  =testMem.get(i).getId();//아이디
			data[i][1]  =testMem.get(i).getNickName();//별명
			data[i][2]  =testMem.get(i).getName();//이름
			if(testMem.get(i).getSclc() == 1) {   //1 양력일시
				data[i][3]  ="양력";
			}
			else if(testMem.get(i).getSclc() == 2) { //2 음력일시
				data[i][3]  ="음력";
			}   
			data[i][4]  =testMem.get(i).getAgeY();//연도
			data[i][5]  =testMem.get(i).getAgeM();//월
			data[i][6]  =testMem.get(i).getAgeD();//일
			data[i][7]  =testMem.get(i).getGender();//성별
			data[i][8]  =testMem.get(i).getPhoneNumber();//폰번
			data[i][9]  =testMem.get(i).getGrade();//등급
			data[i][10] =testMem.get(i).getPoint();//포인토                        

			String[] columnName = {"아이디","별명","이름","양력","년도","월","일","성별","PH","등급","포인트"};//제목
			table = new JTable(model);
			model = new DefaultTableModel(data, columnName) 
			{
				public boolean isCellEditable(int rowlndex,int mCollnDex) {return false;}};//수정불가코드
		}
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);//아이디칸크기
		table.getColumnModel().getColumn(1).setPreferredWidth(100);//별명칸
		table.getColumnModel().getColumn(2).setPreferredWidth(70);//이름칸
		table.getColumnModel().getColumn(3).setPreferredWidth(30);//양력칸
		table.getColumnModel().getColumn(4).setPreferredWidth(30);//연도칸
		table.getColumnModel().getColumn(5).setPreferredWidth(30);//월칸
		table.getColumnModel().getColumn(6).setPreferredWidth(30);//일칸
		table.getColumnModel().getColumn(7).setPreferredWidth(30);//성별칸
		table.getColumnModel().getColumn(8).setPreferredWidth(200);//폰번칸
		table.getColumnModel().getColumn(9).setPreferredWidth(70);//등급칸
		table.getColumnModel().getColumn(10).setPreferredWidth(100);//포인트칸크기
		table.getTableHeader().setReorderingAllowed(false);//이동막기
		table.getTableHeader().setResizingAllowed(false);//크기조절막기
		scroll = new JScrollPane (table);//스크롤에 테이블넣음
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1000, 230));//스크롤크기
		add(scroll);//추가함      
	}   
	///////////////////////////////////////////////////////////////////////////////////////////

	public void DelData()//////삭제
	{
		int yes_no_select = JOptionPane.showConfirmDialog(null, 
				"정말 삭제하겠습니까?", "삭제 확인 창", JOptionPane.YES_NO_CANCEL_OPTION);
		if(yes_no_select==JOptionPane.YES_OPTION)
		{
			////////////////////////////////////////////////////////////////
	   		
            Member m = new Member();
			mCon.loadMember();//불러옴
			int deleteRow = table.getSelectedRow(); //클릭한줄 선택
			System.out.println((String)table.getValueAt(deleteRow, 0));
			mCon.memberDelete((String)table.getValueAt(deleteRow, 0));
			model.removeRow(deleteRow);//행삭제
            mCon.saveMember();//저장
			
			////////////////////////////////////////////////////////////////
		}
	}
	private void westyes()//수정창
	{
		int yes_no_select = JOptionPane.showConfirmDialog(null, 
				"정말 수정하십니까?", "관리자", JOptionPane.YES_NO_CANCEL_OPTION     );
		if(yes_no_select==JOptionPane.YES_OPTION)
		{
			//////////////////////////////////////////////////////수정로직   
			Member m = new Member();
			int rowIdx = table.getSelectedRow(); //선택행
			int colIdx = table.getSelectedColumn();//선택열
			table.setValueAt(fixtextfield.getText(), rowIdx, colIdx);//수정한거 눈에보임
            //"아이디","별명","이름","양력","년도","월","일","성별","PH","등급","포인트"
			mCon.loadMember(); //멤버로드
			m = mCon.memberSelect((String)table.getValueAt(rowIdx,0));
			switch(colIdx) 
			{
			//0 아이디수정 x
			case 1: m.setNickName(fixtextfield.getText());break;//별명
			case 2: m.setName(fixtextfield.getText());break;//이름
			case 3: m.setSclc(Integer.valueOf(fixtextfield.getText()));break;//양력
			case 4: m.setAgeY(Integer.valueOf(fixtextfield.getText()));break;//연
			case 5: m.setAgeM(Integer.valueOf(fixtextfield.getText()));break;//월
			case 6: m.setAgeD(Integer.valueOf(fixtextfield.getText()));break;//일
			//7 성별수정x
			case 8: m.setPhoneNumber(fixtextfield.getText());break;//폰번
			//9 등급수정x
			//10 포인트수정x
            default:
  JOptionPane.showMessageDialog(null, "수정이 불가능한 항목입니다", "관리자", JOptionPane.ERROR_MESSAGE);
			}
			mCon.memberModify(m);
			mCon.saveMember();
			//setValueAt(가져올 위치, 행, 열)
			//////////////////////////////////////////////////////수정로직끝
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)//수정창누를시
		{
			westyes();
		}
		if(e.getSource()==deletebutton)//삭제버튼누를시
		{
			DelData();
		}
		if(e.getSource()==exitbutton)//관리창나가기
		{
			this.dispose();
		}
	}
	/////////////////////////////////////////////// 되는지 실험하는곳 
}