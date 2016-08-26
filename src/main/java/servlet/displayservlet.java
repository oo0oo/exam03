package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.Impl.UserDaoImpl;
import jdbc.ConnectionFactory;


public class displayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private service.CheckUserService cus = new service.CheckUserService();

       
 
    public displayservlet() {
        super();
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().makeConnection();
		UserDao userDao = new UserDaoImpl();
		try {
			ResultSet rs = userDao.display(conn);
			List<String> list = new ArrayList<String>();
			
			while(rs.next()){
				for(int i=0;rs.next();i++){
			   
			    list.add(rs.getString(i));
			    System.out.println(list.get(i));
			    }
			}
		} catch (SQLException e) {
						e.printStackTrace();
		}
		
		

		RequestDispatcher rd = null;
		String forward = "display.jsp" ;
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	
	}

		
}


