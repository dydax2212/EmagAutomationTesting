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

    @FindBy(xpath = "//*[@class='btn btn-social google mt-md']")
    WebElement googleSignIn;

    @FindBy(id = "identifierId")
    WebElement gmailField;

    @FindBy(css = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
    WebElement gmailPasswordField;

    @FindBy(xpath = "//*[@class='VfPpkd-muHVFf-bMcfAe']")
    WebElement showPasswordToggle;

    @FindBy(css = "#yDmH0d > c-wiz > div > div.JYXaTc.F8PBrb > div > div > div:nth-child(2) > div > div > button")
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

    public void fillGmailLoginForm(GoogleLoginObjectData data)
    {
        elementsMethods.clickOnElement(googleSignIn);
        elementsMethods.fillElement(gmailField, data.getEmail());
        elementsMethods.fillElement(gmailPasswordField, data.getPassword());
        elementsMethods.clickOnElement(showPasswordToggle);
        elementsMethods.clickOnElement(gmailContinueButton);
        elementsMethods.fillElement(phoneField, data.getPhoneNumber());
        elementsMethods.clickOnElement(trimiteSMSButton);
    }

    public boolean errorMessageIsDisplayed()
    {
        return errorMessage.isDisplayed();
    }
}
