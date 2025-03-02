package EmagTests;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;

public class FavoriteTests  extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());

        LoggerUtility.infoTest("Test started: Navigating on eMAG website");
        ChainTestListener.log("Chrome opened");

        homePage.clickOnAcceptCookies();

        homePage.closeBlackBanner();


        LoggerUtility.infoTest("Test finished successfully.");
    }
}
