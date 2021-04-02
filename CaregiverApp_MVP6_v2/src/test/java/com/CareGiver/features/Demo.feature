@Demo
Feature: Demo

@Demo
Scenario: Login and Logout 

	Given I am registered iusers
	When I open the "Caregiver"  app
	Then app should open up 
	When I input the username 
	And I input password 
	Then Homepage should be displayed
	
	
