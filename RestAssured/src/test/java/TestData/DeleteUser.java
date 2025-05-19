package TestData;

public class DeleteUser {

	private String userid;
	
	private String id;
	
	public DeleteUser(String userId, String id) {
		this.id = id;
		this.userid = userId;		
	}

	public String getUserid() {
		return userid;
	}
	
	public String getId() {
		return id;
	}

}
