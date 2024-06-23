package com.serenitybdd.actions.API;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.annotations.Step;
import static io.restassured.RestAssured.given;
import org.assertj.core.api.Assertions;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ApiActions {
    private static RequestSpecification request;
    public static String PRODUCTS_LIST_ENDPOINT = "https://automationexercise.com/api/productsList";
    public static String SEARCH_PRODUCT_ENDPOINT = "https://automationexercise.com/api/searchProduct";

    @Step("Set base URI to {0}")
    public void setBaseUri(String baseUri) {
        RestAssured.baseURI = baseUri;
        request = RestAssured.given();
    }

    @Step("Perform GET request to {0}")
    public Response performGet(String endpoint) {
        return request.get(endpoint);
    }

    @Step("Perform POST request to {0} with body {1}")
    public Response performPost(String endpoint, String body) {
        return request
                .contentType(ContentType.JSON)
                .body(body)
                .post(endpoint);
    }

    @Step("Perform PUT request to {0} with body {1}")
    public Response performPut(String endpoint, String body) {
        return request
                .contentType(ContentType.JSON)
                .body(body)
                .put(endpoint);
    }

    @Step("Perform DELETE request to {0}")
    public Response performDelete(String endpoint) {
        return request.delete(endpoint);
    }

    @Step("Validate response status code is {0}")
    public void validateStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Step("Validate response body contains {0}")
    public void validateResponseBodyContains(Response response, String expectedContent) {
        Assertions.assertThat(response.getBody().asString()).contains(expectedContent);
    }
    @Step("Send POST request to search for product: {0}")
    public void searchProduct(String searchProduct) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("search_product", searchProduct);
        given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .baseUri(SEARCH_PRODUCT_ENDPOINT)
                .when()
                .post();
    }
    //TBD
    @Step("Send POST request")
    public static Response postRequest(String endpoint, Object requestBody) {
        return request
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpoint);
    }
    @Step("Send PUT request")
    public static Response putRequest(String endpoint, Object requestBody) {
        return request
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(endpoint);
    }

    @Step("Verify Response Header")
    public static void validateResponseHeader(Response response, String headerName, String headerValue) {
        response.then().header(headerName, headerValue);
    }
    @Step("Verify Response Body")
    public static void validateResponseBody(Response response, String jsonPath, Object expectedValue) {
        response.then().body(jsonPath, hasItem(expectedValue));
    }
    @Step("Verify Response Body in an array")
    public static void validateResponseContainsBrand(Response response, String expectedValue) {
        String responseBody = response.getBody().asString();
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonArray brandsArray = jsonObject.getAsJsonArray("brands");
        List<String> brands = new ArrayList<>();

        for (JsonElement brandElement : brandsArray) {
            JsonObject brandObject = brandElement.getAsJsonObject();
            brands.add(brandObject.get("brand").getAsString());
        }

        assertThat("Brand should be found in the response", brands, hasItem(expectedValue));
    }
    @Step("Verify Response Body contains name")
    public static void validateResponseBodyContainsName(Response response, String expectedValue) {
        String responseBody = response.getBody().asString();
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        String actualValue = jsonObject.getAsJsonArray("name").getAsString();

        assertThat("Response should contain the expected name", actualValue, equalTo(expectedValue));
    }
    @Step("Verify Response Body contains name")
    public static void validateResponseBodyContainsMessage(Response response, String expectedValue) {
        String responseBody = response.getBody().asString();
        Assertions.assertThat(responseBody.contains(expectedValue));
    }

}
