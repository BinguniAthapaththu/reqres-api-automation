import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUserTest extends BaseTest{
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
