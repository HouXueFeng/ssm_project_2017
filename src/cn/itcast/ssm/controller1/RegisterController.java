package cn.itcast.ssm.controller1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.itcast.ssm.po.User;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserLoginVo;
import cn.itcast.ssm.service.LoginService;
import cn.itcast.ssm.service.RegisterService;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午8:34:24
 * @description
 */

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping("/register")
	public String register(HttpServletRequest request, Model model, HttpSession httpSession, UserLoginVo loginVo)
			throws Exception {
		Integer integer = registerService.findCountByLoginUser(loginVo);

		if (integer == 0) {

			registerService.RegisterUser(loginVo);


			return "login11";
		} else {
			httpSession.setAttribute("message1", "注册不成功，请核实注册信息！");
			return "redirect:/user_register1.jsp";

		}
	}
}