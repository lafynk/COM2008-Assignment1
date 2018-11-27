package testing;

import java.sql.SQLException;

import SQLcode.Sql;

public class testing {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		s.removeUser(10000000);
	}
}