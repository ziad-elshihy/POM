import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
    // init driver
    WebDriver driver;

    // Tests
    @Test
    public void addToCartTC() {
        new LoginPage(driver)
                .login("standard_user","secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/inventory.html")
                .addItemToCart()
                .isItemAddedToCart();
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
