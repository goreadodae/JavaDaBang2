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

import javax.swing.DefaultCellEditor;
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

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import dabang.client.controller.LoginController;
import dabang.client.controller.MemberController;
public class MemberManagermentView extends JFrame implements ActionListener{
   private JPanel titlepanel = new JPanel();//간판
   private JLabel label1 = new JLabel("회원관리");//타이틀에 할말
   private JPanel buttonpanel = new JPanel();//버튼넣은패널
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
   private Object [][] data = new Object[10][11];
   private Member testMem [] = new Member[11];
   int updateRow;
   private JLabel labelid = new JLabel("수정할 내용 ^ㅅ^");
   private MemberController memC = new MemberController();







   private JTextField labelidf = new JTextField(20);

   public MemberManagermentView() //메인 창 
   {
      super("회원관리"); //이름설정
      this.setSize(1000,500); //프레임 사이즈
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
      fixlabel();
      button();
   }
   private void picture() //타이틀 위에 사진넣기
   {
      picup = new ImageIcon(new ImageIcon("400x1222.jpg").getImage().getScaledInstance(1000,130,Image.SCALE_DEFAULT));
   }
   private void title()//타이틀패널
   {
      //setborder(new TitledBorder(new LineBorder(Color.MAGENTA,2),"입력"));
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

   private void fixlabel()//수정창
   {
      fix.setPreferredSize(new Dimension(1000,40));
      fix.setBackground(Color.yellow);
      fix.add(labelid);//수정라벨
      fix.add(labelidf);//수정tf
      diabutton1.addActionListener(this);
      diaexitbutton.addActionListener(this);
      this.add(fix);
   }
   private void table()//가운데 표
   {
      testMem[0] = new Member("topama2","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[1] = new Member("topama3","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[2] = new Member("topama4","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[3] = new Member("topama5","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[4] = new Member("topama6","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[5] = new Member("topama7","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[6] = new Member("topama8","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[7] = new Member("topama9","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[8] = new Member("topama10","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );
      testMem[9] = new Member("topama11","주멘" ,"김지섭", 1, 92, 02, 05, '남', "010-7730-1344","vip",100 );


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

      for(int i=0;i<data.length;i++) //불러오는거
      {
         data[i][0] =testMem[i].getId();//아이디
         data[i][1] =testMem[i].getNickName();//별명
         data[i][2] =testMem[i].getName();//이름
         data[i][3] =testMem[i].getSclc();//양/음
         data[i][4] =testMem[i].getAgeY();//연도
         data[i][5] =testMem[i].getAgeM();//월
         data[i][6] =testMem[i].getAgeD();//일
         data[i][7] =testMem[i].getGender();//성별
         data[i][8] =testMem[i].getPhoneNumber();//폰번
         data[i][9] =testMem[i].getGrade();//등급
         data[i][10] =testMem[i].getPoint();//포인토                        

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
      /*DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel CellModel = table.getColumnModel();
        for(int i=0;i<CellModel.getColumnCount();i++){
            CellModel.getColumn(i).setCellRenderer(tableCell);
         }*/

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
        /*  
         JTable tb = memC.memberDelete();
             int deleteRow = tb.getSelectedRow();
             if(deleteRow == -1) return;
             else {
                   DefaultTableModel model = (DefaultTableModel) tb.getModel();
                  model.removeRow(deleteRow);
             }
             */
         int deleteRow = table.getSelectedRow(); //클릭한줄 선택
         model.removeRow(deleteRow);
   ////////////////////////////////////////////////////////////////
      }
   }
   private void westyes()//수정창
   {

      int yes_no_select = JOptionPane.showConfirmDialog(null, 
            "정말 수정하세연?", "★★★★★마지막 기회★★★★★", JOptionPane.YES_NO_CANCEL_OPTION     );
      if(yes_no_select==JOptionPane.YES_OPTION){
         //////////////////////////////////////////////////////수정로직   
         int rowIdx = table.getSelectedRow(); //선택행
         int colIdx = table.getSelectedColumn();//선택열
         table.setValueAt(labelidf.getText(), rowIdx, colIdx);//수정
         //setValueAt(가져올 위치, 행, 열)
         //////////////////////////////////////////////////////수정로직끝
      }
   }
   //showtable.table.setValueAt(west.tf[1].getText(), updateRow, 12);   
   //////////////////////////////////////////////////////////////////////////////

   //showtable.table.setValueAt(west.tf[1].getText(), updateRow, 12);   

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
      if(e.getSource()==diabutton1)//수정가즈아
      {
         this.westyes();
         // dialog.tf[0].setText(" ");
         dialog.dispose();
      }
      if(e.getSource()==diaexitbutton)//수정창에서나가기
      {
         dialog.dispose();
      }
   }
   /////////////////////////////////////////////// 되는지 실험하는곳 
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