package MyAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class admin {//	fname	lname	phone	gender	martial_status	DoB	email	password
    private String fname;
    private String lname;
    private String phone;
    private String gender;
    private String Martial_Status;
    private String DoB; // Assuming DoB stands for Date of Birth
    private String email;
    private String password;
    //constructor
    public admin() {
        // Default constructor
    }

    public admin(String fname, String lname, String phone, String gender, String Martial_Status, String DoB,String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.gender = gender;
        this.Martial_Status = Martial_Status;
        this.DoB = DoB;
        this.email = email;
        this.password = password;
    }
    
	
	
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMartial_Status() {
		return Martial_Status;
	}

	public void setMartial_Status(String martial_Status) {
		Martial_Status = martial_Status;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void makeconnection() {
    	// JDBC URL, username, and password of MySQL server
        String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
        String user = "222003029";
        String password = "222003029";
    }
    public void insertData() {
        String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
        String user = "222003029";
        String password = "222003029";

        String sql = "INSERT INTO Admin (fname, lname, phone, gender, martial_Status, DoB, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
        		
            Connection con = DriverManager.getConnection(host, user, password);

            // Create a prepared statement
        		
            PreparedStatement stm= con.prepareStatement(sql);
        ) {
            // Set the values for the prepared statement
        	
            stm.setString(1, this.fname);
            stm.setString(2, this.lname);
            stm.setString(3, this.phone);
            stm.setString(4, this.gender);
            stm.setString(5, this.Martial_Status);
            stm.setString(6, this.DoB);
            stm.setString(7, this.email);
            stm.setString(8, this.password);

            // Execute the query
            int rowsAffected = stm.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
            	//System.out.println("Data inserted successfully!");
               // JOptionPane.showMessageDialog(null, "SinUp successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to SinUp.!","After insert",JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }	
    }
    
    public void login() {
    	makeconnection();
    	String host = "jdbc:mysql://localhost/Automated_Students_Attendance_System";
        String user = "222003029";
        String password = "222003029";
        String sql = "SELECT * FROM Admin WHERE email = ? AND password = ?";
        
    	try(
    			Connection con = DriverManager.getConnection(host, user, password);
            		
                PreparedStatement stm= con.prepareStatement(sql);
    			
    			) {
    		
    		stm.setString(1, this.email);
    		stm.setString(2, this.password);
    		ResultSet rs = stm.executeQuery();
    		if(rs.next()) {
    			//System.out.println("Data inserted successfully!");
                //JOptionPane.showMessageDialog(null, "Login successfully!","After login",JOptionPane.INFORMATION_MESSAGE);
    		} else {
    			JOptionPane.showMessageDialog(null, "Incorect Email and password!","After login",JOptionPane.INFORMATION_MESSAGE);
    		}
    		con.close();
    		
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

	
}


