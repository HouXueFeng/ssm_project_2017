package cn.itcast.ssm.service;

import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserLoginVo;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午9:36:25
 * @description
 */
public interface RegisterService {
	public void RegisterUser(UserLoginVo loginVo) throws Exception;


	public Integer findCountByLoginUser(UserLoginVo loginVo) throws Exception;

}
