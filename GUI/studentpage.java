package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
	 
	 //adds header to welcome user
	 JLabel welcomeLabel = new JLabel("Welcome to your user account '_'");
	 welcomeLabel.setFont(new Font("Serif", Font.BOLD, 26));
	 welcomeLabel.setBounds(290,20,380,50);
	 panel.add(welcomeLabel);
	 
	 //adds label for account management button
	 JLabel accountManagement = new JLabel("Press for Account Management");
	 accountManagement.setFont(new Font("Serif", Font.BOLD, 20));
	 accountManagement.setBounds(260,310,380,50);
	 panel.add(accountManagement);
	 
	 //adds label for current status button
	 JLabel currentStatus = new JLabel("Press for Current Status");
	 currentStatus.setFont(new Font("Serif", Font.BOLD, 20));
	 currentStatus.setBounds(260,410,380,50);
	 panel.add(currentStatus);
	 
	 //adds label for previous status button
	 JLabel previousStatus = new JLabel("Press for Previous Status");
	 previousStatus.setFont(new Font("Serif", Font.BOLD, 20));
	 previousStatus.setBounds(260,510,380,50);
	 panel.add(previousStatus);
	 
	 //adds account management button
	 JButton accountButton = new JButton("GO");
	 accountButton.setBounds(550,300,160,75);
	 panel.add(accountButton);
	 //action for account management
	 accountButton.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			  window.dispose();
		 }
	 });
	 
	 //adds current status button
	 JButton cStatusButton = new JButton("GO");
	 cStatusButton.setBounds(550,400,160,75);
	 panel.add(cStatusButton);
	 //action for current status
	 cStatusButton.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 window.dispose();
		 }
	 });
	 
	 //adds previous status button
	 JButton pStatusButton = new JButton("GO");
	 pStatusButton.setBounds(550,500,160,75);
	 panel.add(pStatusButton);
	 //action for previous status
	 pStatusButton.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 window.dispose();
		 }
	 });
	
	 window.repaint();	 
 }
}