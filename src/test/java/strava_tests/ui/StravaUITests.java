package strava_tests.ui;


import io.cucumber.java.eo.Se;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import strava_tests.ui.base.BaseTest;
import strava_tests.ui.provider.HeaderElementsProvider;
import strava_tests.ui.unums.AccInfo;
import strava_tests.ui.unums.NewPost;
import ui.commons.Log;

import java.util.List;

import static strava_tests.ui.unums.NewPost.POST_WITH_TITLE;
import static ui.constants.Constants.urls.STRAVA_HOMEPAGE;


public class StravaUITests extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("login test")

    @ParameterizedTest
    @ValueSource (strings = {"https://www.strava.com/dashboard"})
    public void logInTest1 (String url) {
        basePage.open(STRAVA_HOMEPAGE);
        Assertions.assertEquals(stravaHomePage
                .clickingLogIn()
                .logInByEmail()
                .getPageUrl()
                , url);
        Log.info("The Users dashboard page is verified");
    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("logout test")
    @ParameterizedTest
    @ValueSource (strings = {"https://www.strava.com/"})
    public void logOutTest (String url) {
        basePage.open(STRAVA_HOMEPAGE);
        Assertions.assertEquals(stravaHomePage
                .clickingLogIn()
                .logInByEmail()
                .logOut()
                .getPageUrl(), url);
        Log.info("Home page is verified");
    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Dashboard Header elements test")
    @ParameterizedTest
    @ArgumentsSource(HeaderElementsProvider.class)
    public void dashboardHeaderElementsTest (List <By> byList) {
        basePage.open(STRAVA_HOMEPAGE);
        Assertions.assertTrue(
                stravaHomePage.clickingLogIn()
                .logInByEmail()
                .dashboardListOpening()
                .headerElementsListVerifying(byList));
        Log.info("Displaying elements are checked");
    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("New Post creation test")
    @ParameterizedTest
    @EnumSource(value = NewPost.class)
    public void newPostCreationTest() {
        basePage.open(STRAVA_HOMEPAGE);
        Assertions.assertTrue(stravaHomePage.clickingLogIn()
                .logInByEmail()
                .newPostPageOpening()
                .newPostContentTypingAndClicking(POST_WITH_TITLE.getPostTitle(), POST_WITH_TITLE.getPostText())
                .homePageBtnClicking()
                .userProfilePageOpening()
                .notesOpen()
                .newPostChecking(POST_WITH_TITLE.getPostTitle(), POST_WITH_TITLE.getPostText()));
        Log.info("New Post are verified");
    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Account info changing test")
    @ParameterizedTest
    @EnumSource(value = AccInfo.class)
    public void AccInfoChangingTest () {
        basePage.open(STRAVA_HOMEPAGE);
        Assertions.assertTrue(stravaHomePage.clickingLogIn()
                .logInByEmail()
                .dashboardSettingsPageOpening()
                .ChangingProfileInfo(
                        AccInfo.ACC_INFO1.getFirstName(), AccInfo.ACC_INFO1.getLastName(),
                        AccInfo.ACC_INFO1.getDay(), AccInfo.ACC_INFO1.getMonth(),
                        AccInfo.ACC_INFO1.getYear(), AccInfo.ACC_INFO1.getSex(),
                        AccInfo.ACC_INFO1.getCity(), AccInfo.ACC_INFO1.getWeight()
                )
                .pageReloading()
                .CheckingAccInfo(
                        AccInfo.ACC_INFO1.getFirstName(), AccInfo.ACC_INFO1.getLastName(),
                AccInfo.ACC_INFO1.getDay(), AccInfo.ACC_INFO1.getMonth(),
                AccInfo.ACC_INFO1.getYear(), AccInfo.ACC_INFO1.getSex(),
                AccInfo.ACC_INFO1.getCity(), AccInfo.ACC_INFO1.getWeight()
                )
        );
        Log.info("User account info are verified");

    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Athlete Searching test")
    @ParameterizedTest
    @ValueSource (strings = {"Adam Smith"})
    public void athleteSearchTest (String athleteName) {
        basePage.open(STRAVA_HOMEPAGE);
        Assertions.assertTrue(stravaHomePage.clickingLogIn()
                .logInByEmail()
                .athleteSearching(athleteName)
                .searchResultChecking(athleteName));
        Log.info("Name: " + athleteName + " are checked");
    }

    @Description("By this test we can verify that the results are displayed correctly")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Result list amount test")
    @ParameterizedTest
    @ValueSource (ints = {21})
    public void resultListAmountTest (int amount) {
        basePage.open(STRAVA_HOMEPAGE);
        Assertions.assertEquals(stravaHomePage.clickingLogIn()
                .logInByEmail()
                .emptyAthleteNameSearching()
                .resultListAmount()
                , amount);
        Log.info("the results amount on the first resultPage are counted");

    }

}
