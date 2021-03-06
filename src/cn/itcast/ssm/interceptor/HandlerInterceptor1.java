package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
* @author  CreateBy HouXueFeng
* @version 2017年3月11日 下午7:03:51
* @description 拦截器类中的方法执行顺序
* 总结：
拦截器1放行，拦截器2 preHandle才会执行。
拦截器2 preHandle不放行，拦截器2 postHandle和afterCompletion不会执行。
只要有一个拦截器不放行，postHandle不会执行。
* 
*/
public class HandlerInterceptor1 implements HandlerInterceptor{

	
	//进入handler之前执行
	//用于身份认证，身份授权
	//比如身份认证，如果认证不通过表示当前用户没有登录，需要此方法拦截不在向下执行。
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("HandlerInterceptor1.....preHandle");
//		return false;//表示拦截，不向下执行
		return true;//表示执行
	}

	//进入handler之后，返回modelAndView之前执行
	//应用场景从modeAndView出发（将公用的模型数据在这里传到视图，也可以在这里统一制定视图）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor1.....postHandle");

	}
	//执行handler完成此方法
	//应用场景：统一异常处理，统一日志处理。
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor1.....afterCompletion");

		
	}

}
