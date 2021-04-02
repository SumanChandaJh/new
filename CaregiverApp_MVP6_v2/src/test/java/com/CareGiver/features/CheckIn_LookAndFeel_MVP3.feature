@CheckIn_Look&Feel
Feature: Check In Detail - Look & Feel Improvement 
US74129 - SFDC Provider Mobile App - Improvement look and feel - Check In Details


@Regression
@CheckIn_PageValidation
Scenario: Check In page
	When I open "CareGiver" app 
	Then I should see John Hancock Logo in Launch page
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
	
	#And I should see "Allow CareGiver to access this device's location?" modal window
	#When I tap on "ALLOW" button in location access modal
	#Then I should see "Terms and Conditions" Terms and Conditions page


	#ICP with multiple customer land in 'My Customers' page
	#Given I have single customer
		#| FirstName | LastName | Email | ClaimStatus |
		#| Avirup | Chatterjee | smee@gmail.com | Active |
		#| Venith | Thayyil | see@gmail.com | Active |
	#And I have started the session
	
	#When I tap on "Accept" Accept button
	#Then I should see "Check In" Check In page
	Then I should see "Start Session" start session button
	
	When I tap on "Start Session" Begin Session button
	# 30 secs of script pause
	Then I should see "Check In" Check In page
	#And I should see Customer Full Name is present
	And I should see "Start Date" as Start Date label
	And I should see Start Date as today
	And I should see "Start Time" as Start Time label 
	And I should see Start Time as current time
	And I should see "End Session" as End Session button label
	