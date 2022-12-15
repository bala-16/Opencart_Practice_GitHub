package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
  @Test
  public void test_login() {
	  HomePage hp=new HomePage(driver);
	  hp.clickMyaccount();
	  logger.info("*** Myaccount is Clicked ***");
	  
	  hp.clickLogin();
	  logger.info("*** Login is Clicked ***");
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.typeEmail(rb.getString("email"));
	  logger.info("*** Entered login Email ***");
	  
	  lp.typePassword(rb.getString("password"));
	  logger.info("*** Entered login Password ***");
	 
	  lp.clickLogin();
	  logger.info("*** Clicked on Login ***");
  }
}
