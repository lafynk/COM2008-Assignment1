package SQLcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import classPkg.Module;
import classPkg.PeriodOfStudy;
import classPkg.StuInfo;
import classPkg.UserInfo;

public class Sql {
	// find user
	public UserInfo checkLogIn(String usr, String pw) throws SQLException {
		Connection con = setUpConnection();
		int ID = 0;
		String pass = "";
		String perm = "";
		boolean logIn = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM Users WHERE Username = ?");
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
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		if (con != null)
			con.close();
		if ((pw == pass) && (logIn == false)) {
			return new UserInfo(ID, perm);
		} else
			return null;
	}

	// find student info from regNo
	public StuInfo getStudentInfo(int reg) throws SQLException {
		Connection con = setUpConnection();
		StuInfo student = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM Students WHERE RegNo = ?");
			pstmt.setInt(1, reg);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String title = res.getString(2);
				String sur = res.getString(3);
				String fore = res.getString(4);
				String email = res.getString(5);
				String tutor = res.getString(6);
				String degree = res.getString(7);
				char p = res.getString(7).charAt(0);
				String awClass = res.getString(8);
				student = new StuInfo(reg, title, sur, fore, email, tutor, degree, p, awClass);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		if (con != null)
			con.close();
		return student;
	}

	// returns array of modules taken this PoS
	public Module[] getModules(PeriodOfStudy p, StuInfo s) throws SQLException {
		Module[] modArray = new Module[10];
		Connection con = setUpConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		boolean ob = false;
		int credit = 0;
		char level = 'A';// default first value
		String taught = "";
		try {
			pstmt = con.prepareStatement("SELECT * FROM ModuleTaken WHERE PosRegCode = ?");
			pstmt2 = con.prepareStatement("SELECT * FROM ModuleAssignment WHERE ModuleCode = ? AND DegreeCode = ?");
			pstmt3 = con.prepareStatement("SELECT WhenTaught FROM Modules WHERE ModuleCode = ?");
			pstmt.setInt(1, p.getPosRegCode());
			ResultSet r1 = pstmt.executeQuery();
			while (r1.next()) {
				String mod = r1.getString(2);
				double grade = r1.getDouble(3);
				double resit = r1.getDouble(4);
				pstmt3.setString(1, mod);
				ResultSet r3 = pstmt3.executeQuery();
				while (r3.next()) {
					taught = r3.getString(1);
				}
				pstmt2.setString(1, mod);
				pstmt2.setString(2, s.getDegree());
				ResultSet r2 = pstmt2.executeQuery();
				while (r2.next()) {
					ob = r2.getBoolean(3);
					credit = r2.getInt(4);
					level = r2.getString(5).charAt(0);
				}
				modArray[modArray.length] = new Module(mod, s.getDegree(), ob, credit, level, taught, grade, resit);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (pstmt2 != null)
				pstmt2.close();
			if (pstmt3 != null)
				pstmt3.close();
		}
		if (con != null)
			con.close();
		return modArray;
	}

	public PeriodOfStudy[] getPeriodsOfStudy(int reg) throws SQLException {
		Connection con = setUpConnection();
		PeriodOfStudy[] posArray = new PeriodOfStudy[6];// can take 5 PoS's if taking masters with placement and can
														// only retake on PoS so 6 is max
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM PeriodsOfStudy WHERE RegistrationNo = ?");
			pstmt.setInt(1, reg);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int prcode = res.getInt(1);
				char pos = res.getString(3).charAt(0);
				Date start = res.getDate(4);
				Date end = res.getDate(5);
				char level = res.getString(6).charAt(0);
				double grade = res.getDouble(7);
				boolean progress = res.getBoolean(8);

				posArray[posArray.length] = new PeriodOfStudy(prcode, reg, pos, start, end, level, grade, progress);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("No access");
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		if (con != null)
			con.close();
		return posArray;
	}

	// add fns
	// add new User
	public void addUser(int id, String usr, String pw, String perm) throws SQLException {
		Connection con = setUpConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO Users VALUES (?,?,?,?,0)");
			pstmt.setInt(1, id);
			pstmt.setString(2, usr);
			pstmt.setString(3, pw);
			pstmt.setString(4, perm);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		if (con != null)
			con.close();
	}

	// add new department
	public void addDep(String code, String name) throws SQLException {
		Connection con = setUpConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO Departments VALUES (?,?)");
			pstmt.setString(1, code);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		if (con != null)
			con.close();
	}

	// add course
	public void addCourse(String code, String name, String dep, String level, boolean pl) throws SQLException {
		Connection con = setUpConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO Degrees VALUES (?,?,?,?,0)");
			pstmt.setString(1, code);
			pstmt.setString(2, name);
			pstmt.setString(3, dep);
			pstmt.setString(4, level);
			pstmt.setBoolean(5, pl);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.print("No access");
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		if (con != null)
			con.close();
	}
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
