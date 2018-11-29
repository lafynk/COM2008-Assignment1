package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import SQLcode.Sql;
import classPkg.Module;
import classPkg.PeriodOfStudy;
import classPkg.StuInfo;
import classPkg.UserInfo;

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
	private JButton btnLogout;
	private JTextField studentmoduletaken;
	private JLabel label_1;
	private JLabel lblCurrentLevel;
	private JComboBox currentlvl;
	private JLabel lblPosCode;
	private JTextField studentidformodule;
	private JSeparator separator_3;
	private JTextField startdate;
	private JTextField enddate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				registrarpage window = null;
				try {
					window = new registrarpage();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.frmSystemsDesign.setVisible(true);
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public registrarpage() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
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
		studenttitle.setModel(new DefaultComboBoxModel(new String[] { "Mr", "Ms" }));
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
		studentpos.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F" }));
		studentpos.setBounds(572, 297, 150, 26);
		frmSystemsDesign.getContentPane().add(studentpos);

		btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();

				try {
					if (s.checkUsernameExists(studentusername.getText())) {
						JOptionPane.showMessageDialog(null, "This username is already in use.", "Operation Failed",
								JOptionPane.ERROR_MESSAGE);
					} else {
						s.addUser(studentusername.getText(), studentpassword.getText(), "Students");
						UserInfo u = s.checkLogIn(studentusername.getText(), studentpassword.getText());
						s.addStudent(u.getRegNo(), studenttitle.getSelectedItem().toString(), studentsname.getText(),
								studentfname.getText(), studenttutor.getText(), studentdegree.getText(),
								studentpos.getSelectedItem().toString().charAt(0), "");

						frmSystemsDesign.dispose();
						registrarpage window = new registrarpage();
						window.frmSystemsDesign.setVisible(true);
						JOptionPane.showMessageDialog(null, "Student Account Created.", "Operation Successful",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
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
					PeriodOfStudy[] pos = s.getPeriodsOfStudy(Integer.parseInt(studentiddelete.getText()));
					for (PeriodOfStudy p : pos) {
						s.removeTakenMods(p.getPosRegCode());
					}
					s.removePoSs(Integer.parseInt(studentiddelete.getText()));
					s.removeStudent(Integer.parseInt(studentiddelete.getText()));
					try {
						s.removeUser(Integer.parseInt(studentiddelete.getText()));
						frmSystemsDesign.dispose();
						registrarpage window = new registrarpage();
						window.frmSystemsDesign.setVisible(true);
						JOptionPane.showMessageDialog(null, "Student Account Deleted.", "Operation Successful",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
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

					s.addTakenModule(Integer.parseInt(studentidformodule.getText()), studentmoduletaken.getText(),
							Double.parseDouble(studentgrade.getText()), Double.parseDouble(studentresit.getText()));
					frmSystemsDesign.dispose();
					registrarpage window = new registrarpage();
					window.frmSystemsDesign.setVisible(true);
					JOptionPane.showMessageDialog(null, "Module Assigned.", "Operation Successful",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
			}
		});
		btnAssign.setBounds(818, 578, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAssign);

		btnDropModule = new JButton("Drop Module");
		btnDropModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.removeTakenMod(Integer.parseInt(studentidformodule.getText()), studentmoduletaken.getText());
					frmSystemsDesign.dispose();
					registrarpage window = new registrarpage();
					window.frmSystemsDesign.setVisible(true);
					JOptionPane.showMessageDialog(null, "Module Dropped.", "Operation Successful",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
			}
		});
		btnDropModule.setBounds(40, 667, 150, 29);
		frmSystemsDesign.getContentPane().add(btnDropModule);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 699, 1021, 261);
		frmSystemsDesign.getContentPane().add(tabbedPane);

		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmSystemsDesign.dispose();
					login window = new login();
					window.frmSystemsDesign.setVisible(true);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
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
					Module mod = null;
					stu = s.getStudentInfo(Integer.parseInt(studentidmodule.getText()));

					s.addPoS(Integer.parseInt(studentidmodule.getText()), stu.getPoS(), startdate.getText(),
							enddate.getText(), currentlvl.getSelectedItem().toString().charAt(0));
					Module[] modulearray = new Module[] {};
					modulearray = s.getCoreModules(stu.getDegree(), currentlvl.getSelectedItem().toString().charAt(0));
					PeriodOfStudy[] p = s.getPeriodsOfStudy(stu.getRegNo());
					int i = 0;
					for (PeriodOfStudy pos : p) {
						if (stu.getPoS() == pos.getPoS()) {
							i = pos.getPosRegCode();
						}
					}
					for (Module x : modulearray) {
						s.addTakenModule(i, x.getModule(), 0.00, 0.00);
					}
					frmSystemsDesign.dispose();
					registrarpage window = new registrarpage();
					window.frmSystemsDesign.setVisible(true);
					JOptionPane.showMessageDialog(null, "Period of Study added." + modulearray, "Operation Successful",
							JOptionPane.INFORMATION_MESSAGE);
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

		lblCurrentLevel = new JLabel("Current Level");
		lblCurrentLevel.setBounds(312, 490, 146, 20);
		frmSystemsDesign.getContentPane().add(lblCurrentLevel);

		currentlvl = new JComboBox();
		currentlvl.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "P" }));
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

		startdate = new JTextField();
		startdate.setText("YYYY-MM-DD");
		startdate.setBounds(312, 458, 133, 26);
		frmSystemsDesign.getContentPane().add(startdate);
		startdate.setColumns(10);

		enddate = new JTextField();
		enddate.setText("YYYY-MM-DD");
		enddate.setColumns(10);
		enddate.setBounds(572, 458, 133, 26);
		frmSystemsDesign.getContentPane().add(enddate);

		//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Student Accounts", null, scrollPane, null);
		scrollPane.setViewportBorder(null);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		model.addColumn("Student ID");
		model.addColumn("Title");
		model.addColumn("Surname");
		model.addColumn("Forename");
		model.addColumn("Email");
		model.addColumn("Tutor");
		model.addColumn("Degree Code");
		model.addColumn("Current Level Of Study");
		model.addColumn("Awarded Class");

		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM Students");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData md = res.getMetaData();
			while (res.next()) {
				int reg = res.getInt(1);
				String regno = res.getString(1);
				String title = res.getString(2);
				String sname = res.getString(3);
				String fname = res.getString(4);
				String email = res.getString(5);
				String tutor = res.getString(6);
				String dcode = res.getString(7);
				String currentlvlos = res.getString(8);
				String awardedclass = res.getString(9);
				String awardedclassstring = null;
				if (awardedclass == null) {
					awardedclassstring = "In Progress";
				}
				model.addRow(new Object[] { regno, title, sname, fname, email, tutor, dcode, currentlvlos,
						awardedclassstring });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			new login();
		}
		scrollPane.setViewportView(table);
//////////////////////////////////////////////////////////////////////////////////////////
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Departments", null, scrollPane_1, null);
		DefaultTableModel model_1 = new DefaultTableModel();
		JTable table_1 = new JTable(model_1);

		model_1.addColumn("Department Code");
		model_1.addColumn("Department Name");

		try {

			pstmt = con.prepareStatement("SELECT * FROM Departments");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData md = res.getMetaData();
			while (res.next()) {
				String dcode = res.getString(1);
				String dname = res.getString(2);
				model_1.addRow(new Object[] { dcode, dname });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		scrollPane_1.setViewportView(table_1);
//////////////////////////////////////////////////////////////////////////////////
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Degrees", null, scrollPane_2, null);
		DefaultTableModel model_2 = new DefaultTableModel();
		JTable table_2 = new JTable(model_2);

		model_2.addColumn("Degree Code");
		model_2.addColumn("Degree Name");
		model_2.addColumn("Department Code");
		model_2.addColumn("Max Level Of Study");
		model_2.addColumn("Placement");

		try {

			pstmt = con.prepareStatement("SELECT * FROM Degrees");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData md = res.getMetaData();
			while (res.next()) {
				String dcode = res.getString(1);
				String dname = res.getString(2);
				String depname = res.getString(3);
				String maxlvlstudy = res.getString(4);
				String placementpossible = res.getString(5);
				String placementstring = null;
				if (placementpossible.contentEquals("0")) {
					placementstring = "No";
				} else {
					placementstring = "Yes";
				}
				model_2.addRow(new Object[] { dcode, dname, depname, maxlvlstudy, placementstring });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		scrollPane_2.setViewportView(table_2);
//////////////////////////////////////////////////////////////////////////////////
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("Modules", null, scrollPane_3, null);
		DefaultTableModel model_3 = new DefaultTableModel();
		JTable table_3 = new JTable(model_3);

		model_3.addColumn("Module Code");
		model_3.addColumn("Module Name");
		model_3.addColumn("When Taught");

		try {

			pstmt = con.prepareStatement("SELECT * FROM Modules");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData md = res.getMetaData();
			while (res.next()) {
				String mcode = res.getString(1);
				String mname = res.getString(2);
				String whentaught = res.getString(3);

				model_3.addRow(new Object[] { mcode, mname, whentaught });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		scrollPane_3.setViewportView(table_3);
//////////////////////////////////////////////////////////////////////////////////
		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("Assigned Modules", null, scrollPane_4, null);
		DefaultTableModel model_4 = new DefaultTableModel();
		JTable table_4 = new JTable(model_4);

		model_4.addColumn("Degree Code");
		model_4.addColumn("Module Code");
		model_4.addColumn("Core");
		model_4.addColumn("Credits");
		model_4.addColumn("Level Taught At");

		try {

			pstmt = con.prepareStatement("SELECT * FROM ModuleAssignment");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData md = res.getMetaData();
			while (res.next()) {
				String dcode = res.getString(1);
				String mcode = res.getString(2);
				String coretf = res.getString(3);
				String creditnum = res.getString(4);
				String lvltaughtat = res.getString(5);
				String coretfstring = null;
				if (coretf.contentEquals("0")) {
					coretfstring = "No";
				} else {
					coretfstring = "Yes";
				}
				model_4.addRow(new Object[] { dcode, mcode, coretfstring, creditnum, lvltaughtat });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		scrollPane_4.setViewportView(table_4);

//////////////////////////////////////////////////////////////////////////////////
		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("Periods Of Study", null, scrollPane_5, null);
		DefaultTableModel model_5 = new DefaultTableModel();
		JTable table_5 = new JTable(model_5);

		model_5.addColumn("PoS Code");
		model_5.addColumn("Student RegNo");
		model_5.addColumn("Period Of Study");
		model_5.addColumn("Start Date");
		model_5.addColumn("End Date");
		model_5.addColumn("Current Level");
		model_5.addColumn("Grade");
		model_5.addColumn("Progress");

		try {

			pstmt = con.prepareStatement("SELECT * FROM PeriodsOfStudy");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData md = res.getMetaData();
			while (res.next()) {
				String poscode = res.getString(1);
				String reg = res.getString(2);
				String pos = res.getString(3);
				String start = res.getString(4);
				String end = res.getString(5);
				String lvl = res.getString(6);
				String grade = res.getString(7);
				String progress = res.getString(8);
				String progressstring = null;
				if (progress.contentEquals("0")) {
					progressstring = "No";
				} else {
					progressstring = "Yes";
				}

				model_5.addRow(new Object[] { poscode, reg, pos, start, end, lvl, grade, progressstring });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		scrollPane_5.setViewportView(table_5);
//////////////////////////////////////////////
		JScrollPane scrollPane_6 = new JScrollPane();
		tabbedPane.addTab("Modules Taken", null, scrollPane_6, null);
		DefaultTableModel model_6 = new DefaultTableModel();
		JTable table_6 = new JTable(model_6);

		model_6.addColumn("PoS Code");
		model_6.addColumn("Module Code");
		model_6.addColumn("Grade");
		model_6.addColumn("Resit");

		try {

			pstmt = con.prepareStatement("SELECT * FROM ModuleTaken");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData md = res.getMetaData();
			while (res.next()) {
				String poscode = res.getString(1);
				String modcode = res.getString(2);
				String grade = res.getString(3);
				String resit = res.getString(4);

				model_6.addRow(new Object[] { poscode, modcode, grade, resit });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
		}
		scrollPane_6.setViewportView(table_6);
	}
}