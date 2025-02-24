package Pages;

import HelperMethods.ElementsMethods;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(css = "body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo")
    WebElement acceptCookies;

    @FindBy(css = "body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-refuse.gtm_bxxzbgwexm")
    WebElement rejectCookies;

    @FindBy(css = "body > div.main-container-outer > div.megamenu-container.megamenu-always-open > div > div.megamenu-details > div:nth-child(2) > div.megamenu-details-department-items > ul > li:nth-child(1) > div.megamenu-group.collapse.megamenu-group-4041 > a:nth-child(1)")
    WebElement placiVideoSection;

    @FindBy(xpath = "//*[@class='em em-mouse megamenu-list-department__icon']")
    WebElement periferice;

    @FindBy(xpath = "//*[@class='card-alt no-decoration js-product-url']")
    WebElement product1;

    @FindBy(xpath = "//*[@class='navbar-brand']")
    WebElement emagPage;

    @FindBy(css = "body > div.main-container-outer > footer > div.footer-copy.footer-inverse")
    WebElement footer;

    @FindBy(css = "#top_ribbon")
    WebElement header;

    @FindBy(xpath = "//*[@class='js-dismiss-login-notice-btn dismiss-btn btn btn-link py-0 px-0']")
    WebElement stickyBlackBanner;

    @FindBy(css = "body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.login-view.login-view-ro.show > div > div > a")
    WebElement loginFromBlackBanner;

    @FindBy(xpath = "//*[text()='Contul meu ']")
    WebElement contulMeu;

    @FindBy(xpath = "//*[@class='btn btn-link btn-sm']")
    WebElement contNou;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver,this);
    }

    // METODE

    public void hoverContulMeu()
    {
        elementsMethods.hoverOnElement(contulMeu);
        ChainTestListener.log("Hover on Contul Meu.");
    }

    public void clickOnContNou()
    {
        elementsMethods.clickOnElement(contNou);
        ChainTestListener.log("Click on Cont nou.");
    }

    public void clickOnAcceptCookies()
    {
        elementsMethods.waitForElementToBeClickable(acceptCookies);
        elementsMethods.clickOnElement(acceptCookies);
        ChainTestListener.log("Cookies accepted.");
    }

    public void clickOnRejectCookies()
    {
        elementsMethods.waitForElementToBeClickable(rejectCookies);
        elementsMethods.clickOnElement(rejectCookies);
        ChainTestListener.log("Cookies rejected.");
    }

    public void hoverOnPeriferice()
    {
        elementsMethods.waitForElementToBeClickable(periferice);
        elementsMethods.hoverOnElement(periferice);
        ChainTestListener.log("Hover on Pc, Periferice & Software section.");
    }

    public void clickOnProduct()
    {
        elementsMethods.waitForElementToBeClickable(product1);
        elementsMethods.clickOnElement(product1);
        ChainTestListener.log("First product of the page clicked.");
    }

    public void clickOnSection()
    {
        elementsMethods.waitForElementToBeClickable(placiVideoSection);
        elementsMethods.clickOnElement(placiVideoSection);
        ChainTestListener.log("Click on placi video section.");
    }

    public void clickOnEmag()
    {
        elementsMethods.waitForElementToBeClickable(emagPage);
        elementsMethods.clickOnElement(emagPage);
        ChainTestListener.log("Click on eMAG icon.");
    }

    public void scrollToFooter()
    {
        elementsMethods.scrollToElement(footer);
        elementsMethods.waitForSeconds(2);
        ChainTestListener.log("Successfully scrolled to footer.");
    }
    public void scrollToHeader()
    {
        elementsMethods.scrollToElement(header);
        elementsMethods.waitForSeconds(2);
        ChainTestListener.log("Successfully scrolled to header.");
    }

    public void closeBlackBanner()
    {
        elementsMethods.waitForElementToBeClickable(stickyBlackBanner);
        elementsMethods.clickOnElement(stickyBlackBanner);
        ChainTestListener.log("Login sticky black banner closed.");
    }

    public void clickOnLoginFromStickyBlackBanner()
    {
        elementsMethods.waitUntilElementIsPresent(loginFromBlackBanner);
        elementsMethods.clickOnElement(loginFromBlackBanner);
        ChainTestListener.log("Successfully clicked on login from sticky black banner.");
    }
}
