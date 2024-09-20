package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;



public class LoginPage {
	WebDriver driver;
    WaitHelper waitHelper;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);  // Initialize WaitHelper for dynamic waits
    }

    public void enterUsername(String username) {
        waitHelper.waitForElement(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitHelper.waitForElement(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        waitHelper.waitForElement(loginButton);
        loginButton.click();
    }
}

