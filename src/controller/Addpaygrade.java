package controller;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.*;
import javax.transaction.Transactional.TxType;

import org.osgi.service.jndi.JNDIContextManager;

import vo.*;
import DAO.*;
import LSCD.MyUtility;

/**
 * Servlet implementation class Addpaygrade
 */
@WebServlet("/Addpaygrade")
public class Addpaygrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addpaygrade() {
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
		  CurrencyHibernateDAO apgd = factory.getCurrencyDAO();
		 
		  /* Boolean as= (apgd==null) ;
		  System.out.println(as);*/
		  //AddPaygradeHibernateDAO apghd = new AddPaygradeHibernateDAO();
	     
		  CurrencyVO apgv = new CurrencyVO();
	     
	      //apgd.setSession(MyUtility.getSession());
	     /* UserTransaction tx = factory.getTransaction();
	      tx.begin();*/
	      
	      t = apgd.getTx();
	     List ls = apgd.findAll(apgv);
	      
	      //tx.commit();
	      
	      t.commit();
	        HttpSession ss = request.getSession();
			ss.setAttribute("list", ls);
			
	}catch(Exception e){
		e.printStackTrace();
		System.out.println(e.getCause());
	}  
		
}		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//@Transactional
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		try{
		 
				org.hibernate.Transaction t;
				
			  DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
			  AddPaygradeHibernateDAO apgd = factory.getAddPaygradeDAO();
			 
			  /* Boolean as= (apgd==null) ;
			  System.out.println(as);*/
			  //AddPaygradeHibernateDAO apghd = new AddPaygradeHibernateDAO();
		     
			  AddpaygradeVO apgv = new AddpaygradeVO();
		      apgv.setPaygradename(request.getParameter("addpaygname"));
		     
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
