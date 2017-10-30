package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="leave_entitlement")
public class LeaveEntitlementVO {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int LeaveEntitlement_id;
	@ManyToOne
	 @JoinColumn(name="leavetype")
	private AddLeaveTypeVO LeaveEntitlement_type;
	private Date LeaveEntitlement_startday;
	private Date LeaveEntitlement_endday;
	private float LeaveEntitlement_days;
	@ManyToOne
	 @JoinColumn(name="employee")
	private vo.Regdetails LeaveEntitlement_emp;
	
	public int getLeaveEntitlement_id() {
		return LeaveEntitlement_id;
	}
	public void setLeaveEntitlement_id(int leaveEntitlement_id) {
		LeaveEntitlement_id = leaveEntitlement_id;
	}
	
	public Date getLeaveEntitlement_startday() {
		return LeaveEntitlement_startday;
	}
	
	public AddLeaveTypeVO getLeaveEntitlement_type() {
		return LeaveEntitlement_type;
	}
	public void setLeaveEntitlement_type(AddLeaveTypeVO leaveEntitlement_type) {
		LeaveEntitlement_type = leaveEntitlement_type;
	}
	public void setLeaveEntitlement_startday(Date leaveEntitlement_startday) {
		LeaveEntitlement_startday = leaveEntitlement_startday;
	}
	public vo.Regdetails getLeaveEntitlement_emp() {
		return LeaveEntitlement_emp;
	}
	public void setLeaveEntitlement_emp(vo.Regdetails leaveEntitlement_emp) {
		LeaveEntitlement_emp = leaveEntitlement_emp;
	}
	public Date getLeaveEntitlement_endday() {
		return LeaveEntitlement_endday;
	}
	public void setLeaveEntitlement_endday(Date leaveEntitlement_endday) {
		LeaveEntitlement_endday = leaveEntitlement_endday;
	}
	public float getLeaveEntitlement_days() {
		return LeaveEntitlement_days;
	}
	public void setLeaveEntitlement_days(float leaveEntitlement_days) {
		LeaveEntitlement_days = leaveEntitlement_days;
	}
	
	
}
