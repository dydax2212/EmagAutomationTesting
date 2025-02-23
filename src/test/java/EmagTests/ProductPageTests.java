package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
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

        ChainTestListener.log("Chrome opened");

        //ACCEPT COOKIES
        homePage.clickOnAcceptCookies();
        ChainTestListener.log("Cookies where accepted.");

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();

        //HOVER ON PC, PERIFERICE & SOFTWARE
        homePage.hoverOnPeriferice();
        ChainTestListener.log("HOVER ON PC, PERIFERICE & SOFTWARE");

        //CLICK ON PLACI VIDEO
        homePage.clickOnSection();
        ChainTestListener.log("CLICK ON PLACI VIDEO");

        //CLICK ON A PRODUCT


        //SCROLL TO SPECIFICATII


        //CLICK ON DROPDOWN BUTTON


        //SEARCH FOR ...


    }
}
