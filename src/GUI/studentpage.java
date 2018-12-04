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
	Sql s = new Sql();
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
	logButton.setBounds(845,10,130,49);
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
	//pos reg text
	JTextField Regg = new JTextField("Enter Registration Number");
	Regg.setBounds(10,130,200,50);
	panel.add(Regg);
	
	JButton getPosbutton = new JButton("Get PoS");
	getPosbutton.setBounds(220,130,130,49);
	panel.add(getPosbutton);
	getPosbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JTabbedPane tabbedPane11 = new JTabbedPane(JTabbedPane.TOP);
			  tabbedPane11.setBounds(10, 260, 955, 320);
			  panel.add(tabbedPane11);
			  
			  //sets up
			  JScrollPane scrollPane11 = new JScrollPane();
			  tabbedPane11.addTab("All Period of Study", null, scrollPane11, null);
			  scrollPane11.setViewportBorder(null);
			  
			  DefaultTableModel model12 = new DefaultTableModel();
			  JTable table12 = new JTable(model12);
			  
			//making columns to match the database
			  model12.addColumn("PosResCode"); 
			  
			  PreparedStatement pstmt = null;
			  Connection con = null;
		  try {
				//setting up connection and query statement to get information required
				  con = s.setUpConnection();
				  Integer nEReg1 = Integer.parseInt(Regg.getText());
				  pstmt = con.prepareStatement("SELECT * FROM PeriodsOfStudy WHERE RegistrationNo = '"+nEReg1+"'");
				  ResultSet res = pstmt.executeQuery();
				  ResultSetMetaData md = res.getMetaData();
				  while (res.next()) {
						String poscode = res.getString(1);
						//add the information in rows under the correct columns
						model12.addRow(new Object[] {poscode});
					}
			  } catch (SQLException ex) {
				  ex.printStackTrace();
				  JOptionPane.showMessageDialog(null, "Registration not recognised try again","Error!", JOptionPane.ERROR_MESSAGE);
			  }
			   scrollPane11.setViewportView(table12);
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
	
	//pos reg text
	JTextField eReg = new JTextField("Enter PoS Number");
	eReg.setBounds(10,200,200,50);
	panel.add(eReg);
	
	//button to view status
	JButton viewButton = new JButton("View Status");
	viewButton.setBounds(220,200,130,49);
	panel.add(viewButton);
	viewButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  //sets up tabbed pane which will be displayed
			  JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			  tabbedPane.setBounds(10, 580, 955, 360);
			  panel.add(tabbedPane);
			  
			  //sets up
			  JScrollPane scrollPane = new JScrollPane();
			  tabbedPane.addTab("Period of Study", null, scrollPane, null);
			  scrollPane.setViewportBorder(null);
			  
			  DefaultTableModel model1 = new DefaultTableModel();
			  JTable table1 = new JTable(model1);
			  
			//making columns to match the database
			  model1.addColumn("PosResCode");
			  model1.addColumn("Module Code");
			  model1.addColumn("Grade");
			  model1.addColumn("Resit Grade");
			  
			  PreparedStatement pstmt = null;
			  Connection con = null;
			  try {
				//setting up connection and query statement to get information required
				  con = s.setUpConnection();
				  Integer nEReg = Integer.parseInt(eReg.getText());
				  pstmt = con.prepareStatement("SELECT * FROM ModuleTaken WHERE PosRegCode = '"+nEReg+"'");
				  ResultSet res = pstmt.executeQuery();
				  ResultSetMetaData md = res.getMetaData();
				  while (res.next()) {
						String poscode = res.getString(1);
						String regP = res.getString(2);
						String grade = res.getString(3);
						String rgrade = res.getString(4);
						//add the information in rows under the correct columns
						model1.addRow(new Object[] {poscode, regP, grade, rgrade});
					}
			  } catch (SQLException ex) {
				  ex.printStackTrace();
				  JOptionPane.showMessageDialog(null, "Registration not recognised try again","Error!", JOptionPane.ERROR_MESSAGE);
			  }
			   scrollPane.setViewportView(table1);
			   
			   JScrollPane scrollPane_1 = new JScrollPane();
			   tabbedPane.addTab("Overall Progress", null, scrollPane_1, null);
			   DefaultTableModel model_1 = new DefaultTableModel();
			   JTable table_1 = new JTable(model_1);
			   
			   model_1.addColumn("PoS Code");
			   model_1.addColumn("Student RegNo");
			   model_1.addColumn("Period Of Study");
			   model_1.addColumn("Start Date");
			   model_1.addColumn("End Date");
			   model_1.addColumn("Current Level");
			   model_1.addColumn("Grade");
			   model_1.addColumn("Progress");
				
			   try {
				 //setting up connection and query statement to get information required
				   con = s.setUpConnection();
				   Integer nEReg = Integer.parseInt(eReg.getText());
				   pstmt = con.prepareStatement("SELECT * FROM PeriodsOfStudy WHERE PosRegCode = '"+nEReg+"'");
				   ResultSet res = pstmt.executeQuery();
				   ResultSetMetaData md = res.getMetaData();
				   while (res.next()) {
						String poscode = res.getString(1);
						String regP = res.getString(2);
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
						//add the information in rows under the correct columns
						model_1.addRow(new Object[] { poscode, regP, pos, start, end, lvl, grade, progressstring });
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					  JOptionPane.showMessageDialog(null, "Registration not recognised try again","Error!", JOptionPane.ERROR_MESSAGE);
				}
			   scrollPane_1.setViewportView(table_1);
		  }
	});
	

	
window.repaint();	 
}
}