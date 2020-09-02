package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase{

	//Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//webelements
	@FindBy (xpath="//li[@class='account-info']")
	WebElement logedinUsername;

	@FindBy (xpath="//span[@class='logo-lg']")
	WebElement logo;

	@FindBy (xpath="//a[contains(text(),'Logout')]")
	WebElement logoutbtn;	


	@FindBy (xpath="//a[@href='#']//span[contains(text(),'Customers')]")
	WebElement lnkCustomers_menu;

	@FindBy (xpath="//span[@class='menu-item-title'][contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;



	//Actions
	public String validatePageTitle(){
		return driver.getTitle();
	}

	public String validateNameonHomeScreen(){
		return logedinUsername.getText();
	}

	public boolean validatelogoonHomeScreen(){
		return logo.isDisplayed();
	}

	public LoginPage clickOnLogout(){
		logoutbtn.click();
		return new LoginPage();
	}

	public void clickonMainMenu(String MainMenuName){
		System.out.println(MainMenuName);
		driver.findElement(By.xpath("//a[@href='#']//span[contains(text(),'"+MainMenuName+"')]")).click();
	}
	
	public void clickonMenuItem(String MainItemName){
		System.out.println(MainItemName);
		driver.findElement(By.xpath("//span[@class='menu-item-title'][contains(text(),'"+MainItemName+"')]")).click();
	}

}
