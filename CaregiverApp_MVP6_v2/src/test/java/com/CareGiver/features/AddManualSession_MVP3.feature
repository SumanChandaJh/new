@AddManualSession
Feature: Add Manual Session 
US81514 - SFDC Provider Mobile App - Add Manual Session
#MVP3 Feature

Background: Navigate to Add Manual Session page
	Given I am registered ICP user
    | Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword   | 
	|  STAGE      |        LAUREL LEIBRECHT               | ltcportal.user+13005002@gmail.com| R13ICPLaurel      | Password@123 | 	           abc@jhncock.com                 |  Password@123  |
	When I open "CareGiver" app 
	Then I should see John Hancock Logo in Launch page
	#When I tap on "prJHLTCProd" button ICP Portal
	#Then I should see "Independent care provider login" ISAM login page
	When I enter username in textbox
	And I enter password in textbox
	And I tap on "Login" button to Login
	Then I should see "Allow Access?" Allow Access page
    When I tap on "Allow" Allow button
	
	#### optional for ios
	And I should see "Allow CareGiver to access this device's location?" modal window
	When I tap on "ALLOW" button in location access modal
	Then I should see "Terms and Conditions" Terms and Conditions page

	##Given I have "SINGLE" customer
		| FirstName | LastName |      Email     				| ClaimStatus |
		|  R9Avirup |  R9Chat  | ltcportal.user+77711@gmail.com |    Active   |
	
	#### optional for ios
	When I tap on "Accept" Accept button
	Then I should see "Start Session" Customer Screen page
	And I should see Customer Full Name as page title
	Then I should see "Start Session" Customer Screen page

	When I tap on "All Session" All Session button
	Then I should see "All Sessions" All Sessions page
	And I should see the "add" add sign in the header
	When I tap on "add" add button

@Regression
@AddManualSession_pageValidation
Scenario: Page Validation - Add Manual Session
	
	# 'Add' Manual Session page
	Then I should see "Session" Add Session page
	And I should see Customer Full Name as "R9Avirup R9Chat"
	# 'Time' Section field verification
	And I should see "Time" section label
	And I should see "Start Time" label
	And I should see default "Start Time" in "M/d/yy, h:mm a" format
	And I should see "End Time" label
	And I should see default "End Time" in "M/d/yy, h:mm a" format
	And I should see "Hourly Rate ($)" label
	And I should see my default Hourly Rate
	And I should see "Total Charges ($)" label
	And I should see Total Charges amount
	
	# 'Activities of Daily Living' section field verification
	And I should see "Activities of Daily Living" section label
	And I should see ADL_labels:
		| Bathing 	 			  |
		| Continence 			  |
		| Dressing 		          |
		| Eating 				  |
		| Toileting 			  |
		| Transferring / Mobility |
		| Supervision / Safety 	  |
		| Other                   |
	When I tap "Other" labelled ADL button
	Then I should see "Other" textbox appears
	
	# 'Submit Session' button
	And I should see green colored "Submit Session" button
	When I tap on "arrow back" back button
	Then I should see "All Sessions" All Sessions page
	When I tap on "arrow back" back button
	Then I should see "Start Session" Customer Screen page
	
	#### Logout from CareGiver
	And I should see "menu" button
	When I click "menu" menu button
	Then I should see app menu
	When I tap "Log Out" Logout button
	Then I should see John Hancock Logo in Launch page
	
@Regression
@AddManualSession_Submit
Scenario: Submit Manual Session
	
	# 'Add' Manual Session page
	Then I should see "Session" Add Session page
	
	# 'Time' Section field verification
	And I should see "Time" section label
	
	# Select Start & End date & Time
	#When I select "Start Time" as "3/4/19, 12:00 PM" in date time "M/d/yy, h:mm a" format
	When I select the "Start Time" date picker to "subtract" "179" minutes
	Then I should see "Start Time" value in "M/d/yy, h:mm a" format
	#When I select "End Time" as "3/4/19, 1:00 PM" in date time "M/d/yy, h:mm a" format
	When I select the "End Time" date picker to "subtract" "23" minutes
	Then I should see "End Time" value in "M/d/yy, h:mm a" format
	
	# 'Activities of Daily Living' section field verification
	And I should see "Activities of Daily Living" section label
	When I tap to select below ADL_options:
		| Bathing    |
		| Continence |
		| Dressing   |
		| Eating     |
	Then I should see "Other" textbox appears
	#And I enter "Hello" in the "Other" Edit Text Box
	
	# 'Submit Session' button
	When I tap on "Submit Session" button
	Then I should see the toast message "Session submitted."
	And I should see "Start Session" Customer Screen page
	
	# validate submission in 'All Sessions'
	When I tap on "All Session" All Session button
	Then I should see "All Sessions" All Sessions page
	And I should see the Submitted Timelog displaying at the top
	And I verify the Submitted Session detail
	
	#### Logout from CareGiver
	And I should see "menu" button
	When I click "menu" menu button
	Then I should see app menu
	When I tap "Log Out" Logout button
	Then I should see John Hancock Logo in Launch page
	