package TestMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class ProductPage {
    WebDriver driver;

    String product = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[1]/div";
    String quantityDropdown ="#native_dropdown_selected_size_name";
    String buyNowButton ="buy-now-button";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct() {
        WebElement productItem=driver.findElement(By.xpath(product));
        productItem.click();
        switchToNewWindow();
    }

    private void switchToNewWindow() {
        Set<String> handles = driver.getWindowHandles();
        for (String newWindow : handles) {
            driver.switchTo().window(newWindow);
        }
    }

    public void selectQuantity(int index) {
        Select quantity = new Select(driver.findElement(By.cssSelector(quantityDropdown)));
        quantity.selectByIndex(index);
    }

    public void clickBuyNow() {
        WebElement buy=driver.findElement(By.id(buyNowButton));
        buy.click();
    }
}
