package Pages;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
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

    @FindBy(xpath = "(//*[@class='card-v2-title-wrapper'])[1]")
    WebElement product1;

    @FindBy(xpath = "(//*[@class='product-new-price'])[1]")
    WebElement product1Price;

    @FindBy(xpath = "//*[@class='navbar-brand']")
    WebElement emagPage;

    @FindBy(css = "body > div.main-container-outer > footer > div.footer-copy.footer-inverse")
    WebElement footer;

    @FindBy(css = "#top_ribbon")
    WebElement header;

    @FindBy(xpath = "//*[@class='js-dismiss-login-notice-btn dismiss-btn btn btn-link py-0 px-0']")
    WebElement stickyBlackBanner;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
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

    public void clickOnAcceptCookies() {
        elementsMethods.waitForElementToBeClickable(acceptCookies);
        Assert.assertTrue(acceptCookies.isDisplayed(), "The 'Accept Cookies' button is not visible!");
        elementsMethods.clickOnElement(acceptCookies);
        ChainTestListener.log("Cookies accepted successfully.");
    }

    public void clickOnRejectCookies() {
        elementsMethods.waitForElementToBeClickable(rejectCookies);
        Assert.assertTrue(rejectCookies.isDisplayed(), "The 'Reject Cookies' button is not visible!");
        elementsMethods.clickOnElement(rejectCookies);
        ChainTestListener.log("Cookies rejected successfully.");
    }

    public void hoverOnPeriferice() {
        elementsMethods.waitUntilElementIsPresent(periferice);
        elementsMethods.hoverOnElement(periferice);

        elementsMethods.waitUntilElementIsPresent(placiVideoSection);
        Assert.assertTrue(placiVideoSection.isDisplayed(), "The 'Video Cards' section is not visible!");
        elementsMethods.hoverOnElement(placiVideoSection);
        ChainTestListener.log("Hover over 'Video Cards' was successful.");
    }

//    public void clickOnProduct() {
//        elementsMethods.waitForElementToBeClickable(product1);
//        Assert.assertTrue(product1.isDisplayed(), "The product is not visible!");
//        elementsMethods.clickOnElement(product1);
//        ChainTestListener.log("Click on the first product was successful.");
//    }

    public void clickOnProduct() {
        elementsMethods.waitForElementToBeClickable(product1);
        Assert.assertTrue(product1.isDisplayed(), "Error: The first product is not visible!");

        // Get product title
        String productTitle = product1.getText().trim();
        Assert.assertFalse(productTitle.isEmpty(), "Error: The first product title is empty!");

        // Get product price
        elementsMethods.waitUntilElementIsPresent(product1Price);
        String productPrice = product1Price.getText().trim();
        Assert.assertFalse(productPrice.isEmpty(), "Error: The first product price is empty!");

        // Log product details
        ChainTestListener.log("Product selected: " + productTitle);
        ChainTestListener.log("Product price: " + productPrice);
        LoggerUtility.infoTest("Selected product: " + productTitle + " | Price: " + productPrice);

        // Click on product to open details page
        elementsMethods.clickOnElement(product1);
        ChainTestListener.log("Clicked on the first product successfully.");
    }


    public void clickOnSection() {
        elementsMethods.waitForElementToBeClickable(placiVideoSection);
        Assert.assertTrue(placiVideoSection.isDisplayed(), "The 'Video Cards' section is not visible!");
        elementsMethods.clickOnElement(placiVideoSection);
        ChainTestListener.log("Click on 'Video Cards' was successful.");
    }

    public void clickOnEmag() {
        elementsMethods.waitForElementToBeClickable(emagPage);
        Assert.assertTrue(emagPage.isDisplayed(), "The eMAG logo is not visible!");
        elementsMethods.clickOnElement(emagPage);
        ChainTestListener.log("Click on the eMAG logo was successful.");
    }

    public void scrollToFooter() {
        elementsMethods.scrollToElement(footer);
        elementsMethods.waitForSeconds(2);
        Assert.assertTrue(footer.isDisplayed(), "The footer is not visible after scrolling!");
        ChainTestListener.log("Successfully scrolled to the footer.");
    }

    public void scrollToHeader() {
        elementsMethods.scrollToElement(header);
        elementsMethods.waitForSeconds(2);
        Assert.assertTrue(header.isDisplayed(), "The header is not visible after scrolling!");
        ChainTestListener.log("Successfully scrolled to the header.");
    }

    public void closeBlackBanner() {
        elementsMethods.waitForElementToBeClickable(stickyBlackBanner);
        Assert.assertTrue(stickyBlackBanner.isDisplayed(), "The black sticky banner is not visible!");
        elementsMethods.clickOnElement(stickyBlackBanner);
        ChainTestListener.log("The black sticky banner was closed successfully.");
    }
}
