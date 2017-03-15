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

	@Override
	public void RegisterUser(UserLoginVo loginVo) throws Exception {

		userRegisterMapper.RegisterUser(loginVo);
		userRegisterMapper.RegisterUser1(loginVo);
		System.out.println(loginVo.getUserCustom().getLogin_user_id());

	}

	@Override
	public Integer findCountByLoginUser(UserLoginVo loginVo) throws Exception {
		 Integer integer = userRegisterMapper.findCountByLoginUser(loginVo);
		if (integer == null||integer==0) {
			return integer;

		} else {
			return integer;
		}
	}



	
}