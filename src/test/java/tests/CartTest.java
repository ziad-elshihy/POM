package tests;

import drivers.AbstractDriver;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CartTest {
    // init driver
    WebDriver driver;

    // Tests
    @Test
    public void navigateToCart() {
        new LoginPage(driver)
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .isLoggedIn("https://www.saucedemo.com/inventory.html")
                .addItemToCart()
                .isItemAddedToCart()
                .goToCart()
                .isOnCartPage();
    }

    @Test
    public void proceedToCheckout() {
        new LoginPage(driver)
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .isLoggedIn("https://www.saucedemo.com/inventory.html")
                .addItemToCart()
                .isItemAddedToCart()
                .goToCart()
                .isOnCartPage()
                .proceedToCheckout()
                .isOnCheckoutPage();
    }


    // Configuration and setup methods would go here
    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.initDriver("edge");
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
