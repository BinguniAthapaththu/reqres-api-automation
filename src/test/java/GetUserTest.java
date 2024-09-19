import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class GetUserTest {

    @BeforeClass
    public void setUp(){
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void GetUserTest_ValidRequest(){
        given()
                .when()
                .get("/users?id=1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.id", equalTo(1)) // Check the user's id is 1
                .body("data.email", equalTo("george.bluth@reqres.in")) // Verify user's email
                .body("data.first_name", equalTo("George")) // Verify user's first name
                .body("data.last_name", equalTo("Bluth")) // Verify user's last name
                .body("data.avatar", equalTo("https://reqres.in/img/faces/1-image.jpg")) // Verify user's avatar URL
                .log().body();
    }

    @Test
    public void GetUserTest_InvalidID(){
        given()
                .when()
                .get("/users?id=15")
                .then()
                .assertThat()
                .statusCode(404);
    }
}
