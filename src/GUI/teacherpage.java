package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import SQLcode.Sql;
import classPkg.PeriodOfStudy;

import java.awt.event.ActionListener;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class teacherpage extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 4540369166472097474L;

	public static void main(String[] args) {
		 // launching code goes in here
			 new teacherpage();
	}
	 
	public teacherpage() throws HeadlessException {
		//establish new sql connection
		Sql s = new Sql(); 
		//setting the size of the window and some attributes
		JFrame window = new JFrame("Systems Design & Security: Team Project");
		window.setVisible(true);
	    window.setSize(1000,1000);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//components to be added to panel, then added to window
		JPanel panel = new JPanel();
		panel.setLayout(null);
		window.add(panel);
		 
		//teacher label and position
		JLabel teacherlabel = new JLabel("Teacher Dashboard");
		teacherlabel.setBounds(10,10,300,50);
		teacherlabel.setFont(new Font("", Font.PLAIN, 30));
		panel.add(teacherlabel);
	
			
		//Add grade field and position
		JLabel addLabel = new JLabel("Update Grade:");
		addLabel.setBounds(10,70,150,60);
		addLabel.setFont(new Font("", Font.PLAIN, 20));
		panel.add(addLabel);
		
		//Score field and position
		JTextField score = new JTextField("score");
		score.setBounds(170,120,150,50);
		panel.add(score);
		
		//PoS code field and position
		JTextField reg = new JTextField("PoS Code");
		reg.setBounds(10,120,150,50);
		panel.add(reg);
		
		//add grade button
		JButton addButton = new JButton("Update Grade");
		addButton.setBounds(330,120,130,49);
		panel.add(addButton);
		//action for Search
		//takes the PoS and Score and updates that field in database
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
			//refresh page
			window.dispose();
			teacherpage t1 = new teacherpage();
			window.setVisible(true);
				
			}
		});
		
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
		
		//update module grade label and position
		JLabel updateLabel = new JLabel("Update Module Grade:");
		updateLabel.setBounds(10,180,230,60);
		updateLabel.setFont(new Font("", Font.PLAIN, 20));
		panel.add(updateLabel);
		
		//Pos code field and position
		JTextField reg1 = new JTextField("PoS Code");
	    reg1.setBounds(10,230,150,50);
		panel.add(reg1);
		
		//module code field and position
		JTextField modCode = new JTextField("Module Code");
		modCode.setBounds(170,230,150,50);
		panel.add(modCode);
	
		//score field and position
		JTextField score1 = new JTextField("Score");
		score1.setBounds(330,230,150,50);
		panel.add(score1);
	
		
		//add grade button
		JButton updateButton = new JButton("Update Grade");
		updateButton.setBounds(490,230,130,39);
		panel.add(updateButton);
		//action for Search
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer n1Reg = Integer.parseInt(reg1.getText());
					String n1Mod =  modCode.getText();
					double n1Score = Double.parseDouble(score1.getText());
					try {
						s.updateModuleGrade(n1Score, n1Reg, n1Mod);
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
				//refresh the page
				window.dispose();
				teacherpage t2 = new teacherpage();
				window.setVisible(true);
					
				}
			});
			
		
		//resit grade field
		JLabel resitLabel = new JLabel("Update Resit Grade:");
		resitLabel.setBounds(10,290,200,60);
		resitLabel.setFont(new Font("", Font.PLAIN, 20));
		panel.add(resitLabel);
		
	
		//module code field
		JTextField reg2 = new JTextField("PoS Code");
		reg2.setBounds(10,345,150,50);
		panel.add(reg2);
		
		//module code field
		JTextField modCode1 = new JTextField("Module Code");
		modCode1.setBounds(170,345,150,50);
		panel.add(modCode1);
	
		//module code field
		JTextField score2 = new JTextField("Score");
		score2.setBounds(330,345,150,50);
		panel.add(score2);
	
		//add grade button
		JButton updateButton1 = new JButton("Update Grade");
		updateButton1.setBounds(490,345,130,49);
		panel.add(updateButton1);
		//action for Search
		updateButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer n2Reg = Integer.parseInt(reg2.getText());
					String n2Mod =  modCode1.getText();
					double n2Score = Double.parseDouble(score2.getText());
					try {
						s.updateModuleResit(n2Reg, n2Mod, n2Score);
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
				//refresh page
				window.dispose();
				teacherpage t3 = new teacherpage();
				window.setVisible(true);
				}
		});
		
		//resit grade field
		JLabel aveLabel = new JLabel("Calculate average Grade:");
		aveLabel.setBounds(10,400,260,60);
		aveLabel.setFont(new Font("", Font.PLAIN, 20));
		panel.add(aveLabel);
		
		//module code field
		JTextField reg4 = new JTextField("PoS Code");
		reg4.setBounds(10,450,150,50);
		panel.add(reg4);
		
		JButton aveButton1 = new JButton("Calculate average");
		aveButton1.setBounds(170,450,150,49);
		panel.add(aveButton1);
		//action for Search
		aveButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer nreg4 = Integer.parseInt(reg4.getText());
					try {
						double average = s.calcPosAverage(nreg4);
						s.updateGrade(nreg4, average);
						progress(nreg4, average);
						window.dispose();
						teacherpage t4 = new teacherpage();
						window.setVisible(true);
						
					} catch(SQLException e1) {
						JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
								"Operation Failed", JOptionPane.ERROR_MESSAGE);
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
							"Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	
			
		
		JButton aveButton2 = new JButton("Calculate Degree average");
		aveButton2.setBounds(330,450,200,49);
		panel.add(aveButton2);
		//action for Search
		aveButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer nreg4 = Integer.parseInt(reg4.getText());
					try {
						double average = s.calcPosAverage(nreg4);
						s.updateGrade(nreg4, average);
						JOptionPane.showMessageDialog(null, average,
								"Students Degree Average", JOptionPane.INFORMATION_MESSAGE);
						
					} catch(SQLException e1) {
						JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
								"Operation Failed", JOptionPane.ERROR_MESSAGE);
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
							"Operation Failed", JOptionPane.ERROR_MESSAGE);
				}
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
				String pos1 = res.getString(3);
				String start = res.getString(4);
				String end = res.getString(5);
				String lvl1 = res.getString(6);
				String grade = res.getString(7);
				String progress = res.getString(8);
				String progressstring = null;
				if (progress.contentEquals("0")) {
					progressstring = "No";
				} else {
					progressstring = "Yes";
				}
	
				model.addRow(new Object[] { poscode, regP, pos1, start, end, lvl1, grade, progressstring });
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
	public void progress(int posRegNo, double value) throws SQLException {
		Sql s = new Sql();
		int r = Integer.parseInt(String.valueOf(posRegNo).substring(1));
		PeriodOfStudy[] pos = s.getPeriodsOfStudy(r);
		PeriodOfStudy i = null;
		for (PeriodOfStudy p:pos) {
			if (p!=null) {
				if (posRegNo == p.getPosRegCode()) {
					i = p;
				}
			}
		}
		char lvl = i.getLevel();
		if (lvl == '4') {
			if (value > 50)
			s.updateProgress(posRegNo, true);
		} else if((lvl == '3') || (lvl == '2') || (lvl == '1')) {
			if (value > 40) {
			s.updateProgress(posRegNo, true);	
		} else if (lvl == 'P') {
				s.updateProgress(posRegNo, true);	
		} else s.updateProgress(posRegNo, false);	
	}
}
}
	    
  