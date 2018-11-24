import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class login extends JFrame {
	 public static void main(String[] args) {
		 // launching code goes in here
			 new login();
		 }

public login() throws HeadlessException {
	JFrame window = new JFrame("Systems Design & Security: Team Project");
	 window.setLayout(new FlowLayout());
	 window.setSize(1000,1000);
	 window.setVisible(true);
	 window.setResizable(false);
	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




	 JTextField username = new JTextField();
	 username.setBounds(400,400,200,50);
	 window.add(username);



	 JButton loginbutton = new JButton("Login");
	 loginbutton.setBounds(400,600,200,50);
	 window.add(loginbutton);
	 loginbutton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //your actions
        //window.exit();
      //  window.dispose();
      //  new studentpage();
			JOptionPane.showMessageDialog(null, "Username or password is incorrect","Login Failure!", JOptionPane.ERROR_MESSAGE);
    }
    });

	 JLabel usernamelabel = new JLabel("Username");
	 usernamelabel.setBounds(400,340,200,50);
	 window.add(usernamelabel);

	 JLabel pwdlabel = new JLabel("Password");
	 pwdlabel.setBounds(400,440,200,50);
	 window.add(pwdlabel);

	 JTextField password = new JTextField();
	 password.setBounds(400,500,200,50);
	 window.add(password);

	 window.repaint();

 }

}
