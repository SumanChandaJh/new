@Smoke 
Feature: Smoke - Login & Logout 
#MVP3 Feature

@Smoke 
Scenario: Verify Provider's'access to App 
	Given I am registered ICP user 
		| Environment | FullName 				            | Email            				   | Username 			  | Password     | 		  SFUsername 			|   SFPassword    | 
		#| PORTALSIT5  | R15Provider_Virat R15Provider_Kohli | ltcportal.user+1500505@gmail.com | SIT5R15ProviderVirat | Temp@#012 | shreshtha@caregiver.com.sit6 |  Password@123   |
		|  STAGE      | BENILDA HARGETT                       | ltcportal.user+12000201@gmail.com     | R12STAGEICPBENILDA | Temp@#987 | shreshtha@caregiver.com.sit6 |  Password@123   |
	When I open "CareGiver" app 
	#Then I should see John Hancock Logo in Launch page 
	#When I tap on "prJHLTCProd" button ICP Portal 
	#This is a temporary way to login to CareGiver app
	Then I should see "Long-Term Care Provider Login" ISAM login page 
	When I enter username in textbox 
	And I enter password in textbox 
	And I tap on "Login" button to Login 
	Then I should see "Allow Access?" Allow Access page 
	When I tap on "Allow" Allow button 
	
	#### optional for ios
	And I should see "Allow CareGiver to access this device's location?" modal window 
	
	When I tap on "ALLOW" button in location access modal 
	When I tap on "Not Now" button in Location Chekin modal window 
	Then I should see "Terms and Conditions" Terms and Conditions page 
	When I tap on "Accept" Accept button 
	Then I should see "Start Session" Customer Screen page 
	And I should see "menu" button 
	When I click "menu" menu button 
	Then I should see menu_items: 
		| My Customers |
		| My Profile |
		| Tips |
		| Terms and Conditions |
		| Log Out |
	When I tap "Log Out" Logout button 
	
	