package RestUtils;

import java.util.HashMap;

import Constants.FileConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {
	
	public Response postReq(String endpoint, Object payload, HashMap<String, String> header) {
		header.put("Content-Type", FileConstants.CONTENT_TYPE);
		Response res = RestAssured.given()
				.headers(header)
				.when()
				.body(payload)
				.post(endpoint);
		return res;
		
	}
	
	public Response getReq(String endpoint,HashMap<String, String> header) {
		header.put("Content-Type", FileConstants.CONTENT_TYPE);
		Response res = RestAssured.given()
				.headers(header)	
				.when()
				.get(endpoint);
		return res;
	}
	
	public Response deleteReq(String endpoint, String payload, HashMap<String, String> header) {
		Response res = RestAssured.given()
				.headers(header)
				.when()
				.body(payload)
				.delete(endpoint);
		return res;
	}

	public Response putReq(String endpoint, String payload, HashMap<String, String> header) {
		Response res = RestAssured.given()
				.headers(header)
				.when()
				.body(payload)
				.put(endpoint);
		return res;
}

	public void patchReq() {
	
}

}
