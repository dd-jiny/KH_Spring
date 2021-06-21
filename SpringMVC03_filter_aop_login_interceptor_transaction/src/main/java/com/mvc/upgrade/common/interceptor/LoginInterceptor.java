package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[Interceptor]  : preHandler");
		
		
		//spring 3.2 이상부터는 servlet-context.xml에서 <exclude-mapping-path>를 사용하여 설정 가능 
		if(
				request.getRequestURI().contains("/loginform.do") || 
				request.getRequestURI().contains("/ajaxlogin.do") || 
				request.getRequestURI().contains("/test.do")) 
		{
			return true;
		}
		
		if(request.getSession().getAttribute("login") != null) {
			return true;
		}else if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		if(modelAndView != null) {
			logger.info("[Interceptor] viewName : "+ modelAndView.getViewName());
		}
		
		logger.info("[Interceptor] : postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[Interceptor] : afterCompletion");
	}

}


/*



1.  preHandle() 메서드는  컨트롤러가 호출되기 전에 실행됩니다. 

2. 매개변수 obj는 Dispatcher의 HandlerMapping 이 찾아준 컨트롤러의 메서드를 참조할 수 있는 HandlerMethod 객체입니다.
posthandle은 컨트롤러가 실행된후, ViewAndModel이 화면에 띄워지기 직전에
실행되고

3.  afterComplete() 은 뷰에서 최종 결과가 생성하는 일을 포함한 모든 일이 완료 되었을 때 실행됩니다.



*/