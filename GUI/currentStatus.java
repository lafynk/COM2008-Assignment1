package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class currentStatus extends JFrame {
	
	JTable jt;

	String[] columns = {"Unit Code","Description","Semester","Credit Value","Grade"};
	Object[][] data = {{"COM1002", "Foundations of Computer Science",
		                  "ACAD YR 17","20","68" }};
	public currentStatus()
	{
		jt = new JTable(data,columns);
		jt.setBounds(50,50,500,500);
		JScrollPane js=new JScrollPane(jt);
		this.add(js);
		this.setSize(1000,1000);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new currentStatus();
}
}

