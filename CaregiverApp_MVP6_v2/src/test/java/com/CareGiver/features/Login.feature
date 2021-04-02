@Login
Feature: ICP Provider Login to CareGiver app
US68893 - SFDC Provider Mobile App - Login flow look and feel improvements


@Regression
@Login
Scenario: ICP Login
	When I open "CareGiver" app 
	#Then I should see John Hancock Logo in Launch page
	When I tap on "prJHLTCProd" button ICP Portal
		 #This is a temporary way to login to CareGiver app
	Then I should see "Independent care provider login" ISAM login page
	When I enter below detail in textbox
		 | Label | Value |
		 | Username | R12SoumavoICP |
	 And I enter below detail in textbox
		 | Label | Value |
		 | Password | Password@123 |
	And I tap on "Login" button to Login
		#button with "Login" "label"
	
	Then I should see "Allow Access?" Allow Access page
	When I tap on "Allow" Allow button
	
	And I should see "Allow CareGiver to access this device's location?" modal window
	When I tap on "ALLOW" button in location access modal
	Then I should see "Terms and Conditions" Terms and Conditions page
	
	#ICP with multiple customer land in 'My Customers' page
	#Given I have multiple customer(s)
		#| FirstName | LastName | Email | ClaimStatus |
		#| Avirup | Chatterjee | smee@gmail.com | Active |
		#| Venith | Thayyil | see@gmail.com | Active |
	#When I tap on "Accept" Accept button
	#Then I should see "My Customers" My Customers page

	#ICP with multiple customer land in 'My Customers' page
	#Given I have single customer
		#| FirstName | LastName | Email | ClaimStatus |
		#| Avirup | Chatterjee | smee@gmail.com | Active |
		#| Venith | Thayyil | see@gmail.com | Active |
	
	When I tap on "Accept" Accept button
	Then I should see "Check In" Check In page
	
@Regression
@Login_BO
Scenario: ICP Salesforce Back Office Login
	Given I am registered ICP user
		| Environment |            FullName 				  | 		        Email            |  Username  |   Password   | 		  SFUsername 			|   SFPassword    | 
		|  PORTALSIT6 | R9_CP_Shreshtha04 R9_ICP_Provider04   | ltcportal.user+9900901@gmail.com | SIT6ICP002 | Password@123 | shreshtha@caregiver.com.sit6 |  Password@123   |
	
	When I open "CareGiver" app 
	Then I should see John Hancock Logo in Launch page
	#When I tap on "Log In with a Different Account" button
	#And I should see Salesforce BackOffice Login page
	And I should see "Log In to Sandbox" LogIn button
	When I enter my Username in "Username" textbox
	And I enter my Password in "Password" textbox
	And I tap on "Log In to Sandbox" button
		
	#When I tap on "prJHLTCProd" button ICP Portal
	#Then I should see "Independent care provider login" ISAM login page
	#When I enter username in textbox
	#And I enter password in textbox
	#And I tap on "Login" button to Login
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
	When I tap on "Accept" Accept button
	Then I should see "Start Session" Customer Screen page
	