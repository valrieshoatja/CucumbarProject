Feature: User Login Test
  # Positive logins navigate to Learning Materials
  # Negative logins verify login failure

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then login result should be "success"
    When I navigate to learning materials
    Then practice buttons should be visible

    Examples:
      | username         | password    |
      | valrie@gmail.com | @12345678  |

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then login result should be "failure"

    Examples:
      | username         | password    |
      | valrie@gmail.com | wrongpass  |
      | wrong@gmail.com  | @12345678  |
