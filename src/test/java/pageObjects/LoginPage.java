package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver){
		super(driver);
	}
	@FindBy(id="input-email") WebElement txtLoginEmail;

	@FindBy(id="input-password") WebElement txtLoginPwd;

	@FindBy(xpath="//button[contains(text(),'Login')]") WebElement btnLogin;

	public void typeEmail(String lemail) {
		txtLoginEmail.sendKeys(lemail);
	}
	public void typePassword(String lpwd) {
		txtLoginPwd.sendKeys(lpwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
}
