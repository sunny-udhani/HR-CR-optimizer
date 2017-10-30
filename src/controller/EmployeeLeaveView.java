package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.AssignLeavetoEmployeeVO;
import vo.LeaveEntitlementVO;
import vo.LeaveStatusVO;
import vo.Regdetails;
import vo.register;
import DAO.AssignLeavetoEmployeeHibernateDAO;
import DAO.DAOFactory;
import DAO.GenericHibernateDAO;
import DAO.LeaveEntitlementHibernateDAO;
import DAO.LeaveStatusHibernateDAO;
import DAO.RegdetailsHibernateDAO;
import DAO.RegisterHibernateDAO;

/**
 * Servlet implementation class EmployeeLeaveView
 */
@WebServlet("/EmployeeLeaveView")
public class EmployeeLeaveView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int userregdid = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLeaveView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			HttpSession ss = request.getSession(false);
			
			org.hibernate.Transaction t;
			
		
			  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
			  AssignLeavetoEmployeeHibernateDAO aled = factory.getAssignLeavetoEmployeeDAO();
			 
			  LeaveStatusHibernateDAO lsd = factory.getLeaveStatusDAO();
			  
			  RegisterHibernateDAO rd = factory.getRegisterDAO();
			  
			  LeaveEntitlementHibernateDAO lehd = factory.getLeaveEntitlementDAO();
			  
		     
			  AssignLeavetoEmployeeVO alev = new AssignLeavetoEmployeeVO();
			  LeaveStatusVO lsv = new LeaveStatusVO();
			  LeaveEntitlementVO lev = new LeaveEntitlementVO();
		
			  String usernameregistered = (String)ss.getAttribute("username");

			 //****************  Updating taken and pending requests  ***********************
			  
				List ls = rd.findByQuery("From "+register.class.getSimpleName()+" where username=?", usernameregistered);
				
				Iterator itr = ls.iterator();
				
				if(itr.hasNext())
				{
					
					register regvo = (register)itr.next();
					int id = regvo.getId();
					
					Regdetails regdetailsvo = new Regdetails();
					RegdetailsHibernateDAO regdhd = factory.getRegdetailsDAO();
					List lsc = regdhd.findByQuery("From "+Regdetails.class.getSimpleName()+" where reg_id=?", id);
					
					regdetailsvo = (Regdetails)lsc.iterator().next();
					
					ss.setAttribute("user", regdetailsvo.getId());
					userregdid = regdetailsvo.getId();
						List ls1 = lehd.findByQuery("From leave_entitlement where employee=?", regdetailsvo.getId());
				        Iterator itr1 = ls1.iterator();
					      
				        while(itr1.hasNext())
					      {
				        	lev = (LeaveEntitlementVO)itr1.next();
				        	System.out.println("leave entitlement id -----  "+lev.getLeaveEntitlement_id());
					    	  List ls2 = aled.findByQuery("from "+alev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=?",lev);
					    	  Iterator itr2 = ls2.iterator();
							      while(itr2.hasNext())
							      {
							    	  alev = (AssignLeavetoEmployeeVO)itr2.next();
							    	  if(alev.getAssignLeavetoEmployeeVO_status().getId()==1)
							    	  {
							    		  
							    		  LocalDate start = tolocaldate(alev.getAssignLeavetoEmployeeVO_startday());
							    		  LocalDate end = tolocaldate(alev.getAssignLeavetoEmployeeVO_endday());
							    		  LocalDate now = LocalDate.now();
							    		  System.out.println(now);
							    		  if(now.isAfter(start) && now.isAfter(end))
							    		  {
							    			  lsv.setId(2);
							    			  alev.setAssignLeavetoEmployeeVO_status(lsv);
							    			  aled.update(alev);
							    		  }
							    		 
							    	  }
							    		  if(alev.getAssignLeavetoEmployeeVO_status().getId()==3)
								    	  {
								    		  
								    		  LocalDate start = tolocaldate(alev.getAssignLeavetoEmployeeVO_startday());
								    		  LocalDate end = tolocaldate(alev.getAssignLeavetoEmployeeVO_endday());
								    		  LocalDate now = LocalDate.now();
								    		  System.out.println(now);
								    		  if(now.isAfter(start) && now.isAfter(end))
								    		  {
								    			  lsv.setId(5);
								    			  alev.setAssignLeavetoEmployeeVO_status(lsv);
								    			  aled.update(alev);
								    		  }
								    	  }
							    		  
							      }
					      	}
					}
		      
			//***********************  Retrieving updated leaves and storing in session for display  *****************
				
			  List leavelist = new ArrayList();
		      t = aled.getTx();
		      
		      List ls1 = lehd.findByQuery("From leave_entitlement where employee=?", userregdid);
			  Iterator itr1 = ls1.iterator();
					      
				        while(itr1.hasNext())
					      {
				        	  lev = (LeaveEntitlementVO)itr1.next();
				        	  System.out.println("storing list by leave entitlement id ===== "+lev.getLeaveEntitlement_id());
					    	  List ls2 = aled.findByQuery("from "+alev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=?",lev);
					    	  leavelist.addAll(ls2);
					      }	  
				
		      t.commit();
		      
		      t = lsd.getTx();
		      List statuslist = lsd.findAll(lsv);
		      t.commit();
		      
		     
				ss.setAttribute("xlist", leavelist);
				ss.setAttribute("statuslist", statuslist);
				
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
		String str = request.getParameter("flag");
			
			if(str.equals("action")){
				
				System.out.println("inside action");
				HttpSession ss = request.getSession(false);
				userregdid = (Integer)(ss.getAttribute("user"));
				
				 LeaveEntitlementVO lev = new LeaveEntitlementVO();
				 org.hibernate.Transaction t;
				
				 DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
				 AssignLeavetoEmployeeHibernateDAO aled = factory.getAssignLeavetoEmployeeDAO();
				 LeaveEntitlementHibernateDAO led = factory.getLeaveEntitlementDAO();
				  
				  AssignLeavetoEmployeeVO alev = new AssignLeavetoEmployeeVO();
				  LeaveStatusVO lsv = new LeaveStatusVO();
				 
				
				List paramls = new ArrayList();
				Enumeration<String> var = request.getParameterNames();
				while (var.hasMoreElements()) {
					 paramls.add(var.nextElement());
					
				}
				
				List actionls = new ArrayList();
				Iterator paramitr = paramls.iterator();
				while(paramitr.hasNext())
				{
					String actionstr = (String)paramitr.next();
					actionls.add(request.getParameter(actionstr));
					System.out.println("valuess --- "+request.getParameter(actionstr));
				}
				
				
			    Iterator paramitr1 = paramls.iterator();
			    Iterator actionitr = actionls.iterator();
				while(paramitr1.hasNext() && actionitr.hasNext())
				{
					String idfromparam = (String)paramitr1.next();
					String sp = request.getParameter(idfromparam);
					System.out.println("action =---="+sp);
					if(sp.equals("10"))
					{
						 System.out.println("inside update of action");
						  List ls = aled.findByQuery("from "+alev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_id=?", Integer.parseInt(idfromparam));
						  Iterator itr = ls.iterator();
						  
						  alev = (AssignLeavetoEmployeeVO)itr.next();
						  lsv.setId(5);
						  alev.setAssignLeavetoEmployeeVO_status(lsv);
						  aled.update(alev);
						  List levls = aled.findByQuery("from leave_entitlement where LeaveEntitlement_id=?", alev.getAssignLeavetoEmployeeVO_lev().getLeaveEntitlement_id());
						  Iterator levitr = levls.iterator();
						  lev = (LeaveEntitlementVO)levitr.next();
						  float days = lev.getLeaveEntitlement_days();
						  lev.setLeaveEntitlement_days(days+alev.getAssignLeavetoEmployeeVO_totaldays());
						  led.update(lev);
					}
					
					
				}
				 
				  List leavelist = new ArrayList();
			      t = aled.getTx();
			      
			      List ls1 = aled.findByQuery("From leave_entitlement where employee=?", userregdid);
				  Iterator itr1 = ls1.iterator();
						      
					        while(itr1.hasNext())
						      {
					        	LeaveEntitlementVO lev1 = (LeaveEntitlementVO)itr1.next();
					        	  System.out.println("storing list by leave entitlement id ===== "+lev1.getLeaveEntitlement_id());
						    	  List ls2 = aled.findByQuery("from "+alev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=?",lev1);
						    	  leavelist.addAll(ls2);
						      }	  
					
			      t.commit();
			      ss.setAttribute("xrlist", leavelist);

			      response.sendRedirect("Admin/EmployeeLeaveView.jsp");
				
			}
	
			else{
		
		
				try{
					HttpSession ss = request.getSession(false); 
					org.hibernate.Transaction t;
					Date convertedDate = null;
			        Date convertedDate1 = null;
			        
					DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
					AssignLeavetoEmployeeHibernateDAO aled = factory.getAssignLeavetoEmployeeDAO();
				
					
					
					String s = request.getParameter("EmployeeLeaveViewperiod");
					String[] s2 = request.getParameterValues("EmployeeLeaveViewstatus");
					
					String[] period={} ;
					
					System.out.println("leave period==="+s);
					if(!s.equals(""))
						{
						period = s.split("-");
						
							if(period[0]!=null)
							{
						        // Creating SimpleDateFormat with yyyyMMdd format e.g."20110914"
						        convertedDate = dateformat(period[0]);
						        convertedDate1 = dateformat(period[1]);
						        
						        LocalDate datefrom = tolocaldate(convertedDate);
							    LocalDate dateto = tolocaldate(convertedDate1);
							    
							    System.out.println("1: --- from: "+datefrom+" to: "+dateto+" ---");
							}
						}
					
					System.out.println(s2);
					if(s2!=null)
					{
						for(int i = 0 ;i<s2.length;i++)
						{
							
							System.out.println("Selected leave status's: "+Integer.parseInt(s2[i]));
						}
					}
					 AssignLeavetoEmployeeVO altev = new AssignLeavetoEmployeeVO();
					 
					 String strquery = "from "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=?";
						
					 List leavelist = new ArrayList();
					 List total = new ArrayList();
					 
					 if(s2==null && convertedDate == null && convertedDate1 == null)
						{
							System.out.println("Condition 1: all status");
							List ls1 = aled.findByQuery("From leave_entitlement where employee=?", ss.getAttribute("user"));
							Iterator itr1 = ls1.iterator();
		
							 while (itr1.hasNext()) {
								 leavelist = aled.findByQuery(strquery, (LeaveEntitlementVO)itr1.next());
								 total.addAll(leavelist);
							 }
							 
									
						}
						
					 if( s2!=null && convertedDate == null && convertedDate1 == null)
						{
							if(Integer.parseInt(s2[0]) == 0)
							{
								List ls1 = aled.findByQuery("From leave_entitlement where employee=?", ss.getAttribute("user"));
							
								Iterator itr1 = ls1.iterator();
		
								 while (itr1.hasNext()) {
									 leavelist = aled.findByQuery(strquery, (LeaveEntitlementVO)itr1.next());
									 total.addAll(leavelist);
								 }
							}
						}
					
					 if(convertedDate == null && convertedDate1 == null && s2!=null)
					    {
					    	if(Integer.parseInt(s2[0]) != 0)
					    	{
					    	System.out.println("Condition 3: Only selected leave status");
					    	 for(int i = 0; i<s2.length;i++)
						    	{
								   System.out.println(i);
								   System.out.println(Integer.parseInt(s2[i]));
								   List ls1 = aled.findByQuery("From leave_entitlement where employee=?", ss.getAttribute("user"));
									
									Iterator itr1 = ls1.iterator();
		
									 while (itr1.hasNext()) {
									    leavelist = aled.findByQuery(strquery+" and AssignLeavetoEmployeeVO_status_id=?",(LeaveEntitlementVO)itr1.next(), Integer.parseInt(s2[i]));
									    total.addAll(leavelist);
									 }
							    }
					    	}
					    }
					 
					 if(convertedDate != null && convertedDate1 != null && s2 == null)
					    {
					    	System.out.println("condition 5: leave entitlement and dates");
					    	int i = 0;
					    	List ls1 = aled.findByQuery("From leave_entitlement where employee=?", ss.getAttribute("user"));
							
							Iterator itr1 = ls1.iterator();
		
							 while (itr1.hasNext()) {
					    			LeaveEntitlementVO v = (LeaveEntitlementVO)itr1.next();
					    			System.out.println(v.getLeaveEntitlement_id());
					    			leavelist = aled.findByQuery(strquery+" and AssignLeavetoEmployeeVO_startday>=? and AssignLeavetoEmployeeVO_endday<?", v,convertedDate,convertedDate1 );
						    		total.addAll(leavelist);
							 	}
					    }
					 
					 if(convertedDate != null && convertedDate1 != null  && s2!=null )
					    {
					    	System.out.println("Condition 7: dates and status");
					    	if(Integer.parseInt(s2[0])!=0)
					    	{
					    		for(int i = 0;i<s2.length;i++)
					    		{
					    			 List ls1 = aled.findByQuery("From leave_entitlement where employee=?", ss.getAttribute("user"));
										
										Iterator itr1 = ls1.iterator();
		
										 while (itr1.hasNext()) {
											 LeaveEntitlementVO v = (LeaveEntitlementVO)itr1.next();
								    		 System.out.println(v.getLeaveEntitlement_id());
							    			
								    		
								    		 leavelist = aled.findByQuery(strquery+" and AssignLeavetoEmployeeVO_startday>=? and AssignLeavetoEmployeeVO_endday<? and  AssignLeavetoEmployeeVO_status_id=? ",v, convertedDate,convertedDate1,Integer.parseInt(s2[i]));
							    			
								    		 total.addAll(leavelist);
										 }
					    		}
					    	}
					    	else if(Integer.parseInt(s2[0])==0)
					    	{
					    		 List ls1 = aled.findByQuery("From leave_entitlement where employee=?", ss.getAttribute("user"));
									
									Iterator itr1 = ls1.iterator();
		
									 while (itr1.hasNext()) {
										 LeaveEntitlementVO v = (LeaveEntitlementVO)itr1.next();
							    		 System.out.println(v.getLeaveEntitlement_id());
						    			
							    		
							    		 leavelist = aled.findByQuery(strquery+" and AssignLeavetoEmployeeVO_startday>=? and AssignLeavetoEmployeeVO_endday<? ",v, convertedDate,convertedDate1);
						    			
							    		 total.addAll(leavelist);
							    		 }
					    	}
					    }
					 
					 ss.setAttribute("xrlist", total);
					 response.sendRedirect("Admin/EmployeeLeaveView.jsp");
				
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
		} 
    }

	
		// ****************  Date formatting and Conversion  *********************
	
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
