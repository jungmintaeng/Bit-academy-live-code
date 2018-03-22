package com.cafe24.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.guestbook.dao.GuestBookDao;
import com.cafe24.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookDao dao;
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		model.addAttribute("list", dao.getList());
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/deleteform")
	public String deleteForm() {
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam(value="target", required=true, defaultValue="0L") Long no,
								 @RequestParam(value="password", required=true, defaultValue="") String password) {
		GuestBookVo vo = dao.getRowByNo(no);
		if(password != null && password.equals(vo.getPassword())){
			dao.delete(no);
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value="/add")
	public String add(@ModelAttribute GuestBookVo vo) {
		dao.insert(vo);
		return "redirect:/list";
	}
}
