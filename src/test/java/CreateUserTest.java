import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class CreateUserTest {
    @BeforeClass
    public void setup(){
        baseURI = "https://reqres.in/api";
    }
    @Test
    public void CreateUser_ValidRequest(){
        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "QA Engineer");

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .post("/users")
                .then()
                .assertThat()
                .statusCode(201)
                .log().body();
    }
}
