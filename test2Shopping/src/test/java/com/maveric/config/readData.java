package com.maveric.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readData 
{
	public static String readData1(int row, int col,int sheet)
	{
		String data=null;
		try {
			  // Specify the path of file
			   File src=new File("C:\\Users\\nandhinid\\workspace\\test2Shopping\\testData\\inputs.xlsx");
			 
			   // load file
			   FileInputStream fis=new FileInputStream(src);
			 
			   // Load workbook
			   XSSFWorkbook wb=new XSSFWorkbook(fis);
			   
			   // Load sheet
			   XSSFSheet sh1= wb.getSheetAt(sheet);
			   				
			 			  
			 data =sh1.getRow(row).getCell(col).getStringCellValue();
		
			 } 
	catch (Exception e)
		      {
			 
			   System.out.println(e.getMessage());
		
			  }
		return data;
			  
			 }
	}
	
	


