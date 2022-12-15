package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
 public AccountRegistrationPage (WebDriver driver) {
	 super(driver);
 }
 
 @FindBy(id="input-firstname") WebElement txtFirstName;
 
 @FindBy(id="input-lastname") WebElement txtLastName;
 
 @FindBy(id="input-email") WebElement txtEmail;
 
 @FindBy(id="input-password") WebElement txtPassword;
 
 @FindBy(id="input-newsletter-yes") WebElement btnSubscribe;
 
 @FindBy(name="agree") WebElement chckPolicy;
 
 @FindBy(xpath="//button[contains(text(),'Continue')]") WebElement btnContinue;
 
 @FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]") WebElement msgConfirmation;
 
 public String getConfirmationMessage() {
	 try {
	 return msgConfirmation.getText();
	 	 }
	 catch (Exception e) {
		 return (e.getMessage());
	 }
 }
 
 public void setFirstName(String fname) {
	 txtFirstName.sendKeys(fname);
	}
 public void setLastName(String lname) {
	 txtLastName.sendKeys(lname);
	}
 public void setEmail(String email) {
	 txtEmail.sendKeys(email);
	}
 public void setPassword(String password) {
	 txtPassword.sendKeys(password);
	}
 public void chckSubscribe() {
	 btnSubscribe.click();
	}
 public void chckTerms() {
	 chckPolicy.click();
	}
 public void clickContinue() {
	 btnContinue.click();
	}
}
