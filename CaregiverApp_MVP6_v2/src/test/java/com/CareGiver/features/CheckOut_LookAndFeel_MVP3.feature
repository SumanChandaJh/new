Feature: Check Out Detail - Look & Feel Improvement 
US77549 - SFDC Provider Mobile App - Improvement look and feel - Check Out Details


@Regression
@CheckOut_PageLabelValidation
Scenario: Check Out page label validation
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
	And I should see Customer Full Name as page title
	And I should see "All Sessions" button with "arrow forward" right alinged arrow
	And I should see "Manage Sessions" button with "arrow forward" right alinged arrow
	And I should see "Start Session" button at page bottom
	When I tap on "Start Session" Begin Session button
	And I should see "End Session" as End Session button label
	And I should tap on "End Session" button 
	Then I should see "Session" Page
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
	|Submit Session|
	|Delete Session|
	And I should see "Start Time" field is read only
	And I should see "End Time" field is not read only
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
	And I should see green colored "Submit Session" button

	@CheckOut_PageErrorMessageValidation
	Scenario: Check Out page Error Message validation
	And I should see "Start Time" field is read only
	And I should see "End Time" field is not read only
	And I should enter "0.00" into the "Hourly Rate" field
	When I tap to select below ADL_options:
		| Bathing    |
		| Continence |
		| Dressing   |
		| Eating     |
	
	And I should tap on "Submit Session" button 
    Then I should see the "Zero Hourly Rate" error message
	And I should enter "1000.00" into the "Hourly Rate" field
	When I tap to select below ADL_options:
		| Bathing    |
		| Continence |
	
	
	And I should tap on "Submit Session" button 
	Then I should see the "Maximum Value Exceeded" error message
	And I should enter "" into the "Hourly Rate" field
	When I tap to select below ADL_options:
		| Bathing    |
		| Continence |
	And I should tap on "Submit Session" button 
    Then I should see the "Invalid Hourly Rate" error message
	
	And I should enter "" into the "Others Text" field
	And I should tap on "Submit Session" button
	
	Then I should see the "Other Error Message" error message
	
	