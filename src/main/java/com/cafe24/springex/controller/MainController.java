package com.cafe24.springex.controller;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	/*
	 * Method 단독 Mapping
	 */
	
	@RequestMapping("/main")
	public String main() {
		return "MainController:main()";
	}
	
	@ResponseBody
	@RequestMapping("/a/b/c/main")
	//@Auth(level="ADMIN") : 내가 만든 Annotation --> 인증이 있어야 해당 메소드에 접근할 수 있다.
	public String main2(HttpServletRequest request,
									HttpServletResponse response,
									HttpSession session,
									Writer out
									) {
		return "MainController:main()";
	}
}
//View Resolver, Message Converter