package HelperMethods;

import Logger.LoggerUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementsMethods extends CommonMethods {
    WebDriver driver;
    Actions actions;

    public ElementsMethods(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    private String getElementInfo(WebElement element) {
        return element.toString().split("->")[1]; // Extracts locator information
    }

    public void clickOnElement(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
        Assert.assertTrue(element.isEnabled(), "Element is not clickable!");

        try {
            LoggerUtility.infoTest("Clicking on element: " + getElementInfo(element));
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void hoverOnElement(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
        actions.moveToElement(element).perform();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void fillElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
        Assert.assertTrue(element.isEnabled(), "Element is not interactable!");

        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));

        Assert.assertEquals(text, element.getAttribute("value"), "Text input failed!");
        LoggerUtility.infoTest("Filled element with text: " + text);
    }

    public void moveSlider(WebElement sliderHandle, int xOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(sliderHandle)
                .moveByOffset(xOffset, 0)
                .release()
                .perform();
    }

    public String getText(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");

        String text = element.getText();
        Assert.assertNotNull(text, "Element text is null!");
        Assert.assertFalse(text.isEmpty(), "Element text is empty!");

        LoggerUtility.infoTest("Element text is: " + text);
        ChainTestListener.log("Extracted text: " + text);
        return text;
    }
}
