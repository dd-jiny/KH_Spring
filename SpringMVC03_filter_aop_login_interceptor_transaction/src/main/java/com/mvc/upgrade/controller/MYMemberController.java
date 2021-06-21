package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MYMemberBiz;
import com.mvc.upgrade.model.dto.MYMemberDto;

@Controller
public class MYMemberController {

	private Logger logger = LoggerFactory.getLogger(MYMemberController.class);
	@Autowired
	private MYMemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("[Contoroller] : loginform.do");
		return"mymemberlogin";
	}
	
	/*
	 
	 @RequestBody : request로 넘어오는 데이터를 java Object(객체) 로 변환 
	 @ResponseBody : java Object(객체)를 response 객체에 데이터로 binding 
	 model and view에 담겨서 응답되는게 아니라 바로 응답 
	 
	 
	 */
	
	@RequestMapping(value = "/ajaxlogin.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MYMemberDto dto){
		logger.info("[Contoroller] : ajaxlogin.do");
		MYMemberDto res = biz.login(dto);
		boolean check = false; 
		if(res != null) {
			session.setAttribute("login", res);
			check = true; 
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		return map;
		
	}
	
	@RequestMapping("/registform.do")
	public String insertform(Model model) {
		logger.info("[Contoroller] : registform.do");
		return "mymemberinsert"; 
	}
	@RequestMapping("/registres.do")
	public String insertres(MYMemberDto dto) {
		if(biz.insertMember(dto)>0) {
			logger.info("[Contoroller] : registres.do");
			return "redirect:loginform.do";
			
		}
		return "redirect:insertform.do";
	}
	
	
	
	
	
}
