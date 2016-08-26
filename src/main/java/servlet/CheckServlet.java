package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.CheckUserService;


public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private service.CheckUserService cus = new service.CheckUserService();
	public CheckServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");

		RequestDispatcher rd = null;
		String forward = null ;
		if(uname==null){
			request.setAttribute("msg", "用户名为空！");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}else{
			User user = new User();
			user.setName(uname);
			
			boolean bool = cus.check(user);
			if(bool){
				forward = "/success.jsp";
				request.getSession().setAttribute("flag", "login_success");
			}else{
				request.setAttribute("msg", "用户名错误，请重新输入！");
				forward = "/error.jsp";
				request.getSession().setAttribute("flag", "login_error");
			}
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
		
		
		
		
	}

}
