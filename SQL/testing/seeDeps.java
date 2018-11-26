package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQLcode.Sql;

public class seeDeps {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = s.setUpConnection();
			pstmt = con.prepareStatement("SELECT * FROM Departments");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String code = res.getString(1);
				String name = res.getString(2);
				System.out.println(code + " " + name);
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