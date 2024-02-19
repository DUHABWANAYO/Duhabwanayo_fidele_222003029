package Faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyFaculty {
	
	
	private int Faculty_ID;
	private String Name;
	private String Contact_Information ;
	private String course_id  ;
	private String Lecturer_names;
	
		
	 
	public MyFaculty(int Faculty_ID,String Name,String Contact_Information,String  course_id,String Lecturer_name){
		super();
		this.Faculty_ID=Faculty_ID;
		this.Name=Name;
		this.Contact_Information =Contact_Information ;
		this.course_id =course_id ;
		this.Lecturer_names=Lecturer_names;
		}



	public MyFaculty() {
		// TODO Auto-generated constructor stub
	}



	public int getFaculty_ID() {
		return Faculty_ID;
	}



	public void setFaculty_ID(int faculty_ID) {
		Faculty_ID = faculty_ID;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
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



	public String getLecturer_names() {
		return Lecturer_names;
	}



	public void setLecturer_names(String lecturer_names) {
		Lecturer_names = Lecturer_names;
	}
	

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to insert data
    String sql = "INSERT INTO faculty(Name,Contact_Information , course_id,Lecturer_names ) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.Name);
       preparedStatement.setString(2, this.Contact_Information);
       preparedStatement.setString(3, this.course_id);
       preparedStatement.setString(4, this.Lecturer_names);
       
       
        
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

	        String sql = "SELECT * FROM faculty";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputFaculty_ID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to update data
    String sql = "UPDATE faculty SET Name= ?, Contact_Information= ? , course_id= ?, Lecturer_names= ?  WHERE Faculty_ID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement ftm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  ftm.setString(1, this.getName());
          ftm.setString(2, this.getContact_Information());
          ftm.setString(3, this.getCourse_id()); 
          ftm.setString(4, this.getLecturer_names());// Assuming there is a column named 'id' for the WHERE clause
       
          ftm.setInt(5, inputFaculty_ID);
       
        // Execute the update
        int rowsAffected = ftm.executeUpdate();

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
public void delete(int inputFaculty_ID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
    String user = "222003029";
    String password = "222003029";

    // SQL query to delete data
    String sql = "DELETE FROM faculty WHERE  Faculty_ID = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputFaculty_ID); // Assuming there is a column named 'id' for the WHERE clause

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
