package com.serenitybdd.actions.API;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;


import static io.restassured.RestAssured.given;

public class ProductAPI {

    public static String PRODUCTS_LIST_ENDPOINT = "https://automationexercise.com/api/productsList";
    public static String SEARCH_PRODUCT_ENDPOINT = "https://automationexercise.com/api/searchProduct";

    @Step("Send GET request to retrieve products list")
    public void getProductsList() {
        given()
                .baseUri(PRODUCTS_LIST_ENDPOINT)
                .when()
                .get();
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
}
