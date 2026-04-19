package opencart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class LoginTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    String validMail = "kazkas@kazkas.com";
    String wrongPass = "asdfgh";

    @Test
    void loginTest() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);


        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        //type email
        loginPage.typeEmail(validMail);
        //type password
        loginPage.typePassword(validMail);
        //click login
        loginPage.clickLoginButton();
//        ASERT (new page!)
        //V1
        String expected = "My Account";
        //TODO Flaky method
        String actual = myAccountPage.getHeaderText();
        Assertions.assertThat(actual).isEqualTo(expected);
        //V2
        Assertions.assertThat(myAccountPage.isOpened()).isTrue();

    }

    @Test
    void loginTest_negative() {

       homePage = new HomePage(driver);
       loginPage = new LoginPage(driver);

       homePage.clickMyAccountLink();
       homePage.clickLoginLink();

        loginPage.typeEmail(validMail);
       loginPage.typePassword(wrongPass);
      loginPage.clickLoginButton();

         Assertions.assertThat(loginPage.getAlertText())
               .isEqualTo("Warning: No match for E-Mail Address and/or Password.");
    }

}