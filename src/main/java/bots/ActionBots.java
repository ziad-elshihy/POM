package bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionBots {
    // init driver
    private final WebDriver driver;
    private final WaitBot waitBot;
    // Constructor
    public ActionBots(WebDriver driver) {
        this.driver = driver;
        this.waitBot = new WaitBot(driver);
    }

    // Action Methods
    public void type(By locator, String text) {
        waitBot.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                new Actions(driver).scrollToElement(element);
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void click(By locator) {
        waitBot.fluentWait().until(d -> {
            try{
                WebElement element = d.findElement(locator);
                new Actions(driver).scrollToElement(element);
                element.click();
                return true;
            } catch (Exception e){
                return false;
            }
        });

    }

    public String getText(By locator) {
        return waitBot.fluentWait().until(d -> {
            try{
                WebElement element = d.findElement(locator);
                new Actions(driver).scrollToElement(element);
                String text = element.getText();
                return !text.isEmpty() ? text : null;
            } catch (Exception e){
                return null;
            }
        });
    }
}
