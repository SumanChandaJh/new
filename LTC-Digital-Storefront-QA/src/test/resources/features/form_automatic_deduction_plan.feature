@AutomaticDeductionPlanForm
Feature: Automatic Deduction Plan Form in LTC Digital-Storefront
  I want to see new Automatic Deduction Plan Form and Submit a request for the same.

  @FormFields
  Scenario Outline: Verify Automatic Deduction Plan Form Fields
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
    Then I see "Automatic Deduction Plan" card with expected contents and link
    When I select "Automatic Deduction Plan" card
    Then I see "Automatic Deduction Plan" form with appropriate headers
    And I all the fields for "Automatic Deduction Plan" are available

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |

  @ErrorValidations
  Scenario Outline: Verify Error Messages in Automatic Deduction Plan Form
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
    #And I select "<claim>" from claim selector
    Then I see "Automatic Deduction Plan" card with expected contents and link
    When I select "Automatic Deduction Plan" card
    Then I see "Automatic Deduction Plan" form with appropriate headers
    And I all the fields for "Automatic Deduction Plan" are available
    #When I fill in the "Automatic Deduction Plan" form
    And I upload the the supporting documents with name "<attachment_name>"
    And click on "Submit" button
    Then I see error message of "<error_message>" for the empty fields

    Examples: User Details
      | fullname                             | username            | password     | policy  | attachment_name |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 | 4617149 | 3.5MB_JPG.jpg   |

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
    Then I see "Automatic Deduction Plan" card with expected contents and link
    When I select "Automatic Deduction Plan" card
    Then I see "Automatic Deduction Plan" form with appropriate headers
    And I all the fields for "Automatic Deduction Plan" are available
    When I fill in the "Automatic Deduction Plan" form 
    And click on "Submit" button
    Then I see message of successful "Legal Representative" form submission

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |
