Feature: Premiums Page Contents 

@Premiums_Page
Scenario Outline: Verify premium page as displayed to customer 

	Given I am a registered Portal user 
	When I open "Login_Page_URL" for Digital Storefront Portal 
	Then I see "John_Hancock_Title" as title of the page 
	When I enter "<username>" in the username field 
	And I enter "<password>" in password field 
	And I click on "login" button 
	Then I see "LTC_Digital_Storefront_Home_icon" on the page 
	#And I see my fullname as "<fullname>" in the header of the page 
	When I hover over the "Premiums" flyout menu item 
	#Then I see "Premiums" flyout page with header as "Premiums_Header_Text" and sub-header as  "Premiums_SubHeader_Text" 
	And I click on View Premiums link for the given "<policy>" to navigate to Premiums page
	Then I validate Premiums table for "<policy>" and "<payment year>"
	
	Examples: User Details 
		|fullname								|username		 |password	|policy  |payment year|
		|R15Insured_Henry	R15Insured_Nicholls	|R21InsuredHenry |Temp@#123	|10000106|2017|
		
		
		
		