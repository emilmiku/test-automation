package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;


public class CartPage extends BasePage {


    @FindBy(css = "div.cart-item")
    private WebElement cartItem;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getCartItemID() {
        Waiters.waitForVisibility(driver, By.cssSelector("#cartContainer"));
       return cartItem.getAttribute("data-id");
    }



}
