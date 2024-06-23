package com.serenitybdd.stepdefinitions.APIStepDefs;
import com.google.gson.*;
import com.serenitybdd.actions.API.ApiActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.annotations.Steps;
import org.assertj.core.api.Assertions;

import java.util.List;

import static com.serenitybdd.actions.API.ApiActions.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;


public class ApiTestSteps {

    @Steps
    ApiActions apiActions;
    private Response response;


//    @When("I send a GET request to retrieve products list")
//    public void iSendAGETRequestToRetrieveProductsList() {
//        //apiActions.getProductsList();
//
//    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int responseCode) {
        response = given()
                .baseUri(ApiActions.PRODUCTS_LIST_ENDPOINT)
                .when()
                .get();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(responseCode);
    }

    @And("the response should contain all products list")
    public void theResponseShouldContainAllProductsList() {
        Assertions.assertThat(response).isNotNull();
        String responseBody = response.getBody().asString();
        JsonObject jsonResponse = new Gson().fromJson(responseBody, JsonObject.class);
        JsonArray productsArray = jsonResponse.getAsJsonArray("products");
        Assertions.assertThat(productsArray).isNotNull();
        //Assertions.assertThat(productsArray).isNotEmpty();
        // (Optional) modification needed to avoid hardcoding
        Assertions.assertThat(productsArray)
                .extracting(JsonElement::getAsJsonObject)
                .extracting(product -> product.get("name").getAsString())
                .contains("Blue Top", "Men Tshirt", "Sleeveless Dress");
    }

    @When("I send a POST request to search for the product {string}")
    public void iSendAPOSTRequestToSearchForTheProduct(String searchProduct) {
        apiActions.searchProduct(searchProduct);
    }

    @And("the response should contain the searched product {string}")
    public void theResponseShouldContainTheSearchedProduct(String searchedProduct) {
        List<String> productNames = response.jsonPath().getList("products.name");

        Assertions.assertThat(productNames)
                .as("Product '%s' should be found in the response", searchedProduct)
                .contains(searchedProduct);
    }

    @Given("I set the base URL to {string}")
    public void iSetTheBaseURLTo(String baseUrl) {
        apiActions.setBaseUri(baseUrl);

    }

    @When("I perform a GET request to {string}")
    public void iPerformAGETRequestTo(String endpoint) {
        response = apiActions.performGet(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        apiActions.validateStatusCode(response, statusCode);
    }

    @And("the response body should contain {string} with value {string}")
    public void theResponseBodyShouldContainWithValue(String jsonPath, String expectedValue) {
        //validateResponseBody(response,jsonPath,expectedValue);
        System.out.println("Response Body: " + response.getBody().asString());
        validateResponseBodyContainsName(response,expectedValue);
    }


    @When("I perform a DELETE request to {string}")
    public void iPerformADELETERequestTo(String endpoint) {
        response = apiActions.performDelete(endpoint);
    }

    @And("the response body should contain brand with value {string}")
    public void theResponseBodyShouldContainBrandWithValue(String expectedValue) {
        apiActions.validateResponseBodyContains(response,expectedValue);
    }

    @And("the response body should show message {string}")
    public void theResponseBodyShouldShowMessage(String responseMessage) {
        validateResponseBodyContainsMessage(response,responseMessage);
    }

    @When("I perform a POST request to {string} with body{string}")
    public void iPerformAPOSTRequestToWithBody(String endpoint, String body) {
        response = apiActions.performPost(endpoint,body);
    }

    @When("I perform a POST request to {string} with the body:")
    public void iPerformAPOSTRequestToWithTheBody(String endpoint, Object requestBody) {
        response = postRequest(endpoint,requestBody);
    }

    @When("I perform a PUT request to {string} with body{string}")
    public void iPerformAPUTRequestToWithBody(String endpoint, String body) {
        response = apiActions.performPut(endpoint,body);
    }

}
