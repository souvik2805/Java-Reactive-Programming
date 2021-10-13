package reactivefromudemy.sec04_operators.helper;

import reactivefromudemy.courseUtil.Util;

public class User {

	private int userId;
	private String name;

	public User(int userId) {
		this.userId = userId;
		this.name = Util.faker().name().fullName();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}

}
