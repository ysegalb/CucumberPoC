Feature: test google behavior
  Just tests if google works as expected

  Scenario: feeling lucky
    Given the home page of google
    When the user searches SOMETHING
    And feels lucky
    Then the user is redirected to the first result

  Scenario: not feeling lucky
    Given the home page of google
    When the user searches SOMETHING
    And wants full results
    Then the user is redirected to the results page