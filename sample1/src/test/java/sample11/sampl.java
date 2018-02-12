package sample11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sampl 
{

	public static void main(String[] args) {
		
	
	WebDriver driver= new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("http://automationpractice.com/index.php?id_category=5&controller=category");
	  driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a")).click();
	  WebElement imgTshirt= driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
	 
	  //Add to cart
	  Actions action = new Actions(driver);
	  action.moveToElement(imgTshirt).build().perform();
	  driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
	  
	  
	  //Explicit wait
	// WebDriverWait wait=new WebDriverWait(driver, 20);
	  
	 // WebElement status= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='clearfix']/div[@class='layer_cart_product col-xs-12 col-md-6']/h2")));
	  
	//  WebElement status=driver.findElement(By.id("layer_cart"));
	 // WebElement status1=status.findElement(By.xpath(".//*[@class='clearfix']/div[@class='layer_cart_product col-xs-12 col-md-6']/h2"));
	//WebElement t= driver.findElement(By.xpath(".//*[@class='clearfix']/div[@class='layer_cart_product col-xs-12 col-md-6']/h2"));
	 // System.out.println(status.getText());
	
	  driver.findElement(By.xpath("//div[@class='clearfix']//div[@class='button-container']//a")).click();
	  
	  driver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a/b")).click();
	 // WebElement cart=driver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a/span[3]"));
	 // action.moveToElement(cart).perform();
	  
	  	  

}
}