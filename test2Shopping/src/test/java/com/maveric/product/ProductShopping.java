package com.maveric.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.maveric.config.ConfigFile;
import com.maveric.config.TakeScreenshot;
import com.maveric.config.readData;
import com.maveric.config.Write;

public class ProductShopping
{
	
	WebDriver driver= new FirefoxDriver();
	WebDriverWait wait=new WebDriverWait(driver, 80);
	ConfigFile cf=new ConfigFile();
	Properties p1=cf.propFile();
		
	  
	  // Navigate "AutomationPractice" site
	  @BeforeMethod
	  public void setUp() throws IOException 
	  {
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  driver.get(p1.getProperty("url"));
		  
	  }
		  
	  @Test
	  public void login()throws InterruptedException, IOException 
	  {
		  Write.write1(1, 0, 0, "hjkhhjk@hjhj.com");
		  Write.write1(1, 1, 0, "abcd");
		  
		  String usr= readData.readData1(0, 0, 0);
		  String pwd=readData.readData1(0, 1, 0);
		  
		  WebElement loginForm=driver.findElement(By.className("login"));
		  loginForm.findElement(By.id("username")).sendKeys(usr);
		  loginForm.findElement(By.id("password")).sendKeys(pwd);
		  loginForm.findElement(By.name("login")).click();
		  TakeScreenshot.screenshot("AfterLogin",driver);
	  
		  String cart=driver.findElement(By.xpath("//li[@id='wpmenucartli']/a/span")).getText();
		  System.out.println(cart);
		  if(cart.equalsIgnoreCase("0 Items"))
		  {
			  driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		  }
		  else
		  {
			  driver.findElement(By.xpath("//li[@id='wpmenucartli']/a/span")).click();
			  int numRow=driver.findElements(By.xpath(".//*[@id='page-34']/div/div[1]/form/table/tbody/tr")).size();
			  for(int i=1;i<numRow;i++)
			  {
					 
				  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/a")))).click();
				  Thread.sleep(20000);
			  }
				  
			  String txt= driver.findElement(By.xpath("//*[@id='page-34']/div/div[2]/p[1]")).getText();
			  Assert.assertEquals(txt,"Your basket is currently empty.");
			      
			  driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
				  
		  }
			    
		  //Sorting
		  WebElement sort=driver.findElement(By.xpath(".//*[@id='content']/form/select"));
		  Select sortType=new Select(sort);
		  sortType.selectByVisibleText("Sort by price: low to high");
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='content']/form/select")));
		 // String val=sortType.getFirstSelectedOption().getText();
		 // Assert.assertEquals(val,"Sort by price: low to high");
			  
		  //Selecting Functional Programming in JS
		
		//ScrollDown
		  WebElement loc1= driver.findElement(By.xpath(".//*[@id='content']/ul/li[3]"));

		  JavascriptExecutor jse = (JavascriptExecutor)driver;
 		  jse.executeScript("arguments[0].scrollIntoView();", loc1);
		  driver.findElement(By.xpath(".//*[@id='content']/ul/li[3]/a[2]")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='content']/ul/li[3]/a[3]"))));
			  
		  //Selecting Selenium Ruby
		  WebElement loc2=driver.findElement(By.xpath(".//*[@id='content']/ul/li[7]"));
		  //ScrollDown
		  jse.executeScript("arguments[0].scrollIntoView();", loc2);	 
		  driver.findElement(By.xpath("//*[@id='content']/ul/li[8]/a[2]")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='content']/ul/li[8]/a[3]")))).click();
			  
		  driver.findElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]")).click();
		  
		  //Billing Form
		  driver.findElement(By.id("billing_first_name")).sendKeys(p1.getProperty("FName"));
		  driver.findElement(By.id("billing_last_name")).sendKeys(p1.getProperty("LName"));
		  driver.findElement(By.id("billing_phone")).sendKeys(p1.getProperty("phone"));
		  driver.findElement(By.id("billing_address_1")).sendKeys(p1.getProperty("address"));
		  driver.findElement(By.id("billing_city")).sendKeys(p1.getProperty("city"));
		  driver.findElement(By.id("s2id_autogen2_search")).sendKeys(p1.getProperty("state"));
		  driver.findElement(By.id("select2-chosen-2")).click();
		  driver.findElement(By.id("billing_postcode")).sendKeys(p1.getProperty("Post"));
		  driver.findElement(By.xpath("//*[@id='payment_method_cod']")).click();
			  
	  }
		  @AfterMethod
		  public void snap(ITestResult result)
		  {
			  if(result.getStatus()==ITestResult.FAILURE)
			  {
				  System.out.println("Failed");
				  TakeScreenshot.screenshot(result.getName(),driver);
			  }
			  driver.close();
		  }
		  
			  
}

