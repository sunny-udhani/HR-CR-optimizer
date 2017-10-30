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

import vo.AssignLeavetoEmployeeVO;
import vo.LeaveEntitlementVO;
import DAO.AssignLeavetoEmployeeDAO;
import DAO.DAOFactory;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class jobhi
 */
@WebServlet("/jobhi")
public class jobhi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobhi() {
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
		System.out.println("in servlet");
		String s = request.getParameter("status");
	
		LeaveEntitlementVO vo = new LeaveEntitlementVO();
		vo.setLeaveEntitlement_id(Integer.parseInt(s));
		org.hibernate.Transaction t;
		
		  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		
		AssignLeavetoEmployeeDAO aled = factory.getAssignLeavetoEmployeeDAO();
		
		List ls = aled.findByQuery("From AssignLeavetoEmployeeVO where AssignLeavetoEmployeeVO_status_id=?",Integer.parseInt(s));
		
		HttpSession ss = request.getSession();
		Iterator itr = ls.iterator();
		int i =0;
		while(itr.hasNext())
		{
			AssignLeavetoEmployeeVO v = (AssignLeavetoEmployeeVO)itr.next();
			
			System.out.println(v.getAssignLeavetoEmployeeVO_id());
			
			
		}
		
		ss.setAttribute("xor", ls);
		response.sendRedirect("Admin/checkassign.jsp");
	
	}

}
