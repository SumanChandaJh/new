@AllSessions
Feature: View All Sessions 
US80185 - SFDC Provider Mobile App - View All Sessions
#MVP3 Feature

@Regression
@AllSessions
Scenario: View All Sessions page validation
	Given I am registered ICP user
  	| Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword    | 
	|  PORTALSIT6 | R9_CP_Shreshtha04 R9_ICP_Provider04   | ltcportal.user+9900901@gmail.com | StageICPPenTest01 | Password@123 | shreshtha@caregiver.com.sit6 |  Password@123   |
	When I open "CareGiver" app
	Then I should see John Hancock Logo in Launch page
	When I tap on "prJHLTCProd" button ICP Portal
		 #This is a temporary way to login to CareGiver app
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

	# ICP with multiple customer land in 'My Customers' page
	Given I have "MULTIPLE" customer
		| FirstName | LastName 	 |      Email     | ClaimStatus |
		|  R9Nikhil |  R9Prakash | smee@gmail.com |    Active   |
		|  R9Sadhvi |  R9Mishra  | smee@gmail.com |    Active   |
	
	#### optional for ios
	When I tap on "Accept" Accept button
	
	#### optional for Single Customer
	Then I should see "My Customer" My Customers page
	When I click on the Customer Card "R9Nikhil R9Prakash"
	Then I should see "Start Session" Customer Screen page
	And I should see "All Sessions" button with "arrow forward" right alinged arrow

	When I tap on "All Session" All Session button
	Then I should see "All Sessions" All Sessions page
	And I should see the "add" add sign in the header
	Given I have atleast one session
	And I should see Check In Date as header in "MM/dd/yyyy" format
	And I should see Check In Time and Check Out Time in "h:mm a" format
	And I should see Total Charges with "$" sign
	When I tap on "arrow back" back button
	Then I should see "Start Session" Customer Screen page
	
	#### Multiple Customer scenario
	When I tap on "arrow back" back button
	Then I should see "My Customer" My Customers page
	
	#### No Sessions Customer
	When I click on the Customer Card "R9Sadhvi R9Mishra"
	Then I should see "Start Session" Customer Screen page
	When I tap on "All Session" All Session button
	Then I should see "All Sessions" All Sessions page
	And I should see the message "No sessions have been submitted for this customer."
	When I tap on "arrow back" back button
	Then I should see "Start Session" Customer Screen page
	
	#### Multiple Customer scenario
	When I tap on "arrow back" back button
	Then I should see "My Customer" My Customers page
	
	#### Logout from CareGiver
	And I should see "menu" button
	When I click "menu" menu button
	When I click "menu" menu button
	When I tap "Log Out" Logout button
	Then I should see John Hancock Logo in Launch page
	