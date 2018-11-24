import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class adminpage extends JFrame {
	 public static void main(String[] args) {
		 // launching code goes in here
			 new adminpage();
		 }
	 
public adminpage() throws HeadlessException {
	JFrame window = new JFrame("Systems Design & Security: Team Project");
	 window.setLayout(null);
	 window.setSize(1000,1000);
	 window.setVisible(true);
	 window.setResizable(false);
	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 JLabel adminlabel = new JLabel("Admin Dashboard");
	 adminlabel.setBounds(40,10,300,50);
	 adminlabel.setFont(new Font("", Font.PLAIN, 30));
	 window.add(adminlabel);


	 JTextField useraccount = new JTextField("Type user account to add/delete here");
	 useraccount.setBounds(10,100,250,50);
	 window.add(useraccount);
	 
     JTextField useraccountpwd = new JTextField("Type user account password (if creating acct)");
	 useraccountpwd.setBounds(260,100,250,50);
	 window.add(useraccountpwd);
	 
	 JComboBox<String> accttype = new JComboBox<String>();
	 
	// add items to the combo box
	 accttype.addItem("Student");
	 accttype.addItem("Admin");
	 accttype.addItem("Teacher");
	 accttype.addItem("Registrar");
	 accttype.setBounds(510,100,80,50);
	window.add(accttype);
	
	 
	 JButton deleteacctbutton = new JButton("Delete Acct");
	 deleteacctbutton.setBounds(800,100,200,50);
	 window.add(deleteacctbutton);
	 deleteacctbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // delte acct function call
    }
    });
     	 JButton addacctbutton = new JButton("Add Acct");
	 addacctbutton.setBounds(600,100,200,50);
	 window.add(addacctbutton);
	 addacctbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // add acct function call
    }
    });
     
     /////////////////////////////////
     
	 JTextField department = new JTextField("Type department to add/delete here");
	 department.setBounds(10,200,300,50);
	 window.add(department);

	 JButton adddeptbutton = new JButton("Add dept");
	 adddeptbutton.setBounds(350,200,200,50);
	 window.add(adddeptbutton);
	 adddeptbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // delte dept function call
    }
    });
     	 JButton deletedeptbutton = new JButton("Delete dept");
	 deletedeptbutton.setBounds(600,200,200,50);
	 window.add(deletedeptbutton);
	 deletedeptbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // add dept function call
    }
     });
    
    ///////////////////
     
	 JTextField degree = new JTextField("Type course to add here");
	 degree.setBounds(10,300,300,50);
	 window.add(degree);
	 JTextField deptfordegree = new JTextField("Type department to add course to");
	 deptfordegree.setBounds(10,350,300,50);
	 window.add(deptfordegree);
	 
	 
	 JButton adddegreebutton = new JButton("Add degree");
	 adddegreebutton.setBounds(350,300,200,50);
	 window.add(adddegreebutton);
	 adddegreebutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // add degree function call
    }
    });
     	 JButton deletedegreebutton = new JButton("Delete degree");
	 deletedegreebutton.setBounds(600,300,200,50);
	 window.add(deletedegreebutton);
	 deletedegreebutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // delte degree function call
    }
     });
     
    
    ///////////////////
     
	 JTextField module = new JTextField("Type module to add here");
	 module.setBounds(10,450,300,50);
	 window.add(module);
	 JTextField modulefordegree = new JTextField("Type degree to add module to");
	 modulefordegree.setBounds(10,500,300,50);
	 window.add(modulefordegree);
	 
	 
	 JButton addmodulebutton = new JButton("Add module");
	 addmodulebutton.setBounds(350,450,200,50);
	 window.add(addmodulebutton);
	 addmodulebutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // add module function call
    }
    });
     	 JButton deletemodulebutton = new JButton("Delete module");
	 deletemodulebutton.setBounds(600,450,200,50);
	 window.add(deletemodulebutton);
	 deletemodulebutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // delte moudule function call
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
yearofstudy.setBounds(350,510,100,50);
window.add(yearofstudy);
     



     // create an empty combo box with items of type String
JComboBox<String> coreornah = new JComboBox<String>();
 
// add items to the combo box
coreornah.addItem("Core");
coreornah.addItem("Not Core");

coreornah.setBounds(460,510,100,50);
window.add(coreornah);



    JTextArea ta=new JTextArea(200,200);  
    JPanel p1=new JPanel();  
    p1.add(ta);  
    JPanel p2=new JPanel();  
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JTabbedPane tp=new JTabbedPane();  
    tp.setBounds(25,570,950,380);  
    tp.add("User accounts",p1);  
    tp.add("Departments",p2);  
    tp.add("Degrees",p3); 
    tp.add("Modules",p4);  
    window.add(tp);  
    
window.repaint();
		 
 }

}
