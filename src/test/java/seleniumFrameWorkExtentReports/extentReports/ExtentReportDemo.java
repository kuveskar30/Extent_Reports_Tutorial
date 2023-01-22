package seleniumFrameWorkExtentReports.extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
// for using extents reports add extents reports dependency to pom.xml
// it is an open source tool	
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		//ExtentSparkReporter helps in creating report html file and configuring it
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TesterName", "Rahul Shetty");
	}
	
	
	@Test
	public void initialDemo() {
		//By using ExtentTest object we can do various operations 
		//like taking screenshot, failing test intentionally
		//This line and above code of config method needs to be written at beginning of any test 
		ExtentTest test = extent.createTest("Initial Demo");
		
		WebDriverManager.chromedriver().setup();
		WebDriver d1 = new ChromeDriver();
		d1.get("https://rahulshettyacademy.com/");
		System.out.println(d1.getTitle());
		test.fail("intiontionally failed by me");
		extent.flush();
	}
	
	
	
	
}
