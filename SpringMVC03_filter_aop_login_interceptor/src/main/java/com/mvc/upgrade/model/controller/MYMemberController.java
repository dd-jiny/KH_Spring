package com.mvc.upgrade.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MYMemberBiz;
import com.mvc.upgrade.model.dto.MYMemberDto;

@Controller // 컨트롤러는 controller!
public class MYMemberController {
	
	private Logger logger = LoggerFactory.getLogger(MYBoardController.class);
	@Autowired
	private MYMemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("[Controller] : list.do");
		
		return "mymemberlogin";
	}

	/*
	 jackson 이 들어오는 json 을 자바 객체로도 변환시켜주고 
	 나가는 map을 json으로도 변환시켜준다. 
	 
	 @RequestBody : request로 넘어오는 데이터를 java Object(객체) 로 변환 
 
	 자바에는 json이라는 타입이없다.
	 ajax로 json 형태로 넘어온 값들을 requestbody가 자바객체로 바인딩을 시켜준다. 
	 k=v 형태로 넘어온 id와 pw를 Dto에알아서 세터에 넣어줌  
	 requestbody 와 content 타입이 한짝궁이라 일단 생각해 
	 
	 	 
	 @ResponseBody : java Object(객체)를 response 객체에 데이터로 binding 
	 model and view에 담겨서 응답되는게 아니라 바로 응답
	 컨트롤러에서 String 값을 리턴중이다. view(name)이 String값으로 리턴되고 있었다.
	 
	 결국 마지막에 리턴되는 타입은 json
	 
	 request,response body들에 담겨져있는 값을 자바객체나 , json타입으로 변환시켜주는게 jackson의 역할
	 body는 그럼 바구니 같은건가..?
	 */
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MYMemberDto dto){
		logger.info("[Controller] : list.do");
		
		MYMemberDto res = biz.login(dto);
		boolean check = false;
		if ( res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	
	@RequestMapping("/registform.do")
	public String insertForm() {
		logger.info("[Controller] : list.do");
		
		return "mymemberinsert";
	}
	
	@RequestMapping("/registres.do")
	public String insertres(MYMemberDto dto) {
		logger.info("[Controller] : list.do");
		
		if(biz.insertMember(dto)>0) {
			
			return "redirect:loginform.do";
		}
		
		return "redirect:insertform.do";
	}
	
}












