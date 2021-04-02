Feature: Set Time Log Status on Check Out
US78782 - SFDC Provider Mobile App - Set Time Log Status on Check Out


@Regression
@CheckOut_PagePositive
Scenario: Check Out page field level validation
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
	When I tap on "Start Session" Begin Session button
	# 30 secs of script pause
	Then I should see "Check In" Check In page
	#And I should see Customer Full Name is present
	
	And I should see "End Session" as End Session button label
	And I should tap on "End Session" button 
	
	When I tap to select below ADL_options:
		| Bathing    |
		| Continence |
		| Dressing   |
		| Eating     |
	And I should tap on "Submit Session" button  
	
	@BackOffice
	Scenario: BackOffice validation
	When I navigate to the Salesforce Backoffice
		|UserName|Password|URL|
		|sachin_rajan@jhancock.com.ltc.portalsit6|Apr@2019|https://jhltc--portalsit6.cs19.my.salesforce.com|sachin_rajan@jhancock.com.ltc.portalsit6|

   And I log in to the SFDC application as a "Claim Specialist" 
#		|UserType|UserID|Password|
#		|Special Claim Specialist|iroy@jhancock.com.ltc.portalsit6|Apr@2019|
#		|Claim Specialist|sachin_rajan@jhancock.com.ltc.portalsit6|Apr@2019|
#		|Super User|raymond_superuser@jhancock.com.ltc.portalsit6|Apr@2019|
#	
#	When I click on "All TABS" section in SFDC Backoffice 
#	And I select "Time Logs" from the All Items subsection 
#	Then the "Time Logs" page should be displayed 
#	When I select the "All Time Logs" value  
#	Then I should see "All Time Logs" table  
#	And I sort the "Timelog Details"  table in "descending" order 
#	And I select the first value from the "Time Logs" table
#	And the value of the field 
#    Then the browser should be closed 

	