package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.AddLeaveTypeVO;
import vo.AssignLeavetoEmployeeVO;
import vo.LeaveEntitlementVO;
import vo.LeaveStatusVO;
import vo.Regdetails;
import DAO.AddLeaveTypeHibernateDAO;
import DAO.AssignLeavetoEmployeeHibernateDAO;
import DAO.DAOFactory;
import DAO.LeaveEntitlementHibernateDAO;
import DAO.LeaveStatusHibernateDAO;
import DAO.RegdetailsHibernateDAO;

/**
 * Servlet implementation class ViewLeaveList
 */
@WebServlet("/ViewLeaveList")
public class ViewLeaveList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLeaveList() {
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
		  AssignLeavetoEmployeeHibernateDAO aled = factory.getAssignLeavetoEmployeeDAO();
		 
		  LeaveStatusHibernateDAO lsd = factory.getLeaveStatusDAO();
		  /* Boolean as= (apgd==null) ;
		  System.out.println(as);*/
		  //AddPaygradeHibernateDAO apghd = new AddPaygradeHibernateDAO();
	     
		  AssignLeavetoEmployeeVO alev = new AssignLeavetoEmployeeVO();
		  LeaveStatusVO lsv = new LeaveStatusVO();
		  
	     /* DAO.Regdetails regd = new DAO.Regdetails();*/
	      /*vo.Regdetails regv = new vo.Regdetails();
		  
		  RegdetailsHibernateDAO rdd = factory.getRegdetailsDAO();
	      *///apgd.setSession(MyUtility.getSession());
	     /* UserTransaction tx = factory.getTransaction();
	      tx.begin();*/
	      
	      /*t = led.getTx();
	      List ls = rdd.findAll(regv);
	      t.commit();
	      */  
	      /*AddLeaveTypeHibernateDAO altd = factory.getAddLeaveTypeDAO();
	      AddLeaveTypeVO altv = new AddLeaveTypeVO();
	      */
		  System.out.println("In view leave entitlement servlet's  doget() method");
	      t = aled.getTx();
	      List lsc = aled.findAll(alev);
	      t.commit();
	      
	      Iterator itr = lsc.iterator();
	      while(itr.hasNext())
	      {
	    	  alev = (AssignLeavetoEmployeeVO)itr.next();
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
	      
	      t = aled.getTx();
	      lsc = aled.findAll(alev);
	      t.commit();
	      
	      t = lsd.getTx();
	      List ls = lsd.findAll(lsv);
	      t.commit();
	      
	        HttpSession ss = request.getSession();
			ss.setAttribute("xlist", lsc);
			ss.setAttribute("statuslist", ls);
			
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
			 
			org.hibernate.Transaction t;
			Date convertedDate = null;
	        Date convertedDate1 = null;
	        
			DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
			AssignLeavetoEmployeeHibernateDAO aled = factory.getAssignLeavetoEmployeeDAO();
		 
			
			String s = request.getParameter("viewleavelistperiod");
			String[] s2 = request.getParameterValues("viewleaveliststatus");
			String s3 = request.getParameter("viewleavelistemp");
			String s4 = request.getParameter("viewleavelisttype");
			
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
			 
		    List ls = new ArrayList();
		    List lsc = new ArrayList() ;
		    HttpSession ss = request.getSession();
		   
		   
		    //Condition: only status selected and that also all!
		    if(Integer.parseInt(s3) == 0 && Integer.parseInt(s4) == 0 && s2==null && convertedDate == null && convertedDate1 == null)
		    {
		    	System.out.println("Condition 1: all status");
		     lsc = aled.findAll(altev);
		    }
		    
		    if(Integer.parseInt(s3) == 0 && Integer.parseInt(s4) == 0 && s2!=null && convertedDate == null && convertedDate1 == null)
		    {
		    	if(Integer.parseInt(s2[0]) == 0)
		    	{
			    	System.out.println("Condition 1: all status");
			    	lsc = aled.findAll(altev);
		    	}
		    }
		    
		    
		    //Condition: only date range selected
		    if(Integer.parseInt(s3)==0 && (convertedDate != null && convertedDate1 != null) && s2 == null)
		    {
		    		System.out.println("Condition 2: only leave period");
		    	lsc = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where  AssignLeavetoEmployeeVO_startday>=? and AssignLeavetoEmployeeVO_endday<? ",convertedDate,convertedDate1 );
				
		    }
		    
		    if(Integer.parseInt(s3)==0 && convertedDate == null && convertedDate1 == null && s2!=null)
		    {
		    	if(Integer.parseInt(s2[0]) != 0)
		    	{
		    	System.out.println("Condition 3: Only selected leave status");
		    	 for(int i = 0; i<s2.length;i++)
			    	{
					   System.out.println(i);
					   System.out.println(Integer.parseInt(s2[i]));
					    ls = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_status_id=?", Integer.parseInt(s2[i]));
					    lsc.addAll(ls);
				    }
		    	}
		    }
		    
		    if(convertedDate == null && convertedDate1 == null && s2 == null && (Integer.parseInt(s3)!=0 || Integer.parseInt(s4)!=0))
		    {
		    	System.out.println("Condition 4: only leave type or empname");
		    	int i = 0;
		    	List levlist = aled.searchlev(s3, s4);
		    	Iterator itr = levlist.iterator();
		    	
		    	while(itr.hasNext())
		    	{
		    		
		    		LeaveEntitlementVO v = (LeaveEntitlementVO)itr.next();
		    		if(v.getLeaveEntitlement_id()!=0){
		    			System.out.println(v.getLeaveEntitlement_id());
		    		ls = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=?", v);
		    		lsc.addAll(ls);
		    		i++;
		    		}
		    	}
		    }
		    
		    if((Integer.parseInt(s3)!=0 || Integer.parseInt(s4)!=0) && convertedDate != null && convertedDate1 != null && s2 == null)
		    {
		    	System.out.println("condition 5: leave entitlement and dates");
		    	int i = 0;
		    	List levlist = aled.searchlev(s3, s4);
		    	Iterator itr = levlist.iterator();
		    	List statuslev[] = {};
		    	while(itr.hasNext())
		    	{
		    			LeaveEntitlementVO v = (LeaveEntitlementVO)itr.next();
		    			System.out.println(v.getLeaveEntitlement_id());
		    			ls = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=? and AssignLeavetoEmployeeVO_startday>=? and  AssignLeavetoEmployeeVO_endday<?", v,convertedDate,convertedDate1 );
			    		lsc.addAll(ls);
			   
			    		i++;
		    	}
		    }
		    
		    
		    if((Integer.parseInt(s3)!=0 || Integer.parseInt(s4)!=0) && convertedDate == null && convertedDate1 == null && s2!=null)
		    {
		    	System.out.println("Condition 6: leave entitlement and status");
		    	int i = 0;
		    	List levlist = aled.searchlev(s3, s4);
		    	Iterator itr = levlist.iterator();
		    	List statuslev[] = {};
		    	while(itr.hasNext())
		    	{
		    		LeaveEntitlementVO v = (LeaveEntitlementVO)itr.next();
		    
		    		if(Integer.parseInt(s2[0])!=0)
		    		{
		    			for(int j=0; j<s2.length;j++)
		    			{
		    				statuslev[j]= aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=? and AssignLeavetoEmployeeVO_status_id=? ",v,Integer.parseInt(s2[i]));
		    				ls.addAll(statuslev[j]);
		    			}
		    			lsc.addAll(ls);
		    		}
		    		else if(Integer.parseInt(s2[0])==0)
		    		{
		    			lsc = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=? ",v);
		    			
		    		}
		    	i++;
		    	}
		    }
		    
		    
		    if((Integer.parseInt(s3)==0 && Integer.parseInt(s4)==0) && convertedDate != null && convertedDate1 != null  && s2!=null )
		    {
		    	System.out.println("Condition 7: dates and status");
		    	if(Integer.parseInt(s2[0])!=0)
		    	{
		    		for(int i = 0;i<s2.length;i++)
		    		{
		    			ls = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_startday>=? and  AssignLeavetoEmployeeVO_endday<? and  AssignLeavetoEmployeeVO_status_id=? ", convertedDate,convertedDate1,Integer.parseInt(s2[i]));
		    			lsc.addAll(ls);
		    		}
		    	}
		    	else if(Integer.parseInt(s2[0])==0)
		    	{
		    		lsc = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where  AssignLeavetoEmployeeVO_startday>=? and AssignLeavetoEmployeeVO_endday<? ",convertedDate,convertedDate1 );
		    	}
		    }
		    
		    if((Integer.parseInt(s3)!=0 || Integer.parseInt(s4)!=0) && convertedDate != null && convertedDate1 != null  && s2!=null)
		    {
		    	System.out.println("condition 8: All selected");
		    	int i=0;
		    	List levlist = aled.searchlev(s3, s4);
		    	Iterator itr = levlist.iterator();
		    	List statuslev[] = {};
		    	while(itr.hasNext())
		    	{
		    		LeaveEntitlementVO v = (LeaveEntitlementVO)itr.next();
		    		
		    		if(Integer.parseInt(s2[0])!=0)
		    		{
		    			for(int j=0; j<s2.length;j++)
		    			{
		    				statuslev[j]= aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=? and AssignLeavetoEmployeeVO_startday>=? and  AssignLeavetoEmployeeVO_endday<? and AssignLeavetoEmployeeVO_status_id=? ",v,convertedDate,convertedDate1,Integer.parseInt(s2[i]));
		    				ls.addAll(statuslev[j]);
		    			}
		    			lsc.addAll(ls);
		    		}
		    		else if(Integer.parseInt(s2[0])==0)
		    		{
		    			lsc = aled.findByQuery("From "+altev.getClass().getSimpleName()+" where AssignLeavetoEmployeeVO_lev=? and AssignLeavetoEmployeeVO_startday>=? and  AssignLeavetoEmployeeVO_endday<? ",v,convertedDate,convertedDate1);
		    			
		    		}
		    	i++;
		    	
		    	}
		    	
		    }
		    
		    
		    
		    /*if(Integer.parseInt(s2[0]) == 0)
		    {
		    	lsc = aled.searchall(altev);
		    	
		    	ss.setAttribute("xlist", lsc);
		    }
		    
		    else
		    {
	    
			    for(int i = 0; i<s2.length;i++)
			    	{
					   
					    LeaveStatusVO lsv = new LeaveStatusVO();
					    lsv.setId(Integer.parseInt(s2[i]));
					    altev.setAssignLeavetoEmployeeVO_status(lsv);
					    
					    ls[i] = aled.searchassignedleaves(altev);
					    lsc.addAll(ls[i]);
				    }
			    
			  
			    ss.setAttribute("xlist", lsc);
			    
		    }*/
		    
		    ss.setAttribute("xrlist", lsc);
		    response.sendRedirect("Admin/ViewLeaveList.jsp");
		}
			
		catch(Exception e)
			{
			e.printStackTrace();	
			}
	    
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
