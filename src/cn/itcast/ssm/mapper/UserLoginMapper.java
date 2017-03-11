package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserLoginVo;

/**
* @author  CreateBy HouXueFeng
* @version 2017年3月11日 下午9:33:18
* @description
*/
public interface UserLoginMapper {
	
	public Integer findLoginMessageList(UserLoginVo loginVo)throws Exception;

}
