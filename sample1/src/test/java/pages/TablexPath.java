package pages;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TablexPath {

	public static void main(String[] args) 
	{
		WebDriver driver= new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.xpath("")).sendKeys();

		basics obj=new basics();
	}

}
