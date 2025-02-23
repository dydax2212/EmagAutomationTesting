package EmagTests;

import HelperMethods.ElementsMethods;
import ObjectData.RegisterFormObjectData;
import Pages.HomePage;
import Pages.RegisterPage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class RegisterTests extends Hooks
{
    HomePage homePage;
    ElementsMethods elementsMethods;
    RegisterPage registerPage;
    private Map<String, RegisterFormObjectData> registerFormObjectDataMap;

    @Test
    public void metodaTest()
    {
        registerFormObjectDataMap = xmlReader.loadData("src/test/resources/registerFormData.xml", RegisterFormObjectData.class);
        RegisterFormObjectData data = registerFormObjectDataMap.get("dataSet_2");

        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        registerPage = new RegisterPage(getDriver());

        ChainTestListener.log("Chrome opened");

        //ACCEPT COOKIES
        homePage.clickOnAcceptCookies();

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
        homePage.closeBlackBanner();

        //GO TO REGISTRATION PAGE FROM MAIN WEBPAGE
        homePage.hoverContulMeu();

        //CLICK ON CONT NOU TO REGISTER
        homePage.clickOnContNou();

        //REGISTER TEST

        // Resolve the reCAPCHA manually
        registerPage.fillRegistrationForm(data);
        ChainTestListener.log("Registration finished.");
    }
}
