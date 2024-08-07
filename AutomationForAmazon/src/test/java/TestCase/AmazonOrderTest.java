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
        signInPage = new SignInPage(driver,driverWait);
        homePage = new HomePage(driver,driverWait);
        productPage = new ProductPage(driver,driverWait);
    }

    @Test
    public void orderProduct() throws InterruptedException {
        signInPage.clickSignInButton();
        signInPage.enterEmail("6382990175");
        signInPage.enterPassword("abhi8983");

        homePage.searchForItem("shoes");

        productPage.selectProduct();

        productPage.selectQuantity(5);

        productPage.clickBuyNow();
    }

//    @AfterSuite
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
