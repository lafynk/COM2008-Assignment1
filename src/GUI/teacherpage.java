package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import SQLcode.Sql;

import java.awt.event.ActionListener;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**import SQLcode.Sql;
import java.sql.SQLException;
 */


public class teacherpage extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 4540369166472097474L;

	public static void main(String[] args) {
		 // launching code goes in here
			 new teacherpage();
		 };
	 
public teacherpage() throws HeadlessException {
	Sql s = new Sql();
	JFrame window = new JFrame("Systems Design & Security: Team Project");
	window.setVisible(true);
    window.setSize(1000,1000);
	window.setResizable(false);
	//window.setLayout(new FlowLayout());
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel panel = new JPanel();
	panel.setLayout(null);
	window.add(panel);
	 
	JLabel teacherlabel = new JLabel("Teacher Dashboard");
	teacherlabel.setBounds(10,10,300,50);
	teacherlabel.setFont(new Font("", Font.PLAIN, 30));
	panel.add(teacherlabel);
	
	//text field to enter name
	JTextField studentF = new JTextField("Type student First name");
	studentF .setBounds(10,75,250,50);
	panel.add(studentF);
	
	//text field to enter name
	JTextField studentL = new JTextField("Type student Last name");
	studentL.setBounds(270,75,250,50);
	panel.add(studentL);
	
	//search button
	JButton searchButton = new JButton("Search");
	searchButton.setBounds(530,75,100,49);
	panel.add(searchButton);
	//action for Search
	searchButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			window.dispose();
			}
		});
	 
	//search button
	JButton statusButton = new JButton("View Status");
	statusButton.setBounds(640,75,150,49);
		panel.add(statusButton);
		//action for Search
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
	});
		
	//Add grade field
	JLabel addLabel = new JLabel("Update Grade:");
	addLabel.setBounds(10,140,150,60);
	addLabel.setFont(new Font("", Font.PLAIN, 20));
	panel.add(addLabel);
	
	//module code field
	JTextField reg = new JTextField("PoS Code");
	reg.setBounds(170,190,150,50);
	panel.add(reg);
	
	//module code field
	JTextField score = new JTextField("score");
	score.setBounds(10,190,150,50);
	panel.add(score);
	
	//add grade button
	JButton addButton = new JButton("Update Grade");
	addButton.setBounds(330,190,100,49);
	panel.add(addButton);
	//action for Search
	addButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
		try {
			Integer nReg = Integer.parseInt(reg.getText());
			double nScore = Double.parseDouble(score.getText());
			try {
				s.updateGrade(nReg, nScore);
				JOptionPane.showMessageDialog(null, "Grade Updated." , "Operation Succesful",
						JOptionPane.INFORMATION_MESSAGE);
				} catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
							"Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
					"Operation Failed", JOptionPane.ERROR_MESSAGE);
	}
	
			window.dispose();
			
		}
	});
	
	//update grade field
	JLabel updateLabel = new JLabel("Update Module Grade:");
	updateLabel.setBounds(10,250,150,60);
	updateLabel.setFont(new Font("", Font.PLAIN, 20));
	panel.add(updateLabel);
	
	//module code field
	JTextField reg1 = new JTextField("PoS Code");
    reg1.setBounds(10,300,150,50);
	panel.add(reg1);
	
	//module code field
	JTextField modCode = new JTextField("Module Code");
	modCode.setBounds(170,300,150,50);
	panel.add(modCode);

	//score field
	JTextField score1 = new JTextField("Score");
	score1.setBounds(330,300,150,50);
	panel.add(score1);

	
	//add grade button
	JButton updateButton = new JButton("Update Grade");
	updateButton.setBounds(490,300,130,49);
	panel.add(updateButton);
	//action for Search
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Integer n1Reg = Integer.parseInt(reg1.getText());
				String n1Mod =  modCode.getText();
				double n1Score = Double.parseDouble(score1.getText());
				try {
					s.updateModuleGrade(n1Reg, n1Mod, n1Score);
					JOptionPane.showMessageDialog(null, "Grade Added." , "Operation Succesful",
							JOptionPane.INFORMATION_MESSAGE);
					} catch(SQLException e1) {
						JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
								"Operation Failed", JOptionPane.ERROR_MESSAGE);
					}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
						"Operation Failed", JOptionPane.ERROR_MESSAGE);
		}
		
				window.dispose();
				
			}
		});
		
	
	//resit grade field
	JLabel resitLabel = new JLabel("Update Resit Grade:");
	resitLabel.setBounds(10,360,200,60);
	resitLabel.setFont(new Font("", Font.PLAIN, 20));
	panel.add(resitLabel);
	

	//module code field
	JTextField reg2 = new JTextField("PoS Code");
	reg2.setBounds(10,410,150,50);
	panel.add(reg2);
	
	//module code field
	JTextField modCode1 = new JTextField("Module Code");
	modCode1.setBounds(170,410,150,50);
	panel.add(modCode1);
	

	//module code field
	JTextField score2 = new JTextField("Score");
	score2.setBounds(330,410,150,50);
	panel.add(score2);

	//add grade button
	JButton updateButton1 = new JButton("Update Grade");
	updateButton1.setBounds(490,410,130,49);
	panel.add(updateButton1);
	//action for Search
	updateButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			window.dispose();
			/**try {
			s.updateModuleResit(reg2.getText(), modCode1.getText(), score2.getText());
			} catch(SQLException e1) {
				el.printStackTrace();
			}*/
		}
	});
	
	//resit grade field
	JLabel aveLabel = new JLabel("Calculate average Grade:");
	aveLabel.setBounds(10,470,260,60);
	aveLabel.setFont(new Font("", Font.PLAIN, 20));
	panel.add(aveLabel);
	
	
	JButton aveButton1 = new JButton("Calculate average");
	aveButton1.setBounds(10,520,150,49);
	panel.add(aveButton1);
	//action for Search
	aveButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			window.dispose();
		}
	});
	
	JButton aveButton2 = new JButton("Calculate Degree average");
	aveButton2.setBounds(170,520,200,49);
	panel.add(aveButton2);
	//action for Search
	aveButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			window.dispose();
		}
	});
	 
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(0, 592, 1021, 368);
	panel.add(tabbedPane);
	
	JScrollPane scrollPane = new JScrollPane();
	tabbedPane.addTab("Periods Of Study", null, scrollPane, null);
	scrollPane.setViewportBorder(null);
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);

	model.addColumn("PoS Code");
	model.addColumn("Student RegNo");
	model.addColumn("Period Of Study");
	model.addColumn("Start Date");
	model.addColumn("End Date");
	model.addColumn("Current Level");
	model.addColumn("Grade");
	model.addColumn("Progress");
	
	PreparedStatement pstmt = null;
	Connection con = null;
	try {
		con = s.setUpConnection();
		pstmt = con.prepareStatement("SELECT * FROM PeriodsOfStudy");
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

			model.addRow(new Object[] { poscode, regP, pos, start, end, lvl, grade, progressstring });
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		new login();
	}
	scrollPane.setViewportView(table);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	tabbedPane.addTab("Modules Taken", null, scrollPane_1, null);
	DefaultTableModel model_1 = new DefaultTableModel();
	JTable table_1 = new JTable(model_1);
	model_1.addColumn("PosRegCode");
	model_1.addColumn("Module Code");
	model_1.addColumn("Grade");
	model_1.addColumn("Resit Grade");
	try {
		con = s.setUpConnection();
		pstmt = con.prepareStatement("SELECT * FROM ModuleTaken");
		ResultSet res = pstmt.executeQuery();
		ResultSetMetaData md = res.getMetaData();
		while (res.next()) {
			String poscode = res.getString(1);
			String regP = res.getString(2);
			String grade = res.getString(3);
			String rgrade = res.getString(4);
			model_1.addRow(new Object[] {poscode, regP, grade, rgrade});
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	scrollPane_1.setViewportView(table_1);
	
    window.repaint();
  }
}