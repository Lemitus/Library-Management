package application;

public class User {
	private String userName, userPassword, userPermission, userNum;
	
	public String getName() {
		return userName;
	}
	public String getPassword() {
		return userPassword;
	}
	public String getPermission() {
		return userPermission;
	}
	public String getNum() {
		return userNum;
	}
	public void setName(String theName){
		userName = theName;
	}
	public void setPassword(String thePassword){
		userPassword = thePassword;
	}
	public void setPermission(String thePermission){
		userPermission = thePermission;
	}
	public void setNum(String theNum){
		userNum = theNum;
	}
}
