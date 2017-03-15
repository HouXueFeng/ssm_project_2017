package cn.itcast.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.UserLoginMapper;
import cn.itcast.ssm.mapper.UserRegisterMapper;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserLoginVo;
import cn.itcast.ssm.service.LoginService;
import cn.itcast.ssm.service.RegisterService;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午9:37:27
 * @description
 */
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserRegisterMapper userRegisterMapper;

	
	//进行注册service
	@Override
	public void RegisterUser(UserLoginVo loginVo) throws Exception {
		if (loginVo.getUserCustom().getUsername() != null || !(loginVo.getUserCustom().getUsername().equals(""))) {

			// 一个serives调用两个mapper
			userRegisterMapper.RegisterUser(loginVo);
			userRegisterMapper.RegisterUser1(loginVo);
			System.out.println(loginVo.getUserCustom().getLogin_user_id());
			//看是否能可以拿到uuid（）
		}
	}

	/**
	 * 这里判断了注册时输入空值的情况
	 *  若输入注册的某个信息为空则 
	 *  暴力返回已经存在了用户已经存在空值的情况即返回!=0
	 */
	@Override
	public Integer findCountByLoginUser(UserLoginVo loginVo) throws Exception {
		while (!(loginVo.getUserCustom().getUsername().equals(""))
				|| !(loginVo.getUserCustom().getPassword().equals(""))
				|| !(loginVo.getUserCustom().getUser_trueName().equals(""))
				|| !(loginVo.getUser().getAddress().equals(""))) {
			Integer integer = userRegisterMapper.findCountByLoginUser(loginVo);
			if (integer == null || integer == 0 || integer.equals("")) {
				return integer;

			} else {
				return integer;
			}
		}
		return 1;
	}
}