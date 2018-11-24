import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class teacherpage extends JFrame {
	 public static void main(String[] args) {
		 // launching code goes in here
			 new teacherpage();
		 }
	 
public teacherpage() throws HeadlessException {
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
	
	//adds header to welcome user
    JLabel welcomeLabel = new JLabel("Welcome to your user account '_'");
	welcomeLabel.setFont(new Font("Serif", Font.BOLD, 26));
	welcomeLabel.setBounds(290,20,380,50);
	panel.add(welcomeLabel);
	
	//adds label for add/update grade button
    JLabel gradeLabel = new JLabel("Press to add/update grades");
    gradeLabel.setFont(new Font("Serif", Font.BOLD, 20));
    gradeLabel.setBounds(260,310,380,50);
    panel.add(gradeLabel);
    
    //adds label for calculating average button
    JLabel calcAverage = new JLabel("Press to calculate the weighted mean grade");
    calcAverage.setFont(new Font("Serif", Font.BOLD, 20));
    calcAverage.setBounds(260,410,380,50);
    panel.add(calcAverage);
    
    //adds label for calculating average for whole degree button
    JLabel calcAveDegree = new JLabel("Press to calculate the overall degree result");
    calcAveDegree .setFont(new Font("Serif", Font.BOLD, 20));
    calcAveDegree .setBounds(260,510,380,50);
    panel.add(calcAveDegree );
    
    //adds label for previous status button
	JLabel stuStatus = new JLabel("Press for student Status");
	stuStatus.setFont(new Font("Serif", Font.BOLD, 20));
	stuStatus.setBounds(260,610,380,50);
	panel.add(stuStatus);
	
	//adds grade button
    JButton gradeButton = new JButton("GO");
    gradeButton.setBounds(700,300,160,75);
    panel.add(gradeButton);
	//action for grade button
	gradeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				  window.dispose();
		}
	});
	
	//adds calculating average button
    JButton calcAverageButton = new JButton("GO");
    calcAverageButton.setBounds(700,400,160,75);
    panel.add(calcAverageButton);
	//action for calculating average
    calcAverageButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				  window.dispose();
		}
	});
    
    //adds calculating degree average button
    JButton calcAveDegreeButton = new JButton("GO");
    calcAveDegreeButton .setBounds(700,500,160,75);
    panel.add(calcAveDegreeButton);
	//action for calculating degree average
    calcAveDegreeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				  window.dispose();
		}
	});
    
    //adds current status button
  	JButton cStatusButton = new JButton("GO");
  	cStatusButton.setBounds(700,600,160,75);
  	panel.add(cStatusButton);
  	//action for current status
  	cStatusButton.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			window.dispose();
  		}
  	});
	 
    window.repaint();
  }
}
