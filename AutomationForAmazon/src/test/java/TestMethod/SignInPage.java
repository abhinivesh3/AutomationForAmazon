package TestMethod;

import Common.LocatorFile;
import Common.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class SignInPage {
    WebDriver driver;
    WebDriverWait driverWait;
    WaitClass waitClass =new WaitClass();
    LocatorFile locatorFile = new LocatorFile();
    private static final Logger LOGGER = Logger.getLogger(SignInPage.class.getName());

    public SignInPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        try {
            WebElement signIn = waitClass.waitForElementLocated(driverWait,locatorFile.signButton);
            signIn.click();
        } catch (Exception e) {
            LOGGER.severe("Failed to click on Sign In button: " + e.getMessage());
        }
    }

    public void enterEmail(String email) {
        try {
            WebElement emailId = waitClass.waitForElementLocated(driverWait, locatorFile.emailField);
            emailId.sendKeys(email + Keys.ENTER);
            waitClass.waitForElementAndClick(driverWait, locatorFile.continueButtonForEmail);
        } catch (Exception e) {
            LOGGER.severe("Failed to enter email: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            WebElement passwordBox = waitClass.waitForElementLocated(driverWait,locatorFile.passwordField);
            passwordBox.sendKeys(password + Keys.ENTER);
            waitClass.waitForElementAndClick(driverWait, locatorFile.signInButtonForPassword);
        } catch (Exception e) {
            LOGGER.severe("Failed to enter password: " + e.getMessage());
        }
    }
}
