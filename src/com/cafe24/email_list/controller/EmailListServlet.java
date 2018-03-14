package com.cafe24.email_list.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.email_list.dao.EmailListDao;
import com.cafe24.email_list.vo.EmailListVo;
import com.cafe24.mvc.util.WebUtil;

/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmailListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String actionName = request.getParameter("a");
		if("form".equals(actionName)) {
			WebUtil.forward(request, response, "/WEB-INF/views/form.jsp");
		} else if("add".equals(actionName)) {
	    	String first_name = request.getParameter("fn");
	    	String last_name = request.getParameter("ln");
	  	  	String email = request.getParameter("email");
	  	  	
	  	 	EmailListDao dao = new EmailListDao();
	  	  	EmailListVo vo = new EmailListVo();
	  	  	vo.setEmail(email);
	  	  	vo.setFirst_name(first_name);
	  	  	vo.setLast_name(last_name);
	  	  	dao.insert(vo);
	  	  	
	  	  	WebUtil.redirect(request, response, "/email_list2/el?a=list");
		} else {	//list 요청 ( default )
			EmailListDao dao = new EmailListDao();
			List<EmailListVo> vos = dao.getList();
			request.setAttribute("list", vos);
			
			WebUtil.forward(request, response, "/WEB-INF/views/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
