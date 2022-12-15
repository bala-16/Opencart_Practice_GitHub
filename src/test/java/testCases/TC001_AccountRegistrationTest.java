package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	@Test
	public void test_account_registration() throws InterruptedException {
		try {
			HomePage hp=new HomePage(driver);
			logger.info("*** Application is Opened ***");
			
			hp.clickMyaccount();
			logger.info("*** Clicked on Myaccount ***");
			
			hp.clickRegister();
			logger.info("*** Clicked on Register ***");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			regpage.setFirstName(randomString());
			logger.info("*** Entered First Name ***");
			
			regpage.setLastName(randomString());
			logger.info("*** Entered Last Name ***");
			
			regpage.setEmail(randomAlphaNumeric2()+"@gmail.com");
			logger.info("*** Entered Email ***");
			
			regpage.setPassword(randomString());
			logger.info("*** Entered password ***");
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			regpage.chckTerms();
			logger.info("*** Checked the terms ***");
			
			regpage.clickContinue();
			logger.info("*** Clicked on Continue ***");
						
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//String actual=regpage.getConfirmationMessage();
			//Assert.assertEquals(actual, "Your Account Has Been Created!");
		}
		catch (Exception e) {
			Assert.fail();
		}
	}
}
