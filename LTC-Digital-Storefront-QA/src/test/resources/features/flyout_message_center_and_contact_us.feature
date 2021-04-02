@Flyout
Feature: Contact Us Flyout Contents

  @Flyout_ContactUs
  Scenario Outline: Verify contact us flyout content as displayed to customer
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I hover over the "Contact Us" flyout menu item
    Then I see "Contact Us" flyout page with header as "Contact_Us_Header_Text" and sub-header as  "Contact_Us_SubHeader_Text"
    And I see a section with header "Contact_Us_Quick_Links_Header_Text"
    And I see quick links of "Contact_Us_View_FAQs_Link_Text" and "Contact_Us_Ask_Question_Link_Text" in the section
    And I see a section with header "Contact_Us_Need_Help_Header_Text"
    And I see quick link "Contact_Us_Need_Help_Link_Text" in the section

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |

  @Flyout_MessageCenter
  Scenario Outline: Verify message center flyout content as displayed to customer
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
    And I see quick link "Message_Center_Link_Text" in the section

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |

  @AskQuestion_MessageCenter @ActiveClaim
  Scenario Outline: Verify Ask a Question feature for a customer
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
    And I see quick link "Message_Center_Link_Text" in the section
    When I click on the quick link "Message_Center_Link_Text"
    Then I see a header as "Message_Center_Page_Header_Text" and sub-header as "Message_Center_Page_SubHeader_Text"
    And I see five quick links as "Message_Center_Page_Section2_LinkText1" and "Message_Center_Page_Section2_LinkText2" and "Message_Center_Page_Section2_LinkText3" and "Message_Center_Page_Section2_LinkText4" and "Message_Center_Page_Section2_LinkText5" below the above one
    When I click on the quick link "Message_Center_Page_Section2_LinkText2"
    Then I see a header as "Message_Center_Page_Ask_Question_Link_Header" and sub-header as "Message_Center_Page_Ask_Question_Link_SubHeader"
    And I see a drop down below the above which i click and select the "<category>"
    Then I see a header as "Message_Center_Page_Ask_Question_Policy_Header"
    And below the policy header I see a policy drop down which I click and select the "<policy>"
    Then I see a header as "Message_Center_Page_Ask_Question_Claim_Header"
    And below the claim header I see a claim drop down which I click and select the "<claim>"
    Then I see a header as "Message_Center_Page_Ask_Question_Question_Header"
    And below I see a textarea where I post the "<question>"
    Then I click on the "Message_Center_Page_Ask_Question_Submit_Button"
    When the question is submitted  I get a confirmation with a header as "Message_Center_Page_Ask_Question_Confirmation_Header" and message as "Message_Center_Page_Ask_Question_Confirmation_Message"

    Examples: User Details
      | fullname                             | username            | password     | category | policy                             | claim               | question                 |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 | Group 1  | R15insured_Matt's Policy: 10000032 | P16380 - Terminated | What is my Claim Amount? |
