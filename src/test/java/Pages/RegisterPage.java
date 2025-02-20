package Pages;

import HelperMethods.CommonMethods;
import HelperMethods.ElementsMethods;
import ObjectData.RegisterFormObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{
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

    @FindBy(id = "user_register_agree_terms")
    WebElement acceptTerms;

    @FindBy(id = "user_register_subscribe_newsletter")
    WebElement subscribeToNews;

    @FindBy(id = "user_register_continue")
    WebElement registrationContinueButton;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver,this);
    }

    public void fillRegistrationForm(RegisterFormObjectData data)
    {
        elementsMethods.clickOnElement(loginContinueButton);
        elementsMethods.fillElement(emailField, data.getEmail());
        elementsMethods.fillElement(nameField, data.getFullName());
        elementsMethods.fillElement(firstPassword, data.getPassword1());
        elementsMethods.fillElement(secondPassword, data.getPassword2());
        elementsMethods.clickOnElement(acceptTerms);
        elementsMethods.clickOnElement(subscribeToNews);
        elementsMethods.clickOnElement(registrationContinueButton);
    }


    // methods

//    public void insertEmail(String email)
//    {
//        emailField.sendKeys(email);
//    }
//    public boolean isEmailFieldDisplayed()
//    {
//        return emailField.isDisplayed();
//    }
//
//    public void clickLoginContinueButton()
//    {
//        elementsMethods.clickOnElement(loginContinueButton);
//    }
//    public boolean isLoginContinueButtonEnable()
//    {
//        return loginContinueButton.isEnabled();
//    }
//
//    public void insertFullName(String fullName)
//    {
//        nameField.sendKeys(fullName);
//    }
//    public boolean isNameFieldDisplayed()
//    {
//        return nameField.isDisplayed();
//    }
//
//    public void insertFirstPassword(String passwordOne)
//    {
//        firstPassword.sendKeys(passwordOne);
//    }
//    public boolean isPasswordNotEmpty() {
//        return !Objects.requireNonNull(firstPassword.getAttribute("Test123!")).isEmpty();
//    }
//
//    public void insertSecondPassword(String passwordTwo)
//    {
//        secondPassword.sendKeys(passwordTwo);
//    }
//    public boolean isConfirmPasswordNotEmpty() {
//        return !Objects.requireNonNull(secondPassword.getAttribute("Test123!")).isEmpty();
//    }
//
//    public void clickOnTerms()
//    {
//        elementsMethods.clickOnElement(acceptTerms);
//    }
//    public boolean isTermsCheckboxSelected() {
//        return acceptTerms.isSelected();
//    }
//
//    public void clickOnNews()
//    {
//        elementsMethods.clickOnElement(subscribeToNews);
//    }
//    public boolean isNewsCheckboxSelected() {
//        return subscribeToNews.isSelected();
//    }
//
//    public void clickOnContinue()
//    {
//        elementsMethods.clickOnElement(registrationContinueButton);
//    }
//    public boolean isContinueButtonDisplayed()
//    {
//        return registrationContinueButton.isEnabled();
//    }
}
