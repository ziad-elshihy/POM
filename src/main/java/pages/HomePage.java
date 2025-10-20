package pages;

import bots.ActionBots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    // Variables
    private WebDriver driver;
    private ActionBots actionBots;


    // Locators
    private final By addToCartButton = By.cssSelector(".inventory_item_description #add-to-cart-sauce-labs-backpack");
    private final By cartIconNumber = By.cssSelector(".shopping_cart_badge");
    private final By cartIconButton = By.cssSelector(".shopping_cart_link");
    private final By cartPageTitle = By.cssSelector(".title");

    // Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.actionBots = new ActionBots(driver);
    }

    // Methods
    public HomePage addItemToCart(){
        actionBots.click(addToCartButton);
        return this;
    }

    public HomePage goToCart(){
        actionBots.click(cartIconButton);
        return this;
    }

    // Validation Methods
    public HomePage isItemAddedToCart() {
        String count = actionBots.getText(cartIconNumber);
        Assert.assertEquals(count, "1");
        return this;
    }

    public CartPage isOnCartPage() {
        String title = actionBots.getText(cartPageTitle);
        Assert.assertEquals(title, "Your Cart");
        return new CartPage(driver);
    }
}
