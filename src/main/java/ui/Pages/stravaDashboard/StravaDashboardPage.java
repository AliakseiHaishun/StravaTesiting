package ui.Pages.stravaDashboard;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.Pages.base.BasePage;
import ui.Pages.strava_athlete_new_post_page.StravaAthleteNewPostPage;
import ui.Pages.strava_home.StravaHomePage;
import ui.Pages.strava_searhResult.StravaSearchResultPage;
import ui.Pages.strava_settings.StravaSettingsPage;
import ui.Pages.strava_user_profile.StravaUserProfilePage;

import java.util.List;

public class StravaDashboardPage extends BasePage {
    public StravaDashboardPage(WebDriver driver) {
        super(driver);
    }
    protected final By dashboardList =
            By.xpath("//li[@class = 'nav-item drop-down-menu accessible-nav-dropdown selected enabled active']");

    @Step("Open the dashboard list")
    public StravaDashboardPage dashboardListOpening () {
        Actions action = new Actions(driver);
        WebElement componentsList = driver.findElement(By.xpath("//div[contains(text(), 'Загрузить')]"));
        action.moveToElement(componentsList).build().perform();
        return this;
    }

    @Step("Open user profile page")
    public StravaUserProfilePage userProfilePageOpening () {
        Actions action = new Actions(driver);
        WebElement componentsList = driver.findElement(By.xpath("//a[@class = 'nav-link selection accessible-nav-link']"));
        action.moveToElement(componentsList).build().perform();
        WebElement settingsElement = driver.findElement(By.xpath("//a[contains(text(), 'Мой профиль')]"));
        waitElementsIsVisible(settingsElement).click();

        return new StravaUserProfilePage(driver);
    }

    @Step("Create the header elements list")
    public boolean  headerElementsListVerifying (List<By> byList) {
        boolean bln = false;
        WebElement element = driver.findElement(By.xpath("//header[@id = 'global-header']"));
        for (int i = 0; i <byList.size(); i++) {
            if (element.findElement(byList.get(i)).isDisplayed()) {
                bln = true;
            } else {
                bln = false;
            }
        }

        return bln;
    }

    @Step("Open new post page")
    public StravaAthleteNewPostPage newPostPageOpening () {
        Actions action = new Actions(driver);
        WebElement componentsList = driver.findElement(By.xpath("//li[@class = 'nav-item drop-down-menu upload-menu enabled']"));
        action.moveToElement(componentsList).build().perform();
        WebElement settingsElement = driver.findElement(By.xpath("//span[@class= 'create-post app-icon icon-create-post']/parent::*"));
        waitElementsIsVisible(settingsElement).click();
        return new StravaAthleteNewPostPage(driver);
    }

    @Step("Open User setting page")
    public StravaSettingsPage dashboardSettingsPageOpening () {
        Actions action = new Actions(driver);
        WebElement componentsList = driver.findElement(By.xpath("//a[@class = 'nav-link selection accessible-nav-link']"));
        action.moveToElement(componentsList).build().perform();
        WebElement settingsElement = driver.findElement(By.xpath("//a[contains(text(), 'Настройки')]"));
        waitElementsIsVisible(settingsElement).click();
        return new StravaSettingsPage(driver);
    }

    @Step("Searching the Athlete by name ")
    public StravaSearchResultPage athleteSearching (String athleteName) {
        driver.findElement(By.xpath("//button[@id = 'open-global-search-button']")).click();
        driver.findElement(By.xpath("//div[@id = 'global-search-filter']")).click();
        driver.findElement(By.xpath("//div[@data-value= 'athletes']")).click();
        driver.findElement(By.xpath("//input[@class= 'form-control ui-autocomplete-input']")).sendKeys(athleteName);
        driver.findElement(By.xpath("//button[@id= 'global-search-button']")).click();
        return new StravaSearchResultPage(driver);
    }
    @Step("Searching all Athletes")
    public StravaSearchResultPage emptyAthleteNameSearching () {
        driver.findElement(By.xpath("//button[@id = 'open-global-search-button']")).click();
        driver.findElement(By.xpath("//div[@id = 'global-search-filter']")).click();
        driver.findElement(By.xpath("//div[@data-value= 'athletes']")).click();
        driver.findElement(By.xpath("//button[@id= 'global-search-button']")).click();
        return new StravaSearchResultPage(driver);
    }

    @Step("LogOut and opening the start Page ")
    public StravaHomePage logOut () {
        Actions action = new Actions(driver);
        WebElement componentsList = driver.findElement(By.xpath("//a[@class = 'nav-link selection accessible-nav-link']"));
        action.moveToElement(componentsList).build().perform();
        WebElement settingsElement = driver.findElement(By.xpath("//a[contains(text(), 'Выйти')]"));
        waitElementsIsVisible(settingsElement).click();
        return new StravaHomePage(driver);
    }

    @Step("Getting the page URL")
    public String getPageUrl () {
        String pageUrl = driver.getCurrentUrl();
        System.out.println(pageUrl);
        return pageUrl;
    }

}
