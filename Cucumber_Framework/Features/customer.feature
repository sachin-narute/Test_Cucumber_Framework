Feature: Customer

Scenario: Search customers by First name or Last Name
	Given User navigates to website
	And User enters a valid username as "admin@yourstore.com"
	And User enters a valid password as "admin"
	When User clicks on the login button
	Then User should be taken to the successful login page
	And click on "Customers" menu and "Customers" sub menu
	And "Customers" page should get displayed
	And search customer by "first name" with value as "John"
	And search result should be displayed as per search criteria
	


