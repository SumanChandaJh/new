@ContactUs
Feature: Contact Us Page Contents

  Scenario Outline: Verify contact us page content as displayed to customer
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
    When I click on the quick link "Contact_Us_Need_Help_Link_Text"
    Then I see a header as "Contact_Us_Page_Header_Text" and sub-header as "Contact_Us_Page_SubHeader_Text"
    And I see a section in the page with a header as "Contact_Us_Page_Section1_Header1_Text"
    And I see a phone number as "Contact_Us_Page_Section1_Header1_Phone" below the header in the same section
    And I see a fax number as "Contact_Us_Page_Section1_Header1_Fax" below the phone number
    And I see texts as "Contact_Us_Page_Section1_Header1_TextMessage1" and "Contact_Us_Page_Section1_Header1_TextMessage2" below the fax number
    And I see another header as "Contact_Us_Page_Section1_Header2_Text" on the right side of the page
    And I see another phone number as "Contact_Us_Page_Section1_Header2_Phone" below the above header
    And I see texts as "Contact_Us_Page_Section1_Header2_TextMessage1" and "Contact_Us_Page_Section1_Header2_TextMessage2" below the above phone number
    And I see mailing address header as "Contact_Us_Page_Section2_Mail" in the below section having address details as "Contact_Us_Page_Section2_Mail_Address_Line1" and "Contact_Us_Page_Section2_Mail_Address_Line2" and "Contact_Us_Page_Section2_Mail_Address_Line3"

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |
