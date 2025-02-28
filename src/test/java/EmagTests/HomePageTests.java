package EmagTests;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends Hooks {
    HomePage homePage;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());

        LoggerUtility.infoTest("Test started: Navigating on eMAG website");
        ChainTestListener.log("Chrome opened");

        // ACCEPT OR REJECT COOKIES
        Assert.assertNotNull(homePage, "HomePage object is null!");
        homePage.clickOnAcceptCookies();
        LoggerUtility.infoTest("Cookies accepted.");
        ChainTestListener.log("Checked: Cookies accepted.");

        // CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();
        LoggerUtility.infoTest("Sticky black banner closed.");
        ChainTestListener.log("Checked: Sticky black banner closed.");

        // SCROLL TO THE MIDDLE OF THE WEBPAGE
        elementsMethods.scrollToHalfPage();
        LoggerUtility.infoTest("Scrolled to the middle of the page.");
        ChainTestListener.log("Checked: Scrolled to the middle of the page.");

        // SCROLL TO THE END OF THE WEBPAGE
        homePage.scrollToFooter();
        LoggerUtility.infoTest("Footer is visible after scrolling.");
        ChainTestListener.log("Checked: Footer is visible.");

        // SCROLL TO THE TOP OF THE WEBPAGE
        homePage.scrollToHeader();
        LoggerUtility.infoTest("Header is visible after scrolling.");
        ChainTestListener.log("Checked: Header is visible.");

        // HOVER ON PC, PERIFERICE & SOFTWARE
        homePage.hoverOnPeriferice();
        LoggerUtility.infoTest("Hover on 'Plăci Video' successful.");
        ChainTestListener.log("Checked: Hover on 'Plăci Video' successful.");

        // CLICK ON PLACI VIDEO
        homePage.clickOnSection();
        LoggerUtility.infoTest("Clicked on 'Plăci Video' section.");
        ChainTestListener.log("Checked: Click on 'Plăci Video' successful.");

        // CLICK ON EMAG ICON FROM THE HEADER
        homePage.clickOnEmag();
        LoggerUtility.infoTest("Clicked on eMAG icon.");
        ChainTestListener.log("Checked: Click on eMAG icon successful.");

        // CLICK ON THE FIRST PRODUCT SHOWN ON THE WEBPAGE
        homePage.clickOnProduct();
        LoggerUtility.infoTest("Clicked on a product.");
        ChainTestListener.log("Checked: Click on a product successful.");

        // CLICK ON EMAG ICON FROM THE HEADER AGAIN
        homePage.clickOnEmag();
        LoggerUtility.infoTest("Clicked on eMAG icon again.");
        ChainTestListener.log("Checked: Click on eMAG icon successful (second time).");

        LoggerUtility.infoTest("Test finished successfully.");
    }
}
