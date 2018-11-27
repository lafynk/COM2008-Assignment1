package classPkg;

public class Module {
	private String Module;
	private String Degree;
	private boolean obligatory;
	private int credit;
	private char level;
	private String taught;
	private double grade;
	private double resit;

	public Module(String m, String d, boolean o, int c, char l, String t, double g, double r) {
		Module = m;
		Degree = d;
		obligatory = o;
		credit = c;
		level = l;
		taught = t;
		grade = g;
		resit = r;
	}

	public String getModule() {
		return Module;
	}

	public String getDegree() {
		return Degree;
	}

	public boolean getOb() {
		return obligatory;
	}

	public int getCredit() {
		return credit;
	}

	public char getLevel() {
		return level;
	}

	public String getWhenTaught() {
		return taught;
	}

	public double getGrade() {
		return grade;
	}

	public double getResit() {
		return resit;
	}
}