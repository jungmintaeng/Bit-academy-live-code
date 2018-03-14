package com.cafe24.helloweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request body의 데이터 인코딩 : POST 방식으로 넘어오는 데이터를 인코딩
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("e");
		String password = request.getParameter("p");
		String name = request.getParameter("n");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String[] hobbies = request.getParameterValues("hobby");
		String intro = request.getParameter("introduce");
		
		System.out.println(email);
		System.out.println(password);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(birth);
		if(hobbies != null)
			for (String s : hobbies)
				System.out.println(s);
		System.out.println(intro);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
