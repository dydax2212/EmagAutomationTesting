package EmagTests;

import Logger.LoggerUtility;
import Pages.GeniusPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeniusTests extends Hooks {
    HomePage homePage;
    GeniusPage geniusPage;

    @Test
    public void metodaTest() {
        homePage = new HomePage(getDriver());
        geniusPage = new GeniusPage(getDriver());

        LoggerUtility.infoTest("Test started: Navigating on eMAG website");
        ChainTestListener.log("Chrome opened");

        Assert.assertNotNull(homePage, "HomePage object is null!");
        homePage.clickOnAcceptCookies();
        LoggerUtility.infoTest("Cookies accepted.");

        homePage.closeBlackBanner();
        LoggerUtility.infoTest("Sticky black banner closed.");

        //Locate navigation bar
        homePage.locateNavBar();
        LoggerUtility.infoTest("Navigation bar located.");

        // Click on the Genius button from the homepage
        homePage.clickOnGeniusButton();
//
        // Navigate through service details
        geniusPage.clickOnEmagDetails();
        geniusPage.clickOnTazzDetails();
        geniusPage.clickOnFashionDaysDetails();
        geniusPage.clickOnFreshfulDetails();

        // Click the 'Incearca gratuit 3 luni' button
        geniusPage.clickOnTryFor3Months();

        //Move sliders right and left
        geniusPage.moveEmagSlider();
        geniusPage.moveFashionDaysSlider();
        geniusPage.moveTazzSlider();
        geniusPage.moveFreshfulSlider();

        //Get a total of how much you will save
        geniusPage.getTotal();

        LoggerUtility.infoTest("Test finished successfully.");
    }
}
