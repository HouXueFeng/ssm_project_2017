package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月11日 下午8:32:13
 * @description
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor.....preHandle");
		String url = request.getRequestURI();
		System.out.println(url);
		if (url.indexOf("login.action") >= 0) {
			return true;
		}else if(url.indexOf("register.action") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		if (username != null && password != null) {
			return true;
		}else{
		request.getRequestDispatcher("/WEB-INF/jsp/login11.jsp").forward(request, response);
		return false;// 表示拦截，不向下执行
		// return true;//表示执行
		}
	}
	// 进入handler之后，返回modelAndView之前执行
	// 应用场景从modeAndView出发（将公用的模型数据在这里传到视图，也可以在这里统一制定视图）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor.....postHandle");

	}
	// 执行handler完成此方法
	// 应用场景：统一异常处理，统一日志处理。
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor.....afterCompletion");

	}
}
