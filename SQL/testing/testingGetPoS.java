package testing;

import java.sql.SQLException;

import SQLcode.Sql;
import classPkg.PeriodOfStudy;

public class testingGetPoS {

	public static void main(String[] args) throws SQLException {
		Sql s = new Sql();
		PeriodOfStudy[] pos = s.getPeriodsOfStudy(170140910);
		for (PeriodOfStudy x : pos) {
			if (x != null)
				System.out.println(x.getPosRegCode() + " " + x.getRegNo() + " " + x.getPoS() + " " + x.getStartDate()
						+ " " + x.getEndDate() + " " + x.getLevel() + " " + x.getGrade() + " " + x.getProgress());
		}
	}
}
