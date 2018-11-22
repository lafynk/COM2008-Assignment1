package SQLcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classPkg.UserInfo;

public class Sql {
	public UserInfo checkLogIn(String usr, String pw) throws SQLException {
		Connection con = setUpConnection();
		int ID = 0;
		String pass = "";
		String perm = "";
		boolean logIn;
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT TOP 1 Username FROM Users WHERE Username = ?");
			pstmt.setString(1, usr);
			ResultSet res = pstmt.executeQuery();
			ID = res.getInt(1);
			pass = res.getString(3);
			perm = res.getString(4);
			logIn = res.getBoolean(5);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		}
		if (con != null)
			con.close();
		if ((pw == pass) && (logIn = false)) {
			return new UserInfo(ID, perm);
		} else
			return null;
	}

	public Connection setUpConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team035", "team035", "b7af5f37");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		}
		return con;
	}
}
