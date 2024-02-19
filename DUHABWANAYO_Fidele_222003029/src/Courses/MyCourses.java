package Courses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyCourses {
	private int course_id;
	private String course_name;
	private String course_code ;
		
	 
	public MyCourses(int course_id,String course_name,String course_code){
		super();
		this.course_id=course_id;
		this.course_name=course_name;
		this.course_code=course_code;
		}


	public MyCourses() {
		// TODO Auto-generated constructor stub
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public String getCourse_code() {
		return course_code;
	}


	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
	    String user = "222003029";
	    String password = "222003029";

	    // SQL query to insert data
	    String sql = "INSERT INTO courses(course_name, course_code) VALUES (?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.course_name);
	       preparedStatement.setString(2, this.course_code);
	       
	       
	        
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

		        String sql = "SELECT * FROM courses";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
			
			
			
	public void update(int inputcourse_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
	    String user = "222003029";
	    String password = "222003029";

	    // SQL query to update data
	    String sql = "UPDATE courses SET  course_name= ?, course_code= ? WHERE course_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getCourse_name());
	          stm.setString(2, this.getCourse_code());// Assuming there is a column named 'id' for the WHERE clause
	          stm.setInt(3, inputcourse_id);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

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
	public void delete(int inputcourse_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
	    String user = "222003029";
	    String password = "222003029";

	    // SQL query to delete data
	    String sql = "DELETE FROM courses WHERE  course_id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputcourse_id); // Assuming there is a column named 'id' for the WHERE clause

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
	
	



