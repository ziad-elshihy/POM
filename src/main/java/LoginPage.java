import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
    public LoginPage enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage clickLogin(){
        driver.findElement(loginButton).click();
        return this;
    }

    // Validation Methods
    public HomePage isLoggedIn(String expectedUrl){
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return new HomePage(driver);
    }
}
