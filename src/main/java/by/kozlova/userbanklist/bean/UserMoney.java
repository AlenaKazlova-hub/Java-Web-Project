package by.kozlova.userbanklist.bean;

public class UserMoney implements Comparable<UserMoney> {
	private int userId;
	private int userAmmount;

	public UserMoney(int userId, int userAmmount) {
		this.userId = userId;
		this.userAmmount = userAmmount;
	}

	
	public int getUserId() {
		return userId;
	}


	@Override
	public int compareTo(UserMoney other) {
		return this.userAmmount - other.userAmmount;
	}


	@Override
	public String toString() {
		return "UserMoney [userId=" + userId + ", userAmmount=" + userAmmount + "]";
	}

	
}
