package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/01")
public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public _01Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iVal = 10;
		long lVal = 10;
		float fVal = 3.14f;
		boolean bVal = true;
		Object obj = null;
		
		request.setAttribute("iVal", iVal);
		request.setAttribute("lVal", lVal);
		request.setAttribute("fVal", fVal);
		request.setAttribute("bVal", bVal);
		request.setAttribute("obj", obj);
		
		UserVo vo2 = new UserVo();
		UserVo vo3 = new UserVo();
		UserVo vo4 = new UserVo();
		
		vo2.setNo(2L);
		vo3.setNo(3L);
		vo4.setNo(4L);
		
		//requestScope
		request.setAttribute("vo2", vo2);
		//session scope
		request.getSession().setAttribute("vo3", vo3);
		//application scope
		request.getServletContext().setAttribute("vo4", vo4);
		
		request.getRequestDispatcher("WEB-INF/views/01.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
