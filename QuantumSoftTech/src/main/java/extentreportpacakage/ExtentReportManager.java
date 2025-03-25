package extentreportpacakage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager 
{
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest>test = new ThreadLocal<>();
	
	public static void  setUpExtentReport()
	{
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("./extent-reports/extent.html");
		extent = new ExtentReports();
	}
	public static void createTest(String testname)
	{
		ExtentTest extentTest = extent
				.createTest(testname)
				.assignAuthor("Ankush")
				.assignDevice("Chrome");
		
		test.set(extentTest);
	
	}
	public static ExtentTest getTest()
	{
		return test.get();
		
	}
	public static ExtentReports getReport()
	{
		return extent;
		
	}
	public static void flushReport()
	{
		extent.flush();
	}

}
