@FlyoutMenuVisibility
Feature: Flyout Menu Items Visibility

  @FlyoutMenu_Insured
  Scenario Outline: Verify flyout menus as displayed to Insured
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page

    Examples: 
      | fullname                             | username            | password     | role  |
      | R15Insured_Jonny R15Insured_Bairstow | SIT6R15InsuredJonny | Password@123 | HIPAA |

  @FlyoutMenu_POA
  Scenario Outline: Verify flyout menus as displayed to Legal Representative
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page

    Examples: 
      | fullname                               | username           | password     |
      | R15LegalRep_Jasprit R15LegalRep_Bumrah | R15LegalRepJasprit | Password@123 |

  @FlyoutMenu_HIPAA
  Scenario Outline: Verify flyout menus as displayed to HIPAA
    Given I am a registered Portal user
    When I open "Login_Page_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Digital_Storefront_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page

    Examples: 
      | fullname                     | username         | password     |
      | R15HIPAA_Aron R15HIPAA_Finch | SIT6R15HIPAAAron | Password@123 |
