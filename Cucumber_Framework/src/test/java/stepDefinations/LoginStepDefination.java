package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;

import testBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination extends TestBase {

	pageObjects.LoginPage loginPage;
	pageObjects.HomePage HomePage;
	WebDriver driver=null;
	
	
	public LoginStepDefination() {
		super();
	}

	@BeforeMethod
	public void teststarted(){
		log.info("log4j2 - teststarted");
	
	}

	@Given("User navigates to website")
	public void user_navigates_to_website() {
		log.info("log4j2 - User navigates to website");
		initialization();
		loginPage = new pageObjects.LoginPage();
		AssertJUnit.assertEquals(loginPage.validateLoginPageTitle(), "Your store. Login");
	}

	@And("User enters a valid username as {string}")
	public void user_enters_a_valid_username_as(String emailid) {
		log.info("log4j2 - User enters a valid username");
		loginPage.setEmail(emailid);
	}

	@And("User enters a valid password as {string}")
	public void user_enters_a_valid_password_as(String pwd) {
		log.info("log4j2 - User enters a valid password");
		loginPage.setPassword(pwd);
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		log.info("log4j2 - User clicks on the login button");
		loginPage.clickonLoginButton();

	}

	@Then("User should be taken to the successful login page")
	public void user_should_be_taken_to_the_successful_login_page() {
		log.info("log4j2 - User should be taken to the successful login page");
		HomePage = new pageObjects.HomePage();
		AssertJUnit.assertEquals(HomePage.validatePageTitle(), "Dashboard / nopCommerce administration");
		AssertJUnit.assertEquals(HomePage.validateNameonHomeScreen(), "John Smith");
	}

	@AfterMethod
	public void tearDown(){
		log.info("log4j2 - tearDown");
		teardown();
	}

}