Feature: SetUp Hourly Rate 

Background: Verify Provider's'access to App 
	Given I am registered ICP user 
		| Environment | FullName 				             | Username 			   | Password     |
		| PORTALSIT6  | R15Provider_Kemar R15Provider__Roach | R17ProviderKemar     |  WRONG@#123   | 
	#PORTALSIT6  | R15Provider_Kemar R15Provider__Roach | R17ProviderKemar     |  WRONG@#123   |
	#| PORTALSIT6  | R15Provider_MS R15Provider_Dhoni | R18ProviderMS     |  P_assword@1234   |
	When I open "CareGiver" app 
	#Then I should see John Hancock Logo in Launch page 
	#When I tap on "prJHLTCProd" button ICP Portal 
	#This is a temporary way to login to CareGiver app
	Then I should see "Long-Term Care Provider Login" ISAM login page 
	When I enter username in textbox 
	And I enter password in textbox 
	And I tap on "Login" button to Login 
	#When I tap on "Login" Allow button 
	Then I should see "Allow Access?" Allow Access page 
	When I tap on "Allow" Allow button 
	
	#### optional for ios
	And I should see "Allow CareGiver to access this device's location?" modal window 
	
	When I tap on "ALLOW" button in location access modal 
	#And I tap on Not Now Location Chekin modal window 
	Then I should see "John Hancock Long Term Care Provider Mobile Application Terms and Conditions of Use" Terms and Conditions page 
	When I tap on "Accept" Accept button 
	And I skip the tour of the App 
	
#@HourlyRateSetup 
Scenario: SetUp Hourly Rate 

	Then I should be on the start page 
	When I click on the Set Up profile button 
	Then I would be on the hourly rate page 
	Then I enter the hourly rate and click on next button 
		|    20    |
	And  I reach the acknowledgement page 
	When I click on Return To The Home Screen button  
	Then I should be on the Home Screen page 
		| Customers |
		| Profile   |
		| More      |
	When I click on More option 
	Then I should see all items 
		| Tips               |
		| Tour               |
		| Terms & Conditions |
		| Log Out            |

#@HourlyRateSetupSingleCustomer 
Scenario: SetUp Hourly Rate for Single-Customer User

	Then I should be on the start page 
	When I click on the Set Up profile button 
	Then I would be on the hourly rate page 
	Then I enter the hourly rate and click on next button 
		|    20    |
	And  I reach the acknowledgement page 
	When I click on Return To The Home Screen button
	And I skip the tour of the App 
	Then I should be on the Home Screen page 
		| Sessions |
		| Profile   |
		| More      |
	When I click on More option 
	Then I should see all items 
		| Tips               |
		| Tour               |
		| Terms & Conditions |
		| Log Out            |	
		
				