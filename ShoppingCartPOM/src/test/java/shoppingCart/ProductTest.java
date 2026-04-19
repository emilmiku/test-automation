package shoppingCart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pageObjects.CartPage;
import pageObjects.ProductDetailPage;
import pageObjects.ProductPage;


public class ProductTest extends BaseTest {

    ProductPage productPage;
    CartPage cartPage;
    String productID = "1";
    ProductDetailPage productDetailPage;


    @Test
    void addToCartTest() {
        productPage = new ProductPage(driver);

        productPage.addToCart(productID);
        String expected = "1";
        String actual = productPage.getCartCount();
        Assertions.assertThat(actual).isEqualTo(expected);
        productPage.clickCartIcon();


        cartPage = new CartPage(driver);
        Assertions.assertThat(productID).isEqualTo(cartPage.getCartItemID());
    }

    @Test
    void viewProductTest() {
        String expectedProduct = "Mystic Apparatus 1";
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        productPage.clickView(expectedProduct);
        String actualProduct = productDetailPage.getProductTitle();
        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);
    }

}
