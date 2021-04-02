@TipsPage
Feature: Verification of Tips page
As a CareGiver App User, I want to be able to view Tips within the app, 
so that I don't have to call the Call Center for basic questions that can be found in Tips.


@Regression
@Tips_pageValidation
Scenario: Tips page validation
    
    Given I am registered ICP user
		|            FullName 				  | 		        Email            |  Username  |   Password   |
		| R9_CP_Shreshtha04 R9_ICP_Provider04 | ltcportal.user+9900901@gmail.com | SIT6ICP002 | Password@123 |
	When I open "CareGiver" app 
	Then I should see John Hancock Logo in Launch page
	When I tap on "prJHLTCProd" button ICP Portal
		 #This is a temporary way to login to CareGiver app
	When I enter username in textbox
	And I enter password in textbox
	And I tap on "Login" button to Login

	Then I should see "Allow Access?" Allow Access page
	When I tap on "Allow" Allow button
	
	#### optional for ios
	And I should see "Allow CareGiver to access this device's location?" modal window
	When I tap on "ALLOW" button in location access modal
	Then I should see "Terms and Conditions" Terms and Conditions page

	#ICP with multiple customer land in 'My Customers' page
	Given I have "SINGLE" customer
		| FirstName | LastName |      Email     | ClaimStatus |
		|  R9Sachin |  R9Rajan | smee@gmail.com |    Active   |
	
	#### optional for ios
	When I tap on "Accept" Accept button
	
	Then I should see "Start Session" Customer Screen page
	And I should see "menu" button
	When I click "menu" menu button
	Then I should see menu_items:
		| My Customers |
		| My Profile |
		| Tips |
		| Terms and Conditions |
		| Log Out |
		
	#Then I should see "Tips" Tips menu
	
	
	
	When I tap on "Tips" Tips from menu
	Then I should see "Tips" Tips page
	#And I should see Tips Article Title is present
	#And I should see Tips Article content is present
	And I should see "arrow back" back button is present
	When I tap on "arrow back" back button
	Then I should see "Start Session" Customer Screen page
	
	#Logout from CareGiver
	And I should see "menu" button
	When I click "menu" menu button
	Then I should see menu_items:
		| My Customers |
		| My Profile |
		| Tips |
		| Terms and Conditions |
		| Log Out |
	When I tap "Log Out" Logout button
	Then I should see John Hancock Logo in Launch page
	#END