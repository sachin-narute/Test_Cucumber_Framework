package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import testBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CustomerStepDefination extends TestBase{
	
	WebDriver driver=null;
	pageObjects.HomePage HomePage;
	pageObjects.CustomerPage CustomerPage;
	

	public CustomerStepDefination() {
		super();
	}

	@BeforeMethod
	public void teststarted(){
		System.out.println("Test Started");
	}

	//***************************Need to Add Customers Specific functions***********************

	@And("^click on \"([^\"]*)\" menu and \"([^\"]*)\" sub menu$")
	public void click_on_something_menu_and_something_sub_menu(String mainMenu, String subMenu) {
		HomePage = new pageObjects.HomePage();
		HomePage.clickonMainMenu(mainMenu);
		HomePage.clickonMenuItem(subMenu);
	}

	@And("^\"([^\"]*)\" page should get displayed$")
	public void something_page_should_get_displayed(String subMenu) {
		CustomerPage = new pageObjects.CustomerPage();
		AssertJUnit.assertEquals(CustomerPage.getCustomerPageTitle(), subMenu);
	}

	@And("^search customer by \"([^\"]*)\" with value as \"([^\"]*)\"$")
    public void search_customer_by_something_with_value_as_something(String SearchBy, String SearchByValue) {
		
		//CustomerPage.setFName(fname);
		//CustomerPage.setLName(lname);
		//CustomerPage.clickSubmit();		
	}

	@And("search result should be displayed as per search criteria")
	public void search_result_should_be_displayed_as_per_search_criteria() {
		System.out.println("search result should be displayed as per search criteria");
	}

	

	//***************************Need to Add Customers Specific functions***********************


	@AfterMethod
	public void tearDown(){
		System.out.println("TearDown started");
		teardown();
	}

}
