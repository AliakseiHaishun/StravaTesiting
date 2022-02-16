package api.methods;

import io.restassured.http.ContentType;
import ui.commons.Property;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetClubsInfoMethod {

    public List<Integer> getUserClubsId() {
        List<Integer> clubsIdList = null;
        try {
            clubsIdList = given()
                    .header("Authorization", "Bearer " + Property.getPropertyValue("token"))
                    .contentType(ContentType.JSON)
                    .baseUri("https://www.strava.com/api")
                    .basePath("/v3/athlete/clubs")
                    .when().get()
                    .then()
                    .statusCode(200).log().all()
                    .extract().body().jsonPath().getList("id");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clubsIdList;
    }

    public boolean ClubsIdCompassion(List<Integer> clubsIdList1, List<Integer> clubsIdList2) {
        boolean bln = false;
        for (int i = 0; i < clubsIdList1.size(); i++) {
            if (clubsIdList1.get(i).equals(clubsIdList1.get(i))) {
                bln = true;
            } else {
                bln = false;
            }
        }
        return bln;
    }
}
