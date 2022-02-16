package api.methods;

import io.restassured.http.ContentType;
import ui.commons.Property;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetActivityMethod {
    public List<Long> getUserActivitiesId() {
        List<Long> activityidList = null;
        try {
            activityidList = given()
                    .header("Authorization", "Bearer " + Property.getPropertyValue("token"))
                    .when()
                    .contentType(ContentType.JSON)
                    .get("https://www.strava.com/api/v3/athlete/activities")
                    .then().log().all()
                    .extract().body().jsonPath().getList("id");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activityidList;
    }
}