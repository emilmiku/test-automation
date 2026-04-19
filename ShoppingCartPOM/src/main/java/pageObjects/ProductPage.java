package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;


public class ProductPage extends BasePage {


    @FindBy(css = "#cartCount")
    private WebElement cartCount;

    @FindBy(css = ".cart-icon")
    private WebElement cartIcon;


    public ProductPage(WebDriver driver) {

        super(driver);
    }
    public void addToCart(String productID) {
        Waiters.waitForVisibility(driver, By.cssSelector("#productGrid"));
        driver.findElement(By.xpath("//button[@class='add'][@data-id='" + productID + "']")).click();
    }
    public String getCartCount() {

        return cartCount.getText();
    }
    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickView(String title) {
        WebElement viewButton = driver.findElement(By.xpath("//*[normalize-space(text())='" + title + "']/parent::*//*[contains(@class,'view')]"));
        viewButton.click();
    }



}
