package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.springex.vo.UserVo;

/**
 * 
 * RequestMapping(타입 + 메소드)
 */
@Controller
public class UserController {
	
/*	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(String email, String password) {
		return "UserController:join()";
	}*/
	//위 코드가 아래처럼 바뀐다. (Vo 사용)
	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join( @ModelAttribute UserVo vo ) {
		
		return "UserController:join()\n" + vo.toString();
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(){
		return "/WEB-INF/views/joinform.jsp";
	}
	
	/**
	 * 
	 * Join을 했을 때 Android같은 경우는 Redirect URL을 주면 안된다.
	 * Join에 성공했거나, 실패했다는 Data를 담아서 보내주어야 한다.
	 * 보통은 웹용과 모바일용 또는 REST용은 다르게 Mapping한다.
	 * 
	 */
	
	@ResponseBody
	@RequestMapping("/loginform")
	public String loginForm() {
		return "UserController:loginForm()";
	}
	
	@ResponseBody
	@RequestMapping( value="/login", method=RequestMethod.POST )
	public String login(
							@RequestParam( value="email", required=false ) String email,
							@RequestParam( value="pwd", required=true, defaultValue="") String password) {
		return "UserController:login() : " + email;
	}
	
	@ResponseBody
	@RequestMapping("/view/{no}")
	public String view( @PathVariable("no") Long no ) {
		return "UserController:view() " + no;
	}
}
