@ClaimsLayout
Feature: Claims Layout in LTC Digital-Storefront
  I want to see new Claims layout when I select a Claim from flyout

  @TabLayout
  Scenario Outline: Verify new Claims Layout is available
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the  page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Claims" flyout menu item
    Then I see "Claims" flyout page with header as "Claims_Flyout_Header_Text" and sub-header as  "Claims_Flyout_SubHeader_Text"
    When I select claim "<claim>" from available claims list for policy "<policy>"
    Then I see "Claims" layout page with appropriate headers
    When I select "Claim overview" tab
    Then I see "Claim overview" tab with appropriate headers
    When I select "Submit an invoice" tab
    Then I see "Submit an invoice" tab with appropriate headers
    When I select "Payment and invoice history" tab
    Then I see "Payment and invoice history" tab with appropriate headers
    When I select "Approved providers" tab
    Then I see "Approved providers" tab with appropriate headers

    #When I select "Submit documents" tab
    # Then I see "Submit documents" tab with appropriate headers
    Examples: User Details
      | fullname                             | username            | password     | policy  | claim     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 | 4617149 | FIC116080 |

  #| R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 | 10000032 | P16380 |
  @ClaimsOverviewTab
  Scenario Outline: Verify Claims Overview Tab is available
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter <username> in the username field
    And I enter <password> in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Claims" flyout menu item
    Then I see "Claims" flyout page with header as "Claims_Flyout_Header_Text" and sub-header as  "Claims_Flyout_SubHeader_Text"
    When I select a claim from available claims list
    Then I see "Claims" layout page with appropriate headers
    When I select "Claims Overview" tab
    Then I see "Claims Overview" tab with appropriate headers
    And I see Claim Status with Status Effective Date
    And I see list of Authorized Individuals
    And I see a graph of EP Information

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |
