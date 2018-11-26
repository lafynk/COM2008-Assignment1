package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.Random;
import SQLcode.Sql;
import classPkg.UserInfo;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class registrarpage extends JFrame {
	 public static void main(String[] args) throws HeadlessException, SQLException {
		 // launching code goes in here
			 new registrarpage();
		 }
	 
public registrarpage() throws HeadlessException, SQLException {
	Sql s = new Sql();
	JFrame window = new JFrame("Systems Design & Security: Team Project");
	 window.setLayout(null);
	 window.setSize(1000,1000);
	 window.setVisible(true);
	 window.setResizable(false);
	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 JLabel adminlabel = new JLabel("Registrar Dashboard");
	 adminlabel.setBounds(40,10,500,50);
	 adminlabel.setFont(new Font("", Font.PLAIN, 30));
	 window.add(adminlabel);
	 
	 JTextField studentaccount = new JTextField("Type student ID to delete here");
	 studentaccount.setBounds(10,100,250,50);
	 window.add(studentaccount);
	 
     JTextField studentdegree = new JTextField("Type student degree code (if creating acct)");
     studentdegree.setBounds(10,150,250,50);
	 window.add(studentdegree);
	 
	 JTextField studentfname = new JTextField("Type student forename (if creating acct)");
     studentfname.setBounds(10,200,250,50);
	 window.add(studentfname);
	 
	 JTextField studentsname = new JTextField("Type student surname (if creating acct)");
     studentsname.setBounds(10,250,250,50);
	 window.add(studentsname);
	 
	 

	 JComboBox<String> studenttitle = new JComboBox<String>();
	 
		// add items to the combo box
	 studenttitle.addItem("Mr");
	 studenttitle.addItem("Ms");
	
		 studenttitle.setBounds(360,250,250,50);
		window.add(studenttitle);
		
	 JTextField studenttutor = new JTextField("Type student tutor (if creating acct)");
     studenttutor.setBounds(360,200,250,50);
	 window.add(studenttutor);
	 
	 JComboBox<String> lvl = new JComboBox<String>();
	 
	// add items to the combo box
	 lvl.addItem("1");
	 lvl.addItem("2");
	 lvl.addItem("3");
	 lvl.addItem("4");
	 lvl.addItem("5");
	 lvl.setBounds(510,100,80,50);
	window.add(lvl);
	
	 
	 JButton deletestudentbutton = new JButton("Delete Student");
	 deletestudentbutton.setBounds(800,100,200,50);
	 window.add(deletestudentbutton);
	 deletestudentbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // delte acct function call
    	try {
			s.removeStudent(Integer.parseInt(studentaccount.getText()));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    });
     	 JButton addstudentbutton = new JButton("Add Student");
	 addstudentbutton.setBounds(600,100,200,50);
	 window.add(addstudentbutton);
	 addstudentbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // add acct function call
    	//UserInfo u=null;
    	String makeemail =( studentfname.getText().substring(0, 1)) + studentsname.getText() + "1"+"@sheffield.ac.uk";
		try {
			Random rand = new Random();
			int randReg = rand.nextInt(900000000);
			s.addUser(100000000 + randReg, "joshstu", "123", "Students");
			s.addStudent(100000000 + randReg, studenttitle.getSelectedItem().toString(), studentsname.getText(),studentfname.getText(), makeemail, studenttutor.getText(), studentdegree.getText(), lvl.getSelectedItem().toString().charAt(0), "1st");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    });
     
     /////////////////////////////////
     
	 JTextField module = new JTextField("Type module code to add/drop here");
	 module.setBounds(10,400,300,50);
	 window.add(module);
	 JTextField idformodule = new JTextField("Type student ID to assign module to");
	 idformodule.setBounds(10,450,300,50);
	 window.add(idformodule);
	 
	 
	 JButton addmodulebutton = new JButton("Add module");
	 addmodulebutton.setBounds(350,400,200,50);
	 window.add(addmodulebutton);
	 addmodulebutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // add module function call
    	try {
			s.addTakenModule(Integer.parseInt(idformodule.getText()), module.getText(), 0, 0);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    });
     	 JButton deletemodulebutton = new JButton("Drop module");
	 deletemodulebutton.setBounds(600,400,200,50);
	 window.add(deletemodulebutton);
	 deletemodulebutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // delte moudule function call
    	try {
			s.removeTakenMod(Integer.parseInt(idformodule.getText()), module.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
     });
     // create an empty combo box with items of type String
JComboBox<String> yearofstudy = new JComboBox<String>();
 
// add items to the combo box
yearofstudy.addItem("1");
yearofstudy.addItem("2");
yearofstudy.addItem("3");
yearofstudy.addItem("4");
yearofstudy.addItem("5");
yearofstudy.setBounds(350,460,100,50);
window.add(yearofstudy);
     
JComboBox<String> period = new JComboBox<String>();

//add items to the combo box
period.addItem("Autumn");
period.addItem("Spring");
period.addItem("Summer");
period.addItem("Year");
period.setBounds(460,460,140,50);
window.add(period);
  




JPanel p1=new JPanel();  
JPanel p2=new JPanel(); 
JPanel p3=new JPanel();
JPanel p4=new JPanel();
/*
Statement st = null;
/*
DefaultTableModel studentmodel = new DefaultTableModel(new String[]{"RegNo", "Title", "Surname", "Forename", "Email","Tutor","Degree Code","Current PoS", "Class Awarded"}, 0);
//try {
ResultSet rs = st.executeQuery("SELECT * FROM Students");
	while(rs.next())
	{
	    String d = rs.getString("RegistrationNo");
	    String e = rs.getString("Title");
	    String f = rs.getString("Surname");
	    String g = rs.getString("Forename");
	    String h = rs.getString("Email");
	    String i = rs.getString("Tutor");
	    String j = rs.getString("DegreeCode");
	    String k = rs.getString("CurrentPeriodOfStudy");
	    String l = rs.getString("AwardedClass");

	   studentmodel.addRow(new Object[]{d, e, f, g, h, i, j, k, l});
	    
	    JTable table = new JTable();
	    table.setModel(studentmodel);
	    p2.add(table);
	}
/*} catch (NullPointerException e) {
	JLabel nodata = new JLabel("No Data");
	p1.add(nodata);
}


DefaultTableModel deptmodel = new DefaultTableModel(new String[]{"Department Code", "Department Name"}, 0);
try {
ResultSet rs2 = st.executeQuery("SELECT * FROM Departments");
	while(rs.next())
	{
	    String d = rs2.getString("DepartmentCode");
	    String e = rs2.getString("DepartmentName");

	    deptmodel.addRow(new Object[]{d, e});
	    
	    JTable table = new JTable();
	    table.setModel(deptmodel);
	    p2.add(table);
	}
} catch (NullPointerException e) {
	JLabel nodata = new JLabel("No Data");
	p2.add(nodata);
}


DefaultTableModel degreemodel = new DefaultTableModel(new String[]{"Degree Code", "Degree Name", "Deaprtment Code", "Max Level Of Study","Placement"}, 0);
try {
ResultSet rs3 = st.executeQuery("SELECT * FROM Degrees");
	while(rs3.next())
	{
	    String d = rs3.getString("DegreeCode");
	    String e = rs3.getString("DegreeName");
	    String f = rs3.getString("DepartmentCode");
	    String g = rs3.getString("MaxLevelOfStudy");
	    String h = rs3.getString("Placement");

	    degreemodel.addRow(new Object[]{d, e, f, g, h});
	    
	    JTable table = new JTable();
	    table.setModel(degreemodel);
	    p3.add(table);
	}
} catch (NullPointerException e) {
	JLabel nodata = new JLabel("No Data");
	p3.add(nodata);
}


DefaultTableModel modulemodel = new DefaultTableModel(new String[]{"Module Code", "Module Name","When Taught"}, 0);
try {
ResultSet rs4 = st.executeQuery("SELECT * FROM Modules");
	while(rs.next())
	{
	    String d = rs4.getString("ModuleCode");
	    String e = rs4.getString("ModuleName");
	    String f = rs4.getString("WhenTaught");

	    modulemodel.addRow(new Object[]{d, e, f});
	    
	    JTable table = new JTable();
	    table.setModel(modulemodel);
	    p3.add(table);
	}
} catch (NullPointerException e) {
	JLabel nodata = new JLabel("No Data");
	p4.add(nodata);
}
*/

JTabbedPane tp=new JTabbedPane();  
tp.setBounds(25,570,950,380);  
tp.add("Students",p1);  
tp.add("Departments",p2);  
tp.add("Degrees",p3); 
tp.add("Modules",p4);  
window.add(tp); 

window.repaint();
		 
 }

}
