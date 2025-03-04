package Pages;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FavoritePage {
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(xpath = "//*[@class='add-to-favorites btn btn-xl btn-default btn-icon btn-block gtm_t95ovv border-lg']")
    WebElement addToFavorite;

    @FindBy(xpath = "(//*[@class='visible-lg-inline visible-xl-inline'])[2]")
    WebElement favoriteButton;

    @FindBy(xpath = "//*[@class='jewel jewel-danger']")
    WebElement favoriteCounter;

    @FindBy(xpath = "//*[@class='nav-product-line_title']")
    WebElement checkProduct;

    @FindBy(xpath = "//*[@class='btn btn-link btn-xs btn-link-add-to-cart px-0 js-add-to-cart gtm_mg160119536']")
    WebElement dropdownAddToCart;

    @FindBy(xpath = "//*[@class='btn btn-xs nav-remove-favorite-product nav-product-line_remove gtm_mg160119537']")
    WebElement removeProductFromDropdown;

    @FindBy(xpath = "//a[@href='/favorites?ref=ua_favorites']")
    WebElement goToFavoritePage;

    @FindBy(xpath = "(//*[@class='em em-fav em-fav-bold'])[2]")
    WebElement addProduct2ToFav;

    @FindBy(xpath = "(//*[@class='em em-fav em-fav-bold'])[3]")
    WebElement addProduct3ToFav;

    @FindBy(xpath = "(//*[@class='gtm_9p2y1a d-none d-md-inline-block'])[1]")
    WebElement removeProductFromFavPage;


    public FavoritePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    //METODE

    public void clickOnAddToFavorite() {
        elementsMethods.waitForElementToBeClickable(addToFavorite);
        elementsMethods.clickOnElement(addToFavorite);

        ChainTestListener.log("Clicked on 'Add to Favorite'.");
        LoggerUtility.infoTest("Product added to favorites.");
    }

    public boolean checkFavoriteCounter(int expectedCount) {
        String expectedText = String.valueOf(expectedCount);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(favoriteCounter, expectedText));

        String actualText = elementsMethods.getText(favoriteCounter);
        boolean isMatching = actualText.equals(expectedText);

        LoggerUtility.infoTest("Favorite counter check: Expected = " + expectedText + ", Actual = " + actualText);
        ChainTestListener.log("Favorite counter: " + actualText + " (Expected: " + expectedText + ").");

        return isMatching;
    }

    public void checkProductInFavorite() {
        elementsMethods.waitUntilElementIsPresent(favoriteButton);
        elementsMethods.hoverOnElement(favoriteButton);
        elementsMethods.hoverOnElement(checkProduct);

        ChainTestListener.log("Hovered over 'Favorite' dropdown and product.");
        LoggerUtility.infoTest("Checked product inside favorites.");
    }

    public void addToCartFromDropdown() {
        elementsMethods.waitForElementToBeClickable(dropdownAddToCart);
        elementsMethods.clickOnElement(dropdownAddToCart);

        LoggerUtility.infoTest("Product added to cart from favorites dropdown.");
    }

    public void removeFromDropdown() {
        elementsMethods.waitUntilElementIsPresent(removeProductFromDropdown);
        elementsMethods.clickOnElement(removeProductFromDropdown);

        ChainTestListener.log("Clicked on 'Remove from Favorites'.");
        LoggerUtility.infoTest("Product removed from favorites.");
    }

    public void goToFavoritePage() {
        elementsMethods.waitUntilElementIsPresent(goToFavoritePage);
        elementsMethods.clickOnElement(goToFavoritePage);
        elementsMethods.waitForPageLoad();

        elementsMethods.verifyUrl("https://www.emag.ro/favorites?ref=ua_favorites");

        ChainTestListener.log("Navigated to 'Favorites' page.");
        LoggerUtility.infoTest("Opened Favorites page.");
    }

    public void addTwoMoreProductsToFav() {
        elementsMethods.waitForElementToBeClickable(addProduct2ToFav);
        elementsMethods.clickOnElement(addProduct2ToFav);
        ChainTestListener.log("Second product added to Favorites.");
        LoggerUtility.infoTest("Clicked on 'Add to Favorites' for second product.");

        elementsMethods.waitForElementToBeClickable(addProduct3ToFav);
        elementsMethods.clickOnElement(addProduct3ToFav);
        ChainTestListener.log("Third product added to Favorites.");
        LoggerUtility.infoTest("Clicked on 'Add to Favorites' for third product.");

        elementsMethods.waitForPageLoad();
    }

    public void removeFirstProductFromFavPage() {
        elementsMethods.waitForElementToBeClickable(removeProductFromFavPage);
        Assert.assertTrue(removeProductFromFavPage.isDisplayed(), "Error: Remove button is not visible!");

        elementsMethods.clickOnElement(removeProductFromFavPage);
        ChainTestListener.log("Clicked on 'Remove from Favorites' button on Favorites Page.");
        LoggerUtility.infoTest("Removed first product from Favorites Page.");

        elementsMethods.waitForPageLoad();
    }


}
