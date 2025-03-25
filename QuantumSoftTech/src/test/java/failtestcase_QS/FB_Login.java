package failtestcase_QS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenShot;

public class FB_Login 
{
	WebDriver driver;

	@BeforeClass
    public void BrowserLaunch() 
    {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");


    }
	@Test
	public void testFunctionality()
	{
		WebElement Email = driver.findElement(By.xpath("//*[@id='email']"));
		Email.sendKeys("ankushtelang26@gmail");
		
		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
		password.sendKeys("Ankush@123");
	        
		WebElement Login = driver.findElement(By.xpath("//*[@name='login']"));
		Login.click();
		


		
	}
    @AfterMethod
	@Test(priority=1)
	public void screenshot() throws IOException
	{
		ScreenShot.captureScreenshot(driver,"Login Failed ");
	}
	
}

