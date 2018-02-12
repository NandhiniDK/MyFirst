package com.maveric.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write
{
	public static void write1(int row, int col, int sheet, String input) 
	{
		Workbook wb=null;
	 try
	 {
		 
          File src=new File("C:\\Users\\nandhinid\\workspace\\test2Shopping\\testData\\inputs.xlsx");
          FileInputStream fis=new FileInputStream(src);
		 
		   wb=new XSSFWorkbook(fis);
		 
		   Sheet sh1=wb.getSheetAt(sheet);
		 
		   sh1.createRow(row).createCell(col).setCellValue(input);
		 
		 
		 FileOutputStream fout=new FileOutputStream(src);
		// finally write content 
 
		 wb.write(fout);
		 
		// close the file
		 fout.flush();
		 fout.close();
		 
		  } catch (Exception e) {
		 
		   System.out.println(e.getMessage());
		 
		  }
		 
		 }
		 
		}


