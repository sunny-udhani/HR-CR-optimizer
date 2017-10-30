package controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import DAO.DAOFactory;
import DAO.RegisterHibernateDAO;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{
			/*Context c = new InitialContext();
			  UserTransaction ut = (UserTransaction)
			    c.lookup("java:comp/UserTransaction");
			  ut.begin();*/
		  
		String s = request.getParameter("username");
		String s1 = request.getParameter("password");
		
		vo.register r = new vo.register();
		r.setUsername(s);
		r.setPassword(s1);
		
		DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		RegisterHibernateDAO rd = factory.getRegisterDAO();
		  
		
		Boolean flag = rd.search(r);
		
		if(flag == true){
			HttpSession ss = request.getSession();
			String uri = (String)getServletContext().getAttribute("requri");
			System.out.println("login: page ="+uri);
			getServletContext().removeAttribute("requri");
			ss.setAttribute("username", r.getUsername());
			if(uri==null)
			{
				response.sendRedirect("Admin/index.jsp");
			}else
			response.sendRedirect(uri);
		
		}
		else
		{
			HttpSession ss = request.getSession();
			ss.setAttribute("Error", "");
			getServletContext().getRequestDispatcher("/Admin/LogIn.jsp").forward(request, response);
		}
		
		//ut.commit();
		}catch(Exception e){e.printStackTrace();}
		}

}
