@TabLayout
Feature: Message Center Layout in LTC Digital-Storefront
  I want to see new Message Center layout when I select Message Center link from flyout

  @MessageCenterTabLayout
  Scenario Outline: Verify new Message Center Layout is available
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
    When I select "Inbox" tab
    Then I see "Inbox" tab with appropriate headers
    When I select "Ask A Question" tab
    Then I see "Ask A Question" tab with appropriate headers
    When I select "Submit Document" tab
    Then I see "Submit Document" tab with appropriate headers
    When I select "Document History" tab
    Then I see "Document History" tab with appropriate headers
    When I select "Tax Forms" tab
    Then I see "Tax Forms" tab with appropriate headers

    Examples: User Details
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |
