import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    // Variables
    WebDriver driver;

    // Locators
    private final By addToCartButton = By.cssSelector(".inventory_item_description #add-to-cart-sauce-labs-backpack");
    private final By cartIconNumber = By.cssSelector(".shopping_cart_badge");

    // Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public HomePage addItemToCart(){
        driver.findElement(addToCartButton).click();
        return this;
    }

    public HomePage isItemAddedToCart() {
        String count = driver.findElement(cartIconNumber).getText();
        Assert.assertEquals(count, "1");
        return this;
    }



}
