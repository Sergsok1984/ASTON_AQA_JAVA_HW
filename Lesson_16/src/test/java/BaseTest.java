import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class BaseTest {

    protected RequestSpecification requestSpec1 = given()
            .baseUri("https://postman-echo.com");

    protected ResponseSpecification responseSpec1 = expect()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .and().body("headers.x-forwarded-proto", equalTo("https"))
            .and().body("headers.x-forwarded-port", equalTo("443"))
            .and().body("headers.host", equalTo("postman-echo.com"))
            .and().body("headers.x-amzn-trace-id", containsString("Root="))
            .and().body("headers.accept", equalTo("*/*"))
            .and().body("headers.user-agent", containsString("Apache-HttpClient"))
            .and().body("headers.accept-encoding", equalTo("gzip,deflate"));
    protected RequestSpecification requestSpec2 = given()
            .baseUri("https://postman-echo.com")
            .body("Some raw text")
            .when();

    protected ResponseSpecification responseSpec2 = expect()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .and().body("headers.x-forwarded-proto", equalTo("https"))
            .and().body("headers.x-forwarded-port", equalTo("443"))
            .and().body("headers.host", equalTo("postman-echo.com"))
            .and().body("headers.content-length", equalTo("13"))
            .and().body("headers.x-amzn-trace-id", containsString("Root="))
            .and().body("headers.accept", equalTo("*/*"))
            .and().body("headers.user-agent", containsString("Apache-HttpClient"))
            .and().body("headers.accept-encoding", equalTo("gzip,deflate"));
}
