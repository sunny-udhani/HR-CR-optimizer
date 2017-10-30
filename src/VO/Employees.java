package vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employees {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int empname_val;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpname_val() {
		return empname_val;
	}
	public void setEmpname_val(int empname_val) {
		this.empname_val = empname_val;
	}
	
	
	
}
