import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

public class LoginPage {
    // Variables
    private final WebDriver driver;

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");


    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public LoginPage login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return this;
    }

    public HomePage isLoggedIn(String expectedUrl){
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return new HomePage(driver);
    }
}
