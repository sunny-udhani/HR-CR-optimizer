package hrm.pim.VO;

import java.util.Date;

public class EmployeeDependants {

	private String dependantname;
	private String relationship;
	private Date birthdate;
	public String getDependantname() {
		return dependantname;
	}
	public void setDependantname(String dependantname) {
		this.dependantname = dependantname;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date d) {
		this.birthdate = d;
	}
	
}
