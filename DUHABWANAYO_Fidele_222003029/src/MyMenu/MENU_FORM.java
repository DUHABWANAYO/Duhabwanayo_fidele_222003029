package MyMenu;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import myAttendance.Attendance_Form;
import myCourses.Courses_Form;
import myEnrollments.Enrollment_Form;
import myFaculty.Faculty_form;
import students.Students_Form;



public class MENU_FORM extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Studentsmenu;
    private JMenu Facultymenu;
    private JMenu Enrollmentmenu;
    private JMenu Coursesmenu;
    private JMenu Attendancemenu;
    private JMenu Logoutmenu;
    


	public MENU_FORM() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem StudentsItem;
    private JMenuItem FacultyItem;
    private JMenuItem EnrollmentItem;
    private JMenuItem CoursesItem;
    private JMenuItem AttendanceItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public MENU_FORM(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Studentsmenu = new JMenu("Students");
        Facultymenu = new JMenu("Faculty");
        Enrollmentmenu= new JMenu("Enrollment");
        Coursesmenu = new JMenu("Courses");
        Attendancemenu = new JMenu("Attendance");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Studentsmenu);
        StudentsItem = new JMenuItem("StudentsForm");
        StudentsItem.addActionListener(this);
        
        menuBar.add(Facultymenu);
        FacultyItem = new JMenuItem("FacultyForm");
        FacultyItem.addActionListener(this);
        
        menuBar.add(Enrollmentmenu);
        EnrollmentItem = new JMenuItem("EnrollmentForm");
        EnrollmentItem.addActionListener(this);
        
        menuBar.add(Coursesmenu);
        CoursesItem = new JMenuItem("CoursesForm");
        CoursesItem.addActionListener(this);
        
        menuBar.add(Attendancemenu);
        AttendanceItem = new JMenuItem("AttendanceForm");
        AttendanceItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Studentsmenu.add(StudentsItem);
        Facultymenu.add(FacultyItem);
        Enrollmentmenu.add(EnrollmentItem);
        Coursesmenu.add( CoursesItem);
        Attendancemenu.add(AttendanceItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\fidele Duhabwanayo\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == StudentsItem) {
            new Students_Form();
        
        } else if (e.getSource() == FacultyItem) {
            new Faculty_form();
        
        } else if (e.getSource() == EnrollmentItem) {
            new Enrollment_Form();
       
        } else if (e.getSource() == CoursesItem) {
           new Courses_Form();
        
        } else if (e.getSource() == AttendanceItem) {
           new Attendance_Form();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MENU_FORM( "TO AUTOMATED STUDENTS ATTENDANCE SYSTEM "));
    }
}




