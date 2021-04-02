Feature: Verification of Tour Page
As a CareGiver App User, I want to verify Tour within the app

Background: Login as a user
Given I am registered ICP user
  	| Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword   | 
	#|  PORTALSIT6     |        ROHIT SHARMA             | ltcportal.user+13005002@gmail.com| R19ProviderRohit      | P_assword@1234 | 	           abc@jhncock.com                 |  P_assword@1234  |
	|  STAGE      | BENILDA HARGETT                       | ltcportal.user+12000201@gmail.com     | R12STAGEICPBENILDA | Temp@#987 | shreshtha@caregiver.com.sit6 |  Password@123   |
	When I clean and open "CareGiver" app 
#	Then I should see John Hancock Logo in Launch page
#	When I tap on "prJHLTCProd" button ICP Portal
		 #This is a temporary way to login to CareGiver app
	When I enter username in textbox
	And I enter password in textbox
	And I tap on "Login" button to Login

	Then I should see "Allow Access?" Allow Access page
	When I tap on "Allow" Allow button
	
	#### optional for ios
	And I should see "Allow CareGiver to access this device's location?" modal window
	When I tap on "ALLOW" button in location access modal
	#When I tap on Not Now Location Chekin modal window
	Then I should see "John Hancock Long Term Care Provider Mobile Application Terms and Conditions of Use" Terms and Conditions page 
 
	#### optional for ios
	When I tap on "Accept" Accept button
	#Then I should see "Tour" Tutorial Page for Caregiver App
	
@TourValidation
Scenario: Tour Page Validation	
	When I click on "Start" Button for Tour
	Then I should see "All Sessions" All Sessions Tour Page
	When I click on "CareGiver" in the screen
	Then I should see Sessions Tour Tab
	When I click on "CareGiver" in the screen
	Then I should see "Past Sessions" Past Sessions for Tour
	When I click on "CareGiver" in the screen
	Then I should see "Recent Sessions" Recent Sessions for Tour
	When I click on "CareGiver" in the screen
	And I click on "Start Session" Start Session for Tour
#	Then I should see session getting started
	When I click on "CareGiver" in the screen
	#Then I should see "End Session" End Session for Tour
	When I click on "End Session" End Session for Tour
	Then I should see "Start Time" Start Time and "End Time" End Time for Tour
	When I click on "CareGiver" in the screen
	Then I should see "Hourly Rate" Hourly Rate for Tour
	When I click on "CareGiver" in the screen
	Then I should see "Total Cost" Total Cost for Tour
	When I click on "CareGiver" in the screen
	Then I should see "Services" Services for Tour
	When I click on "CareGiver" in the screen
	#Then I should see "Submit Session" Submit Session for Tour
	When I click on "Submit Session" Submit Session for Tour
	Then I should see "Profile Setup" Profile Setup page after Tour
	
	
	
@PastSessionAddition
Scenario: Past Session Page Validation
	When I click on "Skip" Skip button
	When I click on "Profile Setup" Profile Setup page
	Then I should be able to set "Hourly Rate" Hourly Rate
	When I click on "Next" Next button
	And I click on "Submit Past Session" Submit Past Session
	#Then I should be able to see "Start Time" Start Time and "End Time" End Time
	When I enter "Future End Date" in End Time input
	|Date|
	|21 March 2020|
	And I click on "Service" Service
	When I click on "Submit Session" submit session button
	Then I validate the "Error Message" for future date
	When I enter "Correct End date" in End Time input
	|Date|
	|06 March 2020|
	When I click on Start Date and enter "Future Time" time
	|Time|Hour|
	|AM|9|
	When I click on "Submit Session" submit session button
	Then I validate the Error Messages for future time
	When I click on Start Date and enter "Correct Time" time
	|Time|Hour|
	|AM|1|
	#When I click on "End Time" End Time input and enter time
	#And I click on "Service" Service 
	When I click on "Submit Session" submit session button
	And I click on "Submit" Submit popup
	#Then I should see "Session Submitted" Session Submitted Popup
	Then I click on "Home Screen" Home Screen button
	Then I Log Out
	
	
	
	