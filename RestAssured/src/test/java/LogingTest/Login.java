package LogingTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.internal.Utils;

import Constants.FileConstants;
import RestUtils.ApiClient;
import TestData.AddUser;
import TestData.DeleteUser;
import TestData.UpdateUser;
import commonUtils.DataUtils;
import commonUtils.utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Login {
	private String baseUrl;
	HashMap<String, String> headers = new HashMap<String, String>();
	public Login() {
		baseUrl="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
	}

	String token = null;
	ApiClient api = new ApiClient();
	
	@Test(priority = 1)
	public void LoginTest() throws IOException {
		RestAssured.baseURI=baseUrl ;
		
		//String payload = "{\"username\": \"feb2025.subhashree@tekarch.com\", \"password\": \"Admin123\"}";
		
		Object payload=  DataUtils.readTestDatafromJsonString(FileConstants.TEST_DATA_FILE_PATH, "$.payload.login");
		
		Response logResponse = api.postReq("login",payload, headers);	
		/*Response logResponse = RestAssured.given()
				.headers(headers)
				.when()
				.body(payload)
				.post("login");*/
		logResponse.getBody().prettyPrint();
	
		
		//System.out.println(FileConstants.LOGIN_RESPOSE_SCHEMA_PATH);
		
		utils.schemaValidate(logResponse, FileConstants.LOGIN_RESPOSE_SCHEMA_PATH);
				
		String actualUserId = logResponse.jsonPath().getString("[0].userid");
		assertEquals(actualUserId, "GZWyTijuutGpUpRrQ8hH");
		
		token = logResponse.jsonPath().getString("[0].token");
		System.out.println(token);
	
	}
	
	@Test(priority = 2, dependsOnMethods = "LoginTest")
	public void getUsersTest() {
		
		headers.put("token", token);
		Response getDataRes = api.getReq("getdata?id=", headers);
		utils.schemaValidate(getDataRes, FileConstants.GETDATA_RESPONSE_SCHEMA_PATH);
		assertEquals(getDataRes.getStatusCode(), 200);
	
		getDataRes.prettyPrint();
	}
	
	@Test(priority = 3, dependsOnMethods = "LoginTest")
	public void addUserTest() throws IOException {
		//AddUser user = new AddUser("gsgdfd4-CN","7","3404546","757544");
		Object user=  DataUtils.readTestDatafromJsonString(FileConstants.TEST_DATA_FILE_PATH, "$.payload.addData");
		
		//serialization - Object Mapper
		ObjectMapper om = new ObjectMapper();
		String payload = om.writeValueAsString(user); 
		System.out.println(payload);
		 
		headers.put("token", token);
		
		Response addDataRes = api.postReq("addData", payload, headers);
		
		assertEquals(addDataRes.getStatusCode(), 201);	
		
		addDataRes.prettyPrint();
		
	}
	
	@Test(priority = 4, dependsOnMethods = "LoginTest")
	public void updateUserTest() throws IOException {
		//UpdateUser user = new UpdateUser("GZWyTijuutGpUpRrQ8hH","jiEotsfJbRVRDx5J0IEl","gsgdfd4-CN","7","3404559","757544");
		
		Object user=  DataUtils.readTestDatafromJsonString(FileConstants.TEST_DATA_FILE_PATH, "$.payload.updateUser");
		//serialization - Object Mapper
		
		ObjectMapper om = new ObjectMapper();
		String payload = om.writeValueAsString(user); 
		System.out.println(payload);
		
		
		
		headers.put("token", token);
		
		Response addDataRes = api.putReq("updateData", payload.toString(), headers);
		
		assertEquals(addDataRes.getStatusCode(), 401);	
		
		addDataRes.prettyPrint();
		
	}
	

	@Test(priority = 5, dependsOnMethods = "LoginTest")
	public void deleteUserTest() throws JsonProcessingException {
		DeleteUser deleteUser = new DeleteUser("GZWyTijuutGpUpRrQ8hH","SdaNdcM8EHkdUtB5KV7M");
		
		//serialization - Object Mapper
		
		ObjectMapper om = new ObjectMapper();
		String payload = om.writeValueAsString(deleteUser); 
		System.out.println(payload);
		 
		headers.put("token", token);
		
		Response deleteResponse = api.deleteReq("deleteData", payload, headers);
		
		assertEquals(deleteResponse.getStatusCode(), 200);	
		
		deleteResponse.prettyPrint();
		
	}
}
