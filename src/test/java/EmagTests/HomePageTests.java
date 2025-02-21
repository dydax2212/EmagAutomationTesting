package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;

public class HomePageTests extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());

        ChainTestListener.log("Chrome opened");

        //ACCEPT OR REJECT COOKIES
//      homePage.clickOnAcceptCookies();
        homePage.clickOnRejectCookies();
        elementsMethods.waitForSeconds(2);

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
         homePage.closeBlackBanner();

        //SCROLL TO THE MIDDLE OF THE WEBPAGE
        elementsMethods.scrollToHalfPage();
        ChainTestListener.log("SCROLL TO THE MIDDLE OF THE WEBPAGE");
        elementsMethods.waitForSeconds(2);

        //SCROLL TO THE END OF THE WEBPAGE
        homePage.scrollToFooter();
        ChainTestListener.log("SCROLL TO THE END OF THE WEBPAGE");
        elementsMethods.waitForSeconds(2);

        //SCROLL TO THE TOP OF THE WEBPAGE
        homePage.scrollToHeader();
        ChainTestListener.log("SCROLL TO THE TOP OF THE WEBPAGE");
        elementsMethods.waitForSeconds(2);

        //HOVER ON PC, PERIFERICE & SOFTWARE
        homePage.hoverOnPeriferice();
        ChainTestListener.log("HOVER ON PC, PERIFERICE & SOFTWARE");
        elementsMethods.waitForSeconds(2);

        //CLICK ON PLACI VIDEO
        homePage.clickOnSection();
        ChainTestListener.log("CLICK ON PLACI VIDEO");
        elementsMethods.waitForSeconds(2);

        //CLICK ON EMAG ICON FROM THE HEADER
        homePage.clickOnEmag();
        ChainTestListener.log("CLICK ON EMAG ICON FROM THE HEADER");
        elementsMethods.waitForSeconds(2);

        //CLICK ON THE FIRST PRODUCT SHOWN ON THE WEBPAGE
        homePage.clickOnProduct();
        ChainTestListener.log("CLICK ON THE FIRST PRODUCT SHOWN ON THE WEBPAGE");
        elementsMethods.waitForSeconds(2);

        //CLICK ON EMAG ICON FROM THE HEADER
        homePage.clickOnEmag();
        ChainTestListener.log("CLICK ON EMAG ICON FROM THE HEADER");



    }
}
