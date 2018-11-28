package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;

import SQLcode.Sql;
import classPkg.UserInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

	JFrame frmSystemsDesign;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
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
		
		JLabel lblSystemLogin = new JLabel("System Login");
		lblSystemLogin.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblSystemLogin.setBounds(360, 115, 486, 186);
		frmSystemsDesign.getContentPane().add(lblSystemLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUsername.setBounds(386, 348, 164, 42);
		frmSystemsDesign.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(386, 406, 262, 47);
		frmSystemsDesign.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword.setBounds(386, 516, 164, 42);
		frmSystemsDesign.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(386, 574, 262, 47);
		frmSystemsDesign.getContentPane().add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfo u=null;
				try {
					u = s.checkLogIn(username.getText(), password.getText());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
		

			if (u != null){
				frmSystemsDesign.dispose();
				if (u.getPermission().contentEquals("Students")){
					new studentpage();
				}
				else if (u.getPermission().contentEquals("Teachers")){
					new teacherpage();
				}
				else if (u.getPermission().contentEquals("Admin")){
					adminpage window = null;
					try {
						window = new adminpage();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Could not open window. Too many connections.","Error!", JOptionPane.ERROR_MESSAGE);
					}
					window.frmSystemsDesign.setVisible(true);
				}
				else if (u.getPermission().contentEquals("Registrars")){
					registrarpage window = null;
					try {
						window = new registrarpage();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Could not open window. Too many connections.","Error!", JOptionPane.ERROR_MESSAGE);
					}
					window.frmSystemsDesign.setVisible(true);
						
				
				}
				else {
					
					JOptionPane.showMessageDialog(null, "User permissions could not be determined","Login Failure!", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Username or password is incorrect","Login Failure!", JOptionPane.ERROR_MESSAGE);
			}
   
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(386, 722, 262, 71);
		frmSystemsDesign.getContentPane().add(btnLogin);
	}

}
