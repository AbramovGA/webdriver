Feature: Bug

  Scenario: bug report scenario
    Given login as "tester1"
    And   click on <Report Issue> button
    And   fill the form
    And   click on <Submit Issue> button
    And   go to view issues page
    When  check for issue report
    Then  logout

    Given login as "dev1"
    And   go to view issues page
    When  check for issue report
    And   open bug page
    And   check all fields
    And   mark the bug as "resolved"
    Then  logout

    Given login as "lead1"
    And   go to view issues page
    When  check for issue report
    And   open bug page
    And   mark the bug as "closed"
    And   go to view issues page
    And   show closed issues
    When  check for issue report
    Then  logout
