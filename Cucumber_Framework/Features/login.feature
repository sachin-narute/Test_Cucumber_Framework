Feature: login

Scenario Outline: Login into account with correct details
	Given User navigates to website
	And User enters a valid username as <username>
	And User enters a valid password as <password>
	When User clicks on the login button
	Then User should be taken to the successful login page
	
	Examples:
	| username | password |
	| "admin@yourstore.com" | "admin" |
	| "admin@yourstore.com" | "admin1" |