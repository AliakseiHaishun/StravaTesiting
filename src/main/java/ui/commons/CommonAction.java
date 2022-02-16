package ui.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static ui.commons.Config.PLATFORM_AND_BROWSER;
import static ui.constants.Constants.IMPLICIT_WAIT;


public class CommonAction {
    public static WebDriver createDriver() {

        WebDriver driver = null;
        switch (PLATFORM_AND_BROWSER) {
            case "windows_chrome":
                System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
