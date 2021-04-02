@SubmitInvoice
Feature: Submit Invoice form in LTC Digital-Storefront
  I want to see new Submit invoice layout and Submit a request for the same.

  @NursingHome
  Scenario Outline: Submit Invoice Form - Nuursing Home - With Individual Charges
    Given I am a registered Portal user
    #When I open "Login_Page_URL" for Digital Storefront Portal
    #Then I see "John_Hancock_Title" as title of the  page
    # When I enter "<username>" in the username field
    # And I enter "<password>" in password field
    # And I click on "login" button
    When I login to LTC DIgital Sorefront via Backoffice with user "<fullname>"
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Claims" flyout menu item
    Then I see "Claims" flyout page with header as "Claims_Flyout_Header_Text" and sub-header as  "Claims_Flyout_SubHeader_Text"
    When I select claim "<claim>" from available claims list for policy "<policy>"
    Then I see "Claims" layout page with appropriate headers
    When I select "Submit an invoice" tab
    Then I see "Submit an invoice" tab with appropriate headers
    When I select provider of type "<provider_type>"
    And I fill submit invoice form for "<provider_type>"

    #And I click on the submit button
    #Then I see message of successful "Submit Invoice" form submission
    Examples: User Details
      | fullname                              | username               | password       | policy  | claim     | provider_type |
      | R15Insured_Yuvendra R15Insured_Chahal | SIT6R15InsuredYuvendra | Temp@&hash;124 | 9496005 | R14010308 | Nursing Home  |
      
  @AssistedLivingFacility
  Scenario Outline: Submit Invoice Form - Assisted Living Facility - With Individual Charges
    Given I am a registered Portal user
    #When I open "Login_Page_URL" for Digital Storefront Portal
    #Then I see "John_Hancock_Title" as title of the  page
    # When I enter "<username>" in the username field
    # And I enter "<password>" in password field
    # And I click on "login" button
    When I login to LTC DIgital Sorefront via Backoffice with user "<fullname>"
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Claims" flyout menu item
    Then I see "Claims" flyout page with header as "Claims_Flyout_Header_Text" and sub-header as  "Claims_Flyout_SubHeader_Text"
    When I select claim "<claim>" from available claims list for policy "<policy>"
    Then I see "Claims" layout page with appropriate headers
    When I select "Submit an invoice" tab
    Then I see "Submit an invoice" tab with appropriate headers
    When I select provider of type "<provider_type>"
    And I fill submit invoice form for "<provider_type>"

    #And I click on the submit button
    #Then I see message of successful "Submit Invoice" form submission
    Examples: User Details
      | fullname                              | username               | password       | policy  | claim     | provider_type |
      | R15Insured_Yuvendra R15Insured_Chahal | SIT6R15InsuredYuvendra | Temp@&hash;124 | 9496005 | R14010308 | Assisted Living Facility  |
