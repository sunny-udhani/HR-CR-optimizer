package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.Days;

import DAO.AssignLeavetoEmployeeDAO;
import DAO.AssignLeavetoEmployeeHibernateDAO;
import DAO.DAOFactory;
import DAO.LeaveEntitlementHibernateDAO;
import vo.AssignLeavetoEmployeeVO;
import vo.LeaveEntitlementVO;
import vo.LeaveStatusVO;

/**
 * Servlet implementation class AssignLeavetoEmployee
 */
@WebServlet("/AssignLeavetoEmployee")
public class AssignLeavetoEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String flag="no-redirect";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignLeavetoEmployee() {
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
		String s = request.getParameter("assignleaveemployeename");
		String s1 = request.getParameter("assignleaveLeaveType");
		String s2 = request.getParameter("assignleaveperiod");
		System.out.println(s +" - "+s1+" - "+s2);
	    
		String[] period = s2.split("-");
		 
		
			Date convertedDate = null;
	        Date convertedDate1 = null;
	        // Creating SimpleDateFormat with yyyyMMdd format e.g."20110914"
	        convertedDate = dateformat(period[0]);
	        convertedDate1 = dateformat(period[1]);
	        
	        
	    AssignLeavetoEmployeeVO obj = new AssignLeavetoEmployeeVO();
	    LeaveStatusVO lsv = new LeaveStatusVO();
	    LeaveEntitlementVO lev = new LeaveEntitlementVO();

//	    obj.setAssignLeavetoEmployeeVO_empname(s);
//	    obj.setLeavetype(s1);

	    
	    LocalDate datefrom = tolocaldate(convertedDate);
	    LocalDate dateto = tolocaldate(convertedDate1);
	    
	    System.out.println("1: --- from: "+datefrom+" to: "+dateto+" ---");
	    
	    Period p = Period.between(datefrom, dateto);
	    int i = p.getDays();
	    System.out.println("2: Days >>>> "+(i+1)+" <<<<");
	    i = i+1;
	   // int i = convertedDate1.getDate() - convertedDate.getDate();
	    org.hibernate.Transaction t;
		
        DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  

	    AssignLeavetoEmployeeHibernateDAO obj1 = factory.getAssignLeavetoEmployeeDAO();
	    LeaveEntitlementHibernateDAO led = factory.getLeaveEntitlementDAO();
	    
	    
	    t = led.getTx();
	    List ls = led.findByQuery("from leave_entitlement where employee="+Integer.parseInt(s)+" and leavetype="+Integer.parseInt(s1)+" ");
	    
	    Iterator itr = ls.iterator();
	    
	    flag = "no-redirect";
	    
	    if(itr.hasNext())
	    {
	    
	    	lev = (LeaveEntitlementVO)itr.next();
	    	LocalDate levstartday = tolocaldate(lev.getLeaveEntitlement_startday());
	    	LocalDate levendday = tolocaldate(lev.getLeaveEntitlement_endday());
		    
	    	System.out.println("3: leave entitlement id "+lev.getLeaveEntitlement_id());
	    		    	
	    	if(datefrom.isAfter(levstartday) && dateto.isBefore(levendday)){
	    
	    		List ls1 = led.findByQuery("from leave_entitlement where employee="+Integer.parseInt(s)+" ");
	    	    
	    	    Iterator itr1 = ls1.iterator();
	    	    
	    	    while(itr1.hasNext())
	    	    {
	    	    	LeaveEntitlementVO levid = (LeaveEntitlementVO)itr1.next();
/*	    	    	
	    	    	System.out.println("6: leave entitlement id "+levid.getLeaveEntitlement_id());
*/	    			    List lev_ = obj1.searchbyLev(levid);
	    		    	
	    		    	Iterator itr_ = lev_.iterator();
	    			    
	    			    while(itr_.hasNext())
	    			    {
	    			    
	    			    	System.out.println("7: in while for all leave entitlements for a employee");
	    			    	AssignLeavetoEmployeeVO obju = (AssignLeavetoEmployeeVO)itr_.next();
	    			    	
	    			    	/*if(obju.getAssignLeavetoEmployeeVO_lev().getLeaveEntitlement_id() == levid.getLeaveEntitlement_id())
	    			    	{
	    			    	*/
	    			    	Date storedfrom = obju.getAssignLeavetoEmployeeVO_startday();
	    			    	Date storedto = obju.getAssignLeavetoEmployeeVO_endday();
	    			    
	    			    	//System.out.println("8: inside");
	    			    
	    			    	LocalDate storedfrom1 = tolocaldate(storedfrom);
	    			    	LocalDate storedto1 = tolocaldate(storedto);
	    				    
	    			    	/*boolean date1 = from.getDate() == convertedDate.getDate(); 
	    					boolean month1 = from.getMonth() == convertedDate.getMonth();
	    					boolean year1 = from.getYear() == convertedDate.getYear();
	    					
	    					boolean date2 = to.getDate() == convertedDate1.getDate(); 
	    					boolean month2 = to.getMonth() == convertedDate1.getMonth();
	    					boolean year2 = to.getYear() == convertedDate1.getYear();
	    					*/
	    					
	    			    	if((datefrom.isAfter(storedfrom1) && datefrom.isBefore(storedto1)) || (dateto.isAfter(storedfrom1) && dateto.isBefore(storedto1) || storedfrom1.isEqual(datefrom) || storedto1.isEqual(dateto) )){
	    				    	
	    			    		flag = "yes";
	    			    		
	    						System.out.println("9: to be redirected");
	    						HttpSession ss = request.getSession();
	    		    			ss.setAttribute("error", "No two leaves allowed at same dates");
	    		    			response.sendRedirect("Admin/AssignLeavetoEmp.jsp");
	    		    			obj1.wait(3000);
	    						}
	    			    	else{
	    			    		
	    			    		}
	    			    }
	    	    }
	    	    
	    	    if(flag.equals("no-redirect"))
	    	    {

	    	    	org.hibernate.Transaction t1;
	    	    	
	    	    	System.out.println(" insert ");
	    	    
	    	    	t1 = obj1.getTx();
	    	    	lsv.setId(1);
		    	    obj.setAssignLeavetoEmployeeVO_startday(convertedDate);
		    	    obj.setAssignLeavetoEmployeeVO_endday(convertedDate1);
		    	    obj.setAssignLeavetoEmployeeVO_status(lsv);
		    	    obj.setAssignLeavetoEmployeeVO_totaldays(i);
		    	    /*lev = (LeaveEntitlementVO)itrlast.next();	*/
					obj.setAssignLeavetoEmployeeVO_lev(lev);
					
					System.out.println("update leave entitlement days: "+(lev.getLeaveEntitlement_days() - i));
					
			    	lev.setLeaveEntitlement_days(lev.getLeaveEntitlement_days() - i);
			    	led.update(lev);
			    	obj1.makePersistent(obj);
	
			    	 t1.commit();
		    	 }
	    	    else
	    	    {
	    	    	
	    	    }
	    	}
	    	else
	    		{
	    		System.out.println("4: why me?");
	    			HttpSession ss = request.getSession();
	    			ss.setAttribute("error", "leave was out of period");
	    			response.sendRedirect("Admin/AssignLeavetoEmp.jsp");
	    		}
		}
	  /*  t.commit();

	    t = obj1.getTx();
	    
	    System.out.println("5: emp id "+Integer.parseInt(s));*/
        /*List ls1 = led.findByQuery("from leave_entitlement where employee="+Integer.parseInt(s)+" ");
	    
	    Iterator itr1 = ls1.iterator();
	    
	    while(itr1.hasNext())
	    {
	    	LeaveEntitlementVO levid = (LeaveEntitlementVO)itr1.next();
	    	
	    	System.out.println("6: leave entitlement id"+levid.getLeaveEntitlement_id());
			    List lev_ = obj1.searchbyLev(levid);
		    	
		    	Iterator itr_ = lev_.iterator();
			    
			    while(itr_.hasNext())
			    {
			    
			    	System.out.println("7: in while lev_");
			    	AssignLeavetoEmployeeVO obju = (AssignLeavetoEmployeeVO)itr_.next();
			    	
			    	if(obju.getAssignLeavetoEmployeeVO_lev().getLeaveEntitlement_id() == levid.getLeaveEntitlement_id())
			    	{
			    	
			    	Date storedfrom = obju.getAssignLeavetoEmployeeVO_startday();
			    	Date storedto = obju.getAssignLeavetoEmployeeVO_endday();
			    
			    	System.out.println("8: inside");
			    
			    	LocalDate storedfrom1 = tolocaldate(storedfrom);
			    	LocalDate storedto1 = tolocaldate(storedto);
				    
			    	boolean date1 = from.getDate() == convertedDate.getDate(); 
					boolean month1 = from.getMonth() == convertedDate.getMonth();
					boolean year1 = from.getYear() == convertedDate.getYear();
					
					boolean date2 = to.getDate() == convertedDate1.getDate(); 
					boolean month2 = to.getMonth() == convertedDate1.getMonth();
					boolean year2 = to.getYear() == convertedDate1.getYear();
					
					
			    	if(storedfrom1.isEqual(datefrom) || storedto1.isEqual(dateto)){
				    	
						System.out.println("9: to be redirected");
						HttpSession ss = request.getSession();
		    			ss.setAttribute("error", "No two leaves allowed at same dates");
		    			response.sendRedirect("Admin/AssignLeavetoEmp.jsp");
		    			
						}
		*/			/*else{
						List lslast = led.findByQuery("from leave_entitlement where employee="+Integer.parseInt(s)+" and leavetype="+Integer.parseInt(s1)+" ");
					    
					    Iterator itrlast = lslast.iterator();
					    
					    if(itrlast.hasNext())
					    {
					    
					    lev = (LeaveEntitlementVO)itrlast.next();	
						obj.setAssignLeavetoEmployeeVO_lev(lev);
				    	lev.setLeaveEntitlement_days(lev.getLeaveEntitlement_days() - i);
				    	led.update(lev);
				    	obj1.makePersistent(obj);

				    	 t.commit();

					    HttpSession ss = request.getSession();
						ss.setAttribute("error", "noerror");
						
					    response.sendRedirect("Admin/ViewLeaveEntitlement.jsp");

					    }
						}
			    	}
			    }
	    }
	    
	    
	    		}
*/		

	
	    t.commit();
	    response.sendRedirect("Admin/ViewLeaveEntitlement.jsp");
		}catch(Exception e){e.printStackTrace();}
	}


		public Date dateformat(String d)
		{
			DateFormat formatter = null;
		    Date convertedDate = null;
		    // Creating SimpleDateFormat with yyyyMMdd format e.g."20110914"
		    
		    formatter = new SimpleDateFormat("MM/dd/yyyy");
		    try {
				convertedDate = (Date) formatter.parse(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Date : " + convertedDate);
			return convertedDate;
		}
		
		
		public LocalDate tolocaldate(Date d)
		{
			LocalDate datefrom = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
			return datefrom;
		}

}
