package com.serenitybdd.stepdefinitions.APIStepDefs;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.serenitybdd.actions.API.ProductAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.assertj.core.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;


public class ApiTestSteps {

    @Steps
    ProductAPI productAPI;
    private Response response;

    @When("I send a GET request to retrieve products list")
    public void iSendAGETRequestToRetrieveProductsList() {
        productAPI.getProductsList();
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int responseCode) {
        response = given()
                .baseUri(ProductAPI.PRODUCTS_LIST_ENDPOINT)
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
        productAPI.searchProduct(searchProduct);
    }

    @And("the response should contain the searched product {string}")
    public void theResponseShouldContainTheSearchedProduct(String searchedProduct) {
        List<String> productNames = response.jsonPath().getList("products.name");

        Assertions.assertThat(productNames)
                .as("Product '%s' should be found in the response", searchedProduct)
                .contains(searchedProduct);
    }
}
