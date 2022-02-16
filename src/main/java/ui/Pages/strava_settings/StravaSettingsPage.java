package ui.Pages.strava_settings;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.Pages.base.BasePage;

import java.util.List;

public class StravaSettingsPage extends BasePage {
    public StravaSettingsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Changing the Profile Info")
    public StravaSettingsPage ChangingProfileInfo (String firstName,
                                                   String lastName,
                                                   int day, int month,
                                                   int year, String sex,
                                                   String city,
                                                   int weight) {

        driver.findElement(By.xpath("//div[contains(text(), 'Имя')]/parent::*")).click();
        driver.findElement(By.xpath("//input[@id = 'first-name-js']")).clear();
        driver.findElement(By.xpath("//input[@id = 'first-name-js']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id = 'last-name-js']")).clear();
        driver.findElement(By.xpath("//input[@id = 'last-name-js']")).sendKeys(lastName);
        driver.findElement(By.xpath("//button[@id = 'submit-button']")).click();
        //
        driver.findElement(By.xpath("//div[contains(text(), 'День рождения')]/parent::*")).click();
        driver.findElement(By.xpath("//select[@id = 'day-js']")).click();
        WebElement dayElement = driver.findElement(By.xpath("//select[@id = 'day-js']/option[@value = '" + day + "']"));
        waitElementsIsVisible(dayElement).click();
        driver.findElement(By.xpath("//select[@id = 'day-js']")).click();
        //
        driver.findElement(By.xpath("//select[@id = 'month-js']")).click();
        WebElement monthElement = driver.findElement(By.xpath("//select[@id = 'month-js']/option[@value = '" + month + "']"));
        waitElementsIsVisible(monthElement).click();
        //
        driver.findElement(By.xpath("//select[@id = 'year-js']")).click();
        WebElement yearElement = driver.findElement(By.xpath("//select[@id = 'year-js']/option[@value = '" + year + "']"));
        waitElementsIsVisible(yearElement).click();
        driver.findElement(By.xpath("//button[@id = 'submit-button']")).click();
        //
        driver.findElement(By.xpath("//div[contains(text(), 'Пол')]/parent::*")).click();
        WebElement sexElement = driver.findElement(By.xpath("//input[@value = '" + sex + "']"));
        waitElementsIsVisible(sexElement).click();
        driver.findElement(By.xpath("//button[@id = 'submit-button']")).click();
        //
        driver.findElement(By.xpath("//div[contains(text(), 'Место')]/parent::*")).click();
        WebElement locationElement = driver.findElement(By.xpath("//input[@id = 'location-js']"));
        waitElementsIsVisible(locationElement).clear();
        locationElement.sendKeys(city);
        driver.findElement(By.xpath("//button[@id = 'submit-button']")).click();
        //
        driver.findElement(By.xpath("//div[contains(text(), 'Вес')]/parent::*")).click();
        WebElement weightElement = driver.findElement(By.xpath("//input[@class = 'weight-field weight-js']"));
        waitElementsIsVisible(weightElement).clear();
        weightElement.sendKeys("" + weight + "");
        driver.findElement(By.xpath("//button[@id = 'submit-button']")).click();

        return this;
    }


    @Step ("Reload Page")
    public StravaSettingsPage pageReloading(){
        driver.navigate().refresh();
        return this;
    }

    @Step("Checking the User account info ")
    public boolean CheckingAccInfo (String firstName,
                                    String lastName,
                                    int day, int month,
                                    int year, String sex,
                                    String city,
                                    int weight) {
        boolean bln = false;
        String monthName = "";
        String sexName = "";
        List<String> accElementsNameList = List.of(
                driver.findElement(By.xpath("//div[contains(text(), 'Имя')]/following-sibling::div")).getText(),
                driver.findElement(By.xpath("//div[contains(text(), 'День рождения')]/following-sibling::div")).getText(),
                driver.findElement(By.xpath("//div[contains(text(), 'Пол')]/following-sibling::div")).getText(),
                driver.findElement(By.xpath("//div[contains(text(), 'Место')]/following-sibling::div")).getText(),
                driver.findElement(By.xpath("//div[contains(text(), 'Вес')]/following-sibling::div")).getText()
        );
        switch (month) {
            case (1):
                monthName = ("января");
                break;
                case (2):
                    monthName = ("февраля");
                    break;
            case (3):
                monthName = ("марта");
                break;
            case (4):
                monthName = ("апреля");
                break;
            case (5):
                monthName = ("мая");
                break;
            case (6):
                monthName = ("июня");
                break;
            case (7):
                monthName = ("июля");
                break;
            case (8):
                monthName = ("августа");
                break;
            case (9):
                monthName = ("сентября");
                break;
            case (10):
                monthName = ("октября");
                break;
            case (11):
                monthName = ("ноября");
                break;
            case (12):
                monthName = ("декабря");
                break;
    }
    switch (sex) {
        case ("M"):
            sexName = "Муж.";
            break;
        case ("F"):
            sexName = "Жен.";
            break;
        case  (""):
            sexName = "Другое";
            break;
    }

        if (accElementsNameList.get(0).equals(firstName + " " + lastName)) {
            bln = true;
        } else {
            bln = false;
        }
        if (accElementsNameList.get(1).equals(day + " " + monthName + " " + year + "г.")) {
            bln = true;
        } else {
            bln = false;
        }
        if (accElementsNameList.get(2).equals(sexName)) {
            bln = true;
        } else {
            bln = false;
        }

        return bln;
    }

}
