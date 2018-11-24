import classPkg.*;
import SQLcode.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class test2 {

	public static void main(String[] args) throws SQLException {
		try {
			Sql s = new Sql();
			s.addUser(170140910, "aca17aj", "1234", "Students");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}