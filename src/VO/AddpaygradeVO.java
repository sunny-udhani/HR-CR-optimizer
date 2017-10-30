package vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddpaygradeVO {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int paygrade_id;
	private String paygradename;
	public int getPaygrade_id() {
		return paygrade_id;
	}
	public void setPaygrade_id(int paygrade_id) {
		this.paygrade_id = paygrade_id;
	}
	public String getPaygradename() {
		return paygradename;
	}
	public void setPaygradename(String paygradename) {
		this.paygradename = paygradename;
	}
	
	
	
}
