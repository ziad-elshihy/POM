import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    // init driver
    WebDriver driver;

    // Tests
    @Test
    public void validLoginTC() {
        new LoginPage(driver)
            .enterUsername("standard_user")
            .enterPassword("secret_sauce")
            .clickLogin()
            .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTC() {
        new LoginPage(driver)
            .enterUsername("standard")
            .enterPassword("secret_sauce")
            .clickLogin()
            .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    // Configuration and setup methods would go here
    @BeforeMethod
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless=new");
        driver = new EdgeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
