package sample11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;



public class DataProvider
{
	//public HashMap<String, String> hmap;
public	HashMap<String, String> excelHashMapValues = new HashMap<String, String>();
	
	public HashMap<String,String> extractExcelData(String testCaseID) throws FilloException, IOException
	{
	
		//TestBaseClass ConfigProp = new TestBaseClass();
		//Properties ConfigObj = ConfigProp.LoadConfigProperties();
		Fillo fillo=new Fillo();
		
		//Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\DataSheet\\TestData.xlsx");
		Connection connection=fillo.getConnection("C:\\Users\\nandhinid\\workspace\\com.maveric.shopping.book\\DataSheet\\login.xlsx");
	//	String sheetname= ConfigObj.getProperty("TestDataSheet");
		//String strQuery="Select * from Sheet1 where TestCaseID='" +testCaseID +"'";
		String strQuery="Select * from Sheet where TestCaseID='TC_01'";
		Recordset recordset=connection.executeQuery(strQuery);
		
		while(recordset.next())
		{
			ArrayList<String> ColCollection = recordset.getFieldNames();
			int Iter;
			int size = ColCollection.size();
			for (Iter=0 ; Iter<= (size-1) ; Iter++)
			{
				String ColName = ColCollection.get(Iter);
				System.out.println(ColName);
				String ColValue = recordset.getField(ColName);
				System.out.println(ColValue);
				//HashMap<String, String> excelHashMapValues = new HashMap <String, String>();
				excelHashMapValues.put(ColName, ColValue);				
			}
		}
		recordset.close();
		connection.close();
		
		return excelHashMapValues;
	}
	
		public static void main(String args[]) throws Exception
		{
			
			DataProvider dp = new DataProvider();
			dp.extractExcelData("123");
		}
	
}