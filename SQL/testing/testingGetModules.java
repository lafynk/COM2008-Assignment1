package testing;

import java.sql.SQLException;

import SQLcode.Sql;
import classPkg.Module;
import classPkg.PeriodOfStudy;
import classPkg.StuInfo;

public class testingGetModules {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		StuInfo st = s.getStudentInfo(170140910);
		PeriodOfStudy[] pos = s.getPeriodsOfStudy(170140910);
		Module[] mod = s.getModules(pos[1], st);
		for (Module x : mod) {
			if (x != null)
				System.out.println(x.getModule() + " " + x.getDegree() + " " + x.getOb() + " " + x.getCredit() + " "
						+ x.getLevel() + " " + x.getWhenTaught() + " " + x.getGrade() + " " + x.getResit());
		}
	}
}
