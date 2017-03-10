package cn.itcast.ssm.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月10日 下午10:43:59
 * @description 输入json格式输出json并解析，输入key/value格式输出json并解析
 * 
 */
@Controller
public class JsonController {

	/**
	 * 
	 * @param requestJson方法是请求json格式，输出json
	 * @RequestBody是将商品信息的json串转化为itemsCustom对象
	 * @ResponseBody是将itemsCustom转化为json输出
	 * 
	 * @return
	 */
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom ItemsCustom) {

		return ItemsCustom;

	}
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson( ItemsCustom ItemsCustom) {

		return ItemsCustom;

	}

}
