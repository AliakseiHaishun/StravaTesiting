package ui.Pages.strava_athlete_new_post_page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.Pages.base.BasePage;
import ui.Pages.stravaDashboard.StravaDashboardPage;

public class StravaAthleteNewPostPage extends BasePage {
    public StravaAthleteNewPostPage(WebDriver driver) {
        super(driver);
    }


    @Step("Clicking the homepage button")
    public StravaDashboardPage homePageBtnClicking () {
        driver.findElement(By.xpath("//a[@class = 'branding-content']")).click();
        return new StravaDashboardPage(driver);
    }

    @Step("Typing the title and text of the new post")
    public StravaAthleteNewPostPage newPostContentTypingAndClicking (String title, String content) {
        driver.findElement(By.xpath("//textarea[@class = 'post-title mb-md']"))
                .sendKeys(title);
        driver.findElement(By.xpath("//textarea[@class = 'autoresize post-content mb-sm noresize']"))
                .sendKeys(content);
        driver.findElement(By.xpath("//button[@class = 'btn btn-primary btn-save-post']")).click();
        return this;
    }
}
