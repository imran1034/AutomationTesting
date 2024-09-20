package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class WaitHelper {
	WebDriver driver;
    ConfigReader configReader = new ConfigReader();

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Explicit wait for element to be visible
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configReader.getProperty("explicitWait"))));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
