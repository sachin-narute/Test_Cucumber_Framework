package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class CustomerPage extends TestBase{

	//Initializing the Page Objects:
	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}

	//webelements
	@FindBy (xpath="//h1[@class='pull-left']")
	WebElement CustomerPageTitle;

	@FindBy (xpath="//div[@class='search-text']")
	WebElement CustSearchPanel;

	/*
		panelHide - 		xpath="//div[@class='row search-row']"
		PanelOpen - 		xpath="//div[@class='row search-row opened']"
	 */



	@FindBy (xpath="//input[@id='SearchEmail']")
	WebElement txtEmailSearch;

	@FindBy (xpath="//input[@id='SearchCompany']")
	WebElement txtCompSearch;

	@FindBy (xpath="//input[@id='SearchFirstName']")
	WebElement txtFNameSearch;

	@FindBy (xpath="//input[@id='SearchIpAddress']")
	WebElement txtIPAddSearch;

	@FindBy (xpath="//input[@id='SearchLastName']")
	WebElement txtLNameSearch;

	@FindBy (xpath="//input[@class='k-input']")
	WebElement selCustRole;

	@FindBy (xpath=("//div[@class='k-multiselect-wrap k-floatwrap']"))
	WebElement txtcustomerRoles;

	@FindBy (xpath=("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]"))
	WebElement SelectedCustomerRoleIds;

	@FindBy (xpath=("//li[contains(text(),'Administrators')]"))
	WebElement lstitemAdministrators;

	@FindBy (xpath=("//li[contains(text(),'Registered')]"))
	WebElement lstitemRegistered;


	@FindBy (xpath=("//li[contains(text(),'Guests')]"))
	WebElement lstitemGuests;

	@FindBy (xpath=("//li[contains(text(),'Vendors')]"))
	WebElement lstitemVendors;


	@FindBy (xpath="//select[@id='SearchMonthOfBirth']")
	WebElement selDOBMonth;

	@FindBy (xpath="//select[@id='SearchDayOfBirth']")
	WebElement selDOBDay;

	@FindBy (xpath="//button[@id='search-customers']")
	WebElement btnSearchCust;

	@FindBy (xpath="//div[@class='dataTables_scrollHead']//tr[@role='row']/th")
	List<WebElement> HeaderList;


	//Actions
	public void getPageTitle(){
		driver.getTitle();
	}

	public String getCustomerPageTitle(){
		return CustomerPageTitle.getText();
	}

	public void setEmail(String emailadd){
		txtEmailSearch.sendKeys(emailadd);	
	}

	public void setCompany(String CompanyName){
		txtCompSearch.sendKeys(CompanyName);
	}

	public void setFName(String FName){
		txtFNameSearch.sendKeys(FName);
	}

	public void setLName(String LName){
		txtLNameSearch.sendKeys(LName);
	}

	public void setIPAdd(String IPadd){
		txtIPAddSearch.sendKeys(IPadd);
	}

	public void selectDOBMonth(String month){
		Select MonList = new Select(selDOBMonth);	
		MonList.selectByVisibleText(month);
	}

	public void selectDOBDay(String day){
		Select DayList = new Select(selDOBDay);
		DayList.selectByVisibleText(day);;
	}

	public void setCustomerRoles(String role) throws InterruptedException 
	{
		SelectedCustomerRoleIds.click();
		txtcustomerRoles.click();

		WebElement listitem;
		Thread.sleep(3000);

		if(role.equals("Administrators"))
		{
			listitem=lstitemAdministrators; 
		}
		else if(role.equals("Guests"))
		{
			listitem=lstitemGuests;
		}
		else if(role.equals("Registered"))
		{
			listitem=lstitemRegistered;
		}
		else if(role.equals("Vendors"))
		{
			listitem=lstitemVendors;
		}
		else
		{
			listitem=lstitemGuests;
		}

		listitem.click();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", listitem);

	}

	public void clickSubmit(){
		btnSearchCust.click();
	}

	public void valSearchResult(String fname){

	}

	public static int getColumnHeaderIndex(String columnName){
		int NoOfColM=driver.findElements(By.xpath("//div[@class='dataTables_scrollHead']//tr[@role='row']/th")).size();
		ArrayList<String> List= new ArrayList<String>();
		for (int i = 1; i <= NoOfColM; i++) {
			String name=driver.findElement(By.xpath("//div[@class='dataTables_scrollHead']//tr[@role='row']/th["+i+"]")).getText();
			List.add(name);
		}
		return List.indexOf(columnName);
	}

	public void valSearchResult(String email, String fname, String lname,  int monDOB, int dayDOB, String compName, String ipAdd, String custRole){
		//CustomerTable - //div[@class='dataTables_scroll']
	}
}
