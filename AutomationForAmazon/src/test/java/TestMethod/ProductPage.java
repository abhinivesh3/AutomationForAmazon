package TestMethod;

import Common.LocatorFile;
import Common.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class ProductPage {
    WebDriver driver;
    WebDriverWait driverWait;
    LocatorFile locatorFile = new LocatorFile();
    WaitClass waitClass = new WaitClass();

    private static final Logger LOGGER = Logger.getLogger(ProductPage.class.getName());

    public ProductPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver,this);
    }

    public void selectProduct() {
        try {
            waitClass.waitForElementAndClick(driverWait, locatorFile.product);
            switchToNewWindow();
        }
        catch (Exception e) {
            System.out.println("Failed to click on select the product : " + e.getMessage());
        }
    }

    private void switchToNewWindow() {
        Set<String> handles = driver.getWindowHandles();
        for (String newWindow : handles) {
            driver.switchTo().window(newWindow);
        }
    }

    public void selectQuantity(int index) {
        try {
            Select quantity = (Select) waitClass.waitForElementLocated(driverWait,locatorFile.quantityDropdown);
            quantity.selectByIndex(index);
        }
        catch (Exception e){
            System.out.println("Failed to click on select the product quantity : " + e.getMessage());
        }
    }

    public void addToCard() {
        try {
            waitClass.waitForElementAndClick(driverWait,locatorFile.addToCartButton);
            //waitClass.waitForElementAndClick(driverWait,locatorFile.addToCartIcon);

        }
        catch(Exception e) {
            System.out.println("Failed to click on add to card : " + e.getMessage());
        }
    }

    public void clickBuyNow() {
        try {
            waitClass.waitForElementAndClick(driverWait,locatorFile.buyButton);
        }
        catch (Exception e){
            System.out.println("Failed to click on Buy option : " + e.getMessage());
        }
    }
}
