package opencart;

import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import pageobjects.YourAccountHasBeenCreated;
import utils.DataGenerator;

import org.assertj.core.api.Assertions;
import static utils.DataGenerator.generateEmail;

public class RegisterTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    YourAccountHasBeenCreated yourAccountHasBeenCreated;

    @Test
    public void userCanRegisterTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);
        YourAccountHasBeenCreated yourAccountHasBeenCreated = new YourAccountHasBeenCreated(driver);
        String pass = "12345";

        DataGenerator.generateEmail();
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registerPage.typeFirstName("John");
        registerPage.typeLastName("Doe");
        registerPage.typeEmail(generateEmail());
        registerPage.typeTelephone("1234567890");
        registerPage.typePassword(pass);
        registerPage.typeConfirmPassword(pass);
        registerPage.clickAgreeButton();
        registerPage.clickContinueButton();

        String actual = yourAccountHasBeenCreated.getParagraph();
        String expected = "Congratulations! Your new account has been successfully created!";
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    void userCantRegisterWithoutAgreePolicy() {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);
        YourAccountHasBeenCreated yourAccountHasBeenCreated = new YourAccountHasBeenCreated(driver);
        String pass = "12345";

        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registerPage.typeFirstName("John");
        registerPage.typeLastName("Doe");
        registerPage.typeEmail(generateEmail());
        registerPage.typeTelephone("1234567890");
        registerPage.typePassword(pass);
        registerPage.typeConfirmPassword(pass);
        registerPage.clickContinueButton();

        Assertions.assertThat(registerPage.getAlertText())
                .isEqualTo("Warning: You must agree to the Privacy Policy!");
    }

}
