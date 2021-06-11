package com.mvc.upgrade.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {

	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "myboardlist";
	}
	
	@RequestMapping("/writeform.do")
	public String insertForm() {
		
		return "myboardinsert";
	}
	
	@RequestMapping(value="/writeres.do", method=RequestMethod.POST) //post방식으로 넘어왔을때만 진행하고싶다
	public String insertRes(MYBoardDto dto) {  //파라미터 MYBoardDto 로 하면 알아서 자동 저장해준다.
		
		if (biz.insert(dto) > 0) {
			
			return "redirect:list.do"; //response.sendredirect랑 비슷
		}
		return "redirect:writeform.do";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboarddetail";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(MYBoardDto dto) {
		
		if (biz.update(dto) > 0) {
			return "redirect:detail.do?myno="+dto.getMyno();
			
		}
		
		return "redirect:updateform.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		if (biz.delete(myno) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:detail.do?myno="+myno;
	}
}


















