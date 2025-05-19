package commonUtils;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
public class utils {

	public static void schemaValidate(Response response, String schemaFilePath) {
		
		 response.then().assertThat()
		 .body(matchesJsonSchema(new File(schemaFilePath)));
	}

	public static String serilizeData(Object obj) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(obj);
			
		
	}
}
	

 