package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import SQLcode.Sql;
import classPkg.PeriodOfStudy;
import classPkg.Module;
import classPkg.StuInfo;

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

	public static void main(String[] args) throws HeadlessException, SQLException {
		 // launching code goes in here
			 new teacherpage();
	}
	 
	public teacherpage() throws HeadlessException, SQLException {
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
		updateLabel.setBounds(10,70,300,60);
		updateLabel.setFont(new Font("", Font.PLAIN, 20));
		panel.add(updateLabel);
		
		//Pos code field and position
		JTextField reg1 = new JTextField("PoS Code");
	    reg1.setBounds(10,120,150,50);
		panel.add(reg1);
		
		//module code field and position
		JTextField modCode = new JTextField("Module Code");
		modCode.setBounds(170,120,150,50);
		panel.add(modCode);
	
		//score field and position
		JTextField score1 = new JTextField("Score");
		score1.setBounds(330,120,150,50);
		panel.add(score1);
	
		
		//add grade button
		JButton updateButton = new JButton("Update Grade");
		updateButton.setBounds(490,120,130,49);
		panel.add(updateButton);
		//action for Search
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//gets required info from text fields
					int n1Reg = Integer.parseInt(reg1.getText());
					String n1Mod =  modCode.getText();
					double n1Score = Double.parseDouble(score1.getText());
					try {
						//runs function update the grade and calc new average
						s.updateModuleGrade(n1Score, n1Reg, n1Mod);
						double newAve = s.calcPosAverage(n1Reg);
						s.updateGrade(n1Reg, newAve);
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
				teacherpage t2;
				try {
					t2 = new teacherpage();
					t2.setVisible(true);
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				}
			});
			
		
		//resit grade field
		JLabel resitLabel = new JLabel("Update Resit Grade:");
		resitLabel.setBounds(10,180,230,60);
		resitLabel.setFont(new Font("", Font.PLAIN, 20));
		panel.add(resitLabel);
		
	
		//module code field
		JTextField reg2 = new JTextField("PoS Code");
		reg2.setBounds(10,230,150,50);
		panel.add(reg2);
		
		//module code field
		JTextField modCode1 = new JTextField("Module Code");
		modCode1.setBounds(170,230,150,50);
		panel.add(modCode1);
	
		//module code field
		JTextField score2 = new JTextField("Score");
		score2.setBounds(330,230,150,50);
		panel.add(score2);
	
		//add grade button
		JButton updateButton1 = new JButton("Update Grade");
		updateButton1.setBounds(490,230,130,49);
		panel.add(updateButton1);
		//action for Search
		updateButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//gets required info from text fields
					int n2Reg = Integer.parseInt(reg2.getText());
					String n2Mod =  modCode1.getText();
					double n2Score = Double.parseDouble(score2.getText());
					try {
						//runs function update the grade and calc new average
						s.updateModuleResit(n2Reg, n2Mod, n2Score);
						double newAve = s.calcPosAverage(n2Reg);
						s.updateGrade(n2Reg, newAve);
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
				teacherpage t3;
				try {
					t3 = new teacherpage();
					t3.setVisible(true);
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
		});
		
		//calculate average field and position
		JLabel aveLabel = new JLabel("Calculate average Grade:");
		aveLabel.setBounds(10,290,300,60);
		aveLabel.setFont(new Font("", Font.PLAIN, 20));
		panel.add(aveLabel);
		
		//Pos field and position
		JTextField reg4 = new JTextField("PoS Code");
		reg4.setBounds(10,345,150,50);
		panel.add(reg4);
		
		//calc average button and position
		JButton aveButton1 = new JButton("End of Year");
		aveButton1.setBounds(170,345,150,49);
		panel.add(aveButton1);
		//action for Search
		aveButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					//gets required info from text fields
					int nreg4 = Integer.parseInt(reg4.getText());
					try {
						int regNo = Integer.parseInt(reg4.getText().substring(1));
						PeriodOfStudy[] p1 = s.getPeriodsOfStudy(regNo);
						//runs function update the grade and calc new average
						double average = s.calcPosAverage(nreg4);
						s.updateGrade(nreg4, average);
						progress(nreg4, average);
						int failCount = 0;
						for (PeriodOfStudy p:p1) {
							if (p != null) {
								if (p.getProgress() == false)
									failCount ++;
							}
						}
						if (failCount > 1) {
							s.updateAwardedClass(regNo, "fail");
						} else s.updateAwardedClass(regNo, null);
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
				//refresh page
				window.dispose();
				teacherpage t4;
				try {
					t4 = new teacherpage();
					t4.setVisible(true);
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		//calc degree label and position
		JLabel ave1Label = new JLabel("Calculate End Degree");
		ave1Label.setBounds(340,290,300,60);
		ave1Label.setFont(new Font("", Font.PLAIN, 20));
		panel.add(ave1Label);
		
		//Pos field and position
		JTextField reg5 = new JTextField("Enter Registration No");
		reg5.setBounds(340,345,150,50);
		panel.add(reg5);
		
		//degree field and position
		JTextField degree = new JTextField("Enter Degree");
		degree.setBounds(500,345,150,50);
		panel.add(degree);
		
		//calc degree average buttton and position
		JButton aveButton2 = new JButton("End of Degree");
		aveButton2.setBounds(660,345,200,49);
		panel.add(aveButton2);
		//action for Search
		aveButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//gets required info from text fields
					//runs functions to return the score and awarded class
					int nreg5 = Integer.parseInt(reg5.getText());
					String lvl1 = degree.getText();
					double average = s.calcDegreeAverage(nreg5);
					char lvl = s.getMaxLevel(lvl1);
					String destination = teacherpage.this.getClass(lvl, average);
					s.updateAwardedClass(nreg5, destination);
					JOptionPane.showMessageDialog(null, average +" "+ destination,
							"Students Degree Average", JOptionPane.INFORMATION_MESSAGE);
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Operation Failed! Please check fields and try again.",
							"Operation Failed", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		//tabbed pane for database info to be added
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 450, 1021, 510);
		panel.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Periods Of Study", null, scrollPane, null);
		scrollPane.setViewportBorder(null);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
	
		//making columns to match the database
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
			//setting up connection and query statement to get information required
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
				//add the information in rows under the correct columns
				model.addRow(new Object[] { poscode, regP, pos1, start, end, lvl1, grade, progressstring });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			new login();
		}
		scrollPane.setViewportView(table);
		
		//second page on the tabbedpane to get module taken information
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Modules Taken", null, scrollPane_1, null);
		DefaultTableModel model_1 = new DefaultTableModel();
		JTable table_1 = new JTable(model_1);
		model_1.addColumn("PosRegCode");
		model_1.addColumn("Module Code");
		model_1.addColumn("Grade");
		model_1.addColumn("Resit Grade");
		try {
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

	//method to return awarded class
	public String getClass(char num, double score) {
		if(num == '1') {
			if (score > 69.4) {
				return "Distinction";
			}
			else if (score > 49.4 && score < 59.5) {
				return "Pass";
			}
			else if (score > 59.4 && score < 69.5) {
				return "Merit";
			}
			else {
				return "Fail";
			}
		}
		else if(num == '2' || num == '3') {
			if (score > 69.4) {
				return "Distinction";
			}
			else if (score > 39.4 && score < 44.5) {
				return "Pass (Non-Honours)";
			}
			else if (score < 49.5 && score > 44.4) {
				return "Third Class";
			}
			else if (score > 49.4 && score < 59.5) {
				return "Lower Second";
			}
			else if (score > 59.4 && score < 69.5) {
				return "Upper Second";
			}
			else {
				return "Fail";
			}
		}
		else if(num == '4'){
			if (score > 69.5) {
				return "Distinction";
			}
			else if (score > 49.4 && score < 59.5) {
				return "Lower Second";
			}
			else if (score > 59.4 && score < 69.5) {
				return "Upper Second";
			}
			else {
				return "Fail";
			}
		}
		return null;
		
	}
	
	//public int failed()
	
	//method to up date the progress
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
		System.out.println(lvl);
		if ((lvl != 'P') && (!progress1(posRegNo))) {
			s.updateProgress(posRegNo, false);
		}else if (lvl == '4') {
			if (value > 50) {
				s.updateProgress(posRegNo, true);
			} else {
				double degX = s.calcDegreeAverage2(r, '3');
				String cla = getClass('3',degX);
				s.updateAwardedClass(r, cla);
			}
			
		} else if((lvl == '3') || (lvl == '2') || (lvl == '1')) {
			if (value > 40) {
				s.updateProgress(posRegNo, true);
			} else s.updateProgress(posRegNo, false);
		} else {
			s.updateProgress(posRegNo, true);	
		}
	}
	
    public boolean progress1(int posRegNo) throws SQLException {
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
   
    	StuInfo stu = s.getStudentInfo(r);
    	String deg = stu.getDegree();
    	char t = s.getMaxLevel(deg);
    	System.out.println(t);
    	double threshold = 0.00;
    	switch (t) {
    	case '1':
    		threshold = 49.5;
    		break;
    	case '3':
    		threshold = 39.5;
    		break;
    	case '4':
    		threshold = 49.5;
    		break;
    	}
    	System.out.println(threshold);
    	Module[] m1 = s.getModules(i, stu);
    	int failCount = 0;
    	for(Module m : m1) {
    		if (m != null) {
    			if (m.getResit() == 0.00) {
    				if ((m.getGrade() < threshold) && (m.getGrade() >= threshold-10)) {
    					failCount ++;
    				}else if (m.getGrade() < threshold-10) {
    					return false;
    				}
    			} else if ((m.getResit() < threshold)  && (m.getGrade() >= threshold-10)) {
    				failCount++;
    			}else if (m.getGrade() < threshold-10) {
					return false;
    			}
    		}
    	}
    	if (failCount > 1) {
    		return false;
    	} else return true;
    		
    }
}
	    
  