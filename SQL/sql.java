import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class sql {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team035","team035","b7af5f37");
			String sql = "CREATE TABLE Degrees(\n" + 
					" DegreeCode CHAR(6) NOT NULL PRIMARY KEY,\n" + 
					" DegreeName VARCHAR(30),\n" + 
					" DepartmentCode CHAR(3) NOT NULL,\n" + 
					" MaxLevelOfStudy ENUM('1','2','3','4'),\n" + 
					" Placement TINYINT(1),\n" + 
					" FOREIGN KEY (DepartmentCode) REFERENCES Departments) ENGINE=BDB;";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(sql);
				System.out.println("done");
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				if (stmt != null)
					stmt.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (con != null) con.close();
		}

	}

}