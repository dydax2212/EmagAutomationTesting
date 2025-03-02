package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
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

        homePage.closeBlackBanner();



    }
}
