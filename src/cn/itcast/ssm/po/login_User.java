package cn.itcast.ssm.po;

import javax.validation.constraints.NotNull;

import cn.itcast.ssm.validator.ValidGroup;
import cn.itcast.ssm.validator.ValidGroup3;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午9:09:11
 * @description
 */
public class login_User {

	private int login_user_id;

	@NotNull(message = "{login_User.username.isNull.error}", groups = { ValidGroup3.class })
	private String username;
	
	@NotNull(message = "{login_User.password.isNull.error}", groups = { ValidGroup3.class })
	private String password;
	
	@NotNull(message = "{login_User.user_trueName.isNull.error}", groups = { ValidGroup3.class })
	private String user_trueName;

	public int getLogin_user_id() {
		return login_user_id;
	}

	public void setLogin_user_id(int login_user_id) {
		this.login_user_id = login_user_id;
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

	public String getUser_trueName() {
		return user_trueName;
	}

	public void setUser_trueName(String user_trueName) {
		this.user_trueName = user_trueName;
	}

}
