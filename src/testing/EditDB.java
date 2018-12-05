package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditDB {
	public static void main(String[] args) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team035", "team035", "b7af5f37");
			pstmt = con.prepareStatement("DELETE FROM ModuleAssignment WHERE DegreeCode = ? AND ModuleCode = ?");
			pstmt.setString(1, "COMU01");
			pstmt.setString(2, "COM0023");
			pstmt.executeUpdate();
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
