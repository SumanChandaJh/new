@Flyout @Flyout_Claims
Feature: Claim Flyout Content

  @Flyout_Claims_Single_Policy
  Scenario Outline: Verify  content for Customer with Single Policy and SIngle Claim
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Claims" flyout menu item
    Then I see "Claims" flyout page with header as "Claims_Flyout_Header_Text" and sub-header as  "Claims_Flyout_SubHeader_Text"
    And I see sections of all the policies with claims on which "<fullname>" has party role with Policy and Claim Details 

    Examples: User Details
      | fullname                             | username            | password     | 
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |


