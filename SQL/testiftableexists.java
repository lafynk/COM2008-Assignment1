import java.sql.*;

public class testiftableexists {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team035","team035","b7af5f37");
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (con != null) con.close();
		}
	}

}
