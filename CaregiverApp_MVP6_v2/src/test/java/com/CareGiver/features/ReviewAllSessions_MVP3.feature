@ReviewAllSessions
Feature: Review All Sessions 
US84022 - SFDC Provider Mobile App - Review Session
#MVP3 Feature

@Regression
@ReviewAllSession
Scenario: View All Sessions page validation
	Given I am registered ICP user
  	| Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword    | 
	|  PORTALSIT6 | R9_CP_Shreshtha04 R9_ICP_Provider04   | ltcportal.user+9900901@gmail.com | StageICPPenTest01 | Password@123 | shreshtha@caregiver.com.sit6 |  Password@123   |
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
    When I tap on first session of All session page
	Then I should see the following items
	
	|Start Time|
    |End Time|
    |Hourly Rate|
    |Total Charges|
	|Bathing|
	|Continence|
	|Dressing|
	|Eating|
	|Toileting|
	|Transferring|
	|Supervision|
	|Other|
	
	And I should see all fields are read only
	When I tap on "arrow back" back button
	Then I should see "All Sessions" All Sessions page
	When I tap on "arrow back" back button
	Then I should see "Start Session" Customer Screen page
	