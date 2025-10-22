package pages;

import bots.ActionBots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    // Variables
    private WebDriver driver;
    private ActionBots actionBots;

    // Locators
    private final By checkoutButton = By.cssSelector("#checkout");
    private final By checkoutPageTitle = By.cssSelector(".header_secondary_container .title");

    // Constructor
    public CartPage(WebDriver driver){
        this.driver = driver;
        this.actionBots = new ActionBots(driver);
    }

    // Methods
    public CartPage proceedToCheckout(){
        actionBots.click(checkoutButton);
        return this;
    }

    // Validation Methods
    public CartPage isOnCheckoutPage() {
        String title = actionBots.getText(checkoutPageTitle);
        Assert.assertEquals(title, "Checkout: Your Information");
        return this;
    }
}
