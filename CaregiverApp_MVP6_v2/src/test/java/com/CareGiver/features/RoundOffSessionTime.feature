@RoundOffSessionTime
Feature: View All Sessions 
US80244 - SFDC Provider Mobile App - Remove seconds from Start/End Date/Time
#MVP3 Feature

@Regression
@RoundOffCheckinCheckOutTime
Scenario: View All Sessions page validation
	Given I am registered ICP user
		|            FullName 				  | 		        Email            |  Username  |   Password   |
		| R9_CP_Shreshtha04 R9_ICP_Provider04 | ltcportal.user+9900901@gmail.com | StageICPPenTest01 | Password@123 |
	When I open CareGiver app
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
	Given I have "MULTIPLE" customer
		| FirstName | LastName 	 |      Email     | ClaimStatus |
		|  R9Nikhil |  R9Prakash | smee@gmail.com |    Active   |
		|  R9Sadhvi |  R9Mishra  | smee@gmail.com |    Active   |
	
	#### optional for ios
	When I tap on "Accept" Accept button
	
	#### optional for Single Customer
	Then I should see "My Customer" My Customers page
	When I click on the Customer Card
	
	
	Then I should see "Start Session" Customer Screen page
	When I tap on "Start Session" Begin Session button
	Then I should see "Check In" Check In page
	
	And I should tap on "End Session" button 
	And I should see total charges 
	
	