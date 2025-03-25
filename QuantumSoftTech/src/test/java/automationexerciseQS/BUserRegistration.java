package automationexerciseQS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BUserRegistration 
{
	
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
	public void SignUp()
	{
		driver.findElement(By.xpath("//*[@href='/login']")).click();
		driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Ankush Telang");
		driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("ankushtelang26@gmail.com");
		driver.findElement(By.xpath("//*[text()='Signup']")).click();
	}
	@Test(priority=1)
     public void AccountInfo()
	{
		WebElement radiobutton = driver.findElement(By.xpath("(//*[@name='title'])[1]"));
		radiobutton.click();
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("Ankush@1234");
		
		WebElement day = driver.findElement(By.xpath("//*[@id='days']"));
		Select selday = new Select(day);
		selday.selectByVisibleText("26");
		
		WebElement month = driver.findElement(By.xpath("//*[@id='months']"));
		Select selmonth = new Select(month);
		selmonth.selectByVisibleText("August");
		
		WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
		Select selyear = new Select(year);
		selyear.selectByVisibleText("2000");
		
		WebElement firstname = driver.findElement(By.xpath("//*[@id='first_name']"));
		firstname.sendKeys("Ankush");
		
		WebElement lastname = driver.findElement(By.xpath("//*[@id='last_name']"));
		lastname.sendKeys("Telang");
		
		WebElement address = driver.findElement(By.xpath("//*[@id='address1']"));
		address.sendKeys("Chikhali Road,Buldana");
		
//		WebElement country = driver.findElement(By.xpath("//*[@id='address1']"));
//		Select selcountry = new Select(country);
//		selcountry.selectByVisibleText("India");
		
		WebElement mystate = driver.findElement(By.xpath("//*[@id='state']"));
		mystate.sendKeys("Maharashtra");
		
		WebElement mycity = driver.findElement(By.xpath("//*[@id='city']"));
		mycity.sendKeys("Buldana");
		
		WebElement myzipcode = driver.findElement(By.xpath("//*[@id='zipcode']"));
		myzipcode.sendKeys("443001");
		
		WebElement mymobile_number = driver.findElement(By.xpath("//*[@id='mobile_number']"));
		mymobile_number.sendKeys("8856854671");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement createAC = driver.findElement(By.xpath("//*[text()='Create Account']"));
		createAC.click();
		
		

	}
	@Test
	public void AdressInfo()
	{
		WebElement firstname = driver.findElement(By.xpath("//*[@id='first_name']"));
		firstname.sendKeys("Ankush");
		
		WebElement lastname = driver.findElement(By.xpath("//*[@id='last_name']"));
		lastname.sendKeys("Telang");
		
		WebElement address = driver.findElement(By.xpath("//*[@id='address1']"));
		address.sendKeys("Chikhali Road,Buldana");
		
		WebElement country = driver.findElement(By.xpath("//*[@id='address1']"));
		Select selcountry = new Select(country);
		selcountry.selectByVisibleText("India");
		
		WebElement mystate = driver.findElement(By.xpath("//*[@id='state']"));
		mystate.sendKeys("Maharashtra");
		
		WebElement mycity = driver.findElement(By.xpath("//*[@id='city']"));
		mycity.sendKeys("Buldana");
		
		WebElement myzipcode = driver.findElement(By.xpath("//*[@id='zipcode']"));
		myzipcode.sendKeys("443001");
		
		WebElement mymobile_number = driver.findElement(By.xpath("//*[@id='mobile_number']"));
		mymobile_number.sendKeys("8856854671");
		
		WebElement createAC = driver.findElement(By.xpath("//*[text()='Create Account']"));
		createAC.click();
		
	}

}
