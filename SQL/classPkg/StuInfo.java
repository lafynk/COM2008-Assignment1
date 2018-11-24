package classPkg;

public class StuInfo {
	private int RegNo;
	private String title;
	private String surname;
	private String forename;
	private String email;
	private String tutor;
	private String degree;
	private char PoS;
	private String awardedclass;

	public StuInfo(int r, String t, String s, String f, String e, String tu, String d, char p, String c) {
		RegNo = r;
		title = t;
		surname = s;
		forename = f;
		email = e;
		tutor = tu;
		degree = d;
		PoS = p;
		awardedclass = c;
	}

	public int getRegNo() {
		return RegNo;
	}

	public String getTitle() {
		return title;
	}

	public String getSurname() {
		return surname;
	}

	public String getForename() {
		return forename;
	}

	public String getEmail() {
		return email;
	}

	public String getTutor() {
		return tutor;
	}

	public String getDegree() {
		return degree;
	}

	public char getPoS() {
		return PoS;
	}

	public String getAwardedClass() {
		return awardedclass;
	}
}
