package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.AddLeaveTypeVO;
import vo.LeaveEntitlementVO;
import vo.Regdetails;
import vo.register;
import DAO.AddLeaveTypeHibernateDAO;
import DAO.DAOFactory;
import DAO.LeaveEntitlementHibernateDAO;
import DAO.RegdetailsHibernateDAO;

/**
 * Servlet implementation class EmployeeLeaveEntitlementView
 */
@WebServlet("/EmployeeLeaveEntitlementView")
public class EmployeeLeaveEntitlementView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int userregdid;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLeaveEntitlementView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		org.hibernate.Transaction t;
		HttpSession ss = request.getSession();
		
		  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		  
		  AddLeaveTypeHibernateDAO altd = factory.getAddLeaveTypeDAO();
	      AddLeaveTypeVO altv = new AddLeaveTypeVO();
	      
	      //***** Extracting Leave types
	      t = altd.getTx();
	      List lsc = altd.findAll(altv);
	      t.commit();
	      
		  ss.setAttribute("typelist", lsc);
			
			
			  LeaveEntitlementVO lev = new LeaveEntitlementVO();
			  LeaveEntitlementHibernateDAO led = factory.getLeaveEntitlementDAO();
				
			  String usernameregistered = (String)ss.getAttribute("username");

			 //****************  Extracting all entitlements  ***********************
			  
				List ls = led.findByQuery("From "+register.class.getSimpleName()+" where username=?", usernameregistered);
				
				Iterator itr = ls.iterator();
				
				if(itr.hasNext())
				{
					
					register regvo = (register)itr.next();
					int id = regvo.getId();
					
					Regdetails regdetailsvo = new Regdetails();
					RegdetailsHibernateDAO regdhd = factory.getRegdetailsDAO();
					List userls = regdhd.findByQuery("From "+Regdetails.class.getSimpleName()+" where reg_id=?", id);
					
					regdetailsvo = (Regdetails)userls.iterator().next();
					
					ss.setAttribute("user", regdetailsvo.getId());
					userregdid = regdetailsvo.getId();
					List levls = led.findByQuery("From leave_entitlement where employee=?", regdetailsvo.getId());
					Iterator levitr = levls.iterator();
					float i=0;
					while(levitr.hasNext())
					{
						lev = (LeaveEntitlementVO)levitr.next();
						i = i+lev.getLeaveEntitlement_days();
					}
					ss.setAttribute("total", i);
					ss.setAttribute("xlist", levls);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		org.hibernate.Transaction t;
		HttpSession ss = request.getSession();
		
		  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		  LeaveEntitlementHibernateDAO led = factory.getLeaveEntitlementDAO();
		  LeaveEntitlementVO lev = new LeaveEntitlementVO();
		  
		  String type = request.getParameter("EmployeeLeaveEntitlementViewtype");
		  
		  int userid = (Integer)(ss.getAttribute("user"));
		  
		  t = led.getTx();
		  
		  List entllist = led.findByQuery("from leave_entitlement where employee=? and leavetype=? ",userid,Integer.parseInt(type));
		  
		  t.commit();
		  
		  Iterator levitr = entllist.iterator();
		  float i=0;
			while(levitr.hasNext())
			{
				lev = (LeaveEntitlementVO)levitr.next();
				i = i+lev.getLeaveEntitlement_days();
			}
			ss.setAttribute("total", i);
		  
			ss.setAttribute("xrlist", entllist);
			
			response.sendRedirect("Admin/EmployeeLeaveEntitlementsView.jsp");
		
	}

}
