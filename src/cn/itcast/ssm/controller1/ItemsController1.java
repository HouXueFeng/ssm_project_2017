package cn.itcast.ssm.controller1;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

/**
 * 
 */
// 使用Controller标识 它是一个控制器
@Controller
@RequestMapping("/items") // 进行窄化请求映射
// 为了对url进行分类管理，可以在这里定义根路径，最终访问的url是根路径+子路径。
public class ItemsController1 {
	// 通过注入的方式得到Service接口
	@Autowired
	private ItemsService itemsService;

	// ------------------------------------------------------------

	// 商品查询
	@RequestMapping("/queryItems")
	public String queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo, Model model) throws Exception {
		// 可修改商品的进行数据共享，查看是否能够得到修改商品的id号
		System.out.println(request.getParameter("id"));
		// 调用Service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		model.addAttribute("itemsList", itemsList);
		return "items/itemsList";
	}
	// ------------------------------------------------------------

	// @RequestMapping("/editItems")
	// 限制http请求方式
	// @RequestMapping(value="/editItems",method={RequestMethod.GET,RequestMethod.POST})
	// public ModelAndView editItems() throws Exception {
	// //根据id查询商品
	// ItemsCustom itemsCustom = itemsService.selectItemById(1);
	// ModelAndView modelAndView = new ModelAndView();
	// //将商品信息放到model中
	// modelAndView.addObject("itemsCustom", itemsCustom);
	// //商品修改页面
	// modelAndView.setViewName("items/editItems");
	// return modelAndView;
	// }
	// ------------------------------------------------------------
	// 使用参数绑定简单类型,使用@RequestParam进行参数绑定
	// 注意：@RequestParam里面的指定request传入参数和形参item_id进行绑定
	@RequestMapping(value = "/editItems", method = { RequestMethod.GET, RequestMethod.POST })
	public String editItems(Model model, @RequestParam(value = "id", required = true) Integer items_id)
			throws Exception {
		// 根据id查询商品
		ItemsCustom itemsCustom = itemsService.selectItemById(items_id);
		// 通过形式参数中的model将model数据传到页面
		// addAttribute（）相当于modelAndView.addObject（）方法
		model.addAttribute("itemsCustom", itemsCustom);
		return "items/editItems";
	}

	// ------------------------------------------------------------
	// controller返回ModelAndView类型
	// @RequestMapping("/editItemsSubmit")
	// public ModelAndView editItemsSubmit() throws Exception {
	// ModelAndView andView = new ModelAndView();
	// andView.setViewName("success");
	// return andView;
	// }
	// controller返回String类型
	// @RequestMapping("/editItemsSubmit")
	// public String editItemsSubmit() throws Exception {
	// //因为不用传递数据所以直接返回页面
	// return "success";
	// }

	// ------------------------------------------------------------
	// 进行修改信息之后的重定向
	// @RequestMapping("/editItemsSubmit")
	// public String editItemsSubmit() throws Exception {
	// //因为不用传递数据所以直接返回页面
	// //进行重定向redirect（不能进行数据共享）
	// //（使用重定向的方式可以在提交修改后直接返回查询商品列表的页面（查看是否修改成功查看当前数据））
	// return "redirect:queryItems.action";
	// }

	// ------------------------------------------------------------

	// 进行页面修改后的提交传入pojo（参数绑定pojo）
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) throws Exception {

		// 进行页面修改itemsCustom中传入了商品属性
		itemsService.updateItems(id, itemsCustom);
		// 因为不用传递数据所以直接返回页面
		// 进行重定向forward（可以进行数据共享）
		// （使用servlet请求转发的方式（HttpServletRequest
		// request传入request域给查询商品的页面查看是否数据共享）
		// 这里不能写/items的原因是在同一个controller中
		return "forward:queryItems.action";

		// ------------------------------------------------------------

	}	
	//因为checkbox是个多选框，所以可以进行批量删除操作傳入id數組
	// 批量删除商品
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception {
		itemsService.deletedItems1(items_id);
		return "success";
	}
}
