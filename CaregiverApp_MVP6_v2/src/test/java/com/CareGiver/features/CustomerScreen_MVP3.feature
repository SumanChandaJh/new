@Customer_Screen
Feature: Customer Screen - Look & Feel Improvement 
US74130 - SFDC Provider Mobile App - Improvement look and feel - Customer Screen
#MVP3 Feature

@Regression
@CustomerScreen_pageValidation
Scenario: Customer Start Session Screen validation
	Given I am registered ICP user
		|            FullName 				  | 		        Email            |  Username  |   Password   |
		| R9_CP_Shreshtha04 R9_ICP_Provider04 | ltcportal.user+9900901@gmail.com | SIT6ICP002 | Password@123 |
	When I open "CareGiver" app 
	Then I should see John Hancock Logo in Launch page
	When I tap on "prJHLTCProd" button ICP Portal
	Then I should see "Independent care provider login" ISAM login page
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
	And I should see Customer Full Name as page title
	And I should see "All Sessions" button with "arrow forward" right alinged arrow
	And I should see "Manage Sessions" button with "arrow forward" right alinged arrow
	And I should see "Start Session" button at page bottom

	
	#When I tap on "Start Session" Begin Session button
	# 30 secs of script pause
	
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
	