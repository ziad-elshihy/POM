package pages;

import bots.ActionBots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    // Variables
    private WebDriver driver;
    private ActionBots actionBots;

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.actionBots = new ActionBots(driver);
    }

    // Methods
    public LoginPage enterUsername(String username){
        actionBots.type(usernameField, username);
        return this;
    }
    public LoginPage enterPassword(String password){
        actionBots.type(passwordField, password);
        return this;
    }
    public LoginPage clickLogin(){
        actionBots.click(loginButton);
        return this;
    }

    // Validation Methods
    public HomePage isLoggedIn(String expectedUrl){
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return new HomePage(driver);
    }
}
