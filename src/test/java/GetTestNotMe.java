import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTestNotMe extends AbstractTest{
    private static String token="1a709b965ef66e6e844a25813af820bf";
    private static String userName="GB202302d8e3c02";
    private static String passWord="a4506abb71";
    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @BeforeEach
    void authorization(){
        JsonPath response= given()
                .formParam("username",userName)
                .formParam("password",passWord)
                .when()
                .post(getUrl())
                .body()
                .jsonPath();
        assertThat(response.get("id"), equalTo(4515));
        assertThat(response.get("token"), equalTo("1a709b965ef66e6e844a25813af820bf"));
    }
    @Test
    void get1(){
        given()
                .header("X-Auth-Token",token)
                .when()
                .get(getUrlGet())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    void get2(){
        given()
                .header("X-Auth-Token",token)
                .queryParam("page","2")
                .when()
                .get(getUrlGetTest())
                .then()
                .assertThat()
                .body("meta.nextPage",equalTo(3))
                .statusCode(200);
    }
    @Test
    void get3(){
        given()
                .header("X-Auth-Token",token)
                .queryParam("page","7000")
                .when()
                .get(getUrlGetTest())
                .then()
                .assertThat()
                .body("meta.nextPage",equalTo(null))
                .statusCode(200);
    }
    @Test
    void get4(){
        given()
                .header("X-Auth-Token",token)
                .queryParam("order","ALL")
                .when()
                .get(getUrlGetTest())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    void get5(){
        given()
                .header("X-Auth-Token",token)
                .queryParam("page","0")
                .when()
                .get(getUrlGetTest())
                .then()
                .assertThat()
                .body("meta.prevPage",equalTo(0))
                .statusCode(200);
    }

}
