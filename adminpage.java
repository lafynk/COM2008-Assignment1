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
	 window.setLayout(new FlowLayout());
	 window.setSize(1000,1000);
	 window.setVisible(true);
	 window.setResizable(false);
	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 


	 window.repaint();
		 
 }

}
