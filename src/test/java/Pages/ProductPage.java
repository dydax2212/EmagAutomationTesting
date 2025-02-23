package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class ProductPage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    //ELEMENTE

    @FindBy(css = "a.card-v2-title")
    List<WebElement> products;

    @FindBy(xpath = "(//*[@class='page-section-title'])[1]")
    WebElement descriptionSection;

    @FindBy(tagName = "//*[text()='Vezi mai mult ']")
    WebElement expandDescriptionButton;

    @FindBy(xpath = "(//*[@class='page-section-title'])[2]")
    WebElement specsSection;

    @FindBy(xpath = "//*[@class='ph-widget ph-collapse-one btn btn-outline-primary w-sm-100']")
    WebElement expandSpecsButton;

    @FindBy(xpath = "//*[@class='gtm_t95ovv']")
    WebElement favoriteButton;

    @FindBy(xpath = "//*[text()='Produsul a fost adaugat la Favorite']")
    WebElement favoriteConfirmation;

    @FindBy(xpath = "//*[@class='btn btn-xl btn-emag btn-block main-button gtm_680klw yeahIWantThisProduct']")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[text()='Produsul a fost adaugat in cos']")
    WebElement cartConfirmation;

    @FindBy(xpath = "//*[@class='em em-close d-none d-sm-block gtm_6046yfqs']")
    WebElement closeButton;

    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    //METODE

    public void selectRandomProduct()
    {
        Assert.assertFalse(products.isEmpty(), "Eroare: Nu s-au găsit produse!");

        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        WebElement selectedProduct = products.get(randomIndex);

        System.out.println("Produs selectat: " + selectedProduct.getText());
        elementsMethods.clickOnElement(selectedProduct);

        Assert.assertTrue(driver.getCurrentUrl().contains("placa"), "Produsul nu s-a deschis corect!");
    }

    //Scroll la descriere
    public void scrollToDescription()
    {
        elementsMethods.scrollToElement(descriptionSection);
        Assert.assertTrue(elementsMethods.isDisplayed(descriptionSection), "Secțiunea de descriere nu este vizibilă!");
    }

    //Expandare descriere
    public void expandDescription()
    {
        if (elementsMethods.isElementPresent(expandDescriptionButton))
        {
            elementsMethods.scrollToElement(expandDescriptionButton);
            elementsMethods.waitForElementToBeClickable(expandDescriptionButton);
            elementsMethods.clickOnElement(expandDescriptionButton);
        } else
        {
            System.out.println("Nu există buton de expandare pentru descriere pe această pagină.");
        }
    }

    //Scroll la specificații
    public void scrollToSpecifications()
    {
        elementsMethods.scrollToElement(specsSection);
        elementsMethods.waitUntilElementIsPresent(specsSection);
    }

    //Expandare specificații
    public void expandSpecifications() {
        if (elementsMethods.isElementPresent(expandSpecsButton))
        {
            elementsMethods.scrollToElement(expandSpecsButton);
            elementsMethods.waitForElementToBeClickable(expandSpecsButton);
            elementsMethods.clickOnElement(expandSpecsButton);
        } else
        {
            System.out.println("Nu există buton de expandare pentru specificații pe această pagină.");
        }
    }

    //Adăugare la favorite
    public void addToFavorites()
    {
        elementsMethods.waitForElementToBeClickable(favoriteButton);
        elementsMethods.clickOnElement(favoriteButton);

        elementsMethods.waitForSeconds(2);
        System.out.println(favoriteConfirmation.getText());
    }

    //Adăugare în coș
    public void addToCart()
    {
        elementsMethods.waitForElementToBeClickable(addToCartButton);
        elementsMethods.clickOnElement(addToCartButton);

        elementsMethods.waitForSeconds(2);
        System.out.println(cartConfirmation.getText());

        elementsMethods.clickOnElement(closeButton);
        elementsMethods.waitForSeconds(2);
    }
}
