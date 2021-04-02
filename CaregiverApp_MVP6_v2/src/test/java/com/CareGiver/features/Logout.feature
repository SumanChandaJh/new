@Logout 
Feature: ICP Provider Login to CareGiver app 
	US68893 - SFDC Provider Mobile App - Login flow look and feel improvements


@Regression 
@Logout_ 
Scenario: Logout Functionality 
	Given I am registered ICP user 
		| Environment |            FullName 				  | 		        Email            |         Username  |   Password   | 		  SFUsername 			|   SFPassword   | 
		|  PORTALSIT6 | R9_CP_Shreshtha04 R9_ICP_Provider04   | ltcportal.user+9900901@gmail.com | StageICPPenTest01 | Password@123 | shreshtha@caregiver.com.sit6 	|  Password@123  |
	When I open "CareGiver" app 
	Then I should see "Start Session" start session button 
	When I tap on "Start Session" Begin Session button 
	Then I should see "Check In" Check In page 
	When I click "menu" menu button 
	Then I should see menu_items: 
		| My Customers |
		| My Profile |
		| Tips |
		| Terms and Conditions |
		| Log Out |
	When I tap "Log Out" Logout button 
	Then I should see John Hancock Logo in Launch page