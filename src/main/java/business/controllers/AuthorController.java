package business.controllers;

import business.model.Author;
import core.util.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorController {

    public RequestSpecification getClient() {
        return RestAssured
                .given()
                .header("Content-Type", "application/json");
    }

    public Response createAuthor(Author author) {
        return getClient()
                .body(author)
                .post(PropertyReader.getProperty("createAuthor"))
                .then().log().ifValidationFails().statusCode(201)
                .extract().response();
    }

    public Response updateAuthor(Author author) {
        return getClient()
                .body(author)
                .put(PropertyReader.getProperty("createAuthor"))
                .then().log().ifValidationFails().statusCode(200)
                .extract().response();
    }

    public Response deleteAuthor(int authorID) {
        return getClient()
                .delete(String.format(PropertyReader.getProperty("deleteAuthor"), authorID))
                .then().log().ifValidationFails().statusCode(204)
                .extract().response();
    }

    public Response getAuthor(int authorID) {
        return RestAssured
                .given()
                .get(String.format(PropertyReader.getProperty("getAuthor"), authorID))
                .then().log().ifValidationFails().statusCode(200)
                .extract().response();
    }
}
