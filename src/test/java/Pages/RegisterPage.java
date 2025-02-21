package Pages;

import HelperMethods.ElementsMethods;
import ObjectData.RegisterFormObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    ElementsMethods elementsMethods;

    // Registration elements

    @FindBy(id = "user_login_continue")
    WebElement loginContinueButton;

    @FindBy(id = "user_login_email")
    WebElement emailField;

    @FindBy(id = "user_register_full_name")
    WebElement nameField;

    @FindBy(id = "user_register_password_first")
    WebElement firstPassword;

    @FindBy(id = "user_register_password_second")
    WebElement secondPassword;

    @FindBy(css = "body > div.auth-box.text-center > div.auth-panel > div.auth-panel-body > div.mt-md > form > div:nth-child(7) > div.form-check > label")
    WebElement acceptTerms;

    @FindBy(css = "body > div.auth-box.text-center > div.auth-panel > div.auth-panel-body > div.mt-md > form > div:nth-child(8) > div.form-check > label")
    WebElement subscribeToNews;

    @FindBy(id = "user_register_continue")
    WebElement registrationContinueButton;

    @FindBy(css = "#validate_mfa_phone_phone")
    WebElement phoneNumber;

    @FindBy(css = "#validate_mfa_phone_continue")
    WebElement trimiteSMSButton;

    @FindBy(css = "body > div.auth-box.text-center > div.auth-panel > div.auth-panel-body > div:nth-child(4) > form > div.form-group.has-error > div > div")
    WebElement errorMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillRegistrationForm(RegisterFormObjectData data)
    {
        elementsMethods.waitUntilElementIsPresent(emailField);
        elementsMethods.fillElement(emailField, data.getEmail());
        System.out.println("Email typed successfully.");

        elementsMethods.waitForElementToBeClickable(loginContinueButton);
        elementsMethods.clickOnElement(loginContinueButton);
        System.out.println("Continue button clicked.");

        elementsMethods.waitUntilElementIsPresent(nameField);
        elementsMethods.fillElement(nameField, data.getFullName());
        System.out.println("Full name typed successfully.");

        elementsMethods.waitUntilElementIsPresent(firstPassword);
        elementsMethods.fillElement(firstPassword, data.getPassword1());
        System.out.println("Password typed successfully.");

        elementsMethods.waitUntilElementIsPresent(secondPassword);
        elementsMethods.fillElement(secondPassword, data.getPassword2());
        System.out.println("Second password typed successfully.");

        elementsMethods.waitForElementToBeClickable(acceptTerms);
        elementsMethods.clickOnElement(acceptTerms);
        System.out.println("Accept terms checkbox clicked.");

        elementsMethods.waitForElementToBeClickable(subscribeToNews);
        elementsMethods.clickOnElement(subscribeToNews);
        System.out.println("Subscribe to news checkbox clicked.");

        elementsMethods.waitForElementToBeClickable(registrationContinueButton);
        elementsMethods.clickOnElement(registrationContinueButton);
        System.out.println("Continue button clicked.");

        elementsMethods.waitUntilElementIsPresent(phoneNumber);
        elementsMethods.fillElement(phoneNumber, data.getPhoneNumber());
        System.out.println("Phone number typed successfully.");

        elementsMethods.waitUntilElementIsPresent(trimiteSMSButton);
        elementsMethods.clickOnElement(trimiteSMSButton);
        System.out.println("'Trimite SMS' button clicked.");

        elementsMethods.waitUntilElementIsPresent(errorMessage);
        errorMessage.isDisplayed();
        System.out.println("Error message: " + errorMessage.getText());
    }
}