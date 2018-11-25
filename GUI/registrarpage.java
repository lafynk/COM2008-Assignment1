package GUI;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import SQLcode.Sql;
import classPkg.UserInfo;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class registrarpage extends JFrame {
	 public static void main(String[] args) {
		 // launching code goes in here
			 new registrarpage();
		 }
	 
public registrarpage() throws HeadlessException {
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
	 
	 JTextField studentemail = new JTextField("Type student email (if creating acct)");
     studentemail.setBounds(10,300,250,50);
	 window.add(studentemail);
	 

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
    	String makeemail =( studentfname.getText().substring(0, 1)) + studentsname.getText() + "2"+"@sheffield.ac.uk";
		try {
			Random rand = new Random();
			s.addStudent(100000000 + rand.nextInt(900000000), studenttitle.getSelectedItem().toString(), studentsname.getText(),studentfname.getText(), makeemail, studenttutor.getText(), studentdegree.getText(), lvl.getSelectedItem().toString().charAt(0), " ");
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
period.addItem("autumn semester");
period.addItem("spring semester");
period.addItem("all year");

period.setBounds(460,460,140,50);
window.add(period);
  



JTextArea ta=new JTextArea(200,200);  
JPanel p1=new JPanel();  
p1.add(ta);  
JPanel p2=new JPanel();  
JPanel p3=new JPanel();
JPanel p4=new JPanel();
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
