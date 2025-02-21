package EmagTests;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import ObjectData.GoogleLoginObjectData;
import Pages.GoogleLoginPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class GoogleLoginTests extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;
    GoogleLoginPage googleLoginPage;
    private Map<String, GoogleLoginObjectData> googleLoginObjectDataMap;

    @Test
    public void metodaTest() {

        googleLoginObjectDataMap = xmlReader.loadData("src/test/resources/gmailLoginData.xml", GoogleLoginObjectData.class);
        GoogleLoginObjectData data = googleLoginObjectDataMap.get("dataSet_1");

        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        googleLoginPage = new GoogleLoginPage(getDriver());

        //ACCEPT COOKIES
        homePage.clickOnAcceptCookies();
        ChainTestListener.log("Cookies where accepted.");

        //
        homePage.clickOnLoginFromStickyBlackBanner();
        ChainTestListener.log("Clicked on login button from black banner");

        //GOOGLE LOGIN TEST

        //Use debug at line 72 from GoogleLoginPage to resolve the reCAPCHA manually

        googleLoginPage.fillGmailLoginForm(data);
        ChainTestListener.log("All data typed and error message received.");

    }
}
