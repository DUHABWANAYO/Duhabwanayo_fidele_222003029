package Enrollments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyEnrollments {
	
	private int enrollment_id ;
	private String student_id ;
	private String Contact_Information ;
	private String course_id  ;
	private String Lecturer_name;
	
		
	 
	public MyEnrollments(int enrollment_id,String student_id,String Contact_Information,String course_id,String Lecturer_name){
		super();
		this.enrollment_id=enrollment_id;
		this.student_id=student_id;
		this.Contact_Information =Contact_Information ;
		this.course_id =course_id ;
		this.Lecturer_name=Lecturer_name;
		}



	public MyEnrollments() {
		// TODO Auto-generated constructor stub
	}



public int getEnrollment_id() {
		return enrollment_id;
	}



	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
	}



	public String getStudent_id() {
		return student_id;
	}



	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}



	public String getContact_Information() {
		return Contact_Information;
	}



	public void setContact_Information(String contact_Information) {
		Contact_Information = contact_Information;
	}



	public String getCourse_id() {
		return course_id;
	}



	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}



	public String getLecturer_name() {
		return Lecturer_name;
	}



	public void setLecturer_name(String lecturer_name) {
		Lecturer_name = lecturer_name;
	}



public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to insert data
    String sql = "INSERT INTO enrollment(student_id, Contact_Information,Lecturer_name) VALUES (?,?,?)";
	
    try (//student_id	Contact_Information	Lecturer_name
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.student_id);
       preparedStatement.setString(2, this.Contact_Information);
       preparedStatement.setString(3, this.Lecturer_name);
       
        
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

	        String sql = "SELECT * FROM enrollment";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		
public void update(int inputenrollment_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to update data
    String sql = "UPDATE enrollment SET  student_id= ?, Contact_Information= ?,Lecturer_name= ?  WHERE enrollment_id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement etm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  etm.setString(1, this.getStudent_id());
          etm.setString(2, this.getContact_Information()); 
          etm.setString(3, this.getLecturer_name());// Assuming there is a column named 'id' for the WHERE clause
       
          etm.setInt(4, inputenrollment_id);
        // Execute the update
        int rowsAffected = etm.executeUpdate();

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
public void delete(int inputenrollment_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to delete data
    String sql = "DELETE FROM enrollment WHERE  enrollment_id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputenrollment_id); // Assuming there is a column named 'id' for the WHERE clause

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





