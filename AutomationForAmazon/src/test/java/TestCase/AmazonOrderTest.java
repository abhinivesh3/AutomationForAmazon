package TestCase;

import TestMethod.HomePage;
import TestMethod.ProductPage;
import TestMethod.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class AmazonOrderTest {
    WebDriver driver;
    WebDriverWait driverWait;
    SignInPage signInPage;
    HomePage homePage;
    ProductPage productPage;
    Set<Cookie> cookies;

    @BeforeSuite
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "/Users/abhi-21739/Downloads/chromedriver-mac-arm64/chromedriver");
        try{
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.navigate().to("https://www.amazon.in/");
            driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signInPage = new SignInPage(driver, driverWait);
            homePage = new HomePage(driver, driverWait);
            productPage = new ProductPage(driver, driverWait);
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    @Test
    public void loadCookies() {
        try {
            cookies = driver.manage().getCookies();
            System.out.println("The size of cookies  : " + cookies.size());
            for (Cookie cookie : cookies) {
                System.out.println(cookie);
            }
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "  " + cookie.getValue());
            }
//            System.out.println(driver.manage().getCookieNamed("session-id-time"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void loginAndSaveCookie() throws InterruptedException {
        try {
            Cookie obj =  new Cookie("phoneNo","6382990175");
            driver.manage().addCookie(obj);
            cookies = driver.manage().getCookies();

            System.out.println("The size of cookies  : " + cookies.size());

            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "  " + cookie.getValue());
            }

            driver.manage().deleteCookie(obj);
            cookies=driver.manage().getCookies();
            System.out.println("The size of cookies  : " + cookies.size());

            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "  " + cookie.getValue());
            }

            driver.manage().deleteAllCookies();
            cookies=driver.manage().getCookies();

            System.out.println("The size of cookies  : " + cookies.size());

            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "  " + cookie.getValue());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    @Test
//    public void orderProduct() throws InterruptedException {
//       try {
//           signInPage.clickSignInButton();
//           signInPage.enterInvalidEmail("abcd@gmail.com");
//           signInPage.enterEmail(">>>>");
//           signInPage.enterInvalidPassword("12345678");
//           signInPage.enterPassword(">>>>");
//
//           homePage.searchForItem("shoes");
//
//           productPage.selectProduct();
//
//           productPage.selectQuantity(4);
//
//           productPage.addToCard();
//
//           productPage.clickBuyNow();
//
//           allCookies=driver.manage().getCookies();
//
//           for(Cookie cookie: allCookies){
//               System.out.println("Cookies generated  are ==> "+cookie);
//           }
//       }
//       catch (Exception e){
//           System.out.println(e.getMessage());
//       }
//    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
