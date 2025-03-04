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

public class FavoriteTests extends Hooks {
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

        // Select first product on the page
        homePage.clickOnProduct();
        ChainTestListener.log("First product selected.");

        // Add product to favorites and verify confirmation
        LoggerUtility.infoTest("Adding product to Favorites.");
        favoritePage.clickOnAddToFavorite();
        productPage.getFavoriteConfirmationText(); // Verifică mesajul automat

        // Check favorite counter
        Assert.assertTrue(favoritePage.checkFavoriteCounter(1), "Error: Favorite counter is incorrect!");
        ChainTestListener.log("Favorite counter updated correctly.");

        // Check product in favorites dropdown
        favoritePage.checkProductInFavorite();

        // Add product to cart from favorites
        LoggerUtility.infoTest("Adding product to cart from Favorites.");
        favoritePage.addToCartFromDropdown();
        productPage.getCartConfirmationText(); // Verifică mesajul automat

        // Navigate to the Favorites page
        favoritePage.goToFavoritePage();

        //Add two more products to favorite from Favorite Page
        LoggerUtility.infoTest("Adding two more products to Favorites.");
        ChainTestListener.log("Adding two more products to Favorites...");

        favoritePage.addTwoMoreProductsToFav();

        Assert.assertTrue(favoritePage.checkFavoriteCounter(3), "Error: Favorite counter did not update correctly!");

        LoggerUtility.infoTest("Successfully added two more products to Favorites.");
        ChainTestListener.log("Favorite counter updated correctly.");

        // Remove a product from Favorite Page
        LoggerUtility.infoTest("Removing first product from Favorites Page.");
        ChainTestListener.log("Removing first product from Favorites Page...");
        favoritePage.removeFirstProductFromFavPage();

        // Verify favorite counter after removing from Favorites Page
        Assert.assertTrue(favoritePage.checkFavoriteCounter(2), "Error: Counter should be 2 after removing one product from Favorites Page.");

        // Check product in favorites dropdown
        favoritePage.checkProductInFavorite();

        // Remove a product from Favorite dropdown
        LoggerUtility.infoTest("Removing a product from Favorite dropdown.");
        ChainTestListener.log("Removing a product from Favorite dropdown...");
        favoritePage.removeFromDropdown();

        // Verify favorite counter is updated to 1
        Assert.assertTrue(favoritePage.checkFavoriteCounter(1), "Error: Counter should be 1 after removing one product from Favorites dropdown.");

        LoggerUtility.infoTest("Test finished successfully.");
    }
}
