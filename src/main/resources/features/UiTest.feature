Feature: UI Test

  Scenario: New user registration
    Given I am on the home page
    When I click on the signup link
    And I enter email and name
    And I click on the signup button
    Then I should be navigated to registration page

#@API
#  Scenario: GET API to retrieve all products list
#    When I send a GET request to retrieve products list
#    Then the response code should be 200
