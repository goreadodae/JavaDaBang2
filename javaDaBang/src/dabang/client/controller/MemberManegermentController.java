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
     //���� Ŭ���� ��ü ����
     West west = new West(); 
     Buttons buttons = new Buttons();
     ShowTable showtable = new ShowTable();
     
     int updateRow; //�������� ����
     
     //������ ����
   
     
     //West ���� Ŭ���� ����
     class West extends JPanel{ //���� ����ϴ� �ֵ��� �� ����� �ٿ��� �ϹǷ�, JPanel
           //�ʵ� ���� - ���̺��ϰ� �ؽ�Ʈ �ʵ尡 �ʿ��ϴ�.
           JLabel la;
           JTextField tf[]; 
           
           //ȭ�� ����
           public West(){
                //���� �����
                //------------
                setBorder(new TitledBorder(new LineBorder(Color.MAGENTA,2),"�Է�"));
                String text[] = {"��     ��", "�ڵ��� ��ȣ","�ֹε�Ϲ�ȣ"};
                tf = new JTextField[3];
                setLayout(new GridLayout(3,2,5,10)); //GridLayout(��,��,�ణ��,������)
                
                for(int i=0;i<text.length;i++){
                     la = new JLabel(text[i]);
                     tf[i]= new JTextField(20);
                     la.setHorizontalAlignment(JLabel.CENTER); 
                     //���� ������ ��� �� ���ΰ� - JLabel�� ������ �ִ� ����� CENTER
                     add(la); add(tf[i]);
                }
                setPreferredSize(new Dimension(230,300)); 
                //Dimension = ũ��, ġ�� -> �κ����� ũ�⸦ ���� �� ���. �ֻ����� setSize();
           }
     }
     
     //Buttons ���� Ŭ���� ����
     class Buttons extends JPanel implements ActionListener{ 
    //�κ����� �г� SOUTH�� �� ������ �ϹǷ� JPanel
           //�ʵ� ����
           Vector<String> vector; //��ü �����
           JButton addBtn, updateBtn, delBtn;
           String juminNo;
           
           public Buttons(){
                setLayout(new GridLayout(1, 3));
                addBtn = new JButton("�߰�");
                updateBtn = new JButton("����");
                delBtn = new JButton("����");
                
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
                if(e.getActionCommand().equals("�߰�")) //�ڸǵ带 �޾ƿ��� �޼ҵ�
                     AddData();
                else if(e.getActionCommand().equals("����")) 
                     UpdateData();
                else if(e.getActionCommand().equals("����"))
                     DelData();
           }
           
           //����� ���� �޼ҵ�
           public void AddData(){
                Vector<String> vector = new Vector<String>();
                vector.add(west.tf[0].getText()); //��ư ������ �̸� �ʵ� �޾ƴٰ� ���Ϳ� ������Ѷ�. 
                vector.add(west.tf[1].getText());
                //vector.add(west.tf[2].getText()); 
                //vector�� �����ϱ� ����, �ֹι�ȣ�� üũ�ؼ� �����ؾ� ��. 
                
                juminNo = west.tf[2].getText();
                
                String regex = "[0-9]{6}-[0-9]{7}"; 
                //{ }�� �ݺ�, ���� ����, �ϰ��ڸ��� �ݺ��ϴµ�, 0~9������ ���� - ������ ����.
                //boolean check = juminNo.matches(regex); 
                //String Ŭ������ matches()�޼ҵ尡 �ִ�.
                boolean check = Pattern.matches(regex, juminNo);
                
                if(check==false){
                     JOptionPane.showMessageDialog(null, 
                                "�ֹι�ȣ�� ���Ŀ� ���� ����!", 
                                "�߿�߿� ���", JOptionPane.ERROR_MESSAGE);
                     west.tf[2].setText(null);
                     west.tf[2].requestFocus(); 
                     //��Ŀ�� �ű�� ���߰�, �� ���� �״�� �־��~'�ٽ� �Է�'
                     return;
                } //end if
                
                int [] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5}; //����ġ
                int sum = 0;
                
                for(int i=0;i<13;i++){
                     if(juminNo.charAt(i)=='-') continue;
                     sum +=((juminNo.charAt(i)-48)*weight[i]);
                }
 
                int temp = 11-(sum%11);
                int result = temp%10;
                
                if(result==(juminNo.charAt(13)-48)){  //�ùٸ� �ֹι�ȣ�� ��� 
                     JOptionPane.showMessageDialog(null, "�ֹι�ȣ Check��� �����Դϴ�.");
                     vector.add(west.tf[2].getText());
 
                }
                else{
                     JOptionPane.showMessageDialog(null,"�ùٸ� �ֹι�ȣ�� �ƴմϴ�.",
                                "�ֹι�ȣ�� �ٽ� �Է��ϼ���.",JOptionPane.ERROR_MESSAGE);
                     return;
                }
                west.tf[2].setText(null);
                west.tf[2].requestFocus(); 
           //vector�� �ִ� ���� Vector<Vector<String>> data�� ���� �ֱ� - 1����� ���Ϳ� �� ��.
                showtable.data.addElement(vector);
                /*�߿� => vector�� �ִ� ����(data ���Ϳ� ����� �����͵�)�� 
                 datamodel�� JTable�� �����ֱ� !
                 �����Ͱ� ��ȭ�� �� �������(�߰�/����/����)�� JTable�� �˷��־�� �ϴµ�
                 fireTableDataChanged()�޼ҵ带 ȣ���ϸ� �ȴ�.*/ 
               showtable.datamodel.fireTableDataChanged();
           }
           //"����"�̺�Ʈ ó��
           public void UpdateData(){
                updateRow = showtable.table.getSelectedRow();
                //�ֹι�ȣ ���� ���ϰ� �ϴ� ���
                
                //�ڵ��� ����
           showtable.table.setValueAt(west.tf[1].getText(), updateRow, 1); //setValueAt(������ ��ġ, ��, ��)
                //west.tf[2].setEnabled(true);
           }
           
           //"����"�̺�Ʈ ó��
           public void DelData(){
                int yes_no_select = JOptionPane.showConfirmDialog(null, 
                           "���� �����ϰڽ��ϱ�?", "���� Ȯ�� â", JOptionPane.YES_NO_CANCEL_OPTION     );
                
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
                           //��~~ó��! ���Ƴ��� â Ǯ���ֱ�
                          west.tf[2].setEnabled(true);
                          west.tf[0].requestFocus(); //��Ŀ�� 1�� �ؽ�Ʈ â�� !
                     }
                }
                else return;
                     
           }
     }
     
     class ShowTable extends MouseAdapter{
           DefaultTableModel datamodel;
           JTable table;
           JScrollPane scrollPane;
           String colName[]={"�̸�","�ڵ�����ȣ","�ֹι�ȣ"};
           
     //========================���߿��========================
           //DefaultTableModel(Vector data, Vector columnNames) ������
           Vector<Vector<String>> data; 
           Vector<String> column_name;
           
           //���� �ȿ� ���͸� ��� ��. 10�� �� �ȿ�, ù° �濡�� 10���� ���� ��� ��. 
           /*Vector<String> vec = new Vector<String>(); �̸�, 
            ()�ȿ��� �⺻������ 10,10�� �Ǿ� ����. 
10�� ���� �����ϰ�, �����ϸ� 10���� �ڵ����� �þ��. */
           
//[����]�޴��� ����, ���� �۾��� Vector�� �����͸� Ȱ���Ѵ�. ����, �߰� ����� ����     
           public ShowTable(){
                data = new Vector<Vector<String>>();
                column_name = new Vector<String>();
           //���߿� ������ �����ؼ� �ҷ����� �� �� �־�� �Ѵ�. ����-������ Vector�� ���ؼ� �ؾ� �Ѵ�.
                
                for(int i=0;i<colName.length;i++){
                     column_name.add(colName[i]);
                }
                
                datamodel = new DefaultTableModel(data,column_name);
                table = new JTable (datamodel);
                scrollPane = new JScrollPane(table);
                
                //�̺�Ʈ ����
                table.addMouseListener(this); 
                //���콺 �̺�Ʈ�� ���콺������
                //����� ���� �޼ҵ� ȣ��
                TableSize();
           }
     //JTable�� �� ũ�� ���� �� �� ������ �� �߾� ���� ��Ű�� �޼ҵ�
           public void TableSize(){
           table.getColumnModel().getColumn(0).setPreferredWidth(50); //�̸� ��
           table.getColumnModel().getColumn(1).setPreferredWidth(70); //��ȭ��ȣ ��
           table.getColumnModel().getColumn(2).setPreferredWidth(120); //�ֹι�ȣ ��
                
           DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
           tableCell.setHorizontalAlignment(SwingConstants.CENTER);
           TableColumnModel CellModel = table.getColumnModel();
                
            for(int i=0;i<CellModel.getColumnCount();i++){
                CellModel.getColumn(i).setCellRenderer(tableCell);
             }
        }
     //�������� �������̵��ϴ� ��� : MouseClicked()�� �ʿ��ϹǷ�
           @Override
           public void mouseClicked(java.awt.event.MouseEvent e) {
                updateRow = table.getSelectedRow(); //������ ���� ������ �޼ҵ�
                //�����ϸ� JTextField�� �ѷ��־�� �Ѵ�.
                west.tf[0].setText((String) showtable.table.getValueAt(updateRow, 0));
                west.tf[1].setText((String) showtable.table.getValueAt(updateRow, 1));
                west.tf[2].setText((String) showtable.table.getValueAt(updateRow, 2));
                /*west�� tf0�� "��   ��" �ؽ�Ʈ �ڽ��ϱ�... ���⸦ set�ϴ°ǵ� ��� set�ϳĸ�.. 
                 showtable�� �ִ� datamodel�� ����ִ� JTable(table)���� ���� �����µ�,
                 updateRow�� ������ ��!, ���⼭ 0, 1, 2��° ���� ������� text���� ���ͼ� 
                 String���� ��ȯ�ؼ� set�ض�! */
                west.tf[2].setEditable(false); 
                // TextField�� �ִ� ����Ÿ���� �������� ���ϵ���/���ھ��� ����(�ֹι�ȣ ���� X)
           }
    }
     
   
}