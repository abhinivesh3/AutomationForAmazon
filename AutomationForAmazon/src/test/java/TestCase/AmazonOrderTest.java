package TestCase;

import TestMethod.HomePage;
import TestMethod.ProductPage;
import TestMethod.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonOrderTest {
    WebDriver driver;
    WebDriverWait driverWait;
    SignInPage signInPage;
    HomePage homePage;
    ProductPage productPage;

    @BeforeSuite
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "/Users/abhi-21739/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.amazon.in/");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        signInPage = new SignInPage(driver,driverWait);
        homePage = new HomePage(driver,driverWait);
        productPage = new ProductPage(driver,driverWait);
    }

    @Test
    public void orderProduct() throws InterruptedException {
        signInPage.clickSignInButton();
        signInPage.enterEmail("****");
        signInPage.enterPassword("****");

        homePage.searchForItem("shoes");

        productPage.selectProduct();

        productPage.selectQuantity(4);

        productPage.addToCard();

        productPage.clickBuyNow();
    }

//    @AfterSuite
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
