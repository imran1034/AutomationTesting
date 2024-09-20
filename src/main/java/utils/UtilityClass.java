package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {
	WebDriver driver;
    ConfigReader configReader = new ConfigReader();

    public UtilityClass(WebDriver driver) {
        this.driver = driver;
    }

    // Capture screenshot method
    public String captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = configReader.getProperty("screenshotPath") + screenshotName + ".png";
        try {
            FileHandler.copy(src, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }

    // Handle JavaScript alert dynamically
    public String handleAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

}
