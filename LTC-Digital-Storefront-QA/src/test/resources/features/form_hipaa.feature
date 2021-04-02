@HIPAA_Form
Feature: HIPAA Form in LTC Digital-Storefront
  I want to see new HIPAA Form and Submit a request for the same.

  @FormFields
  Scenario Outline: Verify HIPAA Form Fields
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
    Then I see "HIPAA" card with expected contents and link
    When I select "HIPAA" card
    Then I see "HIPAA" form with appropriate headers
    And I all the fields for "HIPAA" are available

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |

  @SubmitForm
  Scenario Outline: Submit Legal Representative Form
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
    When I select "Legal Representative" card
    Then I see "Legal Representative" form with appropriate headers
    And I all the fields for "Legal Representative" are available
    When I fill in the "Legal Representative" form
    And click on "Submit" button
    Then I see message of successful "Legal Representative" form submission

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |
