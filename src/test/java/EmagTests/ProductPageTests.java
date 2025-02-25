package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
import Pages.ProductPage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;

public class ProductPageTests  extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;
    ProductPage productPage;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        productPage = new ProductPage(getDriver());

        ChainTestListener.log("Chrome opened.");

        //ACCEPT COOKIES
        homePage.clickOnAcceptCookies();

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();

        //HOVER ON PC, PERIFERICE & SOFTWARE
        homePage.hoverOnPeriferice();

        //CLICK ON PLACI VIDEO
        homePage.clickOnSection();

        //CLICK ON A RANDOM PRODUCT
        productPage.selectRandomProduct();
        ChainTestListener.log("Random product selected.");

        //SCROLL TO DESCRIERE AND EXPAND
        productPage.scrollToDescription();
        ChainTestListener.log("Successfully scrolled to Descriere.");
        productPage.expandDescription();

        //SCROLL TO SPECIFICATII AND EXPAND
        productPage.scrollToSpecifications();
        ChainTestListener.log("Successfully scrolled to Specificatii.");
        productPage.expandSpecifications();

        //SCROLL TO DISCLAIMER
        productPage.scrollToDisclaimerSection();

        homePage.scrollToHeader();
        ChainTestListener.log("Successfully scrolled to header.");

        //ADD TO FAVORITE
        productPage.addToFavorites();

        //ADD TO CART
        productPage.addToCart();
     }
}
