package TestData;

public class UpdateUser extends AddUser {
	public UpdateUser(String userId, String id,String accountno, String departmentno, String salary, String pincode) {
		super(accountno, departmentno, salary, pincode);
		this.userId = userId;
		this.id = id;
	}
	private String userId;
	private String id;
	
	public String getUserId() {
		return userId;
	}
	public String getId() {
		return id;
	}
}
