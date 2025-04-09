package com.Automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

public static String readDataFromPropertyFile(String path, String key) {
		
		//need property file
		//property path
		//reader class
		//property key
		
		
	File file = new File(path);
	FileInputStream fis =null;
	Properties pro = new Properties();
	String data = null;
	
	try {
		
		fis= new FileInputStream(file);
		pro.load(fis);
		data = pro.getProperty(key);
		fis.close();
		
		
	} catch (FileNotFoundException e) {
		
		System.out.println("File not found.Please give the correct path.");
		e.printStackTrace();
	
	}catch (Exception e) {
		
		System.out.println("Error in loading the file in properties object.");
	}
		return data;
		
	}
	
public static void writeDataToPropertyFile(String path,String key,String value) {
	
	Properties propFile=new Properties();
	propFile.setProperty(key, value);
	FileOutputStream fo=null;
	File file=new File(path);
	
	try {
		
		fo=new FileOutputStream(file);
		propFile.store(fo,"adding new property with value");
		fo.close();
	
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
}


}
