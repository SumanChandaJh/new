@Flyout
Feature: Policy Flyout Content

  @Flyout_Policies
  Scenario Outline: Verify policy flyout content for Customer with Single Policy
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Policies" flyout menu item
    Then I see "Policies" flyout page with header as "Policy_Flyout_Header_Text" and sub-header as  "Policy_Flyout_SubHeader_Text"
    And I see sections of all the Policies on which "<fullname>" has party roles with Policy Number, Status and View Details Link

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |

  Scenario Outline: Verify policy flyout content for Customer with Dual Policy Roles
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Policies" flyout menu item
    Then I see "Policies" flyout page with header as "Policy_Flyout_Header_Text" and sub-header as  "Policy_Flyout_SubHeader_Text"
    And I see sections of all the Policies on which "<fullname>" has party roles with Policy Number, Status and View Details Link

    Examples: User Details
      | fullname                       | username         | password     |
      | R15insured_Kl R15insured_Rahul | SIT6R15InsuredKL | Password@123 |
