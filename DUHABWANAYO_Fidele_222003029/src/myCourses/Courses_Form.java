package myCourses;

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

import Courses.MyCourses;


public class Courses_Form implements ActionListener{
	
	JFrame frame;
	JLabel course_id_lb=new JLabel("course_id");
	JLabel course_name_lb=new JLabel("course_name");
	JLabel course_code_lb=new JLabel("course_code");
	
	
	JTextField course_id_txf=new JTextField();
	JTextField course_name_txf=new JTextField();
    JTextField course_code_txf=new JTextField();
        
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  Courses_Form() {
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
        frame.setTitle("Courses_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	course_id_lb.setBounds(10, 10, 200, 30);
    	course_name_lb.setBounds(10, 50, 200, 30);
    	course_code_lb.setBounds(10, 90, 200, 30);
    	
    	
    	course_id_txf.setBounds(200, 10, 300, 30);
    	course_name_txf.setBounds(200, 50, 300, 30);
    	course_code_txf.setBounds(200, 90, 300, 30);
    	
    	 
    	 
    	 insert_btn.setBounds(30, 150,85, 30);
         read_btn.setBounds(120,  150, 85, 30);
         update_btn.setBounds(210,150, 85, 30);
         delete_btn.setBounds(300,150, 85, 30);
         table.setBounds(550, 10, 600, 200);

     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	course_id_lb.setFont(fontLabel);
   	course_name_lb.setFont(fontLabel);
   	course_code_lb.setFont(fontLabel);
   	
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	course_id_txf.setFont(fontText);
   	course_name_txf.setFont(fontText);
   	course_code_txf.setFont(fontText);
   	
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(course_id_lb);
        frame.add(course_name_lb);
        frame.add(course_code_lb);
        	
      
    	
        frame.add(course_id_txf);
        frame.add(course_name_txf);
        frame.add(course_code_txf);
       
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    @Override
     public void actionPerformed(ActionEvent e) {
    	MyCourses ct=new MyCourses();
    if (e.getSource() == insert_btn) {
        ct.setCourse_name(course_name_txf.getText());
        ct.setCourse_code(course_code_txf.getText());
        ct.insertData();
    }
    
    
    
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("course_id");
        model.addColumn("course_name");
        model.addColumn("course_code");
        
       
        ResultSet resultSet =MyCourses.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    
    }
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(course_id_txf.getText());
      
        ct.setCourse_name(course_name_txf.getText());
        ct.setCourse_code(course_code_txf.getText());
        ct.update(id);
    } 
    else {
        int id = Integer.parseInt(course_id_txf.getText());
        ct.delete(id);
    }
}
	public static void main(String[] args) {
		Courses_Form Courf=new Courses_Form();	

	}


}
