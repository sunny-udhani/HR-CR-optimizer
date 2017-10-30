package hrm.pim.VO;

import java.util.Date;

public class EmployeeJobHistory {

	private Date joineddate;
	private Date probationenddate;
	private Date dateofpermanancy;
	private String jobtitle;
	private String employmentstatus;
	private String jobcategory;
	private String joblocation;
	private String jobsubunit;
	private Date effectivedate;
	private String jobworkshift;
	public Date getJoineddate() {
		return joineddate;
	}
	public void setJoineddate(Date joineddate) {
		this.joineddate = joineddate;
	}
	public Date getProbationenddate() {
		return probationenddate;
	}
	public void setProbationenddate(Date probationenddate) {
		this.probationenddate = probationenddate;
	}
	public Date getDateofpermanancy() {
		return dateofpermanancy;
	}
	public void setDateofpermanancy(Date dateofpermanancy) {
		this.dateofpermanancy = dateofpermanancy;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getEmploymentstatus() {
		return employmentstatus;
	}
	public void setEmploymentstatus(String employmentstatus) {
		this.employmentstatus = employmentstatus;
	}
	public String getJobcategory() {
		return jobcategory;
	}
	public void setJobcategory(String jobcategory) {
		this.jobcategory = jobcategory;
	}
	public String getJoblocation() {
		return joblocation;
	}
	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}
	public String getJobsubunit() {
		return jobsubunit;
	}
	public void setJobsubunit(String jobsubunit) {
		this.jobsubunit = jobsubunit;
	}
	public Date getEffectivedate() {
		return effectivedate;
	}
	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}
	public String getJobworkshift() {
		return jobworkshift;
	}
	public void setJobworkshift(String jobworkshift) {
		this.jobworkshift = jobworkshift;
	}
	
	
}
