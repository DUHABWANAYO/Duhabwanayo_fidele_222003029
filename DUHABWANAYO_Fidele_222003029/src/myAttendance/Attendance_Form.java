package myAttendance;

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

import Attendance.MyAttendance;


public class Attendance_Form implements ActionListener{
	
	JFrame frame;
	JLabel Attendance_id_lb=new JLabel("Attendance_id");
	JLabel student_id_lb=new JLabel("student_id ");
	JLabel Course_id_lb=new JLabel("Course_id");
	JLabel attendance_date_lb=new JLabel("attendance_date");
	JLabel status_lb=new JLabel("status");
	
	
	JTextField Attendance_id_txf=new JTextField();
	JTextField student_id_txf=new JTextField();
    JTextField Course_id_txf=new JTextField();
    JTextField attendance_date_txf= new JTextField();
    JTextField status_txF=new JTextField();
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  Attendance_Form() {
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
        frame.setTitle("Attendance_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Attendance_id_lb.setBounds(10, 10, 200, 30);
    	student_id_lb.setBounds(10, 50, 200, 30);
    	Course_id_lb.setBounds(10, 90, 200, 30);
    	attendance_date_lb.setBounds(10, 130, 200, 30);
    	status_lb.setBounds(10, 170, 200, 30);
    	
    	
    	Attendance_id_txf.setBounds(200, 10, 300, 30);
    	student_id_txf.setBounds(200, 50, 300, 30);
    	Course_id_txf.setBounds(200, 90, 300, 30);
    	attendance_date_txf.setBounds(200, 130, 300, 30);
    	status_txF.setBounds(200, 170, 300, 30);
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(550, 10, 600, 200);
         
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	Attendance_id_lb.setFont(fontLabel);
   	student_id_lb.setFont(fontLabel);
   	Course_id_lb.setFont(fontLabel);
   	attendance_date_lb.setFont(fontLabel);
   	status_lb.setFont(fontLabel);
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Attendance_id_txf.setFont(fontText);
   	student_id_txf.setFont(fontText);
   	Course_id_txf.setFont(fontText);
   	attendance_date_txf.setFont(fontText);
   	status_txF.setFont(fontText);
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Attendance_id_lb);
        frame.add(student_id_lb);
        frame.add(Course_id_lb);
        frame.add(attendance_date_lb);
        frame.add(status_lb);	
      
       
    	
        frame.add(Attendance_id_txf);
        frame.add(student_id_txf);
        frame.add(Course_id_txf);
        frame.add(attendance_date_txf);
        frame.add(status_txF);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
        
    }
     public void actionPerformed(ActionEvent e) {
    	 MyAttendance at=new MyAttendance();
    	 
    	 if (e.getSource() == insert_btn) { 
            at.setStudent_id(student_id_txf.getText());
            at.setCourse_id(Course_id_txf.getText());
            at.setAttendance_date(attendance_date_txf.getText());
            at.setStatus(status_txF.getText());
            at.insertData();
    }
    	 
    	 else if (e.getSource() == read_btn) {
    	        model.setColumnCount(0);
    	        model.setRowCount(1);
    	        model.addColumn("Attendance_id");
    	        model.addColumn("student_id");
    	        model.addColumn("Course_id");
    	        model.addColumn("attendance_date");
    	        model.addColumn("status");
    	       
    	        ResultSet resultSet =MyAttendance.viewData();
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
    int id = Integer.parseInt(Attendance_id_txf.getText());
    
    at.setStudent_id(student_id_txf.getText());
    at.setCourse_id(Course_id_txf.getText());
    at.setAttendance_date(attendance_date_txf.getText());
    at.setStatus(status_txF.getText());
    at.update(id);
} 
else {
    int id = Integer.parseInt(Attendance_id_txf.getText());
    at.delete(id);
}
}	


public static void main(String[] args) {
	Attendance_Form attf=new Attendance_Form();

}


}

