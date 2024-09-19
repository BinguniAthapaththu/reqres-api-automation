import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UpdateUserTest extends BaseTest{
    @Test
    public void UpdateUser_ValidRequest(){
        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "Automation Engineer");
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .put("/users/2")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
