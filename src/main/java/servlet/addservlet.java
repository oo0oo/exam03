package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;


public class addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private service.CheckUserService cus = new service.CheckUserService();
   
    public addservlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String discripton = request.getParameter("discription");
		String language =  request.getParameter("language");

		RequestDispatcher rd = null;
		String forward = null ;
		if(title==null||discripton==null||language==null){
			request.setAttribute("msg", "内容不能为空！");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}else{
			User user = new User();
			user.setTitle(title);
			user.setDescription(discripton);
			user.setLanguage(language);
			
			boolean bool = cus.check(user);
			if(bool){
				forward = "/success.jsp";
				request.setAttribute("msg", "添加成功！");
			}else{
				request.setAttribute("msg", "添加失败！");
				forward = "/error.jsp";				
			}
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
		
	}

	


}
