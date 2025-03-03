package EmagTests;

import Logger.LoggerUtility;
import Pages.HomePage;
import Pages.ProductPage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends Hooks {
    HomePage homePage;
    ProductPage productPage;

    @Test
    public void metodaTest() {
        homePage = new HomePage(getDriver());
        productPage = new ProductPage(getDriver());

        LoggerUtility.infoTest("Test started: Navigating on eMAG website");
        ChainTestListener.log("Chrome opened");

        //ACCEPT COOKIES
        Assert.assertNotNull(homePage, "HomePage object is null!");
        homePage.clickOnAcceptCookies();
        LoggerUtility.infoTest("Cookies accepted.");

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();

        //HOVER ON PC, PERIFERICE & SOFTWARE
        homePage.hoverOnPeriferice();

        //CLICK ON PLACI VIDEO
        homePage.clickOnSection();

        //CLICK ON A RANDOM PRODUCT
        productPage.selectRandomProduct();
        ChainTestListener.log("Random product selected.");

        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("placa"), "Error: URL-ul nu conține 'placa', produsul nu s-a deschis corect!");
        ChainTestListener.log("URL verificat: " + currentUrl);

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

        Assert.assertEquals(productPage.getFavoriteConfirmationText(), "Produsul a fost adaugat la Favorite", "Error: Mesajul de confirmare pentru favorite nu este corect!");
        ChainTestListener.log("Mesaj Favorite verificat: " + productPage.getFavoriteConfirmationText());

        //ADD TO CART
        productPage.addToCart();

        Assert.assertEquals(productPage.getCartConfirmationText(), "Produsul a fost adaugat in cos", "Error: Mesajul de confirmare pentru coș nu este corect!");
        ChainTestListener.log("Mesaj Coș verificat: " + productPage.getCartConfirmationText());

        LoggerUtility.infoTest("Test finished successfully.");
    }
}
