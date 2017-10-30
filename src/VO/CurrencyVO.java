package vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="currency")
public class CurrencyVO {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int currencyid;
	private String currencyname;
	public int getId() {
		return currencyid;
	}
	public void setId(int id) {
		this.currencyid = id;
	}
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	
	
}
