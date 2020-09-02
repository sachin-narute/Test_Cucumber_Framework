package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase{

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//WebElements	
	@FindBy(name="Email")
	WebElement txtEmail;

	@FindBy(name="Password")
	WebElement txtPassword;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//h1[contains(text(),'Admin area demo')]")
	WebElement AdminBaner;

	@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
	WebElement loginerrormsg;

	//Actions
	public  void setEmail(String EmailID) {
		txtEmail.clear();
		txtEmail.sendKeys(EmailID);
	}

	public  void setPassword(String txtPwd) {
		txtPassword.clear();
		txtPassword.sendKeys(txtPwd);
	}

	public String getloginerrormsg(){
		return loginerrormsg.getText();
	}


	public HomePage clickonLoginButton() {
		loginBtn.click();
		return new HomePage();
	}

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

}
