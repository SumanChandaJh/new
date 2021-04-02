@RegressionTest
Feature: Regression-Menu Verification,Customer Screen Verification,Checkin-Check Out
#MVP3 Feature

@Menu
Scenario: Menu verification

  	Given I am registered ICP user
  	| Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword    | 
	|  STAGE      | BENILDA HARGETT                       | ltcportal.user+12000201@gmail.com     | R12STAGEICPBENILDA | Password@789 | shreshtha@caregiver.com.sit6 |  Password@123   |
	When I open "CareGiver" app
	

	When I enter username in textbox
	And I enter password in textbox
	And I tap on "Login" button to Login

	Then I should see "Allow Access?" Allow Access page
	When I tap on "Allow" Allow button
	
	#### optional for ios
	And I should see "Allow CareGiver to access this device's location?" modal window
	When I tap on "ALLOW" button in location access modal
	Then I should see "Terms and Conditions" Terms and Conditions page
    When I tap on "Accept" Accept button
    
	Given I have "SINGLE" customer
		| FirstName | LastName | Email | ClaimStatus |
		|ROBERT     | MILLER   | ltcportal.user+120002@gmail.com | Active |
	
	#When I tap on "Accept" Accept button
	#Then I should see "Check In" Check In page
	Then I should see "Start Session" Customer Screen page
	And I should see "menu" button
	When I click "menu" menu button
	Then I should see menu_items:
		| My Customers |
		| My Profile |
		| Tips |
		| Terms and Conditions |
		| Log Out |
		

@Customer
Scenario: Customer Screen verification	
Given I am registered ICP user
  	| Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword    | 
	|  STAGE      | BENILDA HARGETT                       | ltcportal.user+12000201@gmail.com     | R12STAGEICPBENILDA | Password@789 | shreshtha@caregiver.com.sit6 |  Password@123   |
	When I open "CareGiver" app
	

	When I enter username in textbox
	And I enter password in textbox
	And I tap on "Login" button to Login

	Then I should see "Allow Access?" Allow Access page
	When I tap on "Allow" Allow button
	
	#### optional for ios
	And I should see "Allow CareGiver to access this device's location?" modal window
	When I tap on "ALLOW" button in location access modal
	Then I should see "Terms and Conditions" Terms and Conditions page
    When I tap on "Accept" Accept button
  
	
	Then I should see "Start Session" Customer Screen page
	
	And I should see "All Sessions" button with "arrow forward" right alinged arrow
	And I should see "Start Session" button at page bottom

	And I should see "menu" button
	When I click "menu" menu button
	Then I should see menu_items:
		| My Customers |
		| My Profile |
		| Tips |
		| Terms and Conditions |
		| Log Out |

	
@CheckinCheckOut
Scenario: check in ,check  verification
Given I am registered ICP user
  	| Environment |FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword    | 
	#|  PORTALSIT6      | ROHIT SHARMA             | ltcportal.user+13005002@gmail.com| 	R19ProviderRohit      | P_assword@1234 | 	           abc@jhncock.com                 |  P_assword@1234  |
	|  STAGE      | BENILDA HARGETT                       | ltcportal.user+12000201@gmail.com     | R12STAGEICPBENILDA | P_assword@1234 | shreshtha@caregiver.com.sit6 |  Password@123   |
	When I open "CareGiver" app
	When I enter username in textbox
	And I enter password in textbox
	And I tap on "Login" button to Login

	Then I should see "Allow Access?" Allow Access page
	When I tap on "Allow" Allow button
	
	#### optional for ios
	#And I should see "Allow CareGiver to access this device's location?" modal window
	#When I tap on "ALLOW" button in location access modal
	#Then I should see "Terms and Conditions" Terms and Conditions page
    #When I tap on "Accept" Accept button
    
	And I should tap on "Start Session" button
    And I should see "End Session" as End Session button label
	And I should tap on "End Session" button 
	Then I should see "New Session" Page
	Then I should see the following items
    |Start Time:|
	|End Time:|
	|Hourly Rate|
	|Total:|
	And I should see "Services Provided" label present
	And I should see the following list of Services Available
	|Bathing|
	|Continence|
	|Dressing|
	|Eating|
	|Toileting|
	|Mobility|
	|Supervision|
	|Other|
	When I tap to select below service options
	|Bathing|
	|Continence|
	|Mobility|
	And I should tap on "Submit Session" button 
	And I should tap on "Submit" to submit the session
	Then I Log Out
	
	
	
	