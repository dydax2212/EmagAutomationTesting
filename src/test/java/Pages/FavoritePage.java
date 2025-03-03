package Pages;

import HelperMethods.ElementsMethods;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
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

    @FindBy(css = "p.product-new-price")
    WebElement priceElement;

    @FindBy(xpath = "//*[@class='add-to-favorites btn btn-xl btn-default btn-icon btn-block gtm_t95ovv border-lg']")
    WebElement addToFavorite;

    @FindBy(xpath = "(//*[@class='visible-lg-inline visible-xl-inline'])[2]")
    WebElement favoriteButton;

    @FindBy(xpath = "//*[@class='jewel jewel-danger']")
    WebElement favoriteCounter;

    @FindBy(xpath = "//*[@class='btn btn-xs nav-remove-favorite-product nav-product-line_remove gtm_mg160119537']")
    WebElement removeProductFromDropdown;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm btn-block']")
    WebElement goToFavoritePage;


    public FavoritePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    //METODE

    public void selectRandomProduct() {
        Assert.assertFalse(products.isEmpty(), "Error: No product found!");

        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        WebElement selectedProduct = products.get(randomIndex);

        String productTitle = selectedProduct.getText();

        WebElement priceElement = selectedProduct.findElement(By.xpath("./ancestor::div[contains(@class, 'card-item')]//p[contains(@class, 'product-new-price')]"));
        String productPrice = priceElement.getText();

        ChainTestListener.log("Product selected: " + productTitle);
        ChainTestListener.log("Product price: " + productPrice);

        elementsMethods.scrollToElement(selectedProduct);
        elementsMethods.clickOnElement(selectedProduct);
    }

    public void clickOnAddToFavorite() {
        elementsMethods.waitForElementToBeClickable(addToFavorite);
        elementsMethods.clickOnElement(addToFavorite);
    }

    public boolean checkFavoriteCounter(int expectedCount) {
        String expectedText = String.valueOf(expectedCount);

        elementsMethods.waitForSeconds(3);

        String actualText = elementsMethods.getText(favoriteCounter);

        return actualText.equals(expectedText);
    }

    public void checkProductInFavorite() {
        elementsMethods.waitUntilElementIsPresent(favoriteButton);
        elementsMethods.hoverOnElement(favoriteButton);
    }


}
