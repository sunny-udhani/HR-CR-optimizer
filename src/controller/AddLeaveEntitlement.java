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

import org.apache.tomcat.jni.Lock;

import vo.AddLeaveTypeVO;
import vo.CurrencyVO;
import vo.LeaveEntitlementVO;
import DAO.AddLeaveTypeHibernateDAO;
import DAO.CurrencyHibernateDAO;
import DAO.DAOFactory;
import DAO.LeaveEntitlementHibernateDAO;
import DAO.Regdetails;
import DAO.RegdetailsHibernateDAO;

/**
 * Servlet implementation class AddLeaveEntitlement
 */
@WebServlet("/AddLeaveEntitlement")
public class AddLeaveEntitlement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLeaveEntitlement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try{
			 
			org.hibernate.Transaction t;
			
		  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		  LeaveEntitlementHibernateDAO led = factory.getLeaveEntitlementDAO();
		 
		  /* Boolean as= (apgd==null) ;
		  System.out.println(as);*/
		  //AddPaygradeHibernateDAO apghd = new AddPaygradeHibernateDAO();
	     
		  LeaveEntitlementVO lev = new LeaveEntitlementVO();
	     /* DAO.Regdetails regd = new DAO.Regdetails();*/
	      vo.Regdetails regv = new vo.Regdetails();
		  
		  RegdetailsHibernateDAO rdd = factory.getRegdetailsDAO();
	      //apgd.setSession(MyUtility.getSession());
	     /* UserTransaction tx = factory.getTransaction();
	      tx.begin();*/
	      
	      t = led.getTx();
	      List ls = rdd.findAll(regv);
	      t.commit();
	        
	      AddLeaveTypeHibernateDAO altd = factory.getAddLeaveTypeDAO();
	      AddLeaveTypeVO altv = new AddLeaveTypeVO();
	      
	      t = altd.getTx();
	      List lsc = altd.findAll(altv);
	      t.commit();
	      
	        HttpSession ss = request.getSession();
			ss.setAttribute("emplist", ls);
			ss.setAttribute("typelist", lsc);
			
	}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getCause());
		}  
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String s = request.getParameter("leaveentitlementemp");
			String s1 = request.getParameter("leaveentitlementLeaveType");
			String s2 = request.getParameter("leaveentitlementperiod");
			String s3 = request.getParameter("leaveentitlementdays");
			System.out.println(s +"- "+s1+"- "+s2);
			
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
		    
		        int from = convertedDate.getMonth();
		        int to = convertedDate1.getMonth();
			 
		        System.out.println(to-from+1);
		        org.hibernate.Transaction t;
			
		        DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		        LeaveEntitlementHibernateDAO led = factory.getLeaveEntitlementDAO();
		 
				/* Boolean as= (apgd==null) ;
				System.out.println(as);*/
				//AddPaygradeHibernateDAO apghd = new AddPaygradeHibernateDAO();
			     
				LeaveEntitlementVO lev = new LeaveEntitlementVO();
				
				LeaveEntitlementVO levsearch = new LeaveEntitlementVO();
				vo.Regdetails rev = new vo.Regdetails();
				//RegdetailsHibernateDAO rdd = factory.getRegdetailsDAO();
				AddLeaveTypeVO altv = new AddLeaveTypeVO();
				altv.setId(Integer.parseInt(s1));
				rev.setId(Integer.parseInt(s));
				/*t=altd.getTx();
				altd.makePersistent(altv);
				t.commit();*/
				
				
				lev.setLeaveEntitlement_emp(rev);
				/*t = rdd.getTx();
				rdd.makePersistent(regv);
				t.commit();
				*/
				
				
				t= led.getTx();
				
				lev.setLeaveEntitlement_startday(convertedDate);
				lev.setLeaveEntitlement_endday(convertedDate1);
				lev.setLeaveEntitlement_days(Integer.parseInt(s3));
				lev.setLeaveEntitlement_type(altv);
				List xx = led.findByQuery("From leave_entitlement where employee="+lev.getLeaveEntitlement_emp().getId()+" and leavetype="+lev.getLeaveEntitlement_type().getId()+" " );
				
				Iterator x = xx.iterator();
				while(x.hasNext())
				{
					levsearch = (LeaveEntitlementVO)x.next();
					
					float i = lev.getLeaveEntitlement_days();
					lev.setLeaveEntitlement_days(i+levsearch.getLeaveEntitlement_days());
					
					Date d1,d2;
					d1 = levsearch.getLeaveEntitlement_startday();
					d2 = levsearch.getLeaveEntitlement_endday();
					
					System.out.println("delete");
					led.makeTransient(levsearch);
					
					if(d1.getMonth()>from && d2.getMonth()<to)
						{
							System.out.println("1");
							lev.setLeaveEntitlement_startday(convertedDate);
							lev.setLeaveEntitlement_endday(convertedDate1);
						}
					else if(d1.getMonth()<from && d2.getMonth()>to)
					{
						System.out.println("2");
						lev.setLeaveEntitlement_startday(d1);
						lev.setLeaveEntitlement_endday(d2);
					}
					else if(d1.getMonth()>from && d2.getMonth()>to)
					{
						System.out.println("3");
						lev.setLeaveEntitlement_startday(convertedDate);
						lev.setLeaveEntitlement_endday(d2);
					}
					else if(d1.getMonth()<from && d2.getMonth()<to)
					{
						System.out.println("4");
						lev.setLeaveEntitlement_startday(d1);
						lev.setLeaveEntitlement_endday(convertedDate1);
					}
				}
				
				
				
				
				
				
				led.makePersistent(lev);
				t.commit();
		
				response.sendRedirect("Admin/ViewLeaveEntitlement.jsp");
		}catch(Exception ex){ex.printStackTrace();}
	}

}
