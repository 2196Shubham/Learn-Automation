Feature: Form Submission

  @SmokeTest
  Scenario: Submit form with valid data
    Given I navigate to "https://testing.qaautomationlabs.com/form.php"
    When I fill the form with the following data:
      | firstName | middleName | lastName | email                | password   | address          | city      | state    | pinCode   |
      | John      | A.         | Doe      | john.doe@email.com   | Pass@123   | 123 Main Street  | New York  | NY       | 10001     |
      | Jane      | B.         | Smith    | jane.smith@email.com | Pass@456   | 456 Oak Avenue   | Toronto   | ON       | M5H 2N2   |
    And I click the submit button
    Then I should see a successful submission message

  @SmokeTest
  Scenario Outline: Submit form with valid data
    Given I navigate to "https://testing.qaautomationlabs.com/form.php"
    When I fill the form with the following data "<firstName>" "<middleName>" "<lastName>" "<email>" "<password>" "<address>" "<city>" "<state>" "<pinCode>"
    And I click the submit button
    Then I should see a successful submission message
    Examples:
      | firstName | middleName | lastName | email                | password | address         | city     | state | pinCode |
      | John      | A.         | Doe      | john.doe@email.com   | Pass@123 | 123 Main Street | New York | NY    | 10001   |
      | Jane      | B.         | Smith    | jane.smith@email.com | Pass@456 | 456 Oak Avenue  | Toronto  | ON    | M5H2N2  |


  @SmokeTestLogin
  Scenario Outline: Login Functionality
    Given Navigate to "https://practicetestautomation.com/practice-test-login/"
    When Login with valid "<email>" "<password>"
    And click on login button
    Then Login successful message
    Examples:
      | email                | password    |
      | student              | Password123 |
      | jane.smith@email.com | Pass@456    |