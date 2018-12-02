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

import javax.swing.DefaultComboBoxModel;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import SQLcode.Sql;

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
	 
	//Log out button and position
	JButton logButton = new JButton("Log out");
	logButton.setBounds(700,130,130,49);
	panel.add(logButton);
	logButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				window.dispose();
				login window = new login();
				window.frmSystemsDesign.setVisible(true);
			} catch (HeadlessException e1) {
					
			}
		}
	});
	
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
	
	JTextField eReg = new JTextField("Enter Registration Number");
	eReg.setBounds(10,130,200,50);
	panel.add(eReg);

	
	JButton addmodulebutton = new JButton("View Status");
	addmodulebutton.setBounds(220,130,130,49);
	panel.add(addmodulebutton);
	addmodulebutton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  //getModules	
			  JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			  tabbedPane.setBounds(10, 170, 973, 780);
			  panel.add(tabbedPane);
	
			  JScrollPane scrollPane = new JScrollPane();
			  tabbedPane.addTab("Progress", null, scrollPane, null);
			  scrollPane.setViewportBorder(null);
			  
			  DefaultTableModel model1 = new DefaultTableModel();
			  JTable table1 = new JTable(model1);
			  
			  model1.addColumn("PosResCode");
			  model1.addColumn("Registration No");
			  model1.addColumn("Perioid of Study");
			  model1.addColumn("Start Date");
			  model1.addColumn("End Date");
			  model1.addColumn("Current Level");
			  model1.addColumn("Grade");
			  model1.addColumn("Progress");
			  
			  PreparedStatement pstmt = null;
			  Connection con = null;
			  /**try {
				  con = s.setUpConnection();
				  pstmt = con.preparedStatement("SELECT")
			  }*/
			  
			  scrollPane.setViewportView(table1);
			


		   }
	});
	

	
window.repaint();	 
}
}