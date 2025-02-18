package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
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

        //ACCEPT OR REJECT COOKIES
        homePage.clickOnAcceptCookies();
//      homePage.clickOnRejectCookies();

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();

        //SCROLL TO THE MIDDLE OF THE WEBPAGE
        elementsMethods.scrollToHalfPage();

        //SCROLL TO THE END OF THE WEBPAGE
        homePage.scrollToFooter();

        //SCROLL TO THE TOP OF THE WEBPAGE
        homePage.scrollToHeader();

        //HOVER ON PC, PERIFERICE & SOFTWARE
        homePage.hoverOnPeriferice();

        //CLICK ON PLACI VIDEO
        homePage.clickOnSection();

        //CLICK ON EMAG ICON FROM THE HEADER
        homePage.clickOnEmag();

        //CLICK ON THE FIRST PRODUCT SHOWN ON THE WEBPAGE
        homePage.clickOnProduct();

        //CLICK ON EMAG ICON FROM THE HEADER
        homePage.clickOnEmag();


    }

}
