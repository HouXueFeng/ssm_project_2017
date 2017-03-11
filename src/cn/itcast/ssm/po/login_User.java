package cn.itcast.ssm.po;
/**
* @author  CreateBy HouXueFeng
* @version 2017年3月11日 下午9:09:11
* @description
*/
public class login_User {
	
	private int user_id;
	private String username;
	private String password;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "login_User [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}
	

}
