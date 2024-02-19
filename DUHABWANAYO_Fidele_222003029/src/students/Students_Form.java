package students;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MyStudents.Students;
import students.Students_Form;

public class Students_Form implements ActionListener{
	JFrame frame;
	JLabel Student_ID_lb=new JLabel("Student_ID ");
	JLabel First_Name_lb=new JLabel("First_Name");
	JLabel Last_Name_lb=new JLabel("Last_Name");
	JLabel Date_Of_Birth_lb=new JLabel("Date_Of_Birth");
	JLabel Email_lb=new JLabel(" Email");
	
	
	JTextField Student_ID_txf=new JTextField();
	JTextField First_Name_txf=new JTextField();
    JTextField Last_Name_txf=new JTextField();
    JTextField Date_Of_Birth_txf= new JTextField();
    JTextField Email_txF=new JTextField();
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  Students_Form() {
    	setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        read_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Students_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Student_ID_lb.setBounds(10, 10, 200, 30);
    	First_Name_lb.setBounds(10, 50, 200, 30);
    	Last_Name_lb.setBounds(10, 90, 200, 30);
    	Date_Of_Birth_lb.setBounds(10, 130, 200, 30);
    	Email_lb.setBounds(10, 170, 200, 30);
    	
    	
    	Student_ID_txf.setBounds(200, 10, 250, 30);
    	First_Name_txf.setBounds(200, 50, 250, 30);
    	Last_Name_txf.setBounds(200, 90, 250, 30);
    	Date_Of_Birth_txf.setBounds(200, 130, 250, 30);
    	Email_txF.setBounds(200, 170, 250, 30);
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	Student_ID_lb.setFont(fontLabel);
   	First_Name_lb.setFont(fontLabel);
   	Last_Name_lb.setFont(fontLabel);
   	Date_Of_Birth_lb.setFont(fontLabel);
   	Email_lb.setFont(fontLabel);
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Student_ID_txf.setFont(fontText);
   	First_Name_txf.setFont(fontText);
   	Last_Name_txf.setFont(fontText);
   	Date_Of_Birth_txf.setFont(fontText);
   	Email_txF.setFont(fontText);
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Student_ID_lb);
        frame.add(First_Name_lb);
        frame.add(Last_Name_lb);
        frame.add(Date_Of_Birth_lb);
        frame.add(Email_lb);	
      
       
    	
        frame.add(Student_ID_txf);
        frame.add(First_Name_txf);
        frame.add(Last_Name_txf);
        frame.add(Date_Of_Birth_txf);
        frame.add(Email_txF);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	Students st=new Students();
    if (e.getSource() == insert_btn) {
        st.setFirst_Name(First_Name_txf.getText());
        st.setLast_Name(Last_Name_txf.getText());
        st.setDate_Of_Birth(Date_Of_Birth_txf.getText());
        st.setEmail(Email_txF.getText());
        st.insertData();
    }
    
    
    
 
    
    
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("Student_ID");
        model.addColumn("First_Name");
        model.addColumn("Last_Name");
        model.addColumn("Date_Of_Birth");
        model.addColumn("Email");
       
        ResultSet resultSet =Students.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(Student_ID_txf.getText());
        
        st.setFirst_Name(First_Name_txf.getText());
        st.setLast_Name(Last_Name_txf.getText());
        st.setDate_Of_Birth(Date_Of_Birth_txf.getText());
        st.setEmail(Email_txF.getText());
        st.update(id);
    } 
    else {
        int id = Integer.parseInt(Student_ID_txf.getText());
        st.delete(id);
    }
}	
	

	public static void main(String[] args) {
		Students_Form Studf=new Students_Form();

	}
	

}
