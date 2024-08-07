package TestMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    WebDriver driver;

    String signButton = "nav-link-accountList";
    String emailField = "ap_email_login";
    String passwordField = "ap_password";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
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
