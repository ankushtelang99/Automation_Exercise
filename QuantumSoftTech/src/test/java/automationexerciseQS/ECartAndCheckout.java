package automationexerciseQS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECartAndCheckout 
{

	String actualdescription;
	String expecteddescription="Men > Tshirts";

	String actualprice;
	String expectedprice ="Rs. 400";
	
	String actualorderplaced ;
	String expectedorderplaced ="Congratulations! Your order has been confirmed!";
	

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
	public void cartAndCheckout()

	{
		WebElement Loginlink=driver.findElement(By.xpath("//*[@href='/login']"));
		Loginlink.click();

		WebElement email = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
		email.sendKeys("ankushtelang26@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//*[@name='password']"));
		pass.sendKeys("Ankush@1234");
		WebElement Loginbutton = driver.findElement(By.xpath("//*[text()='Login']"));
		Loginbutton.click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement cart = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]"));
		cart.click();

		WebElement proceedToCheckout = driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));
		proceedToCheckout.click();

		WebElement scrollbar = driver.findElement(By.xpath("//*[@lang='en']"));
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 400).perform();


		actualdescription = driver.findElement(By.xpath("//*[text()='Men > Tshirts']")).getText();
		Assert.assertEquals(actualdescription, expecteddescription);
		System.out.println("Product description Matched Successfully");


		actualprice = driver.findElement(By.xpath("//*[text()='Rs. 400']")).getText();
		Assert.assertEquals(actualprice, expectedprice);
		System.out.println("Product price Matched Successfully");

		WebElement scrollbar1 = driver.findElement(By.xpath("//*[@lang='en']"));
		act.scrollByAmount(0, 400).perform();

		WebElement placeorder = driver.findElement(By.xpath("//*[text()='Place Order']"));
		placeorder.click();


	}

	@Test(priority=1)
	public void paymentandOrderConfirmation()
	{
		WebElement nameofcard = driver.findElement(By.xpath("//*[@class='form-control']"));
		nameofcard.sendKeys("State bank of India");
		
		WebElement cardnumber = driver.findElement(By.xpath("//*[@name='card_number']"));
		cardnumber.sendKeys("20210523078");
		
		WebElement cvc = driver.findElement(By.xpath("//*[@name='cvc']"));
		cvc.sendKeys("383");
		
		WebElement expirationmonth = driver.findElement(By.xpath("//*[@name='expiry_month']"));
		expirationmonth.sendKeys("08");
		
		WebElement expirationyear = driver.findElement(By.xpath("//*[@name='expiry_year']"));
		expirationyear.sendKeys("2027");
	
		WebElement confirmorder = driver.findElement(By.xpath("//*[@id='submit']"));
		confirmorder.click();
		
		String Actualorderplaced = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).getText();
		Assert.assertEquals(Actualorderplaced, expectedorderplaced);
		System.out.println("order got placed Successfully");
		
		
	}
    @Test(priority=2)
	public void contactUS()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    	WebElement cilcktocontactus = driver.findElement(By.xpath("//*[text()=' Contact us']"));
    	cilcktocontactus.click();
    	
    	WebElement namefield = driver.findElement(By.xpath("//*[@name='name']"));
    	namefield.sendKeys("Ankush Telang");
    	
    	WebElement emailfield = driver.findElement(By.xpath("//*[@name='email']"));
    	emailfield.sendKeys("ankushtelang26@gmail.com");
    	
    	WebElement subjectfield = driver.findElement(By.xpath("//*[@name='subject']"));
    	subjectfield.sendKeys("I want to Return the product");
    	
    	WebElement messagefield = driver.findElement(By.xpath("//*[@name='message']"));
    	messagefield.sendKeys("wrong product has been recieved");
    	
    	WebElement submitbutton = driver.findElement(By.xpath("//*[@name='submit']"));
    	submitbutton.click();
     	
    	
	}
}
