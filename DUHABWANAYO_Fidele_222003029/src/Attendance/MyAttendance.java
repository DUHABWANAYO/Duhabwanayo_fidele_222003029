package Attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyAttendance {
	
	private int Attendance_id ;
	private String student_id ;
	private String Course_id ;
	private String attendance_date  ;
	private String status;
	
		
	 
	public MyAttendance(int  Attendance_id,String student_id,String Course_id,String attendance_date,String status){
		super();
		this.Course_id =Course_id;
		this.student_id =student_id ;
		this.Course_id=Course_id;
		this.attendance_date=attendance_date;
		this.status=status;
		}



	public MyAttendance() {
		// TODO Auto-generated constructor stub
	}



	public int getAttendance_id() {
		return Attendance_id;
	}



	public void setAttendance_id(int attendance_id) {
		Attendance_id = attendance_id;
	}



	public String getStudent_id() {
		return student_id;
	}



	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}



	public String getCourse_id() {
		return Course_id;
	}



	public void setCourse_id(String Course_id) {
		this.Course_id = Course_id;
	}



	public String getAttendance_date() {
		return attendance_date;
	}



	public void setAttendance_date(String attendance_date) {
		this.attendance_date = attendance_date;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to insert data
    String sql = "INSERT INTO attendance(Course_id,student_id , attendance_date,status ) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.Course_id);
       preparedStatement.setString(2, this.student_id); 
       preparedStatement.setString(3, this.attendance_date);
       preparedStatement.setString(4, this.status);
       
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
	        String user = "222003029";
	        String password = "222003029";

	        String sql = "SELECT * FROM attendance";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		
		
		
public void update(int inputAttendance_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE attendance SET Course_id= ?,student_id= ? , attendance_date= ?,status= ?   WHERE Attendance_id = ?";
    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement atm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	
    	  atm.setString(1, this.getCourse_id());
          atm.setString(2, this.getStudent_id());
          atm.setString(3, this.getAttendance_date()); 
          atm.setString(4, this.getStatus());// Assuming there is a column named 'id' for the WHERE clause
          atm.setInt(5, inputAttendance_id);
       
        // Execute the update
        int rowsAffected = atm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to update data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputAttendance_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to delete data
    String sql = "DELETE FROM attendance WHERE  Attendance_id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputAttendance_id); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}
