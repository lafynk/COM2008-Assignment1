package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;

import SQLcode.Sql;
import classPkg.UserInfo;


public class login extends JFrame {

	 public static void main(String[] args) throws HeadlessException, SQLException {
		 // launching code goes in here
			 new login();
		 }

public login() throws HeadlessException, SQLException {
	Sql s = new Sql();
	JFrame window = new JFrame("Systems Design & Security: Team Project");
	 window.setLayout(new FlowLayout());
	 window.setSize(1000,1000);
	 window.setVisible(true);
	 window.setResizable(false);
	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




	 JTextField username = new JTextField();
	 username.setBounds(400,400,200,50);
	 window.add(username);
	 
	 JTextField password = new JTextField();
	 password.setBounds(400,500,200,50);
	 window.add(password);


	 JButton loginbutton = new JButton("Login");
	 loginbutton.setBounds(400,600,200,50);
	 window.add(loginbutton);
	 loginbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        //window.exit();


			//	UserInfo u = null;
			
				UserInfo u=null;
				try {
					u = s.checkLogIn(username.getText(), password.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		

			if (u != null){
				window.dispose();
				if (u.getPermission() == "Students"){
					new studentpage();
				}
				else if (u.getPermission() == "Teachers"){
					new teacherpage();
				}
				else if (u.getPermission() == "Admin"){
					new adminpage();
				}
				else if (u.getPermission() == "Registrars"){
					try {
						new registrarpage();
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Username or password is incorrect","Login Failure!", JOptionPane.ERROR_MESSAGE);
			}
    }
    });

	 JLabel usernamelabel = new JLabel("Username");
	 usernamelabel.setBounds(400,340,200,50);
	 window.add(usernamelabel);

	 JLabel pwdlabel = new JLabel("Password");
	 pwdlabel.setBounds(400,440,200,50);
	 window.add(pwdlabel);


	 window.repaint();

 }

}
