package cn.itcast.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Byhouxuefeng 2017年3月10日
 */
public final class CustomExceptionResovler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		CustomException customException = null;
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			customException = new CustomException("未知错误");
		}
		String message = customException.getMessage();

		ModelAndView andView = new ModelAndView();

		andView.addObject("message", message);
		andView.setViewName("error");
		return andView;

	}

}
