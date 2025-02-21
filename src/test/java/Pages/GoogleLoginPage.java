package Pages;

import HelperMethods.ElementsMethods;
import ObjectData.GoogleLoginObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLoginPage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(xpath = "//*[@class='btn btn-social google mt-md']")
    WebElement googleSignIn;

    @FindBy(css = "#identifierId")
    WebElement gmailField;

    @FindBy(css = "#identifierNext > div > button > span")
    WebElement nextStepButton;

    @FindBy(xpath = "//*[@class='whsOnd zHQkBf'][1]")
    WebElement gmailPasswordField;

    @FindBy(xpath = "//*[@class='VfPpkd-muHVFf-bMcfAe']")
    WebElement showPasswordToggle;

    @FindBy(css = "#passwordNext > div > button")
    WebElement gmailContinueButton;

    @FindBy(id = "validate_mfa_phone_phone")
    WebElement phoneField;

    @FindBy(id = "validate_mfa_phone_continue")
    WebElement trimiteSMSButton;

    @FindBy(xpath = "//*[@class='help-block text-left']")
    WebElement errorMessage;

    public GoogleLoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver,this);
    }

    // METODE

    public void fillGmailLoginForm(GoogleLoginObjectData data)
    {
        elementsMethods.clickOnElement(googleSignIn);

        elementsMethods.waitUntilElementIsPresent(gmailField);
        elementsMethods.fillElement(gmailField, data.getEmail());
        System.out.println("Email typed successfully.");

        elementsMethods.waitForSeconds(4); //waitUntilElementIsPresent didn't work, and it gave Assert error: found as false
        elementsMethods.clickOnElement(nextStepButton);
        System.out.println("Next step button clicked.");

        elementsMethods.waitForSeconds(4); //waitUntilElementIsPresent didn't work, and it gave Assert error: found as false
        elementsMethods.fillElement(gmailPasswordField, data.getPassword());
        System.out.println("Password typed successfully.");

        elementsMethods.clickOnElement(showPasswordToggle);
        System.out.println("Show password toggle enabled.");

        elementsMethods.clickOnElement(gmailContinueButton);
        System.out.println("Continue button clicked.");

        elementsMethods.waitUntilElementIsPresent(phoneField);
        elementsMethods.fillElement(phoneField, data.getPhoneNumber());  // Manually resolve the reCAPCHA and resume run.
        System.out.println("Phone number typed successfully.");

        elementsMethods.waitUntilElementIsPresent(trimiteSMSButton);
        elementsMethods.clickOnElement(trimiteSMSButton);
        System.out.println("'Trimite SMS' button clicked.");

        elementsMethods.waitUntilElementIsPresent(errorMessage);
        errorMessage.isDisplayed();
        System.out.println("Error message: " + errorMessage.getText());
    }
}
