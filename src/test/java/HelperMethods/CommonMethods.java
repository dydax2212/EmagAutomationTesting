package HelperMethods;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class CommonMethods {
    WebDriver driver;
    Actions actions;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
    }

    public void waitUntilElementIsPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
            Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
        } catch (Exception e) {
            System.out.println("Element is not visible or interactable: " + e.getMessage());
        }
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waited for " + seconds + " seconds.");
    }

    public void scrollToHalfPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
    }

    public void scrollToElement(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void scrollByPixels(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ");");
    }

    public void verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();

        ChainTestListener.log("Verify URL: " + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl, "The actual URL does not match the expected URL!");
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
