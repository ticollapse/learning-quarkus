package teste.vitor.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BitcoinResourceTest {

    @Test
    public void RequestHasStatusCode200(){
        RestAssured
                .given().get("bitcoins")
                .then()
                .statusCode(200);
    }
}
