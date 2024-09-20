package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import utils.ConfigReader;

public class BaseClass {
	public static WebDriver driver;
    ConfigReader configReader = new ConfigReader();

    public void initializeDriver() {
        String browser = configReader.getProperty("browser");
        if (browser.equalsIgnoreCase("mozilla")) {
            System.setProperty("webdriver.gecko.driver", configReader.getProperty("chromeDriverPath"));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts()
        .implicitlyWait(Duration.ofSeconds(Integer.parseInt(configReader.getProperty("implicitWait"))));
        driver.manage().timeouts()
        .pageLoadTimeout(Duration.ofSeconds(30));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
	
    }
}
