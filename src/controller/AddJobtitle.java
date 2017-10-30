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
import javax.transaction.Synchronization;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.spi.LocalStatus;

import DAO.AddJobtitleDAO;
import DAO.AddJobtitleHibernateDAO;
import DAO.AddPaygradeHibernateDAO;
import DAO.AttachmentDAO;
import DAO.AttachmentHibernateDAO;
import DAO.DAOFactory;
import vo.AddJobtitleVO;
import vo.AttachmentVO;

/**
 * Servlet implementation class AddJobtitle
 */
@WebServlet("/AddJobtitle")
public class AddJobtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJobtitle() {
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
		insert(request, response);
		
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		org.hibernate.Transaction t ;
		
		try{
		String s = request.getParameter("jobtitlename");
		
		AttachmentVO attachmentVO = new AttachmentVO();
		
		DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
		  AddJobtitleHibernateDAO ajtd = factory.getAddJobtitleDAO();
		  AttachmentHibernateDAO ad = factory.getAttachmentDAO();
		
		  
			
		HttpSession session =request.getSession();
		
		List myList=(List)session.getAttribute("fileList");
		
		Iterator itr =  myList.iterator();
         
        System.out.println("Reading from session");
         
		         if (itr.hasNext()) {
		     
		        	 attachmentVO.setAttachment_name("Photo");
		        	 attachmentVO.setPath((String)itr.next());
		        	 t = ad.getTx();
		        	 ad.makePersistent(attachmentVO);
		        	 t.commit();
					}
				

		
		session.removeAttribute("fileList");
		
		AddJobtitleVO jobtitlevo = new AddJobtitleVO();
		
		jobtitlevo.setJobtitlename(s);
		jobtitlevo.setAttachment(attachmentVO);
		t = ajtd.getTx();
		ajtd.makePersistent(jobtitlevo);
		t.commit();
		
	}catch(Exception ex){
		ex.printStackTrace();
	}
		response.sendRedirect("Admin/index.jsp");
  }	
}
