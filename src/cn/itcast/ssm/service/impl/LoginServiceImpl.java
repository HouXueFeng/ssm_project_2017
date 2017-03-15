package cn.itcast.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.UserLoginMapper;
import cn.itcast.ssm.po.UserLoginVo;
import cn.itcast.ssm.service.LoginService;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午9:37:27
 * @description
 */
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserLoginMapper userLoginMapper;

	@Override
	public Integer findLoginMessageList(UserLoginVo loginVo) throws Exception {

		  Integer integer = userLoginMapper.findLoginMessageList(loginVo);
		
		 return integer;
	}
}