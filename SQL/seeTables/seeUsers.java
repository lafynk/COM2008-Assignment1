package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQLcode.Sql;

public class seeUsers {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM Users");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int reg = res.getInt(1);
				String usr = res.getString(2);
				String pw = res.getString(3);
				String perm = res.getString(4);
				boolean l = res.getBoolean(5);
				System.out.println(reg + " " + usr + " " + pw + " " + perm + " " + l);
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