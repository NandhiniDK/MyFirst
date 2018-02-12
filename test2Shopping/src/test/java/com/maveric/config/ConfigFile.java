package com.maveric.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {

	 public Properties propFile()
	 {
		File file;
		FileInputStream  fileInput=null;
		
		try 
		{
			file = new File("C:\\Users\\nandhinid\\workspace\\test2Shopping\\src\\test\\java\\com\\maveric\\config\\utilities.property");
			fileInput = new FileInputStream(file);
		}	
		catch(FileNotFoundException e) 
		{
		 
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try
		{
			prop.load(fileInput);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return prop;
	}
		 
}
		

	
