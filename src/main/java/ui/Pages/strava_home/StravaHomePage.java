package ui.Pages.strava_home;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.Pages.base.BasePage;
import ui.Pages.strava_login.StravaLoginPage;

public class StravaHomePage extends BasePage {
    public StravaHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the login Page")
    public StravaLoginPage clickingLogIn () {
        WebElement element = driver.findElement(By.xpath("//a[@class = 'btn btn-default btn-login']"));
        waitElementsIsVisible(element).click();
        return new StravaLoginPage(driver);
    }

    @Step("Getting the page URL")
    public String getPageUrl () {
        String pageUrl = driver.getCurrentUrl();
        System.out.println(pageUrl);
        return pageUrl;
    }

}
