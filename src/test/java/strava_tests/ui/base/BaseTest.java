package strava_tests.ui.base;


import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ui.Pages.base.BasePage;
import ui.Pages.strava_home.StravaHomePage;
import ui.commons.CommonAction;

import static ui.commons.Config.CLEAR_COOKIES_AND_STORAGE;
import static ui.commons.Config.HOLD_BROWSER_OPEN;


public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected StravaHomePage stravaHomePage = new StravaHomePage(driver);

    @AfterEach
    public void clearCookiesAndLocalStorage () {
        if(CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterEach
    public void close() {
        if(HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
