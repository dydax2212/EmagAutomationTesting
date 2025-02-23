package Pages;

import HelperMethods.ElementsMethods;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class FavoritePage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(css = "a.card-v2-title")
    List<WebElement> products;

    @FindBy(css = "p.product-new-price")
    WebElement priceElement;



    public FavoritePage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver,this);
    }

    //METODE

    public void selectRandomProduct()
    {
        Assert.assertFalse(products.isEmpty(), "Error: No product found!");

        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        WebElement selectedProduct = products.get(randomIndex);

        String priceText = priceElement.isDisplayed() ? priceElement.getText() : "No price found.";

        ChainTestListener.log("Product selected: " + selectedProduct.getText());
        ChainTestListener.log("Product price: " + priceText);

        elementsMethods.clickOnElement(selectedProduct);

        Assert.assertTrue(driver.getCurrentUrl().contains("placa"), "Product didn't open correctly!");
    }



}
