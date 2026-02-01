import data.AuthRequest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.testng.annotations.BeforeClass;

import static io.qameta.allure.Allure.step;

public class BaseTestApi {

    protected static RequestSpecification requestSpec;
    protected static String token;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        step("Настраиваем окружение", () -> requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("User-Agent", "RestAssured/5.3.0")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .build());

        token = getAuthToken();
    }

    @AfterEach
    void getSomeRest(){
        try {
            wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAuthToken() {
        AuthRequest authRequest = AuthRequest.builder()
                .username("SolidSnake")
                .password("ChickenWinner11233")
                .build();

        return RestAssured.given()
                .spec(requestSpec)
                .body(authRequest)
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
