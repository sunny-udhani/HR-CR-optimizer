package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.AddLeaveTypeVO;
import DAO.AddLeaveTypeHibernateDAO;
import DAO.CurrencyHibernateDAO;
import DAO.DAOFactory;

/**
 * Servlet implementation class AddLeaveType
 */
@WebServlet("/AddLeaveType")
public class AddLeaveType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLeaveType() {
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
			org.hibernate.Transaction t;
			
			String s = request.getParameter("addleavetypename");
			  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
			  AddLeaveTypeHibernateDAO altd = factory.getAddLeaveTypeDAO();
			  AddLeaveTypeVO altv = new AddLeaveTypeVO(); 
		
			  altv.setLeavetype(s);
			  t = altd.getTx();
			  altd.makePersistent(altv);
			  t.commit();
		}
		catch(Exception ex){ex.printStackTrace();}
	
	response.sendRedirect("Admin/AddLeaveType.jsp");
	}

}
