package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import org.testng.annotations.Test;

public class ProductPageTests  extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());

        homePage.clickOnAcceptCookies();
        elementsMethods.waitForSeconds(3);

        homePage.closeBlackBanner();
        elementsMethods.waitForSeconds(3);

        //LOGIN

        //HOVER ON PC, PERIFERICE & SOFTWARE

        //CLICK ON PLACI VIDEO

        //SCROLL TO SPECIFICATII

        //CLICK ON DROPDOWN BUTTON

        //SEARCH FOR ...

    }
}
