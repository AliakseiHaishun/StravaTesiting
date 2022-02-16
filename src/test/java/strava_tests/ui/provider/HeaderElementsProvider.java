package strava_tests.ui.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.stream.Stream;

public class HeaderElementsProvider  implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        By.xpath("//div[@class = 'branding']"),
                        By.xpath("//button[@id= 'open-global-search-button']"),
                        By.xpath("//li[@data-log-category='dashboard']"),
                        By.xpath("//li[@data-log-category='training']"),
                        By.xpath("//li[@data-log-category='explore']"),
                        By.xpath("//ul[@class = 'global-nav nav-group']/li[@class = 'nav-item']"),
                        By.xpath("//li[@class = 'nav-item upgrade']"),
                        By.xpath("//li[@id= 'notifications']"),
                        By.xpath("//li[@class= 'nav-item drop-down-menu user-menu accessible-nav-dropdown enabled']"),
                        By.xpath("//li[@class= 'nav-item drop-down-menu upload-menu enabled']")
                ))
        );
    }

}