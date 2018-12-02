package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import SQLcode.Sql;

public class seeModuleTaken {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM ModuleTaken");
			ResultSet res = pstmt.executeQuery();
			ResultSetMetaData rsmd = res.getMetaData();
			System.out.println(rsmd.getColumnName(4));
			while (res.next()) {
				int posreg = res.getInt(1);
				String mod = res.getString(2);
				double g = res.getDouble(3);
				double r = res.getDouble(4);
				System.out.println(posreg + " " + mod + " " + g + " " + r);
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
