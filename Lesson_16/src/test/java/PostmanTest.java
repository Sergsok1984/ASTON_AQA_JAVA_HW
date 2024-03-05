import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostmanTest extends BaseTest {
    @Test
    public void getPostmanTest() {
       requestSpec
                .get("/get")
                .then().log().body()
                .spec(responseSpec)
                .and().body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    public void postPostmanTest() {
        requestSpec
                .body("Some raw text")
                .when()
                .post("/post")
                .then().log().body()
                .spec(responseSpec)
                .and().body("headers.content-length", equalTo("13"))
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void putPostmanTest() {
        requestSpec
                .body("Some raw text")
                .when()
                .put("/put")
                .then().log().body()
                .spec(responseSpec)
                .and().body("headers.content-length", equalTo("13"))
                .and().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void deletePostmanTest() {
        requestSpec
                .body("Some raw text")
                .when()
                .delete("/delete")
                .then().log().body()
                .spec(responseSpec)
                .and().body("headers.content-length", equalTo("13"))
                .and().body("url", equalTo("https://postman-echo.com/delete"));
    }
}
