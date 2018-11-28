package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQLcode.Sql;

public class test2 {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM Students");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int reg = res.getInt(1);
				String title = res.getString(2);
				String sur = res.getString(3);
				String fore = res.getString(4);
				String email = res.getString(5);
				String tutor = res.getString(6);
				String deg = res.getString(7);
				char pos = res.getString(8).charAt(0);
				String cl = res.getString(9);
				System.out.println(reg + " " + title + " " + sur + " " + fore + " " + email + " " + tutor + " " + deg
						+ " " + pos + " " + cl);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
}