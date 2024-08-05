package api.utilities;

import api.models.User;
//import io.restassured.RestAssured;
import api.models.User2;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import static net.serenitybdd.rest.SerenityRest.*;

public class ApiHelper {
    private static final String BASE_URL = "https://reqres.in/api";
    public static Response createUser(User user)
    {
        return given()
                .contentType(ContentType.JSON)
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(BASE_URL+"/users");

    }

    public static Response consultUser(String id)
    {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL+"/users/"+id);
    }

    public static Response updateUser(String id, User2 user2)
    {
        return given()
                .contentType(ContentType.JSON)
                .body(user2, ObjectMapperType.GSON)
                .when()
                .put(BASE_URL+"/users/"+id);
    }
    public static Response partialUpdateUser(String id, User2 user2)
    {
        return given()
                .contentType(ContentType.JSON)
                .body(user2, ObjectMapperType.GSON)
                .when()
                .patch(BASE_URL+"/users/"+id);
    }
}
