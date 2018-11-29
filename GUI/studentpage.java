package GUI;
import java.awt.*;
import javax.swing.*;
//import java.sql.SQLException;
//import java.sql.*;
//import SQLcode.Sql;
//classPkg.UserInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//---------------------------------------------------------------------------------------------------------

public class studentpage extends JFrame {
	public static void main(String[] args) {
		 // launching code goes in here
			 new studentpage();
		 }
	 
public studentpage() throws HeadlessException {
	
	JFrame window = new JFrame("Systems Design & Security: Team Project");
	 window.setVisible(true);
	 window.setSize(1000,1000);
	 window.setResizable(false);
	 //window.setLayout(new FlowLayout());
	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 //panel for components to be added too.
	 JPanel panel = new JPanel();
	 panel.setLayout(null);
	 window.add(panel);
	
	 //student label
	JLabel studentlabel = new JLabel("Student Dashboard");
	studentlabel.setBounds(10,10,300,50);
	studentlabel.setFont(new Font("", Font.PLAIN, 30));
	panel.add(studentlabel);
	
	//welcome label
	JLabel welcomelabel = new JLabel("Welcome to your home page your current status is:");
	welcomelabel.setBounds(10,80,500,50);
	welcomelabel.setFont(new Font("", Font.PLAIN, 20));
	panel.add(welcomelabel);
	
	JButton addmodulebutton = new JButton("View Status");
	addmodulebutton.setBounds(470,100,130,40);
	panel.add(addmodulebutton);
	addmodulebutton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  //getModules
		   }
	});
	
	//Text area where grades will go 
	JTextArea textA = new JTextArea(200,200);
	textA .setBounds(10, 170, 973, 780);
	panel.add(textA);
	
window.repaint();	 
}
}