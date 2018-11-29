package testing;

import java.sql.SQLException;

import SQLcode.Sql;
import classPkg.UserInfo;

public class testShowRecords {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		UserInfo u = s.checkLogIn("aca17aj", "1234");
		if (u == null) {
			System.out.println("null");
		} else {
			System.out.println(u.getRegNo() + " " + u.getPermission());
		}
	}

}
