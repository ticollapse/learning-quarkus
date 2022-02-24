package org.acme.hibernate;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class ProductResourceTest {

    @Test
    public void testProductResourceGET(){
        given()
                .when().get("/products")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }


}
