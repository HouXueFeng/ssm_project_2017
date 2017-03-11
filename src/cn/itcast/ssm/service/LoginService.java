package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserLoginVo;

/**
* @author  CreateBy HouXueFeng
* @version 2017年3月11日 下午9:36:25
* @description
*/
public interface LoginService {
	public Integer findLoginMessageList(UserLoginVo loginVo)throws Exception;


}
