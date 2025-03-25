package automationexerciseQS;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenShot;

public class CUserLoginLogout 
{
	String actualResult;
	String expectedResult="Ankush Telang"; 
	String ActualErrormessage;
	String ExpectedErrormessage = "Your email or password is incorrect!";
	
	WebDriver driver;
	@BeforeClass
	public void launchBrowser()
		{
		    WebDriverManager.chromedriver().setup();

		    driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.automationexercise.com");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		}
	
	@Test 
	public void invalidLogincredentials()
	{
		WebElement Loginlink=driver.findElement(By.xpath("//*[@href='/login']"));
		Loginlink.click();

		WebElement email = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
		email.sendKeys("ankushtelang26@gmail.co");
        WebElement pass = driver.findElement(By.xpath("//*[@name='password']"));
        pass.sendKeys("Ankush@1234");
        WebElement Loginbutton = driver.findElement(By.xpath("//*[text()='Login']"));
        Loginbutton.click();
        
        ActualErrormessage = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).getText();
        Assert.assertEquals(ActualErrormessage, ExpectedErrormessage);
        System.out.println("Test passed");

	}
	@Test(priority=1)
	public void Screenshot() throws IOException
	{
		ScreenShot.captureScreenshot(driver,"invalid credentials");
        driver.navigate().back();

	}
	
	@Test (priority=2)
	public void validLogincredentials()
	{
		WebElement Loginlink=driver.findElement(By.xpath("//*[@href='/login']"));
		Loginlink.click();

		WebElement email = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
		email.sendKeys("ankushtelang26@gmail.com");
        WebElement pass = driver.findElement(By.xpath("//*[@name='password']"));
        pass.sendKeys("Ankush@1234");
        WebElement Loginbutton = driver.findElement(By.xpath("//*[text()='Login']"));
        Loginbutton.click();
        
        actualResult = driver.findElement(By.xpath("//*[text()='Ankush Telang']")).getText();
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Got success message");

	}
	
}
