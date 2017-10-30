package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOFactory;
import DAO.ViewLeaveEntitlementHibernateDAO;
import vo.AddLeaveTypeVO;
import vo.LeaveEntitlementVO;

/**
 * Servlet implementation class ViewLeaveEntitlement
 */
@WebServlet("/ViewLeaveEntitlement")
public class ViewLeaveEntitlement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLeaveEntitlement() {
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
		org.hibernate.Transaction t;
		
		DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		String flag = request.getParameter("flag");
		if(flag.equals("search"))
		{
			
			String s  = request.getParameter("viewleaveentitlementemp");
			String s1 = request.getParameter("viewleaveentitlementtype");
			/*String s2 = request.getParameter("viewleaveentitlementperiod");
			
			String[] period = s2.split("-");
			 
			DateFormat formatter = null;
		        Date convertedDate = null;
		        Date convertedDate1 = null;
		        // Creating SimpleDateFormat with yyyyMMdd format e.g."20110914"
		        
		        formatter = new SimpleDateFormat("MM/dd/yyyy");
		        try {
					convertedDate = (Date) formatter.parse(period[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("Date : " + convertedDate);
		        
		        try {
					convertedDate1 = (Date) formatter.parse(period[1]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("Date  : " + convertedDate1);
		    
		        int from = convertedDate.getDate();
		        int to = convertedDate1.getDate();
			 
		        System.out.println(to-from+1);
		    */
			LeaveEntitlementVO lev = new LeaveEntitlementVO();
			ViewLeaveEntitlementHibernateDAO vlehd = factory.getViewLeaveEntitlementDAO();
			
			vo.Regdetails rev = new vo.Regdetails();
			//RegdetailsHibernateDAO rdd = factory.getRegdetailsDAO();
			AddLeaveTypeVO altv = new AddLeaveTypeVO();
			altv.setId(Integer.parseInt(s1));
			rev.setId(Integer.parseInt(s));
			
			t= vlehd.getTx();
			
			/*lev.setLeaveEntitlement_startday(convertedDate);
			lev.setLeaveEntitlement_endday(convertedDate1);
			lev.setLeaveEntitlement_days(to-from+1);
			*/lev.setLeaveEntitlement_type(altv);
			lev.setLeaveEntitlement_emp(rev);
			List<LeaveEntitlementVO> ls = vlehd.search(lev);
			t.commit();
	
			Iterator<LeaveEntitlementVO> itr = ls.iterator();
			
			
			while(itr.hasNext())
			{
				
				lev = (LeaveEntitlementVO)itr.next();
				System.out.println(lev.getLeaveEntitlement_type().getLeavetype());
				System.out.println(lev.getLeaveEntitlement_days());
				
			}
			HttpSession ss =  request.getSession();
			ss.setAttribute("xlist", ls);
			response.sendRedirect("Admin/ViewLeaveEntitlement.jsp");
		}
		 else if(flag.equals("Delete"))
		 	{
			 String[] s = request.getParameterValues("checkbox-delete");
			 
			 LeaveEntitlementVO lev = new LeaveEntitlementVO();
			 ViewLeaveEntitlementHibernateDAO vlehd = factory.getViewLeaveEntitlementDAO();
				
			 t = vlehd.getTx();
			 for(int i=0;i<s.length;i++)
			 	{
				 System.out.println(s[i]);
				 lev.setLeaveEntitlement_id(Integer.parseInt(s[i]));
				 vlehd.makeTransient(lev);
				 System.out.println("inside for");
			 	}
			 System.out.println("outside for");
			 t.commit();
			 response.sendRedirect("Admin/ViewLeaveEntitlement.jsp");
		 	}
		
	}

}
