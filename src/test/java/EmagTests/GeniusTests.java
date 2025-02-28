package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.GeniusPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import org.testng.annotations.Test;

public class GeniusTests extends Hooks {
    HomePage homePage;
    ElementsMethods elementsMethods;
    GeniusPage geniusPage;

    @Test
    public void metodaTest() {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        geniusPage = new GeniusPage(getDriver());

        homePage.clickOnAcceptCookies();
//      homePage.clickOnRejectCookies();

        homePage.closeBlackBanner();

        geniusPage.locateNavBar();

        // Click on the Genius button from the homepage
        geniusPage.clickOnGeniusButton();

        // Enter locality and select from dropdown
        geniusPage.writeInLocalitateField("Sector 1");
        geniusPage.clickOnLocalitateDropdownButton();

        // Print availability message
        geniusPage.printAvailabilityMessage();

        // Navigate through service details
        geniusPage.clickOnEmagDetails();
        geniusPage.clickOnTazzDetails();
        geniusPage.clickOnFashionDaysDetails();
        geniusPage.clickOnFreshfulDetails();

        // Click the button Incearca gratuit 3 luni
        geniusPage.clickOnTryFor3Months();


    }
}
