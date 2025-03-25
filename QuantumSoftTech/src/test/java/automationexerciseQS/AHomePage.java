package automationexerciseQS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AHomePage 
{
	   
	WebDriver driver;
@BeforeClass
public void launchBrowser()
	{
	    WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com");
	}
	@Test
	public void validatePageTitle()
	{
		String ActualPageTitle = driver.getTitle();
		//System.out.println(ActualPageTitle);
		
		String ExpectedPageTitle = "Automation Exercise";
		
		if(ActualPageTitle.equals(ExpectedPageTitle))
		{
			System.out.println("PASS:the Automation Excercise Page opened Successfully");
		}
		else
		{
			System.out.println("FAIL:the Automation Excercise Page not opened Successfully");
		}
		
	}
		@Test
		public void validateLogo()
		{

           WebElement logo = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
           boolean isDisplayed = logo.isDisplayed();
           Assert.assertTrue(isDisplayed, "Logo is not displayed");
           
           String logoSrc = logo.getAttribute("src");
           System.out.println("Logo Image Source: " + logoSrc);
           Assert.assertTrue(logoSrc.contains("logo.png"), "Logo src is incorrect");
             
		}
		
		public void headerLinks()
		{
			WebElement footer = driver.findElement(By.xpath("//*[@id='header']"));
			footer.click();
		}
		@Test
		public void footerLinks()
		{
			WebElement footer = driver.findElement(By.xpath("//*[@id='footer']"));
			footer.click();
		}
		@Test
		public void allNavigations()
		{
			
			List<WebElement> alloptions = driver.findElements(By.xpath("//*[@href='/products']/parent::li/following-sibling::li"));
			System.out.println("The size of alloptions :"+alloptions.size());
			
			for(WebElement oneoption:alloptions)
			{
				String eachoption = oneoption.getText();
				System.out.println(eachoption);
			}
				
		}

		@Test
		public void scrollingResponse() throws InterruptedException
		{
			
			WebElement scrollbar = driver.findElement(By.xpath("//*[@lang='en']"));
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			act.scrollByAmount(0, 10000).perform();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		

}
