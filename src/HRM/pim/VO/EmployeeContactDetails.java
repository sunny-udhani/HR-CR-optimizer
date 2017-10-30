package hrm.pim.VO;

public class EmployeeContactDetails {
	
	private String Address;
	private String city;
	private String state;
	private int pincode ;
	private String country;
	private String workemail;
	private String otheremail;
	private int mobilenumber;
	private int phonenumber;
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWorkemail() {
		return workemail;
	}
	public void setWorkemail(String workemail) {
		this.workemail = workemail;
	}
	public String getOtheremail() {
		return otheremail;
	}
	public void setOtheremail(String otheremail) {
		this.otheremail = otheremail;
	}
	public int getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	

}
