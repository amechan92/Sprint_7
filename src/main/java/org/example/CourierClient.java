package org.example;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CourierClient {
    public CourierClient() {
        RestAssured.baseURI = Configuration.BASE_URI;
        RestAssured.basePath = Configuration.BASE_PATH;
    }
    @Step("Create")
    public Response createCourier(Object body) {
        return RestAssured.given()
                .baseUri(Configuration.BASE_URI)
                .basePath(Configuration.BASE_PATH)
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post("/courier");
    }

    @Step("Auth")
    public Response loginCourier(Object body) {
        return RestAssured.given()
                .baseUri(Configuration.BASE_URI)
                .basePath(Configuration.BASE_PATH)
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post("/courier/login");
    }

    @Step("Delete")
    public Response deleteCourier(int courierId) {
        return RestAssured.given()
                .baseUri(Configuration.BASE_URI)
                .basePath(Configuration.BASE_PATH)
                .pathParam("id", courierId)
                .when()
                .delete("/courier/{id}");
    }
}