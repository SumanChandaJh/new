Feature: Digital Storefront Portal Login

  @Login
  Scenario Outline: Verify access to Digital Storefront Portal
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page

    Examples: 
      | fullname                             | username            | password     |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 |

