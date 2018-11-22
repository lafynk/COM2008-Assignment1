package classPkg;

public class UserInfo {
	private int regNo;
	private String permission;

	public UserInfo(int id, String p) {
		regNo = id;
		permission = p;
	}

	public int getRegNo() {
		return regNo;
	}

	public String getPermission() {
		return permission;
	}
}
