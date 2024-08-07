package TestMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait driverWait;

    String  searchBox = "twotabsearchtextbox";

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public void searchForItem(String item) {
        WebElement search = driver.findElement(By.id(searchBox));
        search.sendKeys(item + Keys.ENTER);
    }
}
