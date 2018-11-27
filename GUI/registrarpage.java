package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import SQLcode.Sql;
import classPkg.UserInfo;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

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
	private JLabel lblModuleCode;
	private JTextField studentmoduletaken;
	private JLabel lblGrade;
	private JTextField studentgrade;
	private JLabel lblResitGrade;
	private JTextField studentresit;
	private JButton btnAssign;
	private JButton btnDropModule;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnLogout;

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
				int randReg = rand.nextInt(900000000);
				try {
					
					s.addUser(studentusername.getText(), studentpassword.getText(), "Students");
					UserInfo u = null;
					u =s.checkLogIn(studentusername.getText(), studentpassword.getText());
					s.addStudent((u.getRegNo()), studenttitle.getSelectedItem().toString(), studentsname.getText(),studentfname.getText(), studenttutor.getText(), studentdegree.getText(), studentpos.getSelectedItem().toString().charAt(0), "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
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
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					s.removeUser(Integer.parseInt(studentiddelete.getText()));
					
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
		lblStudentId_1.setBounds(44, 444, 146, 20);
		frmSystemsDesign.getContentPane().add(lblStudentId_1);
		
		studentidmodule = new JTextField();
		studentidmodule.setColumns(10);
		studentidmodule.setBounds(44, 469, 146, 26);
		frmSystemsDesign.getContentPane().add(studentidmodule);
		
		lblModuleCode = new JLabel("Module Code");
		lblModuleCode.setBounds(312, 444, 146, 20);
		frmSystemsDesign.getContentPane().add(lblModuleCode);
		
		studentmoduletaken = new JTextField();
		studentmoduletaken.setColumns(10);
		studentmoduletaken.setBounds(312, 469, 146, 26);
		frmSystemsDesign.getContentPane().add(studentmoduletaken);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setBounds(572, 444, 146, 20);
		frmSystemsDesign.getContentPane().add(lblGrade);
		
		studentgrade = new JTextField();
		studentgrade.setText("0");
		studentgrade.setColumns(10);
		studentgrade.setBounds(572, 469, 146, 26);
		frmSystemsDesign.getContentPane().add(studentgrade);
		
		lblResitGrade = new JLabel("Resit Grade");
		lblResitGrade.setBounds(572, 502, 146, 20);
		frmSystemsDesign.getContentPane().add(lblResitGrade);
		
		studentresit = new JTextField();
		studentresit.setText("0");
		studentresit.setColumns(10);
		studentresit.setBounds(572, 527, 146, 26);
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
		btnAssign.setBounds(818, 468, 150, 29);
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
		btnDropModule.setBounds(44, 526, 150, 29);
		frmSystemsDesign.getContentPane().add(btnDropModule);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(514, 487, 2, 52);
		frmSystemsDesign.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(15, 569, 964, 7);
		frmSystemsDesign.getContentPane().add(separator_3);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 592, 1021, 368);
		frmSystemsDesign.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Students", null, panel, null);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Degrees", null, panel_1, null);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Modules", null, panel_3, null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Departments", null, panel_2, null);
		
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
	}

}
