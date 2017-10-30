package hrm.pim.VO;

import java.util.Date;

public class EmployeeSalaryHistory {

	private String paygrade;
	private String currency;
	private int basicpayamount ;
	private Date basicpayamounteffdate; 
	private int pensiondeductions;
	private Date pensiondeductionseffdate;
	
	public String getPaygrade() {
		return paygrade;
	}
	public void setPaygrade(String paygrade) {
		this.paygrade = paygrade;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getBasicpayamount() {
		return basicpayamount;
	}
	public void setBasicpayamount(int basicpayamount) {
		this.basicpayamount = basicpayamount;
	}
	public Date getBasicpayamounteffdate() {
		return basicpayamounteffdate;
	}
	public void setBasicpayamounteffdate(Date basicpayamounteffdate) {
		this.basicpayamounteffdate = basicpayamounteffdate;
	}
	public int getPensiondeductions() {
		return pensiondeductions;
	}
	public void setPensiondeductions(int pensiondeductions) {
		this.pensiondeductions = pensiondeductions;
	}
	public Date getPensiondeductionseffdate() {
		return pensiondeductionseffdate;
	}
	public void setPensiondeductionseffdate(Date pensiondeductionseffdate) {
		this.pensiondeductionseffdate = pensiondeductionseffdate;
	}
}
