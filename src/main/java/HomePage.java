import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    // Variables
    WebDriver driver;

    // Locators
    private final By addToCartButton = By.cssSelector(".inventory_item_description #add-to-cart-sauce-labs-backpack");
    private final By cartIconNumber = By.cssSelector(".shopping_cart_badge");
    private final By cartIconButton = By.cssSelector(".shopping_cart_link");
    private final By cartPageTitle = By.cssSelector(".title");

    // Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public HomePage addItemToCart(){
        driver.findElement(addToCartButton).click();
        return this;
    }

    public HomePage goToCart(){
        driver.findElement(cartIconButton).click();
        return this;
    }

    // Validation Methods
    public HomePage isItemAddedToCart() {
        String count = driver.findElement(cartIconNumber).getText();
        Assert.assertEquals(count, "1");
        return this;
    }

    public CartPage isOnCartPage() {
        String title = driver.findElement(cartPageTitle).getText();
        Assert.assertEquals(title, "Your Cart");
        return new CartPage(driver);
    }
}
