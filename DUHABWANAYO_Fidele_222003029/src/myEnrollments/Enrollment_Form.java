package myEnrollments;

import java.awt.Color;
import java.awt.Component;
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

import Attendance.MyAttendance;
import Courses.MyCourses;
import Enrollments.MyEnrollments;
import myEnrollments.Enrollment_Form;

public class Enrollment_Form implements ActionListener{
	
	
	
	JFrame frame;
	JLabel enrollment_id_lb=new JLabel("enrollment_id");
	JLabel student_id_lb=new JLabel("student_id ");
	JLabel Contact_Information_lb=new JLabel("Contact_Information");
	JLabel Lecturer_name_lb=new JLabel("Lecturer_name");
	
	
	JTextField enrollment_id_txf=new JTextField();
	JTextField student_id_txf=new JTextField();
    JTextField Contact_Information_txf= new JTextField();
    JTextField Lecturer_name_txF=new JTextField();
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
	

    public  Enrollment_Form() {
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
        frame.setTitle("Enrollment_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	enrollment_id_lb.setBounds(10, 10, 200, 30);
    	student_id_lb.setBounds(10, 50, 200, 30);
    	Contact_Information_lb.setBounds(10, 90, 200, 30);
    	Lecturer_name_lb.setBounds(10, 130, 200, 30);
    	
    	
    	enrollment_id_txf.setBounds(250, 10, 300, 30);
    	student_id_txf.setBounds(250, 50, 300, 30);
    	Contact_Information_txf.setBounds(250, 90, 300, 30);
    	Lecturer_name_txF.setBounds(250, 130, 300, 30);
    	
         insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(600, 10, 600, 200);
         
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	enrollment_id_lb.setFont(fontLabel);
   	student_id_lb.setFont(fontLabel);
   	Contact_Information_lb.setFont(fontLabel);
   	Lecturer_name_lb.setFont(fontLabel);
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	enrollment_id_txf.setFont(fontText);
   	student_id_txf.setFont(fontText);
   	Contact_Information_txf.setFont(fontText);
   	Lecturer_name_txF.setFont(fontText);
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(enrollment_id_lb);
        frame.add(student_id_lb);
        frame.add(Contact_Information_lb);
        frame.add(Lecturer_name_lb);	
      
       
    	
        frame.add(enrollment_id_txf);
        frame.add(student_id_txf);
        frame.add(Contact_Information_txf);
        frame.add(Lecturer_name_txF);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	MyEnrollments et=new MyEnrollments();
        if (e.getSource() == insert_btn) {
            et.setStudent_id(student_id_txf.getText());
            et.setContact_Information(Contact_Information_txf.getText());
            et.setLecturer_name(Lecturer_name_txF.getText());

            et.insertData();
        } 
        
        
        
        else if (e.getSource() == read_btn) {
	        model.setColumnCount(0);
	        model.setRowCount(1);
	        model.addColumn("enrollment_id");
	        model.addColumn("student_id");
	        model.addColumn("Contact_Information");
	        model.addColumn("Lecturer_name");
	       
	        ResultSet resultSet =MyEnrollments.viewData();
	        if (resultSet != null) {
	            try {
	                while (resultSet.next()) {
	                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                            resultSet.getString(3), resultSet.getString(4)});
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
       
        
        else if (e.getSource() == update_btn) {
            int id = Integer.parseInt(enrollment_id_txf.getText());
          
            et.setStudent_id(student_id_txf.getText());
            et.setContact_Information(Contact_Information_txf.getText());
            et.setLecturer_name(Lecturer_name_txF.getText());
            et.update(id);
        } 
        else {
            int id = Integer.parseInt(enrollment_id_txf.getText());
            et.delete(id);
        }
    }


	public static void main(String[] args) {
		Enrollment_Form Enrof=new Enrollment_Form();

	
	}

}
