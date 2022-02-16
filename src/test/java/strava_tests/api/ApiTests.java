package strava_tests.api;

import api.pojos.activity.Activity;
import api.pojos.user_info.UserData;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import strava_tests.api.base.BaseApiTest;
import strava_tests.api.enums.UserDataPojo;
import strava_tests.api.provider.ClubsIdListProvider;
import java.util.List;



public class ApiTests extends BaseApiTest {


    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest
    @EnumSource(UserDataPojo.class)
    public void testUserInfoTest() {
        Assertions.assertEquals(getUserInfoMethod.getUserAccInfo(),
                UserDataPojo.USER_DATA_POJO1.userInfo());
    }

    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void getUsersActivityById () {
        Assertions.assertTrue(!getActivityMethod
                .getUserActivitiesId().isEmpty());
    }


    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest
    @ArgumentsSource(ClubsIdListProvider.class)
    public void usersClubsTest (List<Integer> clubsIdList) {
        Assertions.assertTrue(getClubsInfoMethod
                        .ClubsIdCompassion(getClubsInfoMethod.getUserClubsId(), clubsIdList));
    }


}
