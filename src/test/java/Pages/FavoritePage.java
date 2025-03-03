package Pages;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class FavoritePage {
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(css = "a.card-v2-title")
    List<WebElement> products;

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

    @FindBy(xpath = "//*[@class='visible-lg-inline visible-xl-inline']")
    WebElement goToFavoritePage;

    @FindBy(xpath = "//*[@class='d-inline-block']")
    WebElement goToHomaPage;


    public FavoritePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    //METODE

    public void selectRandomProduct() {
        Assert.assertFalse(products.isEmpty(), "Error: No product found!");

        int maxProducts = Math.min(products.size(), 7); // Selectează din primele 7 produse
        Random random = new Random();

        WebElement selectedProduct;
        String productTitle;
        String productPrice = "";

        do {
            selectedProduct = products.get(random.nextInt(maxProducts));
            productTitle = selectedProduct.getText();

            Assert.assertFalse(productTitle.isEmpty(), "Error: Selected product has no title!");

            List<WebElement> priceElements = selectedProduct.findElements(By.xpath("./ancestor::div[contains(@class, 'card-item')]//p[contains(@class, 'product-new-price')]"));
            if (!priceElements.isEmpty()) {
                productPrice = priceElements.get(0).getText().trim();
            }
        } while (productPrice.isEmpty()); // Dacă nu are preț, alege alt produs

        Assert.assertFalse(productPrice.isEmpty(), "Error: Selected product has no price!");

        ChainTestListener.log("Product selected: " + productTitle);
        ChainTestListener.log("Product price: " + productPrice);

        LoggerUtility.infoTest("Selected product: " + productTitle + " | Price: " + productPrice);

        elementsMethods.scrollToElement(selectedProduct);
        elementsMethods.clickOnElement(selectedProduct);

        elementsMethods.waitForPageLoad();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.emag.ro/", "Error: Product page did not load!");
    }

    public void clickOnAddToFavorite() {
        elementsMethods.waitForElementToBeClickable(addToFavorite);
        elementsMethods.clickOnElement(addToFavorite);
    }

    public boolean checkFavoriteCounter(int expectedCount) {
        String expectedText = String.valueOf(expectedCount);

        elementsMethods.waitForSeconds(2);

        String actualText = elementsMethods.getText(favoriteCounter);

        return actualText.equals(expectedText);
    }

    public void checkProductInFavorite() {
        elementsMethods.waitUntilElementIsPresent(favoriteButton);
        elementsMethods.hoverOnElement(favoriteButton);

        elementsMethods.hoverOnElement(checkProduct);
    }

    public void addToCartFromDropdown()
    {
        elementsMethods.waitForElementToBeClickable(dropdownAddToCart);
        elementsMethods.clickOnElement(dropdownAddToCart);
    }

    public void removeFromDropdown()
    {
        elementsMethods.waitUntilElementIsPresent(removeProductFromDropdown);
        elementsMethods.clickOnElement(removeProductFromDropdown);
    }

    public void goToFavoritePage()
    {
        elementsMethods.clickOnElement(goToFavoritePage);

    }

    public void goBackToHomePage()
    {
        elementsMethods.waitUntilElementIsPresent(goToHomaPage);
        elementsMethods.clickOnElement(goToHomaPage);
        elementsMethods.waitForPageLoad();
    }



}
