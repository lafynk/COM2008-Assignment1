package testing;

import java.sql.SQLException;

import SQLcode.Sql;
import classPkg.UserInfo;

public class logintest {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		UserInfo u = s.checkLogIn("", "");
		if (u == null) {
			System.out.println("no match");
		}
	}

}
