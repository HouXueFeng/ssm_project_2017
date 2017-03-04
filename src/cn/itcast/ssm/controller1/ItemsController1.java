package cn.itcast.ssm.controller1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

/**
 * 
 */
// 使用Controller标识 它是一个控制器
@Controller
public class ItemsController1 {
	// 通过注入的方式得到Service接口
	@Autowired
	private ItemsService itemsService;

	// 商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {
		// 调用Service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);

		ModelAndView modelAndView = new ModelAndView();
		// 相当于requset的setAttribute，在jsp页面中通过itemList取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定试图
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}

	@RequestMapping("/editItems")
	public ModelAndView editItems() throws Exception {
		//根据id查询商品
		ItemsCustom itemsCustom = itemsService.selectItemById(1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}

	@RequestMapping("/editItemsSubmit")
	public ModelAndView editItemsSubmit() throws Exception {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("success");
		return andView;
	}
}
