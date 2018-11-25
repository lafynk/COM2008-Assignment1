package testing;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQLcode.Sql;

public class seePos {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM PeriodsOfStudy");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int posreg = res.getInt(1);
				int reg = res.getInt(2);
				char pos = res.getString(3).charAt(0);
				Date start = res.getDate(4);
				Date end = res.getDate(5);
				char lvl = res.getString(6).charAt(0);
				double grade = res.getDouble(7);
				boolean p = res.getBoolean(8);
				System.out.println(
						posreg + " " + reg + " " + pos + " " + start + " " + end + " " + lvl + " " + grade + " " + p);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
		}
	}
}