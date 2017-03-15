package cn.itcast.ssm.po;

import java.util.List;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午9:14:06
 * @description
 */
public class UserLoginVo {

	private UserCustom userCustom;
	private List<UserCustom> ListCustom;
	private User user;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<UserCustom> getListCustom() {
		return ListCustom;
	}

	public void setListCustom(List<UserCustom> listCustom) {
		ListCustom = listCustom;
	}

	@Override
	public String toString() {
		return "UserLoginVo [userCustom=" + userCustom + ", ListCustom=" + ListCustom + "]";
	}

}
