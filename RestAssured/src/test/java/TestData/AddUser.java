package TestData;

public class AddUser {
	
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;

	public AddUser(String accountno,String departmentno,String salary,String pincode) {
		
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
	}
	
	public String getAccountno() {
		return accountno;
		
	}
	
	public String getDepartmentno() {
		return departmentno;
		
	}
	
	public String getSalary() {
		return salary;
		
	}
	
	public String getpincode() {
		return pincode;
		
	}
}
