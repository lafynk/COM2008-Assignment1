package SQLcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classPkg.StuInfo;
import classPkg.UserInfo;

public class Sql {
	// find user
	public UserInfo checkLogIn(String usr, String pw) throws SQLException {
		Connection con = setUpConnection();
		int ID = 0;
		String pass = "";
		String perm = "";
		boolean logIn;
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Users WHERE Username = ?");
			pstmt.setString(1, usr);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				ID = res.getInt(1);
				pass = res.getString(3);
				perm = res.getString(4);
				logIn = res.getBoolean(5);
			}
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

	// find student info from regNo
	public StuInfo getStudentInfo(int reg) throws SQLException {
		Connection con = setUpConnection();
		String title = "";
		String sur = "";
		String fore = "";
		String email = "";
		String tutor = "";
		String degree = "";
		char p;
		String awClass = "";
		StuInfo student = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Students WHERE RegNo = ?");
			pstmt.setInt(1, reg);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				title = res.getString(2);
				sur = res.getString(3);
				fore = res.getString(4);
				email = res.getString(5);
				tutor = res.getString(6);
				degree = res.getString(7);
				p = res.getString(7).charAt(0);
				student = new StuInfo(reg, title, sur, fore, email, tutor, degree, p, awClass);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		}
		return student;
	}

	// find/show fns still to do

	// find modules from posRegNo, returns list of module classes
	// find PoSG, return Grade as double (or make PoS class)
	// show student progress (return all PoS's)

	// add fns
	// add new User
	// add new department
	// add course
	// add module
	// add student
	// add taken module
	// add a grade for module
	// add resit grade for module

	// remove fns
	// delete user
	// delete department
	// delete course
	// delete module
	// delete student
	// drop taken module

	// update fns
	// update awarded class
	// update grade (ask for grade type in param, norm or resit)

	// other fns
	// check taken module are applicable (right level of study and module)
	// check taken module credit total (could leave for josh and tom)
	// calc weighted mean grade (could leave for tom and josh as no sql involved
	// other than getting all PoS grades)
	// pass or fail (same as above, we just need a fn to return PoSmodulesinfo like
	// find module)
	// find awarded class in final year (as above)

	// get connection
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
