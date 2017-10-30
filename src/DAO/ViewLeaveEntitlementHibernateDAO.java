package DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import vo.LeaveEntitlementVO;

public class ViewLeaveEntitlementHibernateDAO  extends GenericHibernateDAO<LeaveEntitlementVO, Integer> implements ViewLeaveEntitlementDAO {

	public List<LeaveEntitlementVO> search(LeaveEntitlementVO v)
	{
		String hql = "";
		Session ss = getSession();
		if(v.getLeaveEntitlement_type().getId()!=0)
		{
			hql = "From leave_entitlement where employee="+v.getLeaveEntitlement_emp().getId()+" and leavetype="+v.getLeaveEntitlement_type().getId()+"";
		}
		else
		{
			hql = "From leave_entitlement where employee="+v.getLeaveEntitlement_emp().getId()+" ";
		}
		Query q = ss.createQuery(hql);
		List<LeaveEntitlementVO> ls = q.list();
		return ls;
	}
	

	public void makeTransient(LeaveEntitlementVO v)
	{
	 Session ss = getSession();
	 String hql = "delete from leave_entitlement where LeaveEntitlement_id="+v.getLeaveEntitlement_id()+" ";
	 Query q = ss.createQuery(hql);
	 q.executeUpdate();
	}
}
