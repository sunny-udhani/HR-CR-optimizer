package hrm.pim.VO;

import java.util.Date;

public class EmployeeImmigrationDetails {

	private String Documenttype;
	private String issuedbycountry;
	private String eligiblestatus;
	private int documentnumber;
	private Date issueddate;
	private Date expirydate;
	public String getDocumenttype() {
		return Documenttype;
	}
	public void setDocumenttype(String documenttype) {
		Documenttype = documenttype;
	}
	public String getIssuedbycountry() {
		return issuedbycountry;
	}
	public void setIssuedbycountry(String issuedbycountry) {
		this.issuedbycountry = issuedbycountry;
	}
	public String getEligiblestatus() {
		return eligiblestatus;
	}
	public void setEligiblestatus(String eligiblestatus) {
		this.eligiblestatus = eligiblestatus;
	}
	public int getDocumentnumber() {
		return documentnumber;
	}
	public void setDocumentnumber(int documentnumber) {
		this.documentnumber = documentnumber;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	
	
	
}
