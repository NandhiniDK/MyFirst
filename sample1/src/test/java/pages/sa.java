package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import sample11.Takescreenshot;

public class sa
{
static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) throws InterruptedException 
	{
		
	 ArrayList<String> al = new ArrayList<String>();
	
	driver.get("http://practice.automationtesting.in/shop/");
	List<WebElement> li= driver.findElements(By.xpath("//div[@id='content']//a[@class='woocommerce-LoopProduct-link']/span[@class='onsale' ]/following-sibling::img"));

	for(int i=0;i<li.size();i++)
	{
		WebElement list=driver.findElements(By.xpath("//div[@id='content']//a[@class='woocommerce-LoopProduct-link']/span[@class='onsale' ]/following-sibling::img")).get(i);
	    al.add(list.getAttribute("alt"));
	    
	}
	for(int i=0;i<al.size();i++)
	{
		String s=al.get(i);
		System.out.println(s);
		jsClick(driver.findElement(By.xpath("//*[text()='"+s+"']")));
		driver.findElement(By.xpath(".//*[@id='menu-item-40']/a")).click();
		Thread.sleep(2000);
	}
	}
	
	public static void jsClick(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
	}
	    
	    
}
    
	



	