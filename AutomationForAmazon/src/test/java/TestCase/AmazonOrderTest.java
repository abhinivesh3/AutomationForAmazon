package TestCase;

import TestMethod.HomePage;
import TestMethod.ProductPage;
import TestMethod.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AmazonOrderTest {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    ProductPage productPage;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/abhi-21739/Downloads/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.amazon.in/");
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void orderProduct() throws InterruptedException {
        signInPage.clickSignInButton();
        signInPage.enterEmail("....");
        signInPage.enterPassword("....");

        homePage.searchForItem("shoes");
        Thread.sleep(3000);

        productPage.selectProduct();
        Thread.sleep(3000);

        productPage.selectQuantity(5);
        Thread.sleep(3000);

        productPage.clickBuyNow();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
