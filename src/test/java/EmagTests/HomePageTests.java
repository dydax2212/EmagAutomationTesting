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
        homePage.clickOnAcceptCookies();
        ChainTestListener.log("Cookies accepted.");

//        homePage.clickOnRejectCookies();
//        ChainTestListener.log("Cookies rejected.");

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
         homePage.closeBlackBanner();
         ChainTestListener.log("Login sticky black banner closed.");

        //SCROLL TO THE MIDDLE OF THE WEBPAGE
        elementsMethods.scrollToHalfPage();
        ChainTestListener.log("SCROLL TO THE MIDDLE OF THE WEBPAGE");

        //SCROLL TO THE END OF THE WEBPAGE
        homePage.scrollToFooter();
        ChainTestListener.log("SCROLL TO THE END OF THE WEBPAGE");

        //SCROLL TO THE TOP OF THE WEBPAGE
        homePage.scrollToHeader();
        ChainTestListener.log("SCROLL TO THE TOP OF THE WEBPAGE");

        //HOVER ON PC, PERIFERICE & SOFTWARE
        homePage.hoverOnPeriferice();
        ChainTestListener.log("HOVER ON PC, PERIFERICE & SOFTWARE");

        //CLICK ON PLACI VIDEO
        homePage.clickOnSection();
        ChainTestListener.log("CLICK ON PLACI VIDEO");

        //CLICK ON EMAG ICON FROM THE HEADER
        homePage.clickOnEmag();
        ChainTestListener.log("CLICK ON EMAG ICON FROM THE HEADER");

        //CLICK ON THE FIRST PRODUCT SHOWN ON THE WEBPAGE
        homePage.clickOnProduct();
        ChainTestListener.log("CLICK ON THE FIRST PRODUCT SHOWN ON THE WEBPAGE");

        //CLICK ON EMAG ICON FROM THE HEADER
        homePage.clickOnEmag();
        ChainTestListener.log("CLICK ON EMAG ICON FROM THE HEADER");


    }
}
