package EmagTests;

import Logger.LoggerUtility;
import Pages.FavoritePage;
import Pages.HomePage;
import Pages.ProductPage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.nimbusds.openid.connect.sdk.assurance.IdentityTrustFramework;
import org.testng.annotations.Test;

public class FavoriteTests  extends Hooks
{
    HomePage homePage;
    FavoritePage favoritePage;
    ProductPage productPage;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());
        favoritePage = new FavoritePage(getDriver());
        productPage = new ProductPage(getDriver());

        LoggerUtility.infoTest("Test started: Navigating on eMAG website");
        ChainTestListener.log("Chrome opened");

        homePage.clickOnAcceptCookies();

        homePage.closeBlackBanner();

        favoritePage.selectRandomProduct();

        favoritePage.clickOnAddToFavorite();
        productPage.getFavoriteConfirmationText();

        favoritePage.checkFavoriteCounter(1);

        favoritePage.checkProductInFavorite();

        favoritePage.addToCartFromDropdown();

        favoritePage.removeFromDropdown();

        favoritePage.checkFavoriteCounter(0);

        favoritePage.goToFavoritePage();

        favoritePage.goBackToHomePage();

        LoggerUtility.infoTest("Test finished successfully.");
    }
}
