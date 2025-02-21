package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.GoogleLoginPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleLoginTests extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;
    GoogleLoginPage googleLoginPage;

    @Test
    public void metodaTest() {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        googleLoginPage = new GoogleLoginPage(getDriver());

        //ACCEPT COOKIES
        homePage.clickOnAcceptCookies();
        elementsMethods.waitForSeconds(3);

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();
        elementsMethods.waitForSeconds(3);

        //GO TO REGISTRATION PAGE FROM MAIN WEBPAGE
        homePage.hoverContulMeu();
        elementsMethods.waitForSeconds(3);

        homePage.clickOnContNou();
        elementsMethods.waitForSeconds(3);


        //GOOGLE LOGIN TEST





    }
}
