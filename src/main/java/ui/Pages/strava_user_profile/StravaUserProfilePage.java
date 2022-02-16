package ui.Pages.strava_user_profile;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.Pages.base.BasePage;

public class StravaUserProfilePage extends BasePage {

    public StravaUserProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the notes field")
    public StravaUserProfilePage notesOpen () {
        driver.findElement(By.xpath("//a[contains(text(), 'Записи')]")).click();
        return this;
    }

    @Step("Verifying the Last post title&text")
    public boolean newPostChecking (String title, String noteText) {
        boolean bln = false;
        String postTitle = driver.findElement(By.xpath("//a[@class = 'str-click-self-js']")).getText();
        String postText = driver.findElement(By.xpath("//div[@class = 'h5 topless']")).getText();
        if (postTitle.equals(title) && postText.equals(noteText)) {
            bln = true;
        }
        return bln;
    }

}
