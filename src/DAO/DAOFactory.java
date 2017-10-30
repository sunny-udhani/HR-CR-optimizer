package DAO;


public abstract class DAOFactory {
	 /** 
     * Creates a standalone DAOFactory that returns unmanaged DAO 
     * beans for use in any environment Hibernate has been configured 
     * for. Uses HibernateUtil/SessionFactory and Hibernate context 
     * propagation (CurrentSessionContext), thread-bound or transaction-bound, 
     * and transaction scoped. 
     */  
    public static final Class HIBERNATE = HibernateDAOFactory.class;  
  
    /** 
     * Factory method for instantiation of concrete factories. 
     */  
    public static DAOFactory instance(Class factory) {  
        try {  
            return (DAOFactory)factory.newInstance();  
        } catch (Exception ex) {  
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);  
        }  
    }  
  
    // Add your DAO interfaces here
    public abstract RegdetailsHibernateDAO getRegdetailsDAO();
    public abstract RegisterHibernateDAO getRegisterDAO();
    public abstract AddLeaveTypeHibernateDAO getAddLeaveTypeDAO();
    public abstract LeaveStatusHibernateDAO getLeaveStatusDAO();
    
    public abstract ViewLeaveEntitlementHibernateDAO getViewLeaveEntitlementDAO();

    public abstract AssignLeavetoEmployeeHibernateDAO getAssignLeavetoEmployeeDAO();
    
    public abstract AddPaygradeHibernateDAO getAddPaygradeDAO();
    public abstract CurrencyHibernateDAO getCurrencyDAO();
    public abstract AddWorkshiftHibernateDAO getAddWorkshiftDAO();
    public abstract EmployeesHibernateDAO getEmployeesDAO();
    
    public abstract AddJobtitleHibernateDAO getAddJobtitleDAO();
    public abstract AttachmentHibernateDAO getAttachmentDAO();
    public abstract LeaveEntitlementHibernateDAO getLeaveEntitlementDAO();
   // public abstract UserTransaction getTransaction();
   
}
