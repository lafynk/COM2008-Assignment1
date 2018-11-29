package testing;

import java.sql.SQLException;

import SQLcode.Sql;

public class testing {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		s.addCourse("BSc Computer Science with P", "COM", "3", true, "U");
	}
}