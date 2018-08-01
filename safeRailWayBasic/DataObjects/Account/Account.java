package Account;

import Common.Utilities;

public class Account {
	private String email;
	private String password;
	private String confirmpass;
	private String pid;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void generateData() {
		String pass = Utilities.getRandomString(8);

		this.setEmail("testAuto" + Utilities.getRandomString(8) + "@gmail.com");
		this.setPassword(pass);
		this.setConfirmpass(pass);
		this.setPid(Utilities.getRandomString(8));
	}
}
