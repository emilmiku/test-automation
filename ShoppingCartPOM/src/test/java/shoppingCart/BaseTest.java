package shoppingCart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Waiters;


public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        driver = new ChromeDriver(options);
        driver.get("https://testpages.eviltester.com/apps/basiccart/?page=1&limit=10");
    }

   @AfterEach
   void tearDown() {
        driver.quit();
    }
}
