package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WayToAutomation 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust");
		
     	Thread.sleep(10);
		
		WebElement add = driver.findElement(By.xpath("//*[@type='submit']"));
		add.click();
		
		
		
	
		
    }
}
