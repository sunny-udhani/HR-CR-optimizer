package vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AssignLeavetoEmployeeVO {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int AssignLeavetoEmployeeVO_id;
	@OneToOne
	 @JoinColumn(name="leave_entitlement")
	private vo.LeaveEntitlementVO AssignLeavetoEmployeeVO_lev;
	
	@OneToOne
	private LeaveStatusVO AssignLeavetoEmployeeVO_status;
	
	private Date AssignLeavetoEmployeeVO_startday;
	private Date AssignLeavetoEmployeeVO_endday;
	
	private int AssignLeavetoEmployeeVO_partialdays;
	
	private int AssignLeavetoEmployeeVO_totaldays;
	
	public int getAssignLeavetoEmployeeVO_totaldays() {
		return AssignLeavetoEmployeeVO_totaldays;
	}
	public void setAssignLeavetoEmployeeVO_totaldays(
			int assignLeavetoEmployeeVO_totaldays) {
		AssignLeavetoEmployeeVO_totaldays = assignLeavetoEmployeeVO_totaldays;
	}
	public LeaveStatusVO getAssignLeavetoEmployeeVO_status() {
		return AssignLeavetoEmployeeVO_status;
	}
	public void setAssignLeavetoEmployeeVO_status(
			LeaveStatusVO assignLeavetoEmployeeVO_status) {
		AssignLeavetoEmployeeVO_status = assignLeavetoEmployeeVO_status;
	}
	public vo.LeaveEntitlementVO getAssignLeavetoEmployeeVO_lev() {
		return AssignLeavetoEmployeeVO_lev;
	}
	public void setAssignLeavetoEmployeeVO_lev(
			vo.LeaveEntitlementVO assignLeavetoEmployeeVO_lev) {
		AssignLeavetoEmployeeVO_lev = assignLeavetoEmployeeVO_lev;
	}
	public int getAssignLeavetoEmployeeVO_partialdays() {
		return AssignLeavetoEmployeeVO_partialdays;
	}
	public void setAssignLeavetoEmployeeVO_partialdays(
			int assignLeavetoEmployeeVO_partialdays) {
		AssignLeavetoEmployeeVO_partialdays = assignLeavetoEmployeeVO_partialdays;
	}
	public Date getAssignLeavetoEmployeeVO_startday() {
		return AssignLeavetoEmployeeVO_startday;
	}
	public void setAssignLeavetoEmployeeVO_startday(
			Date assignLeavetoEmployeeVO_startday) {
		AssignLeavetoEmployeeVO_startday = assignLeavetoEmployeeVO_startday;
	}
	public Date getAssignLeavetoEmployeeVO_endday() {
		return AssignLeavetoEmployeeVO_endday;
	}
	public void setAssignLeavetoEmployeeVO_endday(
			Date assignLeavetoEmployeeVO_endday) {
		AssignLeavetoEmployeeVO_endday = assignLeavetoEmployeeVO_endday;
	}
	public int getAssignLeavetoEmployeeVO_id() {
		return AssignLeavetoEmployeeVO_id;
	}
	public void setAssignLeavetoEmployeeVO_id(int assignLeavetoEmployeeVO_id) {
		AssignLeavetoEmployeeVO_id = assignLeavetoEmployeeVO_id;
	}
	
	
}
