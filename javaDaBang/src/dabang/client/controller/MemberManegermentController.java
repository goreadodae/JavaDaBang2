package dabang.client.controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MemberManegermentController extends JFrame{
     //내부 클래스 객체 생성
     West west = new West(); 
     Buttons buttons = new Buttons();
     ShowTable showtable = new ShowTable();
     
     int updateRow; //전역변수 선언
     
     //생성자 구현
   
     
     //West 내부 클래스 구현
     class West extends JPanel{ //왼쪽 담당하는 애들이 또 나뉘어서 붙여야 하므로, JPanel
           //필드 선언 - 레이블하고 텍스트 필드가 필요하다.
           JLabel la;
           JTextField tf[]; 
           
           //화면 구성
           public West(){
                //보더 만들기
                //------------
                setBorder(new TitledBorder(new LineBorder(Color.MAGENTA,2),"입력"));
                String text[] = {"이     름", "핸드폰 번호","주민등록번호"};
                tf = new JTextField[3];
                setLayout(new GridLayout(3,2,5,10)); //GridLayout(행,열,행간격,열간격)
                
                for(int i=0;i<text.length;i++){
                     la = new JLabel(text[i]);
                     tf[i]= new JTextField(20);
                     la.setHorizontalAlignment(JLabel.CENTER); 
                     //수평 정렬을 어떻게 할 것인가 - JLabel이 가지고 있는 상수가 CENTER
                     add(la); add(tf[i]);
                }
                setPreferredSize(new Dimension(230,300)); 
                //Dimension = 크기, 치수 -> 부분적인 크기를 정할 때 사용. 최상위는 setSize();
           }
     }
     
     //Buttons 내부 클래스 구현
     class Buttons extends JPanel implements ActionListener{ 
    //부분적인 패널 SOUTH에 또 만들어야 하므로 JPanel
           //필드 선언
           Vector<String> vector; //객체 저장소
           JButton addBtn, updateBtn, delBtn;
           String juminNo;
           
           public Buttons(){
                setLayout(new GridLayout(1, 3));
                addBtn = new JButton("추가");
                updateBtn = new JButton("수정");
                delBtn = new JButton("삭제");
                
                addBtn.setBackground(Color.YELLOW);
                updateBtn.setBackground(Color.PINK);
                delBtn.setBackground(Color.ORANGE);
                
                add(addBtn); add(updateBtn); add(delBtn);
                addBtn.addActionListener(this);
                updateBtn.addActionListener(this);
                delBtn.addActionListener(this);
 
           }
 
           @Override
           public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("추가")) //코맨드를 받아오는 메소드
                     AddData();
                else if(e.getActionCommand().equals("수정")) 
                     UpdateData();
                else if(e.getActionCommand().equals("삭제"))
                     DelData();
           }
           
           //사용자 정의 메소드
           public void AddData(){
                Vector<String> vector = new Vector<String>();
                vector.add(west.tf[0].getText()); //버튼 누르면 이름 필드 받아다가 벡터에 저장시켜라. 
                vector.add(west.tf[1].getText());
                //vector.add(west.tf[2].getText()); 
                //vector에 저장하기 전에, 주민번호는 체크해서 저장해야 함. 
                
                juminNo = west.tf[2].getText();
                
                String regex = "[0-9]{6}-[0-9]{7}"; 
                //{ }는 반복, 숫자 여섯, 일곱자리를 반복하는데, 0~9사이의 숫자 - 하이픈 포함.
                //boolean check = juminNo.matches(regex); 
                //String 클래스에 matches()메소드가 있다.
                boolean check = Pattern.matches(regex, juminNo);
                
                if(check==false){
                     JOptionPane.showMessageDialog(null, 
                                "주민번호가 형식에 맞지 않음!", 
                                "삐용삐용 경고", JOptionPane.ERROR_MESSAGE);
                     west.tf[2].setText(null);
                     west.tf[2].requestFocus(); 
                     //포커스 거기다 맞추고, 그 상태 그대로 있어라~'다시 입력'
                     return;
                } //end if
                
                int [] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5}; //가중치
                int sum = 0;
                
                for(int i=0;i<13;i++){
                     if(juminNo.charAt(i)=='-') continue;
                     sum +=((juminNo.charAt(i)-48)*weight[i]);
                }
 
                int temp = 11-(sum%11);
                int result = temp%10;
                
                if(result==(juminNo.charAt(13)-48)){  //올바른 주민번호일 경우 
                     JOptionPane.showMessageDialog(null, "주민번호 Check결과 정상입니다.");
                     vector.add(west.tf[2].getText());
 
                }
                else{
                     JOptionPane.showMessageDialog(null,"올바른 주민번호가 아닙니다.",
                                "주민번호를 다시 입력하세요.",JOptionPane.ERROR_MESSAGE);
                     return;
                }
                west.tf[2].setText(null);
                west.tf[2].requestFocus(); 
           //vector에 있는 값을 Vector<Vector<String>> data에 집어 넣기 - 1사람꺼 벡터에 들어간 것.
                showtable.data.addElement(vector);
                /*중요 => vector에 있는 내용(data 백터에 저장된 데이터들)을 
                 datamodel의 JTable에 보여주기 !
                 데이터가 변화된 후 변경사항(추가/수정/삭제)을 JTable에 알려주어야 하는데
                 fireTableDataChanged()메소드를 호출하면 된다.*/ 
               showtable.datamodel.fireTableDataChanged();
           }
           //"수정"이벤트 처리
           public void UpdateData(){
                updateRow = showtable.table.getSelectedRow();
                //주민번호 수정 못하게 하는 방법
                
                //핸드폰 수정
           showtable.table.setValueAt(west.tf[1].getText(), updateRow, 1); //setValueAt(가져올 위치, 행, 열)
                //west.tf[2].setEnabled(true);
           }
           
           //"삭제"이벤트 처리
           public void DelData(){
                int yes_no_select = JOptionPane.showConfirmDialog(null, 
                           "정말 삭제하겠습니까?", "삭제 확인 창", JOptionPane.YES_NO_CANCEL_OPTION     );
                
                if(yes_no_select==JOptionPane.YES_OPTION){
                     JTable tb = showtable.table;
                     int deleteRow = tb.getSelectedRow();
                     if(deleteRow == -1) return;
                     else {
                           DefaultTableModel model = (DefaultTableModel) tb.getModel();
                          model.removeRow(deleteRow);
                           
                          west.tf[0].setText(null);
                          west.tf[1].setText(null);
                          west.tf[2].setText(null);
                           //꼭~~처리! 막아놓은 창 풀어주기
                          west.tf[2].setEnabled(true);
                          west.tf[0].requestFocus(); //포커스 1번 텍스트 창에 !
                     }
                }
                else return;
                     
           }
     }
     
     class ShowTable extends MouseAdapter{
           DefaultTableModel datamodel;
           JTable table;
           JScrollPane scrollPane;
           String colName[]={"이름","핸드폰번호","주민번호"};
           
     //========================※중요※========================
           //DefaultTableModel(Vector data, Vector columnNames) 생성자
           Vector<Vector<String>> data; 
           Vector<String> column_name;
           
           //벡터 안에 벡터를 담는 것. 10개 방 안에, 첫째 방에도 10개의 방을 담는 것. 
           /*Vector<String> vec = new Vector<String>(); 이면, 
            ()안에는 기본적으로 10,10이 되어 있음. 
10개 저장 가능하고, 부족하면 10개가 자동으로 늘어난다. */
           
//[파일]메뉴의 열기, 저장 작업시 Vector의 데이터를 활용한다. →즉, 중간 저장소 역할     
           public ShowTable(){
                data = new Vector<Vector<String>>();
                column_name = new Vector<String>();
           //나중에 데이터 저장해서 불러오고 할 수 있어야 한다. 열기-저장을 Vector를 통해서 해야 한다.
                
                for(int i=0;i<colName.length;i++){
                     column_name.add(colName[i]);
                }
                
                datamodel = new DefaultTableModel(data,column_name);
                table = new JTable (datamodel);
                scrollPane = new JScrollPane(table);
                
                //이벤트 연결
                table.addMouseListener(this); 
                //마우스 이벤트는 마우스리스너
                //사용자 정의 메소드 호출
                TableSize();
           }
     //JTable의 셀 크기 변경 및 셀 데이터 값 중앙 정렬 시키는 메소드
           public void TableSize(){
           table.getColumnModel().getColumn(0).setPreferredWidth(50); //이름 셀
           table.getColumnModel().getColumn(1).setPreferredWidth(70); //전화번호 셀
           table.getColumnModel().getColumn(2).setPreferredWidth(120); //주민번호 셀
                
           DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
           tableCell.setHorizontalAlignment(SwingConstants.CENTER);
           TableColumnModel CellModel = table.getColumnModel();
                
            for(int i=0;i<CellModel.getColumnCount();i++){
                CellModel.getColumn(i).setCellRenderer(tableCell);
             }
        }
     //수동으로 오버라이드하는 방법 : MouseClicked()만 필요하므로
           @Override
           public void mouseClicked(java.awt.event.MouseEvent e) {
                updateRow = table.getSelectedRow(); //선택한 행을 얻어오는 메소드
                //선택하면 JTextField에 뿌려주어야 한다.
                west.tf[0].setText((String) showtable.table.getValueAt(updateRow, 0));
                west.tf[1].setText((String) showtable.table.getValueAt(updateRow, 1));
                west.tf[2].setText((String) showtable.table.getValueAt(updateRow, 2));
                /*west에 tf0이 "이   름" 텍스트 박스니까... 여기를 set하는건데 어떻게 set하냐면.. 
                 showtable에 있는 datamodel을 담고있는 JTable(table)에서 값을 얻어오는데,
                 updateRow는 선택한 행!, 여기서 0, 1, 2번째 열의 순서대로 text값을 얻어와서 
                 String으로 변환해서 set해라! */
                west.tf[2].setEditable(false); 
                // TextField에 있는 데이타들을 수정하지 못하도록/글자쓰기 금지(주민번호 수정 X)
           }
    }
     
   
}