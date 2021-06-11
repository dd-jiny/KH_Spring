package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	/*
	 	Interceptor : 디스패쳐서블릿에서 컨트롤러 넘어갈때 핸들러 매핑한다라고 했었다. 핸들러 매핑 하는 신호를 인터셉터가 일단 뻇는다.
	 	그런다음 만일 세션에 저장한 값이 없다면 로그인페이지로 가라 유저라면 유저페이지로가라 어드민이라면 어드민 페이지로 가라 내가 원하는 대로
	 	컨트롤러를 다른 곳으로 갈 수 있게 해주는애 
	 	ex)회원전용 게시판에서 로그인한 회원만 이용하게 하는 것들을 해볼거임
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[Interceptor] : preHandle");
		
		// spring 3.2 이상부터는 servlet-context.xml에서 <exclude-mapping-path> 를 사용하여 설정가능
		
		if(request.getRequestURI().contains("/loginform.do") || request.getRequestURI().contains("ajaxlogin.do")) {
			return true; // 여기까지 로그인 하얀색창
		}
		/*
		if (request.getRequestURI().contains("/ajaxlogin.do")) {
			return true; //여기까지도 로그인 흰색창  위에 if문처럼 ||로 표현가능하다.
		}
		*/
		
		if (request.getSession().getAttribute("login") != null) {
			return true;
		} else if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		 
		return false; //컨트롤러로 보내지 마라 
		//return true; 컨트롤러로 보내라
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (modelAndView != null) { //이렇게 설정해놓으면 어떤 view가 출력되는지 볼 수 있다. 
			logger.info("[Interceptor] : " + modelAndView.getViewName());
		}
		logger.info("[Interceptor] : postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[Interceptor] : afterCompletion");
	}

}
