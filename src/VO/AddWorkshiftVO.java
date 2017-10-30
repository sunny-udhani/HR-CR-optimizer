package vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;

@Entity
public class AddWorkshiftVO {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int workshift_id;
	
	private String workshift_name;
	
	private int workshift_from;
	
	private int workshift_to;
	
	@ElementCollection
	@JoinTable(name="work_emp",
				joinColumns=@JoinColumn(name="id")
			)
	private List<Employees> workshift_listofemployees = new ArrayList<Employees>();
	
	public int getWorkshift_id() {
		return workshift_id;
	}
	public void setWorkshift_id(int workshift_id) {
		this.workshift_id = workshift_id;
	}
	public String getWorkshift_name() {
		return workshift_name;
	}
	public void setWorkshift_name(String workshift_name) {
		this.workshift_name = workshift_name;
	}
	public int getWorkshift_from() {
		return workshift_from;
	}
	public void setWorkshift_from(int workshift_from) {
		this.workshift_from = workshift_from;
	}
	public int getWorkshift_to() {
		return workshift_to;
	}
	public void setWorkshift_to(int workshift_to) {
		this.workshift_to = workshift_to;
	}
	public List<Employees> getWorkshift_listofemployees() {
		return workshift_listofemployees;
	}
	public void setWorkshift_listofemployees(
			List<Employees> workshift_listofemployees) {
		this.workshift_listofemployees = workshift_listofemployees;
	}
	
}
