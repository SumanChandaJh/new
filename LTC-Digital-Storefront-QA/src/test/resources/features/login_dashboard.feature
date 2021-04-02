@MyDashboardLogin
Feature: Digital Storefront Dashboard Login

  ####################################################################################################
  @STAGE @MyDashboardViaDashboardURL @UserWithOnlyLTCPolicy
  Scenario Outline: Verify_access_to_My_Dashboard_for_user_with_only_LTC_Policy
    Given I am a registered Portal user
    When I open "DASHBOARD_LOGIN_URL" for Digital Storefront Portal
    Then I see "MyDashboard_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "My_Dashboard_Home_Icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    And I see card to manage my policies for my "LTC" policies

    Examples: 
      | fullname   | username      | password       |
      | JOY DUMONT | HCDInsuredJoy | Temp@&hash;123 |

  @STAGE @MyDashboardViaDashboardURL @UserWithLifeAndLTCPolicies
  Scenario Outline: Verify_access_to_My_Dashboard_for_user_with_both_LTC_and_Life_Policy
    Given I am a registered Portal user
    When I open "DASHBOARD_LOGIN_URL" for Digital Storefront Portal
    Then I see "MyDashboard_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "My_Dashboard_Home_Icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    And I see card to manage my policies for my "LTC" policies
    And I see card to manage my policies for my "Life" policies

    Examples: 
      | fullname      | username               | password       |
      | William Brown | RHCDInsuredWilliam1109 | Temp@&hash;123 |

  ####################################################################################################
  @STAGE @MyDashboardViaLTC @UserWithOnlyLTCPolicy
  Scenario Outline: Verify_Dashboard_Access_Via_LTC_URL_OnlyLTCPolicy
    Given I am a registered Portal user
    When I open "LTC_LOGIN_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Old_Customer_Portal_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I select My Dashboard tab
    Then I see "My_Dashboard_Home_Icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    And I see card to manage my policies for my "LTC" policies

    Examples: 
      | fullname   | username      | password       |
      | JOY DUMONT | HCDInsuredJoy | Temp@&hash;123 |

  @STAGE @MyDashboardViaLTC @UserWithLifeAndLTCPolicies
  Scenario Outline: Verify_Dashboard_Access_Via_LTC_URL_LifeAndLTCPolicies
    Given I am a registered Portal user
    When I open "STAGE_LTC_LOGIN_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Old_Customer_Portal_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I select My Dashboard tab
    Then I see "My_Dashboard_Home_Icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    And I see card to manage my policies for my "LTC" policies

    Examples: 
      | fullname      | username               | password       |
      | William Brown | RHCDInsuredWilliam1109 | Temp@&hash;123 |

  ####################################################################################################
  @PROD @PreDeployment
  Scenario Outline: Verify_access_to_My_Dashboard_for_Production_User
    Given I am a registered Portal user
    When I open "PRODUCTION_SF_Login_Page_URL" for Digital Storefront Portal
    Then I see "PRODUCTION_SF_Title" as title of the page
    When I enter SF username "daniel@3mail.com" in username field
    When I enter SF password "testuser02" in password field
    And I click on SF Login button
    #When I enter "<username>" in the username field
    # And I enter "<password>" in password field
    #And I click on "login" button
    Then I see "My_Dashboard_Home_Icon" on the page
    And I see my fullname as "Daniel Benutzer" in the header of the page
    And I see card to manage my policies for my "Error" policies

    Examples: 
      | fullname     | username        | password       |
      | Linda Jahnke | HCDInsuredLinda | Temp@&hash;123 |

  ####################################################################################################
  @PROD @MyDashboardViaLTC
  Scenario Outline: Verify_access_to_My_Dashboard_via_LTC_Portal
    Given I am a registered Portal user
    When I open "PRODUCTION_LTC_LOGIN_URL" for Digital Storefront Portal
    Then I see "John_Hancock_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "LTC_Old_Customer_Portal_Home_icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    When I select My Dashboard tab
    Then I see "My_Dashboard_Home_Icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    And I see card to manage my policies for my "LTC" policies

    Examples: 
      | fullname      | username    | password     |
      | Lglrep Doedoe | ltclegalrep | Jan2021@1234 |

  @PROD @MyDashboardViaDashboardURL
  Scenario Outline: Verify_access_to_My_Dashboard_via_Dashboard_URL
    Given I am a registered Portal user
    When I open "PRODUCTION_DASHBOARD_LOGIN_URL" for Digital Storefront Portal
    Then I see "MyDashboard_Title" as title of the page
    When I enter "<username>" in the username field
    And I enter "<password>" in password field
    And I click on "login" button
    Then I see "My_Dashboard_Home_Icon" on the page
    And I see my fullname as "<fullname>" in the header of the page
    And I see card to manage my policies for my "LTC" policies

    Examples: 
      | fullname          | username    | password     |
      | TestUser TestUser | ltclegalrep | Jan2021@1234 |
