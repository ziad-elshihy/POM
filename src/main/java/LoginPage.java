import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class LoginPage {
    // Variables
    WebDriver driver;

    // Locators
    private final By usernameField = By.id("user-name"); // standard_user
    private final By passwordField = By.id("password"); // secret_sauce
    private final By loginButton = By.id("login-button");
    //url: https://www.saucedemo.com/

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public void login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn(String expectedUrl){
        return Objects.equals(driver.getCurrentUrl(), expectedUrl);
    }
}
