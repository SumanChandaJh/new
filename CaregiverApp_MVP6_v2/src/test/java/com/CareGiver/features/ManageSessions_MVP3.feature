@ManageSessions
Feature: Manage Sessions
US84036 - SFDC Provider Mobile App - Manage Sessions
#MVP3 Feature

Background: Navigate to Manage Sessions page
	Given I am registered ICP user
  	| Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword    | 
	|  PORTALSIT6 | R9_CP_Shreshtha04 R9_ICP_Provider04   | ltcportal.user+9900901@gmail.com | StageICPPenTest01 | Password@123 | shreshtha@caregiver.com.sit6 |  Password@123   |
	When I open "CareGiver" app 
	Then I should see John Hancock Logo in Launch page
	When I tap on "prJHLTCProd" button ICP Portal
	Then I should see "Long-Term Care Provider Login" ISAM login page
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
	
	#### optional for ios
	#When I tap on "Accept" Accept button
	Then I should see "Start Session" Customer Screen page
	And I should see Customer Full Name as page title
	When I tap on "Manage Sessions" Manage Session button
	Then I should see "Manage Sessions" Manage Sessions page

# Covers 'With Denied TimeLogs' & 'Without TimeLogs scenarios' page validation
@Regression
@ManageSessions_pageValidation
Scenario: Page Validation - Manage Sessions

	And I should see the "add" add sign in the header
	Given I have atleast one session
	#Then I should see List of Session with the date in "descending" order
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
	When I tap on "Manage Session" All Session button
	Then I should see "Manage Sessions" All Sessions page
	And I should see the message "No corrections are needed for this customer."
	When I tap on "arrow back" back button
	Then I should see "Start Session" Customer Screen page
	
	#### Multiple Customer scenario
	When I tap on "arrow back" back button
	Then I should see "My Customer" My Customers page
	
	#### Logout from CareGiver
	And I should see "menu" button
	When I click "menu" menu button
	Then I should see app menu
	When I tap "Log Out" Logout button
	Then I should see John Hancock Logo in Launch page
	
@Regression
@ManageSessions_AddManualSession_pageValidation
Scenario: Page Validation - Manage Sessions - Add Manual Session
	
	# Tap on '+' sign in the header
	When I tap on "add" add button
	
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
	
	#### Multiple Customer scenario
	When I tap on "arrow back" back button
	Then I should see "My Customer" My Customers page
	
	#### Logout from CareGiver
	And I should see "menu" button
	When I click "menu" menu button
	Then I should see app menu
	When I tap "Log Out" Logout button
	Then I should see John Hancock Logo in Launch page