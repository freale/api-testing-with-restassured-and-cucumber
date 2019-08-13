package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification request;

    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
        requestSpecBuilder.setContentType(ContentType.JSON);
        var requestSpec = requestSpecBuilder.build(); // var se puede usar a partir de java 11
        request = RestAssured.given().spec(requestSpec);
    }

    public static void getOpsWithPathParameter(String url, Map<String, String> pathParams) {
        //Act
        request.pathParams(pathParams);
        try {
            request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> getOps(String url) {
        //Act
        try {
            return request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
