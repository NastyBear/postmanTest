import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostTest extends AbstractTest {
    private static String userName="GB202302d8e3c02";
    private static String passWord="a4506abb71";


    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @Test
    void authorization(){
        JsonPath response= given()
            .formParam("username",userName)
            .formParam("password",passWord)
            .when()
            .post(getUrl())
            .body()
            .jsonPath();
        assertThat(response.get("id"), equalTo(4515));


}
    @Test
    void authorization2(){
        given()
                .formParam("username","GB202302d8e3c021")
                .formParam("password",passWord)
                .when()
                .post(getUrl())
                .then()
                .assertThat()
                .statusCode(401)
                .body("error",equalTo("Invalid credentials."));
    }
    @Test
    void authorization3(){
        given()
                .formParam("password",passWord)
                .when()
                .post(getUrl())
                .then()
                .assertThat()
                .statusCode(400)
                .body("message",equalTo("The key \"username\" must be provided."));
    }


}
