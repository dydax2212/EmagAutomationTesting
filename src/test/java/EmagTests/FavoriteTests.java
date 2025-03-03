package EmagTests;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import Pages.FavoritePage;
import Pages.HomePage;
import Pages.ProductPage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoriteTests  extends Hooks
{
    HomePage homePage;
    FavoritePage favoritePage;
    ProductPage productPage;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {
        homePage = new HomePage(getDriver());
        favoritePage = new FavoritePage(getDriver());
        productPage = new ProductPage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());

        LoggerUtility.infoTest("Test started: Navigating on eMAG website");
        ChainTestListener.log("Chrome opened");

        // Accept cookies
        homePage.clickOnAcceptCookies();

        // Close sticky black banner
        homePage.closeBlackBanner();

        // Select a random product
        favoritePage.selectRandomProduct();
        ChainTestListener.log("Random product selected.");

        // Add product to favorites and verify confirmation
        favoritePage.clickOnAddToFavorite();
        Assert.assertEquals(productPage.getFavoriteConfirmationText(), "Produsul a fost adaugat la Favorite", "Error: Mesajul de confirmare pentru favorite nu este corect!");
        ChainTestListener.log("Message: " + productPage.getFavoriteConfirmationText());

        // Check favorite counter
        Assert.assertTrue(favoritePage.checkFavoriteCounter(1), "Error: Favorite counter is incorrect!");
        ChainTestListener.log("Favorite counter updated correctly.");

        // Check product in favorites dropdown
        favoritePage.checkProductInFavorite();

        // Add product to cart from favorites
        favoritePage.addToCartFromDropdown();
        Assert.assertEquals(productPage.getCartConfirmationText(), "Produsul a fost adaugat in cos", "Error: Mesajul de confirmare pentru coș nu este corect!");
        ChainTestListener.log("Message: " + productPage.getCartConfirmationText());
        ChainTestListener.log("Added product to cart from Favorites.");

        // Remove product from Favorites
        favoritePage.removeFromDropdown();

        // Navigate to the Favorites page
        favoritePage.goToFavoritePage();

        // Return to the Home page
        favoritePage.goBackToHomePage();

        LoggerUtility.infoTest("Test finished successfully.");
    }
}
