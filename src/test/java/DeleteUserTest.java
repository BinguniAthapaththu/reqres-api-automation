import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUserTest {
    @BeforeClass
    public void setup(){
        baseURI = "https://reqres.in/api";
    }
    @Test
    public void DeleteUser_ValidRequest(){
        given()
                .when()
                .delete("/users/2")
                .then()
                .assertThat()
                .statusCode(204);
    }
}
