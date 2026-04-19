package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class ProductDetailPage extends BasePage {

    @FindBy(css = ".title")
    public WebElement productTitle;

    public ProductDetailPage(WebDriver driver) {

        super(driver);
    }

    public String getProductTitle() {

        Waiters.waitForVisibility(driver, By.cssSelector("#productContainer"));
        return productTitle.getText();
    }

}
