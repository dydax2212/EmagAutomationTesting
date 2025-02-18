package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class GoogleRegisterPage
{

    WebDriver driver;
    ElementsMethods elementsMethods;

    public GoogleRegisterPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "body > div.auth-box.text-center > div.auth-panel > div.auth-panel-body > div:nth-child(4) > form:nth-child(2) > button")
    WebElement registerWithGoogle;

    @FindBy(id = "identifierId")
    WebElement googleEmail;

    @FindBy(css = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
    WebElement gPassword;

    @FindBy(css = "#passwordNext > div > button > span")
    WebElement clickOnNext;

    public void clickOnRegisterWithGoogle()
    {
        elementsMethods.clickOnElement(registerWithGoogle);
    }
    public boolean isGoogleRegistrationButtonEnabled()
    {
        return registerWithGoogle.isEnabled();
    }

    public void insertGmail(String gmail)
    {
        googleEmail.sendKeys(gmail);
    }
    public boolean isEmailFieldDisplayed()
    {
        return googleEmail.isDisplayed();
    }

    public void insertGmailPassword(String gmailPassword)
    {
        gPassword.sendKeys(gmailPassword);
    }
    public boolean isPasswordNotEmpty() {
        return !Objects.requireNonNull(gPassword.getAttribute("Test123!")).isEmpty();
    }

    public void clickNext()
    {
        elementsMethods.clickOnElement(clickOnNext);
    }
    public boolean isNextButtonDisplayed()
    {
        return clickOnNext.isDisplayed();
    }

}
