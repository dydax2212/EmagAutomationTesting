package Pages;

import HelperMethods.ElementsMethods;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeniusPage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(xpath = "//*[@class='navbar-aux-content collapse navbar-collapse']")
    WebElement navBar;

    @FindBy(xpath = "//*[text()='Genius']")
    WebElement homePageGeniusButton;

    @FindBy(xpath = "//*[@class='_input_1bhmh_1']")
    WebElement writeLocalitateaField;

    @FindBy(xpath = "//*[@class='_options_1bhmh_58']")
    WebElement localitateDropdownList;

    @FindBy(id = "headlessui-combobox-option-125")
    WebElement clickOnResult;

    @FindBy(xpath = "//*[@class='_availability_1b9w7_47']")
    WebElement availabilityMessage;

    @FindBy(xpath = "(//*[@class='_tab_18qh2_4'])[1]")
    WebElement emagDetails;

    @FindBy(xpath = "(//*[@class='_tab_18qh2_4'])[2]")
    WebElement tazzDetails;

    @FindBy(xpath = "(//*[@class='_tab_18qh2_4'])[3]")
    WebElement fashionDaysDetails;

    @FindBy(xpath = "(//*[@class='_tab_18qh2_4'])[4]")
    WebElement freshfulDetails;

    @FindBy(xpath = "//*[@class='_subscribeButton_1b9w7_92']")
    WebElement try3MonthsButton;

    public GeniusPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver,this);
    }

    // METODE

    public void locateNavBar()
    {
        elementsMethods.waitUntilElementIsPresent(navBar);
        ChainTestListener.log("Navbar has been located.");
    }

    public void clickOnGeniusButton()
    {
        elementsMethods.clickOnElement(homePageGeniusButton);
        ChainTestListener.log("Clicked on Genius button.");
    }

    public void writeInLocalitateField(String localitate)
    {
        elementsMethods.waitUntilElementIsPresent(writeLocalitateaField);
        elementsMethods.clickOnElement(writeLocalitateaField);

        elementsMethods.sendKeys(writeLocalitateaField, localitate);

        elementsMethods.waitUntilElementIsPresent(clickOnResult);
        ChainTestListener.log("Typed: " + localitate);
        elementsMethods.clickOnElement(clickOnResult);
    }

    public void clickOnLocalitateDropdownButton()
    {
        elementsMethods.clickOnElement(localitateDropdownList);
        ChainTestListener.log("Selected locality from dropdown.");
    }

    public void printAvailabilityMessage()
    {
        String message = elementsMethods.getText(availabilityMessage);
        ChainTestListener.log("Availability message: " + message);
    }

    public void clickOnEmagDetails()
    {
        elementsMethods.clickOnElement(emagDetails);
        elementsMethods.scrollByPixels(100);
        ChainTestListener.log("Accessed eMAG tab.");
    }

    public void clickOnTazzDetails()
    {
        elementsMethods.clickOnElement(tazzDetails);
        ChainTestListener.log("Accessed Tazz tab.");
    }

    public void clickOnFashionDaysDetails()
    {
        elementsMethods.clickOnElement(fashionDaysDetails);
        ChainTestListener.log("Accessed Fashion Days tab.");
    }

    public void clickOnFreshfulDetails()
    {
        elementsMethods.clickOnElement(freshfulDetails);
        ChainTestListener.log("Accessed Freshful tab.");
    }

    public void clickOnTryFor3Months()
    {
        elementsMethods.clickOnElement(try3MonthsButton);
        ChainTestListener.log("Clicked on 'Incearca gratuit 3 luni' button.");
    }

}
