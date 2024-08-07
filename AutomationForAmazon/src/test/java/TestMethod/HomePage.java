package TestMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    String  searchBox = "twotabsearchtextbox";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForItem(String item) {
        WebElement search = driver.findElement(By.id(searchBox));
        search.sendKeys(item + Keys.ENTER);
    }
}
