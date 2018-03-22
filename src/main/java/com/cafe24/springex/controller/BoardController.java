package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@ResponseBody
	public String list( @RequestParam(value="p", required=true, defaultValue="1") Integer page ) {
		return "list()";
	}
	
	@ResponseBody
	public String insert() {
		return "insert()";
	}
}
