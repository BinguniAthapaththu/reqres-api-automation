import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUsersTest {

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/api";
    }
    @Test
    public void GetUsersTest_ValidRequest(){
        given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void GetUsersTest_InvalidRequest(){
        given()
                .when()
                .get("/")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void GetUsersTest_InvalidPageNumber(){
        given()
                .when()
                .get("/users?page=20")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data",hasSize(0));
    }
}
