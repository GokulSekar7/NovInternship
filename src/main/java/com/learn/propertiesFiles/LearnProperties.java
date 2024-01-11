package com.learn.propertiesFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LearnProperties {

	public static void main(String[] args) throws IOException {
		
		// Step :1 - Instantiate the Properites class --> from java.util
		
		
		Properties prop = new Properties();
		
		// Step 2 : Add the properties file location into the FIS 
		FileInputStream fis = new FileInputStream("./resources/Credentials2.properties");
		
		// Step 3: Load the FIS into the Properities.
		prop.load(fis);

		String uname = prop.getProperty("username");
		System.out.println("Username  : " +  uname);
		
		String pwd = prop.getProperty("password");
		System.out.println("Password " + pwd );
	}

}
