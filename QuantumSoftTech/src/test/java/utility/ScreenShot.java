package utility;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot 
{
	
	public static void captureScreenshot(WebDriver driver,String filename) throws IOException
	{
        TakesScreenshot scrshot = (TakesScreenshot) driver; 
		
		String path = System.getProperty("user.dir")+"\\Screenshots\\"+filename+".png";
		
		File destination = new File(path);

		File source = scrshot.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(source,destination);

	}		
		
		
		
		
		
}
	

	
	
	
	
	
	
	


