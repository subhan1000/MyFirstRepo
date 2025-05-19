package commonUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.jayway.jsonpath.JsonPath;

public class DataUtils {

	public static String readJsonFiletoString(String filePath) throws IOException {
		
		byte[] jsonData = Files.readAllBytes(Path.of(filePath));
		return  new String(jsonData);
	}
	
	public static Object readTestDatafromJsonString(String filePath, String jsonPath) throws IOException {
		String dataFormFile = readJsonFiletoString(filePath);
		
		return JsonPath.read(dataFormFile, jsonPath);
		
	}
}
