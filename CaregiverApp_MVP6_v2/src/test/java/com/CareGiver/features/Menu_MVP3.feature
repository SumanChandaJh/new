@MenuPage
Feature: Verification of Menu page
As a CareGiver App User, I want to be able to view Menu within the app

@Regression
@Menu_PageValidation
Scenario: Menu page validation
	When I open CareGiver app

Then I should see John Hancock Logo in Launch page
	When I tap on "prJHLTCProd" button ICP Portal
		 #This is a temporary way to login to CareGiver app
	Then I should see "Independent care provider login" ISAM login page
	When I enter below detail in textbox
		 | Label | Value |
		 | Username | R12NikhilICP |
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
	Then I should see "My Customers" My Customers page
		#land at #TermsAndCondition page in android device
	When I click "menu" menu button
	Then I should see menu_items:
		| My Customers |
		| My Profile |
		| Tips |
		| Terms and Conditions |
		| Log Out | 
		
	