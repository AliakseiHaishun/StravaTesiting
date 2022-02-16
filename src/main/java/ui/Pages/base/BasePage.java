package ui.Pages.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.commons.Log;

import static ui.constants.Constants.EXPLICIT_WAIT;
import static ui.constants.Constants.urls.STRAVA_HOMEPAGE;


public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    @Step ("Opening the" + STRAVA_HOMEPAGE + " page")
    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementsIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).
                until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
