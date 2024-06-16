Feature: Retrieve Products List, search for a product

  Scenario: GET API to retrieve all products list
    When I send a GET request to retrieve products list
    Then the response code should be 200
    And the response should contain all products list



  Scenario: POST API to search for a product
    When I send a POST request to search for the product "<Blue Top>"
    Then the response code should be 200
    And the response should contain the searched product "Blue Top"