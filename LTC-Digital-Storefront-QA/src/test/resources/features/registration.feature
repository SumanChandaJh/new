@Registration
Feature: Customer Registration
  I want to register as an authorised portal user.

  @Positive @Insured
  Scenario Outline: Successful Registration Attempt as an Insured
    When I open "Customer_Registration_Page_URL" for Digital Storefront Portal
    Then I see "Customer_Registration_Page_Title" as title of the Registration page
    When I select role as "Insured"
    And I enter "<Policy Number>" as Policy Number
    And I enter "<Insured First Name>" as Insured First Name
    And I enter "<Insured Last Name>" as Insured Last Name
    And I enter "<Date of Birth>" as Insured Date of Birth
    And I enter "<SSN>" as Insured SSN last 4 digits
    And I enter "<Daytime Phone Number>" as Insured Daytime Phone Number
    And I enter "<Email address>" as email address
    And I enter "<Email address>" as confirm email address
    And I enter "<Username>" as Username
    And I enter "<Password>" as Password
    And I enter "<Password>" as Confirm Password
    #And I select "<Security Question 1>" as Security Question 1
    And I enter "<Security Answer 1>" as Security Answer 1
    #And I select "<Security Question 2>" as Security Question 2
    And I enter "<Security Answer 1>" as Security Answer 2
    #And I select "<Security Question 3>" as Security Question 3
    And I enter "<Security Answer 1>" as Security Answer 3
    And I click on Submit button
    Then I see the message for successful registration

    Examples: Insured Details
      | Policy Number | Insured First Name | Insured Last Name | Date of Birth | SSN  | Daytime Phone Number | Email address                     | Username        | Password  | Security Question 1 | Security Answer 1 | Security Question 2 | Security Answer 2 | Security Question 3 | Security Answer 3 |
      # |        123456 | Sachin             | Rajan             | 07/12/1993    | 1234 |           1234567890 | ltcportal.user+2501701@gmail.com | R25InsuredSachin  | Temp@#123 |                   2 | test              |                   2 | test              |                   2 | test              |
      # |      10172933 | James              | Moeller           | 10/20/1962    | 1128 |           1234567890 | ltcportal.user+25010041@gmail.com | R25InsuredMoeller   | Temp@#123 |                   2 | test              |                   2 | test              |                   2 | test              |
      # |       4080555 | Joan               | Norman            | 01/30/1933    | 6705 |           1234567890 | ltcportal.user+25010042@gmail.com | R25InsuredNorman | Temp@#123 |                   2 | test              |                   2 | test              |                   2 | test              |
      # |       7172752 | Carol              | Townsend          | 10/27/1937    | 1090 |           1234567890 | ltcportal.user+25010043@gmail.com | R25InsuredTownsend | Temp@#123 |                   2 | test              |                   2 | test              |                   2 | test              |
      # |       7206990 | Stephanie          | Rogall            | 09/08/1941    | 6769 |           1234567890 | ltcportal.user+25010044@gmail.com | R25InsuredRogall | Temp@#123 |                   2 | test              |                   2 | test              |                   2 | test              |
      # |       5802458 | Arthur             | Helm              | 05/29/1948    | 2011 |           1234567890 | ltcportal.user+25010045@gmail.com | R25InsuredHelm  | Temp@#123 |                   2 | test              |                   2 | test              |                   2 | test              |
      |       9319700 | Robert             | Mazur             | 01/28/1925    | 6660 |           1234567890 | ltcportal.user+25010046@gmail.com | R25InsuredMazur | Temp@#123 |                   2 | test              |                   2 | test              |                   2 | test              |

  @Positive @LegalRepresentative @HIPAAAuthorized @POA
  Scenario Outline: Successful Registration Attempt as an Legal Representative/HIPAA Authorized
    When I open "Customer_Registration_Page_URL" for Digital Storefront Portal
    Then I see "Customer_Registration_Page_Title" as title of the Registration page
    When I select role as "Legal Representative/HIPAA Authorized"
    And I enter "" as Registrant First Name
    And I enter "" as Registrant Last Name
    And I enter "<Policy Number>" as Policy Number
    And I enter "<Insured First Name>" as Insured First Name
    And I enter "<Insured Last Name>" as Insured Last Name
    And I enter "<Date of Birth>" as Insured Date of Birth
    And I enter "<SSN>" as Insured SSN last 4 digits
    And I enter "<Daytime Phone Number>" as Insured Daytime Phone Number
    And I enter "<Email address>" as email address
    And I enter "<Confirm email address>" as confirm email address
    And I enter "<Username>" as Username
    And I enter "<Password>" as Password
    And I enter "<Password>" as Confirm Password
    And I select "<Security Question 1>" as Security Question 1
    And I enter "<Security Answer 1>" as Security Answer 1
    And I select "<Security Question 2>" as Security Question 2
    And I enter "<Security Answer 1>" as Security Answer 2
    And I select "<Security Question 3>" as Security Question 3
    And I enter "<Security Answer 1>" as Security Answer 3
    And I click on Submit button
    Then I see the message for successful registration

    Examples: Insured Details
      | Policy Number | Insured First Name | Insured Last Name | Date of Birth | SSN       | Daytime Phone Number | Email address | Confirm email address | Username | Username | Password | Security Question 1 | Security Answer 1 | Security Question 2 | Security Answer 2 | Security Question 3 | Security Answer 3 |
      | NA            | NA                 |           1354999 | $3,787.87     | $1,893.94 | $1,893.94            | $1,893.93     | June 20, 2020         | Annually |          |          |                     |                   |                     |                   |                     |                   |
