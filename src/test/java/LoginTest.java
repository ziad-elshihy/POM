import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    // init driver
    WebDriver driver;

    // Tests
    @Test
    public void validLoginTC() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        Assert.assertTrue(loginPage.isLoggedIn("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void inValidLoginTC() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard","secret_sauce");
        Assert.assertTrue(loginPage.isLoggedIn("https://www.saucedemo.com/inventory.html"));
    }

    // Configuration and setup methods would go here
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
