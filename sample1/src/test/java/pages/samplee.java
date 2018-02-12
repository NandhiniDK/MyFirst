package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class samplee
{
	static WebDriver driver = new FirefoxDriver();
	public static void main(String[] args) throws InterruptedException 
	{
	   	driver.get("http://automationpractice.com/index.php?id_category=11&controller=category");
	   	
         jsClick(driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]/span")));
		
         driver.findElement(By.id("quantity_wanted")).clear();       
         driver.findElement(By.id("quantity_wanted")).sendKeys("10");
         jsClick(driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")));
         
         List<WebElement> rw=driver.findElements(By.id("product_1_1_0_51436"));
         for(int i=1;i<=rw.size();i++)
         {
        	String col=driver.findElement(By.xpath(".//tbody/tr["+i+"]/td[2]")).getText();
        	if(col.contains("Faded Short Sleeve T-shirts"))
        	{
        		driver.findElement(By.xpath(".//tbody/tr["+i+"]//td//following-sibling::a[@id='1_1_0_51436']")).click();
        	}
         }
        	 
	}
	
	public static void jsClick(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
	}
		
	
	
}

//Assert.assertEquals("Please select any option...", selectedOption);

	


