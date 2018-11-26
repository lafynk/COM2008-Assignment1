package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQLcode.Sql;

public class seeAssMod {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM ModuleAssignment");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String deg = res.getString(1);
				String mod = res.getString(2);
				boolean o = res.getBoolean(3);
				int cr = res.getInt(4);
				String lvl = res.getString(5);
				System.out.println(deg + " " + mod + " " + o + " " + cr + " " + lvl);
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