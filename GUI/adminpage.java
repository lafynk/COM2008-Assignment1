package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import SQLcode.Sql;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class adminpage {

	JFrame frmSystemsDesign;
	private JTextField useraccountid;
	private JTextField useraccountpwd;
	private JTextField useraccount;
	private JTextField departmentcode;
	private JTextField department;
	private JTextField degreecode;
	private JTextField degree;
	private JTextField modulecode;
	private JTextField module;
	private JTextField degreetoaddmodule;
	private JTextField moduletoadd;
	private JTextField credits;
	private JTextField depttoadddegree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpage window = new adminpage();
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
	public adminpage() {
		initialize();
}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Sql s = new Sql();
		frmSystemsDesign = new JFrame();
		frmSystemsDesign.setLocation(100, 0);
		frmSystemsDesign.setSize(1000,1000);
		frmSystemsDesign.setTitle("Systems Design & Security: Team Project");
		frmSystemsDesign.setResizable(false);
		frmSystemsDesign.getContentPane().setLayout(null);
		
		JLabel lblAdminDashboard = new JLabel("Admin Dashboard");
		lblAdminDashboard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAdminDashboard.setBounds(360, 16, 311, 29);
		frmSystemsDesign.getContentPane().add(lblAdminDashboard);
		
		useraccountid = new JTextField();
		useraccountid.setBounds(292, 164, 146, 26);
		frmSystemsDesign.getContentPane().add(useraccountid);
		useraccountid.setColumns(10);
		
		useraccountpwd = new JTextField();
		useraccountpwd.setBounds(292, 97, 146, 26);
		frmSystemsDesign.getContentPane().add(useraccountpwd);
		useraccountpwd.setColumns(10);
		
		useraccount = new JTextField();
		useraccount.setBounds(35, 97, 146, 26);
		frmSystemsDesign.getContentPane().add(useraccount);
		useraccount.setColumns(10);
		
		JComboBox accttype = new JComboBox();
		accttype.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Teachers", "Registrars"}));
		accttype.setBounds(546, 97, 150, 26);
		frmSystemsDesign.getContentPane().add(accttype);
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    
				try {
					if (s.checkUsernameExists(useraccount.getText())) {
						JOptionPane.showMessageDialog(null, "This username is already in use.","Operation Failed", JOptionPane.ERROR_MESSAGE);
					}
					else {
						s.addUser(useraccount.getText(), useraccountpwd.getText(), accttype.getSelectedItem().toString());
					}
				   
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchProviderException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddAccount.setBounds(791, 96, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAddAccount);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 145, 948, 2);
		frmSystemsDesign.getContentPane().add(separator);
		
		JLabel lblAccountUsername = new JLabel("Account Username");
		lblAccountUsername.setBounds(35, 61, 146, 20);
		frmSystemsDesign.getContentPane().add(lblAccountUsername);
		
		JLabel lblAccountPassword = new JLabel("Account Password");
		lblAccountPassword.setBounds(292, 61, 146, 20);
		frmSystemsDesign.getContentPane().add(lblAccountPassword);
		
		JLabel lblAccountId = new JLabel("Account ID");
		lblAccountId.setBounds(199, 167, 134, 20);
		frmSystemsDesign.getContentPane().add(lblAccountId);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.removeUser(Integer.parseInt(useraccountid.getText()));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteAccount.setBounds(546, 163, 150, 29);
		frmSystemsDesign.getContentPane().add(btnDeleteAccount);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 201, 948, 2);
		frmSystemsDesign.getContentPane().add(separator_1);
		
		departmentcode = new JTextField();
		departmentcode.setBounds(35, 232, 146, 26);
		frmSystemsDesign.getContentPane().add(departmentcode);
		departmentcode.setColumns(10);
		
		JLabel lblDegreeCode = new JLabel("Department Code");
		lblDegreeCode.setBounds(35, 208, 134, 20);
		frmSystemsDesign.getContentPane().add(lblDegreeCode);
		
		department = new JTextField();
		department.setBounds(292, 232, 146, 26);
		frmSystemsDesign.getContentPane().add(department);
		department.setColumns(10);
		
		JLabel lblDegreeName = new JLabel("Department Name");
		lblDegreeName.setBounds(292, 208, 146, 20);
		frmSystemsDesign.getContentPane().add(lblDegreeName);
		
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.addDep(departmentcode.getText(), department.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					///e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddDepartment.setBounds(546, 231, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAddDepartment);
		
		JButton btnDeleteDepartment = new JButton("Delete Department");
		btnDeleteDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.removeDeps(departmentcode.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteDepartment.setBounds(35, 274, 164, 29);
		frmSystemsDesign.getContentPane().add(btnDeleteDepartment);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(15, 307, 948, 2);
		frmSystemsDesign.getContentPane().add(separator_3);
		
		JLabel lblDegreeCode_1 = new JLabel("Degree Code");
		lblDegreeCode_1.setBounds(35, 316, 146, 20);
		frmSystemsDesign.getContentPane().add(lblDegreeCode_1);
		
		degreecode = new JTextField();
		degreecode.setBounds(35, 340, 146, 26);
		frmSystemsDesign.getContentPane().add(degreecode);
		degreecode.setColumns(10);
		
		JLabel lblDegreeName_1 = new JLabel("Degree Name");
		lblDegreeName_1.setBounds(292, 316, 146, 20);
		frmSystemsDesign.getContentPane().add(lblDegreeName_1);
		
		degree = new JTextField();
		degree.setColumns(10);
		degree.setBounds(292, 340, 146, 26);
		frmSystemsDesign.getContentPane().add(degree);
		
		JLabel lblMaxLevelOf = new JLabel("Max Level Of Study");
		lblMaxLevelOf.setBounds(550, 316, 146, 20);
		frmSystemsDesign.getContentPane().add(lblMaxLevelOf);
		
		JComboBox degreelvl = new JComboBox();
		degreelvl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		degreelvl.setBounds(546, 340, 150, 26);
		frmSystemsDesign.getContentPane().add(degreelvl);
		
		JComboBox placement = new JComboBox();
		placement.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		placement.setBounds(546, 406, 150, 26);
		frmSystemsDesign.getContentPane().add(placement);
		
		JLabel lblPlacement = new JLabel("Placement?");
		lblPlacement.setBounds(550, 382, 146, 20);
		frmSystemsDesign.getContentPane().add(lblPlacement);
		
		JComboBox type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"Undergraduate", "Postgraduate"}));
		type.setBounds(791, 406, 150, 26);
		frmSystemsDesign.getContentPane().add(type);
		
		JButton btnAddDegree = new JButton("Add Degree");
		btnAddDegree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Boolean placementgoing;
					if (placement.getSelectedItem().toString() == "Yes") {
						placementgoing = true;
					}
					else {
						placementgoing = false;
					}
					String shorttype;
					if (type.getSelectedItem().toString() == "Undergraduate") {
						shorttype = "U";
					}
					else {
						shorttype = "P";
					}//degreecode.getText(),
					s.addCourse(degree.getText(), depttoadddegree.getText(), degreelvl.getSelectedItem().toString(), placementgoing, shorttype);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddDegree.setBounds(791, 339, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAddDegree);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(235, 234, 24, 69);
		frmSystemsDesign.getContentPane().add(separator_4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(235, 363, 24, 69);
		frmSystemsDesign.getContentPane().add(separator_2);
		
		JButton btnDeleteDegree = new JButton("Delete Degree");
		btnDeleteDegree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.removeCourse(degreecode.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				//	JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteDegree.setBounds(35, 405, 150, 29);
		frmSystemsDesign.getContentPane().add(btnDeleteDegree);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(15, 440, 948, 2);
		frmSystemsDesign.getContentPane().add(separator_5);
		
		JLabel lblModuleCode = new JLabel("Department Code");
		lblModuleCode.setBounds(35, 451, 146, 20);
		frmSystemsDesign.getContentPane().add(lblModuleCode);
		
		modulecode = new JTextField();
		modulecode.setColumns(10);
		modulecode.setBounds(35, 475, 146, 26);
		frmSystemsDesign.getContentPane().add(modulecode);
		
		JLabel lblModuleName = new JLabel("Module Name");
		lblModuleName.setBounds(292, 451, 146, 20);
		frmSystemsDesign.getContentPane().add(lblModuleName);
		
		module = new JTextField();
		module.setColumns(10);
		module.setBounds(292, 475, 146, 26);
		frmSystemsDesign.getContentPane().add(module);
		
		JLabel lblWhenTaught = new JLabel("When Taught");
		lblWhenTaught.setBounds(546, 451, 146, 20);
		frmSystemsDesign.getContentPane().add(lblWhenTaught);
		
		JComboBox modulewhentaught = new JComboBox();
		modulewhentaught.setModel(new DefaultComboBoxModel(new String[] {"Autumn", "Spring", "Summer", "Year"}));
		modulewhentaught.setBounds(546, 475, 150, 26);
		frmSystemsDesign.getContentPane().add(modulewhentaught);
		
		JButton btnAddModule = new JButton("Add Module");
		btnAddModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.addModule(modulecode.getText(), module.getText(), modulewhentaught.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddModule.setBounds(791, 474, 150, 29);
		frmSystemsDesign.getContentPane().add(btnAddModule);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(15, 552, 948, 2);
		frmSystemsDesign.getContentPane().add(separator_6);
		
		JLabel lblDegreeCode_2 = new JLabel("Degree Code");
		lblDegreeCode_2.setBounds(35, 552, 146, 20);
		frmSystemsDesign.getContentPane().add(lblDegreeCode_2);
		
		degreetoaddmodule = new JTextField();
		degreetoaddmodule.setColumns(10);
		degreetoaddmodule.setBounds(35, 576, 146, 26);
		frmSystemsDesign.getContentPane().add(degreetoaddmodule);
		
		JLabel label_1 = new JLabel("Module Code");
		label_1.setBounds(292, 552, 146, 20);
		frmSystemsDesign.getContentPane().add(label_1);
		
		moduletoadd = new JTextField();
		moduletoadd.setColumns(10);
		moduletoadd.setBounds(292, 576, 146, 26);
		frmSystemsDesign.getContentPane().add(moduletoadd);
		
		JLabel lblCore = new JLabel("Core?");
		lblCore.setBounds(550, 552, 146, 20);
		frmSystemsDesign.getContentPane().add(lblCore);
		
		JComboBox core = new JComboBox();
		core.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		core.setBounds(546, 576, 150, 26);
		frmSystemsDesign.getContentPane().add(core);
		
		JLabel lblLevelOfStudy = new JLabel("Level Of Study");
		lblLevelOfStudy.setBounds(550, 607, 146, 20);
		frmSystemsDesign.getContentPane().add(lblLevelOfStudy);
		
		JComboBox modulelvl = new JComboBox();
		modulelvl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "P"}));
		modulelvl.setBounds(546, 631, 150, 26);
		frmSystemsDesign.getContentPane().add(modulelvl);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(292, 607, 146, 20);
		frmSystemsDesign.getContentPane().add(lblCredits);
		
		credits = new JTextField();
		credits.setColumns(10);
		credits.setBounds(292, 631, 146, 26);
		frmSystemsDesign.getContentPane().add(credits);
		
		JButton btnAssignModule = new JButton("<html>Assign module to degree</html>");
		btnAssignModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Boolean coreornot;
					if (core.getSelectedItem().toString() == "Yes") {
						coreornot = true;
					}
					else {
						coreornot = false;
					}
					s.assignModuleToDegree(degreetoaddmodule.getText(), moduletoadd.getText(), coreornot, Integer.parseInt(credits.getText()), modulelvl.getSelectedItem().toString());
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAssignModule.setBounds(791, 575, 150, 82);
		frmSystemsDesign.getContentPane().add(btnAssignModule);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 673, 994, 287);
		frmSystemsDesign.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("User Accounts", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Departments", null, panel_1, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Degrees", null, panel_3, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Modules", null, panel_2, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Assigned Modules", null, panel_4, null);
		
		JButton btnDeleteModule = new JButton("<html>Delete Module\r\n(Enter Module Code above)");
		btnDeleteModule.setVerticalAlignment(SwingConstants.TOP);
		btnDeleteModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.removeMod(modulecode.getText());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.","Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteModule.setBounds(35, 501, 195, 45);
		frmSystemsDesign.getContentPane().add(btnDeleteModule);
		
		JLabel lblDepartmentToAdd = new JLabel("Department to add degree to");
		lblDepartmentToAdd.setBounds(292, 382, 220, 20);
		frmSystemsDesign.getContentPane().add(lblDepartmentToAdd);
		
		depttoadddegree = new JTextField();
		depttoadddegree.setColumns(10);
		depttoadddegree.setBounds(292, 406, 146, 26);
		frmSystemsDesign.getContentPane().add(depttoadddegree);
		
		JButton btnLogout = new JButton("Logout");
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
		btnLogout.setBounds(826, 22, 115, 29);
		frmSystemsDesign.getContentPane().add(btnLogout);
		
		JLabel lblUgPg = new JLabel("UG / PG");
		lblUgPg.setBounds(795, 382, 146, 20);
		frmSystemsDesign.getContentPane().add(lblUgPg);
		
		
		

	}
}
