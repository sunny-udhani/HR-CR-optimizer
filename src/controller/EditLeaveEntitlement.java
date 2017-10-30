package controller;

import java.io.IOException;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.LeaveEntitlementVO;
import DAO.DAOFactory;
import DAO.LeaveEntitlementHibernateDAO;
import DAO.ViewLeaveEntitlementHibernateDAO;

/**
 * Servlet implementation class EditLeaveEntitlement
 */
@WebServlet("/EditLeaveEntitlement")
public class EditLeaveEntitlement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLeaveEntitlement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("id");
		System.out.println("in servlet");
		System.out.println(Integer.parseInt(s));
		
		org.hibernate.Transaction t;
		
		DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		ViewLeaveEntitlementHibernateDAO vled = factory.getViewLeaveEntitlementDAO();
		t = vled.getTx();
		LeaveEntitlementVO ls = vled.findById(Integer.parseInt(s), false);
		t.commit();
		HttpSession ss = request.getSession();
		ss.setAttribute("object", ls);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("editleaveentitlementdays");
		
		String id = request.getParameter("id");
		
		org.hibernate.Transaction t;
		
		DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		LeaveEntitlementHibernateDAO led = factory.getLeaveEntitlementDAO();
		
		
		ViewLeaveEntitlementHibernateDAO vled = factory.getViewLeaveEntitlementDAO();
		t = vled.getTx();
		LeaveEntitlementVO lev = vled.findById(Integer.parseInt(id), false);
		t.commit();
		lev.setLeaveEntitlement_days(Integer.parseInt(s));
		
		
		t = led.getTx();
		led.update(lev);
		t.commit();
		
		response.sendRedirect("Admin/ViewLeaveEntitlement.jsp");
		
	}

}
