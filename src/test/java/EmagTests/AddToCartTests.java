package EmagTests;

import Pages.HomePage;
import ShareDataBrowser.Hooks;
import org.testng.annotations.Test;

public class AddToCartTests  extends Hooks
{
    HomePage homePage;

    @Test
    public void metodaTest()
    {
        homePage = new HomePage(getDriver());

        homePage.clickOnAcceptCookies();

        homePage.closeBlackBanner();



    }
}
