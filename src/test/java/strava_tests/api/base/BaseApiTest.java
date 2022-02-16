package strava_tests.api.base;


import api.methods.GetActivityMethod;
import api.methods.GetClubsInfoMethod;
import api.methods.GetUserInfoMethod;

public class BaseApiTest {
    protected GetUserInfoMethod getUserInfoMethod = new GetUserInfoMethod();
    protected GetClubsInfoMethod getClubsInfoMethod = new GetClubsInfoMethod();
    protected GetActivityMethod getActivityMethod = new GetActivityMethod();
}
