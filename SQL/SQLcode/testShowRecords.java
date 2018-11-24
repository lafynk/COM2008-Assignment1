import classPkg.*;
import SQLcode.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class testShowRecords {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		try {
			UserInfo u = s.checkLogIn("aca17aj", "1234");
			if (u == null) {
				System.out.println("null");
			} else {
			System.out.println(u.getRegNo() + " " + u.getPermission());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
