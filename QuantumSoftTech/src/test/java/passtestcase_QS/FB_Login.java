package passtestcase_QS;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
	@Test
	public void testFunctionality()
	{
		WebElement Email = driver.findElement(By.xpath("//*[@id='email']"));
		Email.sendKeys("ankushtelang26@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
		password.sendKeys("Ankush@123");
	        
		WebElement Login=driver.findElement(By.xpath("//*[@name='login']"));
		Login.click();
		
	}
	

	}
	

