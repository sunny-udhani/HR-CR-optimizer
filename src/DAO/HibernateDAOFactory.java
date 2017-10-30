package DAO;


import org.hibernate.Session;

public class HibernateDAOFactory extends DAOFactory {

	@Override
	public AddPaygradeHibernateDAO getAddPaygradeDAO() {
		// TODO Auto-generated method stub
		return (AddPaygradeHibernateDAO)instantiateDAO(AddPaygradeHibernateDAO.class);
	}
	
	@Override
	public LeaveStatusHibernateDAO getLeaveStatusDAO() {
		// TODO Auto-generated method stub
		return (LeaveStatusHibernateDAO)instantiateDAO(LeaveStatusHibernateDAO.class);
	}
	
	
	@Override
	public AssignLeavetoEmployeeHibernateDAO getAssignLeavetoEmployeeDAO() {
		// TODO Auto-generated method stub
		return (AssignLeavetoEmployeeHibernateDAO)instantiateDAO(AssignLeavetoEmployeeHibernateDAO.class);
	}
	
	@Override
	public AddLeaveTypeHibernateDAO getAddLeaveTypeDAO() {
		// TODO Auto-generated method stub
		return (AddLeaveTypeHibernateDAO)instantiateDAO(AddLeaveTypeHibernateDAO.class);
	}
	
	@Override
	public ViewLeaveEntitlementHibernateDAO getViewLeaveEntitlementDAO() {
		// TODO Auto-generated method stub
		return (ViewLeaveEntitlementHibernateDAO)instantiateDAO(ViewLeaveEntitlementHibernateDAO.class);
	}
	
	@Override
	public RegisterHibernateDAO getRegisterDAO() {
		// TODO Auto-generated method stub
		return (RegisterHibernateDAO)instantiateDAO(RegisterHibernateDAO.class);
	}
	
	@Override
	public RegdetailsHibernateDAO getRegdetailsDAO() {
		// TODO Auto-generated method stub
		return (RegdetailsHibernateDAO)instantiateDAO(RegdetailsHibernateDAO.class);
	}
	
	@Override
	public AddJobtitleHibernateDAO getAddJobtitleDAO() {
		// TODO Auto-generated method stub
		return (AddJobtitleHibernateDAO)instantiateDAO(AddJobtitleHibernateDAO.class);
	}
	
	@Override
	public LeaveEntitlementHibernateDAO getLeaveEntitlementDAO() {
		// TODO Auto-generated method stub
		return (LeaveEntitlementHibernateDAO)instantiateDAO(LeaveEntitlementHibernateDAO.class);
	}
	
	@Override
	public AttachmentHibernateDAO getAttachmentDAO() {
		// TODO Auto-generated method stub
		return (AttachmentHibernateDAO)instantiateDAO(AttachmentHibernateDAO.class);
	}
	public EmployeesHibernateDAO getEmployeesDAO() {
		// TODO Auto-generated method stub
		return (EmployeesHibernateDAO)instantiateDAO(EmployeesHibernateDAO.class);
	}

	public CurrencyHibernateDAO getCurrencyDAO() {
		// TODO Auto-generated method stub
		return (CurrencyHibernateDAO)instantiateDAO(CurrencyHibernateDAO.class);
	}
	
	public AddWorkshiftHibernateDAO getAddWorkshiftDAO() {
		// TODO Auto-generated method stub
		return (AddWorkshiftHibernateDAO)instantiateDAO(AddWorkshiftHibernateDAO.class);
	}
	
	 private GenericHibernateDAO instantiateDAO(Class daoClass) {  
	        try {  
	            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();  
	            dao.setSession(getSession());  
	            return dao;  
	        } catch (Exception ex) {  
	            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);  
	        }  
	    }  
	 
	 protected Session getSession() {  
	        return LSCD.MyUtility.getSession();  
	    } 
	/* 
	 public UserTransaction getTransaction(){
		 UserTransaction ut=null;
		 try{
		 Context c = new InitialContext();
		 ut = (UserTransaction)
			    c.lookup("java:comp/UserTransaction");
		 }catch(Exception e)
		 {e.printStackTrace();}
			return ut;
	 } */
	 
	 /*public ItemDAO getItemDAO() {  
	        return (ItemDAO)instantiateDAO(ItemDAOHibernate.class);  
	    }*/
}
