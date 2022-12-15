package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDTest extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password, String exp) {
	try {
	HomePage hp=new HomePage(driver);
	hp.clickMyaccount();
	hp.clickLogin();
	LoginPage lp=new LoginPage(driver);
	lp.typeEmail(email);
	lp.typePassword(password);
	lp.clickLogin();
	}
	catch(Exception e) {
		Assert.fail();
	}
	}
}