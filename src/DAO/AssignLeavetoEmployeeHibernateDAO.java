package DAO;

import java.util.List;

import org.hibernate.Query;

import vo.AssignLeavetoEmployeeVO;
import vo.LeaveEntitlementVO;

public class AssignLeavetoEmployeeHibernateDAO extends GenericHibernateDAO<AssignLeavetoEmployeeVO, Long> implements
		AssignLeavetoEmployeeDAO {

	public List searchbyLev(LeaveEntitlementVO lev){
		
		System.out.println("leave entitlement id: "+lev.getLeaveEntitlement_id());
		System.out.println("class name "+lev.getClass().getSimpleName());
		Query q = getSession().createQuery("From "+vo.AssignLeavetoEmployeeVO.class.getSimpleName()+" where AssignLeavetoEmployeeVO_lev="+lev.getLeaveEntitlement_id()+"");
		List ls = q.list();
		
		return ls;
	}
	
	public List searchassignedleaves(AssignLeavetoEmployeeVO v)
	{
		String q = "From "+vo.AssignLeavetoEmployeeVO.class.getSimpleName()+" where AssignLeavetoEmployeeVO_lev=? and AssignLeavetoEmployeeVO_status=? and  AssignLeavetoEmployeeVO_startday>=? and  AssignLeavetoEmployeeVO_endday<?";
		List lsc = findByQuery(q, v.getAssignLeavetoEmployeeVO_lev(),v.getAssignLeavetoEmployeeVO_status(),v.getAssignLeavetoEmployeeVO_startday(),v.getAssignLeavetoEmployeeVO_endday() );
		return lsc;
	}
	
	public List searchall(AssignLeavetoEmployeeVO v)
	{
		String q = "From "+vo.AssignLeavetoEmployeeVO.class.getSimpleName()+" where AssignLeavetoEmployeeVO_lev=? and  AssignLeavetoEmployeeVO_startday>=? and  AssignLeavetoEmployeeVO_endday<?";
		List lsc = findByQuery(q, v.getAssignLeavetoEmployeeVO_lev(),v.getAssignLeavetoEmployeeVO_startday(),v.getAssignLeavetoEmployeeVO_endday() );
		return lsc;
	}
	
	public List searchlev(String s , String s2)
	{
		String sql;
		List lsc = null;
		
		if(Integer.parseInt(s2)!=0 && Integer.parseInt(s)!=0)
		{
			sql = "From leave_entitlement where employee=? and leavetype=?";
			 lsc = findByQuery(sql,Integer.parseInt(s),Integer.parseInt(s2));
		}
		else if(Integer.parseInt(s)==0 && Integer.parseInt(s2)!=0)
		{
			sql = "From leave_entitlement where leavetype=?";
			 lsc = findByQuery(sql,Integer.parseInt(s2));
			
		}
		else
		{
			sql = "From leave_entitlement where employee=?";
			 lsc = findByQuery(sql,Integer.parseInt(s));
			
		}
		
		return lsc;
	}
	
}
