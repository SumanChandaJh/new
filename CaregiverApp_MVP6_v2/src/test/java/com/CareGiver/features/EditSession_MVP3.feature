Feature: Check In Detail - Look & Feel Improvement 
US81515- SFDC Provider Mobile App - Edit Session



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
	When I tap on first session of All session page
	
	@Regression
	@EditSession_pageValidation
	Scenario: Page Validation - Edit Sessions 
	
	When I tap on first session of All session page
	And I should see "Time" section label
	And I should see "Start Time" label
	And I should see "End Time" label
    And I should see "Hourly Rate ($)" label
	#And I should see my default Hourly Rate
	And I should see "Total Charges ($)" label
	#And I should see Total Charges amount
	
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
	And I should see green colored "Submit Session" button
	
	@Regression
	@EditSession_errorValidation
	Scenario: Page Validation - Edit Sessions 
	
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
	
	