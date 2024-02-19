package MyStudents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Students{
	private int Student_ID;
	private String First_Name;
	private String Last_Name;
	private String Date_Of_Birth;
	private String Email;
	
	 
	public Students(int Student_ID,String First_Name,String Last_Name,String Date_Of_Birth,String Email){
		super();
		this.Student_ID=Student_ID;
		this.First_Name=First_Name;
		this.Last_Name=Last_Name;
		this.Date_Of_Birth=Date_Of_Birth;
		this.Email=Email;
		}


	public Students() {
		// TODO Auto-generated constructor stub
	}


	public int getStudent_ID() {
		return Student_ID;
	}


	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}


	public String getFirst_Name() {
		return First_Name;
	}


	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}


	public String getLast_Name() {
		return Last_Name;
	}


	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}


	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}


	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO students(First_Name, Last_Name , Date_Of_Birth, Email ) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.First_Name);
	       preparedStatement.setString(2, this.Last_Name);
	       preparedStatement.setString(3, this.Date_Of_Birth);
	       preparedStatement.setString(4, this.Email);
	       
	        
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
		        String user = "root";
		        String password = "";

		        String sql = "SELECT * FROM students";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
			
			
			
	public void update(int inputStudent_ID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE students SET  First_Name= ?,Last_Name= ?, Date_Of_Birth= ?, Email= ? WHERE Student_ID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getFirst_Name());
	          stm.setString(2, this.getLast_Name());
	          stm.setString(3, this.getDate_Of_Birth()); 
	          stm.setString(4, this.getEmail());// Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputStudent_ID);
	       
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
	public void delete(int inputStudent_ID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM students WHERE  Student_ID = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputStudent_ID); // Assuming there is a column named 'id' for the WHERE clause

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
	


