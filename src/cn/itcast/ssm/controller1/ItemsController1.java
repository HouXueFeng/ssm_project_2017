package cn.itcast.ssm.controller1;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.validator.ValidGroup;

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
		
//		if(itemsCustom==null){
//			throw  new CustomException("修改的商品不存在！！！");
//		}
		// 通过形式参数中的model将model数据传到页面
		// addAttribute（）相当于modelAndView.addObject（）方法
		model.addAttribute("items", itemsCustom);
		 //这里把items传到editItems.jsp
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

	
	//校验器
	//// 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
	//// bindingResult接收校验出错信息
	// 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
	
	
	//数据回显
	//数据回显默认情况下springmvc会把pojo数据放到request域，key等于pojo类型（首字母小写）
	//可以使用注解@ModelAttribute可以指定pojo回显到request域中key
	//这里因为itemsCustom是扩展的items
	//最简单的方式是使用mode.addattribute();把指定pojo回显到request域中key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model, HttpServletRequest request, Integer id,@ModelAttribute("items")
			@Validated(value = { ValidGroup.class }) ItemsCustom itemsCustom, BindingResult bindingResult,MultipartFile items_pic)
			throws Exception {
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);// 将错误的信息集合传到前台页面
			return "items/editItems";
		}
		String orginFileName=items_pic.getOriginalFilename();//原始名称
		/**
		 * 文件上传
		 */
		if(items_pic!=null&&orginFileName!=null&&orginFileName.length()>0){
		String pic_path="E:\\upload\\";//虚拟目录路径
		String newFileName=UUID.randomUUID()+orginFileName.substring(orginFileName.lastIndexOf("."));
		//新名称=随机数+后缀
		File file=new File(pic_path+newFileName);
		items_pic.transferTo(file);//上传

		itemsCustom.setPic(newFileName);

		
}

		// 进行页面修改itemsCustom中传入了商品属性mode.add()
		itemsService.updateItems(id, itemsCustom);
		// 因为不用传递数据所以直接返回页面
		// 进行重定向forward（可以进行数据共享）
		// （使用servlet请求转发的方式（HttpServletRequest
		// request传入request域给查询商品的页面查看是否数据共享）
		// 这里不能写/items的原因是在同一个controller中
		return "forward:queryItems.action";

		// ------------------------------------------------------------

	}

	// 因为checkbox是个多选框，所以可以进行批量删除操作傳入id數組
	// 批量删除商品
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception {
		itemsService.deletedItems1(items_id);
		return "success";
	}

	// 查询到商品的批量信息
	@RequestMapping("editItemsQuery1")
	public String editItemsQuery1(Model model, ItemsQueryVo itemsQueryVo,HttpServletRequest request) throws Exception {

		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		model.addAttribute("itemsList", itemsList);
		return "items/editItemsQuery2";
	}

	// 批量修改商品提交
	// 通过ItemsQueryVo接收批量提交的商品，将商品信息存储到itemsQueryVo中itemsList属性中
	@RequestMapping("/editQueryAllItems")
	// 将修改的信息存入ItemsQueryVo的list集合的itemsList属性中
	public String editQueryAllItems(ItemsQueryVo itemsQueryVo) throws Exception {
		itemsService.updateBatch1(itemsQueryVo);
		return "forward:queryItems.action";	
	}
	
	//商品分类
	//@ModelAttribute可以吧方法的返回值放到request中的key
	@ModelAttribute("itemtypes")
	public Map<String,String>getItemTypes(){
		Map<String, String>itemTypes=new HashMap<String, String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");
		return itemTypes;
		
	}
}
