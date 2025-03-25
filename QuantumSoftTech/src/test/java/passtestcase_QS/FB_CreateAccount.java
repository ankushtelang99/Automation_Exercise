package passtestcase_QS;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenShot;

public class FB_CreateAccount 
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
		WebElement CreateAccount = driver.findElement(By.xpath("//*[@href='/r.php?entry_point=login']"));
		CreateAccount.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement firstname = driver.findElement(By.xpath("//*[@name='firstname']"));
		firstname.sendKeys("Ankush");
		WebElement lastname = driver.findElement(By.xpath("//*[@name='lastname']"));
		lastname.sendKeys("Telang");
		
		WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
		Select selday = new Select(day);
		selday.selectByVisibleText("26");
		
		WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
		Select selmonth = new Select(month);
		selmonth.selectByValue("8");
		
		WebElement year = driver.findElement(By.xpath("//*[@title='Year']"));
		Select selyear = new Select(year);
		selyear.selectByIndex(25);
		
		WebElement Gender = driver.findElement(By.xpath("//*[@type='radio' and @value=2]"));
		Gender.click();
		
		WebElement mobilenumber = driver.findElement(By.xpath("//*[@name='reg_email__']"));
		mobilenumber.sendKeys("8856854671");
	
		WebElement newpassword = driver.findElement(By.xpath("//*[@type='password']"));
		newpassword.sendKeys("Ankush@1234");
		
		WebElement signUp = driver.findElement(By.xpath("//*[@name='websubmit']"));
		signUp.click();


    }
	
	
}
