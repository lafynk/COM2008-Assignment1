package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQLcode.Sql;

public class seeDegs {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM Degrees");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String deg = res.getString(1);
				String mod = res.getString(2);
				String dep = res.getString(3);
				String lvl = res.getString(4);
				boolean pl = res.getBoolean(5);
				String t = res.getString(6);
				System.out.println(deg + " " + mod + " " + dep + " " + lvl + " " + pl + " " + t);
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