package flowershop.entity;


public class User {
	private int uId;
	private String uName;
	private String uPassword;
	
	public User() {}
	public User(int uId,String uName,String uPassword) {
		this.uId=uId;
		this.uName=uName;
		this.uPassword=uPassword;
	}
	public int getUserId() {
		return uId;
	}
	public void setUserId(int newUserId) {
		
	}
	public String getUserName() {
		return uName;
	}
	public void setUserName(String newUserName) {
		uName=newUserName;
	}
	public String getUserPassword() {
		return uPassword;
	}
	public void setUserPassword(String newPassword) {
		this.uPassword=newPassword;
	}
}
