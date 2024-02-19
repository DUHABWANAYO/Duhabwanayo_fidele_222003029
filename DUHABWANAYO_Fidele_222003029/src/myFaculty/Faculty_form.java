package myFaculty;

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

import Faculty.MyFaculty;
import MyStudents.Students;
import myFaculty.Faculty_form;

public class Faculty_form implements ActionListener{
	
	
	JFrame frame;
	JLabel Faculty_ID_lb=new JLabel("Faculty_ID ");
	JLabel Name_lb=new JLabel("Name ");
	JLabel Contact_Information_lb=new JLabel("Contact_Information ");
	JLabel course_id_lb=new JLabel("course_id");
	JLabel Lecturer_names_lb=new JLabel("Lecturer_names ");
	
	
	JTextField Faculty_ID_txf=new JTextField();
	JTextField Name_txf=new JTextField();
    JTextField Contact_Information_txf=new JTextField();
    JTextField course_id_txf= new JTextField();
    JTextField Lecturer_names_txF=new JTextField();
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton view_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
	
    
	public  Faculty_form() {
    	setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        view_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Faculty_form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Faculty_ID_lb.setBounds(10, 10, 250, 30);
    	Name_lb.setBounds(10, 50, 250, 30);
    	Contact_Information_lb.setBounds(10, 90, 250, 30);
    	course_id_lb.setBounds(10, 130, 250, 30);
    	Lecturer_names_lb.setBounds(10, 170, 250, 30);
    	
    	
    	Faculty_ID_txf.setBounds(220, 10, 300, 30);
    	Name_txf.setBounds(220, 50, 300, 30);
    	Contact_Information_txf.setBounds(220, 90, 300, 30);
    	course_id_txf.setBounds(220, 130, 300, 30);
    	Lecturer_names_txF.setBounds(220, 170, 300, 30);
    	
         insert_btn.setBounds(10, 250, 85, 30);
         view_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(600, 10, 600, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	Faculty_ID_lb.setFont(fontLabel);
   	Name_lb.setFont(fontLabel);
   	Contact_Information_lb.setFont(fontLabel);
   	course_id_lb.setFont(fontLabel);
   	Lecturer_names_lb.setFont(fontLabel);
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Faculty_ID_txf.setFont(fontText);
   	Name_txf.setFont(fontText);
   	Contact_Information_txf.setFont(fontText);
   	course_id_txf.setFont(fontText);
   	Lecturer_names_txF.setFont(fontText);
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       view_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Faculty_ID_lb);
        frame.add(Name_lb);
        frame.add(Contact_Information_lb);
        frame.add(course_id_lb);
        frame.add(Lecturer_names_lb);	
      
       
    	
        frame.add(Faculty_ID_txf);
        frame.add(Name_txf);
        frame.add(Contact_Information_txf);
        frame.add(course_id_txf);
        frame.add(Lecturer_names_txF);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(view_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
 public void actionPerformed(ActionEvent e) {
	 MyFaculty ft=new MyFaculty();
    if (e.getSource() == insert_btn) {
        ft.setName(Name_txf.getText());
        ft.setContact_Information(Contact_Information_txf.getText());
        ft.setCourse_id(course_id_txf.getText());
        ft.setLecturer_names(Lecturer_names_txF.getText());
        ft.insertData();
    }
    
    else if (e.getSource() == view_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("Faculty_ID");
        model.addColumn("Name");
        model.addColumn("Contact_Information");
        model.addColumn("course_id");
        model.addColumn("Lecturer_names");
       
        ResultSet resultSet =MyFaculty.viewData();
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
        int id = Integer.parseInt(Faculty_ID_txf.getText());
        
        ft.setName(Name_txf.getText());
        ft.setContact_Information(Contact_Information_txf.getText());
        ft.setCourse_id(course_id_txf.getText());
        ft.setLecturer_names(Lecturer_names_txF.getText());
        ft.update(id);
    } 
    else {
        int id = Integer.parseInt(Faculty_ID_txf.getText());
        ft.delete(id);
    }
}	

	public static void main(String[] args) {
		Faculty_form Faculf=new Faculty_form();	

	}

}


