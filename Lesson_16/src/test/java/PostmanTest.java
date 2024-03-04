import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostmanTest extends BaseTest {
    @Test
    public void getPostmanTest() {
       requestSpec1
                .get("/get")
                .then().log().body()
                .spec(responseSpec1)
                .and().body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    public void postPostmanTest() {
        requestSpec2
                .post("/post")
                .then().log().body()
                .spec(responseSpec2)
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void putPostmanTest() {
        requestSpec2
                .put("/put")
                .then().log().body()
                .spec(responseSpec2)
                .and().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void deletePostmanTest() {
        requestSpec2
                .delete("/delete")
                .then().log().body()
                .spec(responseSpec2)
                .and().body("url", equalTo("https://postman-echo.com/delete"));
    }
}
