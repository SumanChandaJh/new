#Author: rajansa
#Feature: Verification of group Passcode Generation Page
@GROUP_PASSCODE
Feature: Submit Passcode request for customers without SSN in LTC Digital-Storefront
  I want to see new Passcode request layout and submit a request for the same.

  @SMOKE
  Scenario: Verify layout for Passcode request Page
    When I open "GROUP_PASSCODE_REQUEST_URL" for Digital Storefront Portal
    Then I see the page header as "GROUP_PASSCODE_REQUEST_HEADER_TEXT"
    And I see the content of header as "GROUP_PASSCODE_REQUEST_HEADER_CONTENT"
    And I see a card with title "NEED_PASSCODE_CARD_TITLE" with content as "NEED_PASSCODE_CARD_CONTENT" and with link "NEED_PASSCODE_CARD_LINK"
    And I see a card with title "HAVE_PASSCODE_CARD_TITLE" with content as "HAVE_PASSCODE_CARD_CONTENT" and with link "HAVE_PASSCODE_CARD_LINK"

  @POSITIVE
  Scenario Outline: Verify successful Submission for Passcode request Page
    When I open "GROUP_PASSCODE_REQUEST_URL" for Digital Storefront Portal
    Then I see the page header as "GROUP_PASSCODE_REQUEST_HEADER_TEXT"
    And I see the content of header as "GROUP_PASSCODE_REQUEST_HEADER_CONTENT"
    And I see a card with title "NEED_PASSCODE_CARD_TITLE" with content as "NEED_PASSCODE_CARD_CONTENT" and with link "NEED_PASSCODE_CARD_LINK"
    When I click on "NEED_PASSCODE_CARD_LINK"
    Then I see a Group Passcode Form fields
    When I enter Passcode Requester first name as "<FIRST_NAME>"
    When I enter Passcode Requester last name as "<LAST_NAME>"
    When I enter Passcode Requester policy number as "<POLICY_NUMBER>"
    When I enter Passcode Requester date of birth as "<DATE_OF_BIRTH>"
    When I click on "SUBMIT_REQUEST_LINK"
    Then I see a popup message for "CONFIRM_PASSCODE_CHANGE"
    When I click on "CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK"
    Then I see an alert message for "GROUP_PASSCODE_REQUEST_PASS"

    Examples: User Details
      | FIRST_NAME      | LAST_NAME         | POLICY_NUMBER | DATE_OF_BIRTH |
      | R15Insured_Adil | R15Insured_Rashid |       7039122 | 10/28/1940    |

  @NEGATIVE @INCORRECT_LAST_NAME
  Scenario Outline: Verify Submission for Incorrect Last Name
    When I open "GROUP_PASSCODE_REQUEST_URL" for Digital Storefront Portal
    Then I see the page header as "GROUP_PASSCODE_REQUEST_HEADER_TEXT"
    And I see the content of header as "GROUP_PASSCODE_REQUEST_HEADER_CONTENT"
    And I see a card with title "NEED_PASSCODE_CARD_TITLE" with content as "NEED_PASSCODE_CARD_CONTENT" and with link "NEED_PASSCODE_CARD_LINK"
    When I click on "NEED_PASSCODE_CARD_LINK"
    Then I see a Group Passcode Form fields
    When I enter Passcode Requester first name as "<FIRST_NAME>"
    When I enter Passcode Requester last name as "<LAST_NAME>"
    When I enter Passcode Requester policy number as "<POLICY_NUMBER>"
    When I enter Passcode Requester date of birth as "<DATE_OF_BIRTH>"
    When I click on "SUBMIT_REQUEST_LINK"
    Then I see a popup message for "CONFIRM_PASSCODE_CHANGE"
    When I click on "CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK"
    Then I see an alert message for "GROUP_PASSCODE_REQUEST_FAIL"

    Examples: User Details
      | FIRST_NAME      | LAST_NAME          | POLICY_NUMBER | DATE_OF_BIRTH |
      | R15Insured_Adil | WRONG_LAST_NAME    |       7039122 | 10/28/1940    |
      | R15Insured_Adil | R15insured_Malinga |       7039122 | 10/28/1940    |

  @NEGATIVE @INCORRECT_POLICY_NUMBER
  Scenario Outline: Verify Submission for Incorrect Policy Number
    When I open "GROUP_PASSCODE_REQUEST_URL" for Digital Storefront Portal
    Then I see the page header as "GROUP_PASSCODE_REQUEST_HEADER_TEXT"
    And I see the content of header as "GROUP_PASSCODE_REQUEST_HEADER_CONTENT"
    And I see a card with title "NEED_PASSCODE_CARD_TITLE" with content as "NEED_PASSCODE_CARD_CONTENT" and with link "NEED_PASSCODE_CARD_LINK"
    When I click on "NEED_PASSCODE_CARD_LINK"
    Then I see a Group Passcode Form fields
    When I enter Passcode Requester first name as "<FIRST_NAME>"
    When I enter Passcode Requester last name as "<LAST_NAME>"
    When I enter Passcode Requester policy number as "<POLICY_NUMBER>"
    When I enter Passcode Requester date of birth as "<DATE_OF_BIRTH>"
    When I click on "SUBMIT_REQUEST_LINK"
    Then I see a popup message for "CONFIRM_PASSCODE_CHANGE"
    When I click on "CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK"
    Then I see an alert message for "GROUP_PASSCODE_REQUEST_FAIL"

    Examples: User Details
      | FIRST_NAME      | LAST_NAME         | POLICY_NUMBER       | DATE_OF_BIRTH |
      | R15Insured_Adil | R15Insured_Rashid | WRONG_POLICY_NUMBER | 10/28/1940    |
      | R15Insured_Adil | R15Insured_Rashid |            10429051 | 10/28/1940    |

  @NEGATIVE @INCORRECT_DATE_OF_BIRTH
  Scenario Outline: Verify Submission for Incorrect Date of Birth
    When I open "GROUP_PASSCODE_REQUEST_URL" for Digital Storefront Portal
    Then I see the page header as "GROUP_PASSCODE_REQUEST_HEADER_TEXT"
    And I see the content of header as "GROUP_PASSCODE_REQUEST_HEADER_CONTENT"
    And I see a card with title "NEED_PASSCODE_CARD_TITLE" with content as "NEED_PASSCODE_CARD_CONTENT" and with link "NEED_PASSCODE_CARD_LINK"
    When I click on "NEED_PASSCODE_CARD_LINK"
    Then I see a Group Passcode Form fields
    When I enter Passcode Requester first name as "<FIRST_NAME>"
    When I enter Passcode Requester last name as "<LAST_NAME>"
    When I enter Passcode Requester policy number as "<POLICY_NUMBER>"
    When I enter Passcode Requester date of birth as "<DATE_OF_BIRTH>"
    When I click on "SUBMIT_REQUEST_LINK"
    Then I see a popup message for "CONFIRM_PASSCODE_CHANGE"
    When I click on "CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK"
    Then I see an alert message for "GROUP_PASSCODE_REQUEST_FAIL"

    Examples: User Details
      | FIRST_NAME      | LAST_NAME         | POLICY_NUMBER | DATE_OF_BIRTH |
      | R15Insured_Adil | R15Insured_Rashid |       7039122 | 10/28/1941    |

  @NEGATIVE @INVALID_ATTEMPT
  Scenario Outline: Verify Submission for Invalid Attempt after 6 times
    When I open "GROUP_PASSCODE_REQUEST_URL" for Digital Storefront Portal
    Then I see the page header as "GROUP_PASSCODE_REQUEST_HEADER_TEXT"
    And I see the content of header as "GROUP_PASSCODE_REQUEST_HEADER_CONTENT"
    And I see a card with title "NEED_PASSCODE_CARD_TITLE" with content as "NEED_PASSCODE_CARD_CONTENT" and with link "NEED_PASSCODE_CARD_LINK"
    When I click on "NEED_PASSCODE_CARD_LINK"
    Then I see a Group Passcode Form fields
    When I enter Passcode Requester first name as "<FIRST_NAME>"
    When I enter Passcode Requester last name as "<LAST_NAME>"
    When I enter Passcode Requester policy number as "<POLICY_NUMBER>"
    When I enter Passcode Requester date of birth as "<DATE_OF_BIRTH>"
    When I click on "SUBMIT_REQUEST_LINK"
    Then I see a popup message for "CONFIRM_PASSCODE_CHANGE"
    When I click on "CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK"
    Then I see an alert message for "GROUP_PASSCODE_REQUEST_INVALID"

    Examples: User Details
      | FIRST_NAME      | LAST_NAME         | POLICY_NUMBER | DATE_OF_BIRTH |
      | R15Insured_Adil | R15Insured_Rashid |       7039122 | 10/28/1941    |
