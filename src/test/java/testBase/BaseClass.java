package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		rb=ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(this.getClass());

		if (br.equals("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			driver=new ChromeDriver(options);
		}
		else if (br.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.manage().window().maximize();

		driver.get(rb.getString("appURL"));
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomAlphaNumeric() {
		String generatedAlphaNum=RandomStringUtils.randomAlphanumeric(4, 3);
		return generatedAlphaNum;
	}
	public String randomAlphaNumeric2() {
		String st=RandomStringUtils.randomNumeric(4);
		String num=RandomStringUtils.randomNumeric(4);
		return st+num;
	}
	public String captureScreen  (String tname) throws IOException {
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot snap=(TakesScreenshot)driver;
		File source=snap.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshot\\"+tname+timestamp+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		}
		catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

}
