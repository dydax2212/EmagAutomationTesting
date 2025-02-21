package EmagTests;

import HelperMethods.ElementsMethods;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleLoginTests extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;
    GoogleRegisterPage googleRegisterPage;

    @Test
    public void metodaTest() {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        googleRegisterPage = new GoogleRegisterPage(getDriver());

        //ACCEPT COOKIES
        homePage.clickOnAcceptCookies();
        elementsMethods.waitForSeconds(3);

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();
        elementsMethods.waitForSeconds(3);

        //GO TO REGISTRATION PAGE FROM MAIN WEBPAGE
        homePage.hoverContulMeu();
        elementsMethods.waitForSeconds(3);

        homePage.clickOnContNou();
        elementsMethods.waitForSeconds(3);

        //GOOGLE REGISTER TEST

        //CLICK ON GOOGLE REGISTRATION BUTTON
        googleRegisterPage.clickOnRegisterWithGoogle();
        Assert.assertTrue(googleRegisterPage.isGoogleRegistrationButtonEnabled());
        elementsMethods.waitForSeconds(3);

        //INSERT EMAIL
        googleRegisterPage.insertGmail("");
        Assert.assertTrue(googleRegisterPage.isEmailFieldDisplayed());
        elementsMethods.waitForSeconds(3);

        //INSERT PASSWORD
        googleRegisterPage.insertGmailPassword("");
        Assert.assertTrue(googleRegisterPage.isPasswordNotEmpty());
        elementsMethods.waitForSeconds(3);

        //CLICK NEXT
        googleRegisterPage.clickNext();
        Assert.assertTrue(googleRegisterPage.isNextButtonDisplayed());
        elementsMethods.waitForSeconds(3);



    }
}
