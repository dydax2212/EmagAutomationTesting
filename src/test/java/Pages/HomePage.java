package Pages;

import HelperMethods.ElementsMethods;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(xpath = "//*[@class='navbar-aux-content collapse navbar-collapse']")
    WebElement navBar;

    @FindBy(xpath = "(//*[@class='fs-12  visible-md visible-lg visible-xl'])[1]")
    WebElement homePageGeniusButton;

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

    public void locateNavBar() {
        elementsMethods.waitUntilElementIsPresent(navBar);
        ChainTestListener.log("Navbar has been located.");
    }

    public void clickOnGeniusButton() {
        elementsMethods.waitUntilElementIsPresent(homePageGeniusButton);
        elementsMethods.clickOnElement(homePageGeniusButton);
        ChainTestListener.log("Clicked on Genius button.");
        elementsMethods.waitForSeconds(5);
    }

    public void hoverContulMeu() {
        Assert.assertTrue(contulMeu.isDisplayed(), "'Contul Meu' nu este vizibil!");
        elementsMethods.hoverOnElement(contulMeu);
        ChainTestListener.log("Hover pe 'Contul Meu' efectuat cu succes.");
    }

    public void clickOnContNou() {
        Assert.assertTrue(contNou.isDisplayed(), "'Cont Nou' nu este vizibil!");
        Assert.assertTrue(contNou.isEnabled(), "'Cont Nou' nu este clicabil!");
        elementsMethods.clickOnElement(contNou);
        ChainTestListener.log("Click pe 'Cont Nou' efectuat cu succes.");
    }

    public void clickOnAcceptCookies() {
        elementsMethods.waitForElementToBeClickable(acceptCookies);
        Assert.assertTrue(acceptCookies.isDisplayed(), "Butonul 'Accept Cookies' nu este vizibil!");
        elementsMethods.clickOnElement(acceptCookies);
        ChainTestListener.log("Cookies acceptate cu succes.");
    }

    public void clickOnRejectCookies() {
        elementsMethods.waitForElementToBeClickable(rejectCookies);
        Assert.assertTrue(rejectCookies.isDisplayed(), "Butonul 'Reject Cookies' nu este vizibil!");
        elementsMethods.clickOnElement(rejectCookies);
        ChainTestListener.log("Cookies respinse cu succes.");
    }

    public void hoverOnPeriferice() {
        elementsMethods.waitUntilElementIsPresent(periferice);
        elementsMethods.hoverOnElement(periferice);

        elementsMethods.waitUntilElementIsPresent(placiVideoSection);
        Assert.assertTrue(placiVideoSection.isDisplayed(), "Secțiunea 'Plăci Video' nu este vizibilă!");
        elementsMethods.hoverOnElement(placiVideoSection);
        ChainTestListener.log("Hover pe 'Plăci Video' efectuat cu succes.");
    }

    public void clickOnProduct() {
        elementsMethods.waitForElementToBeClickable(product1);
        Assert.assertTrue(product1.isDisplayed(), "Produsul nu este vizibil!");
        elementsMethods.clickOnElement(product1);
        ChainTestListener.log("Click pe primul produs efectuat.");
    }

    public void clickOnSection() {
        elementsMethods.waitForElementToBeClickable(placiVideoSection);
        Assert.assertTrue(placiVideoSection.isDisplayed(), "Secțiunea 'Plăci Video' nu este vizibilă!");
        elementsMethods.clickOnElement(placiVideoSection);
        ChainTestListener.log("Click pe 'Plăci Video' efectuat cu succes.");
    }

    public void clickOnEmag() {
        elementsMethods.waitForElementToBeClickable(emagPage);
        Assert.assertTrue(emagPage.isDisplayed(), "Logo-ul eMAG nu este vizibil!");
        elementsMethods.clickOnElement(emagPage);
        ChainTestListener.log("Click pe logo-ul eMAG efectuat.");
    }

    public void scrollToFooter() {
        elementsMethods.scrollToElement(footer);
        elementsMethods.waitForSeconds(2);
        Assert.assertTrue(footer.isDisplayed(), "Footer-ul nu este vizibil după scroll!");
        ChainTestListener.log("Scroll la footer efectuat cu succes.");
    }

    public void scrollToHeader() {
        elementsMethods.scrollToElement(header);
        elementsMethods.waitForSeconds(2);
        Assert.assertTrue(header.isDisplayed(), "Header-ul nu este vizibil după scroll!");
        ChainTestListener.log("Scroll la header efectuat cu succes.");
    }

    public void closeBlackBanner() {
        elementsMethods.waitForElementToBeClickable(stickyBlackBanner);
        Assert.assertTrue(stickyBlackBanner.isDisplayed(), "Banner-ul negru nu este vizibil!");
        elementsMethods.clickOnElement(stickyBlackBanner);
        ChainTestListener.log("Banner-ul negru închis cu succes.");
    }

    public void clickOnLoginFromStickyBlackBanner() {
        elementsMethods.waitUntilElementIsPresent(loginFromBlackBanner);
        Assert.assertTrue(loginFromBlackBanner.isDisplayed(), "Butonul 'Login' din banner-ul negru nu este vizibil!");
        elementsMethods.clickOnElement(loginFromBlackBanner);
        ChainTestListener.log("Click pe 'Login' din banner-ul negru efectuat.");
    }
}
