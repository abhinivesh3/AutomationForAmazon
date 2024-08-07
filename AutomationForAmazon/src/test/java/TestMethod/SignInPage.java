package TestMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignInPage {
    WebDriver driver;
    WebDriverWait driverWait;
    String signButton = "nav-link-accountList";
    String emailField = "ap_email_login";
    String passwordField = "ap_password";

    public SignInPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public void clickSignInButton() {
        WebElement signIn = driver.findElement(By.id(signButton));
        signIn.click();
    }

    public void enterEmail(String email) {
        WebElement emailId = driver.findElement(By.id(emailField));
        emailId.sendKeys(email + Keys.ENTER);
    }

    public void enterPassword(String password) {
        WebElement passwordBox = driver.findElement(By.id(passwordField));
        passwordBox.sendKeys(password + Keys.ENTER);
    }
}
