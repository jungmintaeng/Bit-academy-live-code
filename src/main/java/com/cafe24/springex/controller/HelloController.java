package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(@RequestParam("n") String name,
			/*@AuthUser UserVo authUser,// Annotation을 만들어서 쓰는 방법*/
			Model model) {
		System.out.println(name);
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;	//model and view는 쓰지 말자
	}
}
