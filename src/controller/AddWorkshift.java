package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.AddWorkshiftVO;
import vo.AddpaygradeVO;
import vo.Employees;
import DAO.AddPaygradeHibernateDAO;
import DAO.AddWorkshiftHibernateDAO;
import DAO.DAOFactory;
import DAO.EmployeesHibernateDAO;

/**
 * Servlet implementation class AddWorkshift
 */
@WebServlet("/AddWorkshift")
public class AddWorkshift extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorkshift() {
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
		String s = request.getParameter("workshiftname");
		int s1 = Integer.parseInt(request.getParameter("workshiftfrom"));
		int s2 = Integer.parseInt(request.getParameter("workshiftto"));
		String s3[] = request.getParameterValues("workShift[assignedEmp][]");
		
		List ls = new ArrayList();
		System.out.println(s3[1]);
		
				for(int i=0;i<s3.length;i++)
				{
					ls.add(Integer.parseInt(s3[i]));
							
				}
		System.out.println(s2);
	
		 
			
		org.hibernate.Transaction t;
		
		  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		  AddWorkshiftHibernateDAO apgd = factory.getAddWorkshiftDAO();
		 
	  /* Boolean as= (apgd==null) ;
	  System.out.println(as);*/
	  //AddPaygradeHibernateDAO apghd = new AddPaygradeHibernateDAO();
     
		  AddWorkshiftVO apgv = new AddWorkshiftVO();
	      apgv.setWorkshift_name(s);
	      apgv.setWorkshift_from(s1);
	      apgv.setWorkshift_to(s2);
	      
//      Employees emp = new Employees();
      EmployeesHibernateDAO aed = factory.getEmployeesDAO();
      
      Iterator itr = ls.iterator();
      int i = 0;
      
      while(itr.hasNext())
      {
    	  Employees emp = new Employees();
    	  emp.setEmpname_val((int)itr.next());
    	  
    	  t = aed.getTx();
    	  aed.makePersistent(emp);
    	  t.commit();
    	  
    	  apgv.getWorkshift_listofemployees().add(i,emp);
    	  System.out.println(emp.getEmpname_val());
    	  i++;
      }	  
      //apgv.getWorkshift_listofemployees().add(emp);
     
      //apgd.setSession(MyUtility.getSession());
     /* UserTransaction tx = factory.getTransaction();
      tx.begin();*/
      
      t = apgd.getTx();
      apgd.makePersistent(apgv);
      
      //tx.commit();
      
      t.commit();
	      
}catch(Exception e){
	e.printStackTrace();
	System.out.println(e.getCause());
}  
 
response.sendRedirect("Admin/index.jsp");
 
}
}
	