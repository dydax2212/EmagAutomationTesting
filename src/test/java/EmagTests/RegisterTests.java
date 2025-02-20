package EmagTests;

import HelperMethods.ElementsMethods;
import ObjectData.RegisterFormObjectData;
import Pages.HomePage;
import Pages.RegisterPage;
import ShareDataBrowser.Hooks;
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

        //ACCEPT COOKIES
  //      homePage.clickOnAcceptCookies();
  //      elementsMethods.waitForSeconds(3);

        //CLOSE LOGIN STICKY BANNER FROM THE BOTTOM OF THE WEBPAGE
 //       homePage.closeBlackBanner();
  //      elementsMethods.waitForSeconds(3);

        //GO TO REGISTRATION PAGE FROM MAIN WEBPAGE
        homePage.hoverContulMeu();
        elementsMethods.waitForSeconds(3);

        homePage.clickOnContNou();
        elementsMethods.waitForSeconds(3);

        //REGISTER TEST

        registerPage.fillRegistrationForm(data);

//        //INSERT EMAIL
//        registerPage.insertEmail("test12gsgs3@gmail.com");
//        Assert.assertTrue(registerPage.isEmailFieldDisplayed());
//        elementsMethods.waitForSeconds(3);
//
//        //CLICK ON CONTINUE BUTTON
//        registerPage.clickLoginContinueButton();
//        Assert.assertTrue(registerPage.isLoginContinueButtonEnable());
//        elementsMethods.waitForSeconds(30);
//
//        //INSERT FULL NAME
//        registerPage.insertFullName("Test Test-Test");
//        Assert.assertTrue(registerPage.isNameFieldDisplayed());
//        elementsMethods.waitForSeconds(3);
//
//        //INSERT FIRST PASSWORD
//        registerPage.insertFirstPassword("Test123!");
//        Assert.assertTrue(registerPage.isPasswordNotEmpty());
//        elementsMethods.waitForSeconds(3);
//
//        //CONFIRM PASSWORD
//        registerPage.insertSecondPassword("Test123!");
//        Assert.assertTrue(registerPage.isConfirmPasswordNotEmpty());
//        elementsMethods.waitForSeconds(3);
//
//        //ACCEPT TERMS AND CONDITIONS
//        registerPage.clickOnTerms();
//        Assert.assertTrue(registerPage.isTermsCheckboxSelected());
//
//        //ACCEPT TO JOIN THE NEWSLETTER
//        registerPage.clickOnNews();
//        Assert.assertTrue(registerPage.isNewsCheckboxSelected());
//        elementsMethods.waitForSeconds(3);
//
//        //CONFIRM REGISTRATION
//        Assert.assertTrue(registerPage.isContinueButtonDisplayed());
//        registerPage.clickOnContinue();
    }
}
