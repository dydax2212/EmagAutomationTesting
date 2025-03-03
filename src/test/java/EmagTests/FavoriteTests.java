package EmagTests;

import Logger.LoggerUtility;
import Pages.FavoritePage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;

public class FavoriteTests  extends Hooks
{
    HomePage homePage;
    FavoritePage favoritePage;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());
        favoritePage = new FavoritePage(getDriver());

        LoggerUtility.infoTest("Test started: Navigating on eMAG website");
        ChainTestListener.log("Chrome opened");

        homePage.clickOnAcceptCookies();

        homePage.closeBlackBanner();

        favoritePage.selectRandomProduct();

        favoritePage.clickOnAddToFavorite();

        favoritePage.checkFavoriteCounter(1);



        LoggerUtility.infoTest("Test finished successfully.");
    }
}
