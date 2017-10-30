package DAO;

import org.hibernate.Query;
import org.hibernate.Session;

import vo.LeaveEntitlementVO;

public class LeaveEntitlementHibernateDAO extends GenericHibernateDAO<LeaveEntitlementVO, Long> implements LeaveEntitlementDAO {

	public void makeTransient(LeaveEntitlementVO v)
	{
	 Session ss = getSession();
	 String hql = "delete from leave_entitlement where LeaveEntitlement_id="+v.getLeaveEntitlement_id()+" ";
	 Query q = ss.createQuery(hql);
	 q.executeUpdate();
	}
}
