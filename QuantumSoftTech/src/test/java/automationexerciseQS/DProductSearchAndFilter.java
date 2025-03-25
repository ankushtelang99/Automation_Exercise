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

public class DProductSearchAndFilter 
{

	String actualProductname;
	String expectedProductname = "Colour Blocked Shirt – Sky Blue";
	
	String actualprice;
	String expectedprice="Rs. 849";
	
	String actualAvailability;
	String expectedAvailability="Availability: In Stock";
	
	String actualpricechanges;
	String actaulQuantitychanges;
	String expectedQuantitychanges="1";	
	
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
    public void productSearch()
    {
	  driver.findElement(By.xpath("//*[@href='/products']")).click();
	  
	  driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("tshirt");
	  
	  driver.findElement(By.xpath("//*[@id='submit_search']")).click();
	  
	  WebElement scrollbar = driver.findElement(By.xpath("//*[@lang='en']"));
	  Actions act = new Actions(driver);
	  act.scrollByAmount(0, 400).perform();
	  
	  WebElement category = driver.findElement(By.xpath("(//*[@class='fa fa-plus'])[2]"));
	  category.click();
	 
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  WebElement tshirt = driver.findElement(By.xpath("//*[@href='/category_products/3']"));
	  tshirt.click();
	 
	  WebElement scrollbar2 = driver.findElement(By.xpath("//*[@lang='en']"));
	  act.scrollByAmount(0, 200).perform();
	  
	  WebElement brand = driver.findElement(By.xpath("//*[text()='Allen Solly Junior']"));
	  brand.click();
	  
    }
    
    @Test(priority=1)
    public void productDetailsPage()
    {
   	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	  WebElement scrollbar3 = driver.findElement(By.xpath("//*[@lang='en']"));
	  Actions act1 = new Actions(driver);
	  act1.scrollByAmount(0, 400).perform();	  
	  
	  WebElement viewproduct = driver.findElement(By.xpath("//*[@class='nav nav-pills nav-justified']//*[@href='/product_details/24']"));
	  viewproduct.click();
	 
	  actualProductname = driver.findElement(By.xpath("//*[text()='Colour Blocked Shirt – Sky Blue']")).getText();
	  Assert.assertEquals(actualProductname, expectedProductname);
	  System.out.println("Product name Matched Successfully");
	 
	  actualprice = driver.findElement(By.xpath("//*[text()='Rs. 849']")).getText();
	  Assert.assertEquals(actualprice, expectedprice);
	  System.out.println("Product Price Matched Successfully");
	 
	  actualAvailability = driver.findElement(By.xpath("//*[text()=' In Stock']")).getText();
	  Assert.assertEquals(actualAvailability, expectedAvailability);
	  System.out.println("Product Availability Matched Successfully");
		
    }
    @Test(priority=2)
    public void addToCartFromProductDetailsPage()
    {
      	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

    	WebElement added = driver.findElement(By.xpath("//*[@class='btn btn-default cart']"));
    	added.click();
    	
    	WebElement viewcart = driver.findElement(By.xpath("//*[@class='modal-body']//*[@href='/view_cart']"));
    	viewcart.click();
    	
        actualpricechanges = driver.findElement(By.xpath("//*[@class='cart_price']/*[text()='Rs. 849']")).getText();
        Assert.assertEquals(actualpricechanges, expectedprice);
        System.out.println("Price is not changed in cart");
       
        actaulQuantitychanges = driver.findElement(By.xpath("//*[@class='cart_quantity']//*[text()='1']")).getText();
        Assert.assertEquals(actaulQuantitychanges, expectedQuantitychanges);
        System.out.println("Quantity is not changed in cart");
 
   
    }
    @Test(priority=3)
    public void addToCartFromHomePage()
    {
    	WebElement homepage = driver.findElement(By.xpath("//*[@class='breadcrumb']//*[@href='/']"));
    	homepage.click();
    	
    	WebElement scrollbar4 = driver.findElement(By.xpath("//*[@lang='en']"));
  	    Actions act2 = new Actions(driver);
  	    act2.scrollByAmount(0, 600).perform();
  	    
  	    WebElement Addtocart1 = driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]"));
	    Addtocart1.click();
	    
	    WebElement viewcart = driver.findElement(By.xpath("//*[text()='View Cart']"));
	    viewcart.click();
    }
    
   


}
