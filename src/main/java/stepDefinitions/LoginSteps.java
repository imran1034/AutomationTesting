package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.UtilityClass;
import utils.ConfigReader;

public class LoginSteps extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;
    UtilityClass util;
    ConfigReader configReader = new ConfigReader();

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() {
        initializeDriver();
        driver.get(configReader.getProperty("url"));
        loginPage = new LoginPage(driver);  // Initialize page object
        util = new UtilityClass(driver);
    }

    @When("^User enters username and password$")
    public void user_enters_username_and_password() {
        loginPage.enterUsername(configReader.getProperty("username"));
        loginPage.enterPassword(configReader.getProperty("password"));
        loginPage.clickLogin();
    }

    @Then("^User is logged in successfully$")
    public void user_is_logged_in_successfully() {
        homePage = new HomePage(driver);
        String welcomeMessage = homePage.getWelcomeMessage();
        Assert.assertEquals("Welcome", welcomeMessage);

        // Capture screenshot after successful login
        util.captureScreenshot("loginSuccess");
        quitDriver();
    }
}
