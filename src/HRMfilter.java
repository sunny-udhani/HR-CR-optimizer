

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class HRMfilter
 */
@WebFilter("/HRMfilter")
public class HRMfilter implements Filter {

	ServletContext serv;
	private FilterConfig filterConfig;
	
    /**
     * Default constructor. 
     */
    public HRMfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String pageRequested = req.getRequestURI().toString();

        System.out.println(pageRequested);
//      System.out.println(session.isNew());
       
        if(session==null && !pageRequested.contains("LogIn.jsp")  && !pageRequested.contains("Registeration.jsp") && !pageRequested.contains("ForgotPassword.jsp")  && !pageRequested.contains("checkemail1.jsp"))
        {
        	HttpSession session1 = req.getSession(true);
        	session1.setAttribute("requri", pageRequested);
        	filterConfig.getServletContext().getRequestDispatcher("/Admin/LogIn.jsp").forward(req, resp);
        	}
        	
        else
        {
        	/*HttpSession session1 = req.getSession(true);
        	session1.setAttribute("requri", pageRequested);*/
        	
        	chain.doFilter(request, response);
        }
		// pass the request along the filter chain
      
        
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 System.out.println("Instance created of " + getClass().getName());
	        this.filterConfig = fConfig;
	        serv = filterConfig.getServletContext();
	        
	}

}
