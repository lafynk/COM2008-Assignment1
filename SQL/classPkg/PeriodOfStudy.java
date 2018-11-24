package classPkg;

import java.util.Date;

public class PeriodOfStudy {
	private int PoSReg;
	private int RegNo;
	private char PoS;
	private Date startDate;
	private Date endDate;
	private char level;
	private double grade;
	private boolean progress;

	public PeriodOfStudy(int posr, int r, char p, Date s, Date e, char l, double g, boolean pr) {
		PoSReg = posr;
		RegNo = r;
		PoS = p;
		startDate = s;
		endDate = e;
		level = l;
		grade = g;
		progress = pr;
	}

	public int getPosRegCode() {
		return PoSReg;
	}

	public int getRegNo() {
		return RegNo;
	}

	public char getPoS() {
		return PoS;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public char getLevel() {
		return level;
	}

	public double getGrade() {
		return grade;
	}

	public boolean getProgress() {
		return progress;
	}
}
