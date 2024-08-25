package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class WaitClass {
    private static final Logger LOGGER = Logger.getLogger(WaitClass.class.getName());
    public WebElement waitForElementLocated(WebDriverWait driverWait,By locator){
        try{
            return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch(Exception e){
            System.out.println("Element not found: " + locator.toString() + " - " + e.getMessage());
            throw e;
        }
    }

    public void waitForElementAndClick(WebDriverWait driverWait,By locator){
        try{
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        }
        catch(Exception e){
            System.out.println("Element not found: " + locator.toString() + " - " + e.getMessage());
        }
    }

    public boolean waitForElementAndClickForDisplay(WebDriverWait driverWait,By locator){
        try{
            return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        }
        catch (Exception e){
            System.out.println("Element not found: " + locator.toString() + " - " + e.getMessage());
        }
        return false;
    }
}
