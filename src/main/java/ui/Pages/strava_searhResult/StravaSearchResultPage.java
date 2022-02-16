package ui.Pages.strava_searhResult;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.Pages.base.BasePage;

import java.util.List;

public class StravaSearchResultPage extends BasePage {
    public StravaSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify searching result by name")
    public boolean searchResultChecking (String searchingString) {
        boolean bln = false;
        WebElement element = driver.findElement(By.xpath("//a[contains(text(), '" + searchingString + "')]"));
        if (waitElementsIsVisible(element).isDisplayed()) {
            bln = true;
        } else {
            bln = false;
        }
        return bln;
    }

    @Step("Counting the results amount on the first resultPage")
    public int resultListAmount () {
        int amount = 0;
        List<WebElement> elementList = driver.findElements(By.xpath("//li[@class = 'row']"));
        amount = elementList.size();
        return amount;
    }


}
