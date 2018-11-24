import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class registrarpage extends JFrame {
	 public static void main(String[] args) {
		 // launching code goes in here
			 new registrarpage();
		 }
	 
public registrarpage() throws HeadlessException {
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
	 
	 JTextField studentaccount = new JTextField("Type student to add/delete here");
	 studentaccount.setBounds(10,100,250,50);
	 window.add(studentaccount);
	 
     JTextField studentdegree = new JTextField("Type student degree (if creating acct)");
     studentdegree.setBounds(260,100,250,50);
	 window.add(studentdegree);
	 
	 JComboBox<String> lvl = new JComboBox<String>();
	 
	// add items to the combo box
	 lvl.addItem("year 1");
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
    }
    });
     
     /////////////////////////////////
     
	 JTextField module = new JTextField("Type module to add/drop here");
	 module.setBounds(10,200,300,50);
	 window.add(module);
	 JTextField modulefordegree = new JTextField("Type student to assign module to");
	 modulefordegree.setBounds(10,250,300,50);
	 window.add(modulefordegree);
	 
	 
	 JButton addmodulebutton = new JButton("Add module");
	 addmodulebutton.setBounds(350,200,200,50);
	 window.add(addmodulebutton);
	 addmodulebutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        // add module function call
    }
    });
     	 JButton deletemodulebutton = new JButton("Drop module");
	 deletemodulebutton.setBounds(600,200,200,50);
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
yearofstudy.setBounds(350,260,100,50);
window.add(yearofstudy);
     
JComboBox<String> period = new JComboBox<String>();

//add items to the combo box
period.addItem("autumn semester");
period.addItem("spring semester");
period.addItem("all year babeh");

period.setBounds(460,260,140,50);
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
