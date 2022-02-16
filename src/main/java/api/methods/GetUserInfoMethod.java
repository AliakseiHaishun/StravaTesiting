package api.methods;

import api.pojos.user_info.UserData;
import io.restassured.http.ContentType;
import ui.commons.Property;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetUserInfoMethod {
    String baseAthletePath = "/v3/athlete";

    public Integer getUserId() {
        Integer userId = null;
        try {
            userId = given()
                    .header("Authorization", "Bearer " + Property.getPropertyValue("token"))
                    .contentType(ContentType.JSON)
                    .baseUri("https://www.strava.com/api")
                    .basePath(baseAthletePath)
                    .when().get()
                    .then()
                    .statusCode(200).log().all()
                    .extract().body().jsonPath().getInt("id");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userId;
    }
    public String getUserAccInfo () {
        UserData userData = null;
        try {
            userData = given()
                    .header("Authorization", "Bearer " + Property.getPropertyValue("token"))
                    .when()
                    .contentType(ContentType.JSON)
                    .get("https://www.strava.com/api/v3/athlete")
                    .then().log().all()
                    .extract().body().jsonPath().getObject(".", UserData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String userInfo = userData.getId() + userData.getFirstname() + userData.getLastname();
        return userInfo;
    }


}
