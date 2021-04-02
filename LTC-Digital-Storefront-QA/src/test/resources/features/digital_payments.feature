@Digital_Payments
Feature: One Time Payment for my premium
  I want to see premium due and Submit using One Inc Modal for the same.

  @Positive
  Scenario Outline: Submit One Time Payment for my premium
    # Given I am a registered Portal user
    #When I open "Login_Page_URL" for Digital Storefront Portal
    #Then I see "John_Hancock_Title" as title of the  page
    # When I enter "<username>" in the username field
    # And I enter "<password>" in password field
    # And I click on "login" button
    When I login to LTC DIgital Sorefront via Backoffice with user "<fullname>"
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Premiums" flyout menu item
    Then I see "Premiums" flyout page with header as "Premiums_Header_Text" and sub-header as  "Premiums_SubHeader_Text"
    Then I click on View Premiums link for the given "<policy>" to navigate to Premiums page
    And I see "Premium Payments" layout page with appropriate headers
    And I see Premium Amount due as "<Amount_Due>"
    And I see Premium Amount due date as "<Amount_Due_Date>"
    And I see Premium Amount frequency as "<Payment_Frequency>"
    When I click on link to view amount due details
    Then I see Premium Amount as "<Premium_Amount>"
    And I see Premium Amount received as "<Payment_Received>"
    And I see net amount due as "<Amount_Due>"
    And I see One-Time Payment Card with header as "ONE_TIME_PAYMENT_CARD_HEADER_TEXT" and content as "ONE_TIME_PAYMENT_CARD_CONTENT"
    When I click on One-Time Payment Card link
    Then I see Terms of Use Modal Window with appropriate headers ans content
    When I click to agree to terms of use checkbox
    And I click on Submit button on terms of use modal window
    And I wait for One Inc Payment Modal window to display for "5" seconds
    Then I see "Step 1 of 3" screen of One Inc Modal Window with appropriate fields
    When I click on "Continue" button of One Inc Modal Window
    Then I see "Step 2 of 3" screen of One Inc Modal Window with appropriate fields
    When I enter "" in routing number field
    And I enter "" in Account Number field
    And I enter "" in Repeat Account Number field
    And I click on "Continue" button of One Inc Modal Window
    Then I see "Step 3 of 3" screen of One Inc Modal Window with appropriate fields
    And I click on "Submit" button of One Inc Modal Window
    Then I see "Confirmation" screen of One Inc Modal Window with appropriate fields
    And I click to download the Print Receipt
    And I close the One Inc Modal Window

    Examples: User Details
      | fullname                           | username      | password | policy  | Premium_Amount | Payment_Received | Amount_Due | Amount_Due_Date | Payment_Frequency |
      | R13Insured_Sachin R13Insured_Rajan | R13SachinUser | Password | 9245999 | $3,531.03      | $3,428.19        | $102.84    | July 06, 2020   | Semi-annually     |
