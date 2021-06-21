package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n* remoteAddr :"+remoteAddr) //사용자의 ip주소 
		  .append("\n* uri :"+uri)//요청한 url중 포트번호와 쿼리 사이의 부분 즉 컨텍스트경로+ 서블릿 경로
		  .append("\n* url :"+url)// 쿼리를 제외한 프로토콜 + 도메인+포트번호+컨텍스트 경로+써블릿 경로
		  .append("\n* queryString :"+queryString) //쿼리스트링
		  .append("\n* referer :"+referer)//이전 페이지(보내는 페이지) url
		  .append("\n* agent:"+agent)//사용자 정보( browser,os등)
		  .append("\n");
		
		logger.info("\nLOG Filter" + sb);
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
	}

}












