package ui.Pages.strava_login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.Pages.base.BasePage;
import ui.Pages.stravaDashboard.StravaDashboardPage;
import ui.commons.Property;

import java.io.IOException;

public class StravaLoginPage extends BasePage {
    public StravaLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Typing email and password in the login field and open the Dashboard page")
    public StravaDashboardPage logInByEmail () {
        try {
            driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys(Property.getPropertyValue("email"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(Property.getPropertyValue("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
        return new StravaDashboardPage(driver);
    }


}
