package steps;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class BDDStyleMethod {

    public static void simpleGETPost(String s) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(String.format("https://petstore.swagger.io/v2/pet/%s", s))
                .then()
                .body("name", is("woof"));
    }

    public static void performContainsCollection(String dog1, String dog2) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(String.format("https://petstore.swagger.io/v2/pet/findByStatus?status=sold"))
                .then()
                .body("name", hasItems(dog1, dog2))
                .statusCode(200);
    }

    public static void performPathParameter(String petId) {
        given()
                .contentType(ContentType.JSON)
                .with()
                .pathParams("petId", petId)
                .when()
                .get(String.format("https://petstore.swagger.io/v2/pet/{petId}"))
                .then()
                .body("name", is("woof"));
    }

    public static void performQueryParameter(String dog1, String dog2) {
        given()
                .contentType(ContentType.JSON)
                .with()
                .queryParam("status","sold")
                .when()
                .get(String.format("https://petstore.swagger.io/v2/pet/findByStatus"))
                .then()
                .body("name", hasItems(dog1, dog2))
                .statusCode(200);
    }

    public static void performPOSTWithBodyParameter(){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("name", "FedeDog3");
        postContent.put("status", "available");

        given()
                .contentType(ContentType.JSON)
                .with()
                    .body(postContent)
                .when()
                    .post("https://petstore.swagger.io/v2/pet")
                .then()
                    .body("name", Is.is("FedeDog3"))
                    .statusCode(200);
    }


}
