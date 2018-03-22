package com.cafe24.email_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.email_list.dao.EmailListDao;
import com.cafe24.email_list.vo.EmailListVo;

@Controller
public class EmailListController {
	//applicationContext.get("클래스명")으로 해도 객체가 튀어나온다.
	@Autowired	// 자동으로 해당 객체를 찾아서 이 레퍼런스에 묶어달라.	--> 의존성 주입
	private EmailListDao emailListDao;
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		List<EmailListVo> list = emailListDao.getList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(@ModelAttribute EmailListVo vo) {
		emailListDao.insert(vo);
		return "redirect:/list";
	}
}
