package com.cafe24.guestbook.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.guestbook.dao.GuestBookDao;
import com.cafe24.guestbook.vo.GuestBookVo;
import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;

public class ListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> vos = dao.getList();
		request.setAttribute("list", vos);
		
		WebUtil.forward(request, response, "/WEB-INF/views/index.jsp");
	}
	
}
