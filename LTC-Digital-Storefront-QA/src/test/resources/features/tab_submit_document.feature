@SubmitDocumentCards
Feature: Submit Document Tab in LTC Digital-Storefront
  I want to see new Submit Document Tab with cards for document submission

  @RetailPolicyActiveClaimCards
  Scenario Outline: Verify Submit Dcoument Cards for Retail Policy
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Message Center" flyout menu item
    Then I see "Message Center" flyout page with header as "Message_Center_Header_Text" and sub-header as  "Message_Center_SubHeader_Text"
    When I click on Message Center Link from flyout
    Then I see "Message Center" layout page with appropriate headers
    When I select "Submit Document" tab
    Then I see "Submit Document" tab with appropriate headers
    When I select "<policy>" from policy selector
    And I select "<claim>" from claim selector
    Then I see "Legal Representative" card with expected contents and link
    And I see "HIPAA" card with expected contents and link
    And I see "Automatic Deduction Plan" card with expected contents and link
    And I see "Direct Deposit" card with expected contents and link
    And I see "Assignment Of Benefits" card with expected contents and link
    And I see "Death Certificate" card with expected contents and link

    Examples: User Details
      | fullname                             | username            | password     | policy  |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 | 4617149 |

  @GroupPolicyActiveClaimCards
  Scenario Outline: Verify Submit Dcoument Cards for Group Policy
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Message Center" flyout menu item
    Then I see "Message Center" flyout page with header as "Message_Center_Header_Text" and sub-header as  "Message_Center_SubHeader_Text"
    When I click on Message Center Link from flyout
    Then I see "Message Center" layout page with appropriate headers
    When I select "Submit Document" tab
    Then I see "Submit Document" tab with appropriate headers
    When I select "<policy>" from policy selector
    # And I select "<claim>" from claim selector
    Then I see "Legal Representative" card with expected contents and link
    And I see "HIPAA" card with expected contents and link
    And I see "Automatic Bank Withdrawl" card with expected contents and link
    And I see "Direct Deposit" card with expected contents and link
    And I see "Assignment Of Benefits" card with expected contents and link
    And I see "Death Certificate" card with expected contents and link

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |
