package controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import DAO.CurrencyHibernateDAO;
import DAO.DAOFactory;
import DAO.RegdetailsHibernateDAO;
import DAO.RegisterHibernateDAO;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
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
		String s0 = request.getParameter("email");
		String s1 = request.getParameter("password");
		String s2 = request.getParameter("full_name");
		String s3 = request.getParameter("address");
		String s4 = request.getParameter("city");
		String s5 = request.getParameter("gender");
		
		vo.register r = new vo.register();
		r.setActive(true);
		r.setUsername(s0);
		r.setPassword(s1);
		
		org.hibernate.Transaction t;
		
		  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		  RegisterHibernateDAO rd = factory.getRegisterDAO();
		  
		  t = rd.getTx();
		  int id= rd.insert(r);
		  t.commit();
		  
		vo.Regdetails d = new vo.Regdetails();
		d.setAddress(s3);
		d.setFull_name(s2);
		d.setCity(s4);
		d.setGender(s5);
		d.setReg_id(id);
		
			/*Context c = new InitialContext();
			  UserTransaction ut = (UserTransaction)
			    c.lookup("java:comp/UserTransaction");
			  ut.begin();*/
		
		RegdetailsHibernateDAO rdd = factory.getRegdetailsDAO();
		  
		t = rdd.getTx();
		rdd.makePersistent(d);
		t.commit();
		
		//ut.commit();
		}catch(Exception e){e.printStackTrace();}
		
		response.sendRedirect("Admin/LogIn.jsp");
	}

}
