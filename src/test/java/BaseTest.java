import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    @BeforeClass
    public void setup(){
        baseURI = "https://reqres.in/api";
    }
}
