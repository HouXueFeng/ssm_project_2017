package cn.itcast.ssm.controller1;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.itcast.ssm.po.User;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserLoginVo;
import cn.itcast.ssm.service.LoginService;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午8:34:24
 * @description
 */

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")

	public String login(Model model, HttpSession httpSession, UserLoginVo loginVo) throws Exception {

		Integer integer = loginService.findLoginMessageList(loginVo);

		UserCustom userCustom = loginVo.getUserCustom();
		String username = userCustom.getUsername();
		String password = userCustom.getPassword();
		if (integer != null&&integer!=0) {
			httpSession.setAttribute("username", username);
			httpSession.setAttribute("password", password);
			
			return "redirect:/items/queryItems.action";

		} else {
			model.addAttribute("msg", "输入有误");
		
		}
		return "login11";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// 清除session
		session.invalidate();

		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}

}
