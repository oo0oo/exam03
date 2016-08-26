package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class permissionfilter implements Filter {


    public permissionfilter() {
    	
    }
	public void init(FilterConfig fConfig) throws ServletException {
			}


	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String servletpath = req.getServletPath();
		HttpSession session = req.getSession();
		String flag = (String)session.getAttribute("flag");
		//System.out.println("haha");
		//System.out.println(servletpath);
		if((servletpath!=null&&servletpath.equals("/login.jsp")
				||servletpath.equals("/index.jsp"))
				||servletpath.equals("/CheckServlet")
				||servletpath.equals("/success.jsp")
				||servletpath.equals("/error.jsp")
				||servletpath.equals("/logoutservlet")){
			chain.doFilter(request, response);
		}else{
	
			if(flag!=null&&flag.equals("login_success")){
				chain.doFilter(request, response);

			}else if((flag!=null&&flag.equals("login_error"))
					||servletpath.equals("/add.jsp")
					||servletpath.equals("/delete.jsp")
					||servletpath.equals("/display.jsp")){
				req.setAttribute("msg", "登陆失败请重新登陆！！");
				req.setAttribute("return_uri", servletpath);
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
			}else{
				req.setAttribute("msg", "您尚未登陆！！");
				
				req.setAttribute("return_uri", servletpath);
				System.out.println((String)req.getAttribute("return_uri"));

				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
			}
		}
		
	}

	public void destroy() {
			}

    }