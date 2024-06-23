@API
Feature: Perform GER,POST,PUT AND DELETE Request

  Scenario: Perform a GET request to retrieve all products list
    Given I set the base URL to "https://automationexercise.com/api"
    When I perform a GET request to "/productsList"
    Then the response code should be 200
    And the response should contain all products list


  Scenario: Perform a POST request to search for a product
    When I send a POST request to search for the product "<Blue Top>"
    Then the response code should be 200
    And the response should contain the searched product "Blue Top"

  @Test
  Scenario: Perform a GET request to retrieve brand list
    Given I set the base URL to "https://automationexercise.com/api"
    When I perform a GET request to "/brandsList"
    Then the response status code should be 200
    And the response body should contain brand with value "Polo"

  @Test
  Scenario: Perform a POST request to create login data
    Given I set the base URL to "https://automationexercise.com/api"
    When I perform a POST request to "/verifyLogin" with body'{"email": "Albertom@sgm.com","password": "Albertomo"}'
    Then the response status code should be 200
    And the response body should show message "User exists!"

  @Test
  Scenario: Perform a POST request to create data
    Given I set the base URL to "https://automationexercise.com/api"
    When I perform a POST request to "/createAccount" with the body:
    """
    {
      "email": "Alberto@sgm.com",
      "password": "Albertsgm",
      "name": "Albertom",
      "title": "Mr,",
      "birth_date": "18",
      "birth_month": "01",
      "birth_year": "2000",
      "firstname": "Albertomm",
      "lastname": "Albert",
      "company": "SGM",
      "address1": "Washington",
      "address2": "DC",
      "country": "USA",
      "zipcode": "30215",
      "state": "Washington",
      "city": "NewYork",
      "mobile_number": "1231235596"
    }
    """
    Then the response status code should be 200
    #And the response body should contain "name" with value "Albertom"
  @Test
  Scenario: Perform a PUT request to update data
    Given I set the base URL to "https://automationexercise.com/api"
    When I perform a PUT request to "/updateAccount" with body'{"email": "Albertom@sgm.com","password": "Thomas"}'
    Then the response status code should be 200
    #And the response body should contain "name" with value "Thomas"
  @Test
  Scenario: Perform a DELETE request to remove data
    Given I set the base URL to "https://automationexercise.com/api"
    When I perform a DELETE request to "/deleteAccount"
    Then the response status code should be 200