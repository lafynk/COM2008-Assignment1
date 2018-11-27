package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import SQLcode.Sql;
import classPkg.StuInfo;
import classPkg.UserInfo;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Color;

public class registrarpage {

	JFrame frmSystemsDesign;
	private JTextField studentusername;
	private JTextField studenttutor;
	private JLabel lblStudentUsername;
	private JLabel lblTitle;
	private JLabel lblTutorName;
	private JLabel lblStudentPassword;
	private JTextField studentpassword;
	private JLabel lblFirstName;
	private JTextField studentfname;
	private JLabel lblSurname;
	private JTextField studentsname;
	private JComboBox studenttitle;
	private JLabel lblDegreeCode;
	private JTextField studentdegree;
	private JLabel lblCurrentPeriodOf;
	private JComboBox studentpos;
	private JButton btnAddStudent;
	private JSeparator separator;
	private JLabel lblStudentId;
	private JTextField studentiddelete;
	private JButton btnDeleteStudent;
	private JSeparator separator_1;
	private JLabel lblStudentId_1;
	private JTextField studentidmodule;
	private JLabel lblGrade;
	private JTextField studentgrade;
	private JLabel lblResitGrade;
	private JTextField studentresit;
	private JButton btnAssign;
	private JButton btnDropModule;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnLogout;
	private JTextField studentmoduletaken;
	private JLabel label_1;
	private JSpinner startdate;
	private JSpinner enddate;
	private JLabel lblCurrentLevel;
	private JComboBox currentlvl;
	private JLabel lblPosCode;
	private JTextField studentidformodule;
	private JSeparator separator_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarpage window = new registrarpage();
					window.frmSystemsDesign.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registrarpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Sql s = new Sql();
		frmSystemsDesign = new JFrame();
		frmSystemsDesign.setTitle("Systems Design & Security: Team Project");
		frmSystemsDesign.setResizable(false);
		frmSystemsDesign.setBounds(100, 0, 1000, 1000);
		frmSystemsDesign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystemsDesign.getContentPane().setLayout(null);
		
		JLabel lblRegistrarDashboard = new JLabel("Registrar Dashboard");
		lblRegistrarDashboard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegistrarDashboard.setBounds(360, 29, 350, 52);
		frmSystemsDesign.getContentPane().add(lblRegistrarDashboard);
		
		studentusername = new JTextField();
		studentusername.setBounds(44, 146, 146, 26);
		frmSystemsDesign.getContentPane().add(studentusername);
		studentusername.setColumns(10);
		
		studenttutor = new JTextField();
		studenttutor.setBounds(572, 146, 146, 26);
		frmSystemsDesign.getContentPane().add(studenttutor);
		studenttutor.setColumns(10);
		
		lblStudentUsername = new JLabel("Student Username");
		lblStudentUsername.setBounds(44, 121, 146, 20);
		frmSystemsDesign.getContentPane().add(lblStudentUsername);
		
		lblTitle = new JLabel("Title");
		lblTitle.setBounds(312, 121, 146, 20);
		frmSystemsDesign.getContentPane().add(lblTitle);
		
		lblTutorName = new JLabel("Tutor Name");
		lblTutorName.setBounds(572, 121, 146, 20);
		frmSystemsDesign.getContentPane().add(lblTutorName);
		
		lblStudentPassword = new JLabel("Student Password");
		lblStudentPassword.setBounds(44, 195, 146, 20);
		frmSystemsDesign.getContentPane().add(lblStudentPassword);
		
		studentpassword = new JTextField();
		studentpassword.setColumns(10);
		studentpassword.setBounds(44, 220, 146, 26);
		frmSystemsDesign.getContentPane().add(studentpassword);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(312, 195, 146, 20);
		frmSystemsDesign.getContentPane().add(lblFirstName);
		
		studentfname = new JTextField();
		studentfname.setColumns(10);
		studentfname.setBounds(312, 220, 146, 26);
		frmSystemsDesign.getContentPane().add(studentfname);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(312, 272, 146, 20);
		frmSystemsDesign.getContentPane().add(lblSurname);
		
		studentsname = new JTextField();
		studentsname.setColumns(10);
		studentsname.setBounds(312, 297, 146, 26);
		frmSystemsDesign.getContentPane().add(studentsname);
		
		studenttitle = new JComboBox();
		studenttitle.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Ms"}));
		studenttitle.setBounds(312, 146, 150, 26);
		frmSystemsDesign.getContentPane().add(studenttitle);
		
		lblDegreeCode = new JLabel("Degree Code");
		lblDegreeCode.setBounds(572, 195, 146, 20);
		frmSystemsDesign.getContentPane().add(lblDegreeCode);
		
		studentdegree = new JTextField();
		studentdegree.setColumns(10);
		studentdegree.setBounds(572, 220, 146, 26);
		frmSystemsDesign.getContentPane().add(studentdegree);
		
		lblCurrentPeriodOf = new JLabel("Current Period Of Study");
		lblCurrentPeriodOf.setBounds(572, 272, 191, 20);
		frmSystemsDesign.getContentPane().add(lblCurrentPeriodOf);
		
		studentpos = new JComboBox();
		studentpos.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		studentpos.setBounds(572, 297, 150, 26);
		frmSystemsDesign.getContentPane().add(studentpos);
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
			
				try {
					if (s.checkUsernameExists(studentusername.getText())) {
						JOptionPane.showMessageDialog(null, "This username is already in use.","Operation Failed", JOptionPane.ERROR_MESSAGE);
					}
					else {
						s.addUser(studentusername.getText(), studentpassword.getText(), "Students");
						UserInfo u = null;
						u =s.checkLogIn(studentusername.getText(), studentpassword.getText());
						s.addStudent((u.getRegNo()), studenttitle.getSelectedItem().toString(), studentsname.getText(),studentfname.getText(), studenttutor.getText(), studentdegree.getText(), studentpos.getSelectedItem().toString().charAt(0), "");
					}
					
		
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchProviderException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddStudent.setBounds(818, 145, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAddStudent);
		
		separator = new JSeparator();
		separator.setBounds(15, 357, 964, 7);
		frmSystemsDesign.getContentPane().add(separator);
		
		lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(225, 380, 146, 20);
		frmSystemsDesign.getContentPane().add(lblStudentId);
		
		studentiddelete = new JTextField();
		studentiddelete.setColumns(10);
		studentiddelete.setBounds(312, 377, 146, 26);
		frmSystemsDesign.getContentPane().add(studentiddelete);
		
		btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.removeStudent(Integer.parseInt(studentiddelete.getText()));
					try {
						s.removeUser(Integer.parseInt(studentiddelete.getText()));
						
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
				
			}
		});
		btnDeleteStudent.setBounds(568, 376, 150, 29);
		frmSystemsDesign.getContentPane().add(btnDeleteStudent);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(15, 421, 964, 7);
		frmSystemsDesign.getContentPane().add(separator_1);
		
		lblStudentId_1 = new JLabel("Student ID");
		lblStudentId_1.setBounds(44, 433, 146, 20);
		frmSystemsDesign.getContentPane().add(lblStudentId_1);
		
		studentidmodule = new JTextField();
		studentidmodule.setColumns(10);
		studentidmodule.setBounds(44, 458, 146, 26);
		frmSystemsDesign.getContentPane().add(studentidmodule);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setBounds(572, 554, 146, 20);
		frmSystemsDesign.getContentPane().add(lblGrade);
		
		studentgrade = new JTextField();
		studentgrade.setText("0");
		studentgrade.setColumns(10);
		studentgrade.setBounds(572, 579, 146, 26);
		frmSystemsDesign.getContentPane().add(studentgrade);
		
		lblResitGrade = new JLabel("Resit Grade");
		lblResitGrade.setBounds(312, 554, 146, 20);
		frmSystemsDesign.getContentPane().add(lblResitGrade);
		
		studentresit = new JTextField();
		studentresit.setText("0");
		studentresit.setColumns(10);
		studentresit.setBounds(312, 579, 146, 26);
		frmSystemsDesign.getContentPane().add(studentresit);
		
		btnAssign = new JButton("Assign Module");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					s.addTakenModule(Integer.parseInt(studentidmodule.getText()), studentmoduletaken.getText(), Double.parseDouble(studentgrade.getText()), Double.parseDouble(studentresit.getText()));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		btnAssign.setBounds(818, 578, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAssign);
		
		btnDropModule = new JButton("Drop Module");
		btnDropModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.removeTakenMod(Integer.parseInt(studentidmodule.getText()), studentmoduletaken.getText());
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				}
			}
		});
		btnDropModule.setBounds(40, 667, 150, 29);
		frmSystemsDesign.getContentPane().add(btnDropModule);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 699, 1021, 261);
		frmSystemsDesign.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Students", null, panel, null);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Degrees", null, panel_1, null);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Modules", null, panel_3, null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Period Of Study", null, panel_2, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Assigned Modules", null, panel_4, null);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmSystemsDesign.dispose();
					login window = new login();
					window.frmSystemsDesign.setVisible(true);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		btnLogout.setBounds(818, 47, 150, 29);
		frmSystemsDesign.getContentPane().add(btnLogout);
		
		studentmoduletaken = new JTextField();
		studentmoduletaken.setColumns(10);
		studentmoduletaken.setBounds(44, 639, 146, 26);
		frmSystemsDesign.getContentPane().add(studentmoduletaken);
		
		label_1 = new JLabel("Module Code");
		label_1.setBounds(44, 614, 146, 20);
		frmSystemsDesign.getContentPane().add(label_1);
		
		JButton btnAddPos = new JButton("Add PoS");
		btnAddPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StuInfo stu = null;
					stu = s.getStudentInfo(Integer.parseInt(studentidmodule.getText()));
					s.addPoS(Integer.parseInt(studentidmodule.getText()), stu.getPoS(), startdate.getValue().toString(), enddate.getValue().toString(), currentlvl.getSelectedItem().toString().charAt(0));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddPos.setBounds(818, 455, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAddPos);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(312, 431, 146, 20);
		frmSystemsDesign.getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(572, 431, 146, 20);
		frmSystemsDesign.getContentPane().add(lblEndDate);
		
		startdate = new JSpinner();
		startdate.setModel(new SpinnerDateModel(new Date(1535756400000L), new Date(1483228800000L), new Date(1893456000000L), Calendar.DAY_OF_YEAR));
		startdate.setBackground(new Color(240, 240, 240));
		startdate.setBounds(312, 456, 146, 26);
		frmSystemsDesign.getContentPane().add(startdate);
		
		enddate = new JSpinner();
		enddate.setModel(new SpinnerDateModel(new Date(1559343600000L), new Date(1483228800000L), new Date(1893456000000L), Calendar.DAY_OF_YEAR));
		enddate.setBounds(572, 456, 146, 26);
		frmSystemsDesign.getContentPane().add(enddate);
		
		lblCurrentLevel = new JLabel("Current Level");
		lblCurrentLevel.setBounds(312, 490, 146, 20);
		frmSystemsDesign.getContentPane().add(lblCurrentLevel);
		
		currentlvl = new JComboBox();
		currentlvl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "P"}));
		currentlvl.setBounds(312, 515, 146, 26);
		frmSystemsDesign.getContentPane().add(currentlvl);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 547, 964, 7);
		frmSystemsDesign.getContentPane().add(separator_2);
		
		lblPosCode = new JLabel("PoS Code");
		lblPosCode.setBounds(44, 556, 146, 20);
		frmSystemsDesign.getContentPane().add(lblPosCode);
		
		studentidformodule = new JTextField();
		studentidformodule.setColumns(10);
		studentidformodule.setBounds(44, 581, 146, 26);
		frmSystemsDesign.getContentPane().add(studentidformodule);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(220, 612, 79, 80);
		frmSystemsDesign.getContentPane().add(separator_3);
		
	}
}
