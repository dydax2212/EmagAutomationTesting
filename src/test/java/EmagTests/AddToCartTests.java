package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
import Pages.RegisterPage;
import ShareDataBrowser.Hooks;
import org.testng.annotations.Test;

public class AddToCartTests  extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());

        homePage.clickOnAcceptCookies();
//      homePage.clickOnRejectCookies();
        elementsMethods.waitForSeconds(3);

        homePage.closeBlackBanner();
        elementsMethods.waitForSeconds(3);



    }
}
