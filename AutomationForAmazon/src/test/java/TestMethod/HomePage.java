package TestMethod;

import Common.LocatorFile;
import Common.WaitClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class HomePage {
    WebDriver driver;
    WebDriverWait driverWait;
    LocatorFile locatorFile = new LocatorFile();
    WaitClass waitClass = new WaitClass();

    private static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String item) {
        try {
            WebElement searchItem = waitClass.waitForElementLocated(driverWait, locatorFile.searchBox);
            searchItem.sendKeys(item);
            waitClass.waitForElementAndClick(driverWait, locatorFile.searchIcon);
        }
        catch (Exception e){
            System.out.println("Failed to find search option : " + e.getMessage());
        }
    }
}
